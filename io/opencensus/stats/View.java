package io.opencensus.stats;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.opencensus.common.Duration;
import io.opencensus.common.Function;
import io.opencensus.internal.CheckerFrameworkUtils;
import io.opencensus.internal.StringUtil;
import io.opencensus.tags.TagKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class View {
  @VisibleForTesting
  static final int NAME_MAX_LENGTH = 255;
  
  public static View create(Name paramName, String paramString, Measure paramMeasure, Aggregation paramAggregation, List<TagKey> paramList, AggregationWindow paramAggregationWindow) {
    boolean bool;
    if ((new HashSet(paramList)).size() == paramList.size()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Columns have duplicate.");
    return new AutoValue_View(paramName, paramString, paramMeasure, paramAggregation, Collections.unmodifiableList(new ArrayList<TagKey>(paramList)), paramAggregationWindow);
  }
  
  public abstract Aggregation getAggregation();
  
  public abstract List<TagKey> getColumns();
  
  public abstract String getDescription();
  
  public abstract Measure getMeasure();
  
  public abstract Name getName();
  
  public abstract AggregationWindow getWindow();
  
  @Immutable
  public static abstract class AggregationWindow {
    private AggregationWindow() {}
    
    public abstract <T> T match(Function<? super Cumulative, T> param1Function, Function<? super Interval, T> param1Function1, Function<? super AggregationWindow, T> param1Function2);
    
    @Immutable
    public static abstract class Cumulative extends AggregationWindow {
      private static final Cumulative CUMULATIVE = new AutoValue_View_AggregationWindow_Cumulative();
      
      public static Cumulative create() {
        return CUMULATIVE;
      }
      
      public final <T> T match(Function<? super Cumulative, T> param2Function, Function<? super View.AggregationWindow.Interval, T> param2Function1, Function<? super View.AggregationWindow, T> param2Function2) {
        return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param2Function).apply(this);
      }
    }
    
    @Immutable
    public static abstract class Interval extends AggregationWindow {
      private static final Duration ZERO = Duration.create(0L, 0);
      
      public static Interval create(Duration param2Duration) {
        boolean bool;
        if (param2Duration.compareTo(ZERO) > 0) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool, "Duration must be positive");
        return new AutoValue_View_AggregationWindow_Interval(param2Duration);
      }
      
      public abstract Duration getDuration();
      
      public final <T> T match(Function<? super View.AggregationWindow.Cumulative, T> param2Function, Function<? super Interval, T> param2Function1, Function<? super View.AggregationWindow, T> param2Function2) {
        return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param2Function1).apply(this);
      }
    }
  }
  
  @Immutable
  public static abstract class Cumulative extends AggregationWindow {
    private static final Cumulative CUMULATIVE = new AutoValue_View_AggregationWindow_Cumulative();
    
    public static Cumulative create() {
      return CUMULATIVE;
    }
    
    public final <T> T match(Function<? super Cumulative, T> param1Function, Function<? super View.AggregationWindow.Interval, T> param1Function1, Function<? super View.AggregationWindow, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function).apply(this);
    }
  }
  
  @Immutable
  public static abstract class Interval extends AggregationWindow {
    private static final Duration ZERO = Duration.create(0L, 0);
    
    public static Interval create(Duration param1Duration) {
      boolean bool;
      if (param1Duration.compareTo(ZERO) > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Duration must be positive");
      return new AutoValue_View_AggregationWindow_Interval(param1Duration);
    }
    
    public abstract Duration getDuration();
    
    public final <T> T match(Function<? super View.AggregationWindow.Cumulative, T> param1Function, Function<? super Interval, T> param1Function1, Function<? super View.AggregationWindow, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function1).apply(this);
    }
  }
  
  @Immutable
  public static abstract class Name {
    public static Name create(String param1String) {
      boolean bool;
      if (StringUtil.isPrintableString(param1String) && param1String.length() <= 255) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Name should be a ASCII string with a length no greater than 255 characters.");
      return new AutoValue_View_Name(param1String);
    }
    
    public abstract String asString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\View.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */