package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface FetchEligibleCampaignsRequestOrBuilder extends MessageLiteOrBuilder {
  CampaignImpression getAlreadySeenCampaigns(int paramInt);
  
  int getAlreadySeenCampaignsCount();
  
  List<CampaignImpression> getAlreadySeenCampaignsList();
  
  ClientSignalsProto.ClientSignals getClientSignals();
  
  String getProjectNumber();
  
  ByteString getProjectNumberBytes();
  
  ClientAppInfo getRequestingClientApp();
  
  boolean hasClientSignals();
  
  boolean hasRequestingClientApp();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\sdkserving\FetchEligibleCampaignsRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */