package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOperator;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {
  final MaybeOperator<? extends R, ? super T> operator;
  
  public MaybeLift(MaybeSource<T> paramMaybeSource, MaybeOperator<? extends R, ? super T> paramMaybeOperator) {
    super(paramMaybeSource);
    this.operator = paramMaybeOperator;
  }
  
  protected void subscribeActual(MaybeObserver<? super R> paramMaybeObserver) {
    try {
      MaybeObserver maybeObserver = (MaybeObserver)ObjectHelper.requireNonNull(this.operator.apply(paramMaybeObserver), "The operator returned a null MaybeObserver");
      this.source.subscribe(maybeObserver);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramMaybeObserver);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */