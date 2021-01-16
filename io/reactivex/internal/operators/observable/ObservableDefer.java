package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableDefer<T> extends Observable<T> {
  final Callable<? extends ObservableSource<? extends T>> supplier;
  
  public ObservableDefer(Callable<? extends ObservableSource<? extends T>> paramCallable) {
    this.supplier = paramCallable;
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    try {
      ObservableSource observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.supplier.call(), "null ObservableSource supplied");
      observableSource.subscribe(paramObserver);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramObserver);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */