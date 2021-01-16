package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleLift<T, R> extends Single<R> {
  final SingleOperator<? extends R, ? super T> onLift;
  
  final SingleSource<T> source;
  
  public SingleLift(SingleSource<T> paramSingleSource, SingleOperator<? extends R, ? super T> paramSingleOperator) {
    this.source = paramSingleSource;
    this.onLift = paramSingleOperator;
  }
  
  protected void subscribeActual(SingleObserver<? super R> paramSingleObserver) {
    try {
      SingleObserver singleObserver = (SingleObserver)ObjectHelper.requireNonNull(this.onLift.apply(paramSingleObserver), "The onLift returned a null SingleObserver");
      this.source.subscribe(singleObserver);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramSingleObserver);
      return;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */