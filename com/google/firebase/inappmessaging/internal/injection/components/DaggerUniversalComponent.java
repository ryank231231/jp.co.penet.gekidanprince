package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AnalyticsConnectorHandleManager;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient_Factory;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient_Factory;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient_Factory;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.Schedulers_Factory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesAnalyticsConnectorFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule_ProvidesSubsriberFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_DeveloperListenerManagerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundNotifierModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ForegroundNotifierModule_ProvidesForegroundFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesGrpcChannelFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcChannelModule_ProvidesServiceHostFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesComputeSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesIOSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SchedulerModule_ProvidesMainThreadSchedulerFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule;
import com.google.firebase.inappmessaging.internal.injection.modules.SystemClockModule_ProvidesSystemClockModuleFactory;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient_Factory;
import com.google.firebase.inappmessaging.model.RateLimit;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import io.grpc.Channel;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

public final class DaggerUniversalComponent implements UniversalComponent {
  private Provider<CampaignCacheClient> campaignCacheClientProvider;
  
  private Provider<DeveloperListenerManager> developerListenerManagerProvider;
  
  private Provider<ImpressionStorageClient> impressionStorageClientProvider;
  
  private Provider<ProtoMarshallerClient> protoMarshallerClientProvider;
  
  private Provider<ConnectableFlowable<String>> providesAnalyticsConnectorEventsProvider;
  
  private Provider<AnalyticsConnectorHandleManager> providesAnalyticsConnectorHandleProvider;
  
  private Provider<AnalyticsConnector> providesAnalyticsConnectorProvider;
  
  private Provider<AnalyticsEventsManager> providesAnalyticsEventsManagerProvider;
  
  private Provider<ConnectableFlowable<String>> providesAppForegroundEventStreamProvider;
  
  private Provider<Application> providesApplicationProvider;
  
  private Provider<Scheduler> providesComputeSchedulerProvider;
  
  private Provider<ForegroundNotifier> providesForegroundProvider;
  
  private Provider<Channel> providesGrpcChannelProvider;
  
  private Provider<Scheduler> providesIOSchedulerProvider;
  
  private Provider<Scheduler> providesMainThreadSchedulerProvider;
  
  private Provider<ProtoStorageClient> providesProtoStorageClientForCampaignProvider;
  
  private Provider<ProtoStorageClient> providesProtoStorageClientForImpressionStoreProvider;
  
  private Provider<ProtoStorageClient> providesProtoStorageClientForLimiterStoreProvider;
  
  private Provider<String> providesServiceHostProvider;
  
  private Provider<Subscriber> providesSubsriberProvider;
  
  private Provider<Clock> providesSystemClockModuleProvider;
  
  private RateLimitModule rateLimitModule;
  
  private Provider<RateLimiterClient> rateLimiterClientProvider;
  
  private Provider<Schedulers> schedulersProvider;
  
  private SystemClockModule systemClockModule;
  
  private DaggerUniversalComponent(Builder paramBuilder) {
    initialize(paramBuilder);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  private void initialize(Builder paramBuilder) {
    this.providesServiceHostProvider = DoubleCheck.provider((Provider)GrpcChannelModule_ProvidesServiceHostFactory.create(paramBuilder.grpcChannelModule));
    this.providesGrpcChannelProvider = DoubleCheck.provider((Provider)GrpcChannelModule_ProvidesGrpcChannelFactory.create(paramBuilder.grpcChannelModule, this.providesServiceHostProvider));
    this.providesIOSchedulerProvider = DoubleCheck.provider((Provider)SchedulerModule_ProvidesIOSchedulerFactory.create(paramBuilder.schedulerModule));
    this.providesComputeSchedulerProvider = DoubleCheck.provider((Provider)SchedulerModule_ProvidesComputeSchedulerFactory.create(paramBuilder.schedulerModule));
    this.providesMainThreadSchedulerProvider = DoubleCheck.provider((Provider)SchedulerModule_ProvidesMainThreadSchedulerFactory.create(paramBuilder.schedulerModule));
    this.schedulersProvider = DoubleCheck.provider((Provider)Schedulers_Factory.create(this.providesIOSchedulerProvider, this.providesComputeSchedulerProvider, this.providesMainThreadSchedulerProvider));
    this.providesApplicationProvider = DoubleCheck.provider((Provider)ApplicationModule_ProvidesApplicationFactory.create(paramBuilder.applicationModule));
    this.providesForegroundProvider = DoubleCheck.provider((Provider)ForegroundNotifierModule_ProvidesForegroundFactory.create(paramBuilder.foregroundNotifierModule));
    this.providesAppForegroundEventStreamProvider = DoubleCheck.provider((Provider)ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory.create(paramBuilder.foregroundFlowableModule, this.providesApplicationProvider, this.providesForegroundProvider));
    this.providesAnalyticsConnectorProvider = DoubleCheck.provider((Provider)AppMeasurementModule_ProvidesAnalyticsConnectorFactory.create(paramBuilder.appMeasurementModule));
    this.providesAnalyticsEventsManagerProvider = DoubleCheck.provider((Provider)AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory.create(paramBuilder.analyticsEventsModule, this.providesAnalyticsConnectorProvider));
    this.providesAnalyticsConnectorEventsProvider = DoubleCheck.provider((Provider)AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory.create(paramBuilder.analyticsEventsModule, this.providesAnalyticsEventsManagerProvider));
    this.providesSubsriberProvider = DoubleCheck.provider((Provider)AppMeasurementModule_ProvidesSubsriberFactory.create(paramBuilder.appMeasurementModule));
    this.providesAnalyticsConnectorHandleProvider = DoubleCheck.provider((Provider)AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory.create(paramBuilder.analyticsEventsModule, this.providesAnalyticsEventsManagerProvider));
    this.providesProtoStorageClientForCampaignProvider = DoubleCheck.provider((Provider)ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory.create(paramBuilder.protoStorageClientModule, this.providesApplicationProvider));
    this.providesSystemClockModuleProvider = (Provider<Clock>)SystemClockModule_ProvidesSystemClockModuleFactory.create(paramBuilder.systemClockModule);
    this.campaignCacheClientProvider = DoubleCheck.provider((Provider)CampaignCacheClient_Factory.create(this.providesProtoStorageClientForCampaignProvider, this.providesApplicationProvider, this.providesSystemClockModuleProvider));
    this.providesProtoStorageClientForImpressionStoreProvider = DoubleCheck.provider((Provider)ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory.create(paramBuilder.protoStorageClientModule, this.providesApplicationProvider));
    this.impressionStorageClientProvider = DoubleCheck.provider((Provider)ImpressionStorageClient_Factory.create(this.providesProtoStorageClientForImpressionStoreProvider));
    this.systemClockModule = paramBuilder.systemClockModule;
    this.protoMarshallerClientProvider = DoubleCheck.provider((Provider)ProtoMarshallerClient_Factory.create());
    this.providesProtoStorageClientForLimiterStoreProvider = DoubleCheck.provider((Provider)ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory.create(paramBuilder.protoStorageClientModule, this.providesApplicationProvider));
    this.rateLimiterClientProvider = DoubleCheck.provider((Provider)RateLimiterClient_Factory.create(this.providesProtoStorageClientForLimiterStoreProvider, this.providesSystemClockModuleProvider));
    this.rateLimitModule = paramBuilder.rateLimitModule;
    this.developerListenerManagerProvider = DoubleCheck.provider((Provider)ApplicationModule_DeveloperListenerManagerFactory.create(paramBuilder.applicationModule));
  }
  
  public AnalyticsConnector analyticsConnector() {
    return (AnalyticsConnector)this.providesAnalyticsConnectorProvider.get();
  }
  
  public AnalyticsConnectorHandleManager analyticsConnectorHandleManager() {
    return (AnalyticsConnectorHandleManager)this.providesAnalyticsConnectorHandleProvider.get();
  }
  
  public ConnectableFlowable<String> analyticsEventsFlowable() {
    return (ConnectableFlowable<String>)this.providesAnalyticsConnectorEventsProvider.get();
  }
  
  public AnalyticsEventsManager analyticsEventsManager() {
    return (AnalyticsEventsManager)this.providesAnalyticsEventsManagerProvider.get();
  }
  
  public ConnectableFlowable<String> appForegroundEventFlowable() {
    return (ConnectableFlowable<String>)this.providesAppForegroundEventStreamProvider.get();
  }
  
  public RateLimit appForegroundRateLimit() {
    return (RateLimit)Preconditions.checkNotNull(this.rateLimitModule.providesAppForegroundRateLimit(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public Application application() {
    return (Application)this.providesApplicationProvider.get();
  }
  
  public CampaignCacheClient campaignCacheClient() {
    return (CampaignCacheClient)this.campaignCacheClientProvider.get();
  }
  
  public Clock clock() {
    return (Clock)Preconditions.checkNotNull(this.systemClockModule.providesSystemClockModule(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public DeveloperListenerManager developerListenerManager() {
    return (DeveloperListenerManager)this.developerListenerManagerProvider.get();
  }
  
  public Subscriber firebaseEventsSubscriber() {
    return (Subscriber)this.providesSubsriberProvider.get();
  }
  
  public Channel gRPCChannel() {
    return (Channel)this.providesGrpcChannelProvider.get();
  }
  
  public ImpressionStorageClient impressionStorageClient() {
    return (ImpressionStorageClient)this.impressionStorageClientProvider.get();
  }
  
  public ProtoMarshallerClient protoMarshallerClient() {
    return (ProtoMarshallerClient)this.protoMarshallerClientProvider.get();
  }
  
  public RateLimiterClient rateLimiterClient() {
    return (RateLimiterClient)this.rateLimiterClientProvider.get();
  }
  
  public Schedulers schedulers() {
    return (Schedulers)this.schedulersProvider.get();
  }
  
  public static final class Builder {
    private AnalyticsEventsModule analyticsEventsModule;
    
    private AppMeasurementModule appMeasurementModule;
    
    private ApplicationModule applicationModule;
    
    private ForegroundFlowableModule foregroundFlowableModule;
    
    private ForegroundNotifierModule foregroundNotifierModule;
    
    private GrpcChannelModule grpcChannelModule;
    
    private ProtoStorageClientModule protoStorageClientModule;
    
    private RateLimitModule rateLimitModule;
    
    private SchedulerModule schedulerModule;
    
    private SystemClockModule systemClockModule;
    
    private Builder() {}
    
    public Builder analyticsEventsModule(AnalyticsEventsModule param1AnalyticsEventsModule) {
      this.analyticsEventsModule = (AnalyticsEventsModule)Preconditions.checkNotNull(param1AnalyticsEventsModule);
      return this;
    }
    
    public Builder appMeasurementModule(AppMeasurementModule param1AppMeasurementModule) {
      this.appMeasurementModule = (AppMeasurementModule)Preconditions.checkNotNull(param1AppMeasurementModule);
      return this;
    }
    
    public Builder applicationModule(ApplicationModule param1ApplicationModule) {
      this.applicationModule = (ApplicationModule)Preconditions.checkNotNull(param1ApplicationModule);
      return this;
    }
    
    public UniversalComponent build() {
      if (this.grpcChannelModule == null)
        this.grpcChannelModule = new GrpcChannelModule(); 
      if (this.schedulerModule == null)
        this.schedulerModule = new SchedulerModule(); 
      if (this.applicationModule != null) {
        if (this.foregroundNotifierModule == null)
          this.foregroundNotifierModule = new ForegroundNotifierModule(); 
        if (this.foregroundFlowableModule == null)
          this.foregroundFlowableModule = new ForegroundFlowableModule(); 
        if (this.appMeasurementModule != null) {
          if (this.analyticsEventsModule == null)
            this.analyticsEventsModule = new AnalyticsEventsModule(); 
          if (this.protoStorageClientModule == null)
            this.protoStorageClientModule = new ProtoStorageClientModule(); 
          if (this.systemClockModule == null)
            this.systemClockModule = new SystemClockModule(); 
          if (this.rateLimitModule == null)
            this.rateLimitModule = new RateLimitModule(); 
          return new DaggerUniversalComponent(this);
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(AppMeasurementModule.class.getCanonicalName());
        stringBuilder1.append(" must be set");
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ApplicationModule.class.getCanonicalName());
      stringBuilder.append(" must be set");
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public Builder foregroundFlowableModule(ForegroundFlowableModule param1ForegroundFlowableModule) {
      this.foregroundFlowableModule = (ForegroundFlowableModule)Preconditions.checkNotNull(param1ForegroundFlowableModule);
      return this;
    }
    
    public Builder foregroundNotifierModule(ForegroundNotifierModule param1ForegroundNotifierModule) {
      this.foregroundNotifierModule = (ForegroundNotifierModule)Preconditions.checkNotNull(param1ForegroundNotifierModule);
      return this;
    }
    
    public Builder grpcChannelModule(GrpcChannelModule param1GrpcChannelModule) {
      this.grpcChannelModule = (GrpcChannelModule)Preconditions.checkNotNull(param1GrpcChannelModule);
      return this;
    }
    
    public Builder protoStorageClientModule(ProtoStorageClientModule param1ProtoStorageClientModule) {
      this.protoStorageClientModule = (ProtoStorageClientModule)Preconditions.checkNotNull(param1ProtoStorageClientModule);
      return this;
    }
    
    public Builder rateLimitModule(RateLimitModule param1RateLimitModule) {
      this.rateLimitModule = (RateLimitModule)Preconditions.checkNotNull(param1RateLimitModule);
      return this;
    }
    
    public Builder schedulerModule(SchedulerModule param1SchedulerModule) {
      this.schedulerModule = (SchedulerModule)Preconditions.checkNotNull(param1SchedulerModule);
      return this;
    }
    
    public Builder systemClockModule(SystemClockModule param1SystemClockModule) {
      this.systemClockModule = (SystemClockModule)Preconditions.checkNotNull(param1SystemClockModule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\components\DaggerUniversalComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */