package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface MonitoringOrBuilder extends MessageLiteOrBuilder {
  Monitoring.MonitoringDestination getConsumerDestinations(int paramInt);
  
  int getConsumerDestinationsCount();
  
  List<Monitoring.MonitoringDestination> getConsumerDestinationsList();
  
  Monitoring.MonitoringDestination getProducerDestinations(int paramInt);
  
  int getProducerDestinationsCount();
  
  List<Monitoring.MonitoringDestination> getProducerDestinationsList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MonitoringOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */