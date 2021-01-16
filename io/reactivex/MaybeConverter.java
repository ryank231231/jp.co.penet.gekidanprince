package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface MaybeConverter<T, R> {
  @NonNull
  R apply(@NonNull Maybe<T> paramMaybe);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\MaybeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */