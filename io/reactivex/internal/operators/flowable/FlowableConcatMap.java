package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
  final ErrorMode errorMode;
  
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  
  final int prefetch;
  
  public FlowableConcatMap(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, ErrorMode paramErrorMode) {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.prefetch = paramInt;
    this.errorMode = paramErrorMode;
  }
  
  public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, ErrorMode paramErrorMode) {
    switch (paramErrorMode) {
      default:
        return (Subscriber)new ConcatMapImmediate<T, R>(paramSubscriber, paramFunction, paramInt);
      case END:
        return (Subscriber)new ConcatMapDelayed<T, R>(paramSubscriber, paramFunction, paramInt, true);
      case BOUNDARY:
        break;
    } 
    return (Subscriber)new ConcatMapDelayed<T, R>(paramSubscriber, paramFunction, paramInt, false);
  }
  
  protected void subscribeActual(Subscriber<? super R> paramSubscriber) {
    if (FlowableScalarXMap.tryScalarXMapSubscribe((Publisher<T>)this.source, paramSubscriber, this.mapper))
      return; 
    this.source.subscribe(subscribe(paramSubscriber, this.mapper, this.prefetch, this.errorMode));
  }
  
  static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
    private static final long serialVersionUID = -3511336836796789179L;
    
    volatile boolean active;
    
    volatile boolean cancelled;
    
    int consumed;
    
    volatile boolean done;
    
    final AtomicThrowable errors;
    
    final FlowableConcatMap.ConcatMapInner<R> inner;
    
    final int limit;
    
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    
    final int prefetch;
    
    SimpleQueue<T> queue;
    
    Subscription s;
    
    int sourceMode;
    
    BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> param1Function, int param1Int) {
      this.mapper = param1Function;
      this.prefetch = param1Int;
      this.limit = param1Int - (param1Int >> 2);
      this.inner = new FlowableConcatMap.ConcatMapInner<R>(this);
      this.errors = new AtomicThrowable();
    }
    
    abstract void drain();
    
    public final void innerComplete() {
      this.active = false;
      drain();
    }
    
    public final void onComplete() {
      this.done = true;
      drain();
    }
    
    public final void onNext(T param1T) {
      if (this.sourceMode != 2 && !this.queue.offer(param1T)) {
        this.s.cancel();
        onError(new IllegalStateException("Queue full?!"));
        return;
      } 
      drain();
    }
    
    public final void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          int i = queueSubscription.requestFusion(3);
          if (i == 1) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueSubscription;
            this.done = true;
            subscribeActual();
            drain();
            return;
          } 
          if (i == 2) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueSubscription;
            subscribeActual();
            param1Subscription.request(this.prefetch);
            return;
          } 
        } 
        this.queue = (SimpleQueue<T>)new SpscArrayQueue(this.prefetch);
        subscribeActual();
        param1Subscription.request(this.prefetch);
      } 
    }
    
    abstract void subscribeActual();
  }
  
  static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = -2945777694260521066L;
    
    final Subscriber<? super R> actual;
    
    final boolean veryEnd;
    
    ConcatMapDelayed(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends Publisher<? extends R>> param1Function, int param1Int, boolean param1Boolean) {
      super(param1Function, param1Int);
      this.actual = param1Subscriber;
      this.veryEnd = param1Boolean;
    }
    
    public void cancel() {
      if (!this.cancelled) {
        this.cancelled = true;
        this.inner.cancel();
        this.s.cancel();
      } 
    }
    
    void drain() {
      if (getAndIncrement() == 0)
        while (true) {
          if (this.cancelled)
            return; 
          if (!this.active) {
            boolean bool = this.done;
            if (bool && !this.veryEnd && (Throwable)this.errors.get() != null) {
              this.actual.onError(this.errors.terminate());
              return;
            } 
            try {
              int i;
              Object object = this.queue.poll();
              if (object == null) {
                i = 1;
              } else {
                i = 0;
              } 
              if (bool && i) {
                object = this.errors.terminate();
                if (object != null) {
                  this.actual.onError((Throwable)object);
                } else {
                  this.actual.onComplete();
                } 
                return;
              } 
              if (!i)
                try {
                  object = ObjectHelper.requireNonNull(this.mapper.apply(object), "The mapper returned a null Publisher");
                  if (this.sourceMode != 1) {
                    i = this.consumed + 1;
                    if (i == this.limit) {
                      this.consumed = 0;
                      this.s.request(i);
                    } else {
                      this.consumed = i;
                    } 
                  } 
                  if (object instanceof java.util.concurrent.Callable) {
                    object = object;
                    try {
                      object = object.call();
                      if (object == null)
                        continue; 
                      if (this.inner.isUnbounded()) {
                        this.actual.onNext(object);
                        continue;
                      } 
                      this.active = true;
                      this.inner.setSubscription(new FlowableConcatMap.WeakScalarSubscription(object, (Subscriber)this.inner));
                    } catch (Throwable throwable) {
                      Exceptions.throwIfFatal(throwable);
                      this.s.cancel();
                      this.errors.addThrowable(throwable);
                      this.actual.onError(this.errors.terminate());
                      return;
                    } 
                  } else {
                    this.active = true;
                    throwable.subscribe((Subscriber)this.inner);
                  } 
                } catch (Throwable throwable) {
                  Exceptions.throwIfFatal(throwable);
                  this.s.cancel();
                  this.errors.addThrowable(throwable);
                  this.actual.onError(this.errors.terminate());
                  return;
                }  
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              this.s.cancel();
              this.errors.addThrowable(throwable);
              this.actual.onError(this.errors.terminate());
              return;
            } 
          } 
          if (decrementAndGet() == 0)
            break; 
        }  
    }
    
    public void innerError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        if (!this.veryEnd) {
          this.s.cancel();
          this.done = true;
        } 
        this.active = false;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void innerNext(R param1R) {
      this.actual.onNext(param1R);
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void request(long param1Long) {
      this.inner.request(param1Long);
    }
    
    void subscribeActual() {
      this.actual.onSubscribe(this);
    }
  }
  
  static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
    private static final long serialVersionUID = 7898995095634264146L;
    
    final Subscriber<? super R> actual;
    
    final AtomicInteger wip;
    
    ConcatMapImmediate(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends Publisher<? extends R>> param1Function, int param1Int) {
      super(param1Function, param1Int);
      this.actual = param1Subscriber;
      this.wip = new AtomicInteger();
    }
    
    public void cancel() {
      if (!this.cancelled) {
        this.cancelled = true;
        this.inner.cancel();
        this.s.cancel();
      } 
    }
    
    void drain() {
      if (this.wip.getAndIncrement() == 0)
        while (true) {
          if (this.cancelled)
            return; 
          if (!this.active) {
            boolean bool = this.done;
            try {
              int i;
              Object object = this.queue.poll();
              if (object == null) {
                i = 1;
              } else {
                i = 0;
              } 
              if (bool && i) {
                this.actual.onComplete();
                return;
              } 
              if (!i)
                try {
                  object = ObjectHelper.requireNonNull(this.mapper.apply(object), "The mapper returned a null Publisher");
                  if (this.sourceMode != 1) {
                    i = this.consumed + 1;
                    if (i == this.limit) {
                      this.consumed = 0;
                      this.s.request(i);
                    } else {
                      this.consumed = i;
                    } 
                  } 
                  if (object instanceof java.util.concurrent.Callable) {
                    object = object;
                    try {
                      object = object.call();
                      if (object == null)
                        continue; 
                      if (this.inner.isUnbounded()) {
                        if (get() == 0 && compareAndSet(0, 1)) {
                          this.actual.onNext(object);
                          if (!compareAndSet(1, 0)) {
                            this.actual.onError(this.errors.terminate());
                            return;
                          } 
                        } 
                        continue;
                      } 
                      this.active = true;
                      this.inner.setSubscription(new FlowableConcatMap.WeakScalarSubscription(object, (Subscriber)this.inner));
                    } catch (Throwable throwable) {
                      Exceptions.throwIfFatal(throwable);
                      this.s.cancel();
                      this.errors.addThrowable(throwable);
                      this.actual.onError(this.errors.terminate());
                      return;
                    } 
                  } else {
                    this.active = true;
                    throwable.subscribe((Subscriber)this.inner);
                  } 
                } catch (Throwable throwable) {
                  Exceptions.throwIfFatal(throwable);
                  this.s.cancel();
                  this.errors.addThrowable(throwable);
                  this.actual.onError(this.errors.terminate());
                  return;
                }  
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              this.s.cancel();
              this.errors.addThrowable(throwable);
              this.actual.onError(this.errors.terminate());
              return;
            } 
          } 
          if (this.wip.decrementAndGet() == 0)
            break; 
        }  
    }
    
    public void innerError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        this.s.cancel();
        if (getAndIncrement() == 0)
          this.actual.onError(this.errors.terminate()); 
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void innerNext(R param1R) {
      if (get() == 0 && compareAndSet(0, 1)) {
        this.actual.onNext(param1R);
        if (compareAndSet(1, 0))
          return; 
        this.actual.onError(this.errors.terminate());
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        this.inner.cancel();
        if (getAndIncrement() == 0)
          this.actual.onError(this.errors.terminate()); 
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void request(long param1Long) {
      this.inner.request(param1Long);
    }
    
    void subscribeActual() {
      this.actual.onSubscribe(this);
    }
  }
  
  static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
    private static final long serialVersionUID = 897683679971470653L;
    
    final FlowableConcatMap.ConcatMapSupport<R> parent;
    
    long produced;
    
    ConcatMapInner(FlowableConcatMap.ConcatMapSupport<R> param1ConcatMapSupport) {
      this.parent = param1ConcatMapSupport;
    }
    
    public void onComplete() {
      long l = this.produced;
      if (l != 0L) {
        this.produced = 0L;
        produced(l);
      } 
      this.parent.innerComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      long l = this.produced;
      if (l != 0L) {
        this.produced = 0L;
        produced(l);
      } 
      this.parent.innerError(param1Throwable);
    }
    
    public void onNext(R param1R) {
      this.produced++;
      this.parent.innerNext(param1R);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      setSubscription(param1Subscription);
    }
  }
  
  static interface ConcatMapSupport<T> {
    void innerComplete();
    
    void innerError(Throwable param1Throwable);
    
    void innerNext(T param1T);
  }
  
  static final class WeakScalarSubscription<T> implements Subscription {
    final Subscriber<? super T> actual;
    
    boolean once;
    
    final T value;
    
    WeakScalarSubscription(T param1T, Subscriber<? super T> param1Subscriber) {
      this.value = param1T;
      this.actual = param1Subscriber;
    }
    
    public void cancel() {}
    
    public void request(long param1Long) {
      if (param1Long > 0L && !this.once) {
        this.once = true;
        Subscriber<? super T> subscriber = this.actual;
        subscriber.onNext(this.value);
        subscriber.onComplete();
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */