package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.internal.AnalyticsConnectorHandleManager;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener;
import dagger.Module;
import dagger.Provides;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Module
public class AnalyticsEventsModule {
  @AnalyticsListener
  @Provides
  @Singleton
  public ConnectableFlowable<String> providesAnalyticsConnectorEvents(AnalyticsEventsManager paramAnalyticsEventsManager) {
    return paramAnalyticsEventsManager.getAnalyticsEventsFlowable();
  }
  
  @Provides
  @Singleton
  public AnalyticsConnectorHandleManager providesAnalyticsConnectorHandle(AnalyticsEventsManager paramAnalyticsEventsManager) {
    return new AnalyticsConnectorHandleManager(paramAnalyticsEventsManager.getHandle());
  }
  
  @Provides
  @Singleton
  public AnalyticsEventsManager providesAnalyticsEventsManager(AnalyticsConnector paramAnalyticsConnector) {
    return new AnalyticsEventsManager(paramAnalyticsConnector);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\AnalyticsEventsModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */