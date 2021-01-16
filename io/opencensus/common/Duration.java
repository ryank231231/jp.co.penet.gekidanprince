package io.opencensus.common;

import com.google.common.primitives.Longs;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Duration implements Comparable<Duration> {
  private static final Duration ZERO = create(0L, 0);
  
  public static Duration create(long paramLong, int paramInt) {
    return (paramLong < -315576000000L || paramLong > 315576000000L) ? ZERO : ((paramInt < -999999999 || paramInt > 999999999) ? ZERO : (((paramLong < 0L && paramInt > 0) || (paramLong > 0L && paramInt < 0)) ? ZERO : new AutoValue_Duration(paramLong, paramInt)));
  }
  
  public static Duration fromMillis(long paramLong) {
    return create(paramLong / 1000L, (int)(paramLong % 1000L * 1000000L));
  }
  
  public int compareTo(Duration paramDuration) {
    int i = Longs.compare(getSeconds(), paramDuration.getSeconds());
    return (i != 0) ? i : Longs.compare(getNanos(), paramDuration.getNanos());
  }
  
  public abstract int getNanos();
  
  public abstract long getSeconds();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\common\Duration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */