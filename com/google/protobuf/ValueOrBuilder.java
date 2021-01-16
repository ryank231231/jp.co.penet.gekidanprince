package com.google.protobuf;

public interface ValueOrBuilder extends MessageLiteOrBuilder {
  boolean getBoolValue();
  
  Value.KindCase getKindCase();
  
  ListValue getListValue();
  
  NullValue getNullValue();
  
  int getNullValueValue();
  
  double getNumberValue();
  
  String getStringValue();
  
  ByteString getStringValueBytes();
  
  Struct getStructValue();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\ValueOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */