package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
  final Scheduler scheduler;
  
  public FlowableUnsubscribeOn(Flowable<T> paramFlowable, Scheduler paramScheduler) {
    super(paramFlowable);
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new UnsubscribeSubscriber<T>(paramSubscriber, this.scheduler));
  }
  
  static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 1015244841293359600L;
    
    final Subscriber<? super T> actual;
    
    Subscription s;
    
    final Scheduler scheduler;
    
    UnsubscribeSubscriber(Subscriber<? super T> param1Subscriber, Scheduler param1Scheduler) {
      this.actual = param1Subscriber;
      this.scheduler = param1Scheduler;
    }
    
    public void cancel() {
      if (compareAndSet(false, true))
        this.scheduler.scheduleDirect(new Cancellation()); 
    }
    
    public void onComplete() {
      if (!get())
        this.actual.onComplete(); 
    }
    
    public void onError(Throwable param1Throwable) {
      if (get()) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (!get())
        this.actual.onNext(param1T); 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      this.s.request(param1Long);
    }
    
    final class Cancellation implements Runnable {
      public void run() {
        FlowableUnsubscribeOn.UnsubscribeSubscriber.this.s.cancel();
      }
    }
  }
  
  final class Cancellation implements Runnable {
    public void run() {
      this.this$0.s.cancel();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableUnsubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */