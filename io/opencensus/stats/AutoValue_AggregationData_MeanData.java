package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AggregationData_MeanData extends AggregationData.MeanData {
  private final long count;
  
  private final double mean;
  
  AutoValue_AggregationData_MeanData(double paramDouble, long paramLong) {
    this.mean = paramDouble;
    this.count = paramLong;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AggregationData.MeanData) {
      paramObject = paramObject;
      if (Double.doubleToLongBits(this.mean) != Double.doubleToLongBits(paramObject.getMean()) || this.count != paramObject.getCount())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public long getCount() {
    return this.count;
  }
  
  public double getMean() {
    return this.mean;
  }
  
  public int hashCode() {
    long l1 = ((int)(1000003L ^ Double.doubleToLongBits(this.mean) >>> 32L ^ Double.doubleToLongBits(this.mean)) * 1000003);
    long l2 = this.count;
    return (int)(l1 ^ l2 ^ l2 >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MeanData{mean=");
    stringBuilder.append(this.mean);
    stringBuilder.append(", count=");
    stringBuilder.append(this.count);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_AggregationData_MeanData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */