package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface DocumentationRuleOrBuilder extends MessageLiteOrBuilder {
  String getDeprecationDescription();
  
  ByteString getDeprecationDescriptionBytes();
  
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\DocumentationRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */