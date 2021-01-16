package com.google.internal.firebase.inappmessaging.v1;

import com.google.developers.mobile.targeting.proto.Conditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface GetConditionEstimationRequestOrBuilder extends MessageLiteOrBuilder {
  String getProjectNumber();
  
  ByteString getProjectNumberBytes();
  
  Conditions.Condition getTargetingCondition();
  
  boolean hasTargetingCondition();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\GetConditionEstimationRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */