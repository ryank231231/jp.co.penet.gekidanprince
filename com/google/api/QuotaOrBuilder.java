package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface QuotaOrBuilder extends MessageLiteOrBuilder {
  QuotaLimit getLimits(int paramInt);
  
  int getLimitsCount();
  
  List<QuotaLimit> getLimitsList();
  
  MetricRule getMetricRules(int paramInt);
  
  int getMetricRulesCount();
  
  List<MetricRule> getMetricRulesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\QuotaOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */