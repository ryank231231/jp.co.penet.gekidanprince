package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AggregationData_SumDataDouble extends AggregationData.SumDataDouble {
  private final double sum;
  
  AutoValue_AggregationData_SumDataDouble(double paramDouble) {
    this.sum = paramDouble;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AggregationData.SumDataDouble) {
      paramObject = paramObject;
      if (Double.doubleToLongBits(this.sum) != Double.doubleToLongBits(paramObject.getSum()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public double getSum() {
    return this.sum;
  }
  
  public int hashCode() {
    return (int)(1000003L ^ Double.doubleToLongBits(this.sum) >>> 32L ^ Double.doubleToLongBits(this.sum));
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SumDataDouble{sum=");
    stringBuilder.append(this.sum);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_AggregationData_SumDataDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */