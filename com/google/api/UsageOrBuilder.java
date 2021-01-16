package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface UsageOrBuilder extends MessageLiteOrBuilder {
  String getProducerNotificationChannel();
  
  ByteString getProducerNotificationChannelBytes();
  
  String getRequirements(int paramInt);
  
  ByteString getRequirementsBytes(int paramInt);
  
  int getRequirementsCount();
  
  List<String> getRequirementsList();
  
  UsageRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<UsageRule> getRulesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\UsageOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */