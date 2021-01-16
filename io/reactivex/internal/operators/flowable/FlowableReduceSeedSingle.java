package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R> extends Single<R> {
  final BiFunction<R, ? super T, R> reducer;
  
  final R seed;
  
  final Publisher<T> source;
  
  public FlowableReduceSeedSingle(Publisher<T> paramPublisher, R paramR, BiFunction<R, ? super T, R> paramBiFunction) {
    this.source = paramPublisher;
    this.seed = paramR;
    this.reducer = paramBiFunction;
  }
  
  protected void subscribeActual(SingleObserver<? super R> paramSingleObserver) {
    this.source.subscribe((Subscriber)new ReduceSeedObserver<T, R>(paramSingleObserver, this.reducer, this.seed));
  }
  
  static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super R> actual;
    
    final BiFunction<R, ? super T, R> reducer;
    
    Subscription s;
    
    R value;
    
    ReduceSeedObserver(SingleObserver<? super R> param1SingleObserver, BiFunction<R, ? super T, R> param1BiFunction, R param1R) {
      this.actual = param1SingleObserver;
      this.value = param1R;
      this.reducer = param1BiFunction;
    }
    
    public void dispose() {
      this.s.cancel();
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (this.s == SubscriptionHelper.CANCELLED) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      R r = this.value;
      if (r != null) {
        this.value = null;
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        this.actual.onSuccess(r);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.value != null) {
        this.value = null;
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      R r = this.value;
      if (r != null)
        try {
          this.value = (R)ObjectHelper.requireNonNull(this.reducer.apply(r, param1T), "The reducer returned a null value");
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.s.cancel();
          onError(throwable);
        }  
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableReduceSeedSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */