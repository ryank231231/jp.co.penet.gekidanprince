package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class SingleCheck<T> implements Provider<T>, Lazy<T> {
  private static final Object UNINITIALIZED = new Object();
  
  private volatile Object instance = UNINITIALIZED;
  
  private volatile Provider<T> provider;
  
  private SingleCheck(Provider<T> paramProvider) {
    this.provider = paramProvider;
  }
  
  public static <T> Provider<T> provider(Provider<T> paramProvider) {
    return (paramProvider instanceof SingleCheck || paramProvider instanceof DoubleCheck) ? paramProvider : new SingleCheck<T>(Preconditions.<Provider<T>>checkNotNull(paramProvider));
  }
  
  public T get() {
    Provider<T> provider = this.provider;
    if (this.instance == UNINITIALIZED) {
      this.instance = provider.get();
      this.provider = null;
    } 
    return (T)this.instance;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\SingleCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */