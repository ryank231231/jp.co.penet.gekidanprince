package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;

public final class CompletableFromRunnable extends Completable {
  final Runnable runnable;
  
  public CompletableFromRunnable(Runnable paramRunnable) {
    this.runnable = paramRunnable;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    Disposable disposable = Disposables.empty();
    paramCompletableObserver.onSubscribe(disposable);
    try {
      this.runnable.run();
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableFromRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */