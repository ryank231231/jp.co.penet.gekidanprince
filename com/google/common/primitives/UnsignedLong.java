package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
  public static final UnsignedLong MAX_VALUE;
  
  public static final UnsignedLong ONE;
  
  private static final long UNSIGNED_MASK = 9223372036854775807L;
  
  public static final UnsignedLong ZERO = new UnsignedLong(0L);
  
  private final long value;
  
  static {
    ONE = new UnsignedLong(1L);
    MAX_VALUE = new UnsignedLong(-1L);
  }
  
  private UnsignedLong(long paramLong) {
    this.value = paramLong;
  }
  
  public static UnsignedLong fromLongBits(long paramLong) {
    return new UnsignedLong(paramLong);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(long paramLong) {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned long value", paramLong);
    return fromLongBits(paramLong);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(String paramString) {
    return valueOf(paramString, 10);
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(String paramString, int paramInt) {
    return fromLongBits(UnsignedLongs.parseUnsignedLong(paramString, paramInt));
  }
  
  @CanIgnoreReturnValue
  public static UnsignedLong valueOf(BigInteger paramBigInteger) {
    boolean bool;
    Preconditions.checkNotNull(paramBigInteger);
    if (paramBigInteger.signum() >= 0 && paramBigInteger.bitLength() <= 64) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "value (%s) is outside the range for an unsigned long value", paramBigInteger);
    return fromLongBits(paramBigInteger.longValue());
  }
  
  public BigInteger bigIntegerValue() {
    BigInteger bigInteger1 = BigInteger.valueOf(this.value & Long.MAX_VALUE);
    BigInteger bigInteger2 = bigInteger1;
    if (this.value < 0L)
      bigInteger2 = bigInteger1.setBit(63); 
    return bigInteger2;
  }
  
  public int compareTo(UnsignedLong paramUnsignedLong) {
    Preconditions.checkNotNull(paramUnsignedLong);
    return UnsignedLongs.compare(this.value, paramUnsignedLong.value);
  }
  
  public UnsignedLong dividedBy(UnsignedLong paramUnsignedLong) {
    return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value));
  }
  
  public double doubleValue() {
    long l = this.value;
    double d1 = (Long.MAX_VALUE & l);
    double d2 = d1;
    if (l < 0L) {
      Double.isNaN(d1);
      d2 = d1 + 9.223372036854776E18D;
    } 
    return d2;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof UnsignedLong;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      if (this.value == ((UnsignedLong)paramObject).value)
        bool1 = true; 
      return bool1;
    } 
    return false;
  }
  
  public float floatValue() {
    long l = this.value;
    float f1 = (float)(Long.MAX_VALUE & l);
    float f2 = f1;
    if (l < 0L)
      f2 = f1 + 9.223372E18F; 
    return f2;
  }
  
  public int hashCode() {
    return Longs.hashCode(this.value);
  }
  
  public int intValue() {
    return (int)this.value;
  }
  
  public long longValue() {
    return this.value;
  }
  
  public UnsignedLong minus(UnsignedLong paramUnsignedLong) {
    return fromLongBits(this.value - ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value);
  }
  
  public UnsignedLong mod(UnsignedLong paramUnsignedLong) {
    return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value));
  }
  
  public UnsignedLong plus(UnsignedLong paramUnsignedLong) {
    return fromLongBits(this.value + ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value);
  }
  
  public UnsignedLong times(UnsignedLong paramUnsignedLong) {
    return fromLongBits(this.value * ((UnsignedLong)Preconditions.checkNotNull(paramUnsignedLong)).value);
  }
  
  public String toString() {
    return UnsignedLongs.toString(this.value);
  }
  
  public String toString(int paramInt) {
    return UnsignedLongs.toString(this.value, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\UnsignedLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */