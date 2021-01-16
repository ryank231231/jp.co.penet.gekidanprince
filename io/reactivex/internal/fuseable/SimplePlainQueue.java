package io.reactivex.internal.fuseable;

import io.reactivex.annotations.Nullable;

public interface SimplePlainQueue<T> extends SimpleQueue<T> {
  @Nullable
  T poll();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\fuseable\SimplePlainQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */