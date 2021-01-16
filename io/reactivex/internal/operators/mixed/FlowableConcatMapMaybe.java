package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {
  final ErrorMode errorMode;
  
  final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
  
  final int prefetch;
  
  final Flowable<T> source;
  
  public FlowableConcatMapMaybe(Flowable<T> paramFlowable, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, ErrorMode paramErrorMode, int paramInt) {
    this.source = paramFlowable;
    this.mapper = paramFunction;
    this.errorMode = paramErrorMode;
    this.prefetch = paramInt;
  }
  
  protected void subscribeActual(Subscriber<? super R> paramSubscriber) {
    this.source.subscribe(new ConcatMapMaybeSubscriber<T, R>(paramSubscriber, this.mapper, this.prefetch, this.errorMode));
  }
  
  static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    static final int STATE_ACTIVE = 1;
    
    static final int STATE_INACTIVE = 0;
    
    static final int STATE_RESULT_VALUE = 2;
    
    private static final long serialVersionUID = -9140123220065488293L;
    
    volatile boolean cancelled;
    
    int consumed;
    
    volatile boolean done;
    
    final Subscriber<? super R> downstream;
    
    long emitted;
    
    final ErrorMode errorMode;
    
    final AtomicThrowable errors;
    
    final ConcatMapMaybeObserver<R> inner;
    
    R item;
    
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    
    final int prefetch;
    
    final SimplePlainQueue<T> queue;
    
    final AtomicLong requested;
    
    volatile int state;
    
    Subscription upstream;
    
    ConcatMapMaybeSubscriber(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends MaybeSource<? extends R>> param1Function, int param1Int, ErrorMode param1ErrorMode) {
      this.downstream = param1Subscriber;
      this.mapper = param1Function;
      this.prefetch = param1Int;
      this.errorMode = param1ErrorMode;
      this.requested = new AtomicLong();
      this.errors = new AtomicThrowable();
      this.inner = new ConcatMapMaybeObserver<R>(this);
      this.queue = (SimplePlainQueue<T>)new SpscArrayQueue(param1Int);
    }
    
    public void cancel() {
      this.cancelled = true;
      this.upstream.cancel();
      this.inner.dispose();
      if (getAndIncrement() == 0) {
        this.queue.clear();
        this.item = null;
      } 
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      Subscriber<? super R> subscriber = this.downstream;
      ErrorMode errorMode = this.errorMode;
      SimplePlainQueue<T> simplePlainQueue = this.queue;
      AtomicThrowable atomicThrowable = this.errors;
      AtomicLong atomicLong = this.requested;
      int i = this.prefetch;
      int j = i - (i >> 1);
      i = 1;
      while (true) {
        if (this.cancelled) {
          simplePlainQueue.clear();
          this.item = null;
        } 
        int k = this.state;
        if (atomicThrowable.get() != null && (errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && k == 0))) {
          simplePlainQueue.clear();
          this.item = null;
          subscriber.onError(atomicThrowable.terminate());
          return;
        } 
        if (k == 0) {
          Throwable throwable1;
          boolean bool = this.done;
          Object object = simplePlainQueue.poll();
          if (object == null) {
            k = 1;
          } else {
            k = 0;
          } 
          if (bool && k != 0) {
            throwable1 = atomicThrowable.terminate();
            if (throwable1 == null) {
              subscriber.onComplete();
            } else {
              subscriber.onError(throwable1);
            } 
            return;
          } 
          if (k == 0) {
            k = this.consumed + 1;
            if (k == j) {
              this.consumed = 0;
              this.upstream.request(j);
            } else {
              this.consumed = k;
            } 
            try {
              object = ObjectHelper.requireNonNull(this.mapper.apply(object), "The mapper returned a null MaybeSource");
              this.state = 1;
              object.subscribe(this.inner);
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              this.upstream.cancel();
              throwable1.clear();
              atomicThrowable.addThrowable(throwable);
              subscriber.onError(atomicThrowable.terminate());
              return;
            } 
          } 
        } else if (k == 2) {
          long l = this.emitted;
          if (l != throwable.get()) {
            R r = this.item;
            this.item = null;
            subscriber.onNext(r);
            this.emitted = l + 1L;
            this.state = 0;
            continue;
          } 
        } 
        k = addAndGet(-i);
        i = k;
        if (k == 0)
          break; 
      } 
    }
    
    void innerComplete() {
      this.state = 0;
      drain();
    }
    
    void innerError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        if (this.errorMode != ErrorMode.END)
          this.upstream.cancel(); 
        this.state = 0;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    void innerSuccess(R param1R) {
      this.item = param1R;
      this.state = 2;
      drain();
    }
    
    public void onComplete() {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        if (this.errorMode == ErrorMode.IMMEDIATE)
          this.inner.dispose(); 
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (!this.queue.offer(param1T)) {
        this.upstream.cancel();
        onError((Throwable)new MissingBackpressureException("queue full?!"));
        return;
      } 
      drain();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.upstream, param1Subscription)) {
        this.upstream = param1Subscription;
        this.downstream.onSubscribe(this);
        param1Subscription.request(this.prefetch);
      } 
    }
    
    public void request(long param1Long) {
      BackpressureHelper.add(this.requested, param1Long);
      drain();
    }
    
    static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
      private static final long serialVersionUID = -3051469169682093892L;
      
      final FlowableConcatMapMaybe.ConcatMapMaybeSubscriber<?, R> parent;
      
      ConcatMapMaybeObserver(FlowableConcatMapMaybe.ConcatMapMaybeSubscriber<?, R> param2ConcatMapMaybeSubscriber) {
        this.parent = param2ConcatMapMaybeSubscriber;
      }
      
      void dispose() {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete() {
        this.parent.innerComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        this.parent.innerError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.replace(this, param2Disposable);
      }
      
      public void onSuccess(R param2R) {
        this.parent.innerSuccess(param2R);
      }
    }
  }
  
  static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
    private static final long serialVersionUID = -3051469169682093892L;
    
    final FlowableConcatMapMaybe.ConcatMapMaybeSubscriber<?, R> parent;
    
    ConcatMapMaybeObserver(FlowableConcatMapMaybe.ConcatMapMaybeSubscriber<?, R> param1ConcatMapMaybeSubscriber) {
      this.parent = param1ConcatMapMaybeSubscriber;
    }
    
    void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete() {
      this.parent.innerComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.parent.innerError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.replace(this, param1Disposable);
    }
    
    public void onSuccess(R param1R) {
      this.parent.innerSuccess(param1R);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\mixed\FlowableConcatMapMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */