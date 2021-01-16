package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {
  public FlowableOnBackpressureError(Flowable<T> paramFlowable) {
    super(paramFlowable);
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new BackpressureErrorSubscriber<T>(paramSubscriber));
  }
  
  static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -3176480756392482682L;
    
    final Subscriber<? super T> actual;
    
    boolean done;
    
    Subscription s;
    
    BackpressureErrorSubscriber(Subscriber<? super T> param1Subscriber) {
      this.actual = param1Subscriber;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (get() != 0L) {
        this.actual.onNext(param1T);
        BackpressureHelper.produced(this, 1L);
      } else {
        onError((Throwable)new MissingBackpressureException("could not emit value due to lack of requests"));
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long))
        BackpressureHelper.add(this, param1Long); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnBackpressureError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */