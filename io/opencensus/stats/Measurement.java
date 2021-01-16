package io.opencensus.stats;

import io.opencensus.common.Function;
import io.opencensus.internal.CheckerFrameworkUtils;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Measurement {
  private Measurement() {}
  
  public abstract Measure getMeasure();
  
  public abstract <T> T match(Function<? super MeasurementDouble, T> paramFunction, Function<? super MeasurementLong, T> paramFunction1, Function<? super Measurement, T> paramFunction2);
  
  @Immutable
  public static abstract class MeasurementDouble extends Measurement {
    public static MeasurementDouble create(Measure.MeasureDouble param1MeasureDouble, double param1Double) {
      return new AutoValue_Measurement_MeasurementDouble(param1MeasureDouble, param1Double);
    }
    
    public abstract Measure.MeasureDouble getMeasure();
    
    public abstract double getValue();
    
    public <T> T match(Function<? super MeasurementDouble, T> param1Function, Function<? super Measurement.MeasurementLong, T> param1Function1, Function<? super Measurement, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function).apply(this);
    }
  }
  
  @Immutable
  public static abstract class MeasurementLong extends Measurement {
    public static MeasurementLong create(Measure.MeasureLong param1MeasureLong, long param1Long) {
      return new AutoValue_Measurement_MeasurementLong(param1MeasureLong, param1Long);
    }
    
    public abstract Measure.MeasureLong getMeasure();
    
    public abstract long getValue();
    
    public <T> T match(Function<? super Measurement.MeasurementDouble, T> param1Function, Function<? super MeasurementLong, T> param1Function1, Function<? super Measurement, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function1).apply(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\Measurement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */