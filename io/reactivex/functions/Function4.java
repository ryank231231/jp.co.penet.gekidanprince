package io.reactivex.functions;

import io.reactivex.annotations.NonNull;

public interface Function4<T1, T2, T3, T4, R> {
  @NonNull
  R apply(@NonNull T1 paramT1, @NonNull T2 paramT2, @NonNull T3 paramT3, @NonNull T4 paramT4) throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\functions\Function4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */