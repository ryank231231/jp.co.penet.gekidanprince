package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

public interface MetricOrBuilder extends MessageLiteOrBuilder {
  boolean containsLabels(String paramString);
  
  @Deprecated
  Map<String, String> getLabels();
  
  int getLabelsCount();
  
  Map<String, String> getLabelsMap();
  
  String getLabelsOrDefault(String paramString1, String paramString2);
  
  String getLabelsOrThrow(String paramString);
  
  String getType();
  
  ByteString getTypeBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MetricOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */