package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Measure_MeasureLong extends Measure.MeasureLong {
  private final String description;
  
  private final String name;
  
  private final String unit;
  
  AutoValue_Measure_MeasureLong(String paramString1, String paramString2, String paramString3) {
    if (paramString1 != null) {
      this.name = paramString1;
      if (paramString2 != null) {
        this.description = paramString2;
        if (paramString3 != null) {
          this.unit = paramString3;
          return;
        } 
        throw new NullPointerException("Null unit");
      } 
      throw new NullPointerException("Null description");
    } 
    throw new NullPointerException("Null name");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Measure.MeasureLong) {
      paramObject = paramObject;
      if (!this.name.equals(paramObject.getName()) || !this.description.equals(paramObject.getDescription()) || !this.unit.equals(paramObject.getUnit()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getUnit() {
    return this.unit;
  }
  
  public int hashCode() {
    return ((this.name.hashCode() ^ 0xF4243) * 1000003 ^ this.description.hashCode()) * 1000003 ^ this.unit.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MeasureLong{name=");
    stringBuilder.append(this.name);
    stringBuilder.append(", description=");
    stringBuilder.append(this.description);
    stringBuilder.append(", unit=");
    stringBuilder.append(this.unit);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_Measure_MeasureLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */