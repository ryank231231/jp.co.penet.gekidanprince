package io.opencensus.stats;

import com.google.common.base.Preconditions;
import io.opencensus.common.Function;
import io.opencensus.internal.CheckerFrameworkUtils;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Aggregation {
  private Aggregation() {}
  
  public abstract <T> T match(Function<? super Sum, T> paramFunction, Function<? super Count, T> paramFunction1, Function<? super Mean, T> paramFunction2, Function<? super Distribution, T> paramFunction3, Function<? super Aggregation, T> paramFunction4);
  
  @Immutable
  public static abstract class Count extends Aggregation {
    private static final Count INSTANCE = new AutoValue_Aggregation_Count();
    
    public static Count create() {
      return INSTANCE;
    }
    
    public final <T> T match(Function<? super Aggregation.Sum, T> param1Function, Function<? super Count, T> param1Function1, Function<? super Aggregation.Mean, T> param1Function2, Function<? super Aggregation.Distribution, T> param1Function3, Function<? super Aggregation, T> param1Function4) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function1).apply(this);
    }
  }
  
  @Immutable
  public static abstract class Distribution extends Aggregation {
    public static Distribution create(BucketBoundaries param1BucketBoundaries) {
      Preconditions.checkNotNull(param1BucketBoundaries, "bucketBoundaries should not be null.");
      return new AutoValue_Aggregation_Distribution(param1BucketBoundaries);
    }
    
    public abstract BucketBoundaries getBucketBoundaries();
    
    public final <T> T match(Function<? super Aggregation.Sum, T> param1Function, Function<? super Aggregation.Count, T> param1Function1, Function<? super Aggregation.Mean, T> param1Function2, Function<? super Distribution, T> param1Function3, Function<? super Aggregation, T> param1Function4) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function3).apply(this);
    }
  }
  
  @Immutable
  public static abstract class Mean extends Aggregation {
    private static final Mean INSTANCE = new AutoValue_Aggregation_Mean();
    
    public static Mean create() {
      return INSTANCE;
    }
    
    public final <T> T match(Function<? super Aggregation.Sum, T> param1Function, Function<? super Aggregation.Count, T> param1Function1, Function<? super Mean, T> param1Function2, Function<? super Aggregation.Distribution, T> param1Function3, Function<? super Aggregation, T> param1Function4) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function2).apply(this);
    }
  }
  
  @Immutable
  public static abstract class Sum extends Aggregation {
    private static final Sum INSTANCE = new AutoValue_Aggregation_Sum();
    
    public static Sum create() {
      return INSTANCE;
    }
    
    public final <T> T match(Function<? super Sum, T> param1Function, Function<? super Aggregation.Count, T> param1Function1, Function<? super Aggregation.Mean, T> param1Function2, Function<? super Aggregation.Distribution, T> param1Function3, Function<? super Aggregation, T> param1Function4) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function).apply(this);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\Aggregation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */