package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RolloutExperimentRequestOrBuilder extends MessageLiteOrBuilder {
  String getExperimentId();
  
  ByteString getExperimentIdBytes();
  
  String getProjectNumber();
  
  ByteString getProjectNumberBytes();
  
  CampaignProto.ExperimentalCampaignRollout getRolloutDetails();
  
  boolean hasRolloutDetails();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\RolloutExperimentRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */