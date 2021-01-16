package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DistributionOrBuilder extends MessageLiteOrBuilder {
  long getBucketCounts(int paramInt);
  
  int getBucketCountsCount();
  
  List<Long> getBucketCountsList();
  
  Distribution.BucketOptions getBucketOptions();
  
  long getCount();
  
  double getMean();
  
  Distribution.Range getRange();
  
  double getSumOfSquaredDeviation();
  
  boolean hasBucketOptions();
  
  boolean hasRange();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\DistributionOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */