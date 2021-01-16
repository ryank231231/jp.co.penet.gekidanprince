package io.reactivex.internal.fuseable;

import io.reactivex.ObservableSource;

public interface HasUpstreamObservableSource<T> {
  ObservableSource<T> source();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\HasUpstreamObservableSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */