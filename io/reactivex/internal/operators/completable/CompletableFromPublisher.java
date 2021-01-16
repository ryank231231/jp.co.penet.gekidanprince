package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class CompletableFromPublisher<T> extends Completable {
  final Publisher<T> flowable;
  
  public CompletableFromPublisher(Publisher<T> paramPublisher) {
    this.flowable = paramPublisher;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.flowable.subscribe((Subscriber)new FromPublisherSubscriber(paramCompletableObserver));
  }
  
  static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final CompletableObserver cs;
    
    Subscription s;
    
    FromPublisherSubscriber(CompletableObserver param1CompletableObserver) {
      this.cs = param1CompletableObserver;
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
      this.cs.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.cs.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {}
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.cs.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableFromPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */