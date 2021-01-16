package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface LogDescriptorOrBuilder extends MessageLiteOrBuilder {
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getDisplayName();
  
  ByteString getDisplayNameBytes();
  
  LabelDescriptor getLabels(int paramInt);
  
  int getLabelsCount();
  
  List<LabelDescriptor> getLabelsList();
  
  String getName();
  
  ByteString getNameBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\LogDescriptorOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */