package dagger.internal;

import dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
  private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory(null);
  
  private final T instance;
  
  private InstanceFactory(T paramT) {
    this.instance = paramT;
  }
  
  public static <T> Factory<T> create(T paramT) {
    return new InstanceFactory<T>(Preconditions.checkNotNull(paramT, "instance cannot be null"));
  }
  
  public static <T> Factory<T> createNullable(T paramT) {
    InstanceFactory<?> instanceFactory;
    if (paramT == null) {
      instanceFactory = nullInstanceFactory();
    } else {
      instanceFactory = new InstanceFactory(instanceFactory);
    } 
    return (Factory)instanceFactory;
  }
  
  private static <T> InstanceFactory<T> nullInstanceFactory() {
    return (InstanceFactory)NULL_INSTANCE_FACTORY;
  }
  
  public T get() {
    return this.instance;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\InstanceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */