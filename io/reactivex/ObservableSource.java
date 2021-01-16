package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface ObservableSource<T> {
  void subscribe(@NonNull Observer<? super T> paramObserver);
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\ObservableSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */