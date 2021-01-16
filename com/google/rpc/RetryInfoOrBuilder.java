package com.google.rpc;

import com.google.protobuf.Duration;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RetryInfoOrBuilder extends MessageLiteOrBuilder {
  Duration getRetryDelay();
  
  boolean hasRetryDelay();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\RetryInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */