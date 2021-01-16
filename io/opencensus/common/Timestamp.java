package io.opencensus.common;

import com.google.common.math.LongMath;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Timestamp implements Comparable<Timestamp> {
  private static final Timestamp EPOCH = new AutoValue_Timestamp(0L, 0);
  
  public static Timestamp create(long paramLong, int paramInt) {
    return (paramLong < -315576000000L || paramLong > 315576000000L) ? EPOCH : ((paramInt < 0 || paramInt > 999999999) ? EPOCH : new AutoValue_Timestamp(paramLong, paramInt));
  }
  
  private static long floorDiv(long paramLong1, long paramLong2) {
    return LongMath.divide(paramLong1, paramLong2, RoundingMode.FLOOR);
  }
  
  private static long floorMod(long paramLong1, long paramLong2) {
    return paramLong1 - floorDiv(paramLong1, paramLong2) * paramLong2;
  }
  
  public static Timestamp fromMillis(long paramLong) {
    return create(floorDiv(paramLong, 1000L), (int)((int)floorMod(paramLong, 1000L) * 1000000L));
  }
  
  private static Timestamp ofEpochSecond(long paramLong1, long paramLong2) {
    return create(LongMath.checkedAdd(paramLong1, floorDiv(paramLong2, 1000000000L)), (int)floorMod(paramLong2, 1000000000L));
  }
  
  private Timestamp plus(long paramLong1, long paramLong2) {
    return ((paramLong1 | paramLong2) == 0L) ? this : ofEpochSecond(LongMath.checkedAdd(LongMath.checkedAdd(getSeconds(), paramLong1), paramLong2 / 1000000000L), getNanos() + paramLong2 % 1000000000L);
  }
  
  public Timestamp addDuration(Duration paramDuration) {
    return plus(paramDuration.getSeconds(), paramDuration.getNanos());
  }
  
  public Timestamp addNanos(long paramLong) {
    return plus(0L, paramLong);
  }
  
  public int compareTo(Timestamp paramTimestamp) {
    int i = Longs.compare(getSeconds(), paramTimestamp.getSeconds());
    return (i != 0) ? i : Longs.compare(getNanos(), paramTimestamp.getNanos());
  }
  
  public abstract int getNanos();
  
  public abstract long getSeconds();
  
  public Duration subtractTimestamp(Timestamp paramTimestamp) {
    long l2;
    int j;
    long l1 = getSeconds() - paramTimestamp.getSeconds();
    int i = getNanos() - paramTimestamp.getNanos();
    if (l1 < 0L && i > 0) {
      l2 = l1 + 1L;
      j = (int)(i - 1000000000L);
    } else {
      l2 = l1;
      j = i;
      if (l1 > 0L) {
        l2 = l1;
        j = i;
        if (i < 0) {
          l2 = l1 - 1L;
          j = (int)(i + 1000000000L);
        } 
      } 
    } 
    return Duration.create(l2, j);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\common\Timestamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */