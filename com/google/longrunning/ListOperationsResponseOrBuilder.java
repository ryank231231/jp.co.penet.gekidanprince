package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ListOperationsResponseOrBuilder extends MessageLiteOrBuilder {
  String getNextPageToken();
  
  ByteString getNextPageTokenBytes();
  
  Operation getOperations(int paramInt);
  
  int getOperationsCount();
  
  List<Operation> getOperationsList();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\longrunning\ListOperationsResponseOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */