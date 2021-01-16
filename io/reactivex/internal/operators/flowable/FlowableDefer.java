package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableDefer<T> extends Flowable<T> {
  final Callable<? extends Publisher<? extends T>> supplier;
  
  public FlowableDefer(Callable<? extends Publisher<? extends T>> paramCallable) {
    this.supplier = paramCallable;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    try {
      Publisher publisher = (Publisher)ObjectHelper.requireNonNull(this.supplier.call(), "The publisher supplied is null");
      publisher.subscribe(paramSubscriber);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptySubscription.error(throwable, paramSubscriber);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */