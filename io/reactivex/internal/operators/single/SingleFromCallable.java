package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T> extends Single<T> {
  final Callable<? extends T> callable;
  
  public SingleFromCallable(Callable<? extends T> paramCallable) {
    this.callable = paramCallable;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    Disposable disposable = Disposables.empty();
    paramSingleObserver.onSubscribe(disposable);
    if (disposable.isDisposed())
      return; 
    try {
      Object object = ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
      if (!disposable.isDisposed())
        paramSingleObserver.onSuccess(object); 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      if (!disposable.isDisposed()) {
        paramSingleObserver.onError(throwable);
      } else {
        RxJavaPlugins.onError(throwable);
      } 
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFromCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */