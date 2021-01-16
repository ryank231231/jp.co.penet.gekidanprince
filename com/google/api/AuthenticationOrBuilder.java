package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface AuthenticationOrBuilder extends MessageLiteOrBuilder {
  AuthProvider getProviders(int paramInt);
  
  int getProvidersCount();
  
  List<AuthProvider> getProvidersList();
  
  AuthenticationRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<AuthenticationRule> getRulesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthenticationOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */