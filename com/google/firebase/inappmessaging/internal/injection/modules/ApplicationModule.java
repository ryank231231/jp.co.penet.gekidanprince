package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
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
  public DeveloperListenerManager developerListenerManager() {
    return new DeveloperListenerManager();
  }
  
  @Provides
  @Singleton
  public Application providesApplication() {
    return this.application;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ApplicationModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */