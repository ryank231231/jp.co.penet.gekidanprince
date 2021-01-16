package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AggregationData_SumDataLong extends AggregationData.SumDataLong {
  private final long sum;
  
  AutoValue_AggregationData_SumDataLong(long paramLong) {
    this.sum = paramLong;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AggregationData.SumDataLong) {
      paramObject = paramObject;
      if (this.sum != paramObject.getSum())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public long getSum() {
    return this.sum;
  }
  
  public int hashCode() {
    long l1 = 1000003L;
    long l2 = this.sum;
    return (int)(l1 ^ l2 ^ l2 >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SumDataLong{sum=");
    stringBuilder.append(this.sum);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_AggregationData_SumDataLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */