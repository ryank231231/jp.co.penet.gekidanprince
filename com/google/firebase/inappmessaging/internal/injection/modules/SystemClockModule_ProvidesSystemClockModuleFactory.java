package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SystemClockModule_ProvidesSystemClockModuleFactory implements Factory<Clock> {
  private final SystemClockModule module;
  
  public SystemClockModule_ProvidesSystemClockModuleFactory(SystemClockModule paramSystemClockModule) {
    this.module = paramSystemClockModule;
  }
  
  public static Factory<Clock> create(SystemClockModule paramSystemClockModule) {
    return new SystemClockModule_ProvidesSystemClockModuleFactory(paramSystemClockModule);
  }
  
  public Clock get() {
    return (Clock)Preconditions.checkNotNull(this.module.providesSystemClockModule(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\SystemClockModule_ProvidesSystemClockModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */