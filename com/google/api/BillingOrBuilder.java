package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface BillingOrBuilder extends MessageLiteOrBuilder {
  Billing.BillingDestination getConsumerDestinations(int paramInt);
  
  int getConsumerDestinationsCount();
  
  List<Billing.BillingDestination> getConsumerDestinationsList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\BillingOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */