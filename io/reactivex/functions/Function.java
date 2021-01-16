package io.reactivex.functions;

import io.reactivex.annotations.NonNull;

public interface Function<T, R> {
  R apply(@NonNull T paramT) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\functions\Function.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */