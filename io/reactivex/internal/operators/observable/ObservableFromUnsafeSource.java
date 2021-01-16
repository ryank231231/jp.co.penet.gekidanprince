package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final class ObservableFromUnsafeSource<T> extends Observable<T> {
  final ObservableSource<T> source;
  
  public ObservableFromUnsafeSource(ObservableSource<T> paramObservableSource) {
    this.source = paramObservableSource;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(paramObserver);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFromUnsafeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */