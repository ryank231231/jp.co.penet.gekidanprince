package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_ProvidesApplicationFactory implements Factory<Application> {
  private final ApplicationModule module;
  
  public ApplicationModule_ProvidesApplicationFactory(ApplicationModule paramApplicationModule) {
    this.module = paramApplicationModule;
  }
  
  public static Factory<Application> create(ApplicationModule paramApplicationModule) {
    return new ApplicationModule_ProvidesApplicationFactory(paramApplicationModule);
  }
  
  public Application get() {
    return (Application)Preconditions.checkNotNull(this.module.providesApplication(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\ApplicationModule_ProvidesApplicationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */