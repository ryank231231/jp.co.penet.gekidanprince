package io.opencensus.stats;

import io.opencensus.common.Timestamp;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_ViewData_AggregationWindowData_CumulativeData extends ViewData.AggregationWindowData.CumulativeData {
  private final Timestamp end;
  
  private final Timestamp start;
  
  AutoValue_ViewData_AggregationWindowData_CumulativeData(Timestamp paramTimestamp1, Timestamp paramTimestamp2) {
    if (paramTimestamp1 != null) {
      this.start = paramTimestamp1;
      if (paramTimestamp2 != null) {
        this.end = paramTimestamp2;
        return;
      } 
      throw new NullPointerException("Null end");
    } 
    throw new NullPointerException("Null start");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ViewData.AggregationWindowData.CumulativeData) {
      paramObject = paramObject;
      if (!this.start.equals(paramObject.getStart()) || !this.end.equals(paramObject.getEnd()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Timestamp getEnd() {
    return this.end;
  }
  
  public Timestamp getStart() {
    return this.start;
  }
  
  public int hashCode() {
    return (this.start.hashCode() ^ 0xF4243) * 1000003 ^ this.end.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CumulativeData{start=");
    stringBuilder.append(this.start);
    stringBuilder.append(", end=");
    stringBuilder.append(this.end);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_ViewData_AggregationWindowData_CumulativeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */