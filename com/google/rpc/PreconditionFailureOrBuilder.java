package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface PreconditionFailureOrBuilder extends MessageLiteOrBuilder {
  PreconditionFailure.Violation getViolations(int paramInt);
  
  int getViolationsCount();
  
  List<PreconditionFailure.Violation> getViolationsList();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\PreconditionFailureOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */