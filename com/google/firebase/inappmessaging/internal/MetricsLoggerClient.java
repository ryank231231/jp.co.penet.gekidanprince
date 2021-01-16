package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.HashMap;
import java.util.Map;

public class MetricsLoggerClient {
  private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> dismissTransform;
  
  private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> errorTransform = new HashMap<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason>();
  
  private final AnalyticsConnector analyticsConnector;
  
  private final ClearcutLoggerInterface clearcutLogger;
  
  private final Clock clock;
  
  private final DeveloperListenerManager developerListenerManager;
  
  private final FirebaseApp firebaseApp;
  
  private final FirebaseInstanceId firebaseInstanceId;
  
  static {
    dismissTransform = new HashMap<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType>();
    errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
    errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
    errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
    errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
    dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
    dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
    dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
    dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
  }
  
  public MetricsLoggerClient(ClearcutLoggerInterface paramClearcutLoggerInterface, AnalyticsConnector paramAnalyticsConnector, FirebaseApp paramFirebaseApp, FirebaseInstanceId paramFirebaseInstanceId, Clock paramClock, DeveloperListenerManager paramDeveloperListenerManager) {
    this.clearcutLogger = paramClearcutLoggerInterface;
    this.analyticsConnector = paramAnalyticsConnector;
    this.firebaseApp = paramFirebaseApp;
    this.firebaseInstanceId = paramFirebaseInstanceId;
    this.clock = paramClock;
    this.developerListenerManager = paramDeveloperListenerManager;
  }
  
  private CampaignAnalytics.Builder createCampaignAnalyticsBuilder(InAppMessage paramInAppMessage) {
    ClientAppInfo clientAppInfo = createClientAppInfo();
    return CampaignAnalytics.newBuilder().setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).setCampaignId(paramInAppMessage.getCampaignMetadata().getCampaignId()).setClientApp(clientAppInfo).setClientTimestampMillis(this.clock.now());
  }
  
  private ClientAppInfo createClientAppInfo() {
    return (ClientAppInfo)ClientAppInfo.newBuilder().setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setFirebaseInstanceId(this.firebaseInstanceId.getId()).build();
  }
  
  private CampaignAnalytics createDismissEntry(InAppMessage paramInAppMessage, DismissType paramDismissType) {
    return (CampaignAnalytics)createCampaignAnalyticsBuilder(paramInAppMessage).setDismissType(paramDismissType).build();
  }
  
  private CampaignAnalytics createEventEntry(InAppMessage paramInAppMessage, EventType paramEventType) {
    return (CampaignAnalytics)createCampaignAnalyticsBuilder(paramInAppMessage).setEventType(paramEventType).build();
  }
  
  private CampaignAnalytics createRenderErrorEntry(InAppMessage paramInAppMessage, RenderErrorReason paramRenderErrorReason) {
    return (CampaignAnalytics)createCampaignAnalyticsBuilder(paramInAppMessage).setRenderErrorReason(paramRenderErrorReason).build();
  }
  
  private boolean hasActionDefined(InAppMessage paramInAppMessage) {
    boolean bool;
    if (paramInAppMessage.getAction() != null && !paramInAppMessage.getAction().getActionUrl().isEmpty()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean isTestCampaign(InAppMessage paramInAppMessage) {
    return paramInAppMessage.getCampaignMetadata().getIsTestMessage();
  }
  
  private void logEventAsync(InAppMessage paramInAppMessage, String paramString, boolean paramBoolean) {
    String str = paramInAppMessage.getCampaignMetadata().getCampaignId();
    Bundle bundle = collectAnalyticsParams(paramInAppMessage.getCampaignMetadata().getCampaignName(), str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Sending event=");
    stringBuilder.append(paramString);
    stringBuilder.append(" params=");
    stringBuilder.append(bundle);
    Logging.logd(stringBuilder.toString());
    AnalyticsConnector analyticsConnector = this.analyticsConnector;
    if (analyticsConnector != null) {
      analyticsConnector.logEvent("fiam", paramString, bundle);
      if (paramBoolean) {
        AnalyticsConnector analyticsConnector1 = this.analyticsConnector;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("fiam:");
        stringBuilder1.append(str);
        analyticsConnector1.setUserProperty("fiam", "_ln", stringBuilder1.toString());
      } 
    } else {
      Logging.logw("Unable to log event: analytics library is missing");
    } 
  }
  
  Bundle collectAnalyticsParams(String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putString("_nmid", paramString2);
    bundle.putString("_nmn", paramString1);
    try {
      bundle.putInt("_ndt", (int)(this.clock.now() / 1000L));
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error while parsing use_device_time in FIAM event: ");
      stringBuilder.append(numberFormatException.getMessage());
      Logging.logw(stringBuilder.toString());
    } 
    return bundle;
  }
  
  public void logDismiss(InAppMessage paramInAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType paramInAppMessagingDismissType) {
    if (isTestCampaign(paramInAppMessage))
      return; 
    this.clearcutLogger.logEvent(createDismissEntry(paramInAppMessage, dismissTransform.get(paramInAppMessagingDismissType)).toByteArray());
    logEventAsync(paramInAppMessage, "firebase_in_app_message_dismiss", false);
  }
  
  public void logImpression(InAppMessage paramInAppMessage) {
    if (isTestCampaign(paramInAppMessage))
      return; 
    this.clearcutLogger.logEvent(createEventEntry(paramInAppMessage, EventType.IMPRESSION_EVENT_TYPE).toByteArray());
    logEventAsync(paramInAppMessage, "firebase_in_app_message_impression", hasActionDefined(paramInAppMessage) ^ true);
    this.developerListenerManager.impressionDetected(paramInAppMessage);
  }
  
  public void logMessageClick(InAppMessage paramInAppMessage, Action paramAction) {
    if (isTestCampaign(paramInAppMessage))
      return; 
    this.clearcutLogger.logEvent(createEventEntry(paramInAppMessage, EventType.CLICK_EVENT_TYPE).toByteArray());
    logEventAsync(paramInAppMessage, "firebase_in_app_message_action", true);
    this.developerListenerManager.messageClicked(paramInAppMessage, paramAction);
  }
  
  public void logRenderError(InAppMessage paramInAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason paramInAppMessagingErrorReason) {
    if (isTestCampaign(paramInAppMessage))
      return; 
    this.clearcutLogger.logEvent(createRenderErrorEntry(paramInAppMessage, errorTransform.get(paramInAppMessagingErrorReason)).toByteArray());
    this.developerListenerManager.displayErrorEncountered(paramInAppMessage, paramInAppMessagingErrorReason);
  }
  
  public static interface ClearcutLoggerInterface {
    void logEvent(byte[] param1ArrayOfbyte);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\MetricsLoggerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */