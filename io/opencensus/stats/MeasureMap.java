package io.opencensus.stats;

import io.opencensus.tags.TagContext;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract class MeasureMap {
  public abstract MeasureMap put(Measure.MeasureDouble paramMeasureDouble, double paramDouble);
  
  public abstract MeasureMap put(Measure.MeasureLong paramMeasureLong, long paramLong);
  
  public abstract void record();
  
  public abstract void record(TagContext paramTagContext);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\MeasureMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */