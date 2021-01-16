package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Measurement_MeasurementDouble extends Measurement.MeasurementDouble {
  private final Measure.MeasureDouble measure;
  
  private final double value;
  
  AutoValue_Measurement_MeasurementDouble(Measure.MeasureDouble paramMeasureDouble, double paramDouble) {
    if (paramMeasureDouble != null) {
      this.measure = paramMeasureDouble;
      this.value = paramDouble;
      return;
    } 
    throw new NullPointerException("Null measure");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Measurement.MeasurementDouble) {
      paramObject = paramObject;
      if (!this.measure.equals(paramObject.getMeasure()) || Double.doubleToLongBits(this.value) != Double.doubleToLongBits(paramObject.getValue()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Measure.MeasureDouble getMeasure() {
    return this.measure;
  }
  
  public double getValue() {
    return this.value;
  }
  
  public int hashCode() {
    return (int)(((this.measure.hashCode() ^ 0xF4243) * 1000003) ^ Double.doubleToLongBits(this.value) >>> 32L ^ Double.doubleToLongBits(this.value));
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MeasurementDouble{measure=");
    stringBuilder.append(this.measure);
    stringBuilder.append(", value=");
    stringBuilder.append(this.value);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_Measurement_MeasurementDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */