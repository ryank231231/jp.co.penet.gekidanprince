package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
  final Callable<? extends T> callable;
  
  public MaybeFromCallable(Callable<? extends T> paramCallable) {
    this.callable = paramCallable;
  }
  
  public T call() throws Exception {
    return this.callable.call();
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    Disposable disposable = Disposables.empty();
    paramMaybeObserver.onSubscribe(disposable);
    if (!disposable.isDisposed())
      try {
        T t = this.callable.call();
        if (!disposable.isDisposed())
          if (t == null) {
            paramMaybeObserver.onComplete();
          } else {
            paramMaybeObserver.onSuccess(t);
          }  
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        if (!disposable.isDisposed()) {
          paramMaybeObserver.onError(throwable);
        } else {
          RxJavaPlugins.onError(throwable);
        } 
        return;
      }  
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */