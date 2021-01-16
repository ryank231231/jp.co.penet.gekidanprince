package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class MaybeJust<T> extends Maybe<T> implements ScalarCallable<T> {
  final T value;
  
  public MaybeJust(T paramT) {
    this.value = paramT;
  }
  
  public T call() {
    return this.value;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    paramMaybeObserver.onSubscribe(Disposables.disposed());
    paramMaybeObserver.onSuccess(this.value);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeJust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */