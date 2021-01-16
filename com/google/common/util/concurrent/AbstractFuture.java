package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import sun.misc.Unsafe;

@GwtCompatible(emulated = true)
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
  static {
    try {
      UnsafeAtomicHelper unsafeAtomicHelper = new UnsafeAtomicHelper();
      this();
    } catch (Throwable throwable) {
      try {
        SafeAtomicHelper safeAtomicHelper = new SafeAtomicHelper();
        this(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
      } catch (Throwable throwable1) {
        log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", throwable);
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable1);
        synchronizedHelper = new SynchronizedHelper();
      } 
    } 
    ATOMIC_HELPER = synchronizedHelper;
    NULL = new Object();
  }
  
  private static CancellationException cancellationExceptionWithCause(@Nullable String paramString, @Nullable Throwable paramThrowable) {
    CancellationException cancellationException = new CancellationException(paramString);
    cancellationException.initCause(paramThrowable);
    return cancellationException;
  }
  
  private Listener clearListeners(Listener paramListener) {
    while (true) {
      Listener listener = this.listeners;
      if (ATOMIC_HELPER.casListeners(this, listener, Listener.TOMBSTONE)) {
        Listener listener1 = paramListener;
        for (paramListener = listener; paramListener != null; paramListener = listener) {
          listener = paramListener.next;
          paramListener.next = listener1;
          listener1 = paramListener;
        } 
        return listener1;
      } 
    } 
  }
  
  private static void complete(AbstractFuture<?> paramAbstractFuture) {
    Listener listener = null;
    label18: while (true) {
      paramAbstractFuture.releaseWaiters();
      paramAbstractFuture.afterDone();
      listener = paramAbstractFuture.clearListeners(listener);
      while (listener != null) {
        AbstractFuture<?> abstractFuture1;
        Listener listener2;
        AbstractFuture<?> abstractFuture3;
        Listener listener1 = listener.next;
        Runnable runnable = listener.task;
        if (runnable instanceof SetFuture) {
          SetFuture setFuture = (SetFuture)runnable;
          abstractFuture3 = setFuture.owner;
          if (abstractFuture3.value == setFuture) {
            Object object = getFutureValue(setFuture.future);
            if (ATOMIC_HELPER.casValue(abstractFuture3, setFuture, object)) {
              listener2 = listener1;
              abstractFuture1 = abstractFuture3;
              continue label18;
            } 
          } 
        } else {
          executeListener((Runnable)abstractFuture3, listener2.executor);
        } 
        AbstractFuture<?> abstractFuture2 = abstractFuture1;
      } 
      break;
    } 
  }
  
  private static void executeListener(Runnable paramRunnable, Executor paramExecutor) {
    try {
      paramExecutor.execute(paramRunnable);
    } catch (RuntimeException runtimeException) {
      Logger logger = log;
      Level level = Level.SEVERE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RuntimeException while executing runnable ");
      stringBuilder.append(paramRunnable);
      stringBuilder.append(" with executor ");
      stringBuilder.append(paramExecutor);
      logger.log(level, stringBuilder.toString(), runtimeException);
    } 
  }
  
  private V getDoneValue(Object paramObject) throws ExecutionException {
    if (!(paramObject instanceof Cancellation)) {
      if (!(paramObject instanceof Failure))
        return (V)((paramObject == NULL) ? null : paramObject); 
      throw new ExecutionException(((Failure)paramObject).exception);
    } 
    throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)paramObject).cause);
  }
  
  private static Object getFutureValue(ListenableFuture<?> paramListenableFuture) {
    Object object;
    if (paramListenableFuture instanceof TrustedFuture)
      return ((AbstractFuture)paramListenableFuture).value; 
    try {
      ListenableFuture listenableFuture = (ListenableFuture)Futures.getDone((Future)paramListenableFuture);
      paramListenableFuture = listenableFuture;
      if (listenableFuture == null)
        object = NULL; 
    } catch (ExecutionException executionException) {
      object = new Failure(executionException.getCause());
    } catch (CancellationException cancellationException) {
      object = new Cancellation(false, cancellationException);
    } catch (Throwable throwable) {
      object = new Failure(throwable);
    } 
    return object;
  }
  
  private void releaseWaiters() {
    Waiter waiter;
    do {
      waiter = this.waiters;
    } while (!ATOMIC_HELPER.casWaiters(this, waiter, Waiter.TOMBSTONE));
    while (waiter != null) {
      waiter.unpark();
      waiter = waiter.next;
    } 
  }
  
  private void removeWaiter(Waiter paramWaiter) {
    paramWaiter.thread = null;
    label24: while (true) {
      paramWaiter = this.waiters;
      if (paramWaiter == Waiter.TOMBSTONE)
        return; 
      for (Object object = null; paramWaiter != null; object = object1) {
        Object object1;
        Waiter waiter = paramWaiter.next;
        if (paramWaiter.thread != null) {
          object1 = paramWaiter;
        } else if (object != null) {
          ((Waiter)object).next = waiter;
          object1 = object;
          if (((Waiter)object).thread == null)
            continue label24; 
        } else {
          object1 = object;
          if (!ATOMIC_HELPER.casWaiters(this, paramWaiter, waiter))
            continue label24; 
        } 
        paramWaiter = waiter;
      } 
      break;
    } 
  }
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor) {
    Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
    Preconditions.checkNotNull(paramExecutor, "Executor was null.");
    Listener listener = this.listeners;
    if (listener != Listener.TOMBSTONE) {
      Listener listener2;
      Listener listener1 = new Listener(paramRunnable, paramExecutor);
      do {
        listener1.next = listener;
        if (ATOMIC_HELPER.casListeners(this, listener, listener1))
          return; 
        listener2 = this.listeners;
        listener = listener2;
      } while (listener2 != Listener.TOMBSTONE);
    } 
    executeListener(paramRunnable, paramExecutor);
  }
  
  @Beta
  protected void afterDone() {}
  
  @CanIgnoreReturnValue
  public boolean cancel(boolean paramBoolean) {
    boolean bool;
    boolean bool2;
    Object object = this.value;
    boolean bool1 = true;
    if (object == null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool | object instanceof SetFuture) {
      Throwable throwable;
      Object object2;
      if (GENERATE_CANCELLATION_CAUSES) {
        throwable = new CancellationException("Future.cancel() was called.");
      } else {
        throwable = null;
      } 
      Cancellation cancellation = new Cancellation(paramBoolean, throwable);
      bool2 = false;
      Object object1 = object;
      object = this;
      do {
        while (ATOMIC_HELPER.casValue((AbstractFuture<?>)object, object1, cancellation)) {
          if (paramBoolean)
            object.interruptTask(); 
          complete((AbstractFuture<?>)object);
          bool2 = bool1;
          if (object1 instanceof SetFuture) {
            object1 = ((SetFuture)object1).future;
            if (object1 instanceof TrustedFuture) {
              object = object1;
              object1 = ((AbstractFuture)object).value;
              if (object1 == null) {
                bool = true;
              } else {
                bool = false;
              } 
              bool2 = bool1;
              if (bool | object1 instanceof SetFuture) {
                bool2 = true;
                continue;
              } 
              // Byte code: goto -> 214
            } 
            object1.cancel(paramBoolean);
            bool2 = bool1;
            break;
          } 
          // Byte code: goto -> 214
        } 
        object2 = ((AbstractFuture)object).value;
        object1 = object2;
      } while (object2 instanceof SetFuture);
    } else {
      bool2 = false;
    } 
    return bool2;
  }
  
  @CanIgnoreReturnValue
  public V get() throws InterruptedException, ExecutionException {
    if (!Thread.interrupted()) {
      boolean bool1;
      boolean bool2;
      Object object = this.value;
      if (object != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (!(object instanceof SetFuture)) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if ((bool1 & bool2) != 0)
        return getDoneValue(object); 
      object = this.waiters;
      if (object != Waiter.TOMBSTONE) {
        Waiter waiter2;
        Waiter waiter1 = new Waiter();
        do {
          waiter1.setNext((Waiter)object);
          if (ATOMIC_HELPER.casWaiters(this, (Waiter)object, waiter1))
            while (true) {
              LockSupport.park(this);
              if (!Thread.interrupted()) {
                object = this.value;
                if (object != null) {
                  bool1 = true;
                } else {
                  bool1 = false;
                } 
                if (!(object instanceof SetFuture)) {
                  bool2 = true;
                } else {
                  bool2 = false;
                } 
                if ((bool1 & bool2) != 0)
                  return getDoneValue(object); 
                continue;
              } 
              removeWaiter(waiter1);
              throw new InterruptedException();
            }  
          waiter2 = this.waiters;
          object = waiter2;
        } while (waiter2 != Waiter.TOMBSTONE);
      } 
      return getDoneValue(this.value);
    } 
    throw new InterruptedException();
  }
  
  @CanIgnoreReturnValue
  public V get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, TimeoutException, ExecutionException {
    long l = paramTimeUnit.toNanos(paramLong);
    if (!Thread.interrupted()) {
      boolean bool1;
      boolean bool2;
      long l1;
      Object object = this.value;
      if (object != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (!(object instanceof SetFuture)) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if ((bool1 & bool2) != 0)
        return getDoneValue(object); 
      if (l > 0L) {
        l1 = System.nanoTime() + l;
      } else {
        l1 = 0L;
      } 
      paramLong = l;
      if (l >= 1000L) {
        object = this.waiters;
        if (object != Waiter.TOMBSTONE) {
          Waiter waiter = new Waiter();
          label66: while (true) {
            waiter.setNext((Waiter)object);
            if (ATOMIC_HELPER.casWaiters(this, (Waiter)object, waiter))
              while (true) {
                LockSupport.parkNanos(this, l);
                if (!Thread.interrupted()) {
                  object = this.value;
                  if (object != null) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  } 
                  if (!(object instanceof SetFuture)) {
                    bool2 = true;
                  } else {
                    bool2 = false;
                  } 
                  if ((bool1 & bool2) != 0)
                    return getDoneValue(object); 
                  paramLong = l1 - System.nanoTime();
                  l = paramLong;
                  if (paramLong < 1000L) {
                    removeWaiter(waiter);
                    break;
                  } 
                  continue;
                } 
                removeWaiter(waiter);
                throw new InterruptedException();
              }  
            Waiter waiter1 = this.waiters;
            object = waiter1;
            if (waiter1 == Waiter.TOMBSTONE)
              break label66; 
          } 
        } else {
          return getDoneValue(this.value);
        } 
      } 
      while (paramLong > 0L) {
        object = this.value;
        if (object != null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (!(object instanceof SetFuture)) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if ((bool1 & bool2) != 0)
          return getDoneValue(object); 
        if (!Thread.interrupted()) {
          paramLong = l1 - System.nanoTime();
          continue;
        } 
        throw new InterruptedException();
      } 
      throw new TimeoutException();
    } 
    throw new InterruptedException();
  }
  
  protected void interruptTask() {}
  
  public boolean isCancelled() {
    return this.value instanceof Cancellation;
  }
  
  public boolean isDone() {
    boolean bool2;
    Object object = this.value;
    boolean bool1 = true;
    if (object != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (object instanceof SetFuture)
      bool1 = false; 
    return bool2 & bool1;
  }
  
  final void maybePropagateCancellation(@Nullable Future<?> paramFuture) {
    boolean bool;
    if (paramFuture != null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool & isCancelled())
      paramFuture.cancel(wasInterrupted()); 
  }
  
  @CanIgnoreReturnValue
  protected boolean set(@Nullable V paramV) {
    V v = paramV;
    if (paramV == null)
      v = (V)NULL; 
    if (ATOMIC_HELPER.casValue(this, null, v)) {
      complete(this);
      return true;
    } 
    return false;
  }
  
  @CanIgnoreReturnValue
  protected boolean setException(Throwable paramThrowable) {
    Failure failure = new Failure((Throwable)Preconditions.checkNotNull(paramThrowable));
    if (ATOMIC_HELPER.casValue(this, null, failure)) {
      complete(this);
      return true;
    } 
    return false;
  }
  
  @Beta
  @CanIgnoreReturnValue
  protected boolean setFuture(ListenableFuture<? extends V> paramListenableFuture) {
    Object object1;
    Preconditions.checkNotNull(paramListenableFuture);
    Object object2 = this.value;
    Object object3 = object2;
    if (object2 == null) {
      if (paramListenableFuture.isDone()) {
        object1 = getFutureValue(paramListenableFuture);
        if (ATOMIC_HELPER.casValue(this, null, object1)) {
          complete(this);
          return true;
        } 
        return false;
      } 
      object3 = new SetFuture(this, (ListenableFuture<?>)object1);
      if (ATOMIC_HELPER.casValue(this, null, object3)) {
        try {
          object1.addListener((Runnable)object3, MoreExecutors.directExecutor());
        } catch (Throwable throwable) {
          try {
            object1 = new Failure();
            super(throwable);
          } catch (Throwable throwable1) {
            object1 = Failure.FALLBACK_INSTANCE;
          } 
          ATOMIC_HELPER.casValue(this, object3, object1);
        } 
        return true;
      } 
      object3 = this.value;
    } 
    if (object3 instanceof Cancellation)
      object1.cancel(((Cancellation)object3).wasInterrupted); 
    return false;
  }
  
  final Throwable trustedGetException() {
    return ((Failure)this.value).exception;
  }
  
  protected final boolean wasInterrupted() {
    boolean bool;
    Object object = this.value;
    if (object instanceof Cancellation && ((Cancellation)object).wasInterrupted) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static {
    SynchronizedHelper synchronizedHelper;
  }
  
  private static final AtomicHelper ATOMIC_HELPER;
  
  private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
  
  private static final Object NULL;
  
  private static final long SPIN_THRESHOLD_NANOS = 1000L;
  
  private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
  
  private volatile Listener listeners;
  
  private volatile Object value;
  
  private volatile Waiter waiters;
  
  private static abstract class AtomicHelper {
    private AtomicHelper() {}
    
    abstract boolean casListeners(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2);
    
    abstract boolean casValue(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2);
    
    abstract boolean casWaiters(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2);
    
    abstract void putNext(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2);
    
    abstract void putThread(AbstractFuture.Waiter param1Waiter, Thread param1Thread);
  }
  
  private static final class Cancellation {
    @Nullable
    final Throwable cause;
    
    final boolean wasInterrupted;
    
    Cancellation(boolean param1Boolean, @Nullable Throwable param1Throwable) {
      this.wasInterrupted = param1Boolean;
      this.cause = param1Throwable;
    }
  }
  
  private static final class Failure {
    static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
          public Throwable fillInStackTrace() {
            /* monitor enter ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
            /* monitor exit ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
            return this;
          }
        });
    
    final Throwable exception;
    
    Failure(Throwable param1Throwable) {
      this.exception = (Throwable)Preconditions.checkNotNull(param1Throwable);
    }
  }
  
  static final class null extends Throwable {
    null(String param1String) {
      super(param1String);
    }
    
    public Throwable fillInStackTrace() {
      /* monitor enter ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
      /* monitor exit ThisExpression{InnerObjectType{InnerObjectType{ObjectType{com/google/common/util/concurrent/AbstractFuture}.Lcom/google/common/util/concurrent/AbstractFuture$Failure;}.Lcom/google/common/util/concurrent/AbstractFuture$Failure$1;}} */
      return this;
    }
  }
  
  private static final class Listener {
    static final Listener TOMBSTONE = new Listener(null, null);
    
    final Executor executor;
    
    @Nullable
    Listener next;
    
    final Runnable task;
    
    Listener(Runnable param1Runnable, Executor param1Executor) {
      this.task = param1Runnable;
      this.executor = param1Executor;
    }
  }
  
  private static final class SafeAtomicHelper extends AtomicHelper {
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> listenersUpdater;
    
    final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
    
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> waiterNextUpdater;
    
    final AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> waiterThreadUpdater;
    
    final AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> waitersUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater<AbstractFuture.Waiter, Thread> param1AtomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<AbstractFuture.Waiter, AbstractFuture.Waiter> param1AtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Waiter> param1AtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, AbstractFuture.Listener> param1AtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Object> param1AtomicReferenceFieldUpdater4) {
      this.waiterThreadUpdater = param1AtomicReferenceFieldUpdater;
      this.waiterNextUpdater = param1AtomicReferenceFieldUpdater1;
      this.waitersUpdater = param1AtomicReferenceFieldUpdater2;
      this.listenersUpdater = param1AtomicReferenceFieldUpdater3;
      this.valueUpdater = param1AtomicReferenceFieldUpdater4;
    }
    
    boolean casListeners(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2) {
      return this.listenersUpdater.compareAndSet(param1AbstractFuture, param1Listener1, param1Listener2);
    }
    
    boolean casValue(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2) {
      return this.valueUpdater.compareAndSet(param1AbstractFuture, param1Object1, param1Object2);
    }
    
    boolean casWaiters(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      return this.waitersUpdater.compareAndSet(param1AbstractFuture, param1Waiter1, param1Waiter2);
    }
    
    void putNext(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      this.waiterNextUpdater.lazySet(param1Waiter1, param1Waiter2);
    }
    
    void putThread(AbstractFuture.Waiter param1Waiter, Thread param1Thread) {
      this.waiterThreadUpdater.lazySet(param1Waiter, param1Thread);
    }
  }
  
  private static final class SetFuture<V> implements Runnable {
    final ListenableFuture<? extends V> future;
    
    final AbstractFuture<V> owner;
    
    SetFuture(AbstractFuture<V> param1AbstractFuture, ListenableFuture<? extends V> param1ListenableFuture) {
      this.owner = param1AbstractFuture;
      this.future = param1ListenableFuture;
    }
    
    public void run() {
      if (this.owner.value != this)
        return; 
      Object object = AbstractFuture.getFutureValue(this.future);
      if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, object))
        AbstractFuture.complete(this.owner); 
    }
  }
  
  private static final class SynchronizedHelper extends AtomicHelper {
    private SynchronizedHelper() {}
    
    boolean casListeners(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$800 : (Lcom/google/common/util/concurrent/AbstractFuture;)Lcom/google/common/util/concurrent/AbstractFuture$Listener;
      //   6: aload_2
      //   7: if_acmpne -> 20
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$802 : (Lcom/google/common/util/concurrent/AbstractFuture;Lcom/google/common/util/concurrent/AbstractFuture$Listener;)Lcom/google/common/util/concurrent/AbstractFuture$Listener;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: aload_1
      //   21: monitorexit
      //   22: iconst_0
      //   23: ireturn
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	24	finally
      //   20	22	24	finally
      //   25	27	24	finally
    }
    
    boolean casValue(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$300 : (Lcom/google/common/util/concurrent/AbstractFuture;)Ljava/lang/Object;
      //   6: aload_2
      //   7: if_acmpne -> 20
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$302 : (Lcom/google/common/util/concurrent/AbstractFuture;Ljava/lang/Object;)Ljava/lang/Object;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: aload_1
      //   21: monitorexit
      //   22: iconst_0
      //   23: ireturn
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	24	finally
      //   20	22	24	finally
      //   25	27	24	finally
    }
    
    boolean casWaiters(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic access$700 : (Lcom/google/common/util/concurrent/AbstractFuture;)Lcom/google/common/util/concurrent/AbstractFuture$Waiter;
      //   6: aload_2
      //   7: if_acmpne -> 20
      //   10: aload_1
      //   11: aload_3
      //   12: invokestatic access$702 : (Lcom/google/common/util/concurrent/AbstractFuture;Lcom/google/common/util/concurrent/AbstractFuture$Waiter;)Lcom/google/common/util/concurrent/AbstractFuture$Waiter;
      //   15: pop
      //   16: aload_1
      //   17: monitorexit
      //   18: iconst_1
      //   19: ireturn
      //   20: aload_1
      //   21: monitorexit
      //   22: iconst_0
      //   23: ireturn
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	24	finally
      //   20	22	24	finally
      //   25	27	24	finally
    }
    
    void putNext(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      param1Waiter1.next = param1Waiter2;
    }
    
    void putThread(AbstractFuture.Waiter param1Waiter, Thread param1Thread) {
      param1Waiter.thread = param1Thread;
    }
  }
  
  static abstract class TrustedFuture<V> extends AbstractFuture<V> {
    public final void addListener(Runnable param1Runnable, Executor param1Executor) {
      super.addListener(param1Runnable, param1Executor);
    }
    
    @CanIgnoreReturnValue
    public final boolean cancel(boolean param1Boolean) {
      return super.cancel(param1Boolean);
    }
    
    @CanIgnoreReturnValue
    public final V get() throws InterruptedException, ExecutionException {
      return super.get();
    }
    
    @CanIgnoreReturnValue
    public final V get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
      return super.get(param1Long, param1TimeUnit);
    }
    
    public final boolean isCancelled() {
      return super.isCancelled();
    }
    
    public final boolean isDone() {
      return super.isDone();
    }
  }
  
  private static final class UnsafeAtomicHelper extends AtomicHelper {
    static final long LISTENERS_OFFSET;
    
    static final Unsafe UNSAFE;
    
    static final long VALUE_OFFSET;
    
    static final long WAITERS_OFFSET;
    
    static final long WAITER_NEXT_OFFSET;
    
    static final long WAITER_THREAD_OFFSET;
    
    static {
      try {
        Unsafe unsafe = Unsafe.getUnsafe();
      } catch (SecurityException securityException) {
        try {
          PrivilegedExceptionAction<Unsafe> privilegedExceptionAction = new PrivilegedExceptionAction<Unsafe>() {
              public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                  field.setAccessible(true);
                  Object object = field.get((Object)null);
                  if (Unsafe.class.isInstance(object))
                    return Unsafe.class.cast(object); 
                } 
                throw new NoSuchFieldError("the Unsafe");
              }
            };
          super();
          Unsafe unsafe = AccessController.<Unsafe>doPrivileged(privilegedExceptionAction);
          try {
            WAITERS_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
            LISTENERS_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
            VALUE_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
            WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("thread"));
            WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("next"));
            UNSAFE = unsafe;
            return;
          } catch (Exception null) {
            Throwables.throwIfUnchecked(exception);
            throw new RuntimeException(exception);
          } 
        } catch (PrivilegedActionException exception) {
          throw new RuntimeException("Could not initialize intrinsics", exception.getCause());
        } 
      } 
      try {
        WAITERS_OFFSET = exception.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
        LISTENERS_OFFSET = exception.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
        VALUE_OFFSET = exception.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
        WAITER_THREAD_OFFSET = exception.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("thread"));
        WAITER_NEXT_OFFSET = exception.objectFieldOffset(AbstractFuture.Waiter.class.getDeclaredField("next"));
        UNSAFE = (Unsafe)exception;
        return;
      } catch (Exception exception1) {
        Throwables.throwIfUnchecked(exception1);
        throw new RuntimeException(exception1);
      } 
    }
    
    private UnsafeAtomicHelper() {}
    
    boolean casListeners(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Listener param1Listener1, AbstractFuture.Listener param1Listener2) {
      return UNSAFE.compareAndSwapObject(param1AbstractFuture, LISTENERS_OFFSET, param1Listener1, param1Listener2);
    }
    
    boolean casValue(AbstractFuture<?> param1AbstractFuture, Object param1Object1, Object param1Object2) {
      return UNSAFE.compareAndSwapObject(param1AbstractFuture, VALUE_OFFSET, param1Object1, param1Object2);
    }
    
    boolean casWaiters(AbstractFuture<?> param1AbstractFuture, AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      return UNSAFE.compareAndSwapObject(param1AbstractFuture, WAITERS_OFFSET, param1Waiter1, param1Waiter2);
    }
    
    void putNext(AbstractFuture.Waiter param1Waiter1, AbstractFuture.Waiter param1Waiter2) {
      UNSAFE.putObject(param1Waiter1, WAITER_NEXT_OFFSET, param1Waiter2);
    }
    
    void putThread(AbstractFuture.Waiter param1Waiter, Thread param1Thread) {
      UNSAFE.putObject(param1Waiter, WAITER_THREAD_OFFSET, param1Thread);
    }
  }
  
  static final class null implements PrivilegedExceptionAction<Unsafe> {
    public Unsafe run() throws Exception {
      for (Field field : Unsafe.class.getDeclaredFields()) {
        field.setAccessible(true);
        Object object = field.get((Object)null);
        if (Unsafe.class.isInstance(object))
          return Unsafe.class.cast(object); 
      } 
      throw new NoSuchFieldError("the Unsafe");
    }
  }
  
  private static final class Waiter {
    static final Waiter TOMBSTONE = new Waiter(false);
    
    @Nullable
    volatile Waiter next;
    
    @Nullable
    volatile Thread thread;
    
    Waiter() {
      AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
    
    Waiter(boolean param1Boolean) {}
    
    void setNext(Waiter param1Waiter) {
      AbstractFuture.ATOMIC_HELPER.putNext(this, param1Waiter);
    }
    
    void unpark() {
      Thread thread = this.thread;
      if (thread != null) {
        this.thread = null;
        LockSupport.unpark(thread);
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */