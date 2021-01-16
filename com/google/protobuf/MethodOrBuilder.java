package com.google.protobuf;

import java.util.List;

public interface MethodOrBuilder extends MessageLiteOrBuilder {
  String getName();
  
  ByteString getNameBytes();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  boolean getRequestStreaming();
  
  String getRequestTypeUrl();
  
  ByteString getRequestTypeUrlBytes();
  
  boolean getResponseStreaming();
  
  String getResponseTypeUrl();
  
  ByteString getResponseTypeUrlBytes();
  
  Syntax getSyntax();
  
  int getSyntaxValue();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\MethodOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */