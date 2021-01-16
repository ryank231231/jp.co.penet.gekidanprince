package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface MoneyOrBuilder extends MessageLiteOrBuilder {
  String getCurrencyCode();
  
  ByteString getCurrencyCodeBytes();
  
  int getNanos();
  
  long getUnits();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\MoneyOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */