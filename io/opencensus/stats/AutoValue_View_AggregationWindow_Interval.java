package io.opencensus.stats;

import io.opencensus.common.Duration;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_View_AggregationWindow_Interval extends View.AggregationWindow.Interval {
  private final Duration duration;
  
  AutoValue_View_AggregationWindow_Interval(Duration paramDuration) {
    if (paramDuration != null) {
      this.duration = paramDuration;
      return;
    } 
    throw new NullPointerException("Null duration");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof View.AggregationWindow.Interval) {
      paramObject = paramObject;
      return this.duration.equals(paramObject.getDuration());
    } 
    return false;
  }
  
  public Duration getDuration() {
    return this.duration;
  }
  
  public int hashCode() {
    return this.duration.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Interval{duration=");
    stringBuilder.append(this.duration);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_View_AggregationWindow_Interval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */