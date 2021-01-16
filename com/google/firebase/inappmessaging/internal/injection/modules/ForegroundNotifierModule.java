package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ForegroundNotifierModule {
  @Provides
  @Singleton
  public ForegroundNotifier providesForeground() {
    return new ForegroundNotifier();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ForegroundNotifierModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */