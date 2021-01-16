package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface ObservableOnSubscribe<T> {
  void subscribe(@NonNull ObservableEmitter<T> paramObservableEmitter) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\ObservableOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */