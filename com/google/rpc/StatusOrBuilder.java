package com.google.rpc;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface StatusOrBuilder extends MessageLiteOrBuilder {
  int getCode();
  
  Any getDetails(int paramInt);
  
  int getDetailsCount();
  
  List<Any> getDetailsList();
  
  String getMessage();
  
  ByteString getMessageBytes();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\StatusOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */