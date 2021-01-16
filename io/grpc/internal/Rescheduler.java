package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class Rescheduler {
  private boolean enabled;
  
  private long runAtNanos;
  
  private final Runnable runnable;
  
  private final ScheduledExecutorService scheduler;
  
  private final Executor serializingExecutor;
  
  private final Stopwatch stopwatch;
  
  private ScheduledFuture<?> wakeUp;
  
  Rescheduler(Runnable paramRunnable, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, Stopwatch paramStopwatch) {
    this.runnable = paramRunnable;
    this.serializingExecutor = paramExecutor;
    this.scheduler = paramScheduledExecutorService;
    this.stopwatch = paramStopwatch;
    paramStopwatch.start();
  }
  
  @VisibleForTesting
  static boolean isEnabled(Runnable paramRunnable) {
    return ((FutureRunnable)paramRunnable).rescheduler.enabled;
  }
  
  private long nanoTime() {
    return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
  }
  
  void cancel(boolean paramBoolean) {
    this.enabled = false;
    if (paramBoolean) {
      ScheduledFuture<?> scheduledFuture = this.wakeUp;
      if (scheduledFuture != null) {
        scheduledFuture.cancel(false);
        this.wakeUp = null;
      } 
    } 
  }
  
  void reschedule(long paramLong, TimeUnit paramTimeUnit) {
    long l = paramTimeUnit.toNanos(paramLong);
    paramLong = nanoTime() + l;
    this.enabled = true;
    if (paramLong - this.runAtNanos < 0L || this.wakeUp == null) {
      ScheduledFuture<?> scheduledFuture = this.wakeUp;
      if (scheduledFuture != null)
        scheduledFuture.cancel(false); 
      this.wakeUp = this.scheduler.schedule(new FutureRunnable(this), l, TimeUnit.NANOSECONDS);
    } 
    this.runAtNanos = paramLong;
  }
  
  private final class ChannelFutureRunnable implements Runnable {
    private ChannelFutureRunnable() {}
    
    public void run() {
      if (!Rescheduler.this.enabled) {
        Rescheduler.access$302(Rescheduler.this, null);
        return;
      } 
      long l = Rescheduler.this.nanoTime();
      if (Rescheduler.this.runAtNanos - l > 0L) {
        Rescheduler rescheduler = Rescheduler.this;
        Rescheduler.access$302(rescheduler, rescheduler.scheduler.schedule(new Rescheduler.FutureRunnable(Rescheduler.this), Rescheduler.this.runAtNanos - l, TimeUnit.NANOSECONDS));
      } else {
        Rescheduler.access$202(Rescheduler.this, false);
        Rescheduler.access$302(Rescheduler.this, null);
        Rescheduler.this.runnable.run();
      } 
    }
  }
  
  private static final class FutureRunnable implements Runnable {
    private final Rescheduler rescheduler;
    
    FutureRunnable(Rescheduler param1Rescheduler) {
      this.rescheduler = param1Rescheduler;
    }
    
    public void run() {
      Executor executor = this.rescheduler.serializingExecutor;
      Rescheduler rescheduler = this.rescheduler;
      rescheduler.getClass();
      executor.execute(new Rescheduler.ChannelFutureRunnable());
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\Rescheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */