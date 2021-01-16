package com.google.logging.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.MessageLiteOrBuilder;

public interface HttpRequestOrBuilder extends MessageLiteOrBuilder {
  long getCacheFillBytes();
  
  boolean getCacheHit();
  
  boolean getCacheLookup();
  
  boolean getCacheValidatedWithOriginServer();
  
  Duration getLatency();
  
  String getProtocol();
  
  ByteString getProtocolBytes();
  
  String getReferer();
  
  ByteString getRefererBytes();
  
  String getRemoteIp();
  
  ByteString getRemoteIpBytes();
  
  String getRequestMethod();
  
  ByteString getRequestMethodBytes();
  
  long getRequestSize();
  
  String getRequestUrl();
  
  ByteString getRequestUrlBytes();
  
  long getResponseSize();
  
  String getServerIp();
  
  ByteString getServerIpBytes();
  
  int getStatus();
  
  String getUserAgent();
  
  ByteString getUserAgentBytes();
  
  boolean hasLatency();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\logging\type\HttpRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */