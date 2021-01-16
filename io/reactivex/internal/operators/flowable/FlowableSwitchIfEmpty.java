package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
  final Publisher<? extends T> other;
  
  public FlowableSwitchIfEmpty(Flowable<T> paramFlowable, Publisher<? extends T> paramPublisher) {
    super(paramFlowable);
    this.other = paramPublisher;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    SwitchIfEmptySubscriber<T> switchIfEmptySubscriber = new SwitchIfEmptySubscriber<T>(paramSubscriber, this.other);
    paramSubscriber.onSubscribe((Subscription)switchIfEmptySubscriber.arbiter);
    this.source.subscribe(switchIfEmptySubscriber);
  }
  
  static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
    final Subscriber<? super T> actual;
    
    final SubscriptionArbiter arbiter;
    
    boolean empty;
    
    final Publisher<? extends T> other;
    
    SwitchIfEmptySubscriber(Subscriber<? super T> param1Subscriber, Publisher<? extends T> param1Publisher) {
      this.actual = param1Subscriber;
      this.other = param1Publisher;
      this.empty = true;
      this.arbiter = new SubscriptionArbiter();
    }
    
    public void onComplete() {
      if (this.empty) {
        this.empty = false;
        this.other.subscribe((Subscriber)this);
      } else {
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.empty)
        this.empty = false; 
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      this.arbiter.setSubscription(param1Subscription);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSwitchIfEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */