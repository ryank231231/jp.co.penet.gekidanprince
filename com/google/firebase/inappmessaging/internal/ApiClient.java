package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@FirebaseAppScope
public class ApiClient {
  private static final String DATA_COLLECTION_DISABLED_ERROR = "Automatic data collection is disabled, not attempting campaign fetch from service.";
  
  private static final String FETCHING_CAMPAIGN_MESSAGE = "Fetching campaigns from service.";
  
  private static final String IID_NOT_INITIALIZED_ERROR = "FirebaseInstanceId not yet initialized, not attempting campaign fetch from service.";
  
  private final Application application;
  
  private final Clock clock;
  
  private final DataCollectionHelper dataCollectionHelper;
  
  private final FirebaseApp firebaseApp;
  
  private final FirebaseInstanceId firebaseInstanceId;
  
  private final GrpcClient grpcClient;
  
  public ApiClient(GrpcClient paramGrpcClient, FirebaseApp paramFirebaseApp, Application paramApplication, FirebaseInstanceId paramFirebaseInstanceId, DataCollectionHelper paramDataCollectionHelper, Clock paramClock) {
    this.grpcClient = paramGrpcClient;
    this.firebaseApp = paramFirebaseApp;
    this.application = paramApplication;
    this.firebaseInstanceId = paramFirebaseInstanceId;
    this.dataCollectionHelper = paramDataCollectionHelper;
    this.clock = paramClock;
  }
  
  @VisibleForTesting
  static FetchEligibleCampaignsResponse createCacheExpiringResponse() {
    return (FetchEligibleCampaignsResponse)FetchEligibleCampaignsResponse.newBuilder().setExpirationEpochTimestampMillis(1L).build();
  }
  
  private ClientAppInfo getClientAppInfo() {
    ClientAppInfo.Builder builder = ClientAppInfo.newBuilder().setGmpAppId(this.firebaseApp.getOptions().getApplicationId());
    String str = this.firebaseInstanceId.getId();
    if (!TextUtils.isEmpty(str))
      builder.setAppInstanceId(str); 
    str = this.firebaseInstanceId.getToken();
    if (!TextUtils.isEmpty(str))
      builder.setAppInstanceIdToken(str); 
    return (ClientAppInfo)builder.build();
  }
  
  private ClientSignalsProto.ClientSignals getClientSignals() {
    ClientSignalsProto.ClientSignals.Builder builder = ClientSignalsProto.ClientSignals.newBuilder().setPlatformVersion(String.valueOf(Build.VERSION.SDK_INT)).setLanguageCode(Locale.getDefault().toString()).setTimeZone(TimeZone.getDefault().getID());
    String str = getVersionName();
    if (!TextUtils.isEmpty(str))
      builder.setAppVersion(str); 
    return (ClientSignalsProto.ClientSignals)builder.build();
  }
  
  @Nullable
  private String getVersionName() {
    try {
      return (this.application.getPackageManager().getPackageInfo(this.application.getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error finding versionName : ");
      stringBuilder.append(nameNotFoundException.getMessage());
      Logging.loge(stringBuilder.toString());
      return null;
    } 
  }
  
  private boolean isFirebaseTokenInitialized() {
    boolean bool;
    if (!TextUtils.isEmpty(this.firebaseInstanceId.getToken()) && !TextUtils.isEmpty(this.firebaseInstanceId.getId())) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private FetchEligibleCampaignsResponse withCacheExpirationSafeguards(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    return (paramFetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() < this.clock.now() + TimeUnit.MINUTES.toMillis(1L) || paramFetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() > this.clock.now() + TimeUnit.DAYS.toMillis(3L)) ? (FetchEligibleCampaignsResponse)((FetchEligibleCampaignsResponse.Builder)paramFetchEligibleCampaignsResponse.toBuilder()).setExpirationEpochTimestampMillis(this.clock.now() + TimeUnit.DAYS.toMillis(1L)).build() : paramFetchEligibleCampaignsResponse;
  }
  
  FetchEligibleCampaignsResponse getFiams(CampaignImpressionList paramCampaignImpressionList) {
    if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
      Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
      return createCacheExpiringResponse();
    } 
    if (!isFirebaseTokenInitialized()) {
      Logging.logi("FirebaseInstanceId not yet initialized, not attempting campaign fetch from service.");
      return createCacheExpiringResponse();
    } 
    Logging.logi("Fetching campaigns from service.");
    return withCacheExpirationSafeguards(this.grpcClient.fetchEligibleCampaigns((FetchEligibleCampaignsRequest)FetchEligibleCampaignsRequest.newBuilder().setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).addAllAlreadySeenCampaigns(paramCampaignImpressionList.getAlreadySeenCampaignsList()).setClientSignals(getClientSignals()).setRequestingClientApp(getClientAppInfo()).build()));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\ApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */