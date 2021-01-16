package io.opencensus.stats;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import io.opencensus.common.Function;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.internal.CheckerFrameworkUtils;
import io.opencensus.tags.TagValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class ViewData {
  private static void checkAggregation(final Aggregation aggregation, final AggregationData aggregationData, final Measure measure) {
    aggregation.match(new Function<Aggregation.Sum, Void>() {
          public Void apply(Aggregation.Sum param1Sum) {
            measure.match(new Function<Measure.MeasureDouble, Void>() {
                  public Void apply(Measure.MeasureDouble param2MeasureDouble) {
                    Preconditions.checkArgument(aggregationData instanceof AggregationData.SumDataDouble, ViewData.createErrorMessageForAggregation(aggregation, aggregationData));
                    return null;
                  }
                }new Function<Measure.MeasureLong, Void>() {
                  public Void apply(Measure.MeasureLong param2MeasureLong) {
                    Preconditions.checkArgument(aggregationData instanceof AggregationData.SumDataLong, ViewData.createErrorMessageForAggregation(aggregation, aggregationData));
                    return null;
                  }
                }Functions.throwAssertionError());
            return null;
          }
        }new Function<Aggregation.Count, Void>() {
          public Void apply(Aggregation.Count param1Count) {
            AggregationData aggregationData = aggregationData;
            Preconditions.checkArgument(aggregationData instanceof AggregationData.CountData, ViewData.createErrorMessageForAggregation(aggregation, aggregationData));
            return null;
          }
        }new Function<Aggregation.Mean, Void>() {
          public Void apply(Aggregation.Mean param1Mean) {
            AggregationData aggregationData = aggregationData;
            Preconditions.checkArgument(aggregationData instanceof AggregationData.MeanData, ViewData.createErrorMessageForAggregation(aggregation, aggregationData));
            return null;
          }
        }new Function<Aggregation.Distribution, Void>() {
          public Void apply(Aggregation.Distribution param1Distribution) {
            AggregationData aggregationData = aggregationData;
            Preconditions.checkArgument(aggregationData instanceof AggregationData.DistributionData, ViewData.createErrorMessageForAggregation(aggregation, aggregationData));
            return null;
          }
        }Functions.throwAssertionError());
  }
  
  private static void checkWindow(View.AggregationWindow paramAggregationWindow, final AggregationWindowData windowData) {
    paramAggregationWindow.match(new Function<View.AggregationWindow.Cumulative, Void>() {
          public Void apply(View.AggregationWindow.Cumulative param1Cumulative) {
            ViewData.AggregationWindowData aggregationWindowData = windowData;
            Preconditions.checkArgument(aggregationWindowData instanceof ViewData.AggregationWindowData.CumulativeData, ViewData.createErrorMessageForWindow(param1Cumulative, aggregationWindowData));
            return null;
          }
        }new Function<View.AggregationWindow.Interval, Void>() {
          public Void apply(View.AggregationWindow.Interval param1Interval) {
            ViewData.AggregationWindowData aggregationWindowData = windowData;
            Preconditions.checkArgument(aggregationWindowData instanceof ViewData.AggregationWindowData.IntervalData, ViewData.createErrorMessageForWindow(param1Interval, aggregationWindowData));
            return null;
          }
        }Functions.throwIllegalArgumentException());
  }
  
  public static ViewData create(View paramView, Map<? extends List<TagValue>, ? extends AggregationData> paramMap, AggregationWindowData paramAggregationWindowData) {
    checkWindow(paramView.getWindow(), paramAggregationWindowData);
    HashMap<? extends List<TagValue>, ? extends AggregationData> hashMap = Maps.newHashMap();
    for (Map.Entry<? extends List<TagValue>, ? extends AggregationData> entry : paramMap.entrySet()) {
      checkAggregation(paramView.getAggregation(), (AggregationData)entry.getValue(), paramView.getMeasure());
      hashMap.put(Collections.unmodifiableList(new ArrayList((Collection)entry.getKey())), entry.getValue());
    } 
    return new AutoValue_ViewData(paramView, Collections.unmodifiableMap(hashMap), paramAggregationWindowData);
  }
  
  private static String createErrorMessageForAggregation(Aggregation paramAggregation, AggregationData paramAggregationData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Aggregation and AggregationData types mismatch. Aggregation: ");
    stringBuilder.append(paramAggregation);
    stringBuilder.append(" AggregationData: ");
    stringBuilder.append(paramAggregationData);
    return stringBuilder.toString();
  }
  
  private static String createErrorMessageForWindow(View.AggregationWindow paramAggregationWindow, AggregationWindowData paramAggregationWindowData) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AggregationWindow and AggregationWindowData types mismatch. AggregationWindow: ");
    stringBuilder.append(paramAggregationWindow);
    stringBuilder.append(" AggregationWindowData: ");
    stringBuilder.append(paramAggregationWindowData);
    return stringBuilder.toString();
  }
  
  public abstract Map<List<TagValue>, AggregationData> getAggregationMap();
  
  public abstract View getView();
  
  public abstract AggregationWindowData getWindowData();
  
  @Immutable
  public static abstract class AggregationWindowData {
    private AggregationWindowData() {}
    
    public abstract <T> T match(Function<? super CumulativeData, T> param1Function, Function<? super IntervalData, T> param1Function1, Function<? super AggregationWindowData, T> param1Function2);
    
    @Immutable
    public static abstract class CumulativeData extends AggregationWindowData {
      public static CumulativeData create(Timestamp param2Timestamp1, Timestamp param2Timestamp2) {
        if (param2Timestamp1.compareTo(param2Timestamp2) <= 0)
          return new AutoValue_ViewData_AggregationWindowData_CumulativeData(param2Timestamp1, param2Timestamp2); 
        throw new IllegalArgumentException("Start time is later than end time.");
      }
      
      public abstract Timestamp getEnd();
      
      public abstract Timestamp getStart();
      
      public final <T> T match(Function<? super CumulativeData, T> param2Function, Function<? super ViewData.AggregationWindowData.IntervalData, T> param2Function1, Function<? super ViewData.AggregationWindowData, T> param2Function2) {
        return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param2Function).apply(this);
      }
    }
    
    @Immutable
    public static abstract class IntervalData extends AggregationWindowData {
      public static IntervalData create(Timestamp param2Timestamp) {
        return new AutoValue_ViewData_AggregationWindowData_IntervalData(param2Timestamp);
      }
      
      public abstract Timestamp getEnd();
      
      public final <T> T match(Function<? super ViewData.AggregationWindowData.CumulativeData, T> param2Function, Function<? super IntervalData, T> param2Function1, Function<? super ViewData.AggregationWindowData, T> param2Function2) {
        return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param2Function1).apply(this);
      }
    }
  }
  
  @Immutable
  public static abstract class CumulativeData extends AggregationWindowData {
    public static CumulativeData create(Timestamp param1Timestamp1, Timestamp param1Timestamp2) {
      if (param1Timestamp1.compareTo(param1Timestamp2) <= 0)
        return new AutoValue_ViewData_AggregationWindowData_CumulativeData(param1Timestamp1, param1Timestamp2); 
      throw new IllegalArgumentException("Start time is later than end time.");
    }
    
    public abstract Timestamp getEnd();
    
    public abstract Timestamp getStart();
    
    public final <T> T match(Function<? super CumulativeData, T> param1Function, Function<? super ViewData.AggregationWindowData.IntervalData, T> param1Function1, Function<? super ViewData.AggregationWindowData, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function).apply(this);
    }
  }
  
  @Immutable
  public static abstract class IntervalData extends AggregationWindowData {
    public static IntervalData create(Timestamp param1Timestamp) {
      return new AutoValue_ViewData_AggregationWindowData_IntervalData(param1Timestamp);
    }
    
    public abstract Timestamp getEnd();
    
    public final <T> T match(Function<? super ViewData.AggregationWindowData.CumulativeData, T> param1Function, Function<? super IntervalData, T> param1Function1, Function<? super ViewData.AggregationWindowData, T> param1Function2) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function1).apply(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\ViewData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */