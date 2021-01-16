package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
  private Subscription s;
  
  protected final void cancel() {
    Subscription subscription = this.s;
    this.s = (Subscription)SubscriptionHelper.CANCELLED;
    subscription.cancel();
  }
  
  protected void onStart() {
    request(Long.MAX_VALUE);
  }
  
  public final void onSubscribe(Subscription paramSubscription) {
    if (EndConsumerHelper.validate(this.s, paramSubscription, getClass())) {
      this.s = paramSubscription;
      onStart();
    } 
  }
  
  protected final void request(long paramLong) {
    Subscription subscription = this.s;
    if (subscription != null)
      subscription.request(paramLong); 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\subscribers\DefaultSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */