package com.google.firebase.inappmessaging;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface ClientAppInfoOrBuilder extends MessageLiteOrBuilder {
  String getFirebaseInstanceId();
  
  ByteString getFirebaseInstanceIdBytes();
  
  String getGoogleAppId();
  
  ByteString getGoogleAppIdBytes();
  
  boolean hasFirebaseInstanceId();
  
  boolean hasGoogleAppId();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\ClientAppInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */