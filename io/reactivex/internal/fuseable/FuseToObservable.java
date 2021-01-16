package io.reactivex.internal.fuseable;

import io.reactivex.Observable;

public interface FuseToObservable<T> {
  Observable<T> fuseToObservable();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\FuseToObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */