package io.opencensus.trace.export;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_RunningSpanStore_PerSpanNameSummary extends RunningSpanStore.PerSpanNameSummary {
  private final int numRunningSpans;
  
  AutoValue_RunningSpanStore_PerSpanNameSummary(int paramInt) {
    this.numRunningSpans = paramInt;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RunningSpanStore.PerSpanNameSummary) {
      paramObject = paramObject;
      if (this.numRunningSpans != paramObject.getNumRunningSpans())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int getNumRunningSpans() {
    return this.numRunningSpans;
  }
  
  public int hashCode() {
    return this.numRunningSpans ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PerSpanNameSummary{numRunningSpans=");
    stringBuilder.append(this.numRunningSpans);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_RunningSpanStore_PerSpanNameSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */