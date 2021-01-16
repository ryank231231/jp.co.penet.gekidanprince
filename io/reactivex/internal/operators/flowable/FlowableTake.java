package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
  final long limit;
  
  public FlowableTake(Flowable<T> paramFlowable, long paramLong) {
    super(paramFlowable);
    this.limit = paramLong;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new TakeSubscriber<T>(paramSubscriber, this.limit));
  }
  
  static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -5636543848937116287L;
    
    final Subscriber<? super T> actual;
    
    boolean done;
    
    final long limit;
    
    long remaining;
    
    Subscription subscription;
    
    TakeSubscriber(Subscriber<? super T> param1Subscriber, long param1Long) {
      this.actual = param1Subscriber;
      this.limit = param1Long;
      this.remaining = param1Long;
    }
    
    public void cancel() {
      this.subscription.cancel();
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (!this.done) {
        this.done = true;
        this.subscription.cancel();
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (!this.done) {
        long l = this.remaining;
        this.remaining = l - 1L;
        if (l > 0L) {
          boolean bool;
          if (this.remaining == 0L) {
            bool = true;
          } else {
            bool = false;
          } 
          this.actual.onNext(param1T);
          if (bool) {
            this.subscription.cancel();
            onComplete();
          } 
        } 
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.subscription, param1Subscription)) {
        this.subscription = param1Subscription;
        if (this.limit == 0L) {
          param1Subscription.cancel();
          this.done = true;
          EmptySubscription.complete(this.actual);
        } else {
          this.actual.onSubscribe(this);
        } 
      } 
    }
    
    public void request(long param1Long) {
      if (!SubscriptionHelper.validate(param1Long))
        return; 
      if (!get() && compareAndSet(false, true) && param1Long >= this.limit) {
        this.subscription.request(Long.MAX_VALUE);
        return;
      } 
      this.subscription.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */