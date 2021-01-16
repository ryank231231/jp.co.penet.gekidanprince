package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
  final Predicate<? super T> predicate;
  
  public FlowableSkipWhile(Flowable<T> paramFlowable, Predicate<? super T> paramPredicate) {
    super(paramFlowable);
    this.predicate = paramPredicate;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new SkipWhileSubscriber<T>(paramSubscriber, this.predicate));
  }
  
  static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> actual;
    
    boolean notSkipping;
    
    final Predicate<? super T> predicate;
    
    Subscription s;
    
    SkipWhileSubscriber(Subscriber<? super T> param1Subscriber, Predicate<? super T> param1Predicate) {
      this.actual = param1Subscriber;
      this.predicate = param1Predicate;
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
      if (this.notSkipping) {
        this.actual.onNext(param1T);
      } else {
        try {
          boolean bool = this.predicate.test(param1T);
          if (bool) {
            this.s.request(1L);
          } else {
            this.notSkipping = true;
            this.actual.onNext(param1T);
          } 
          return;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.s.cancel();
          this.actual.onError(throwable);
          return;
        } 
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSkipWhile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */