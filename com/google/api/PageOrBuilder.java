package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface PageOrBuilder extends MessageLiteOrBuilder {
  String getContent();
  
  ByteString getContentBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  Page getSubpages(int paramInt);
  
  int getSubpagesCount();
  
  List<Page> getSubpagesList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\PageOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */