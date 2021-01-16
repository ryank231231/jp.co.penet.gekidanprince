package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.rpc.Status;

public interface OperationOrBuilder extends MessageLiteOrBuilder {
  boolean getDone();
  
  Status getError();
  
  Any getMetadata();
  
  String getName();
  
  ByteString getNameBytes();
  
  Any getResponse();
  
  Operation.ResultCase getResultCase();
  
  boolean hasMetadata();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\longrunning\OperationOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */