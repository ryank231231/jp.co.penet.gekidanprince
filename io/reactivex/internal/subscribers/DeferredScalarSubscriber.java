package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
  private static final long serialVersionUID = 2984505488220891551L;
  
  protected boolean hasValue;
  
  protected Subscription s;
  
  public DeferredScalarSubscriber(Subscriber<? super R> paramSubscriber) {
    super(paramSubscriber);
  }
  
  public void cancel() {
    super.cancel();
    this.s.cancel();
  }
  
  public void onComplete() {
    if (this.hasValue) {
      complete(this.value);
    } else {
      this.actual.onComplete();
    } 
  }
  
  public void onError(Throwable paramThrowable) {
    this.value = null;
    this.actual.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription) {
    if (SubscriptionHelper.validate(this.s, paramSubscription)) {
      this.s = paramSubscription;
      this.actual.onSubscribe((Subscription)this);
      paramSubscription.request(Long.MAX_VALUE);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\DeferredScalarSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */