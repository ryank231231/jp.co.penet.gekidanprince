package io.opencensus.internal;

import io.opencensus.common.Clock;
import io.opencensus.common.Timestamp;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class ZeroTimeClock extends Clock {
  private static final ZeroTimeClock INSTANCE = new ZeroTimeClock();
  
  private static final Timestamp ZERO_TIMESTAMP = Timestamp.create(0L, 0);
  
  public static ZeroTimeClock getInstance() {
    return INSTANCE;
  }
  
  public Timestamp now() {
    return ZERO_TIMESTAMP;
  }
  
  public long nowNanos() {
    return 0L;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\internal\ZeroTimeClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */