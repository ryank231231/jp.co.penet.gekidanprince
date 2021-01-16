package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableError<T> extends Flowable<T> {
  final Callable<? extends Throwable> errorSupplier;
  
  public FlowableError(Callable<? extends Throwable> paramCallable) {
    this.errorSupplier = paramCallable;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    try {
      throwable = (Throwable)ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
    } 
    EmptySubscription.error(throwable, paramSubscriber);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */