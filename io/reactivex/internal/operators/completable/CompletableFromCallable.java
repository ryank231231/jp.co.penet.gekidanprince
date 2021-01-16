package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

public final class CompletableFromCallable extends Completable {
  final Callable<?> callable;
  
  public CompletableFromCallable(Callable<?> paramCallable) {
    this.callable = paramCallable;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    Disposable disposable = Disposables.empty();
    paramCompletableObserver.onSubscribe(disposable);
    try {
      this.callable.call();
      if (!disposable.isDisposed())
        paramCompletableObserver.onComplete(); 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      if (!disposable.isDisposed())
        paramCompletableObserver.onError(throwable); 
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableFromCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */