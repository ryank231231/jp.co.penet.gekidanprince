package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {
  public FlowableDetach(Flowable<T> paramFlowable) {
    super(paramFlowable);
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new DetachSubscriber<T>(paramSubscriber));
  }
  
  static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    Subscriber<? super T> actual;
    
    Subscription s;
    
    DetachSubscriber(Subscriber<? super T> param1Subscriber) {
      this.actual = param1Subscriber;
    }
    
    public void cancel() {
      Subscription subscription = this.s;
      this.s = (Subscription)EmptyComponent.INSTANCE;
      this.actual = EmptyComponent.asSubscriber();
      subscription.cancel();
    }
    
    public void onComplete() {
      Subscriber<? super T> subscriber = this.actual;
      this.s = (Subscription)EmptyComponent.INSTANCE;
      this.actual = EmptyComponent.asSubscriber();
      subscriber.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      Subscriber<? super T> subscriber = this.actual;
      this.s = (Subscription)EmptyComponent.INSTANCE;
      this.actual = EmptyComponent.asSubscriber();
      subscriber.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDetach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */