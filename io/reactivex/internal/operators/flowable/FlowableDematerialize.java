package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDematerialize<T> extends AbstractFlowableWithUpstream<Notification<T>, T> {
  public FlowableDematerialize(Flowable<Notification<T>> paramFlowable) {
    super(paramFlowable);
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new DematerializeSubscriber<T>(paramSubscriber));
  }
  
  static final class DematerializeSubscriber<T> implements FlowableSubscriber<Notification<T>>, Subscription {
    final Subscriber<? super T> actual;
    
    boolean done;
    
    Subscription s;
    
    DematerializeSubscriber(Subscriber<? super T> param1Subscriber) {
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
    
    public void onNext(Notification<T> param1Notification) {
      if (this.done) {
        if (param1Notification.isOnError())
          RxJavaPlugins.onError(param1Notification.getError()); 
        return;
      } 
      if (param1Notification.isOnError()) {
        this.s.cancel();
        onError(param1Notification.getError());
      } else if (param1Notification.isOnComplete()) {
        this.s.cancel();
        onComplete();
      } else {
        this.actual.onNext(param1Notification.getValue());
      } 
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
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDematerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */