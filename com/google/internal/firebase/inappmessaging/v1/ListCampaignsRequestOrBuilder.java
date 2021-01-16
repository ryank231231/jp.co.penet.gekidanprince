package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ListCampaignsRequestOrBuilder extends MessageLiteOrBuilder {
  String getProjectNumber();
  
  ByteString getProjectNumberBytes();
  
  CommonTypesProto.CampaignState getRequestedStates(int paramInt);
  
  int getRequestedStatesCount();
  
  List<CommonTypesProto.CampaignState> getRequestedStatesList();
  
  int getRequestedStatesValue(int paramInt);
  
  List<Integer> getRequestedStatesValueList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\ListCampaignsRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */