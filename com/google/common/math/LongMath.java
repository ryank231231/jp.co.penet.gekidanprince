package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
public final class LongMath {
  @VisibleForTesting
  static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
  
  @VisibleForTesting
  static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
  
  @VisibleForTesting
  static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
  
  private static final int SIEVE_30 = -545925251;
  
  static final int[] biggestBinomials;
  
  @VisibleForTesting
  static final int[] biggestSimpleBinomials;
  
  static final long[] factorials;
  
  @GwtIncompatible
  @VisibleForTesting
  static final long[] halfPowersOf10;
  
  @VisibleForTesting
  static final byte[] maxLog10ForLeadingZeros = new byte[] { 
      19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 
      16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 
      13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 
      10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 
      7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 
      4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 
      1, 0, 0, 0 };
  
  private static final long[][] millerRabinBaseSets;
  
  @GwtIncompatible
  @VisibleForTesting
  static final long[] powersOf10 = new long[] { 
      1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 
      10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
  
  static {
    halfPowersOf10 = new long[] { 
        3L, 31L, 316L, 3162L, 31622L, 316227L, 3162277L, 31622776L, 316227766L, 3162277660L, 
        31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L };
    factorials = new long[] { 
        1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 
        3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 
        2432902008176640000L };
    biggestBinomials = new int[] { 
        Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 
        361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 
        83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 
        66, 66, 66, 66 };
    biggestSimpleBinomials = new int[] { 
        Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 
        287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 
        73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 
        61 };
    millerRabinBaseSets = new long[][] { { 291830L, 126401071349994536L }, { 885594168L, 725270293939359937L, 3569819667048198375L }, { 273919523040L, 15L, 7363882082L, 992620450144556L }, { 47636622961200L, 2L, 2570940L, 211991001L, 3749873356L }, { 7999252175582850L, 2L, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L }, { 585226005592931976L, 2L, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L }, { Long.MAX_VALUE, 2L, 325L, 9375L, 28178L, 450775L, 9780504L, 1795265022L } };
  }
  
  public static long binomial(int paramInt1, int paramInt2) {
    boolean bool;
    long[] arrayOfLong;
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    if (paramInt2 <= paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "k (%s) > n (%s)", paramInt2, paramInt1);
    int i = paramInt2;
    if (paramInt2 > paramInt1 >> 1)
      i = paramInt1 - paramInt2; 
    switch (i) {
      default:
        arrayOfLong = factorials;
        if (paramInt1 < arrayOfLong.length)
          return arrayOfLong[paramInt1] / arrayOfLong[i] * arrayOfLong[paramInt1 - i]; 
        break;
      case 1:
        return paramInt1;
      case 0:
        return 1L;
    } 
    int[] arrayOfInt = biggestBinomials;
    if (i >= arrayOfInt.length || paramInt1 > arrayOfInt[i])
      return Long.MAX_VALUE; 
    arrayOfInt = biggestSimpleBinomials;
    paramInt2 = arrayOfInt.length;
    byte b = 2;
    if (i < paramInt2 && paramInt1 <= arrayOfInt[i]) {
      paramInt2 = paramInt1 - 1;
      long l = paramInt1;
      paramInt1 = paramInt2;
      while (b <= i) {
        l = l * paramInt1 / b;
        paramInt1--;
        b++;
      } 
      return l;
    } 
    long l2 = paramInt1;
    paramInt2 = log2(l2, RoundingMode.CEILING);
    long l3 = 1L;
    long l1 = l3;
    int j = paramInt1 - 1;
    paramInt1 = paramInt2;
    while (b <= i) {
      paramInt1 += paramInt2;
      if (paramInt1 < 63) {
        l2 *= j;
        l1 *= b;
      } else {
        l3 = multiplyFraction(l3, l2, l1);
        l2 = j;
        l1 = b;
        paramInt1 = paramInt2;
      } 
      b++;
      j--;
    } 
    return multiplyFraction(l3, l2, l1);
  }
  
  @Beta
  public static long ceilingPowerOfTwo(long paramLong) {
    MathPreconditions.checkPositive("x", paramLong);
    if (paramLong <= 4611686018427387904L)
      return 1L << -Long.numberOfLeadingZeros(paramLong - 1L); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ceilingPowerOfTwo(");
    stringBuilder.append(paramLong);
    stringBuilder.append(") is not representable as a long");
    throw new ArithmeticException(stringBuilder.toString());
  }
  
  @GwtIncompatible
  public static long checkedAdd(long paramLong1, long paramLong2) {
    boolean bool2;
    long l = paramLong1 + paramLong2;
    boolean bool1 = true;
    if ((paramLong2 ^ paramLong1) < 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramLong1 ^ l) < 0L)
      bool1 = false; 
    MathPreconditions.checkNoOverflow(bool2 | bool1);
    return l;
  }
  
  @GwtIncompatible
  public static long checkedMultiply(long paramLong1, long paramLong2) {
    byte b;
    int i = Long.numberOfLeadingZeros(paramLong1) + Long.numberOfLeadingZeros(paramLong1 ^ 0xFFFFFFFFFFFFFFFFL) + Long.numberOfLeadingZeros(paramLong2) + Long.numberOfLeadingZeros(0xFFFFFFFFFFFFFFFFL ^ paramLong2);
    if (i > 65)
      return paramLong1 * paramLong2; 
    boolean bool1 = true;
    if (i >= 64) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    MathPreconditions.checkNoOverflow(bool2);
    if (paramLong1 >= 0L) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramLong2 != Long.MIN_VALUE) {
      b = 1;
    } else {
      b = 0;
    } 
    MathPreconditions.checkNoOverflow(i | b);
    long l = paramLong1 * paramLong2;
    boolean bool2 = bool1;
    if (paramLong1 != 0L)
      if (l / paramLong1 == paramLong2) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    MathPreconditions.checkNoOverflow(bool2);
    return l;
  }
  
  @GwtIncompatible
  public static long checkedPow(long paramLong, int paramInt) {
    boolean bool3;
    boolean bool4;
    MathPreconditions.checkNonNegative("exponent", paramInt);
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramLong >= -2L) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramLong <= 2L) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    long l1 = 1L;
    long l2 = l1;
    long l3 = paramLong;
    int i = paramInt;
    if ((bool3 & bool4) != 0) {
      switch ((int)paramLong) {
        default:
          throw new AssertionError();
        case 2:
          if (paramInt < 63)
            bool2 = true; 
          MathPreconditions.checkNoOverflow(bool2);
          return 1L << paramInt;
        case 1:
          return 1L;
        case 0:
          if (paramInt != 0)
            l1 = 0L; 
          return l1;
        case -1:
          if ((paramInt & 0x1) != 0)
            l1 = -1L; 
          return l1;
        case -2:
          break;
      } 
      bool2 = bool1;
      if (paramInt < 64)
        bool2 = true; 
      MathPreconditions.checkNoOverflow(bool2);
      if ((paramInt & 0x1) == 0) {
        paramLong = 1L << paramInt;
      } else {
        paramLong = -1L << paramInt;
      } 
      return paramLong;
    } 
    while (true) {
      switch (i) {
        default:
          paramLong = l2;
          if ((i & 0x1) != 0)
            paramLong = checkedMultiply(l2, l3); 
          break;
        case 1:
          return checkedMultiply(l2, l3);
        case 0:
          return l2;
      } 
      paramInt = i >> 1;
      l2 = paramLong;
      i = paramInt;
      if (paramInt > 0) {
        if (-3037000499L <= l3 && l3 <= 3037000499L) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        MathPreconditions.checkNoOverflow(bool2);
        l3 *= l3;
        l2 = paramLong;
        i = paramInt;
      } 
    } 
  }
  
  @GwtIncompatible
  public static long checkedSubtract(long paramLong1, long paramLong2) {
    boolean bool2;
    long l = paramLong1 - paramLong2;
    boolean bool1 = true;
    if ((paramLong2 ^ paramLong1) >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramLong1 ^ l) < 0L)
      bool1 = false; 
    MathPreconditions.checkNoOverflow(bool2 | bool1);
    return l;
  }
  
  @GwtIncompatible
  public static long divide(long paramLong1, long paramLong2, RoundingMode paramRoundingMode) {
    Preconditions.checkNotNull(paramRoundingMode);
    long l1 = paramLong1 / paramLong2;
    long l2 = paramLong1 - paramLong2 * l1;
    if (l2 == 0L)
      return l1; 
    int i = (int)((paramLong1 ^ paramLong2) >> 63L);
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    int j = i | 0x1;
    i = bool2;
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        paramLong1 = Math.abs(l2);
        paramLong1 -= Math.abs(paramLong2) - paramLong1;
        if (paramLong1 == 0L) {
          if (paramRoundingMode == RoundingMode.HALF_UP) {
            i = 1;
          } else {
            i = 0;
          } 
          if (paramRoundingMode == RoundingMode.HALF_EVEN) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          if ((0x1L & l1) == 0L)
            bool3 = false; 
          i = bool3 & bool2 | i;
          break;
        } 
        if (paramLong1 > 0L) {
          i = bool2;
          break;
        } 
        i = 0;
        break;
      case CEILING:
        if (j > 0) {
          i = bool2;
          break;
        } 
        i = 0;
        break;
      case FLOOR:
        if (j < 0) {
          i = bool2;
          break;
        } 
        i = 0;
        break;
      case UNNECESSARY:
        if (l2 != 0L)
          bool1 = false; 
        MathPreconditions.checkRoundingUnnecessary(bool1);
      case DOWN:
        i = 0;
        break;
      case UP:
        break;
    } 
    paramLong1 = l1;
    if (i != 0)
      paramLong1 = l1 + j; 
    return paramLong1;
  }
  
  @GwtIncompatible
  public static long factorial(int paramInt) {
    long l;
    MathPreconditions.checkNonNegative("n", paramInt);
    long[] arrayOfLong = factorials;
    if (paramInt < arrayOfLong.length) {
      l = arrayOfLong[paramInt];
    } else {
      l = Long.MAX_VALUE;
    } 
    return l;
  }
  
  static boolean fitsInInt(long paramLong) {
    boolean bool;
    if ((int)paramLong == paramLong) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Beta
  public static long floorPowerOfTwo(long paramLong) {
    MathPreconditions.checkPositive("x", paramLong);
    return 1L << 63 - Long.numberOfLeadingZeros(paramLong);
  }
  
  public static long gcd(long paramLong1, long paramLong2) {
    MathPreconditions.checkNonNegative("a", paramLong1);
    MathPreconditions.checkNonNegative("b", paramLong2);
    if (paramLong1 == 0L)
      return paramLong2; 
    if (paramLong2 == 0L)
      return paramLong1; 
    int i = Long.numberOfTrailingZeros(paramLong1);
    long l = paramLong1 >> i;
    int j = Long.numberOfTrailingZeros(paramLong2);
    paramLong1 = paramLong2 >> j;
    for (paramLong2 = l; paramLong2 != paramLong1; paramLong2 >>= Long.numberOfTrailingZeros(paramLong2)) {
      paramLong2 -= paramLong1;
      l = paramLong2 >> 63L & paramLong2;
      paramLong2 = paramLong2 - l - l;
      paramLong1 += l;
    } 
    return paramLong2 << Math.min(i, j);
  }
  
  public static boolean isPowerOfTwo(long paramLong) {
    boolean bool2;
    boolean bool1 = true;
    if (paramLong > 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramLong & paramLong - 1L) != 0L)
      bool1 = false; 
    return bool2 & bool1;
  }
  
  @Beta
  @GwtIncompatible
  public static boolean isPrime(long paramLong) {
    if (paramLong < 2L) {
      MathPreconditions.checkNonNegative("n", paramLong);
      return false;
    } 
    if (paramLong == 2L || paramLong == 3L || paramLong == 5L || paramLong == 7L || paramLong == 11L || paramLong == 13L)
      return true; 
    if ((0xDF75D77D & 1 << (int)(paramLong % 30L)) != 0)
      return false; 
    if (paramLong % 7L == 0L || paramLong % 11L == 0L || paramLong % 13L == 0L)
      return false; 
    if (paramLong < 289L)
      return true; 
    for (long[] arrayOfLong : millerRabinBaseSets) {
      if (paramLong <= arrayOfLong[0]) {
        for (null = 1; null < arrayOfLong.length; null++) {
          if (!MillerRabinTester.test(arrayOfLong[null], paramLong))
            return false; 
        } 
        return true;
      } 
    } 
    throw new AssertionError();
  }
  
  @VisibleForTesting
  static int lessThanBranchFree(long paramLong1, long paramLong2) {
    return (int)((paramLong1 - paramLong2 ^ 0xFFFFFFFFFFFFFFFFL ^ 0xFFFFFFFFFFFFFFFFL) >>> 63L);
  }
  
  @GwtIncompatible
  public static int log10(long paramLong, RoundingMode paramRoundingMode) {
    boolean bool;
    MathPreconditions.checkPositive("x", paramLong);
    int i = log10Floor(paramLong);
    long l = powersOf10[i];
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        return i + lessThanBranchFree(halfPowersOf10[i], paramLong);
      case UP:
      case CEILING:
        return i + lessThanBranchFree(l, paramLong);
      case UNNECESSARY:
        if (paramLong == l) {
          bool = true;
        } else {
          bool = false;
        } 
        MathPreconditions.checkRoundingUnnecessary(bool);
        break;
      case DOWN:
      case FLOOR:
        break;
    } 
    return i;
  }
  
  @GwtIncompatible
  static int log10Floor(long paramLong) {
    byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(paramLong)];
    return b - lessThanBranchFree(paramLong, powersOf10[b]);
  }
  
  public static int log2(long paramLong, RoundingMode paramRoundingMode) {
    int i;
    MathPreconditions.checkPositive("x", paramLong);
    switch (paramRoundingMode) {
      default:
        throw new AssertionError("impossible");
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        i = Long.numberOfLeadingZeros(paramLong);
        return 63 - i + lessThanBranchFree(-5402926248376769404L >>> i, paramLong);
      case UP:
      case CEILING:
        return 64 - Long.numberOfLeadingZeros(paramLong - 1L);
      case UNNECESSARY:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramLong));
        break;
      case DOWN:
      case FLOOR:
        break;
    } 
    return 63 - Long.numberOfLeadingZeros(paramLong);
  }
  
  public static long mean(long paramLong1, long paramLong2) {
    return (paramLong1 & paramLong2) + ((paramLong1 ^ paramLong2) >> 1L);
  }
  
  @GwtIncompatible
  public static int mod(long paramLong, int paramInt) {
    return (int)mod(paramLong, paramInt);
  }
  
  @GwtIncompatible
  public static long mod(long paramLong1, long paramLong2) {
    if (paramLong2 > 0L) {
      paramLong1 %= paramLong2;
      if (paramLong1 < 0L)
        paramLong1 += paramLong2; 
      return paramLong1;
    } 
    throw new ArithmeticException("Modulus must be positive");
  }
  
  static long multiplyFraction(long paramLong1, long paramLong2, long paramLong3) {
    if (paramLong1 == 1L)
      return paramLong2 / paramLong3; 
    long l = gcd(paramLong1, paramLong3);
    return paramLong1 / l * paramLong2 / paramLong3 / l;
  }
  
  @GwtIncompatible
  public static long pow(long paramLong, int paramInt) {
    MathPreconditions.checkNonNegative("exponent", paramInt);
    long l = 1L;
    if (-2L <= paramLong && paramLong <= 2L) {
      int i = (int)paramLong;
      paramLong = 0L;
      switch (i) {
        default:
          throw new AssertionError();
        case 2:
          if (paramInt < 64)
            paramLong = 1L << paramInt; 
          return paramLong;
        case 1:
          return 1L;
        case 0:
          if (paramInt != 0)
            l = 0L; 
          return l;
        case -1:
          if ((paramInt & 0x1) != 0)
            l = -1L; 
          return l;
        case -2:
          break;
      } 
      if (paramInt < 64) {
        if ((paramInt & 0x1) == 0) {
          paramLong = 1L << paramInt;
        } else {
          paramLong = -(1L << paramInt);
        } 
        return paramLong;
      } 
      return 0L;
    } 
    l = 1L;
    while (true) {
      long l1;
      switch (paramInt) {
        default:
          if ((paramInt & 0x1) == 0) {
            long l2 = 1L;
            break;
          } 
          l1 = paramLong;
          l *= l1;
          paramLong *= paramLong;
          paramInt >>= 1;
          continue;
        case 1:
          return l * paramLong;
        case 0:
          return l;
      } 
      l *= l1;
      paramLong *= paramLong;
      paramInt >>= 1;
    } 
  }
  
  @Beta
  public static long saturatedAdd(long paramLong1, long paramLong2) {
    boolean bool2;
    long l = paramLong1 + paramLong2;
    boolean bool1 = true;
    if ((paramLong2 ^ paramLong1) < 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramLong1 ^ l) < 0L)
      bool1 = false; 
    return ((bool2 | bool1) != 0) ? l : ((l >>> 63L ^ 0x1L) + Long.MAX_VALUE);
  }
  
  @Beta
  public static long saturatedMultiply(long paramLong1, long paramLong2) {
    boolean bool2;
    int i = Long.numberOfLeadingZeros(paramLong1) + Long.numberOfLeadingZeros(paramLong1 ^ 0xFFFFFFFFFFFFFFFFL) + Long.numberOfLeadingZeros(paramLong2) + Long.numberOfLeadingZeros(0xFFFFFFFFFFFFFFFFL ^ paramLong2);
    if (i > 65)
      return paramLong1 * paramLong2; 
    long l1 = ((paramLong1 ^ paramLong2) >>> 63L) + Long.MAX_VALUE;
    boolean bool1 = true;
    if (i < 64) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramLong1 < 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramLong2 != Long.MIN_VALUE)
      bool1 = false; 
    if ((i | bool2 & bool1) != 0)
      return l1; 
    long l2 = paramLong1 * paramLong2;
    return (paramLong1 == 0L || l2 / paramLong1 == paramLong2) ? l2 : l1;
  }
  
  @Beta
  public static long saturatedPow(long paramLong, int paramInt) {
    int i;
    int j;
    MathPreconditions.checkNonNegative("exponent", paramInt);
    if (paramLong >= -2L) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramLong <= 2L) {
      j = 1;
    } else {
      j = 0;
    } 
    long l1 = 1L;
    if ((i & j) != 0) {
      switch ((int)paramLong) {
        default:
          throw new AssertionError();
        case 2:
          return (paramInt >= 63) ? Long.MAX_VALUE : (1L << paramInt);
        case 1:
          return 1L;
        case 0:
          if (paramInt != 0)
            l1 = 0L; 
          return l1;
        case -1:
          if ((paramInt & 0x1) != 0)
            l1 = -1L; 
          return l1;
        case -2:
          break;
      } 
      if (paramInt >= 64)
        return (paramInt & 0x1) + Long.MAX_VALUE; 
      if ((paramInt & 0x1) == 0) {
        paramLong = 1L << paramInt;
      } else {
        paramLong = -1L << paramInt;
      } 
      return paramLong;
    } 
    long l2 = (paramInt & 0x1);
    long l3 = paramLong;
    long l4 = l1;
    while (true) {
      long l = l3;
      switch (paramInt) {
        default:
          l1 = l4;
          if ((paramInt & 0x1) != 0)
            l1 = saturatedMultiply(l4, l); 
          break;
        case 1:
          return saturatedMultiply(l4, l);
        case 0:
          return l4;
      } 
      j = paramInt >> 1;
      l4 = l1;
      l3 = l;
      paramInt = j;
      if (j > 0) {
        if (-3037000499L > l) {
          paramInt = 1;
        } else {
          paramInt = 0;
        } 
        if (l > 3037000499L) {
          i = 1;
        } else {
          i = 0;
        } 
        if ((paramInt | i) != 0)
          return (paramLong >>> 63L & l2) + Long.MAX_VALUE; 
        l3 = l * l;
        l4 = l1;
        paramInt = j;
      } 
    } 
  }
  
  @Beta
  public static long saturatedSubtract(long paramLong1, long paramLong2) {
    boolean bool2;
    long l = paramLong1 - paramLong2;
    boolean bool1 = true;
    if ((paramLong2 ^ paramLong1) >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramLong1 ^ l) < 0L)
      bool1 = false; 
    return ((bool2 | bool1) != 0) ? l : ((l >>> 63L ^ 0x1L) + Long.MAX_VALUE);
  }
  
  @GwtIncompatible
  public static long sqrt(long paramLong, RoundingMode paramRoundingMode) {
    MathPreconditions.checkNonNegative("x", paramLong);
    if (fitsInInt(paramLong))
      return IntMath.sqrt((int)paramLong, paramRoundingMode); 
    long l1 = (long)Math.sqrt(paramLong);
    long l2 = l1 * l1;
    int i = null.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()];
    boolean bool1 = true;
    boolean bool2 = true;
    switch (i) {
      default:
        throw new AssertionError();
      case 6:
      case 7:
      case 8:
        if (paramLong >= l2)
          bool2 = false; 
        l1 -= bool2;
        return l1 + lessThanBranchFree(l1 * l1 + l1, paramLong);
      case 4:
      case 5:
        return (paramLong > l2) ? (l1 + 1L) : l1;
      case 2:
      case 3:
        return (paramLong < l2) ? (l1 - 1L) : l1;
      case 1:
        break;
    } 
    if (l2 != paramLong)
      bool1 = false; 
    MathPreconditions.checkRoundingUnnecessary(bool1);
    return l1;
  }
  
  private enum MillerRabinTester {
    LARGE,
    SMALL {
      long mulMod(long param2Long1, long param2Long2, long param2Long3) {
        return param2Long1 * param2Long2 % param2Long3;
      }
      
      long squareMod(long param2Long1, long param2Long2) {
        return param2Long1 * param2Long1 % param2Long2;
      }
    };
    
    static {
      $VALUES = new MillerRabinTester[] { SMALL, LARGE };
    }
    
    private long powMod(long param1Long1, long param1Long2, long param1Long3) {
      long l;
      for (l = 1L; param1Long2 != 0L; l = l1) {
        long l1 = l;
        if ((param1Long2 & 0x1L) != 0L)
          l1 = mulMod(l, param1Long1, param1Long3); 
        param1Long1 = squareMod(param1Long1, param1Long3);
        param1Long2 >>= 1L;
      } 
      return l;
    }
    
    static boolean test(long param1Long1, long param1Long2) {
      MillerRabinTester millerRabinTester;
      if (param1Long2 <= 3037000499L) {
        millerRabinTester = SMALL;
      } else {
        millerRabinTester = LARGE;
      } 
      return millerRabinTester.testWitness(param1Long1, param1Long2);
    }
    
    private boolean testWitness(long param1Long1, long param1Long2) {
      long l = param1Long2 - 1L;
      int i = Long.numberOfTrailingZeros(l);
      param1Long1 %= param1Long2;
      if (param1Long1 == 0L)
        return true; 
      param1Long1 = powMod(param1Long1, l >> i, param1Long2);
      if (param1Long1 == 1L)
        return true; 
      byte b = 0;
      while (param1Long1 != l) {
        if (++b == i)
          return false; 
        param1Long1 = squareMod(param1Long1, param1Long2);
      } 
      return true;
    }
    
    abstract long mulMod(long param1Long1, long param1Long2, long param1Long3);
    
    abstract long squareMod(long param1Long1, long param1Long2);
  }
  
  enum null {
    long mulMod(long param1Long1, long param1Long2, long param1Long3) {
      return param1Long1 * param1Long2 % param1Long3;
    }
    
    long squareMod(long param1Long1, long param1Long2) {
      return param1Long1 * param1Long1 % param1Long2;
    }
  }
  
  enum null {
    private long plusMod(long param1Long1, long param1Long2, long param1Long3) {
      if (param1Long1 >= param1Long3 - param1Long2) {
        param1Long1 = param1Long1 + param1Long2 - param1Long3;
      } else {
        param1Long1 += param1Long2;
      } 
      return param1Long1;
    }
    
    private long times2ToThe32Mod(long param1Long1, long param1Long2) {
      int i = 32;
      while (true) {
        int j = Math.min(i, Long.numberOfLeadingZeros(param1Long1));
        long l = UnsignedLongs.remainder(param1Long1 << j, param1Long2);
        j = i - j;
        i = j;
        param1Long1 = l;
        if (j <= 0)
          return l; 
      } 
    }
    
    long mulMod(long param1Long1, long param1Long2, long param1Long3) {
      long l1 = param1Long1 >>> 32L;
      long l2 = param1Long2 >>> 32L;
      long l3 = param1Long1 & 0xFFFFFFFFL;
      long l4 = param1Long2 & 0xFFFFFFFFL;
      param1Long2 = times2ToThe32Mod(l1 * l2, param1Long3) + l1 * l4;
      param1Long1 = param1Long2;
      if (param1Long2 < 0L)
        param1Long1 = UnsignedLongs.remainder(param1Long2, param1Long3); 
      Long.signum(l3);
      return plusMod(times2ToThe32Mod(param1Long1 + l2 * l3, param1Long3), UnsignedLongs.remainder(l3 * l4, param1Long3), param1Long3);
    }
    
    long squareMod(long param1Long1, long param1Long2) {
      long l1 = param1Long1 >>> 32L;
      long l2 = param1Long1 & 0xFFFFFFFFL;
      long l3 = times2ToThe32Mod(l1 * l1, param1Long2);
      l1 = l1 * l2 * 2L;
      param1Long1 = l1;
      if (l1 < 0L)
        param1Long1 = UnsignedLongs.remainder(l1, param1Long2); 
      return plusMod(times2ToThe32Mod(l3 + param1Long1, param1Long2), UnsignedLongs.remainder(l2 * l2, param1Long2), param1Long2);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\LongMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */