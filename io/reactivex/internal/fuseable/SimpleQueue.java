package io.reactivex.internal.fuseable;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public interface SimpleQueue<T> {
  void clear();
  
  boolean isEmpty();
  
  boolean offer(@NonNull T paramT);
  
  boolean offer(@NonNull T paramT1, @NonNull T paramT2);
  
  @Nullable
  T poll() throws Exception;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\SimpleQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */