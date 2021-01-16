package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface HttpRuleOrBuilder extends MessageLiteOrBuilder {
  HttpRule getAdditionalBindings(int paramInt);
  
  int getAdditionalBindingsCount();
  
  List<HttpRule> getAdditionalBindingsList();
  
  String getBody();
  
  ByteString getBodyBytes();
  
  CustomHttpPattern getCustom();
  
  String getDelete();
  
  ByteString getDeleteBytes();
  
  String getGet();
  
  ByteString getGetBytes();
  
  String getPatch();
  
  ByteString getPatchBytes();
  
  HttpRule.PatternCase getPatternCase();
  
  String getPost();
  
  ByteString getPostBytes();
  
  String getPut();
  
  ByteString getPutBytes();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\HttpRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */