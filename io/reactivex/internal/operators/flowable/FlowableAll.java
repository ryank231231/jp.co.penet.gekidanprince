package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAll<T> extends AbstractFlowableWithUpstream<T, Boolean> {
  final Predicate<? super T> predicate;
  
  public FlowableAll(Flowable<T> paramFlowable, Predicate<? super T> paramPredicate) {
    super(paramFlowable);
    this.predicate = paramPredicate;
  }
  
  protected void subscribeActual(Subscriber<? super Boolean> paramSubscriber) {
    this.source.subscribe(new AllSubscriber<T>(paramSubscriber, this.predicate));
  }
  
  static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3521127104134758517L;
    
    boolean done;
    
    final Predicate<? super T> predicate;
    
    Subscription s;
    
    AllSubscriber(Subscriber<? super Boolean> param1Subscriber, Predicate<? super T> param1Predicate) {
      super(param1Subscriber);
      this.predicate = param1Predicate;
    }
    
    public void cancel() {
      super.cancel();
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      complete(Boolean.valueOf(true));
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
      try {
        boolean bool = this.predicate.test(param1T);
        if (!bool) {
          this.done = true;
          this.s.cancel();
          complete(Boolean.valueOf(false));
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.cancel();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe((Subscription)this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */