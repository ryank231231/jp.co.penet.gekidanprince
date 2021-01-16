package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface MetricDescriptorOrBuilder extends MessageLiteOrBuilder {
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getDisplayName();
  
  ByteString getDisplayNameBytes();
  
  LabelDescriptor getLabels(int paramInt);
  
  int getLabelsCount();
  
  List<LabelDescriptor> getLabelsList();
  
  MetricDescriptor.MetricKind getMetricKind();
  
  int getMetricKindValue();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getType();
  
  ByteString getTypeBytes();
  
  String getUnit();
  
  ByteString getUnitBytes();
  
  MetricDescriptor.ValueType getValueType();
  
  int getValueTypeValue();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MetricDescriptorOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */