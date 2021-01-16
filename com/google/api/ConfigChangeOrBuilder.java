package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ConfigChangeOrBuilder extends MessageLiteOrBuilder {
  Advice getAdvices(int paramInt);
  
  int getAdvicesCount();
  
  List<Advice> getAdvicesList();
  
  ChangeType getChangeType();
  
  int getChangeTypeValue();
  
  String getElement();
  
  ByteString getElementBytes();
  
  String getNewValue();
  
  ByteString getNewValueBytes();
  
  String getOldValue();
  
  ByteString getOldValueBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\ConfigChangeOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */