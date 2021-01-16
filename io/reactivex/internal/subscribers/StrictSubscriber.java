package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
  private static final long serialVersionUID = -4945028590049415624L;
  
  final Subscriber<? super T> actual;
  
  volatile boolean done;
  
  final AtomicThrowable error;
  
  final AtomicBoolean once;
  
  final AtomicLong requested;
  
  final AtomicReference<Subscription> s;
  
  public StrictSubscriber(Subscriber<? super T> paramSubscriber) {
    this.actual = paramSubscriber;
    this.error = new AtomicThrowable();
    this.requested = new AtomicLong();
    this.s = new AtomicReference<Subscription>();
    this.once = new AtomicBoolean();
  }
  
  public void cancel() {
    if (!this.done)
      SubscriptionHelper.cancel(this.s); 
  }
  
  public void onComplete() {
    this.done = true;
    HalfSerializer.onComplete(this.actual, this, this.error);
  }
  
  public void onError(Throwable paramThrowable) {
    this.done = true;
    HalfSerializer.onError(this.actual, paramThrowable, this, this.error);
  }
  
  public void onNext(T paramT) {
    HalfSerializer.onNext(this.actual, paramT, this, this.error);
  }
  
  public void onSubscribe(Subscription paramSubscription) {
    if (this.once.compareAndSet(false, true)) {
      this.actual.onSubscribe(this);
      SubscriptionHelper.deferredSetOnce(this.s, this.requested, paramSubscription);
    } else {
      paramSubscription.cancel();
      cancel();
      onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    } 
  }
  
  public void request(long paramLong) {
    if (paramLong <= 0L) {
      cancel();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("§3.9 violated: positive request amount required but it was ");
      stringBuilder.append(paramLong);
      onError(new IllegalArgumentException(stringBuilder.toString()));
    } else {
      SubscriptionHelper.deferredRequest(this.s, this.requested, paramLong);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\StrictSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */