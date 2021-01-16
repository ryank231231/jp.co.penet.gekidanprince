package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LocalizedMessageOrBuilder extends MessageLiteOrBuilder {
  String getLocale();
  
  ByteString getLocaleBytes();
  
  String getMessage();
  
  ByteString getMessageBytes();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\LocalizedMessageOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */