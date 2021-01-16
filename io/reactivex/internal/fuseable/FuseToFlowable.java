package io.reactivex.internal.fuseable;

import io.reactivex.Flowable;

public interface FuseToFlowable<T> {
  Flowable<T> fuseToFlowable();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\FuseToFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */