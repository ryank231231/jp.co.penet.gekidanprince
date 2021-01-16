package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {
  final Flowable<T> source;
  
  public FlowableIgnoreElementsCompletable(Flowable<T> paramFlowable) {
    this.source = paramFlowable;
  }
  
  public Flowable<T> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableIgnoreElements<T>(this.source));
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.source.subscribe(new IgnoreElementsSubscriber(paramCompletableObserver));
  }
  
  static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final CompletableObserver actual;
    
    Subscription s;
    
    IgnoreElementsSubscriber(CompletableObserver param1CompletableObserver) {
      this.actual = param1CompletableObserver;
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
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {}
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableIgnoreElementsCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */