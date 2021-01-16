package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Aggregation_Count extends Aggregation.Count {
  public boolean equals(Object paramObject) {
    return (paramObject == this) ? true : ((paramObject instanceof Aggregation.Count));
  }
  
  public int hashCode() {
    return 1;
  }
  
  public String toString() {
    return "Count{}";
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_Aggregation_Count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */