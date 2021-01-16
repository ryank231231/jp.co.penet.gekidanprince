package io.opencensus.trace.samplers;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_ProbabilitySampler extends ProbabilitySampler {
  private final long idUpperBound;
  
  private final double probability;
  
  AutoValue_ProbabilitySampler(double paramDouble, long paramLong) {
    this.probability = paramDouble;
    this.idUpperBound = paramLong;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ProbabilitySampler) {
      paramObject = paramObject;
      if (Double.doubleToLongBits(this.probability) != Double.doubleToLongBits(paramObject.getProbability()) || this.idUpperBound != paramObject.getIdUpperBound())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  long getIdUpperBound() {
    return this.idUpperBound;
  }
  
  double getProbability() {
    return this.probability;
  }
  
  public int hashCode() {
    long l1 = ((int)(1000003L ^ Double.doubleToLongBits(this.probability) >>> 32L ^ Double.doubleToLongBits(this.probability)) * 1000003);
    long l2 = this.idUpperBound;
    return (int)(l1 ^ l2 ^ l2 >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ProbabilitySampler{probability=");
    stringBuilder.append(this.probability);
    stringBuilder.append(", idUpperBound=");
    stringBuilder.append(this.idUpperBound);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\samplers\AutoValue_ProbabilitySampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */