package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LabelDescriptorOrBuilder extends MessageLiteOrBuilder {
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getKey();
  
  ByteString getKeyBytes();
  
  LabelDescriptor.ValueType getValueType();
  
  int getValueTypeValue();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\LabelDescriptorOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */