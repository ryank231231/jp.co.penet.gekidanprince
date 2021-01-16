package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
abstract class SmoothRateLimiter extends RateLimiter {
  double maxPermits;
  
  private long nextFreeTicketMicros = 0L;
  
  double stableIntervalMicros;
  
  double storedPermits;
  
  private SmoothRateLimiter(RateLimiter.SleepingStopwatch paramSleepingStopwatch) {
    super(paramSleepingStopwatch);
  }
  
  abstract double coolDownIntervalMicros();
  
  final double doGetRate() {
    double d1 = TimeUnit.SECONDS.toMicros(1L);
    double d2 = this.stableIntervalMicros;
    Double.isNaN(d1);
    return d1 / d2;
  }
  
  abstract void doSetRate(double paramDouble1, double paramDouble2);
  
  final void doSetRate(double paramDouble, long paramLong) {
    resync(paramLong);
    double d = TimeUnit.SECONDS.toMicros(1L);
    Double.isNaN(d);
    d /= paramDouble;
    this.stableIntervalMicros = d;
    doSetRate(paramDouble, d);
  }
  
  final long queryEarliestAvailable(long paramLong) {
    return this.nextFreeTicketMicros;
  }
  
  final long reserveEarliestAvailable(int paramInt, long paramLong) {
    resync(paramLong);
    long l1 = this.nextFreeTicketMicros;
    double d1 = paramInt;
    double d2 = Math.min(d1, this.storedPermits);
    Double.isNaN(d1);
    long l2 = storedPermitsToWaitTime(this.storedPermits, d2);
    paramLong = (long)((d1 - d2) * this.stableIntervalMicros);
    this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, l2 + paramLong);
    this.storedPermits -= d2;
    return l1;
  }
  
  void resync(long paramLong) {
    long l = this.nextFreeTicketMicros;
    if (paramLong > l) {
      double d1 = (paramLong - l);
      double d2 = coolDownIntervalMicros();
      Double.isNaN(d1);
      d1 /= d2;
      this.storedPermits = Math.min(this.maxPermits, this.storedPermits + d1);
      this.nextFreeTicketMicros = paramLong;
    } 
  }
  
  abstract long storedPermitsToWaitTime(double paramDouble1, double paramDouble2);
  
  static final class SmoothBursty extends SmoothRateLimiter {
    final double maxBurstSeconds;
    
    SmoothBursty(RateLimiter.SleepingStopwatch param1SleepingStopwatch, double param1Double) {
      super(param1SleepingStopwatch);
      this.maxBurstSeconds = param1Double;
    }
    
    double coolDownIntervalMicros() {
      return this.stableIntervalMicros;
    }
    
    void doSetRate(double param1Double1, double param1Double2) {
      param1Double2 = this.maxPermits;
      this.maxPermits = this.maxBurstSeconds * param1Double1;
      if (param1Double2 == Double.POSITIVE_INFINITY) {
        this.storedPermits = this.maxPermits;
      } else {
        param1Double1 = 0.0D;
        if (param1Double2 != 0.0D)
          param1Double1 = this.storedPermits * this.maxPermits / param1Double2; 
        this.storedPermits = param1Double1;
      } 
    }
    
    long storedPermitsToWaitTime(double param1Double1, double param1Double2) {
      return 0L;
    }
  }
  
  static final class SmoothWarmingUp extends SmoothRateLimiter {
    private double coldFactor;
    
    private double slope;
    
    private double thresholdPermits;
    
    private final long warmupPeriodMicros;
    
    SmoothWarmingUp(RateLimiter.SleepingStopwatch param1SleepingStopwatch, long param1Long, TimeUnit param1TimeUnit, double param1Double) {
      super(param1SleepingStopwatch);
      this.warmupPeriodMicros = param1TimeUnit.toMicros(param1Long);
      this.coldFactor = param1Double;
    }
    
    private double permitsToTime(double param1Double) {
      return this.stableIntervalMicros + param1Double * this.slope;
    }
    
    double coolDownIntervalMicros() {
      double d1 = this.warmupPeriodMicros;
      double d2 = this.maxPermits;
      Double.isNaN(d1);
      return d1 / d2;
    }
    
    void doSetRate(double param1Double1, double param1Double2) {
      param1Double1 = this.maxPermits;
      double d1 = this.coldFactor * param1Double2;
      long l = this.warmupPeriodMicros;
      double d2 = l;
      Double.isNaN(d2);
      this.thresholdPermits = d2 * 0.5D / param1Double2;
      double d3 = this.thresholdPermits;
      d2 = l;
      Double.isNaN(d2);
      this.maxPermits = d3 + d2 * 2.0D / (param1Double2 + d1);
      this.slope = (d1 - param1Double2) / (this.maxPermits - this.thresholdPermits);
      if (param1Double1 == Double.POSITIVE_INFINITY) {
        this.storedPermits = 0.0D;
      } else {
        if (param1Double1 == 0.0D) {
          param1Double1 = this.maxPermits;
        } else {
          param1Double1 = this.storedPermits * this.maxPermits / param1Double1;
        } 
        this.storedPermits = param1Double1;
      } 
    }
    
    long storedPermitsToWaitTime(double param1Double1, double param1Double2) {
      long l;
      param1Double1 -= this.thresholdPermits;
      if (param1Double1 > 0.0D) {
        double d1 = Math.min(param1Double1, param1Double2);
        l = (long)((permitsToTime(param1Double1) + permitsToTime(param1Double1 - d1)) * d1 / 2.0D);
        param1Double2 -= d1;
      } else {
        l = 0L;
      } 
      param1Double1 = l;
      double d = this.stableIntervalMicros;
      Double.isNaN(param1Double1);
      return (long)(param1Double1 + d * param1Double2);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\SmoothRateLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */