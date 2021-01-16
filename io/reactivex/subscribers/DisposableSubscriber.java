package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {
  final AtomicReference<Subscription> s = new AtomicReference<Subscription>();
  
  protected final void cancel() {
    dispose();
  }
  
  public final void dispose() {
    SubscriptionHelper.cancel(this.s);
  }
  
  public final boolean isDisposed() {
    boolean bool;
    if (this.s.get() == SubscriptionHelper.CANCELLED) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected void onStart() {
    ((Subscription)this.s.get()).request(Long.MAX_VALUE);
  }
  
  public final void onSubscribe(Subscription paramSubscription) {
    if (EndConsumerHelper.setOnce(this.s, paramSubscription, getClass()))
      onStart(); 
  }
  
  protected final void request(long paramLong) {
    ((Subscription)this.s.get()).request(paramLong);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\subscribers\DisposableSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */