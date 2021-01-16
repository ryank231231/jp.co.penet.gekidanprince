package dagger.android;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class DispatchingAndroidInjector_Factory<T> implements Factory<DispatchingAndroidInjector<T>> {
  private final Provider<Map<Class<? extends T>, Provider<AndroidInjector$Factory<? extends T>>>> injectorFactoriesProvider;
  
  public DispatchingAndroidInjector_Factory(Provider<Map<Class<? extends T>, Provider<AndroidInjector$Factory<? extends T>>>> paramProvider) {
    this.injectorFactoriesProvider = paramProvider;
  }
  
  public static <T> Factory<DispatchingAndroidInjector<T>> create(Provider<Map<Class<? extends T>, Provider<AndroidInjector$Factory<? extends T>>>> paramProvider) {
    return new DispatchingAndroidInjector_Factory<T>(paramProvider);
  }
  
  public static <T> DispatchingAndroidInjector<T> newDispatchingAndroidInjector(Map<Class<? extends T>, Provider<AndroidInjector$Factory<? extends T>>> paramMap) {
    return new DispatchingAndroidInjector(paramMap);
  }
  
  public DispatchingAndroidInjector<T> get() {
    return new DispatchingAndroidInjector((Map)this.injectorFactoriesProvider.get());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DispatchingAndroidInjector_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */