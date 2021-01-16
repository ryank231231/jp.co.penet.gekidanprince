package com.google.firebase.inappmessaging;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface CampaignAnalyticsOrBuilder extends MessageLiteOrBuilder {
  String getCampaignId();
  
  ByteString getCampaignIdBytes();
  
  int getClearcutDeliveryRetryCount();
  
  ClientAppInfo getClientApp();
  
  long getClientTimestampMillis();
  
  DismissType getDismissType();
  
  CampaignAnalytics.EventCase getEventCase();
  
  EventType getEventType();
  
  FetchErrorReason getFetchErrorReason();
  
  String getFiamSdkVersion();
  
  ByteString getFiamSdkVersionBytes();
  
  String getProjectNumber();
  
  ByteString getProjectNumberBytes();
  
  RenderErrorReason getRenderErrorReason();
  
  boolean hasCampaignId();
  
  boolean hasClearcutDeliveryRetryCount();
  
  boolean hasClientApp();
  
  boolean hasClientTimestampMillis();
  
  boolean hasDismissType();
  
  boolean hasEventType();
  
  boolean hasFetchErrorReason();
  
  boolean hasFiamSdkVersion();
  
  boolean hasProjectNumber();
  
  boolean hasRenderErrorReason();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\CampaignAnalyticsOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */