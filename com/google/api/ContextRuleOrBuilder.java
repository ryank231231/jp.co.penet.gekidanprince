package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ContextRuleOrBuilder extends MessageLiteOrBuilder {
  String getProvided(int paramInt);
  
  ByteString getProvidedBytes(int paramInt);
  
  int getProvidedCount();
  
  List<String> getProvidedList();
  
  String getRequested(int paramInt);
  
  ByteString getRequestedBytes(int paramInt);
  
  int getRequestedCount();
  
  List<String> getRequestedList();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\ContextRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */