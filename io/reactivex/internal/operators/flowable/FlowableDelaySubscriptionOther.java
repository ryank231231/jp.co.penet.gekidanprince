package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
  final Publisher<? extends T> main;
  
  final Publisher<U> other;
  
  public FlowableDelaySubscriptionOther(Publisher<? extends T> paramPublisher, Publisher<U> paramPublisher1) {
    this.main = paramPublisher;
    this.other = paramPublisher1;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
    paramSubscriber.onSubscribe((Subscription)subscriptionArbiter);
    DelaySubscriber delaySubscriber = new DelaySubscriber(subscriptionArbiter, paramSubscriber);
    this.other.subscribe((Subscriber)delaySubscriber);
  }
  
  final class DelaySubscriber implements FlowableSubscriber<U> {
    final Subscriber<? super T> child;
    
    boolean done;
    
    final SubscriptionArbiter serial;
    
    DelaySubscriber(SubscriptionArbiter param1SubscriptionArbiter, Subscriber<? super T> param1Subscriber) {
      this.serial = param1SubscriptionArbiter;
      this.child = param1Subscriber;
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      FlowableDelaySubscriptionOther.this.main.subscribe((Subscriber)new OnCompleteSubscriber());
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.child.onError(param1Throwable);
    }
    
    public void onNext(U param1U) {
      onComplete();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      this.serial.setSubscription(new DelaySubscription(param1Subscription));
      param1Subscription.request(Long.MAX_VALUE);
    }
    
    final class DelaySubscription implements Subscription {
      private final Subscription s;
      
      DelaySubscription(Subscription param2Subscription) {
        this.s = param2Subscription;
      }
      
      public void cancel() {
        this.s.cancel();
      }
      
      public void request(long param2Long) {}
    }
    
    final class OnCompleteSubscriber implements FlowableSubscriber<T> {
      public void onComplete() {
        FlowableDelaySubscriptionOther.DelaySubscriber.this.child.onComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        FlowableDelaySubscriptionOther.DelaySubscriber.this.child.onError(param2Throwable);
      }
      
      public void onNext(T param2T) {
        FlowableDelaySubscriptionOther.DelaySubscriber.this.child.onNext(param2T);
      }
      
      public void onSubscribe(Subscription param2Subscription) {
        FlowableDelaySubscriptionOther.DelaySubscriber.this.serial.setSubscription(param2Subscription);
      }
    }
  }
  
  final class DelaySubscription implements Subscription {
    private final Subscription s;
    
    DelaySubscription(Subscription param1Subscription) {
      this.s = param1Subscription;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void request(long param1Long) {}
  }
  
  final class OnCompleteSubscriber implements FlowableSubscriber<T> {
    public void onComplete() {
      this.this$1.child.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.this$1.child.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.this$1.child.onNext(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      this.this$1.serial.setSubscription(param1Subscription);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDelaySubscriptionOther.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */