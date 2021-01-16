package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Locale;
import javax.inject.Inject;
import org.reactivestreams.Publisher;

@FirebaseAppScope
public class InAppMessageStreamManager {
  public static final String ON_FOREGROUND = "ON_FOREGROUND";
  
  private final AnalyticsEventsManager analyticsEventsManager;
  
  private final ApiClient apiClient;
  
  private final ConnectableFlowable<String> appForegroundEventFlowable;
  
  private final RateLimit appForegroundRateLimit;
  
  private final CampaignCacheClient campaignCacheClient;
  
  private final Clock clock;
  
  private final ImpressionStorageClient impressionStorageClient;
  
  private final RateLimiterClient rateLimiterClient;
  
  private final Schedulers schedulers;
  
  private final TestDeviceHelper testDeviceHelper;
  
  @Inject
  public InAppMessageStreamManager(@AppForeground ConnectableFlowable<String> paramConnectableFlowable, CampaignCacheClient paramCampaignCacheClient, Clock paramClock, ApiClient paramApiClient, AnalyticsEventsManager paramAnalyticsEventsManager, Schedulers paramSchedulers, ImpressionStorageClient paramImpressionStorageClient, RateLimiterClient paramRateLimiterClient, @AppForeground RateLimit paramRateLimit, TestDeviceHelper paramTestDeviceHelper) {
    this.appForegroundEventFlowable = paramConnectableFlowable;
    this.campaignCacheClient = paramCampaignCacheClient;
    this.clock = paramClock;
    this.apiClient = paramApiClient;
    this.analyticsEventsManager = paramAnalyticsEventsManager;
    this.schedulers = paramSchedulers;
    this.impressionStorageClient = paramImpressionStorageClient;
    this.rateLimiterClient = paramRateLimiterClient;
    this.appForegroundRateLimit = paramRateLimit;
    this.testDeviceHelper = paramTestDeviceHelper;
  }
  
  private static int compareByPriority(CampaignProto.ThickContent paramThickContent1, CampaignProto.ThickContent paramThickContent2) {
    return (paramThickContent1.getIsTestCampaign() && !paramThickContent2.getIsTestCampaign()) ? -1 : ((paramThickContent2.getIsTestCampaign() && !paramThickContent1.getIsTestCampaign()) ? 1 : Integer.compare(paramThickContent1.getPriority().getValue(), paramThickContent2.getPriority().getValue()));
  }
  
  private static boolean containsTriggeringCondition(String paramString, CampaignProto.ThickContent paramThickContent) {
    if (isAppForegroundEvent(paramString) && paramThickContent.getIsTestCampaign())
      return true; 
    for (CommonTypesProto.TriggeringCondition triggeringCondition : paramThickContent.getTriggeringConditionsList()) {
      if (hasFiamTrigger(triggeringCondition, paramString) || hasAnalyticsTrigger(triggeringCondition, paramString)) {
        Logging.logd(String.format("The event %s is contained in the list of triggers", new Object[] { paramString }));
        return true;
      } 
    } 
    return false;
  }
  
  private Maybe<CampaignProto.ThickContent> getContentIfNotRateLimited(String paramString, CampaignProto.ThickContent paramThickContent) {
    return (!paramThickContent.getIsTestCampaign() && isAppForegroundEvent(paramString)) ? this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit).doOnSuccess(InAppMessageStreamManager$$Lambda$3.lambdaFactory$()).onErrorResumeNext(Single.just(Boolean.valueOf(false))).filter(InAppMessageStreamManager$$Lambda$4.lambdaFactory$()).map(InAppMessageStreamManager$$Lambda$5.lambdaFactory$(paramThickContent)) : Maybe.just(paramThickContent);
  }
  
  private Maybe<TriggeredInAppMessage> getTriggeredInAppMessageMaybe(String paramString, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> paramFunction1, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> paramFunction2, Function<CampaignProto.ThickContent, Maybe<CampaignProto.ThickContent>> paramFunction3, FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    return Flowable.fromIterable(paramFetchEligibleCampaignsResponse.getMessagesList()).filter(InAppMessageStreamManager$$Lambda$6.lambdaFactory$()).filter(InAppMessageStreamManager$$Lambda$7.lambdaFactory$(this)).filter(InAppMessageStreamManager$$Lambda$8.lambdaFactory$(paramString)).flatMapMaybe(paramFunction1).flatMapMaybe(paramFunction2).flatMapMaybe(paramFunction3).sorted(InAppMessageStreamManager$$Lambda$9.lambdaFactory$()).firstElement().flatMap(InAppMessageStreamManager$$Lambda$10.lambdaFactory$(this, paramString));
  }
  
  private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition paramTriggeringCondition, String paramString) {
    boolean bool;
    if (paramTriggeringCondition.getEvent() != null && paramTriggeringCondition.getEvent().getName().toString().equals(paramString)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition paramTriggeringCondition, String paramString) {
    boolean bool;
    if (paramTriggeringCondition.getFiamTrigger() != null && paramTriggeringCondition.getFiamTrigger().toString().equals(paramString)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static boolean isActive(Clock paramClock, CampaignProto.VanillaCampaignPayload paramVanillaCampaignPayload) {
    boolean bool;
    long l1 = paramVanillaCampaignPayload.getCampaignStartTimeMillis();
    long l2 = paramVanillaCampaignPayload.getCampaignEndTimeMillis();
    long l3 = paramClock.now();
    if (l3 > l1 && l3 < l2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition paramTriggeringCondition) {
    boolean bool;
    if (paramTriggeringCondition.getFiamTrigger() != null && paramTriggeringCondition.getFiamTrigger().toString().equals("ON_FOREGROUND")) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isAppForegroundEvent(String paramString) {
    return paramString.equals("ON_FOREGROUND");
  }
  
  private boolean shouldIgnoreCache(String paramString) {
    return this.testDeviceHelper.isAppInstallFresh() ? isAppForegroundEvent(paramString) : this.testDeviceHelper.isDeviceInTestMode();
  }
  
  private Maybe<TriggeredInAppMessage> triggeredInAppMessage(CampaignProto.ThickContent paramThickContent, String paramString) {
    InAppMessage inAppMessage = ProtoMarshallerClient.decode(paramThickContent.getContent(), paramThickContent.getVanillaPayload().getCampaignId(), paramThickContent.getVanillaPayload().getCampaignName(), paramThickContent.getIsTestCampaign());
    return inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED) ? Maybe.empty() : Maybe.just(new TriggeredInAppMessage(inAppMessage, paramString));
  }
  
  public Flowable<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
    return Flowable.merge((Publisher)this.appForegroundEventFlowable, (Publisher)this.analyticsEventsManager.getAnalyticsEventsFlowable()).doOnNext(InAppMessageStreamManager$$Lambda$1.lambdaFactory$()).observeOn(this.schedulers.io()).concatMap(InAppMessageStreamManager$$Lambda$2.lambdaFactory$(this)).observeOn(this.schedulers.mainThread());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\InAppMessageStreamManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */