package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class Schedulers {
  @NonNull
  static final Scheduler COMPUTATION;
  
  @NonNull
  static final Scheduler IO;
  
  @NonNull
  static final Scheduler NEW_THREAD;
  
  @NonNull
  static final Scheduler SINGLE = RxJavaPlugins.initSingleScheduler(new SingleTask());
  
  @NonNull
  static final Scheduler TRAMPOLINE;
  
  static {
    COMPUTATION = RxJavaPlugins.initComputationScheduler(new ComputationTask());
    IO = RxJavaPlugins.initIoScheduler(new IOTask());
    TRAMPOLINE = (Scheduler)TrampolineScheduler.instance();
    NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());
  }
  
  private Schedulers() {
    throw new IllegalStateException("No instances!");
  }
  
  @NonNull
  public static Scheduler computation() {
    return RxJavaPlugins.onComputationScheduler(COMPUTATION);
  }
  
  @NonNull
  public static Scheduler from(@NonNull Executor paramExecutor) {
    return (Scheduler)new ExecutorScheduler(paramExecutor);
  }
  
  @NonNull
  public static Scheduler io() {
    return RxJavaPlugins.onIoScheduler(IO);
  }
  
  @NonNull
  public static Scheduler newThread() {
    return RxJavaPlugins.onNewThreadScheduler(NEW_THREAD);
  }
  
  public static void shutdown() {
    computation().shutdown();
    io().shutdown();
    newThread().shutdown();
    single().shutdown();
    trampoline().shutdown();
    SchedulerPoolFactory.shutdown();
  }
  
  @NonNull
  public static Scheduler single() {
    return RxJavaPlugins.onSingleScheduler(SINGLE);
  }
  
  public static void start() {
    computation().start();
    io().start();
    newThread().start();
    single().start();
    trampoline().start();
    SchedulerPoolFactory.start();
  }
  
  @NonNull
  public static Scheduler trampoline() {
    return TRAMPOLINE;
  }
  
  static final class ComputationHolder {
    static final Scheduler DEFAULT = (Scheduler)new ComputationScheduler();
  }
  
  static final class ComputationTask implements Callable<Scheduler> {
    public Scheduler call() throws Exception {
      return Schedulers.ComputationHolder.DEFAULT;
    }
  }
  
  static final class IOTask implements Callable<Scheduler> {
    public Scheduler call() throws Exception {
      return Schedulers.IoHolder.DEFAULT;
    }
  }
  
  static final class IoHolder {
    static final Scheduler DEFAULT = (Scheduler)new IoScheduler();
  }
  
  static final class NewThreadHolder {
    static final Scheduler DEFAULT = (Scheduler)new NewThreadScheduler();
  }
  
  static final class NewThreadTask implements Callable<Scheduler> {
    public Scheduler call() throws Exception {
      return Schedulers.NewThreadHolder.DEFAULT;
    }
  }
  
  static final class SingleHolder {
    static final Scheduler DEFAULT = (Scheduler)new SingleScheduler();
  }
  
  static final class SingleTask implements Callable<Scheduler> {
    public Scheduler call() throws Exception {
      return Schedulers.SingleHolder.DEFAULT;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\schedulers\Schedulers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */