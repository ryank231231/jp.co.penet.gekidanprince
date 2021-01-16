package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Random;
import java.util.concurrent.TimeUnit;

final class ExponentialBackoffPolicy implements BackoffPolicy {
  private long initialBackoffNanos = TimeUnit.SECONDS.toNanos(1L);
  
  private double jitter = 0.2D;
  
  private long maxBackoffNanos = TimeUnit.MINUTES.toNanos(2L);
  
  private double multiplier = 1.6D;
  
  private long nextBackoffNanos = this.initialBackoffNanos;
  
  private Random random = new Random();
  
  private long uniformRandom(double paramDouble1, double paramDouble2) {
    boolean bool;
    if (paramDouble2 >= paramDouble1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return (long)(this.random.nextDouble() * (paramDouble2 - paramDouble1) + paramDouble1);
  }
  
  public long nextBackoffNanos() {
    long l = this.nextBackoffNanos;
    double d1 = l;
    double d2 = this.multiplier;
    Double.isNaN(d1);
    this.nextBackoffNanos = Math.min((long)(d2 * d1), this.maxBackoffNanos);
    d2 = this.jitter;
    double d3 = -d2;
    Double.isNaN(d1);
    Double.isNaN(d1);
    return l + uniformRandom(d3 * d1, d2 * d1);
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setInitialBackoffNanos(long paramLong) {
    this.initialBackoffNanos = paramLong;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setJitter(double paramDouble) {
    this.jitter = paramDouble;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setMaxBackoffNanos(long paramLong) {
    this.maxBackoffNanos = paramLong;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setMultiplier(double paramDouble) {
    this.multiplier = paramDouble;
    return this;
  }
  
  @VisibleForTesting
  ExponentialBackoffPolicy setRandom(Random paramRandom) {
    this.random = paramRandom;
    return this;
  }
  
  static final class Provider implements BackoffPolicy.Provider {
    public BackoffPolicy get() {
      return new ExponentialBackoffPolicy();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ExponentialBackoffPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */