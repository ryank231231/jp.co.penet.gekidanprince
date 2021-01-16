package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import dagger.Module;
import dagger.Provides;

@Module
public class ClearcutLoggerClientModule {
  private static final String FIREBASE_INAPPMESSAGING_LOG_SOURCE = "FIREBASE_INAPPMESSAGING";
  
  private final FirebaseApp firebaseApp;
  
  public ClearcutLoggerClientModule(FirebaseApp paramFirebaseApp) {
    this.firebaseApp = paramFirebaseApp;
  }
  
  @Provides
  @FirebaseAppScope
  public MetricsLoggerClient providesApiClient(ClearcutLogger paramClearcutLogger, AnalyticsConnector paramAnalyticsConnector, FirebaseInstanceId paramFirebaseInstanceId, Clock paramClock, DeveloperListenerManager paramDeveloperListenerManager) {
    return new MetricsLoggerClient(ClearcutLoggerClientModule$$Lambda$1.lambdaFactory$(paramClearcutLogger), paramAnalyticsConnector, this.firebaseApp, paramFirebaseInstanceId, paramClock, paramDeveloperListenerManager);
  }
  
  @Provides
  @FirebaseAppScope
  public ClearcutLogger providesClearcutClient(Application paramApplication) {
    return new ClearcutLogger((Context)paramApplication, "FIREBASE_INAPPMESSAGING", null);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ClearcutLoggerClientModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */