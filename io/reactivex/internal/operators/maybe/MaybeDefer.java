package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class MaybeDefer<T> extends Maybe<T> {
  final Callable<? extends MaybeSource<? extends T>> maybeSupplier;
  
  public MaybeDefer(Callable<? extends MaybeSource<? extends T>> paramCallable) {
    this.maybeSupplier = paramCallable;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    try {
      MaybeSource maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.maybeSupplier.call(), "The maybeSupplier returned a null MaybeSource");
      maybeSource.subscribe(paramMaybeObserver);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramMaybeObserver);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */