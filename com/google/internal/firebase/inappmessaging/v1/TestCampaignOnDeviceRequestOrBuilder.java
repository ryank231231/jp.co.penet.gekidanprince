package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface TestCampaignOnDeviceRequestOrBuilder extends MessageLiteOrBuilder {
  String getCampaignId();
  
  ByteString getCampaignIdBytes();
  
  String getInstanceIds(int paramInt);
  
  ByteString getInstanceIdsBytes(int paramInt);
  
  int getInstanceIdsCount();
  
  List<String> getInstanceIdsList();
  
  String getProjectNumber();
  
  ByteString getProjectNumberBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\TestCampaignOnDeviceRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */