package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory implements Factory<AnalyticsEventsManager> {
  private final Provider<AnalyticsConnector> analyticsConnectorProvider;
  
  private final AnalyticsEventsModule module;
  
  public AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(AnalyticsEventsModule paramAnalyticsEventsModule, Provider<AnalyticsConnector> paramProvider) {
    this.module = paramAnalyticsEventsModule;
    this.analyticsConnectorProvider = paramProvider;
  }
  
  public static Factory<AnalyticsEventsManager> create(AnalyticsEventsModule paramAnalyticsEventsModule, Provider<AnalyticsConnector> paramProvider) {
    return new AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(paramAnalyticsEventsModule, paramProvider);
  }
  
  public AnalyticsEventsManager get() {
    return (AnalyticsEventsManager)Preconditions.checkNotNull(this.module.providesAnalyticsEventsManager((AnalyticsConnector)this.analyticsConnectorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */