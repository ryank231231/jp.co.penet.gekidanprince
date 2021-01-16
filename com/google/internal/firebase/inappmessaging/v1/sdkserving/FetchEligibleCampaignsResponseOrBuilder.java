package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface FetchEligibleCampaignsResponseOrBuilder extends MessageLiteOrBuilder {
  long getExpirationEpochTimestampMillis();
  
  CampaignProto.ThickContent getMessages(int paramInt);
  
  int getMessagesCount();
  
  List<CampaignProto.ThickContent> getMessagesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\sdkserving\FetchEligibleCampaignsResponseOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */