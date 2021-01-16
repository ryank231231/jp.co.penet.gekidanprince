package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

public final class AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory implements Factory<ConnectableFlowable<String>> {
  private final Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
  
  private final AnalyticsEventsModule module;
  
  public AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(AnalyticsEventsModule paramAnalyticsEventsModule, Provider<AnalyticsEventsManager> paramProvider) {
    this.module = paramAnalyticsEventsModule;
    this.analyticsEventsManagerProvider = paramProvider;
  }
  
  public static Factory<ConnectableFlowable<String>> create(AnalyticsEventsModule paramAnalyticsEventsModule, Provider<AnalyticsEventsManager> paramProvider) {
    return new AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(paramAnalyticsEventsModule, paramProvider);
  }
  
  public ConnectableFlowable<String> get() {
    return (ConnectableFlowable<String>)Preconditions.checkNotNull(this.module.providesAnalyticsConnectorEvents((AnalyticsEventsManager)this.analyticsEventsManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */