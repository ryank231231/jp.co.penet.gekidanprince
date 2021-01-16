package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible
@CanIgnoreReturnValue
final class MathPreconditions {
  static void checkInRange(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new ArithmeticException("not in range");
  }
  
  static void checkNoOverflow(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new ArithmeticException("overflow");
  }
  
  static double checkNonNegative(@Nullable String paramString, double paramDouble) {
    if (paramDouble >= 0.0D)
      return paramDouble; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramDouble);
    stringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static int checkNonNegative(@Nullable String paramString, int paramInt) {
    if (paramInt >= 0)
      return paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramInt);
    stringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static long checkNonNegative(@Nullable String paramString, long paramLong) {
    if (paramLong >= 0L)
      return paramLong; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramLong);
    stringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static BigInteger checkNonNegative(@Nullable String paramString, BigInteger paramBigInteger) {
    if (paramBigInteger.signum() >= 0)
      return paramBigInteger; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramBigInteger);
    stringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static int checkPositive(@Nullable String paramString, int paramInt) {
    if (paramInt > 0)
      return paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramInt);
    stringBuilder.append(") must be > 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static long checkPositive(@Nullable String paramString, long paramLong) {
    if (paramLong > 0L)
      return paramLong; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramLong);
    stringBuilder.append(") must be > 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static BigInteger checkPositive(@Nullable String paramString, BigInteger paramBigInteger) {
    if (paramBigInteger.signum() > 0)
      return paramBigInteger; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramBigInteger);
    stringBuilder.append(") must be > 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static void checkRoundingUnnecessary(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\MathPreconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */