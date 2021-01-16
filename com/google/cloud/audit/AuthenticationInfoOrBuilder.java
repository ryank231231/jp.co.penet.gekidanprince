package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface AuthenticationInfoOrBuilder extends MessageLiteOrBuilder {
  String getPrincipalEmail();
  
  ByteString getPrincipalEmailBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\cloud\audit\AuthenticationInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */