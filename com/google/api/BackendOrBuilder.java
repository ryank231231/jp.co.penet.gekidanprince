package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface BackendOrBuilder extends MessageLiteOrBuilder {
  BackendRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<BackendRule> getRulesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\BackendOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */