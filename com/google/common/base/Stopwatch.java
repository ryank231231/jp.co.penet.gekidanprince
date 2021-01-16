package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;

@GwtCompatible
public final class Stopwatch {
  private long elapsedNanos;
  
  private boolean isRunning;
  
  private long startTick;
  
  private final Ticker ticker = Ticker.systemTicker();
  
  Stopwatch() {}
  
  Stopwatch(Ticker paramTicker) {}
  
  private static String abbreviate(TimeUnit paramTimeUnit) {
    switch (paramTimeUnit) {
      default:
        throw new AssertionError();
      case DAYS:
        return "d";
      case HOURS:
        return "h";
      case MINUTES:
        return "min";
      case SECONDS:
        return "s";
      case MILLISECONDS:
        return "ms";
      case MICROSECONDS:
        return "μs";
      case NANOSECONDS:
        break;
    } 
    return "ns";
  }
  
  private static TimeUnit chooseUnit(long paramLong) {
    return (TimeUnit.DAYS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.DAYS : ((TimeUnit.HOURS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.HOURS : ((TimeUnit.MINUTES.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.MINUTES : ((TimeUnit.SECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.SECONDS : ((TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.MILLISECONDS : ((TimeUnit.MICROSECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS)))));
  }
  
  public static Stopwatch createStarted() {
    return (new Stopwatch()).start();
  }
  
  public static Stopwatch createStarted(Ticker paramTicker) {
    return (new Stopwatch(paramTicker)).start();
  }
  
  public static Stopwatch createUnstarted() {
    return new Stopwatch();
  }
  
  public static Stopwatch createUnstarted(Ticker paramTicker) {
    return new Stopwatch(paramTicker);
  }
  
  private long elapsedNanos() {
    long l;
    if (this.isRunning) {
      l = this.ticker.read() - this.startTick + this.elapsedNanos;
    } else {
      l = this.elapsedNanos;
    } 
    return l;
  }
  
  public long elapsed(TimeUnit paramTimeUnit) {
    return paramTimeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
  }
  
  public boolean isRunning() {
    return this.isRunning;
  }
  
  @CanIgnoreReturnValue
  public Stopwatch reset() {
    this.elapsedNanos = 0L;
    this.isRunning = false;
    return this;
  }
  
  @CanIgnoreReturnValue
  public Stopwatch start() {
    Preconditions.checkState(this.isRunning ^ true, "This stopwatch is already running.");
    this.isRunning = true;
    this.startTick = this.ticker.read();
    return this;
  }
  
  @CanIgnoreReturnValue
  public Stopwatch stop() {
    long l = this.ticker.read();
    Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
    this.isRunning = false;
    this.elapsedNanos += l - this.startTick;
    return this;
  }
  
  public String toString() {
    long l = elapsedNanos();
    TimeUnit timeUnit = chooseUnit(l);
    double d1 = l;
    double d2 = TimeUnit.NANOSECONDS.convert(1L, timeUnit);
    Double.isNaN(d1);
    Double.isNaN(d2);
    d2 = d1 / d2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Platform.formatCompact4Digits(d2));
    stringBuilder.append(" ");
    stringBuilder.append(abbreviate(timeUnit));
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Stopwatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */