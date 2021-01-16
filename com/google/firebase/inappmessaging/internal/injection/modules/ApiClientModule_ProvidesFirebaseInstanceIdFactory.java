package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.iid.FirebaseInstanceId;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiClientModule_ProvidesFirebaseInstanceIdFactory implements Factory<FirebaseInstanceId> {
  private final ApiClientModule module;
  
  public ApiClientModule_ProvidesFirebaseInstanceIdFactory(ApiClientModule paramApiClientModule) {
    this.module = paramApiClientModule;
  }
  
  public static Factory<FirebaseInstanceId> create(ApiClientModule paramApiClientModule) {
    return new ApiClientModule_ProvidesFirebaseInstanceIdFactory(paramApiClientModule);
  }
  
  public static FirebaseInstanceId proxyProvidesFirebaseInstanceId(ApiClientModule paramApiClientModule) {
    return paramApiClientModule.providesFirebaseInstanceId();
  }
  
  public FirebaseInstanceId get() {
    return (FirebaseInstanceId)Preconditions.checkNotNull(this.module.providesFirebaseInstanceId(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApiClientModule_ProvidesFirebaseInstanceIdFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */