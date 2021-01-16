package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RequestInfoOrBuilder extends MessageLiteOrBuilder {
  String getRequestId();
  
  ByteString getRequestIdBytes();
  
  String getServingData();
  
  ByteString getServingDataBytes();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\RequestInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */