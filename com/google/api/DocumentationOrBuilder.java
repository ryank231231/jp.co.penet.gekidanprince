package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DocumentationOrBuilder extends MessageLiteOrBuilder {
  String getDocumentationRootUrl();
  
  ByteString getDocumentationRootUrlBytes();
  
  String getOverview();
  
  ByteString getOverviewBytes();
  
  Page getPages(int paramInt);
  
  int getPagesCount();
  
  List<Page> getPagesList();
  
  DocumentationRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<DocumentationRule> getRulesList();
  
  String getSummary();
  
  ByteString getSummaryBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\DocumentationOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */