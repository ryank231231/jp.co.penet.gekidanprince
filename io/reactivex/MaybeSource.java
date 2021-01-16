package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface MaybeSource<T> {
  void subscribe(@NonNull MaybeObserver<? super T> paramMaybeObserver);
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\MaybeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */