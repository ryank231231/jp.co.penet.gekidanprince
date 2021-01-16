package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface SystemParameterRuleOrBuilder extends MessageLiteOrBuilder {
  SystemParameter getParameters(int paramInt);
  
  int getParametersCount();
  
  List<SystemParameter> getParametersList();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\SystemParameterRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */