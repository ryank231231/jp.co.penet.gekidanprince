package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {
  final long n;
  
  public FlowableSkip(Flowable<T> paramFlowable, long paramLong) {
    super(paramFlowable);
    this.n = paramLong;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new SkipSubscriber<T>(paramSubscriber, this.n));
  }
  
  static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> actual;
    
    long remaining;
    
    Subscription s;
    
    SkipSubscriber(Subscriber<? super T> param1Subscriber, long param1Long) {
      this.actual = param1Subscriber;
      this.remaining = param1Long;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      long l = this.remaining;
      if (l != 0L) {
        this.remaining = l - 1L;
      } else {
        this.actual.onNext(param1T);
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        long l = this.remaining;
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        param1Subscription.request(l);
      } 
    }
    
    public void request(long param1Long) {
      this.s.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSkip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */