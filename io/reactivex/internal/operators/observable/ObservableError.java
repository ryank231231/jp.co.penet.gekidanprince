package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableError<T> extends Observable<T> {
  final Callable<? extends Throwable> errorSupplier;
  
  public ObservableError(Callable<? extends Throwable> paramCallable) {
    this.errorSupplier = paramCallable;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    try {
      throwable = (Throwable)ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
    } 
    EmptyDisposable.error(throwable, paramObserver);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */