package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ProtoStorageClientModule {
  public static final String CAMPAIGN_CACHE_FILE = "fiam_eligible_campaigns_cache_file";
  
  public static final String IMPRESSIONS_STORE_FILE = "fiam_impressions_store_file";
  
  public static final String RATE_LIMIT_STORE_FILE = "rate_limit_store_file";
  
  @CampaignCache
  @Provides
  @Singleton
  public ProtoStorageClient providesProtoStorageClientForCampaign(Application paramApplication) {
    return new ProtoStorageClient(paramApplication, "fiam_eligible_campaigns_cache_file");
  }
  
  @ImpressionStore
  @Provides
  @Singleton
  public ProtoStorageClient providesProtoStorageClientForImpressionStore(Application paramApplication) {
    return new ProtoStorageClient(paramApplication, "fiam_impressions_store_file");
  }
  
  @RateLimit
  @Provides
  @Singleton
  public ProtoStorageClient providesProtoStorageClientForLimiterStore(Application paramApplication) {
    return new ProtoStorageClient(paramApplication, "rate_limit_store_file");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ProtoStorageClientModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */