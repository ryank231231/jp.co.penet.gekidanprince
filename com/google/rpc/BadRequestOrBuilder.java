package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface BadRequestOrBuilder extends MessageLiteOrBuilder {
  BadRequest.FieldViolation getFieldViolations(int paramInt);
  
  int getFieldViolationsCount();
  
  List<BadRequest.FieldViolation> getFieldViolationsList();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\BadRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */