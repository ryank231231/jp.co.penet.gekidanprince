package io.opencensus.trace.export;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SampledSpanStore_LatencyFilter extends SampledSpanStore.LatencyFilter {
  private final long latencyLowerNs;
  
  private final long latencyUpperNs;
  
  private final int maxSpansToReturn;
  
  private final String spanName;
  
  AutoValue_SampledSpanStore_LatencyFilter(String paramString, long paramLong1, long paramLong2, int paramInt) {
    if (paramString != null) {
      this.spanName = paramString;
      this.latencyLowerNs = paramLong1;
      this.latencyUpperNs = paramLong2;
      this.maxSpansToReturn = paramInt;
      return;
    } 
    throw new NullPointerException("Null spanName");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SampledSpanStore.LatencyFilter) {
      paramObject = paramObject;
      if (!this.spanName.equals(paramObject.getSpanName()) || this.latencyLowerNs != paramObject.getLatencyLowerNs() || this.latencyUpperNs != paramObject.getLatencyUpperNs() || this.maxSpansToReturn != paramObject.getMaxSpansToReturn())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public long getLatencyLowerNs() {
    return this.latencyLowerNs;
  }
  
  public long getLatencyUpperNs() {
    return this.latencyUpperNs;
  }
  
  public int getMaxSpansToReturn() {
    return this.maxSpansToReturn;
  }
  
  public String getSpanName() {
    return this.spanName;
  }
  
  public int hashCode() {
    long l1 = ((this.spanName.hashCode() ^ 0xF4243) * 1000003);
    long l2 = this.latencyLowerNs;
    l2 = ((int)(l1 ^ l2 ^ l2 >>> 32L) * 1000003);
    l1 = this.latencyUpperNs;
    return (int)(l2 ^ l1 ^ l1 >>> 32L) * 1000003 ^ this.maxSpansToReturn;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LatencyFilter{spanName=");
    stringBuilder.append(this.spanName);
    stringBuilder.append(", latencyLowerNs=");
    stringBuilder.append(this.latencyLowerNs);
    stringBuilder.append(", latencyUpperNs=");
    stringBuilder.append(this.latencyUpperNs);
    stringBuilder.append(", maxSpansToReturn=");
    stringBuilder.append(this.maxSpansToReturn);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SampledSpanStore_LatencyFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */