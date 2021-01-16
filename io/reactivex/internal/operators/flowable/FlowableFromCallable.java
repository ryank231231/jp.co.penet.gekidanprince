package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {
  final Callable<? extends T> callable;
  
  public FlowableFromCallable(Callable<? extends T> paramCallable) {
    this.callable = paramCallable;
  }
  
  public T call() throws Exception {
    return (T)ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(paramSubscriber);
    paramSubscriber.onSubscribe((Subscription)deferredScalarSubscription);
    try {
      Object object = ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
      deferredScalarSubscription.complete(object);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      paramSubscriber.onError(throwable);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFromCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */