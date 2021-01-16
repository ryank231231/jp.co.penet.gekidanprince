package io.opencensus.stats;

import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AggregationData_DistributionData extends AggregationData.DistributionData {
  private final List<Long> bucketCounts;
  
  private final long count;
  
  private final double max;
  
  private final double mean;
  
  private final double min;
  
  private final double sumOfSquaredDeviations;
  
  AutoValue_AggregationData_DistributionData(double paramDouble1, long paramLong, double paramDouble2, double paramDouble3, double paramDouble4, List<Long> paramList) {
    this.mean = paramDouble1;
    this.count = paramLong;
    this.min = paramDouble2;
    this.max = paramDouble3;
    this.sumOfSquaredDeviations = paramDouble4;
    if (paramList != null) {
      this.bucketCounts = paramList;
      return;
    } 
    throw new NullPointerException("Null bucketCounts");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AggregationData.DistributionData) {
      paramObject = paramObject;
      if (Double.doubleToLongBits(this.mean) != Double.doubleToLongBits(paramObject.getMean()) || this.count != paramObject.getCount() || Double.doubleToLongBits(this.min) != Double.doubleToLongBits(paramObject.getMin()) || Double.doubleToLongBits(this.max) != Double.doubleToLongBits(paramObject.getMax()) || Double.doubleToLongBits(this.sumOfSquaredDeviations) != Double.doubleToLongBits(paramObject.getSumOfSquaredDeviations()) || !this.bucketCounts.equals(paramObject.getBucketCounts()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public List<Long> getBucketCounts() {
    return this.bucketCounts;
  }
  
  public long getCount() {
    return this.count;
  }
  
  public double getMax() {
    return this.max;
  }
  
  public double getMean() {
    return this.mean;
  }
  
  public double getMin() {
    return this.min;
  }
  
  public double getSumOfSquaredDeviations() {
    return this.sumOfSquaredDeviations;
  }
  
  public int hashCode() {
    long l1 = ((int)(1000003L ^ Double.doubleToLongBits(this.mean) >>> 32L ^ Double.doubleToLongBits(this.mean)) * 1000003);
    long l2 = this.count;
    int i = (int)(((int)(((int)(((int)(l1 ^ l2 ^ l2 >>> 32L) * 1000003) ^ Double.doubleToLongBits(this.min) >>> 32L ^ Double.doubleToLongBits(this.min)) * 1000003) ^ Double.doubleToLongBits(this.max) >>> 32L ^ Double.doubleToLongBits(this.max)) * 1000003) ^ Double.doubleToLongBits(this.sumOfSquaredDeviations) >>> 32L ^ Double.doubleToLongBits(this.sumOfSquaredDeviations));
    return this.bucketCounts.hashCode() ^ i * 1000003;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DistributionData{mean=");
    stringBuilder.append(this.mean);
    stringBuilder.append(", count=");
    stringBuilder.append(this.count);
    stringBuilder.append(", min=");
    stringBuilder.append(this.min);
    stringBuilder.append(", max=");
    stringBuilder.append(this.max);
    stringBuilder.append(", sumOfSquaredDeviations=");
    stringBuilder.append(this.sumOfSquaredDeviations);
    stringBuilder.append(", bucketCounts=");
    stringBuilder.append(this.bucketCounts);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_AggregationData_DistributionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */