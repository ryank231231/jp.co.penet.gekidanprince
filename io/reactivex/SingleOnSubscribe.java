package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface SingleOnSubscribe<T> {
  void subscribe(@NonNull SingleEmitter<T> paramSingleEmitter) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\SingleOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */