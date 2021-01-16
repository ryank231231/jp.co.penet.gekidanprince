package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RequestMetadataOrBuilder extends MessageLiteOrBuilder {
  String getCallerIp();
  
  ByteString getCallerIpBytes();
  
  String getCallerSuppliedUserAgent();
  
  ByteString getCallerSuppliedUserAgentBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\cloud\audit\RequestMetadataOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */