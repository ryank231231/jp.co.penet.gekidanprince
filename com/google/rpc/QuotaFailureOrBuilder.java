package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface QuotaFailureOrBuilder extends MessageLiteOrBuilder {
  QuotaFailure.Violation getViolations(int paramInt);
  
  int getViolationsCount();
  
  List<QuotaFailure.Violation> getViolationsList();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\QuotaFailureOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */