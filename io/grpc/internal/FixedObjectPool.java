package io.grpc.internal;

import com.google.common.base.Preconditions;

public final class FixedObjectPool<T> implements ObjectPool<T> {
  private final T object;
  
  public FixedObjectPool(T paramT) {
    this.object = (T)Preconditions.checkNotNull(paramT, "object");
  }
  
  public T getObject() {
    return this.object;
  }
  
  public T returnObject(Object paramObject) {
    return null;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\FixedObjectPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */