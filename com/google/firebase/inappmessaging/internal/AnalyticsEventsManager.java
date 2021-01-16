package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.flowables.ConnectableFlowable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

public class AnalyticsEventsManager {
  @VisibleForTesting
  static final String TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR = "Too many contextual triggers defined - limiting to 50";
  
  private final AnalyticsConnector analyticsConnector;
  
  private final ConnectableFlowable<String> flowable;
  
  private AnalyticsConnector.AnalyticsConnectorHandle handle;
  
  public AnalyticsEventsManager(AnalyticsConnector paramAnalyticsConnector) {
    this.analyticsConnector = paramAnalyticsConnector;
    this.flowable = Flowable.create(new AnalyticsFlowableSubscriber(), BackpressureStrategy.BUFFER).publish();
    this.flowable.connect();
  }
  
  @VisibleForTesting
  static Set<String> extractAnalyticsEventNames(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    HashSet<String> hashSet = new HashSet();
    Iterator<CampaignProto.ThickContent> iterator = paramFetchEligibleCampaignsResponse.getMessagesList().iterator();
    while (iterator.hasNext()) {
      for (CommonTypesProto.TriggeringCondition triggeringCondition : ((CampaignProto.ThickContent)iterator.next()).getTriggeringConditionsList()) {
        if (triggeringCondition.getEvent() != null && !TextUtils.isEmpty(triggeringCondition.getEvent().getName()))
          hashSet.add(triggeringCondition.getEvent().getName()); 
      } 
    } 
    if (hashSet.size() > 50)
      Logging.logi("Too many contextual triggers defined - limiting to 50"); 
    return hashSet;
  }
  
  public ConnectableFlowable<String> getAnalyticsEventsFlowable() {
    return this.flowable;
  }
  
  @Nullable
  public AnalyticsConnector.AnalyticsConnectorHandle getHandle() {
    return this.handle;
  }
  
  public void updateContextualTriggers(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    Set<String> set = extractAnalyticsEventNames(paramFetchEligibleCampaignsResponse);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Updating contextual triggers for the following analytics events: ");
    stringBuilder.append(set);
    Logging.logd(stringBuilder.toString());
    this.handle.registerEventNames(set);
  }
  
  private class AnalyticsFlowableSubscriber implements FlowableOnSubscribe<String> {
    public void subscribe(FlowableEmitter<String> param1FlowableEmitter) {
      Logging.logd("Subscribing to analytics events.");
      AnalyticsEventsManager analyticsEventsManager = AnalyticsEventsManager.this;
      AnalyticsEventsManager.access$002(analyticsEventsManager, analyticsEventsManager.analyticsConnector.registerAnalyticsConnectorListener("fiam", new FiamAnalyticsConnectorListener(param1FlowableEmitter)));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\AnalyticsEventsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */