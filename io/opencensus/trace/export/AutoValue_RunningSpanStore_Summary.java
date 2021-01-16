package io.opencensus.trace.export;

import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_RunningSpanStore_Summary extends RunningSpanStore.Summary {
  private final Map<String, RunningSpanStore.PerSpanNameSummary> perSpanNameSummary;
  
  AutoValue_RunningSpanStore_Summary(Map<String, RunningSpanStore.PerSpanNameSummary> paramMap) {
    if (paramMap != null) {
      this.perSpanNameSummary = paramMap;
      return;
    } 
    throw new NullPointerException("Null perSpanNameSummary");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RunningSpanStore.Summary) {
      paramObject = paramObject;
      return this.perSpanNameSummary.equals(paramObject.getPerSpanNameSummary());
    } 
    return false;
  }
  
  public Map<String, RunningSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
    return this.perSpanNameSummary;
  }
  
  public int hashCode() {
    return this.perSpanNameSummary.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Summary{perSpanNameSummary=");
    stringBuilder.append(this.perSpanNameSummary);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_RunningSpanStore_Summary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */