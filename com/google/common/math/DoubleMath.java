package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated = true)
public final class DoubleMath {
  private static final double LN_2 = Math.log(2.0D);
  
  @VisibleForTesting
  static final int MAX_FACTORIAL = 170;
  
  private static final double MAX_INT_AS_DOUBLE = 2.147483647E9D;
  
  private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18D;
  
  private static final double MIN_INT_AS_DOUBLE = -2.147483648E9D;
  
  private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18D;
  
  @VisibleForTesting
  static final double[] everySixteenthFactorial = new double[] { 
      1.0D, 2.0922789888E13D, 2.631308369336935E35D, 1.2413915592536073E61D, 1.2688693218588417E89D, 7.156945704626381E118D, 9.916779348709496E149D, 1.974506857221074E182D, 3.856204823625804E215D, 5.5502938327393044E249D, 
      4.7147236359920616E284D };
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  private static double checkFinite(double paramDouble) {
    Preconditions.checkArgument(DoubleUtils.isFinite(paramDouble));
    return paramDouble;
  }
  
  public static double factorial(int paramInt) {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt > 170)
      return Double.POSITIVE_INFINITY; 
    double d = 1.0D;
    int i = paramInt & 0xFFFFFFF0;
    while (++i <= paramInt) {
      double d1 = i;
      Double.isNaN(d1);
      d *= d1;
    } 
    return d * everySixteenthFactorial[paramInt >> 4];
  }
  
  public static int fuzzyCompare(double paramDouble1, double paramDouble2, double paramDouble3) {
    return fuzzyEquals(paramDouble1, paramDouble2, paramDouble3) ? 0 : ((paramDouble1 < paramDouble2) ? -1 : ((paramDouble1 > paramDouble2) ? 1 : Booleans.compare(Double.isNaN(paramDouble1), Double.isNaN(paramDouble2))));
  }
  
  public static boolean fuzzyEquals(double paramDouble1, double paramDouble2, double paramDouble3) {
    MathPreconditions.checkNonNegative("tolerance", paramDouble3);
    return (Math.copySign(paramDouble1 - paramDouble2, 1.0D) <= paramDouble3 || paramDouble1 == paramDouble2 || (Double.isNaN(paramDouble1) && Double.isNaN(paramDouble2)));
  }
  
  @GwtIncompatible
  public static boolean isMathematicalInteger(double paramDouble) {
    boolean bool;
    if (DoubleUtils.isFinite(paramDouble) && (paramDouble == 0.0D || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(paramDouble)) <= Math.getExponent(paramDouble))) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @GwtIncompatible
  public static boolean isPowerOfTwo(double paramDouble) {
    boolean bool;
    if (paramDouble > 0.0D && DoubleUtils.isFinite(paramDouble) && LongMath.isPowerOfTwo(DoubleUtils.getSignificand(paramDouble))) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static double log2(double paramDouble) {
    return Math.log(paramDouble) / LN_2;
  }
  
  @GwtIncompatible
  public static int log2(double paramDouble, RoundingMode paramRoundingMode) {
    boolean bool2;
    boolean bool1 = false;
    byte b = 0;
    int i = 0;
    if (paramDouble > 0.0D && DoubleUtils.isFinite(paramDouble)) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "x must be positive and finite");
    int j = Math.getExponent(paramDouble);
    if (!DoubleUtils.isNormal(paramDouble))
      return log2(paramDouble * 4.503599627370496E15D, paramRoundingMode) - 52; 
    int k = b;
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_EVEN:
      case HALF_UP:
      case HALF_DOWN:
        paramDouble = DoubleUtils.scaleNormalize(paramDouble);
        k = b;
        if (paramDouble * paramDouble > 2.0D)
          k = 1; 
        break;
      case UP:
        k = i;
        if (j >= 0)
          k = 1; 
        k &= isPowerOfTwo(paramDouble) ^ true;
        break;
      case DOWN:
        k = bool1;
        if (j < 0)
          k = 1; 
        k &= isPowerOfTwo(paramDouble) ^ true;
        break;
      case CEILING:
        k = isPowerOfTwo(paramDouble) ^ true;
        break;
      case UNNECESSARY:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramDouble));
        k = b;
        break;
      case FLOOR:
        break;
    } 
    i = j;
    if (k != 0)
      i = j + 1; 
    return i;
  }
  
  @Deprecated
  @GwtIncompatible
  public static double mean(Iterable<? extends Number> paramIterable) {
    return mean(paramIterable.iterator());
  }
  
  @Deprecated
  @GwtIncompatible
  public static double mean(Iterator<? extends Number> paramIterator) {
    Preconditions.checkArgument(paramIterator.hasNext(), "Cannot take mean of 0 values");
    double d = checkFinite(((Number)paramIterator.next()).doubleValue());
    long l = 1L;
    while (paramIterator.hasNext()) {
      double d1 = checkFinite(((Number)paramIterator.next()).doubleValue());
      l++;
      double d2 = l;
      Double.isNaN(d2);
      d += (d1 - d) / d2;
    } 
    return d;
  }
  
  @Deprecated
  @GwtIncompatible
  public static double mean(double... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
    double d = checkFinite(paramVarArgs[0]);
    long l = 1L;
    while (b < paramVarArgs.length) {
      checkFinite(paramVarArgs[b]);
      l++;
      double d1 = paramVarArgs[b];
      double d2 = l;
      Double.isNaN(d2);
      d += (d1 - d) / d2;
      b++;
    } 
    return d;
  }
  
  @Deprecated
  public static double mean(int... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 0;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
    long l = 0L;
    while (b < paramVarArgs.length) {
      l += paramVarArgs[b];
      b++;
    } 
    double d1 = l;
    double d2 = paramVarArgs.length;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  @Deprecated
  public static double mean(long... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot take mean of 0 values");
    double d = paramVarArgs[0];
    long l = 1L;
    while (b < paramVarArgs.length) {
      l++;
      double d1 = paramVarArgs[b];
      Double.isNaN(d1);
      double d2 = l;
      Double.isNaN(d2);
      d += (d1 - d) / d2;
      b++;
    } 
    return d;
  }
  
  @GwtIncompatible
  static double roundIntermediate(double paramDouble, RoundingMode paramRoundingMode) {
    if (DoubleUtils.isFinite(paramDouble)) {
      double d;
      long l;
      byte b;
      switch (paramRoundingMode) {
        default:
          throw new AssertionError();
        case HALF_DOWN:
          d = Math.rint(paramDouble);
          return (Math.abs(paramDouble - d) == 0.5D) ? paramDouble : d;
        case HALF_UP:
          d = Math.rint(paramDouble);
          return (Math.abs(paramDouble - d) == 0.5D) ? (paramDouble + Math.copySign(0.5D, paramDouble)) : d;
        case HALF_EVEN:
          return Math.rint(paramDouble);
        case UP:
          if (isMathematicalInteger(paramDouble))
            return paramDouble; 
          l = (long)paramDouble;
          if (paramDouble > 0.0D) {
            b = 1;
          } else {
            b = -1;
          } 
          return (l + b);
        case DOWN:
          return paramDouble;
        case CEILING:
          return (paramDouble <= 0.0D || isMathematicalInteger(paramDouble)) ? paramDouble : ((long)paramDouble + 1L);
        case FLOOR:
          return (paramDouble >= 0.0D || isMathematicalInteger(paramDouble)) ? paramDouble : ((long)paramDouble - 1L);
        case UNNECESSARY:
          break;
      } 
      MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(paramDouble));
      return paramDouble;
    } 
    throw new ArithmeticException("input is infinite or NaN");
  }
  
  @GwtIncompatible
  public static BigInteger roundToBigInteger(double paramDouble, RoundingMode paramRoundingMode) {
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int i = 1;
    if (-9.223372036854776E18D - paramDouble < 1.0D) {
      j = 1;
    } else {
      j = 0;
    } 
    if (paramDouble >= 9.223372036854776E18D)
      i = 0; 
    if ((i & j) != 0)
      return BigInteger.valueOf((long)paramDouble); 
    int j = Math.getExponent(paramDouble);
    BigInteger bigInteger2 = BigInteger.valueOf(DoubleUtils.getSignificand(paramDouble)).shiftLeft(j - 52);
    BigInteger bigInteger1 = bigInteger2;
    if (paramDouble < 0.0D)
      bigInteger1 = bigInteger2.negate(); 
    return bigInteger1;
  }
  
  @GwtIncompatible
  public static int roundToInt(double paramDouble, RoundingMode paramRoundingMode) {
    boolean bool2;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    boolean bool1 = true;
    if (paramDouble > -2.147483649E9D) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramDouble >= 2.147483648E9D)
      bool1 = false; 
    MathPreconditions.checkInRange(bool1 & bool2);
    return (int)paramDouble;
  }
  
  @GwtIncompatible
  public static long roundToLong(double paramDouble, RoundingMode paramRoundingMode) {
    boolean bool2;
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    boolean bool1 = true;
    if (-9.223372036854776E18D - paramDouble < 1.0D) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramDouble >= 9.223372036854776E18D)
      bool1 = false; 
    MathPreconditions.checkInRange(bool1 & bool2);
    return (long)paramDouble;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\DoubleMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */