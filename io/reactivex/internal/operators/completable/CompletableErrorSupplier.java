package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class CompletableErrorSupplier extends Completable {
  final Callable<? extends Throwable> errorSupplier;
  
  public CompletableErrorSupplier(Callable<? extends Throwable> paramCallable) {
    this.errorSupplier = paramCallable;
  }
  
  protected void subscribeActual(CompletableObserver paramCompletableObserver) {
    try {
      throwable = (Throwable)ObjectHelper.requireNonNull(this.errorSupplier.call(), "The error returned is null");
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
    } 
    EmptyDisposable.error(throwable, paramCompletableObserver);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableErrorSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */