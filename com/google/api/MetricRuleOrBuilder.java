package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

public interface MetricRuleOrBuilder extends MessageLiteOrBuilder {
  boolean containsMetricCosts(String paramString);
  
  @Deprecated
  Map<String, Long> getMetricCosts();
  
  int getMetricCostsCount();
  
  Map<String, Long> getMetricCostsMap();
  
  long getMetricCostsOrDefault(String paramString, long paramLong);
  
  long getMetricCostsOrThrow(String paramString);
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MetricRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */