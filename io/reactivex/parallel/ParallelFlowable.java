package io.reactivex.parallel;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.Beta;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelConcatMap;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.internal.operators.parallel.ParallelFlatMap;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelMap;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.internal.util.MergerBiFunction;
import io.reactivex.internal.util.SorterFunction;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Beta
public abstract class ParallelFlowable<T> {
  @CheckReturnValue
  public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> paramPublisher) {
    return from(paramPublisher, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
  }
  
  @CheckReturnValue
  public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> paramPublisher, int paramInt) {
    return from(paramPublisher, paramInt, Flowable.bufferSize());
  }
  
  @CheckReturnValue
  @NonNull
  public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> paramPublisher, int paramInt1, int paramInt2) {
    ObjectHelper.requireNonNull(paramPublisher, "source");
    ObjectHelper.verifyPositive(paramInt1, "parallelism");
    ObjectHelper.verifyPositive(paramInt2, "prefetch");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFromPublisher(paramPublisher, paramInt1, paramInt2));
  }
  
  @CheckReturnValue
  @NonNull
  public static <T> ParallelFlowable<T> fromArray(@NonNull Publisher<T>... paramVarArgs) {
    if (paramVarArgs.length != 0)
      return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFromArray((Publisher[])paramVarArgs)); 
    throw new IllegalArgumentException("Zero publishers not supported");
  }
  
  @CheckReturnValue
  @Experimental
  @NonNull
  public final <R> R as(@NonNull ParallelFlowableConverter<T, R> paramParallelFlowableConverter) {
    return (R)((ParallelFlowableConverter)ObjectHelper.requireNonNull(paramParallelFlowableConverter, "converter is null")).apply(this);
  }
  
  @CheckReturnValue
  @NonNull
  public final <C> ParallelFlowable<C> collect(@NonNull Callable<? extends C> paramCallable, @NonNull BiConsumer<? super C, ? super T> paramBiConsumer) {
    ObjectHelper.requireNonNull(paramCallable, "collectionSupplier is null");
    ObjectHelper.requireNonNull(paramBiConsumer, "collector is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelCollect(this, paramCallable, paramBiConsumer));
  }
  
  @CheckReturnValue
  @NonNull
  public final <U> ParallelFlowable<U> compose(@NonNull ParallelTransformer<T, U> paramParallelTransformer) {
    return RxJavaPlugins.onAssembly(((ParallelTransformer)ObjectHelper.requireNonNull(paramParallelTransformer, "composer is null")).apply(this));
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction) {
    return concatMap(paramFunction, 2);
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt) {
    ObjectHelper.requireNonNull(paramFunction, "mapper is null");
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelConcatMap(this, paramFunction, paramInt, ErrorMode.IMMEDIATE));
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean) {
    ErrorMode errorMode;
    ObjectHelper.requireNonNull(paramFunction, "mapper is null");
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    if (paramBoolean) {
      errorMode = ErrorMode.END;
    } else {
      errorMode = ErrorMode.BOUNDARY;
    } 
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelConcatMap(this, paramFunction, paramInt, errorMode));
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean) {
    return concatMapDelayError(paramFunction, 2, paramBoolean);
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doAfterNext(@NonNull Consumer<? super T> paramConsumer) {
    ObjectHelper.requireNonNull(paramConsumer, "onAfterNext is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), paramConsumer, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doAfterTerminated(@NonNull Action paramAction) {
    ObjectHelper.requireNonNull(paramAction, "onAfterTerminate is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, paramAction, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doOnCancel(@NonNull Action paramAction) {
    ObjectHelper.requireNonNull(paramAction, "onCancel is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, paramAction));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doOnComplete(@NonNull Action paramAction) {
    ObjectHelper.requireNonNull(paramAction, "onComplete is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), paramAction, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doOnError(@NonNull Consumer<Throwable> paramConsumer) {
    ObjectHelper.requireNonNull(paramConsumer, "onError is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), paramConsumer, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> paramConsumer) {
    ObjectHelper.requireNonNull(paramConsumer, "onNext is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, paramConsumer, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
  }
  
  @CheckReturnValue
  @Experimental
  @NonNull
  public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> paramConsumer, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction) {
    ObjectHelper.requireNonNull(paramConsumer, "onNext is null");
    ObjectHelper.requireNonNull(paramBiFunction, "errorHandler is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelDoOnNextTry(this, paramConsumer, paramBiFunction));
  }
  
  @CheckReturnValue
  @Experimental
  @NonNull
  public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> paramConsumer, @NonNull ParallelFailureHandling paramParallelFailureHandling) {
    ObjectHelper.requireNonNull(paramConsumer, "onNext is null");
    ObjectHelper.requireNonNull(paramParallelFailureHandling, "errorHandler is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelDoOnNextTry(this, paramConsumer, (BiFunction)paramParallelFailureHandling));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doOnRequest(@NonNull LongConsumer paramLongConsumer) {
    ObjectHelper.requireNonNull(paramLongConsumer, "onRequest is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), paramLongConsumer, Functions.EMPTY_ACTION));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> doOnSubscribe(@NonNull Consumer<? super Subscription> paramConsumer) {
    ObjectHelper.requireNonNull(paramConsumer, "onSubscribe is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, paramConsumer, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> paramPredicate) {
    ObjectHelper.requireNonNull(paramPredicate, "predicate");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFilter(this, paramPredicate));
  }
  
  @CheckReturnValue
  @Experimental
  public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> paramPredicate, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction) {
    ObjectHelper.requireNonNull(paramPredicate, "predicate");
    ObjectHelper.requireNonNull(paramBiFunction, "errorHandler is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFilterTry(this, paramPredicate, paramBiFunction));
  }
  
  @CheckReturnValue
  @Experimental
  public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> paramPredicate, @NonNull ParallelFailureHandling paramParallelFailureHandling) {
    ObjectHelper.requireNonNull(paramPredicate, "predicate");
    ObjectHelper.requireNonNull(paramParallelFailureHandling, "errorHandler is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFilterTry(this, paramPredicate, (BiFunction)paramParallelFailureHandling));
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction) {
    return flatMap(paramFunction, false, 2147483647, Flowable.bufferSize());
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean) {
    return flatMap(paramFunction, paramBoolean, 2147483647, Flowable.bufferSize());
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean, int paramInt) {
    return flatMap(paramFunction, paramBoolean, paramInt, Flowable.bufferSize());
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2) {
    ObjectHelper.requireNonNull(paramFunction, "mapper is null");
    ObjectHelper.verifyPositive(paramInt1, "maxConcurrency");
    ObjectHelper.verifyPositive(paramInt2, "prefetch");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFlatMap(this, paramFunction, paramBoolean, paramInt1, paramInt2));
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> paramFunction) {
    ObjectHelper.requireNonNull(paramFunction, "mapper");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelMap(this, paramFunction));
  }
  
  @CheckReturnValue
  @Experimental
  @NonNull
  public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> paramFunction, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction) {
    ObjectHelper.requireNonNull(paramFunction, "mapper");
    ObjectHelper.requireNonNull(paramBiFunction, "errorHandler is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelMapTry(this, paramFunction, paramBiFunction));
  }
  
  @CheckReturnValue
  @Experimental
  @NonNull
  public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> paramFunction, @NonNull ParallelFailureHandling paramParallelFailureHandling) {
    ObjectHelper.requireNonNull(paramFunction, "mapper");
    ObjectHelper.requireNonNull(paramParallelFailureHandling, "errorHandler is null");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelMapTry(this, paramFunction, (BiFunction)paramParallelFailureHandling));
  }
  
  public abstract int parallelism();
  
  @CheckReturnValue
  @NonNull
  public final Flowable<T> reduce(@NonNull BiFunction<T, T, T> paramBiFunction) {
    ObjectHelper.requireNonNull(paramBiFunction, "reducer");
    return RxJavaPlugins.onAssembly((Flowable)new ParallelReduceFull(this, paramBiFunction));
  }
  
  @CheckReturnValue
  @NonNull
  public final <R> ParallelFlowable<R> reduce(@NonNull Callable<R> paramCallable, @NonNull BiFunction<R, ? super T, R> paramBiFunction) {
    ObjectHelper.requireNonNull(paramCallable, "initialSupplier");
    ObjectHelper.requireNonNull(paramBiFunction, "reducer");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelReduce(this, paramCallable, paramBiFunction));
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> runOn(@NonNull Scheduler paramScheduler) {
    return runOn(paramScheduler, Flowable.bufferSize());
  }
  
  @CheckReturnValue
  @NonNull
  public final ParallelFlowable<T> runOn(@NonNull Scheduler paramScheduler, int paramInt) {
    ObjectHelper.requireNonNull(paramScheduler, "scheduler");
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelRunOn(this, paramScheduler, paramInt));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> sequential() {
    return sequential(Flowable.bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  @NonNull
  public final Flowable<T> sequential(int paramInt) {
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly((Flowable)new ParallelJoin(this, paramInt, false));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  @Experimental
  @NonNull
  public final Flowable<T> sequentialDelayError() {
    return sequentialDelayError(Flowable.bufferSize());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  @NonNull
  public final Flowable<T> sequentialDelayError(int paramInt) {
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly((Flowable)new ParallelJoin(this, paramInt, true));
  }
  
  @CheckReturnValue
  @NonNull
  public final Flowable<T> sorted(@NonNull Comparator<? super T> paramComparator) {
    return sorted(paramComparator, 16);
  }
  
  @CheckReturnValue
  @NonNull
  public final Flowable<T> sorted(@NonNull Comparator<? super T> paramComparator, int paramInt) {
    ObjectHelper.requireNonNull(paramComparator, "comparator is null");
    ObjectHelper.verifyPositive(paramInt, "capacityHint");
    return RxJavaPlugins.onAssembly((Flowable)new ParallelSortedJoin(reduce(Functions.createArrayList(paramInt / parallelism() + 1), ListAddBiConsumer.instance()).map((Function)new SorterFunction(paramComparator)), paramComparator));
  }
  
  public abstract void subscribe(@NonNull Subscriber<? super T>[] paramArrayOfSubscriber);
  
  @CheckReturnValue
  @NonNull
  public final <U> U to(@NonNull Function<? super ParallelFlowable<T>, U> paramFunction) {
    try {
      return (U)((Function)ObjectHelper.requireNonNull(paramFunction, "converter is null")).apply(this);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      throw ExceptionHelper.wrapOrThrow(throwable);
    } 
  }
  
  @CheckReturnValue
  @NonNull
  public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> paramComparator) {
    return toSortedList(paramComparator, 16);
  }
  
  @CheckReturnValue
  @NonNull
  public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> paramComparator, int paramInt) {
    ObjectHelper.requireNonNull(paramComparator, "comparator is null");
    ObjectHelper.verifyPositive(paramInt, "capacityHint");
    return RxJavaPlugins.onAssembly(reduce(Functions.createArrayList(paramInt / parallelism() + 1), ListAddBiConsumer.instance()).map((Function)new SorterFunction(paramComparator)).reduce((BiFunction)new MergerBiFunction(paramComparator)));
  }
  
  protected final boolean validate(@NonNull Subscriber<?>[] paramArrayOfSubscriber) {
    int i = parallelism();
    if (paramArrayOfSubscriber.length != i) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("parallelism = ");
      stringBuilder.append(i);
      stringBuilder.append(", subscribers = ");
      stringBuilder.append(paramArrayOfSubscriber.length);
      IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
      int j = paramArrayOfSubscriber.length;
      for (i = 0; i < j; i++)
        EmptySubscription.error(illegalArgumentException, paramArrayOfSubscriber[i]); 
      return false;
    } 
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\parallel\ParallelFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */