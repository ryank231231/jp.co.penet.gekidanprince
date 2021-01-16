package com.google.protobuf;

import java.util.List;

public interface EnumValueOrBuilder extends MessageLiteOrBuilder {
  String getName();
  
  ByteString getNameBytes();
  
  int getNumber();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\EnumValueOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */