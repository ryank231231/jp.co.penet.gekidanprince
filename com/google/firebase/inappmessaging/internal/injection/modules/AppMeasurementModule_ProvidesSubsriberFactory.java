package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.events.Subscriber;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppMeasurementModule_ProvidesSubsriberFactory implements Factory<Subscriber> {
  private final AppMeasurementModule module;
  
  public AppMeasurementModule_ProvidesSubsriberFactory(AppMeasurementModule paramAppMeasurementModule) {
    this.module = paramAppMeasurementModule;
  }
  
  public static Factory<Subscriber> create(AppMeasurementModule paramAppMeasurementModule) {
    return new AppMeasurementModule_ProvidesSubsriberFactory(paramAppMeasurementModule);
  }
  
  public Subscriber get() {
    return (Subscriber)Preconditions.checkNotNull(this.module.providesSubsriber(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\AppMeasurementModule_ProvidesSubsriberFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */