package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface HttpOrBuilder extends MessageLiteOrBuilder {
  boolean getFullyDecodeReservedExpansion();
  
  HttpRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<HttpRule> getRulesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\HttpOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */