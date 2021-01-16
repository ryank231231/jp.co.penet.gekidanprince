package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromFuture<T> extends Flowable<T> {
  final Future<? extends T> future;
  
  final long timeout;
  
  final TimeUnit unit;
  
  public FlowableFromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit) {
    this.future = paramFuture;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(paramSubscriber);
    paramSubscriber.onSubscribe((Subscription)deferredScalarSubscription);
    try {
      T t;
      if (this.unit != null) {
        T t1 = this.future.get(this.timeout, this.unit);
      } else {
        t = this.future.get();
      } 
      if (t == null) {
        paramSubscriber.onError(new NullPointerException("The future returned null"));
      } else {
        deferredScalarSubscription.complete(t);
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      if (!deferredScalarSubscription.isCancelled())
        paramSubscriber.onError(throwable); 
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFromFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */