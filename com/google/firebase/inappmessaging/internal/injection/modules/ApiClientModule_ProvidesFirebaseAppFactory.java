package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiClientModule_ProvidesFirebaseAppFactory implements Factory<FirebaseApp> {
  private final ApiClientModule module;
  
  public ApiClientModule_ProvidesFirebaseAppFactory(ApiClientModule paramApiClientModule) {
    this.module = paramApiClientModule;
  }
  
  public static Factory<FirebaseApp> create(ApiClientModule paramApiClientModule) {
    return new ApiClientModule_ProvidesFirebaseAppFactory(paramApiClientModule);
  }
  
  public static FirebaseApp proxyProvidesFirebaseApp(ApiClientModule paramApiClientModule) {
    return paramApiClientModule.providesFirebaseApp();
  }
  
  public FirebaseApp get() {
    return (FirebaseApp)Preconditions.checkNotNull(this.module.providesFirebaseApp(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApiClientModule_ProvidesFirebaseAppFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */