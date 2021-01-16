package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {
  final Callable<? extends T> callable;
  
  public ObservableFromCallable(Callable<? extends T> paramCallable) {
    this.callable = paramCallable;
  }
  
  public T call() throws Exception {
    return (T)ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
  }
  
  public void subscribeActual(Observer<? super T> paramObserver) {
    DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(paramObserver);
    paramObserver.onSubscribe((Disposable)deferredScalarDisposable);
    if (deferredScalarDisposable.isDisposed())
      return; 
    try {
      Object object = ObjectHelper.requireNonNull(this.callable.call(), "Callable returned null");
      deferredScalarDisposable.complete(object);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      if (!deferredScalarDisposable.isDisposed()) {
        paramObserver.onError(throwable);
      } else {
        RxJavaPlugins.onError(throwable);
      } 
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFromCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */