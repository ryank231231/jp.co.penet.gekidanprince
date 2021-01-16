package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface SystemParameterOrBuilder extends MessageLiteOrBuilder {
  String getHttpHeader();
  
  ByteString getHttpHeaderBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getUrlQueryParameter();
  
  ByteString getUrlQueryParameterBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\SystemParameterOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */