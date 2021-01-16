package io.opencensus.stats;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.opencensus.common.Function;
import io.opencensus.internal.CheckerFrameworkUtils;
import io.opencensus.internal.StringUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Measure {
  @VisibleForTesting
  static final int NAME_MAX_LENGTH = 255;
  
  private Measure() {}
  
  public abstract String getDescription();
  
  public abstract String getName();
  
  public abstract String getUnit();
  
  public abstract <T> T match(Function<? super MeasureDouble, T> paramFunction, Function<? super MeasureLong, T> paramFunction1, Function<? super Measure, T> paramFunction2);
  
  @Immutable
  public static abstract class MeasureDouble extends Measure {
    public static MeasureDouble create(String param1String1, String param1String2, String param1String3) {
      boolean bool;
      if (StringUtil.isPrintableString(param1String1) && param1String1.length() <= 255) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Name should be a ASCII string with a length no greater than 255 characters.");
      return new AutoValue_Measure_MeasureDouble(param1String1, param1String2, param1String3);
    }
    
    public abstract String getDescription();
    
    public abstract String getName();
    
    public abstract String getUnit();
    
    public <T> T match(Function<? super MeasureDouble, T> param1Function, Function<? super Measure.MeasureLong, T> param1Function1, Function<? super Measure, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function).apply(this);
    }
  }
  
  @Immutable
  public static abstract class MeasureLong extends Measure {
    public static MeasureLong create(String param1String1, String param1String2, String param1String3) {
      boolean bool;
      if (StringUtil.isPrintableString(param1String1) && param1String1.length() <= 255) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Name should be a ASCII string with a length no greater than 255 characters.");
      return new AutoValue_Measure_MeasureLong(param1String1, param1String2, param1String3);
    }
    
    public abstract String getDescription();
    
    public abstract String getName();
    
    public abstract String getUnit();
    
    public <T> T match(Function<? super Measure.MeasureDouble, T> param1Function, Function<? super MeasureLong, T> param1Function1, Function<? super Measure, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function1).apply(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\Measure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */