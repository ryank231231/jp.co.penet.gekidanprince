package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.internal.vendored.SystemClock;
import dagger.Module;
import dagger.Provides;

@Module
public class SystemClockModule {
  @Provides
  public Clock providesSystemClockModule() {
    return (Clock)new SystemClock();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\SystemClockModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */