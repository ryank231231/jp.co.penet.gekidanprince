package io.opencensus.common;

public abstract class Clock {
  public abstract Timestamp now();
  
  public abstract long nowNanos();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\common\Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */