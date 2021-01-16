package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

public final class MaybeError<T> extends Maybe<T> {
  final Throwable error;
  
  public MaybeError(Throwable paramThrowable) {
    this.error = paramThrowable;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    paramMaybeObserver.onSubscribe(Disposables.disposed());
    paramMaybeObserver.onError(this.error);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */