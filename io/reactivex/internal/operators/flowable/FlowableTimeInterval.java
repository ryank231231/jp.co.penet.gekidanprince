package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {
  final Scheduler scheduler;
  
  final TimeUnit unit;
  
  public FlowableTimeInterval(Flowable<T> paramFlowable, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    super(paramFlowable);
    this.scheduler = paramScheduler;
    this.unit = paramTimeUnit;
  }
  
  protected void subscribeActual(Subscriber<? super Timed<T>> paramSubscriber) {
    this.source.subscribe(new TimeIntervalSubscriber<T>(paramSubscriber, this.unit, this.scheduler));
  }
  
  static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super Timed<T>> actual;
    
    long lastTime;
    
    Subscription s;
    
    final Scheduler scheduler;
    
    final TimeUnit unit;
    
    TimeIntervalSubscriber(Subscriber<? super Timed<T>> param1Subscriber, TimeUnit param1TimeUnit, Scheduler param1Scheduler) {
      this.actual = param1Subscriber;
      this.scheduler = param1Scheduler;
      this.unit = param1TimeUnit;
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
      long l1 = this.scheduler.now(this.unit);
      long l2 = this.lastTime;
      this.lastTime = l1;
      this.actual.onNext(new Timed(param1T, l1 - l2, this.unit));
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.lastTime = this.scheduler.now(this.unit);
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      this.s.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */