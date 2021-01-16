package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApiClientModule_ProvidesTestDeviceHelperFactory implements Factory<TestDeviceHelper> {
  private final ApiClientModule module;
  
  private final Provider<SharedPreferencesUtils> sharedPreferencesUtilsProvider;
  
  public ApiClientModule_ProvidesTestDeviceHelperFactory(ApiClientModule paramApiClientModule, Provider<SharedPreferencesUtils> paramProvider) {
    this.module = paramApiClientModule;
    this.sharedPreferencesUtilsProvider = paramProvider;
  }
  
  public static Factory<TestDeviceHelper> create(ApiClientModule paramApiClientModule, Provider<SharedPreferencesUtils> paramProvider) {
    return new ApiClientModule_ProvidesTestDeviceHelperFactory(paramApiClientModule, paramProvider);
  }
  
  public static TestDeviceHelper proxyProvidesTestDeviceHelper(ApiClientModule paramApiClientModule, SharedPreferencesUtils paramSharedPreferencesUtils) {
    return paramApiClientModule.providesTestDeviceHelper(paramSharedPreferencesUtils);
  }
  
  public TestDeviceHelper get() {
    return (TestDeviceHelper)Preconditions.checkNotNull(this.module.providesTestDeviceHelper((SharedPreferencesUtils)this.sharedPreferencesUtilsProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApiClientModule_ProvidesTestDeviceHelperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */