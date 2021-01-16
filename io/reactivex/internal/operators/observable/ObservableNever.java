package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class ObservableNever extends Observable<Object> {
  public static final Observable<Object> INSTANCE = new ObservableNever();
  
  protected void subscribeActual(Observer<? super Object> paramObserver) {
    paramObserver.onSubscribe((Disposable)EmptyDisposable.NEVER);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableNever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */