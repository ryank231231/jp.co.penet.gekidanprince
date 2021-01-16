package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
  static final Disposable DISPOSED;
  
  public static final Scheduler INSTANCE = new ImmediateThinScheduler();
  
  static final Scheduler.Worker WORKER = new ImmediateThinWorker();
  
  static {
    DISPOSED = Disposables.empty();
    DISPOSED.dispose();
  }
  
  @NonNull
  public Scheduler.Worker createWorker() {
    return WORKER;
  }
  
  @NonNull
  public Disposable scheduleDirect(@NonNull Runnable paramRunnable) {
    paramRunnable.run();
    return DISPOSED;
  }
  
  @NonNull
  public Disposable scheduleDirect(@NonNull Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) {
    throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
  }
  
  @NonNull
  public Disposable schedulePeriodicallyDirect(@NonNull Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit) {
    throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
  }
  
  static final class ImmediateThinWorker extends Scheduler.Worker {
    public void dispose() {}
    
    public boolean isDisposed() {
      return false;
    }
    
    @NonNull
    public Disposable schedule(@NonNull Runnable param1Runnable) {
      param1Runnable.run();
      return ImmediateThinScheduler.DISPOSED;
    }
    
    @NonNull
    public Disposable schedule(@NonNull Runnable param1Runnable, long param1Long, @NonNull TimeUnit param1TimeUnit) {
      throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }
    
    @NonNull
    public Disposable schedulePeriodically(@NonNull Runnable param1Runnable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
      throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\ImmediateThinScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */