package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Measurement_MeasurementLong extends Measurement.MeasurementLong {
  private final Measure.MeasureLong measure;
  
  private final long value;
  
  AutoValue_Measurement_MeasurementLong(Measure.MeasureLong paramMeasureLong, long paramLong) {
    if (paramMeasureLong != null) {
      this.measure = paramMeasureLong;
      this.value = paramLong;
      return;
    } 
    throw new NullPointerException("Null measure");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Measurement.MeasurementLong) {
      paramObject = paramObject;
      if (!this.measure.equals(paramObject.getMeasure()) || this.value != paramObject.getValue())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Measure.MeasureLong getMeasure() {
    return this.measure;
  }
  
  public long getValue() {
    return this.value;
  }
  
  public int hashCode() {
    long l1 = ((this.measure.hashCode() ^ 0xF4243) * 1000003);
    long l2 = this.value;
    return (int)(l1 ^ l2 ^ l2 >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MeasurementLong{measure=");
    stringBuilder.append(this.measure);
    stringBuilder.append(", value=");
    stringBuilder.append(this.value);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_Measurement_MeasurementLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */