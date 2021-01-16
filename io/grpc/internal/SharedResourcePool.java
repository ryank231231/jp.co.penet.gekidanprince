package io.grpc.internal;

public final class SharedResourcePool<T> implements ObjectPool<T> {
  private final SharedResourceHolder.Resource<T> resource;
  
  private SharedResourcePool(SharedResourceHolder.Resource<T> paramResource) {
    this.resource = paramResource;
  }
  
  public static <T> SharedResourcePool<T> forResource(SharedResourceHolder.Resource<T> paramResource) {
    return new SharedResourcePool<T>(paramResource);
  }
  
  public T getObject() {
    return SharedResourceHolder.get(this.resource);
  }
  
  public T returnObject(Object paramObject) {
    SharedResourceHolder.release(this.resource, (T)paramObject);
    return null;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\SharedResourcePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */