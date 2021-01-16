package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

public class AnalyticsConnectorHandleManager {
  @VisibleForTesting
  static final String TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR = "Too many contextual triggers defined - limiting to 50";
  
  private AnalyticsConnector.AnalyticsConnectorHandle analyticsHandle;
  
  @Inject
  public AnalyticsConnectorHandleManager(AnalyticsConnector.AnalyticsConnectorHandle paramAnalyticsConnectorHandle) {
    this.analyticsHandle = paramAnalyticsConnectorHandle;
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
  
  public void updateContextualTriggers(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    this.analyticsHandle.registerEventNames(extractAnalyticsEventNames(paramFetchEligibleCampaignsResponse));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\AnalyticsConnectorHandleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */