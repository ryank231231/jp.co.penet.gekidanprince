package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T> extends AbstractFlowableWithUpstream<T, T> {
  public FlowableTakeLastOne(Flowable<T> paramFlowable) {
    super(paramFlowable);
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new TakeLastOneSubscriber<T>(paramSubscriber));
  }
  
  static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -5467847744262967226L;
    
    Subscription s;
    
    TakeLastOneSubscriber(Subscriber<? super T> param1Subscriber) {
      super(param1Subscriber);
    }
    
    public void cancel() {
      super.cancel();
      this.s.cancel();
    }
    
    public void onComplete() {
      Object object = this.value;
      if (object != null) {
        complete(object);
      } else {
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.value = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.value = param1T;
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe((Subscription)this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTakeLastOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */