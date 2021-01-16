package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface ListOperationsRequestOrBuilder extends MessageLiteOrBuilder {
  String getFilter();
  
  ByteString getFilterBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  int getPageSize();
  
  String getPageToken();
  
  ByteString getPageTokenBytes();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\longrunning\ListOperationsRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */