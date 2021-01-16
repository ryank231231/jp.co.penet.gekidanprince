package com.google.firebase.inappmessaging.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AnalyticsConnectorHandleManager_Factory implements Factory<AnalyticsConnectorHandleManager> {
  private final Provider<AnalyticsConnector.AnalyticsConnectorHandle> analyticsHandleProvider;
  
  public AnalyticsConnectorHandleManager_Factory(Provider<AnalyticsConnector.AnalyticsConnectorHandle> paramProvider) {
    this.analyticsHandleProvider = paramProvider;
  }
  
  public static Factory<AnalyticsConnectorHandleManager> create(Provider<AnalyticsConnector.AnalyticsConnectorHandle> paramProvider) {
    return new AnalyticsConnectorHandleManager_Factory(paramProvider);
  }
  
  public AnalyticsConnectorHandleManager get() {
    return new AnalyticsConnectorHandleManager((AnalyticsConnector.AnalyticsConnectorHandle)this.analyticsHandleProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\AnalyticsConnectorHandleManager_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */