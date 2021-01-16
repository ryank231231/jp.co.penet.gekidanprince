package io.reactivex.internal.operators.observable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {
  final Publisher<? extends T> source;
  
  public ObservableFromPublisher(Publisher<? extends T> paramPublisher) {
    this.source = paramPublisher;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe((Subscriber)new PublisherSubscriber<T>(paramObserver));
  }
  
  static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final Observer<? super T> actual;
    
    Subscription s;
    
    PublisherSubscriber(Observer<? super T> param1Observer) {
      this.actual = param1Observer;
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
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFromPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */