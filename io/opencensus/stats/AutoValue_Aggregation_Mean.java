package io.opencensus.stats;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Aggregation_Mean extends Aggregation.Mean {
  public boolean equals(Object paramObject) {
    return (paramObject == this) ? true : ((paramObject instanceof Aggregation.Mean));
  }
  
  public int hashCode() {
    return 1;
  }
  
  public String toString() {
    return "Mean{}";
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AutoValue_Aggregation_Mean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */