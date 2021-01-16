package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
  final Callable<U> bufferSupplier;
  
  final int maxSize;
  
  final boolean restartTimerOnMaxSize;
  
  final Scheduler scheduler;
  
  final long timeskip;
  
  final long timespan;
  
  final TimeUnit unit;
  
  public FlowableBufferTimed(Flowable<T> paramFlowable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, Callable<U> paramCallable, int paramInt, boolean paramBoolean) {
    super(paramFlowable);
    this.timespan = paramLong1;
    this.timeskip = paramLong2;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.bufferSupplier = paramCallable;
    this.maxSize = paramInt;
    this.restartTimerOnMaxSize = paramBoolean;
  }
  
  protected void subscribeActual(Subscriber<? super U> paramSubscriber) {
    if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
      this.source.subscribe((FlowableSubscriber)new BufferExactUnboundedSubscriber<Object, U>((Subscriber<? super U>)new SerializedSubscriber(paramSubscriber), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
      return;
    } 
    Scheduler.Worker worker = this.scheduler.createWorker();
    if (this.timespan == this.timeskip) {
      this.source.subscribe((FlowableSubscriber)new BufferExactBoundedSubscriber<Object, U>((Subscriber<? super U>)new SerializedSubscriber(paramSubscriber), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, worker));
      return;
    } 
    this.source.subscribe((FlowableSubscriber)new BufferSkipBoundedSubscriber<Object, U>((Subscriber<? super U>)new SerializedSubscriber(paramSubscriber), this.bufferSupplier, this.timespan, this.timeskip, this.unit, worker));
  }
  
  static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
    U buffer;
    
    final Callable<U> bufferSupplier;
    
    long consumerIndex;
    
    final int maxSize;
    
    long producerIndex;
    
    final boolean restartTimerOnMaxSize;
    
    Subscription s;
    
    Disposable timer;
    
    final long timespan;
    
    final TimeUnit unit;
    
    final Scheduler.Worker w;
    
    BufferExactBoundedSubscriber(Subscriber<? super U> param1Subscriber, Callable<U> param1Callable, long param1Long, TimeUnit param1TimeUnit, int param1Int, boolean param1Boolean, Scheduler.Worker param1Worker) {
      super(param1Subscriber, (SimplePlainQueue)new MpscLinkedQueue());
      this.bufferSupplier = param1Callable;
      this.timespan = param1Long;
      this.unit = param1TimeUnit;
      this.maxSize = param1Int;
      this.restartTimerOnMaxSize = param1Boolean;
      this.w = param1Worker;
    }
    
    public boolean accept(Subscriber<? super U> param1Subscriber, U param1U) {
      param1Subscriber.onNext(param1U);
      return true;
    }
    
    public void cancel() {
      if (!this.cancelled) {
        this.cancelled = true;
        dispose();
      } 
    }
    
    public void dispose() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aconst_null
      //   4: putfield buffer : Ljava/util/Collection;
      //   7: aload_0
      //   8: monitorexit
      //   9: aload_0
      //   10: getfield s : Lorg/reactivestreams/Subscription;
      //   13: invokeinterface cancel : ()V
      //   18: aload_0
      //   19: getfield w : Lio/reactivex/Scheduler$Worker;
      //   22: invokevirtual dispose : ()V
      //   25: return
      //   26: astore_1
      //   27: aload_0
      //   28: monitorexit
      //   29: aload_1
      //   30: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	26	finally
      //   27	29	26	finally
    }
    
    public boolean isDisposed() {
      return this.w.isDisposed();
    }
    
    public void onComplete() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield buffer : Ljava/util/Collection;
      //   6: astore_1
      //   7: aload_0
      //   8: aconst_null
      //   9: putfield buffer : Ljava/util/Collection;
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_0
      //   15: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   18: aload_1
      //   19: invokeinterface offer : (Ljava/lang/Object;)Z
      //   24: pop
      //   25: aload_0
      //   26: iconst_1
      //   27: putfield done : Z
      //   30: aload_0
      //   31: invokevirtual enter : ()Z
      //   34: ifeq -> 51
      //   37: aload_0
      //   38: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   41: aload_0
      //   42: getfield actual : Lorg/reactivestreams/Subscriber;
      //   45: iconst_0
      //   46: aload_0
      //   47: aload_0
      //   48: invokestatic drainMaxLoop : (Lio/reactivex/internal/fuseable/SimplePlainQueue;Lorg/reactivestreams/Subscriber;ZLio/reactivex/disposables/Disposable;Lio/reactivex/internal/util/QueueDrain;)V
      //   51: aload_0
      //   52: getfield w : Lio/reactivex/Scheduler$Worker;
      //   55: invokevirtual dispose : ()V
      //   58: return
      //   59: astore_1
      //   60: aload_0
      //   61: monitorexit
      //   62: aload_1
      //   63: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	59	finally
      //   60	62	59	finally
    }
    
    public void onError(Throwable param1Throwable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aconst_null
      //   4: putfield buffer : Ljava/util/Collection;
      //   7: aload_0
      //   8: monitorexit
      //   9: aload_0
      //   10: getfield actual : Lorg/reactivestreams/Subscriber;
      //   13: aload_1
      //   14: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   19: aload_0
      //   20: getfield w : Lio/reactivex/Scheduler$Worker;
      //   23: invokevirtual dispose : ()V
      //   26: return
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	27	finally
      //   28	30	27	finally
    }
    
    public void onNext(T param1T) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield buffer : Ljava/util/Collection;
      //   6: astore_2
      //   7: aload_2
      //   8: ifnonnull -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_2
      //   15: aload_1
      //   16: invokeinterface add : (Ljava/lang/Object;)Z
      //   21: pop
      //   22: aload_2
      //   23: invokeinterface size : ()I
      //   28: aload_0
      //   29: getfield maxSize : I
      //   32: if_icmpge -> 38
      //   35: aload_0
      //   36: monitorexit
      //   37: return
      //   38: aload_0
      //   39: aconst_null
      //   40: putfield buffer : Ljava/util/Collection;
      //   43: aload_0
      //   44: aload_0
      //   45: getfield producerIndex : J
      //   48: lconst_1
      //   49: ladd
      //   50: putfield producerIndex : J
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_0
      //   56: getfield restartTimerOnMaxSize : Z
      //   59: ifeq -> 71
      //   62: aload_0
      //   63: getfield timer : Lio/reactivex/disposables/Disposable;
      //   66: invokeinterface dispose : ()V
      //   71: aload_0
      //   72: aload_2
      //   73: iconst_0
      //   74: aload_0
      //   75: invokevirtual fastPathOrderedEmitMax : (Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V
      //   78: aload_0
      //   79: getfield bufferSupplier : Ljava/util/concurrent/Callable;
      //   82: invokeinterface call : ()Ljava/lang/Object;
      //   87: ldc 'The supplied buffer is null'
      //   89: invokestatic requireNonNull : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   92: checkcast java/util/Collection
      //   95: astore_1
      //   96: aload_0
      //   97: monitorenter
      //   98: aload_0
      //   99: aload_1
      //   100: putfield buffer : Ljava/util/Collection;
      //   103: aload_0
      //   104: aload_0
      //   105: getfield consumerIndex : J
      //   108: lconst_1
      //   109: ladd
      //   110: putfield consumerIndex : J
      //   113: aload_0
      //   114: monitorexit
      //   115: aload_0
      //   116: getfield restartTimerOnMaxSize : Z
      //   119: ifeq -> 147
      //   122: aload_0
      //   123: getfield w : Lio/reactivex/Scheduler$Worker;
      //   126: astore_1
      //   127: aload_0
      //   128: getfield timespan : J
      //   131: lstore_3
      //   132: aload_0
      //   133: aload_1
      //   134: aload_0
      //   135: lload_3
      //   136: lload_3
      //   137: aload_0
      //   138: getfield unit : Ljava/util/concurrent/TimeUnit;
      //   141: invokevirtual schedulePeriodically : (Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;
      //   144: putfield timer : Lio/reactivex/disposables/Disposable;
      //   147: return
      //   148: astore_1
      //   149: aload_0
      //   150: monitorexit
      //   151: aload_1
      //   152: athrow
      //   153: astore_1
      //   154: aload_1
      //   155: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   158: aload_0
      //   159: invokevirtual cancel : ()V
      //   162: aload_0
      //   163: getfield actual : Lorg/reactivestreams/Subscriber;
      //   166: aload_1
      //   167: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   172: return
      //   173: astore_1
      //   174: aload_0
      //   175: monitorexit
      //   176: aload_1
      //   177: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	173	finally
      //   11	13	173	finally
      //   14	37	173	finally
      //   38	55	173	finally
      //   78	96	153	java/lang/Throwable
      //   98	115	148	finally
      //   149	151	148	finally
      //   174	176	173	finally
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (!SubscriptionHelper.validate(this.s, param1Subscription))
        return; 
      this.s = param1Subscription;
      try {
        Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
        this.buffer = (U)collection;
        this.actual.onSubscribe(this);
        Scheduler.Worker worker = this.w;
        long l = this.timespan;
        this.timer = worker.schedulePeriodically(this, l, l, this.unit);
        param1Subscription.request(Long.MAX_VALUE);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.w.dispose();
        param1Subscription.cancel();
        EmptySubscription.error(throwable, this.actual);
        return;
      } 
    }
    
    public void request(long param1Long) {
      requested(param1Long);
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield bufferSupplier : Ljava/util/concurrent/Callable;
      //   4: invokeinterface call : ()Ljava/lang/Object;
      //   9: ldc 'The supplied buffer is null'
      //   11: invokestatic requireNonNull : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   14: checkcast java/util/Collection
      //   17: astore_1
      //   18: aload_0
      //   19: monitorenter
      //   20: aload_0
      //   21: getfield buffer : Ljava/util/Collection;
      //   24: astore_2
      //   25: aload_2
      //   26: ifnull -> 59
      //   29: aload_0
      //   30: getfield producerIndex : J
      //   33: aload_0
      //   34: getfield consumerIndex : J
      //   37: lcmp
      //   38: ifeq -> 44
      //   41: goto -> 59
      //   44: aload_0
      //   45: aload_1
      //   46: putfield buffer : Ljava/util/Collection;
      //   49: aload_0
      //   50: monitorexit
      //   51: aload_0
      //   52: aload_2
      //   53: iconst_0
      //   54: aload_0
      //   55: invokevirtual fastPathOrderedEmitMax : (Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V
      //   58: return
      //   59: aload_0
      //   60: monitorexit
      //   61: return
      //   62: astore_2
      //   63: aload_0
      //   64: monitorexit
      //   65: aload_2
      //   66: athrow
      //   67: astore_2
      //   68: aload_2
      //   69: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   72: aload_0
      //   73: invokevirtual cancel : ()V
      //   76: aload_0
      //   77: getfield actual : Lorg/reactivestreams/Subscriber;
      //   80: aload_2
      //   81: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   86: return
      // Exception table:
      //   from	to	target	type
      //   0	18	67	java/lang/Throwable
      //   20	25	62	finally
      //   29	41	62	finally
      //   44	51	62	finally
      //   59	61	62	finally
      //   63	65	62	finally
    }
  }
  
  static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
    U buffer;
    
    final Callable<U> bufferSupplier;
    
    Subscription s;
    
    final Scheduler scheduler;
    
    final AtomicReference<Disposable> timer = new AtomicReference<Disposable>();
    
    final long timespan;
    
    final TimeUnit unit;
    
    BufferExactUnboundedSubscriber(Subscriber<? super U> param1Subscriber, Callable<U> param1Callable, long param1Long, TimeUnit param1TimeUnit, Scheduler param1Scheduler) {
      super(param1Subscriber, (SimplePlainQueue)new MpscLinkedQueue());
      this.bufferSupplier = param1Callable;
      this.timespan = param1Long;
      this.unit = param1TimeUnit;
      this.scheduler = param1Scheduler;
    }
    
    public boolean accept(Subscriber<? super U> param1Subscriber, U param1U) {
      this.actual.onNext(param1U);
      return true;
    }
    
    public void cancel() {
      this.cancelled = true;
      this.s.cancel();
      DisposableHelper.dispose(this.timer);
    }
    
    public void dispose() {
      cancel();
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (this.timer.get() == DisposableHelper.DISPOSED) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      // Byte code:
      //   0: aload_0
      //   1: getfield timer : Ljava/util/concurrent/atomic/AtomicReference;
      //   4: invokestatic dispose : (Ljava/util/concurrent/atomic/AtomicReference;)Z
      //   7: pop
      //   8: aload_0
      //   9: monitorenter
      //   10: aload_0
      //   11: getfield buffer : Ljava/util/Collection;
      //   14: astore_1
      //   15: aload_1
      //   16: ifnonnull -> 22
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: aconst_null
      //   24: putfield buffer : Ljava/util/Collection;
      //   27: aload_0
      //   28: monitorexit
      //   29: aload_0
      //   30: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   33: aload_1
      //   34: invokeinterface offer : (Ljava/lang/Object;)Z
      //   39: pop
      //   40: aload_0
      //   41: iconst_1
      //   42: putfield done : Z
      //   45: aload_0
      //   46: invokevirtual enter : ()Z
      //   49: ifeq -> 66
      //   52: aload_0
      //   53: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   56: aload_0
      //   57: getfield actual : Lorg/reactivestreams/Subscriber;
      //   60: iconst_0
      //   61: aconst_null
      //   62: aload_0
      //   63: invokestatic drainMaxLoop : (Lio/reactivex/internal/fuseable/SimplePlainQueue;Lorg/reactivestreams/Subscriber;ZLio/reactivex/disposables/Disposable;Lio/reactivex/internal/util/QueueDrain;)V
      //   66: return
      //   67: astore_1
      //   68: aload_0
      //   69: monitorexit
      //   70: aload_1
      //   71: athrow
      // Exception table:
      //   from	to	target	type
      //   10	15	67	finally
      //   19	21	67	finally
      //   22	29	67	finally
      //   68	70	67	finally
    }
    
    public void onError(Throwable param1Throwable) {
      // Byte code:
      //   0: aload_0
      //   1: getfield timer : Ljava/util/concurrent/atomic/AtomicReference;
      //   4: invokestatic dispose : (Ljava/util/concurrent/atomic/AtomicReference;)Z
      //   7: pop
      //   8: aload_0
      //   9: monitorenter
      //   10: aload_0
      //   11: aconst_null
      //   12: putfield buffer : Ljava/util/Collection;
      //   15: aload_0
      //   16: monitorexit
      //   17: aload_0
      //   18: getfield actual : Lorg/reactivestreams/Subscriber;
      //   21: aload_1
      //   22: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   27: return
      //   28: astore_1
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   10	17	28	finally
      //   29	31	28	finally
    }
    
    public void onNext(T param1T) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield buffer : Ljava/util/Collection;
      //   6: astore_2
      //   7: aload_2
      //   8: ifnull -> 19
      //   11: aload_2
      //   12: aload_1
      //   13: invokeinterface add : (Ljava/lang/Object;)Z
      //   18: pop
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: astore_1
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	22	finally
      //   11	19	22	finally
      //   19	21	22	finally
      //   23	25	22	finally
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        try {
          Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
          this.buffer = (U)collection;
          this.actual.onSubscribe(this);
          if (!this.cancelled) {
            param1Subscription.request(Long.MAX_VALUE);
            Scheduler scheduler = this.scheduler;
            long l = this.timespan;
            Disposable disposable = scheduler.schedulePeriodicallyDirect(this, l, l, this.unit);
            if (!this.timer.compareAndSet(null, disposable))
              disposable.dispose(); 
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          cancel();
          EmptySubscription.error(throwable, this.actual);
          return;
        } 
      } 
    }
    
    public void request(long param1Long) {
      requested(param1Long);
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield bufferSupplier : Ljava/util/concurrent/Callable;
      //   4: invokeinterface call : ()Ljava/lang/Object;
      //   9: ldc 'The supplied buffer is null'
      //   11: invokestatic requireNonNull : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   14: checkcast java/util/Collection
      //   17: astore_1
      //   18: aload_0
      //   19: monitorenter
      //   20: aload_0
      //   21: getfield buffer : Ljava/util/Collection;
      //   24: astore_2
      //   25: aload_2
      //   26: ifnonnull -> 32
      //   29: aload_0
      //   30: monitorexit
      //   31: return
      //   32: aload_0
      //   33: aload_1
      //   34: putfield buffer : Ljava/util/Collection;
      //   37: aload_0
      //   38: monitorexit
      //   39: aload_0
      //   40: aload_2
      //   41: iconst_0
      //   42: aload_0
      //   43: invokevirtual fastPathEmitMax : (Ljava/lang/Object;ZLio/reactivex/disposables/Disposable;)V
      //   46: return
      //   47: astore_2
      //   48: aload_0
      //   49: monitorexit
      //   50: aload_2
      //   51: athrow
      //   52: astore_2
      //   53: aload_2
      //   54: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   57: aload_0
      //   58: invokevirtual cancel : ()V
      //   61: aload_0
      //   62: getfield actual : Lorg/reactivestreams/Subscriber;
      //   65: aload_2
      //   66: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   71: return
      // Exception table:
      //   from	to	target	type
      //   0	18	52	java/lang/Throwable
      //   20	25	47	finally
      //   29	31	47	finally
      //   32	39	47	finally
      //   48	50	47	finally
    }
  }
  
  static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
    final Callable<U> bufferSupplier;
    
    final List<U> buffers;
    
    Subscription s;
    
    final long timeskip;
    
    final long timespan;
    
    final TimeUnit unit;
    
    final Scheduler.Worker w;
    
    BufferSkipBoundedSubscriber(Subscriber<? super U> param1Subscriber, Callable<U> param1Callable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit, Scheduler.Worker param1Worker) {
      super(param1Subscriber, (SimplePlainQueue)new MpscLinkedQueue());
      this.bufferSupplier = param1Callable;
      this.timespan = param1Long1;
      this.timeskip = param1Long2;
      this.unit = param1TimeUnit;
      this.w = param1Worker;
      this.buffers = new LinkedList<U>();
    }
    
    public boolean accept(Subscriber<? super U> param1Subscriber, U param1U) {
      param1Subscriber.onNext(param1U);
      return true;
    }
    
    public void cancel() {
      this.cancelled = true;
      this.s.cancel();
      this.w.dispose();
      clear();
    }
    
    void clear() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield buffers : Ljava/util/List;
      //   6: invokeinterface clear : ()V
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: astore_1
      //   15: aload_0
      //   16: monitorexit
      //   17: aload_1
      //   18: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	14	finally
      //   15	17	14	finally
    }
    
    public void onComplete() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/util/ArrayList
      //   5: astore_1
      //   6: aload_1
      //   7: aload_0
      //   8: getfield buffers : Ljava/util/List;
      //   11: invokespecial <init> : (Ljava/util/Collection;)V
      //   14: aload_0
      //   15: getfield buffers : Ljava/util/List;
      //   18: invokeinterface clear : ()V
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: invokeinterface iterator : ()Ljava/util/Iterator;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface hasNext : ()Z
      //   38: ifeq -> 65
      //   41: aload_2
      //   42: invokeinterface next : ()Ljava/lang/Object;
      //   47: checkcast java/util/Collection
      //   50: astore_1
      //   51: aload_0
      //   52: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   55: aload_1
      //   56: invokeinterface offer : (Ljava/lang/Object;)Z
      //   61: pop
      //   62: goto -> 32
      //   65: aload_0
      //   66: iconst_1
      //   67: putfield done : Z
      //   70: aload_0
      //   71: invokevirtual enter : ()Z
      //   74: ifeq -> 94
      //   77: aload_0
      //   78: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   81: aload_0
      //   82: getfield actual : Lorg/reactivestreams/Subscriber;
      //   85: iconst_0
      //   86: aload_0
      //   87: getfield w : Lio/reactivex/Scheduler$Worker;
      //   90: aload_0
      //   91: invokestatic drainMaxLoop : (Lio/reactivex/internal/fuseable/SimplePlainQueue;Lorg/reactivestreams/Subscriber;ZLio/reactivex/disposables/Disposable;Lio/reactivex/internal/util/QueueDrain;)V
      //   94: return
      //   95: astore_1
      //   96: aload_0
      //   97: monitorexit
      //   98: aload_1
      //   99: athrow
      // Exception table:
      //   from	to	target	type
      //   2	25	95	finally
      //   96	98	95	finally
    }
    
    public void onError(Throwable param1Throwable) {
      this.done = true;
      this.w.dispose();
      clear();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield buffers : Ljava/util/List;
      //   6: invokeinterface iterator : ()Ljava/util/Iterator;
      //   11: astore_2
      //   12: aload_2
      //   13: invokeinterface hasNext : ()Z
      //   18: ifeq -> 40
      //   21: aload_2
      //   22: invokeinterface next : ()Ljava/lang/Object;
      //   27: checkcast java/util/Collection
      //   30: aload_1
      //   31: invokeinterface add : (Ljava/lang/Object;)Z
      //   36: pop
      //   37: goto -> 12
      //   40: aload_0
      //   41: monitorexit
      //   42: return
      //   43: astore_1
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	43	finally
      //   12	37	43	finally
      //   40	42	43	finally
      //   44	46	43	finally
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      Scheduler.Worker worker;
      if (!SubscriptionHelper.validate(this.s, param1Subscription))
        return; 
      this.s = param1Subscription;
      try {
        Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
        this.buffers.add((U)collection);
        this.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
        worker = this.w;
        long l = this.timeskip;
        worker.schedulePeriodically(this, l, l, this.unit);
        this.w.schedule(new RemoveFromBuffer((U)collection), this.timespan, this.unit);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.w.dispose();
        worker.cancel();
        EmptySubscription.error(throwable, this.actual);
        return;
      } 
    }
    
    public void request(long param1Long) {
      requested(param1Long);
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield cancelled : Z
      //   4: ifeq -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield bufferSupplier : Ljava/util/concurrent/Callable;
      //   12: invokeinterface call : ()Ljava/lang/Object;
      //   17: ldc 'The supplied buffer is null'
      //   19: invokestatic requireNonNull : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   22: checkcast java/util/Collection
      //   25: astore_1
      //   26: aload_0
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield cancelled : Z
      //   32: ifeq -> 38
      //   35: aload_0
      //   36: monitorexit
      //   37: return
      //   38: aload_0
      //   39: getfield buffers : Ljava/util/List;
      //   42: aload_1
      //   43: invokeinterface add : (Ljava/lang/Object;)Z
      //   48: pop
      //   49: aload_0
      //   50: monitorexit
      //   51: aload_0
      //   52: getfield w : Lio/reactivex/Scheduler$Worker;
      //   55: new io/reactivex/internal/operators/flowable/FlowableBufferTimed$BufferSkipBoundedSubscriber$RemoveFromBuffer
      //   58: dup
      //   59: aload_0
      //   60: aload_1
      //   61: invokespecial <init> : (Lio/reactivex/internal/operators/flowable/FlowableBufferTimed$BufferSkipBoundedSubscriber;Ljava/util/Collection;)V
      //   64: aload_0
      //   65: getfield timespan : J
      //   68: aload_0
      //   69: getfield unit : Ljava/util/concurrent/TimeUnit;
      //   72: invokevirtual schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;
      //   75: pop
      //   76: return
      //   77: astore_1
      //   78: aload_0
      //   79: monitorexit
      //   80: aload_1
      //   81: athrow
      //   82: astore_1
      //   83: aload_1
      //   84: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   87: aload_0
      //   88: invokevirtual cancel : ()V
      //   91: aload_0
      //   92: getfield actual : Lorg/reactivestreams/Subscriber;
      //   95: aload_1
      //   96: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   101: return
      // Exception table:
      //   from	to	target	type
      //   8	26	82	java/lang/Throwable
      //   28	37	77	finally
      //   38	51	77	finally
      //   78	80	77	finally
    }
    
    final class RemoveFromBuffer implements Runnable {
      private final U buffer;
      
      RemoveFromBuffer(U param2U) {
        this.buffer = param2U;
      }
      
      public void run() {
        synchronized (FlowableBufferTimed.BufferSkipBoundedSubscriber.this) {
          FlowableBufferTimed.BufferSkipBoundedSubscriber.this.buffers.remove(this.buffer);
          FlowableBufferTimed.BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = FlowableBufferTimed.BufferSkipBoundedSubscriber.this;
          bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.buffer, false, (Disposable)bufferSkipBoundedSubscriber.w);
          return;
        } 
      }
    }
  }
  
  final class RemoveFromBuffer implements Runnable {
    private final U buffer;
    
    RemoveFromBuffer(U param1U) {
      this.buffer = param1U;
    }
    
    public void run() {
      synchronized (this.this$0) {
        this.this$0.buffers.remove(this.buffer);
        FlowableBufferTimed.BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = this.this$0;
        bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.buffer, false, (Disposable)bufferSkipBoundedSubscriber.w);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBufferTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */