package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {
  final AtomicReference<Observer<? super T>> actual;
  
  final boolean delayError;
  
  volatile boolean disposed;
  
  volatile boolean done;
  
  boolean enableOperatorFusion;
  
  Throwable error;
  
  final AtomicReference<Runnable> onTerminate;
  
  final AtomicBoolean once;
  
  final SpscLinkedArrayQueue<T> queue;
  
  final BasicIntQueueDisposable<T> wip;
  
  UnicastSubject(int paramInt, Runnable paramRunnable) {
    this(paramInt, paramRunnable, true);
  }
  
  UnicastSubject(int paramInt, Runnable paramRunnable, boolean paramBoolean) {
    this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(paramInt, "capacityHint"));
    this.onTerminate = new AtomicReference(ObjectHelper.requireNonNull(paramRunnable, "onTerminate"));
    this.delayError = paramBoolean;
    this.actual = new AtomicReference<Observer<? super T>>();
    this.once = new AtomicBoolean();
    this.wip = new UnicastQueueDisposable();
  }
  
  UnicastSubject(int paramInt, boolean paramBoolean) {
    this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(paramInt, "capacityHint"));
    this.onTerminate = new AtomicReference<Runnable>();
    this.delayError = paramBoolean;
    this.actual = new AtomicReference<Observer<? super T>>();
    this.once = new AtomicBoolean();
    this.wip = new UnicastQueueDisposable();
  }
  
  @CheckReturnValue
  @NonNull
  public static <T> UnicastSubject<T> create() {
    return new UnicastSubject<T>(bufferSize(), true);
  }
  
  @CheckReturnValue
  @NonNull
  public static <T> UnicastSubject<T> create(int paramInt) {
    return new UnicastSubject<T>(paramInt, true);
  }
  
  @CheckReturnValue
  @NonNull
  public static <T> UnicastSubject<T> create(int paramInt, Runnable paramRunnable) {
    return new UnicastSubject<T>(paramInt, paramRunnable, true);
  }
  
  @CheckReturnValue
  @Experimental
  @NonNull
  public static <T> UnicastSubject<T> create(int paramInt, Runnable paramRunnable, boolean paramBoolean) {
    return new UnicastSubject<T>(paramInt, paramRunnable, paramBoolean);
  }
  
  @CheckReturnValue
  @Experimental
  @NonNull
  public static <T> UnicastSubject<T> create(boolean paramBoolean) {
    return new UnicastSubject<T>(bufferSize(), paramBoolean);
  }
  
  void doTerminate() {
    Runnable runnable = this.onTerminate.get();
    if (runnable != null && this.onTerminate.compareAndSet(runnable, null))
      runnable.run(); 
  }
  
  void drain() {
    if (this.wip.getAndIncrement() != 0)
      return; 
    Observer<? super T> observer = this.actual.get();
    int i = 1;
    while (true) {
      if (observer != null) {
        if (this.enableOperatorFusion) {
          drainFused(observer);
        } else {
          drainNormal(observer);
        } 
        return;
      } 
      i = this.wip.addAndGet(-i);
      if (i == 0)
        return; 
      observer = this.actual.get();
    } 
  }
  
  void drainFused(Observer<? super T> paramObserver) {
    int j;
    SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
    boolean bool = this.delayError;
    int i = 1;
    do {
      if (this.disposed) {
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
        return;
      } 
      boolean bool1 = this.done;
      if ((bool ^ true) != 0 && bool1 && failedFast((SimpleQueue<T>)spscLinkedArrayQueue, paramObserver))
        return; 
      paramObserver.onNext(null);
      if (bool1) {
        errorOrComplete(paramObserver);
        return;
      } 
      j = this.wip.addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  void drainNormal(Observer<? super T> paramObserver) {
    SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
    boolean bool = this.delayError;
    boolean bool1 = true;
    int i = 1;
    while (true) {
      int j;
      if (this.disposed) {
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
        return;
      } 
      boolean bool2 = this.done;
      Object object = this.queue.poll();
      if (object == null) {
        j = 1;
      } else {
        j = 0;
      } 
      boolean bool3 = bool1;
      if (bool2) {
        bool3 = bool1;
        if ((bool ^ true) != 0) {
          bool3 = bool1;
          if (bool1) {
            if (failedFast((SimpleQueue<T>)spscLinkedArrayQueue, paramObserver))
              return; 
            bool3 = false;
          } 
        } 
        if (j) {
          errorOrComplete(paramObserver);
          return;
        } 
      } 
      if (j) {
        j = this.wip.addAndGet(-i);
        bool1 = bool3;
        i = j;
        if (j == 0)
          return; 
        continue;
      } 
      paramObserver.onNext(object);
      bool1 = bool3;
    } 
  }
  
  void errorOrComplete(Observer<? super T> paramObserver) {
    this.actual.lazySet(null);
    Throwable throwable = this.error;
    if (throwable != null) {
      paramObserver.onError(throwable);
    } else {
      paramObserver.onComplete();
    } 
  }
  
  boolean failedFast(SimpleQueue<T> paramSimpleQueue, Observer<? super T> paramObserver) {
    Throwable throwable = this.error;
    if (throwable != null) {
      this.actual.lazySet(null);
      paramSimpleQueue.clear();
      paramObserver.onError(throwable);
      return true;
    } 
    return false;
  }
  
  @Nullable
  public Throwable getThrowable() {
    return this.done ? this.error : null;
  }
  
  public boolean hasComplete() {
    boolean bool;
    if (this.done && this.error == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasObservers() {
    boolean bool;
    if (this.actual.get() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasThrowable() {
    boolean bool;
    if (this.done && this.error != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onComplete() {
    if (this.done || this.disposed)
      return; 
    this.done = true;
    doTerminate();
    drain();
  }
  
  public void onError(Throwable paramThrowable) {
    ObjectHelper.requireNonNull(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (this.done || this.disposed) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    this.error = paramThrowable;
    this.done = true;
    doTerminate();
    drain();
  }
  
  public void onNext(T paramT) {
    ObjectHelper.requireNonNull(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (this.done || this.disposed)
      return; 
    this.queue.offer(paramT);
    drain();
  }
  
  public void onSubscribe(Disposable paramDisposable) {
    if (this.done || this.disposed)
      paramDisposable.dispose(); 
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    if (!this.once.get() && this.once.compareAndSet(false, true)) {
      paramObserver.onSubscribe((Disposable)this.wip);
      this.actual.lazySet(paramObserver);
      if (this.disposed) {
        this.actual.lazySet(null);
        return;
      } 
      drain();
    } else {
      EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), paramObserver);
    } 
  }
  
  final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = 7926949470189395511L;
    
    public void clear() {
      UnicastSubject.this.queue.clear();
    }
    
    public void dispose() {
      if (!UnicastSubject.this.disposed) {
        UnicastSubject unicastSubject = UnicastSubject.this;
        unicastSubject.disposed = true;
        unicastSubject.doTerminate();
        UnicastSubject.this.actual.lazySet(null);
        if (UnicastSubject.this.wip.getAndIncrement() == 0) {
          UnicastSubject.this.actual.lazySet(null);
          UnicastSubject.this.queue.clear();
        } 
      } 
    }
    
    public boolean isDisposed() {
      return UnicastSubject.this.disposed;
    }
    
    public boolean isEmpty() {
      return UnicastSubject.this.queue.isEmpty();
    }
    
    @Nullable
    public T poll() throws Exception {
      return (T)UnicastSubject.this.queue.poll();
    }
    
    public int requestFusion(int param1Int) {
      if ((param1Int & 0x2) != 0) {
        UnicastSubject.this.enableOperatorFusion = true;
        return 2;
      } 
      return 0;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\subjects\UnicastSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */