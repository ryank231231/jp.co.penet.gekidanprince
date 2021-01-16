package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface AuthRequirementOrBuilder extends MessageLiteOrBuilder {
  String getAudiences();
  
  ByteString getAudiencesBytes();
  
  String getProviderId();
  
  ByteString getProviderIdBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthRequirementOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */