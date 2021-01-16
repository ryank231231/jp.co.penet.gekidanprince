package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableLastMaybe<T> extends Maybe<T> {
  final Publisher<T> source;
  
  public FlowableLastMaybe(Publisher<T> paramPublisher) {
    this.source = paramPublisher;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe((Subscriber)new LastSubscriber<T>(paramMaybeObserver));
  }
  
  static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    T item;
    
    Subscription s;
    
    LastSubscriber(MaybeObserver<? super T> param1MaybeObserver) {
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
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      T t = this.item;
      if (t != null) {
        this.item = null;
        this.actual.onSuccess(t);
      } else {
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.item = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.item = param1T;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableLastMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */