package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

public final class SingleJust<T> extends Single<T> {
  final T value;
  
  public SingleJust(T paramT) {
    this.value = paramT;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    paramSingleObserver.onSubscribe(Disposables.disposed());
    paramSingleObserver.onSuccess(this.value);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleJust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */