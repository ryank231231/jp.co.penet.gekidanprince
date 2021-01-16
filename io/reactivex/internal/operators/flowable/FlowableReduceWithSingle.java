package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableReduceWithSingle<T, R> extends Single<R> {
  final BiFunction<R, ? super T, R> reducer;
  
  final Callable<R> seedSupplier;
  
  final Publisher<T> source;
  
  public FlowableReduceWithSingle(Publisher<T> paramPublisher, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction) {
    this.source = paramPublisher;
    this.seedSupplier = paramCallable;
    this.reducer = paramBiFunction;
  }
  
  protected void subscribeActual(SingleObserver<? super R> paramSingleObserver) {
    try {
      Object object = ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seedSupplier returned a null value");
      this.source.subscribe((Subscriber)new FlowableReduceSeedSingle.ReduceSeedObserver<T, R>(paramSingleObserver, this.reducer, (R)object));
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramSingleObserver);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableReduceWithSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */