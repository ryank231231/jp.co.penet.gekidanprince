package io.opencensus.trace.export;

import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SampledSpanStore_Summary extends SampledSpanStore.Summary {
  private final Map<String, SampledSpanStore.PerSpanNameSummary> perSpanNameSummary;
  
  AutoValue_SampledSpanStore_Summary(Map<String, SampledSpanStore.PerSpanNameSummary> paramMap) {
    if (paramMap != null) {
      this.perSpanNameSummary = paramMap;
      return;
    } 
    throw new NullPointerException("Null perSpanNameSummary");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SampledSpanStore.Summary) {
      paramObject = paramObject;
      return this.perSpanNameSummary.equals(paramObject.getPerSpanNameSummary());
    } 
    return false;
  }
  
  public Map<String, SampledSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
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


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SampledSpanStore_Summary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */