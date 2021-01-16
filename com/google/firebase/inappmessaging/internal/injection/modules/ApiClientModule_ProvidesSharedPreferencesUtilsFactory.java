package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiClientModule_ProvidesSharedPreferencesUtilsFactory implements Factory<SharedPreferencesUtils> {
  private final ApiClientModule module;
  
  public ApiClientModule_ProvidesSharedPreferencesUtilsFactory(ApiClientModule paramApiClientModule) {
    this.module = paramApiClientModule;
  }
  
  public static Factory<SharedPreferencesUtils> create(ApiClientModule paramApiClientModule) {
    return new ApiClientModule_ProvidesSharedPreferencesUtilsFactory(paramApiClientModule);
  }
  
  public static SharedPreferencesUtils proxyProvidesSharedPreferencesUtils(ApiClientModule paramApiClientModule) {
    return paramApiClientModule.providesSharedPreferencesUtils();
  }
  
  public SharedPreferencesUtils get() {
    return (SharedPreferencesUtils)Preconditions.checkNotNull(this.module.providesSharedPreferencesUtils(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApiClientModule_ProvidesSharedPreferencesUtilsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */