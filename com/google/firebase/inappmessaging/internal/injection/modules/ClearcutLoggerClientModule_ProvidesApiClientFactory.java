package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ClearcutLoggerClientModule_ProvidesApiClientFactory implements Factory<MetricsLoggerClient> {
  private final Provider<AnalyticsConnector> analyticsConnectorProvider;
  
  private final Provider<ClearcutLogger> clearcutLoggerProvider;
  
  private final Provider<Clock> clockProvider;
  
  private final Provider<DeveloperListenerManager> developerListenerManagerProvider;
  
  private final Provider<FirebaseInstanceId> firebaseInstanceIdProvider;
  
  private final ClearcutLoggerClientModule module;
  
  public ClearcutLoggerClientModule_ProvidesApiClientFactory(ClearcutLoggerClientModule paramClearcutLoggerClientModule, Provider<ClearcutLogger> paramProvider, Provider<AnalyticsConnector> paramProvider1, Provider<FirebaseInstanceId> paramProvider2, Provider<Clock> paramProvider3, Provider<DeveloperListenerManager> paramProvider4) {
    this.module = paramClearcutLoggerClientModule;
    this.clearcutLoggerProvider = paramProvider;
    this.analyticsConnectorProvider = paramProvider1;
    this.firebaseInstanceIdProvider = paramProvider2;
    this.clockProvider = paramProvider3;
    this.developerListenerManagerProvider = paramProvider4;
  }
  
  public static Factory<MetricsLoggerClient> create(ClearcutLoggerClientModule paramClearcutLoggerClientModule, Provider<ClearcutLogger> paramProvider, Provider<AnalyticsConnector> paramProvider1, Provider<FirebaseInstanceId> paramProvider2, Provider<Clock> paramProvider3, Provider<DeveloperListenerManager> paramProvider4) {
    return new ClearcutLoggerClientModule_ProvidesApiClientFactory(paramClearcutLoggerClientModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
  
  public MetricsLoggerClient get() {
    return (MetricsLoggerClient)Preconditions.checkNotNull(this.module.providesApiClient((ClearcutLogger)this.clearcutLoggerProvider.get(), (AnalyticsConnector)this.analyticsConnectorProvider.get(), (FirebaseInstanceId)this.firebaseInstanceIdProvider.get(), (Clock)this.clockProvider.get(), (DeveloperListenerManager)this.developerListenerManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ClearcutLoggerClientModule_ProvidesApiClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */