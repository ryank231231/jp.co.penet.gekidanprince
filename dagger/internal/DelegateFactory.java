package dagger.internal;

import javax.inject.Provider;

public final class DelegateFactory<T> implements Factory<T> {
  private Provider<T> delegate;
  
  public T get() {
    Provider<T> provider = this.delegate;
    if (provider != null)
      return (T)provider.get(); 
    throw new IllegalStateException();
  }
  
  public void setDelegatedProvider(Provider<T> paramProvider) {
    if (paramProvider != null) {
      if (this.delegate == null) {
        this.delegate = paramProvider;
        return;
      } 
      throw new IllegalStateException();
    } 
    throw new IllegalArgumentException();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\DelegateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */