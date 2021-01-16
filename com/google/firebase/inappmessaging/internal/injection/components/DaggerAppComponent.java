package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging_Factory;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory_Factory;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.GrpcClient_Factory;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager_Factory;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesDataCollectionHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseInstanceIdFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesSharedPreferencesUtilsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesTestDeviceHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ClearcutLoggerClientModule_ProvidesClearcutClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesApiKeyHeadersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import io.grpc.Channel;
import io.grpc.Metadata;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

public final class DaggerAppComponent implements AppComponent {
  private Provider<AnalyticsConnector> analyticsConnectorProvider;
  
  private Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
  
  private ApiClientModule apiClientModule;
  
  private Provider<ConnectableFlowable<String>> appForegroundEventFlowableProvider;
  
  private Provider<RateLimit> appForegroundRateLimitProvider;
  
  private Provider<Application> applicationProvider;
  
  private Provider<CampaignCacheClient> campaignCacheClientProvider;
  
  private Provider<Clock> clockProvider;
  
  private Provider<DeveloperListenerManager> developerListenerManagerProvider;
  
  private Provider<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
  
  private Provider<Subscriber> firebaseEventsSubscriberProvider;
  
  private Provider<FirebaseInAppMessaging> firebaseInAppMessagingProvider;
  
  private Provider<Channel> gRPCChannelProvider;
  
  private Provider<GrpcClient> grpcClientProvider;
  
  private Provider<ImpressionStorageClient> impressionStorageClientProvider;
  
  private Provider<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
  
  private Provider<ApiClient> providesApiClientProvider;
  
  private Provider<MetricsLoggerClient> providesApiClientProvider2;
  
  private Provider<Metadata> providesApiKeyHeadersProvider;
  
  private Provider<ClearcutLogger> providesClearcutClientProvider;
  
  private Provider<DataCollectionHelper> providesDataCollectionHelperProvider;
  
  private Provider<FirebaseInstanceId> providesFirebaseInstanceIdProvider;
  
  private Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> providesInAppMessagingSdkServingStubProvider;
  
  private Provider<SharedPreferencesUtils> providesSharedPreferencesUtilsProvider;
  
  private Provider<TestDeviceHelper> providesTestDeviceHelperProvider;
  
  private Provider<RateLimiterClient> rateLimiterClientProvider;
  
  private Provider<Schedulers> schedulersProvider;
  
  private UniversalComponent universalComponent;
  
  private DaggerAppComponent(Builder paramBuilder) {
    initialize(paramBuilder);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  private DataCollectionHelper getDataCollectionHelper() {
    ApiClientModule apiClientModule = this.apiClientModule;
    return (DataCollectionHelper)Preconditions.checkNotNull(ApiClientModule_ProvidesDataCollectionHelperFactory.proxyProvidesDataCollectionHelper(apiClientModule, (SharedPreferencesUtils)Preconditions.checkNotNull(ApiClientModule_ProvidesSharedPreferencesUtilsFactory.proxyProvidesSharedPreferencesUtils(apiClientModule), "Cannot return null from a non-@Nullable @Provides method"), (Subscriber)Preconditions.checkNotNull(this.universalComponent.firebaseEventsSubscriber(), "Cannot return null from a non-@Nullable component method")), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  private void initialize(Builder paramBuilder) {
    this.appForegroundEventFlowableProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable(paramBuilder.universalComponent);
    this.campaignCacheClientProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient(paramBuilder.universalComponent);
    this.clockProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock(paramBuilder.universalComponent);
    this.gRPCChannelProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel(paramBuilder.universalComponent);
    this.providesApiKeyHeadersProvider = (Provider<Metadata>)GrpcClientModule_ProvidesApiKeyHeadersFactory.create(paramBuilder.grpcClientModule);
    this.providesInAppMessagingSdkServingStubProvider = DoubleCheck.provider((Provider)GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.create(paramBuilder.grpcClientModule, this.gRPCChannelProvider, this.providesApiKeyHeadersProvider));
    this.grpcClientProvider = DoubleCheck.provider((Provider)GrpcClient_Factory.create(this.providesInAppMessagingSdkServingStubProvider));
    this.applicationProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application(paramBuilder.universalComponent);
    this.providesSharedPreferencesUtilsProvider = (Provider<SharedPreferencesUtils>)ApiClientModule_ProvidesSharedPreferencesUtilsFactory.create(paramBuilder.apiClientModule);
    this.firebaseEventsSubscriberProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber(paramBuilder.universalComponent);
    this.providesDataCollectionHelperProvider = (Provider<DataCollectionHelper>)ApiClientModule_ProvidesDataCollectionHelperFactory.create(paramBuilder.apiClientModule, this.providesSharedPreferencesUtilsProvider, this.firebaseEventsSubscriberProvider);
    this.providesApiClientProvider = DoubleCheck.provider((Provider)ApiClientModule_ProvidesApiClientFactory.create(paramBuilder.apiClientModule, this.grpcClientProvider, this.applicationProvider, this.providesDataCollectionHelperProvider));
    this.analyticsEventsManagerProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager(paramBuilder.universalComponent);
    this.schedulersProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers(paramBuilder.universalComponent);
    this.impressionStorageClientProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient(paramBuilder.universalComponent);
    this.rateLimiterClientProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient(paramBuilder.universalComponent);
    this.appForegroundRateLimitProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit(paramBuilder.universalComponent);
    this.providesTestDeviceHelperProvider = (Provider<TestDeviceHelper>)ApiClientModule_ProvidesTestDeviceHelperFactory.create(paramBuilder.apiClientModule, this.providesSharedPreferencesUtilsProvider);
    this.inAppMessageStreamManagerProvider = DoubleCheck.provider((Provider)InAppMessageStreamManager_Factory.create(this.appForegroundEventFlowableProvider, this.campaignCacheClientProvider, this.clockProvider, this.providesApiClientProvider, this.analyticsEventsManagerProvider, this.schedulersProvider, this.impressionStorageClientProvider, this.rateLimiterClientProvider, this.appForegroundRateLimitProvider, this.providesTestDeviceHelperProvider));
    this.providesClearcutClientProvider = DoubleCheck.provider((Provider)ClearcutLoggerClientModule_ProvidesClearcutClientFactory.create(paramBuilder.clearcutLoggerClientModule, this.applicationProvider));
    this.analyticsConnectorProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector(paramBuilder.universalComponent);
    this.providesFirebaseInstanceIdProvider = (Provider<FirebaseInstanceId>)ApiClientModule_ProvidesFirebaseInstanceIdFactory.create(paramBuilder.apiClientModule);
    this.developerListenerManagerProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager(paramBuilder.universalComponent);
    this.providesApiClientProvider2 = DoubleCheck.provider((Provider)ClearcutLoggerClientModule_ProvidesApiClientFactory.create(paramBuilder.clearcutLoggerClientModule, this.providesClearcutClientProvider, this.analyticsConnectorProvider, this.providesFirebaseInstanceIdProvider, this.clockProvider, this.developerListenerManagerProvider));
    this.displayCallbacksFactoryProvider = (Provider<DisplayCallbacksFactory>)DisplayCallbacksFactory_Factory.create(this.impressionStorageClientProvider, this.clockProvider, this.schedulersProvider, this.rateLimiterClientProvider, this.campaignCacheClientProvider, this.appForegroundRateLimitProvider, this.providesApiClientProvider2, this.providesDataCollectionHelperProvider);
    this.firebaseInAppMessagingProvider = DoubleCheck.provider((Provider)FirebaseInAppMessaging_Factory.create(this.inAppMessageStreamManagerProvider, this.providesDataCollectionHelperProvider, this.displayCallbacksFactoryProvider, this.developerListenerManagerProvider));
    this.universalComponent = paramBuilder.universalComponent;
    this.apiClientModule = paramBuilder.apiClientModule;
  }
  
  public DisplayCallbacksFactory displayCallbacksFactory() {
    return new DisplayCallbacksFactory((ImpressionStorageClient)Preconditions.checkNotNull(this.universalComponent.impressionStorageClient(), "Cannot return null from a non-@Nullable component method"), (Clock)Preconditions.checkNotNull(this.universalComponent.clock(), "Cannot return null from a non-@Nullable component method"), (Schedulers)Preconditions.checkNotNull(this.universalComponent.schedulers(), "Cannot return null from a non-@Nullable component method"), (RateLimiterClient)Preconditions.checkNotNull(this.universalComponent.rateLimiterClient(), "Cannot return null from a non-@Nullable component method"), (CampaignCacheClient)Preconditions.checkNotNull(this.universalComponent.campaignCacheClient(), "Cannot return null from a non-@Nullable component method"), (RateLimit)Preconditions.checkNotNull(this.universalComponent.appForegroundRateLimit(), "Cannot return null from a non-@Nullable component method"), (MetricsLoggerClient)this.providesApiClientProvider2.get(), getDataCollectionHelper());
  }
  
  public FirebaseInAppMessaging providesFirebaseInAppMessaging() {
    return (FirebaseInAppMessaging)this.firebaseInAppMessagingProvider.get();
  }
  
  public static final class Builder {
    private ApiClientModule apiClientModule;
    
    private ClearcutLoggerClientModule clearcutLoggerClientModule;
    
    private GrpcClientModule grpcClientModule;
    
    private UniversalComponent universalComponent;
    
    private Builder() {}
    
    public Builder apiClientModule(ApiClientModule param1ApiClientModule) {
      this.apiClientModule = (ApiClientModule)Preconditions.checkNotNull(param1ApiClientModule);
      return this;
    }
    
    public AppComponent build() {
      if (this.grpcClientModule != null) {
        if (this.apiClientModule != null) {
          if (this.clearcutLoggerClientModule != null) {
            if (this.universalComponent != null)
              return new DaggerAppComponent(this); 
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(UniversalComponent.class.getCanonicalName());
            stringBuilder3.append(" must be set");
            throw new IllegalStateException(stringBuilder3.toString());
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(ClearcutLoggerClientModule.class.getCanonicalName());
          stringBuilder2.append(" must be set");
          throw new IllegalStateException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(ApiClientModule.class.getCanonicalName());
        stringBuilder1.append(" must be set");
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(GrpcClientModule.class.getCanonicalName());
      stringBuilder.append(" must be set");
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public Builder clearcutLoggerClientModule(ClearcutLoggerClientModule param1ClearcutLoggerClientModule) {
      this.clearcutLoggerClientModule = (ClearcutLoggerClientModule)Preconditions.checkNotNull(param1ClearcutLoggerClientModule);
      return this;
    }
    
    public Builder grpcClientModule(GrpcClientModule param1GrpcClientModule) {
      this.grpcClientModule = (GrpcClientModule)Preconditions.checkNotNull(param1GrpcClientModule);
      return this;
    }
    
    public Builder universalComponent(UniversalComponent param1UniversalComponent) {
      this.universalComponent = (UniversalComponent)Preconditions.checkNotNull(param1UniversalComponent);
      return this;
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector implements Provider<AnalyticsConnector> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public AnalyticsConnector get() {
      return (AnalyticsConnector)Preconditions.checkNotNull(this.universalComponent.analyticsConnector(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager implements Provider<AnalyticsEventsManager> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public AnalyticsEventsManager get() {
      return (AnalyticsEventsManager)Preconditions.checkNotNull(this.universalComponent.analyticsEventsManager(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable implements Provider<ConnectableFlowable<String>> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public ConnectableFlowable<String> get() {
      return (ConnectableFlowable<String>)Preconditions.checkNotNull(this.universalComponent.appForegroundEventFlowable(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit implements Provider<RateLimit> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public RateLimit get() {
      return (RateLimit)Preconditions.checkNotNull(this.universalComponent.appForegroundRateLimit(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application implements Provider<Application> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public Application get() {
      return (Application)Preconditions.checkNotNull(this.universalComponent.application(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient implements Provider<CampaignCacheClient> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public CampaignCacheClient get() {
      return (CampaignCacheClient)Preconditions.checkNotNull(this.universalComponent.campaignCacheClient(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock implements Provider<Clock> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public Clock get() {
      return (Clock)Preconditions.checkNotNull(this.universalComponent.clock(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager implements Provider<DeveloperListenerManager> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public DeveloperListenerManager get() {
      return (DeveloperListenerManager)Preconditions.checkNotNull(this.universalComponent.developerListenerManager(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber implements Provider<Subscriber> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public Subscriber get() {
      return (Subscriber)Preconditions.checkNotNull(this.universalComponent.firebaseEventsSubscriber(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel implements Provider<Channel> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public Channel get() {
      return (Channel)Preconditions.checkNotNull(this.universalComponent.gRPCChannel(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient implements Provider<ImpressionStorageClient> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public ImpressionStorageClient get() {
      return (ImpressionStorageClient)Preconditions.checkNotNull(this.universalComponent.impressionStorageClient(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient implements Provider<RateLimiterClient> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public RateLimiterClient get() {
      return (RateLimiterClient)Preconditions.checkNotNull(this.universalComponent.rateLimiterClient(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers implements Provider<Schedulers> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public Schedulers get() {
      return (Schedulers)Preconditions.checkNotNull(this.universalComponent.schedulers(), "Cannot return null from a non-@Nullable component method");
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\components\DaggerAppComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */