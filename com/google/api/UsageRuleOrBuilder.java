package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface UsageRuleOrBuilder extends MessageLiteOrBuilder {
  boolean getAllowUnregisteredCalls();
  
  String getSelector();
  
  ByteString getSelectorBytes();
  
  boolean getSkipServiceControl();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\UsageRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */