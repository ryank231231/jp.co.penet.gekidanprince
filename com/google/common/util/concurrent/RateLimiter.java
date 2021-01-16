package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@GwtIncompatible
@ThreadSafe
public abstract class RateLimiter {
  private volatile Object mutexDoNotUseDirectly;
  
  private final SleepingStopwatch stopwatch;
  
  RateLimiter(SleepingStopwatch paramSleepingStopwatch) {
    this.stopwatch = (SleepingStopwatch)Preconditions.checkNotNull(paramSleepingStopwatch);
  }
  
  private boolean canAcquire(long paramLong1, long paramLong2) {
    boolean bool;
    if (queryEarliestAvailable(paramLong1) - paramLong2 <= paramLong1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static void checkPermits(int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Requested permits (%s) must be positive", paramInt);
  }
  
  public static RateLimiter create(double paramDouble) {
    return create(SleepingStopwatch.createFromSystemTimer(), paramDouble);
  }
  
  public static RateLimiter create(double paramDouble, long paramLong, TimeUnit paramTimeUnit) {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "warmupPeriod must not be negative: %s", paramLong);
    return create(SleepingStopwatch.createFromSystemTimer(), paramDouble, paramLong, paramTimeUnit, 3.0D);
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch paramSleepingStopwatch, double paramDouble) {
    SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(paramSleepingStopwatch, 1.0D);
    smoothBursty.setRate(paramDouble);
    return smoothBursty;
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch paramSleepingStopwatch, double paramDouble1, long paramLong, TimeUnit paramTimeUnit, double paramDouble2) {
    SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(paramSleepingStopwatch, paramLong, paramTimeUnit, paramDouble2);
    smoothWarmingUp.setRate(paramDouble1);
    return smoothWarmingUp;
  }
  
  private Object mutex() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mutexDoNotUseDirectly : Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull -> 47
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield mutexDoNotUseDirectly : Ljava/lang/Object;
    //   17: astore_1
    //   18: aload_1
    //   19: astore_2
    //   20: aload_1
    //   21: ifnonnull -> 37
    //   24: new java/lang/Object
    //   27: astore_2
    //   28: aload_2
    //   29: invokespecial <init> : ()V
    //   32: aload_0
    //   33: aload_2
    //   34: putfield mutexDoNotUseDirectly : Ljava/lang/Object;
    //   37: aload_0
    //   38: monitorexit
    //   39: goto -> 47
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    //   47: aload_2
    //   48: areturn
    // Exception table:
    //   from	to	target	type
    //   13	18	42	finally
    //   24	37	42	finally
    //   37	39	42	finally
    //   43	45	42	finally
  }
  
  @CanIgnoreReturnValue
  public double acquire() {
    return acquire(1);
  }
  
  @CanIgnoreReturnValue
  public double acquire(int paramInt) {
    long l = reserve(paramInt);
    this.stopwatch.sleepMicrosUninterruptibly(l);
    double d1 = l;
    Double.isNaN(d1);
    double d2 = TimeUnit.SECONDS.toMicros(1L);
    Double.isNaN(d2);
    return d1 * 1.0D / d2;
  }
  
  abstract double doGetRate();
  
  abstract void doSetRate(double paramDouble, long paramLong);
  
  public final double getRate() {
    synchronized (mutex()) {
      return doGetRate();
    } 
  }
  
  abstract long queryEarliestAvailable(long paramLong);
  
  final long reserve(int paramInt) {
    checkPermits(paramInt);
    synchronized (mutex()) {
      return reserveAndGetWaitLength(paramInt, this.stopwatch.readMicros());
    } 
  }
  
  final long reserveAndGetWaitLength(int paramInt, long paramLong) {
    return Math.max(reserveEarliestAvailable(paramInt, paramLong) - paramLong, 0L);
  }
  
  abstract long reserveEarliestAvailable(int paramInt, long paramLong);
  
  public final void setRate(double paramDouble) {
    boolean bool;
    if (paramDouble > 0.0D && !Double.isNaN(paramDouble)) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "rate must be positive");
    synchronized (mutex()) {
      doSetRate(paramDouble, this.stopwatch.readMicros());
      return;
    } 
  }
  
  public String toString() {
    return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[] { Double.valueOf(getRate()) });
  }
  
  public boolean tryAcquire() {
    return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire(int paramInt) {
    return tryAcquire(paramInt, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire(int paramInt, long paramLong, TimeUnit paramTimeUnit) {
    paramLong = Math.max(paramTimeUnit.toMicros(paramLong), 0L);
    checkPermits(paramInt);
    synchronized (mutex()) {
      long l = this.stopwatch.readMicros();
      if (!canAcquire(l, paramLong))
        return false; 
      paramLong = reserveAndGetWaitLength(paramInt, l);
      this.stopwatch.sleepMicrosUninterruptibly(paramLong);
      return true;
    } 
  }
  
  public boolean tryAcquire(long paramLong, TimeUnit paramTimeUnit) {
    return tryAcquire(1, paramLong, paramTimeUnit);
  }
  
  static abstract class SleepingStopwatch {
    public static final SleepingStopwatch createFromSystemTimer() {
      return new SleepingStopwatch() {
          final Stopwatch stopwatch = Stopwatch.createStarted();
          
          protected long readMicros() {
            return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
          }
          
          protected void sleepMicrosUninterruptibly(long param2Long) {
            if (param2Long > 0L)
              Uninterruptibles.sleepUninterruptibly(param2Long, TimeUnit.MICROSECONDS); 
          }
        };
    }
    
    protected abstract long readMicros();
    
    protected abstract void sleepMicrosUninterruptibly(long param1Long);
  }
  
  static final class null extends SleepingStopwatch {
    final Stopwatch stopwatch = Stopwatch.createStarted();
    
    protected long readMicros() {
      return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
    }
    
    protected void sleepMicrosUninterruptibly(long param1Long) {
      if (param1Long > 0L)
        Uninterruptibles.sleepUninterruptibly(param1Long, TimeUnit.MICROSECONDS); 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\RateLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */