package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface SourceInfoOrBuilder extends MessageLiteOrBuilder {
  Any getSourceFiles(int paramInt);
  
  int getSourceFilesCount();
  
  List<Any> getSourceFilesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\SourceInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */