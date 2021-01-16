package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface SingleSource<T> {
  void subscribe(@NonNull SingleObserver<? super T> paramSingleObserver);
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\SingleSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */