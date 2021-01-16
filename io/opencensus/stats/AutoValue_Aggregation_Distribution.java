package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Aggregation_Distribution extends Aggregation.Distribution {
  private final BucketBoundaries bucketBoundaries;
  
  AutoValue_Aggregation_Distribution(BucketBoundaries paramBucketBoundaries) {
    if (paramBucketBoundaries != null) {
      this.bucketBoundaries = paramBucketBoundaries;
      return;
    } 
    throw new NullPointerException("Null bucketBoundaries");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Aggregation.Distribution) {
      paramObject = paramObject;
      return this.bucketBoundaries.equals(paramObject.getBucketBoundaries());
    } 
    return false;
  }
  
  public BucketBoundaries getBucketBoundaries() {
    return this.bucketBoundaries;
  }
  
  public int hashCode() {
    return this.bucketBoundaries.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Distribution{bucketBoundaries=");
    stringBuilder.append(this.bucketBoundaries);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_Aggregation_Distribution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */