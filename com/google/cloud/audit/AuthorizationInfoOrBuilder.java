package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface AuthorizationInfoOrBuilder extends MessageLiteOrBuilder {
  boolean getGranted();
  
  String getPermission();
  
  ByteString getPermissionBytes();
  
  String getResource();
  
  ByteString getResourceBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\cloud\audit\AuthorizationInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */