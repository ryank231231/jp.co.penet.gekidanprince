package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableFlowable<T> extends Flowable<T> {
  @NonNull
  public Flowable<T> autoConnect() {
    return autoConnect(1);
  }
  
  @NonNull
  public Flowable<T> autoConnect(int paramInt) {
    return autoConnect(paramInt, Functions.emptyConsumer());
  }
  
  @NonNull
  public Flowable<T> autoConnect(int paramInt, @NonNull Consumer<? super Disposable> paramConsumer) {
    if (paramInt <= 0) {
      connect(paramConsumer);
      return RxJavaPlugins.onAssembly(this);
    } 
    return RxJavaPlugins.onAssembly((Flowable)new FlowableAutoConnect(this, paramInt, paramConsumer));
  }
  
  public final Disposable connect() {
    ConnectConsumer connectConsumer = new ConnectConsumer();
    connect((Consumer<? super Disposable>)connectConsumer);
    return connectConsumer.disposable;
  }
  
  public abstract void connect(@NonNull Consumer<? super Disposable> paramConsumer);
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  @NonNull
  public Flowable<T> refCount() {
    return RxJavaPlugins.onAssembly((Flowable)new FlowableRefCount(this));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("none")
  @Experimental
  public final Flowable<T> refCount(int paramInt) {
    return refCount(paramInt, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  @Experimental
  public final Flowable<T> refCount(int paramInt, long paramLong, TimeUnit paramTimeUnit) {
    return refCount(paramInt, paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  @Experimental
  public final Flowable<T> refCount(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    ObjectHelper.verifyPositive(paramInt, "subscriberCount");
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return RxJavaPlugins.onAssembly((Flowable)new FlowableRefCount(this, paramInt, paramLong, paramTimeUnit, paramScheduler));
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  @Experimental
  public final Flowable<T> refCount(long paramLong, TimeUnit paramTimeUnit) {
    return refCount(1, paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @BackpressureSupport(BackpressureKind.PASS_THROUGH)
  @CheckReturnValue
  @SchedulerSupport("custom")
  @Experimental
  public final Flowable<T> refCount(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    return refCount(1, paramLong, paramTimeUnit, paramScheduler);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\io\reactivex\flowables\ConnectableFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */