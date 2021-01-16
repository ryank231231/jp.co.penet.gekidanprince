package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface AuthProviderOrBuilder extends MessageLiteOrBuilder {
  String getAudiences();
  
  ByteString getAudiencesBytes();
  
  String getAuthorizationUrl();
  
  ByteString getAuthorizationUrlBytes();
  
  String getId();
  
  ByteString getIdBytes();
  
  String getIssuer();
  
  ByteString getIssuerBytes();
  
  String getJwksUri();
  
  ByteString getJwksUriBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthProviderOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */