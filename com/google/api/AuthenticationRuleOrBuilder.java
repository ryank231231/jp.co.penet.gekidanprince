package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface AuthenticationRuleOrBuilder extends MessageLiteOrBuilder {
  boolean getAllowWithoutCredential();
  
  OAuthRequirements getOauth();
  
  AuthRequirement getRequirements(int paramInt);
  
  int getRequirementsCount();
  
  List<AuthRequirement> getRequirementsList();
  
  String getSelector();
  
  ByteString getSelectorBytes();
  
  boolean hasOauth();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthenticationRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */