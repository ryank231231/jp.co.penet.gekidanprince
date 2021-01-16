package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface EndpointOrBuilder extends MessageLiteOrBuilder {
  String getAliases(int paramInt);
  
  ByteString getAliasesBytes(int paramInt);
  
  int getAliasesCount();
  
  List<String> getAliasesList();
  
  boolean getAllowCors();
  
  String getApis(int paramInt);
  
  ByteString getApisBytes(int paramInt);
  
  int getApisCount();
  
  List<String> getApisList();
  
  String getFeatures(int paramInt);
  
  ByteString getFeaturesBytes(int paramInt);
  
  int getFeaturesCount();
  
  List<String> getFeaturesList();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getTarget();
  
  ByteString getTargetBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\EndpointOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */