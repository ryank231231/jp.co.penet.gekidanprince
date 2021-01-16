package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
  final BiPredicate<? super Integer, ? super Throwable> predicate;
  
  public FlowableRetryBiPredicate(Flowable<T> paramFlowable, BiPredicate<? super Integer, ? super Throwable> paramBiPredicate) {
    super(paramFlowable);
    this.predicate = paramBiPredicate;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
    paramSubscriber.onSubscribe((Subscription)subscriptionArbiter);
    (new RetryBiSubscriber(paramSubscriber, this.predicate, subscriptionArbiter, (Publisher<?>)this.source)).subscribeNext();
  }
  
  static final class RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    
    final Subscriber<? super T> actual;
    
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    
    long produced;
    
    int retries;
    
    final SubscriptionArbiter sa;
    
    final Publisher<? extends T> source;
    
    RetryBiSubscriber(Subscriber<? super T> param1Subscriber, BiPredicate<? super Integer, ? super Throwable> param1BiPredicate, SubscriptionArbiter param1SubscriptionArbiter, Publisher<? extends T> param1Publisher) {
      this.actual = param1Subscriber;
      this.sa = param1SubscriptionArbiter;
      this.source = param1Publisher;
      this.predicate = param1BiPredicate;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        BiPredicate<? super Integer, ? super Throwable> biPredicate = this.predicate;
        int i = this.retries + 1;
        this.retries = i;
        boolean bool = biPredicate.test(Integer.valueOf(i), param1Throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRetryBiPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */