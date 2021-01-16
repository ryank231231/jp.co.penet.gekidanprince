package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import javax.inject.Inject;

public class DisplayCallbacksFactory {
  private final RateLimit appForegroundRateLimit;
  
  private final CampaignCacheClient campaignCacheClient;
  
  private final Clock clock;
  
  private final DataCollectionHelper dataCollectionHelper;
  
  private final ImpressionStorageClient impressionStorageClient;
  
  private final MetricsLoggerClient metricsLoggerClient;
  
  private final RateLimiterClient rateLimiterClient;
  
  private final Schedulers schedulers;
  
  @Inject
  public DisplayCallbacksFactory(ImpressionStorageClient paramImpressionStorageClient, Clock paramClock, Schedulers paramSchedulers, RateLimiterClient paramRateLimiterClient, CampaignCacheClient paramCampaignCacheClient, @AppForeground RateLimit paramRateLimit, MetricsLoggerClient paramMetricsLoggerClient, DataCollectionHelper paramDataCollectionHelper) {
    this.impressionStorageClient = paramImpressionStorageClient;
    this.clock = paramClock;
    this.schedulers = paramSchedulers;
    this.rateLimiterClient = paramRateLimiterClient;
    this.campaignCacheClient = paramCampaignCacheClient;
    this.appForegroundRateLimit = paramRateLimit;
    this.metricsLoggerClient = paramMetricsLoggerClient;
    this.dataCollectionHelper = paramDataCollectionHelper;
  }
  
  public FirebaseInAppMessagingDisplayCallbacks generateDisplayCallback(InAppMessage paramInAppMessage, String paramString) {
    return new DisplayCallbacksImpl(this.impressionStorageClient, this.clock, this.schedulers, this.rateLimiterClient, this.campaignCacheClient, this.appForegroundRateLimit, this.metricsLoggerClient, this.dataCollectionHelper, paramInAppMessage, paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\DisplayCallbacksFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */