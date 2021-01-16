package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {
  final T defaultItem;
  
  final Publisher<T> source;
  
  public FlowableLastSingle(Publisher<T> paramPublisher, T paramT) {
    this.source = paramPublisher;
    this.defaultItem = paramT;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe((Subscriber)new LastSubscriber<T>(paramSingleObserver, this.defaultItem));
  }
  
  static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    final T defaultItem;
    
    T item;
    
    Subscription s;
    
    LastSubscriber(SingleObserver<? super T> param1SingleObserver, T param1T) {
      this.actual = param1SingleObserver;
      this.defaultItem = param1T;
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
        t = this.defaultItem;
        if (t != null) {
          this.actual.onSuccess(t);
        } else {
          this.actual.onError(new NoSuchElementException());
        } 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableLastSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */