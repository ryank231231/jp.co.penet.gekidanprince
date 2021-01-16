package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {
  static final Scheduler HELPER = Schedulers.single();
  
  @NonNull
  final Executor executor;
  
  public ExecutorScheduler(@NonNull Executor paramExecutor) {
    this.executor = paramExecutor;
  }
  
  @NonNull
  public Scheduler.Worker createWorker() {
    return new ExecutorWorker(this.executor);
  }
  
  @NonNull
  public Disposable scheduleDirect(@NonNull Runnable paramRunnable) {
    paramRunnable = RxJavaPlugins.onSchedule(paramRunnable);
    try {
      if (this.executor instanceof ExecutorService) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask();
        this(paramRunnable);
        scheduledDirectTask.setFuture(((ExecutorService)this.executor).submit(scheduledDirectTask));
        return scheduledDirectTask;
      } 
      ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable();
      this(paramRunnable);
      this.executor.execute(booleanRunnable);
      return booleanRunnable;
    } catch (RejectedExecutionException rejectedExecutionException) {
      RxJavaPlugins.onError(rejectedExecutionException);
      return (Disposable)EmptyDisposable.INSTANCE;
    } 
  }
  
  @NonNull
  public Disposable scheduleDirect(@NonNull Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) {
    Runnable runnable = RxJavaPlugins.onSchedule(paramRunnable);
    if (this.executor instanceof ScheduledExecutorService)
      try {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask();
        this(runnable);
        scheduledDirectTask.setFuture(((ScheduledExecutorService)this.executor).schedule(scheduledDirectTask, paramLong, paramTimeUnit));
        return scheduledDirectTask;
      } catch (RejectedExecutionException rejectedExecutionException) {
        RxJavaPlugins.onError(rejectedExecutionException);
        return (Disposable)EmptyDisposable.INSTANCE;
      }  
    paramRunnable = new DelayedRunnable(runnable);
    Disposable disposable = HELPER.scheduleDirect(new DelayedDispose((DelayedRunnable)paramRunnable), paramLong, paramTimeUnit);
    ((DelayedRunnable)paramRunnable).timed.replace(disposable);
    return (Disposable)paramRunnable;
  }
  
  @NonNull
  public Disposable schedulePeriodicallyDirect(@NonNull Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit) {
    if (this.executor instanceof ScheduledExecutorService) {
      Runnable runnable = RxJavaPlugins.onSchedule(paramRunnable);
      try {
        paramRunnable = new ScheduledDirectPeriodicTask();
        super(runnable);
        paramRunnable.setFuture(((ScheduledExecutorService)this.executor).scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
        return (Disposable)paramRunnable;
      } catch (RejectedExecutionException rejectedExecutionException) {
        RxJavaPlugins.onError(rejectedExecutionException);
        return (Disposable)EmptyDisposable.INSTANCE;
      } 
    } 
    return super.schedulePeriodicallyDirect((Runnable)rejectedExecutionException, paramLong1, paramLong2, paramTimeUnit);
  }
  
  final class DelayedDispose implements Runnable {
    private final ExecutorScheduler.DelayedRunnable dr;
    
    DelayedDispose(ExecutorScheduler.DelayedRunnable param1DelayedRunnable) {
      this.dr = param1DelayedRunnable;
    }
    
    public void run() {
      this.dr.direct.replace(ExecutorScheduler.this.scheduleDirect(this.dr));
    }
  }
  
  static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
    private static final long serialVersionUID = -4101336210206799084L;
    
    final SequentialDisposable direct = new SequentialDisposable();
    
    final SequentialDisposable timed = new SequentialDisposable();
    
    DelayedRunnable(Runnable param1Runnable) {
      super(param1Runnable);
    }
    
    public void dispose() {
      if (getAndSet(null) != null) {
        this.timed.dispose();
        this.direct.dispose();
      } 
    }
    
    public Runnable getWrappedRunnable() {
      Runnable runnable = get();
      if (runnable == null)
        runnable = Functions.EMPTY_RUNNABLE; 
      return runnable;
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (get() == null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void run() {
      Runnable runnable = get();
      if (runnable != null)
        try {
          runnable.run();
        } finally {
          lazySet(null);
          this.timed.lazySet(DisposableHelper.DISPOSED);
          this.direct.lazySet(DisposableHelper.DISPOSED);
        }  
    }
  }
  
  public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
    volatile boolean disposed;
    
    final Executor executor;
    
    final MpscLinkedQueue<Runnable> queue;
    
    final CompositeDisposable tasks = new CompositeDisposable();
    
    final AtomicInteger wip = new AtomicInteger();
    
    public ExecutorWorker(Executor param1Executor) {
      this.executor = param1Executor;
      this.queue = new MpscLinkedQueue();
    }
    
    public void dispose() {
      if (!this.disposed) {
        this.disposed = true;
        this.tasks.dispose();
        if (this.wip.getAndIncrement() == 0)
          this.queue.clear(); 
      } 
    }
    
    public boolean isDisposed() {
      return this.disposed;
    }
    
    public void run() {
      MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
      int i = 1;
      label19: while (true) {
        if (this.disposed) {
          mpscLinkedQueue.clear();
          return;
        } 
        while (true) {
          Runnable runnable = (Runnable)mpscLinkedQueue.poll();
          if (runnable == null) {
            if (this.disposed) {
              mpscLinkedQueue.clear();
              return;
            } 
            int j = this.wip.addAndGet(-i);
            i = j;
            if (j == 0)
              return; 
            continue label19;
          } 
          runnable.run();
          if (this.disposed) {
            mpscLinkedQueue.clear();
            return;
          } 
        } 
        break;
      } 
    }
    
    @NonNull
    public Disposable schedule(@NonNull Runnable param1Runnable) {
      if (this.disposed)
        return (Disposable)EmptyDisposable.INSTANCE; 
      param1Runnable = new BooleanRunnable(RxJavaPlugins.onSchedule(param1Runnable));
      this.queue.offer(param1Runnable);
      if (this.wip.getAndIncrement() == 0)
        try {
          this.executor.execute(this);
        } catch (RejectedExecutionException rejectedExecutionException) {
          this.disposed = true;
          this.queue.clear();
          RxJavaPlugins.onError(rejectedExecutionException);
          return (Disposable)EmptyDisposable.INSTANCE;
        }  
      return (Disposable)rejectedExecutionException;
    }
    
    @NonNull
    public Disposable schedule(@NonNull Runnable param1Runnable, long param1Long, @NonNull TimeUnit param1TimeUnit) {
      if (param1Long <= 0L)
        return schedule(param1Runnable); 
      if (this.disposed)
        return (Disposable)EmptyDisposable.INSTANCE; 
      SequentialDisposable sequentialDisposable1 = new SequentialDisposable();
      SequentialDisposable sequentialDisposable2 = new SequentialDisposable((Disposable)sequentialDisposable1);
      param1Runnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.onSchedule(param1Runnable)), (DisposableContainer)this.tasks);
      this.tasks.add((Disposable)param1Runnable);
      Executor executor = this.executor;
      if (executor instanceof ScheduledExecutorService) {
        try {
          param1Runnable.setFuture(((ScheduledExecutorService)executor).schedule((Callable<?>)param1Runnable, param1Long, param1TimeUnit));
        } catch (RejectedExecutionException rejectedExecutionException) {
          this.disposed = true;
          RxJavaPlugins.onError(rejectedExecutionException);
          return (Disposable)EmptyDisposable.INSTANCE;
        } 
      } else {
        rejectedExecutionException.setFuture(new DisposeOnCancel(ExecutorScheduler.HELPER.scheduleDirect((Runnable)rejectedExecutionException, param1Long, param1TimeUnit)));
      } 
      sequentialDisposable1.replace((Disposable)rejectedExecutionException);
      return (Disposable)sequentialDisposable2;
    }
    
    static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
      private static final long serialVersionUID = -2421395018820541164L;
      
      final Runnable actual;
      
      BooleanRunnable(Runnable param2Runnable) {
        this.actual = param2Runnable;
      }
      
      public void dispose() {
        lazySet(true);
      }
      
      public boolean isDisposed() {
        return get();
      }
      
      public void run() {
        if (get())
          return; 
        try {
          this.actual.run();
          return;
        } finally {
          lazySet(true);
        } 
      }
    }
    
    final class SequentialDispose implements Runnable {
      private final Runnable decoratedRun;
      
      private final SequentialDisposable mar;
      
      SequentialDispose(SequentialDisposable param2SequentialDisposable, Runnable param2Runnable) {
        this.mar = param2SequentialDisposable;
        this.decoratedRun = param2Runnable;
      }
      
      public void run() {
        this.mar.replace(ExecutorScheduler.ExecutorWorker.this.schedule(this.decoratedRun));
      }
    }
  }
  
  static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
    private static final long serialVersionUID = -2421395018820541164L;
    
    final Runnable actual;
    
    BooleanRunnable(Runnable param1Runnable) {
      this.actual = param1Runnable;
    }
    
    public void dispose() {
      lazySet(true);
    }
    
    public boolean isDisposed() {
      return get();
    }
    
    public void run() {
      if (get())
        return; 
      try {
        this.actual.run();
        return;
      } finally {
        lazySet(true);
      } 
    }
  }
  
  final class SequentialDispose implements Runnable {
    private final Runnable decoratedRun;
    
    private final SequentialDisposable mar;
    
    SequentialDispose(SequentialDisposable param1SequentialDisposable, Runnable param1Runnable) {
      this.mar = param1SequentialDisposable;
      this.decoratedRun = param1Runnable;
    }
    
    public void run() {
      this.mar.replace(this.this$0.schedule(this.decoratedRun));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\ExecutorScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */