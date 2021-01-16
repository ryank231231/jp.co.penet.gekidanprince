package io.opencensus.stats;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class BucketBoundaries {
  public static final BucketBoundaries create(List<Double> paramList) {
    Preconditions.checkNotNull(paramList, "bucketBoundaries list should not be null.");
    paramList = new ArrayList<Double>(paramList);
    if (paramList.size() > 1) {
      double d = ((Double)paramList.get(0)).doubleValue();
      byte b = 1;
      while (b < paramList.size()) {
        boolean bool;
        double d1 = ((Double)paramList.get(b)).doubleValue();
        if (d < d1) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool, "Bucket boundaries not sorted.");
        b++;
        d = d1;
      } 
    } 
    return new AutoValue_BucketBoundaries(Collections.unmodifiableList(paramList));
  }
  
  public abstract List<Double> getBoundaries();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\BucketBoundaries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */