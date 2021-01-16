package com.google.cloud.audit;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.util.List;

public interface AuditLogOrBuilder extends MessageLiteOrBuilder {
  AuthenticationInfo getAuthenticationInfo();
  
  AuthorizationInfo getAuthorizationInfo(int paramInt);
  
  int getAuthorizationInfoCount();
  
  List<AuthorizationInfo> getAuthorizationInfoList();
  
  String getMethodName();
  
  ByteString getMethodNameBytes();
  
  long getNumResponseItems();
  
  Struct getRequest();
  
  RequestMetadata getRequestMetadata();
  
  String getResourceName();
  
  ByteString getResourceNameBytes();
  
  Struct getResponse();
  
  Any getServiceData();
  
  String getServiceName();
  
  ByteString getServiceNameBytes();
  
  Status getStatus();
  
  boolean hasAuthenticationInfo();
  
  boolean hasRequest();
  
  boolean hasRequestMetadata();
  
  boolean hasResponse();
  
  boolean hasServiceData();
  
  boolean hasStatus();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\cloud\audit\AuditLogOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */