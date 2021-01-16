package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface LoggingOrBuilder extends MessageLiteOrBuilder {
  Logging.LoggingDestination getConsumerDestinations(int paramInt);
  
  int getConsumerDestinationsCount();
  
  List<Logging.LoggingDestination> getConsumerDestinationsList();
  
  Logging.LoggingDestination getProducerDestinations(int paramInt);
  
  int getProducerDestinationsCount();
  
  List<Logging.LoggingDestination> getProducerDestinationsList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\LoggingOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */