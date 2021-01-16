package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {
  final BiFunction<T, T, T> accumulator;
  
  public FlowableScan(Flowable<T> paramFlowable, BiFunction<T, T, T> paramBiFunction) {
    super(paramFlowable);
    this.accumulator = paramBiFunction;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new ScanSubscriber<T>(paramSubscriber, this.accumulator));
  }
  
  static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final BiFunction<T, T, T> accumulator;
    
    final Subscriber<? super T> actual;
    
    boolean done;
    
    Subscription s;
    
    T value;
    
    ScanSubscriber(Subscriber<? super T> param1Subscriber, BiFunction<T, T, T> param1BiFunction) {
      this.actual = param1Subscriber;
      this.accumulator = param1BiFunction;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      Subscriber<? super T> subscriber = this.actual;
      T t = this.value;
      if (t == null) {
        this.value = param1T;
        subscriber.onNext(param1T);
      } else {
        try {
          param1T = (T)ObjectHelper.requireNonNull(this.accumulator.apply(t, param1T), "The value returned by the accumulator is null");
          this.value = param1T;
          subscriber.onNext(param1T);
          return;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.s.cancel();
          onError(throwable);
          return;
        } 
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      this.s.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */