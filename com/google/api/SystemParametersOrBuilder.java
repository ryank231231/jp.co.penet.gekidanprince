package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface SystemParametersOrBuilder extends MessageLiteOrBuilder {
  SystemParameterRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<SystemParameterRule> getRulesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\SystemParametersOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */