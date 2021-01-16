package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.AnalyticsConnectorHandleManager;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory implements Factory<AnalyticsConnectorHandleManager> {
  private final Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
  
  private final AnalyticsEventsModule module;
  
  public AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory(AnalyticsEventsModule paramAnalyticsEventsModule, Provider<AnalyticsEventsManager> paramProvider) {
    this.module = paramAnalyticsEventsModule;
    this.analyticsEventsManagerProvider = paramProvider;
  }
  
  public static Factory<AnalyticsConnectorHandleManager> create(AnalyticsEventsModule paramAnalyticsEventsModule, Provider<AnalyticsEventsManager> paramProvider) {
    return new AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory(paramAnalyticsEventsModule, paramProvider);
  }
  
  public AnalyticsConnectorHandleManager get() {
    return (AnalyticsConnectorHandleManager)Preconditions.checkNotNull(this.module.providesAnalyticsConnectorHandle((AnalyticsEventsManager)this.analyticsEventsManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */