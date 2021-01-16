package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DisplayCallbacksFactory_Factory implements Factory<DisplayCallbacksFactory> {
  private final Provider<RateLimit> appForegroundRateLimitProvider;
  
  private final Provider<CampaignCacheClient> campaignCacheClientProvider;
  
  private final Provider<Clock> clockProvider;
  
  private final Provider<DataCollectionHelper> dataCollectionHelperProvider;
  
  private final Provider<ImpressionStorageClient> impressionStorageClientProvider;
  
  private final Provider<MetricsLoggerClient> metricsLoggerClientProvider;
  
  private final Provider<RateLimiterClient> rateLimiterClientProvider;
  
  private final Provider<Schedulers> schedulersProvider;
  
  public DisplayCallbacksFactory_Factory(Provider<ImpressionStorageClient> paramProvider, Provider<Clock> paramProvider1, Provider<Schedulers> paramProvider2, Provider<RateLimiterClient> paramProvider3, Provider<CampaignCacheClient> paramProvider4, Provider<RateLimit> paramProvider5, Provider<MetricsLoggerClient> paramProvider6, Provider<DataCollectionHelper> paramProvider7) {
    this.impressionStorageClientProvider = paramProvider;
    this.clockProvider = paramProvider1;
    this.schedulersProvider = paramProvider2;
    this.rateLimiterClientProvider = paramProvider3;
    this.campaignCacheClientProvider = paramProvider4;
    this.appForegroundRateLimitProvider = paramProvider5;
    this.metricsLoggerClientProvider = paramProvider6;
    this.dataCollectionHelperProvider = paramProvider7;
  }
  
  public static Factory<DisplayCallbacksFactory> create(Provider<ImpressionStorageClient> paramProvider, Provider<Clock> paramProvider1, Provider<Schedulers> paramProvider2, Provider<RateLimiterClient> paramProvider3, Provider<CampaignCacheClient> paramProvider4, Provider<RateLimit> paramProvider5, Provider<MetricsLoggerClient> paramProvider6, Provider<DataCollectionHelper> paramProvider7) {
    return new DisplayCallbacksFactory_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7);
  }
  
  public DisplayCallbacksFactory get() {
    return new DisplayCallbacksFactory((ImpressionStorageClient)this.impressionStorageClientProvider.get(), (Clock)this.clockProvider.get(), (Schedulers)this.schedulersProvider.get(), (RateLimiterClient)this.rateLimiterClientProvider.get(), (CampaignCacheClient)this.campaignCacheClientProvider.get(), (RateLimit)this.appForegroundRateLimitProvider.get(), (MetricsLoggerClient)this.metricsLoggerClientProvider.get(), (DataCollectionHelper)this.dataCollectionHelperProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\DisplayCallbacksFactory_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */