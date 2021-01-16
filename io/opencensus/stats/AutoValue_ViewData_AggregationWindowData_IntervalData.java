package io.opencensus.stats;

import io.opencensus.common.Timestamp;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_ViewData_AggregationWindowData_IntervalData extends ViewData.AggregationWindowData.IntervalData {
  private final Timestamp end;
  
  AutoValue_ViewData_AggregationWindowData_IntervalData(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.end = paramTimestamp;
      return;
    } 
    throw new NullPointerException("Null end");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ViewData.AggregationWindowData.IntervalData) {
      paramObject = paramObject;
      return this.end.equals(paramObject.getEnd());
    } 
    return false;
  }
  
  public Timestamp getEnd() {
    return this.end;
  }
  
  public int hashCode() {
    return this.end.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IntervalData{end=");
    stringBuilder.append(this.end);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_ViewData_AggregationWindowData_IntervalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */