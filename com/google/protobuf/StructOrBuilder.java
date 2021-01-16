package com.google.protobuf;

import java.util.Map;

public interface StructOrBuilder extends MessageLiteOrBuilder {
  boolean containsFields(String paramString);
  
  @Deprecated
  Map<String, Value> getFields();
  
  int getFieldsCount();
  
  Map<String, Value> getFieldsMap();
  
  Value getFieldsOrDefault(String paramString, Value paramValue);
  
  Value getFieldsOrThrow(String paramString);
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\StructOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */