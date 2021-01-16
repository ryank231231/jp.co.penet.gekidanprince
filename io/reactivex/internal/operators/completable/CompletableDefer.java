package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class CompletableDefer extends Completable {
  final Callable<? extends CompletableSource> completableSupplier;
  
  public CompletableDefer(Callable<? extends CompletableSource> paramCallable) {
    this.completableSupplier = paramCallable;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    try {
      CompletableSource completableSource = (CompletableSource)ObjectHelper.requireNonNull(this.completableSupplier.call(), "The completableSupplier returned a null CompletableSource");
      completableSource.subscribe(paramCompletableObserver);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramCompletableObserver);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */