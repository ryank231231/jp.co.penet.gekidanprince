package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class SingleDefer<T> extends Single<T> {
  final Callable<? extends SingleSource<? extends T>> singleSupplier;
  
  public SingleDefer(Callable<? extends SingleSource<? extends T>> paramCallable) {
    this.singleSupplier = paramCallable;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    try {
      SingleSource singleSource = (SingleSource)ObjectHelper.requireNonNull(this.singleSupplier.call(), "The singleSupplier returned a null SingleSource");
      singleSource.subscribe(paramSingleObserver);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramSingleObserver);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */