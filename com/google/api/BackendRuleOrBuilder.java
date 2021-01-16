package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface BackendRuleOrBuilder extends MessageLiteOrBuilder {
  String getAddress();
  
  ByteString getAddressBytes();
  
  double getDeadline();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\BackendRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */