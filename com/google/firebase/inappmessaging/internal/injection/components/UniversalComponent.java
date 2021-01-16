package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AnalyticsConnectorHandleManager;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundNotifierModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import dagger.Component;
import io.grpc.Channel;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Component(modules = {GrpcChannelModule.class, SchedulerModule.class, ApplicationModule.class, ForegroundNotifierModule.class, ForegroundFlowableModule.class, AnalyticsEventsModule.class, ProtoStorageClientModule.class, SystemClockModule.class, RateLimitModule.class, AppMeasurementModule.class})
@Singleton
public interface UniversalComponent {
  AnalyticsConnector analyticsConnector();
  
  AnalyticsConnectorHandleManager analyticsConnectorHandleManager();
  
  @AnalyticsListener
  ConnectableFlowable<String> analyticsEventsFlowable();
  
  AnalyticsEventsManager analyticsEventsManager();
  
  @AppForeground
  ConnectableFlowable<String> appForegroundEventFlowable();
  
  @AppForeground
  RateLimit appForegroundRateLimit();
  
  Application application();
  
  CampaignCacheClient campaignCacheClient();
  
  Clock clock();
  
  DeveloperListenerManager developerListenerManager();
  
  Subscriber firebaseEventsSubscriber();
  
  Channel gRPCChannel();
  
  ImpressionStorageClient impressionStorageClient();
  
  ProtoMarshallerClient protoMarshallerClient();
  
  RateLimiterClient rateLimiterClient();
  
  Schedulers schedulers();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\components\UniversalComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */