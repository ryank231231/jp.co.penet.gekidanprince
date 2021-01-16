package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface SingleConverter<T, R> {
  @NonNull
  R apply(@NonNull Single<T> paramSingle);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\SingleConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */