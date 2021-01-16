package com.google.firebase.inappmessaging.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class TestDeviceHelper_Factory implements Factory<TestDeviceHelper> {
  private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
  
  public TestDeviceHelper_Factory(Provider<SharedPreferencesUtils> paramProvider) {
    this.sharedPreferencesUtilsProvider = paramProvider;
  }
  
  public static Factory<TestDeviceHelper> create(Provider<SharedPreferencesUtils> paramProvider) {
    return new TestDeviceHelper_Factory(paramProvider);
  }
  
  public TestDeviceHelper get() {
    return new TestDeviceHelper((SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\TestDeviceHelper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */