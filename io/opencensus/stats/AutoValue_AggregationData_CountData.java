package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AggregationData_CountData extends AggregationData.CountData {
  private final long count;
  
  AutoValue_AggregationData_CountData(long paramLong) {
    this.count = paramLong;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AggregationData.CountData) {
      paramObject = paramObject;
      if (this.count != paramObject.getCount())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public long getCount() {
    return this.count;
  }
  
  public int hashCode() {
    long l1 = 1000003L;
    long l2 = this.count;
    return (int)(l1 ^ l2 ^ l2 >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CountData{count=");
    stringBuilder.append(this.count);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_AggregationData_CountData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */