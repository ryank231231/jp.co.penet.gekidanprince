package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
  protected final ObservableSource<T> source;
  
  AbstractObservableWithUpstream(ObservableSource<T> paramObservableSource) {
    this.source = paramObservableSource;
  }
  
  public final ObservableSource<T> source() {
    return this.source;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\AbstractObservableWithUpstream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */