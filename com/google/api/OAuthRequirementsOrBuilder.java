package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface OAuthRequirementsOrBuilder extends MessageLiteOrBuilder {
  String getCanonicalScopes();
  
  ByteString getCanonicalScopesBytes();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\OAuthRequirementsOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */