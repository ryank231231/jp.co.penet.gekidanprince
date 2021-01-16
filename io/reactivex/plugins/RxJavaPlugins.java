package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Beta;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

public final class RxJavaPlugins {
  @Nullable
  static volatile Consumer<? super Throwable> errorHandler;
  
  static volatile boolean failNonBlockingScheduler;
  
  static volatile boolean lockdown;
  
  @Nullable
  static volatile BooleanSupplier onBeforeBlocking;
  
  @Nullable
  static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
  
  @Nullable
  static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;
  
  @Nullable
  static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
  
  @Nullable
  static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly;
  
  @Nullable
  static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly;
  
  @Nullable
  static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
  
  @Nullable
  static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe;
  
  @Nullable
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;
  
  @Nullable
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;
  
  @Nullable
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
  
  @Nullable
  static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;
  
  @Nullable
  static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
  
  @Nullable
  static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;
  
  @Nullable
  static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe;
  
  @Nullable
  static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;
  
  @Nullable
  static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
  
  @Nullable
  static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
  
  @Nullable
  static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly;
  
  @Nullable
  static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
  
  @Nullable
  static volatile Function<? super Single, ? extends Single> onSingleAssembly;
  
  @Nullable
  static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;
  
  @Nullable
  static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;
  
  private RxJavaPlugins() {
    throw new IllegalStateException("No instances!");
  }
  
  @NonNull
  static <T, U, R> R apply(@NonNull BiFunction<T, U, R> paramBiFunction, @NonNull T paramT, @NonNull U paramU) {
    try {
      return (R)paramBiFunction.apply(paramT, paramU);
    } catch (Throwable throwable) {
      throw ExceptionHelper.wrapOrThrow(throwable);
    } 
  }
  
  @NonNull
  static <T, R> R apply(@NonNull Function<T, R> paramFunction, @NonNull T paramT) {
    try {
      return (R)paramFunction.apply(paramT);
    } catch (Throwable throwable) {
      throw ExceptionHelper.wrapOrThrow(throwable);
    } 
  }
  
  @NonNull
  static Scheduler applyRequireNonNull(@NonNull Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction, Callable<Scheduler> paramCallable) {
    return (Scheduler)ObjectHelper.requireNonNull(apply(paramFunction, paramCallable), "Scheduler Callable result can't be null");
  }
  
  @NonNull
  static Scheduler callRequireNonNull(@NonNull Callable<Scheduler> paramCallable) {
    try {
      return (Scheduler)ObjectHelper.requireNonNull(paramCallable.call(), "Scheduler Callable result can't be null");
    } catch (Throwable throwable) {
      throw ExceptionHelper.wrapOrThrow(throwable);
    } 
  }
  
  @NonNull
  public static Scheduler createComputationScheduler(@NonNull ThreadFactory paramThreadFactory) {
    return (Scheduler)new ComputationScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  @NonNull
  public static Scheduler createIoScheduler(@NonNull ThreadFactory paramThreadFactory) {
    return (Scheduler)new IoScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  @NonNull
  public static Scheduler createNewThreadScheduler(@NonNull ThreadFactory paramThreadFactory) {
    return (Scheduler)new NewThreadScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  @NonNull
  public static Scheduler createSingleScheduler(@NonNull ThreadFactory paramThreadFactory) {
    return (Scheduler)new SingleScheduler((ThreadFactory)ObjectHelper.requireNonNull(paramThreadFactory, "threadFactory is null"));
  }
  
  @Nullable
  public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
    return onComputationHandler;
  }
  
  @Nullable
  public static Consumer<? super Throwable> getErrorHandler() {
    return errorHandler;
  }
  
  @Nullable
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
    return onInitComputationHandler;
  }
  
  @Nullable
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
    return onInitIoHandler;
  }
  
  @Nullable
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
    return onInitNewThreadHandler;
  }
  
  @Nullable
  public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
    return onInitSingleHandler;
  }
  
  @Nullable
  public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
    return onIoHandler;
  }
  
  @Nullable
  public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
    return onNewThreadHandler;
  }
  
  @Nullable
  public static BooleanSupplier getOnBeforeBlocking() {
    return onBeforeBlocking;
  }
  
  @Nullable
  public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
    return onCompletableAssembly;
  }
  
  @Nullable
  public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
    return onCompletableSubscribe;
  }
  
  @Nullable
  public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
    return onConnectableFlowableAssembly;
  }
  
  @Nullable
  public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
    return onConnectableObservableAssembly;
  }
  
  @Nullable
  public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
    return onFlowableAssembly;
  }
  
  @Nullable
  public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
    return onFlowableSubscribe;
  }
  
  @Nullable
  public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
    return onMaybeAssembly;
  }
  
  @Nullable
  public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
    return onMaybeSubscribe;
  }
  
  @Nullable
  public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
    return onObservableAssembly;
  }
  
  @Nullable
  public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
    return onObservableSubscribe;
  }
  
  @Beta
  @Nullable
  public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
    return onParallelAssembly;
  }
  
  @Nullable
  public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
    return onSingleAssembly;
  }
  
  @Nullable
  public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
    return onSingleSubscribe;
  }
  
  @Nullable
  public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
    return onScheduleHandler;
  }
  
  @Nullable
  public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
    return onSingleHandler;
  }
  
  @NonNull
  public static Scheduler initComputationScheduler(@NonNull Callable<Scheduler> paramCallable) {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitComputationHandler;
    return (function == null) ? callRequireNonNull(paramCallable) : applyRequireNonNull(function, paramCallable);
  }
  
  @NonNull
  public static Scheduler initIoScheduler(@NonNull Callable<Scheduler> paramCallable) {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitIoHandler;
    return (function == null) ? callRequireNonNull(paramCallable) : applyRequireNonNull(function, paramCallable);
  }
  
  @NonNull
  public static Scheduler initNewThreadScheduler(@NonNull Callable<Scheduler> paramCallable) {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitNewThreadHandler;
    return (function == null) ? callRequireNonNull(paramCallable) : applyRequireNonNull(function, paramCallable);
  }
  
  @NonNull
  public static Scheduler initSingleScheduler(@NonNull Callable<Scheduler> paramCallable) {
    ObjectHelper.requireNonNull(paramCallable, "Scheduler Callable can't be null");
    Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitSingleHandler;
    return (function == null) ? callRequireNonNull(paramCallable) : applyRequireNonNull(function, paramCallable);
  }
  
  static boolean isBug(Throwable paramThrowable) {
    return (paramThrowable instanceof io.reactivex.exceptions.OnErrorNotImplementedException) ? true : ((paramThrowable instanceof io.reactivex.exceptions.MissingBackpressureException) ? true : ((paramThrowable instanceof IllegalStateException) ? true : ((paramThrowable instanceof NullPointerException) ? true : ((paramThrowable instanceof IllegalArgumentException) ? true : ((paramThrowable instanceof io.reactivex.exceptions.CompositeException))))));
  }
  
  public static boolean isFailOnNonBlockingScheduler() {
    return failNonBlockingScheduler;
  }
  
  public static boolean isLockdown() {
    return lockdown;
  }
  
  public static void lockdown() {
    lockdown = true;
  }
  
  @NonNull
  public static Completable onAssembly(@NonNull Completable paramCompletable) {
    Function<? super Completable, ? extends Completable> function = onCompletableAssembly;
    return (function != null) ? apply((Function)function, paramCompletable) : paramCompletable;
  }
  
  @NonNull
  public static <T> Flowable<T> onAssembly(@NonNull Flowable<T> paramFlowable) {
    Function<? super Flowable, ? extends Flowable> function = onFlowableAssembly;
    return (function != null) ? apply((Function)function, paramFlowable) : paramFlowable;
  }
  
  @NonNull
  public static <T> Maybe<T> onAssembly(@NonNull Maybe<T> paramMaybe) {
    Function<? super Maybe, ? extends Maybe> function = onMaybeAssembly;
    return (function != null) ? apply((Function)function, paramMaybe) : paramMaybe;
  }
  
  @NonNull
  public static <T> Observable<T> onAssembly(@NonNull Observable<T> paramObservable) {
    Function<? super Observable, ? extends Observable> function = onObservableAssembly;
    return (function != null) ? apply((Function)function, paramObservable) : paramObservable;
  }
  
  @NonNull
  public static <T> Single<T> onAssembly(@NonNull Single<T> paramSingle) {
    Function<? super Single, ? extends Single> function = onSingleAssembly;
    return (function != null) ? apply((Function)function, paramSingle) : paramSingle;
  }
  
  @NonNull
  public static <T> ConnectableFlowable<T> onAssembly(@NonNull ConnectableFlowable<T> paramConnectableFlowable) {
    Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = onConnectableFlowableAssembly;
    return (function != null) ? apply((Function)function, paramConnectableFlowable) : paramConnectableFlowable;
  }
  
  @NonNull
  public static <T> ConnectableObservable<T> onAssembly(@NonNull ConnectableObservable<T> paramConnectableObservable) {
    Function<? super ConnectableObservable, ? extends ConnectableObservable> function = onConnectableObservableAssembly;
    return (function != null) ? apply((Function)function, paramConnectableObservable) : paramConnectableObservable;
  }
  
  @Beta
  @NonNull
  public static <T> ParallelFlowable<T> onAssembly(@NonNull ParallelFlowable<T> paramParallelFlowable) {
    Function<? super ParallelFlowable, ? extends ParallelFlowable> function = onParallelAssembly;
    return (function != null) ? apply((Function)function, paramParallelFlowable) : paramParallelFlowable;
  }
  
  public static boolean onBeforeBlocking() {
    BooleanSupplier booleanSupplier = onBeforeBlocking;
    if (booleanSupplier != null)
      try {
        return booleanSupplier.getAsBoolean();
      } catch (Throwable throwable) {
        throw ExceptionHelper.wrapOrThrow(throwable);
      }  
    return false;
  }
  
  @NonNull
  public static Scheduler onComputationScheduler(@NonNull Scheduler paramScheduler) {
    Function<? super Scheduler, ? extends Scheduler> function = onComputationHandler;
    return (function == null) ? paramScheduler : apply((Function)function, paramScheduler);
  }
  
  public static void onError(@NonNull Throwable paramThrowable) {
    UndeliverableException undeliverableException;
    Consumer<? super Throwable> consumer = errorHandler;
    if (paramThrowable == null) {
      NullPointerException nullPointerException = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    } else {
      Throwable throwable = paramThrowable;
      if (!isBug(paramThrowable))
        undeliverableException = new UndeliverableException(paramThrowable); 
    } 
    if (consumer != null)
      try {
        consumer.accept(undeliverableException);
        return;
      } catch (Throwable throwable) {
        throwable.printStackTrace();
        uncaught(throwable);
      }  
    undeliverableException.printStackTrace();
    uncaught((Throwable)undeliverableException);
  }
  
  @NonNull
  public static Scheduler onIoScheduler(@NonNull Scheduler paramScheduler) {
    Function<? super Scheduler, ? extends Scheduler> function = onIoHandler;
    return (function == null) ? paramScheduler : apply((Function)function, paramScheduler);
  }
  
  @NonNull
  public static Scheduler onNewThreadScheduler(@NonNull Scheduler paramScheduler) {
    Function<? super Scheduler, ? extends Scheduler> function = onNewThreadHandler;
    return (function == null) ? paramScheduler : apply((Function)function, paramScheduler);
  }
  
  @NonNull
  public static Runnable onSchedule(@NonNull Runnable paramRunnable) {
    ObjectHelper.requireNonNull(paramRunnable, "run is null");
    Function<? super Runnable, ? extends Runnable> function = onScheduleHandler;
    return (function == null) ? paramRunnable : apply((Function)function, paramRunnable);
  }
  
  @NonNull
  public static Scheduler onSingleScheduler(@NonNull Scheduler paramScheduler) {
    Function<? super Scheduler, ? extends Scheduler> function = onSingleHandler;
    return (function == null) ? paramScheduler : apply((Function)function, paramScheduler);
  }
  
  @NonNull
  public static CompletableObserver onSubscribe(@NonNull Completable paramCompletable, @NonNull CompletableObserver paramCompletableObserver) {
    BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = onCompletableSubscribe;
    return (biFunction != null) ? apply((BiFunction)biFunction, paramCompletable, paramCompletableObserver) : paramCompletableObserver;
  }
  
  @NonNull
  public static <T> MaybeObserver<? super T> onSubscribe(@NonNull Maybe<T> paramMaybe, @NonNull MaybeObserver<? super T> paramMaybeObserver) {
    BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = onMaybeSubscribe;
    return (biFunction != null) ? apply((BiFunction)biFunction, paramMaybe, paramMaybeObserver) : paramMaybeObserver;
  }
  
  @NonNull
  public static <T> Observer<? super T> onSubscribe(@NonNull Observable<T> paramObservable, @NonNull Observer<? super T> paramObserver) {
    BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = onObservableSubscribe;
    return (biFunction != null) ? apply((BiFunction)biFunction, paramObservable, paramObserver) : paramObserver;
  }
  
  @NonNull
  public static <T> SingleObserver<? super T> onSubscribe(@NonNull Single<T> paramSingle, @NonNull SingleObserver<? super T> paramSingleObserver) {
    BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = onSingleSubscribe;
    return (biFunction != null) ? apply((BiFunction)biFunction, paramSingle, paramSingleObserver) : paramSingleObserver;
  }
  
  @NonNull
  public static <T> Subscriber<? super T> onSubscribe(@NonNull Flowable<T> paramFlowable, @NonNull Subscriber<? super T> paramSubscriber) {
    BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = onFlowableSubscribe;
    return (biFunction != null) ? apply((BiFunction)biFunction, paramFlowable, paramSubscriber) : paramSubscriber;
  }
  
  public static void reset() {
    setErrorHandler(null);
    setScheduleHandler(null);
    setComputationSchedulerHandler(null);
    setInitComputationSchedulerHandler(null);
    setIoSchedulerHandler(null);
    setInitIoSchedulerHandler(null);
    setSingleSchedulerHandler(null);
    setInitSingleSchedulerHandler(null);
    setNewThreadSchedulerHandler(null);
    setInitNewThreadSchedulerHandler(null);
    setOnFlowableAssembly(null);
    setOnFlowableSubscribe(null);
    setOnObservableAssembly(null);
    setOnObservableSubscribe(null);
    setOnSingleAssembly(null);
    setOnSingleSubscribe(null);
    setOnCompletableAssembly(null);
    setOnCompletableSubscribe(null);
    setOnConnectableFlowableAssembly(null);
    setOnConnectableObservableAssembly(null);
    setOnMaybeAssembly(null);
    setOnMaybeSubscribe(null);
    setOnParallelAssembly(null);
    setFailOnNonBlockingScheduler(false);
    setOnBeforeBlocking(null);
  }
  
  public static void setComputationSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onComputationHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setErrorHandler(@Nullable Consumer<? super Throwable> paramConsumer) {
    if (!lockdown) {
      errorHandler = paramConsumer;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setFailOnNonBlockingScheduler(boolean paramBoolean) {
    if (!lockdown) {
      failNonBlockingScheduler = paramBoolean;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitComputationSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onInitComputationHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitIoSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onInitIoHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitNewThreadSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onInitNewThreadHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setInitSingleSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onInitSingleHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setIoSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onIoHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setNewThreadSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onNewThreadHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnBeforeBlocking(@Nullable BooleanSupplier paramBooleanSupplier) {
    if (!lockdown) {
      onBeforeBlocking = paramBooleanSupplier;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnCompletableAssembly(@Nullable Function<? super Completable, ? extends Completable> paramFunction) {
    if (!lockdown) {
      onCompletableAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnCompletableSubscribe(@Nullable BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> paramBiFunction) {
    if (!lockdown) {
      onCompletableSubscribe = paramBiFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnConnectableFlowableAssembly(@Nullable Function<? super ConnectableFlowable, ? extends ConnectableFlowable> paramFunction) {
    if (!lockdown) {
      onConnectableFlowableAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnConnectableObservableAssembly(@Nullable Function<? super ConnectableObservable, ? extends ConnectableObservable> paramFunction) {
    if (!lockdown) {
      onConnectableObservableAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnFlowableAssembly(@Nullable Function<? super Flowable, ? extends Flowable> paramFunction) {
    if (!lockdown) {
      onFlowableAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnFlowableSubscribe(@Nullable BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> paramBiFunction) {
    if (!lockdown) {
      onFlowableSubscribe = paramBiFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnMaybeAssembly(@Nullable Function<? super Maybe, ? extends Maybe> paramFunction) {
    if (!lockdown) {
      onMaybeAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnMaybeSubscribe(@Nullable BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> paramBiFunction) {
    if (!lockdown) {
      onMaybeSubscribe = paramBiFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnObservableAssembly(@Nullable Function<? super Observable, ? extends Observable> paramFunction) {
    if (!lockdown) {
      onObservableAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnObservableSubscribe(@Nullable BiFunction<? super Observable, ? super Observer, ? extends Observer> paramBiFunction) {
    if (!lockdown) {
      onObservableSubscribe = paramBiFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  @Beta
  public static void setOnParallelAssembly(@Nullable Function<? super ParallelFlowable, ? extends ParallelFlowable> paramFunction) {
    if (!lockdown) {
      onParallelAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnSingleAssembly(@Nullable Function<? super Single, ? extends Single> paramFunction) {
    if (!lockdown) {
      onSingleAssembly = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setOnSingleSubscribe(@Nullable BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> paramBiFunction) {
    if (!lockdown) {
      onSingleSubscribe = paramBiFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setScheduleHandler(@Nullable Function<? super Runnable, ? extends Runnable> paramFunction) {
    if (!lockdown) {
      onScheduleHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  public static void setSingleSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> paramFunction) {
    if (!lockdown) {
      onSingleHandler = paramFunction;
      return;
    } 
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  static void uncaught(@NonNull Throwable paramThrowable) {
    Thread thread = Thread.currentThread();
    thread.getUncaughtExceptionHandler().uncaughtException(thread, paramThrowable);
  }
  
  static void unlock() {
    lockdown = false;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\plugins\RxJavaPlugins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */