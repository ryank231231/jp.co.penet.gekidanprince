package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.protobuf.AbstractMessageLite;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
public class CampaignCacheClient {
  private final Application application;
  
  @Nullable
  private FetchEligibleCampaignsResponse cachedResponse;
  
  private final Clock clock;
  
  private final ProtoStorageClient storageClient;
  
  @Inject
  CampaignCacheClient(@CampaignCache ProtoStorageClient paramProtoStorageClient, Application paramApplication, Clock paramClock) {
    this.storageClient = paramProtoStorageClient;
    this.application = paramApplication;
    this.clock = paramClock;
  }
  
  private boolean isResponseValid(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    long l1 = paramFetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis();
    long l2 = this.clock.now();
    File file = new File(this.application.getApplicationContext().getFilesDir(), "fiam_eligible_campaigns_cache_file");
    boolean bool1 = false;
    boolean bool2 = false;
    if (l1 != 0L) {
      if (l2 < l1)
        bool2 = true; 
      return bool2;
    } 
    if (file.exists()) {
      bool2 = bool1;
      if (l2 < file.lastModified() + TimeUnit.DAYS.toMillis(1L))
        bool2 = true; 
      return bool2;
    } 
    return true;
  }
  
  public Maybe<FetchEligibleCampaignsResponse> get() {
    return Maybe.fromCallable(CampaignCacheClient$$Lambda$2.lambdaFactory$(this)).switchIfEmpty((MaybeSource)this.storageClient.<AbstractMessageLite>read(FetchEligibleCampaignsResponse.parser()).doOnSuccess(CampaignCacheClient$$Lambda$3.lambdaFactory$(this))).filter(CampaignCacheClient$$Lambda$4.lambdaFactory$(this)).doOnError(CampaignCacheClient$$Lambda$5.lambdaFactory$(this));
  }
  
  public Completable put(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    return this.storageClient.write((AbstractMessageLite)paramFetchEligibleCampaignsResponse).doOnComplete(CampaignCacheClient$$Lambda$1.lambdaFactory$(this, paramFetchEligibleCampaignsResponse));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\CampaignCacheClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */