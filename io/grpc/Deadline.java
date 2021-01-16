package io.grpc;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class Deadline implements Comparable<Deadline> {
  private static final long MAX_OFFSET;
  
  private static final long MIN_OFFSET;
  
  private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
  
  private final long deadlineNanos;
  
  private volatile boolean expired;
  
  private final Ticker ticker;
  
  static {
    MAX_OFFSET = TimeUnit.DAYS.toNanos(36500L);
    MIN_OFFSET = -MAX_OFFSET;
  }
  
  private Deadline(Ticker paramTicker, long paramLong1, long paramLong2, boolean paramBoolean) {
    this.ticker = paramTicker;
    paramLong2 = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, paramLong2));
    this.deadlineNanos = paramLong1 + paramLong2;
    if (paramBoolean && paramLong2 <= 0L) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    this.expired = paramBoolean;
  }
  
  private Deadline(Ticker paramTicker, long paramLong, boolean paramBoolean) {
    this(paramTicker, paramTicker.read(), paramLong, paramBoolean);
  }
  
  public static Deadline after(long paramLong, TimeUnit paramTimeUnit) {
    return after(paramLong, paramTimeUnit, SYSTEM_TICKER);
  }
  
  static Deadline after(long paramLong, TimeUnit paramTimeUnit, Ticker paramTicker) {
    checkNotNull(paramTimeUnit, "units");
    return new Deadline(paramTicker, paramTimeUnit.toNanos(paramLong), true);
  }
  
  private static <T> T checkNotNull(T paramT, Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public int compareTo(Deadline paramDeadline) {
    long l = this.deadlineNanos - paramDeadline.deadlineNanos;
    return (l < 0L) ? -1 : ((l > 0L) ? 1 : 0);
  }
  
  public boolean isBefore(Deadline paramDeadline) {
    boolean bool;
    if (this.deadlineNanos - paramDeadline.deadlineNanos < 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isExpired() {
    if (!this.expired)
      if (this.deadlineNanos - this.ticker.read() <= 0L) {
        this.expired = true;
      } else {
        return false;
      }  
    return true;
  }
  
  public Deadline minimum(Deadline paramDeadline) {
    Deadline deadline = paramDeadline;
    if (isBefore(paramDeadline))
      deadline = this; 
    return deadline;
  }
  
  public Deadline offset(long paramLong, TimeUnit paramTimeUnit) {
    return (paramLong == 0L) ? this : new Deadline(this.ticker, this.deadlineNanos, paramTimeUnit.toNanos(paramLong), isExpired());
  }
  
  public ScheduledFuture<?> runOnExpiration(Runnable paramRunnable, ScheduledExecutorService paramScheduledExecutorService) {
    checkNotNull(paramRunnable, "task");
    checkNotNull(paramScheduledExecutorService, "scheduler");
    return paramScheduledExecutorService.schedule(paramRunnable, this.deadlineNanos - this.ticker.read(), TimeUnit.NANOSECONDS);
  }
  
  public long timeRemaining(TimeUnit paramTimeUnit) {
    long l = this.ticker.read();
    if (!this.expired && this.deadlineNanos - l <= 0L)
      this.expired = true; 
    return paramTimeUnit.convert(this.deadlineNanos - l, TimeUnit.NANOSECONDS);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(timeRemaining(TimeUnit.NANOSECONDS));
    stringBuilder.append(" ns from now");
    return stringBuilder.toString();
  }
  
  private static class SystemTicker extends Ticker {
    private SystemTicker() {}
    
    public long read() {
      return System.nanoTime();
    }
  }
  
  static abstract class Ticker {
    public abstract long read();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Deadline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */