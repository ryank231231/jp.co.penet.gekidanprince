package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {
  private final Application application;
  
  public ApplicationModule(Application paramApplication) {
    this.application = paramApplication;
  }
  
  @Provides
  @Singleton
  public Application providesApplication() {
    return this.application;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\ApplicationModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */