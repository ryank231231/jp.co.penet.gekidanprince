package io.opencensus.stats;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.opencensus.common.Function;
import io.opencensus.internal.CheckerFrameworkUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class AggregationData {
  private AggregationData() {}
  
  public abstract <T> T match(Function<? super SumDataDouble, T> paramFunction, Function<? super SumDataLong, T> paramFunction1, Function<? super CountData, T> paramFunction2, Function<? super MeanData, T> paramFunction3, Function<? super DistributionData, T> paramFunction4, Function<? super AggregationData, T> paramFunction5);
  
  @Immutable
  public static abstract class CountData extends AggregationData {
    public static CountData create(long param1Long) {
      return new AutoValue_AggregationData_CountData(param1Long);
    }
    
    public abstract long getCount();
    
    public final <T> T match(Function<? super AggregationData.SumDataDouble, T> param1Function, Function<? super AggregationData.SumDataLong, T> param1Function1, Function<? super CountData, T> param1Function2, Function<? super AggregationData.MeanData, T> param1Function3, Function<? super AggregationData.DistributionData, T> param1Function4, Function<? super AggregationData, T> param1Function5) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function2).apply(this);
    }
  }
  
  @Immutable
  public static abstract class DistributionData extends AggregationData {
    public static DistributionData create(double param1Double1, long param1Long, double param1Double2, double param1Double3, double param1Double4, List<Long> param1List) {
      if (param1Double2 != Double.POSITIVE_INFINITY || param1Double3 != Double.NEGATIVE_INFINITY) {
        boolean bool;
        if (param1Double2 <= param1Double3) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool, "max should be greater or equal to min.");
      } 
      Preconditions.checkNotNull(param1List, "bucket counts should not be null.");
      List<?> list = Collections.unmodifiableList(Lists.newArrayList(param1List));
      Iterator<?> iterator = list.iterator();
      while (iterator.hasNext())
        Preconditions.checkNotNull(iterator.next(), "bucket should not be null."); 
      return new AutoValue_AggregationData_DistributionData(param1Double1, param1Long, param1Double2, param1Double3, param1Double4, (List)list);
    }
    
    public abstract List<Long> getBucketCounts();
    
    public abstract long getCount();
    
    public abstract double getMax();
    
    public abstract double getMean();
    
    public abstract double getMin();
    
    public abstract double getSumOfSquaredDeviations();
    
    public final <T> T match(Function<? super AggregationData.SumDataDouble, T> param1Function, Function<? super AggregationData.SumDataLong, T> param1Function1, Function<? super AggregationData.CountData, T> param1Function2, Function<? super AggregationData.MeanData, T> param1Function3, Function<? super DistributionData, T> param1Function4, Function<? super AggregationData, T> param1Function5) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function4).apply(this);
    }
  }
  
  @Immutable
  public static abstract class MeanData extends AggregationData {
    public static MeanData create(double param1Double, long param1Long) {
      return new AutoValue_AggregationData_MeanData(param1Double, param1Long);
    }
    
    public abstract long getCount();
    
    public abstract double getMean();
    
    public final <T> T match(Function<? super AggregationData.SumDataDouble, T> param1Function, Function<? super AggregationData.SumDataLong, T> param1Function1, Function<? super AggregationData.CountData, T> param1Function2, Function<? super MeanData, T> param1Function3, Function<? super AggregationData.DistributionData, T> param1Function4, Function<? super AggregationData, T> param1Function5) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function3).apply(this);
    }
  }
  
  @Immutable
  public static abstract class SumDataDouble extends AggregationData {
    public static SumDataDouble create(double param1Double) {
      return new AutoValue_AggregationData_SumDataDouble(param1Double);
    }
    
    public abstract double getSum();
    
    public final <T> T match(Function<? super SumDataDouble, T> param1Function, Function<? super AggregationData.SumDataLong, T> param1Function1, Function<? super AggregationData.CountData, T> param1Function2, Function<? super AggregationData.MeanData, T> param1Function3, Function<? super AggregationData.DistributionData, T> param1Function4, Function<? super AggregationData, T> param1Function5) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function).apply(this);
    }
  }
  
  @Immutable
  public static abstract class SumDataLong extends AggregationData {
    public static SumDataLong create(long param1Long) {
      return new AutoValue_AggregationData_SumDataLong(param1Long);
    }
    
    public abstract long getSum();
    
    public final <T> T match(Function<? super AggregationData.SumDataDouble, T> param1Function, Function<? super SumDataLong, T> param1Function1, Function<? super AggregationData.CountData, T> param1Function2, Function<? super AggregationData.MeanData, T> param1Function3, Function<? super AggregationData.DistributionData, T> param1Function4, Function<? super AggregationData, T> param1Function5) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function1).apply(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\AggregationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */