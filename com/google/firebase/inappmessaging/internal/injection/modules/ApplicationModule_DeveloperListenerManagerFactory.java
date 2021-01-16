package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_DeveloperListenerManagerFactory implements Factory<DeveloperListenerManager> {
  private final ApplicationModule module;
  
  public ApplicationModule_DeveloperListenerManagerFactory(ApplicationModule paramApplicationModule) {
    this.module = paramApplicationModule;
  }
  
  public static Factory<DeveloperListenerManager> create(ApplicationModule paramApplicationModule) {
    return new ApplicationModule_DeveloperListenerManagerFactory(paramApplicationModule);
  }
  
  public DeveloperListenerManager get() {
    return (DeveloperListenerManager)Preconditions.checkNotNull(this.module.developerListenerManager(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApplicationModule_DeveloperListenerManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */