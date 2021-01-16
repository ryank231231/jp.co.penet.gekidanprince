package io.opencensus.stats;

import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_BucketBoundaries extends BucketBoundaries {
  private final List<Double> boundaries;
  
  AutoValue_BucketBoundaries(List<Double> paramList) {
    if (paramList != null) {
      this.boundaries = paramList;
      return;
    } 
    throw new NullPointerException("Null boundaries");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof BucketBoundaries) {
      paramObject = paramObject;
      return this.boundaries.equals(paramObject.getBoundaries());
    } 
    return false;
  }
  
  public List<Double> getBoundaries() {
    return this.boundaries;
  }
  
  public int hashCode() {
    return this.boundaries.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BucketBoundaries{boundaries=");
    stringBuilder.append(this.boundaries);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_BucketBoundaries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */