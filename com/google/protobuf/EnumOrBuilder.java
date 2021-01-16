package com.google.protobuf;

import java.util.List;

public interface EnumOrBuilder extends MessageLiteOrBuilder {
  EnumValue getEnumvalue(int paramInt);
  
  int getEnumvalueCount();
  
  List<EnumValue> getEnumvalueList();
  
  String getName();
  
  ByteString getNameBytes();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  SourceContext getSourceContext();
  
  Syntax getSyntax();
  
  int getSyntaxValue();
  
  boolean hasSourceContext();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\EnumOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */