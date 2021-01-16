package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
  static final long COMPLETE_MASK = -9223372036854775808L;
  
  static final long REQUEST_MASK = 9223372036854775807L;
  
  private static final long serialVersionUID = 7917814472626990048L;
  
  protected final Subscriber<? super R> actual;
  
  protected long produced;
  
  protected Subscription s;
  
  protected R value;
  
  public SinglePostCompleteSubscriber(Subscriber<? super R> paramSubscriber) {
    this.actual = paramSubscriber;
  }
  
  public void cancel() {
    this.s.cancel();
  }
  
  protected final void complete(R paramR) {
    long l = this.produced;
    if (l != 0L)
      BackpressureHelper.produced(this, l); 
    while (true) {
      l = get();
      if ((l & Long.MIN_VALUE) != 0L) {
        onDrop(paramR);
        return;
      } 
      if ((l & Long.MAX_VALUE) != 0L) {
        lazySet(-9223372036854775807L);
        this.actual.onNext(paramR);
        this.actual.onComplete();
        return;
      } 
      this.value = paramR;
      if (compareAndSet(0L, Long.MIN_VALUE))
        return; 
      this.value = null;
    } 
  }
  
  protected void onDrop(R paramR) {}
  
  public void onSubscribe(Subscription paramSubscription) {
    if (SubscriptionHelper.validate(this.s, paramSubscription)) {
      this.s = paramSubscription;
      this.actual.onSubscribe(this);
    } 
  }
  
  public final void request(long paramLong) {
    if (SubscriptionHelper.validate(paramLong))
      while (true) {
        long l = get();
        if ((l & Long.MIN_VALUE) != 0L) {
          if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
            this.actual.onNext(this.value);
            this.actual.onComplete();
          } 
          break;
        } 
        if (compareAndSet(l, BackpressureHelper.addCap(l, paramLong))) {
          this.s.request(paramLong);
          break;
        } 
      }  
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\SinglePostCompleteSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */