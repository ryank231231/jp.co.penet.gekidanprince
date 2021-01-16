package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
  final Flowable<T> source;
  
  public FlowableSingleMaybe(Flowable<T> paramFlowable) {
    this.source = paramFlowable;
  }
  
  public Flowable<T> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableSingle<T>(this.source, null, false));
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new SingleElementSubscriber<T>(paramMaybeObserver));
  }
  
  static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    boolean done;
    
    Subscription s;
    
    T value;
    
    SingleElementSubscriber(MaybeObserver<? super T> param1MaybeObserver) {
      this.actual = param1MaybeObserver;
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
      if (this.done)
        return; 
      this.done = true;
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      T t = this.value;
      this.value = null;
      if (t == null) {
        this.actual.onComplete();
      } else {
        this.actual.onSuccess(t);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.value != null) {
        this.done = true;
        this.s.cancel();
        this.s = (Subscription)SubscriptionHelper.CANCELLED;
        this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
      } 
      this.value = param1T;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSingleMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */