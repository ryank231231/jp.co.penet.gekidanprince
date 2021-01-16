package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface HttpBodyOrBuilder extends MessageLiteOrBuilder {
  String getContentType();
  
  ByteString getContentTypeBytes();
  
  ByteString getData();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\HttpBodyOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */