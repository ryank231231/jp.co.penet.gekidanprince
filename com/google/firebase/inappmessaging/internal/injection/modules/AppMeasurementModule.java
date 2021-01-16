package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class AppMeasurementModule {
  private AnalyticsConnector analyticsConnector;
  
  private Subscriber firebaseEventsSubscriber;
  
  public AppMeasurementModule(AnalyticsConnector paramAnalyticsConnector, Subscriber paramSubscriber) {
    this.analyticsConnector = paramAnalyticsConnector;
    this.firebaseEventsSubscriber = paramSubscriber;
  }
  
  @Provides
  @Singleton
  public AnalyticsConnector providesAnalyticsConnector() {
    return this.analyticsConnector;
  }
  
  @Provides
  @Singleton
  public Subscriber providesSubsriber() {
    return this.firebaseEventsSubscriber;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\AppMeasurementModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */