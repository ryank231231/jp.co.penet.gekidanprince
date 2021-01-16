package io.opencensus.trace.export;

import io.opencensus.trace.Status;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SampledSpanStore_PerSpanNameSummary extends SampledSpanStore.PerSpanNameSummary {
  private final Map<Status.CanonicalCode, Integer> numbersOfErrorSampledSpans;
  
  private final Map<SampledSpanStore.LatencyBucketBoundaries, Integer> numbersOfLatencySampledSpans;
  
  AutoValue_SampledSpanStore_PerSpanNameSummary(Map<SampledSpanStore.LatencyBucketBoundaries, Integer> paramMap, Map<Status.CanonicalCode, Integer> paramMap1) {
    if (paramMap != null) {
      this.numbersOfLatencySampledSpans = paramMap;
      if (paramMap1 != null) {
        this.numbersOfErrorSampledSpans = paramMap1;
        return;
      } 
      throw new NullPointerException("Null numbersOfErrorSampledSpans");
    } 
    throw new NullPointerException("Null numbersOfLatencySampledSpans");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SampledSpanStore.PerSpanNameSummary) {
      paramObject = paramObject;
      if (!this.numbersOfLatencySampledSpans.equals(paramObject.getNumbersOfLatencySampledSpans()) || !this.numbersOfErrorSampledSpans.equals(paramObject.getNumbersOfErrorSampledSpans()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Map<Status.CanonicalCode, Integer> getNumbersOfErrorSampledSpans() {
    return this.numbersOfErrorSampledSpans;
  }
  
  public Map<SampledSpanStore.LatencyBucketBoundaries, Integer> getNumbersOfLatencySampledSpans() {
    return this.numbersOfLatencySampledSpans;
  }
  
  public int hashCode() {
    return (this.numbersOfLatencySampledSpans.hashCode() ^ 0xF4243) * 1000003 ^ this.numbersOfErrorSampledSpans.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PerSpanNameSummary{numbersOfLatencySampledSpans=");
    stringBuilder.append(this.numbersOfLatencySampledSpans);
    stringBuilder.append(", numbersOfErrorSampledSpans=");
    stringBuilder.append(this.numbersOfErrorSampledSpans);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SampledSpanStore_PerSpanNameSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */