package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface MaybeOnSubscribe<T> {
  void subscribe(@NonNull MaybeEmitter<T> paramMaybeEmitter) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\MaybeOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */