package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import dagger.internal.Factory;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

public final class InAppMessageStreamManager_Factory implements Factory<InAppMessageStreamManager> {
  private final Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
  
  private final Provider<ApiClient> apiClientProvider;
  
  private final Provider<ConnectableFlowable<String>> appForegroundEventFlowableProvider;
  
  private final Provider<RateLimit> appForegroundRateLimitProvider;
  
  private final Provider<CampaignCacheClient> campaignCacheClientProvider;
  
  private final Provider<Clock> clockProvider;
  
  private final Provider<ImpressionStorageClient> impressionStorageClientProvider;
  
  private final Provider<RateLimiterClient> rateLimiterClientProvider;
  
  private final Provider<Schedulers> schedulersProvider;
  
  private final Provider<TestDeviceHelper> testDeviceHelperProvider;
  
  public InAppMessageStreamManager_Factory(Provider<ConnectableFlowable<String>> paramProvider, Provider<CampaignCacheClient> paramProvider1, Provider<Clock> paramProvider2, Provider<ApiClient> paramProvider3, Provider<AnalyticsEventsManager> paramProvider4, Provider<Schedulers> paramProvider5, Provider<ImpressionStorageClient> paramProvider6, Provider<RateLimiterClient> paramProvider7, Provider<RateLimit> paramProvider8, Provider<TestDeviceHelper> paramProvider9) {
    this.appForegroundEventFlowableProvider = paramProvider;
    this.campaignCacheClientProvider = paramProvider1;
    this.clockProvider = paramProvider2;
    this.apiClientProvider = paramProvider3;
    this.analyticsEventsManagerProvider = paramProvider4;
    this.schedulersProvider = paramProvider5;
    this.impressionStorageClientProvider = paramProvider6;
    this.rateLimiterClientProvider = paramProvider7;
    this.appForegroundRateLimitProvider = paramProvider8;
    this.testDeviceHelperProvider = paramProvider9;
  }
  
  public static Factory<InAppMessageStreamManager> create(Provider<ConnectableFlowable<String>> paramProvider, Provider<CampaignCacheClient> paramProvider1, Provider<Clock> paramProvider2, Provider<ApiClient> paramProvider3, Provider<AnalyticsEventsManager> paramProvider4, Provider<Schedulers> paramProvider5, Provider<ImpressionStorageClient> paramProvider6, Provider<RateLimiterClient> paramProvider7, Provider<RateLimit> paramProvider8, Provider<TestDeviceHelper> paramProvider9) {
    return new InAppMessageStreamManager_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9);
  }
  
  public InAppMessageStreamManager get() {
    return new InAppMessageStreamManager((ConnectableFlowable<String>)this.appForegroundEventFlowableProvider.get(), (CampaignCacheClient)this.campaignCacheClientProvider.get(), (Clock)this.clockProvider.get(), (ApiClient)this.apiClientProvider.get(), (AnalyticsEventsManager)this.analyticsEventsManagerProvider.get(), (Schedulers)this.schedulersProvider.get(), (ImpressionStorageClient)this.impressionStorageClientProvider.get(), (RateLimiterClient)this.rateLimiterClientProvider.get(), (RateLimit)this.appForegroundRateLimitProvider.get(), (TestDeviceHelper)this.testDeviceHelperProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\InAppMessageStreamManager_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */