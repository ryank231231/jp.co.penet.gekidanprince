package io.grpc.internal;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ObjectPool<T> {
  T getObject();
  
  T returnObject(Object paramObject);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ObjectPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */