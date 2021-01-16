package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
  final long count;
  
  final Predicate<? super Throwable> predicate;
  
  public FlowableRetryPredicate(Flowable<T> paramFlowable, long paramLong, Predicate<? super Throwable> paramPredicate) {
    super(paramFlowable);
    this.predicate = paramPredicate;
    this.count = paramLong;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
    paramSubscriber.onSubscribe((Subscription)subscriptionArbiter);
    (new RetrySubscriber(paramSubscriber, this.count, this.predicate, subscriptionArbiter, (Publisher<?>)this.source)).subscribeNext();
  }
  
  static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    
    final Subscriber<? super T> actual;
    
    final Predicate<? super Throwable> predicate;
    
    long produced;
    
    long remaining;
    
    final SubscriptionArbiter sa;
    
    final Publisher<? extends T> source;
    
    RetrySubscriber(Subscriber<? super T> param1Subscriber, long param1Long, Predicate<? super Throwable> param1Predicate, SubscriptionArbiter param1SubscriptionArbiter, Publisher<? extends T> param1Publisher) {
      this.actual = param1Subscriber;
      this.sa = param1SubscriptionArbiter;
      this.source = param1Publisher;
      this.predicate = param1Predicate;
      this.remaining = param1Long;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      long l = this.remaining;
      if (l != Long.MAX_VALUE)
        this.remaining = l - 1L; 
      if (l == 0L) {
        this.actual.onError(param1Throwable);
      } else {
        try {
          boolean bool = this.predicate.test(param1Throwable);
          if (!bool) {
            this.actual.onError(param1Throwable);
            return;
          } 
          subscribeNext();
          return;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
          return;
        } 
      } 
    }
    
    public void onNext(T param1T) {
      this.produced++;
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      this.sa.setSubscription(param1Subscription);
    }
    
    void subscribeNext() {
      if (getAndIncrement() == 0) {
        int j;
        int i = 1;
        do {
          if (this.sa.isCancelled())
            return; 
          long l = this.produced;
          if (l != 0L) {
            this.produced = 0L;
            this.sa.produced(l);
          } 
          this.source.subscribe((Subscriber)this);
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRetryPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */