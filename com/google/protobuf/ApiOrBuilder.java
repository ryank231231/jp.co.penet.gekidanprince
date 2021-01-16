package com.google.protobuf;

import java.util.List;

public interface ApiOrBuilder extends MessageLiteOrBuilder {
  Method getMethods(int paramInt);
  
  int getMethodsCount();
  
  List<Method> getMethodsList();
  
  Mixin getMixins(int paramInt);
  
  int getMixinsCount();
  
  List<Mixin> getMixinsList();
  
  String getName();
  
  ByteString getNameBytes();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  SourceContext getSourceContext();
  
  Syntax getSyntax();
  
  int getSyntaxValue();
  
  String getVersion();
  
  ByteString getVersionBytes();
  
  boolean hasSourceContext();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\ApiOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */