package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppMeasurementModule_ProvidesAnalyticsConnectorFactory implements Factory<AnalyticsConnector> {
  private final AppMeasurementModule module;
  
  public AppMeasurementModule_ProvidesAnalyticsConnectorFactory(AppMeasurementModule paramAppMeasurementModule) {
    this.module = paramAppMeasurementModule;
  }
  
  public static Factory<AnalyticsConnector> create(AppMeasurementModule paramAppMeasurementModule) {
    return new AppMeasurementModule_ProvidesAnalyticsConnectorFactory(paramAppMeasurementModule);
  }
  
  public AnalyticsConnector get() {
    return (AnalyticsConnector)Preconditions.checkNotNull(this.module.providesAnalyticsConnector(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\AppMeasurementModule_ProvidesAnalyticsConnectorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */