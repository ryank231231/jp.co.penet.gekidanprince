package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
public final class IntMath {
  @VisibleForTesting
  static final int FLOOR_SQRT_MAX_INT = 46340;
  
  @VisibleForTesting
  static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
  
  @VisibleForTesting
  static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
  
  @VisibleForTesting
  static int[] biggestBinomials;
  
  private static final int[] factorials;
  
  @VisibleForTesting
  static final int[] halfPowersOf10;
  
  @VisibleForTesting
  static final byte[] maxLog10ForLeadingZeros = new byte[] { 
      9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 
      6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 
      3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 
      0, 0, 0 };
  
  @VisibleForTesting
  static final int[] powersOf10 = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  
  static {
    halfPowersOf10 = new int[] { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
    factorials = new int[] { 
        1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 
        3628800, 39916800, 479001600 };
    biggestBinomials = new int[] { 
        Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 
        43, 39, 37, 35, 34, 34, 33 };
  }
  
  @GwtIncompatible
  public static int binomial(int paramInt1, int paramInt2) {
    boolean bool2;
    long l;
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    boolean bool1 = false;
    if (paramInt2 <= paramInt1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "k (%s) > n (%s)", paramInt2, paramInt1);
    int i = paramInt2;
    if (paramInt2 > paramInt1 >> 1)
      i = paramInt1 - paramInt2; 
    int[] arrayOfInt = biggestBinomials;
    if (i >= arrayOfInt.length || paramInt1 > arrayOfInt[i])
      return Integer.MAX_VALUE; 
    switch (i) {
      default:
        l = 1L;
        paramInt2 = bool1;
        break;
      case 1:
        return paramInt1;
      case 0:
        return 1;
    } 
    while (paramInt2 < i) {
      long l1 = (paramInt1 - paramInt2);
      l = l * l1 / ++paramInt2;
    } 
    return (int)l;
  }
  
  @Beta
  public static int ceilingPowerOfTwo(int paramInt) {
    MathPreconditions.checkPositive("x", paramInt);
    if (paramInt <= 1073741824)
      return 1 << -Integer.numberOfLeadingZeros(paramInt - 1); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ceilingPowerOfTwo(");
    stringBuilder.append(paramInt);
    stringBuilder.append(") not representable as an int");
    throw new ArithmeticException(stringBuilder.toString());
  }
  
  public static int checkedAdd(int paramInt1, int paramInt2) {
    boolean bool;
    long l = paramInt1 + paramInt2;
    paramInt1 = (int)l;
    if (l == paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    MathPreconditions.checkNoOverflow(bool);
    return paramInt1;
  }
  
  public static int checkedMultiply(int paramInt1, int paramInt2) {
    boolean bool;
    long l = paramInt1 * paramInt2;
    paramInt1 = (int)l;
    if (l == paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    MathPreconditions.checkNoOverflow(bool);
    return paramInt1;
  }
  
  public static int checkedPow(int paramInt1, int paramInt2) {
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    int i = -1;
    int j = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    switch (paramInt1) {
      default:
        i = 1;
        j = paramInt2;
        break;
      case 2:
        if (paramInt2 < 31)
          bool2 = true; 
        MathPreconditions.checkNoOverflow(bool2);
        return 1 << paramInt2;
      case 1:
        return 1;
      case 0:
        paramInt1 = j;
        if (paramInt2 == 0)
          paramInt1 = 1; 
        return paramInt1;
      case -1:
        paramInt1 = i;
        if ((paramInt2 & 0x1) == 0)
          paramInt1 = 1; 
        return paramInt1;
      case -2:
        bool2 = bool1;
        if (paramInt2 < 32)
          bool2 = true; 
        MathPreconditions.checkNoOverflow(bool2);
        if ((paramInt2 & 0x1) == 0) {
          paramInt1 = 1 << paramInt2;
        } else {
          paramInt1 = -1 << paramInt2;
        } 
        return paramInt1;
    } 
    while (true) {
      switch (j) {
        default:
          paramInt2 = i;
          if ((j & 0x1) != 0)
            paramInt2 = checkedMultiply(i, paramInt1); 
          break;
        case 1:
          return checkedMultiply(i, paramInt1);
        case 0:
          return i;
      } 
      int k = j >> 1;
      i = paramInt2;
      j = k;
      if (k > 0) {
        if (-46340 <= paramInt1) {
          i = 1;
        } else {
          i = 0;
        } 
        if (paramInt1 <= 46340) {
          j = 1;
        } else {
          j = 0;
        } 
        MathPreconditions.checkNoOverflow(i & j);
        paramInt1 *= paramInt1;
        i = paramInt2;
        j = k;
      } 
    } 
  }
  
  public static int checkedSubtract(int paramInt1, int paramInt2) {
    boolean bool;
    long l = paramInt1 - paramInt2;
    paramInt1 = (int)l;
    if (l == paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    MathPreconditions.checkNoOverflow(bool);
    return paramInt1;
  }
  
  public static int divide(int paramInt1, int paramInt2, RoundingMode paramRoundingMode) {
    Preconditions.checkNotNull(paramRoundingMode);
    if (paramInt2 != 0) {
      int i = paramInt1 / paramInt2;
      int j = paramInt1 - paramInt2 * i;
      if (j == 0)
        return i; 
      boolean bool1 = true;
      boolean bool2 = true;
      int k = (paramInt1 ^ paramInt2) >> 31 | 0x1;
      paramInt1 = bool1;
      switch (paramRoundingMode) {
        default:
          throw new AssertionError();
        case HALF_DOWN:
        case HALF_UP:
        case HALF_EVEN:
          paramInt1 = Math.abs(j);
          paramInt1 -= Math.abs(paramInt2) - paramInt1;
          if (paramInt1 == 0) {
            paramInt1 = bool1;
            if (paramRoundingMode != RoundingMode.HALF_UP) {
              if (paramRoundingMode == RoundingMode.HALF_EVEN) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              } 
              if ((i & 0x1) != 0) {
                paramInt2 = 1;
              } else {
                paramInt2 = 0;
              } 
              if ((paramInt1 & paramInt2) != 0) {
                paramInt1 = bool1;
                break;
              } 
              paramInt1 = 0;
            } 
            break;
          } 
          if (paramInt1 > 0) {
            paramInt1 = bool1;
            break;
          } 
          paramInt1 = 0;
          break;
        case CEILING:
          if (k > 0) {
            paramInt1 = bool1;
            break;
          } 
          paramInt1 = 0;
          break;
        case FLOOR:
          if (k < 0) {
            paramInt1 = bool1;
            break;
          } 
          paramInt1 = 0;
          break;
        case UNNECESSARY:
          if (j != 0)
            bool2 = false; 
          MathPreconditions.checkRoundingUnnecessary(bool2);
        case DOWN:
          paramInt1 = 0;
          break;
        case UP:
          break;
      } 
      paramInt2 = i;
      if (paramInt1 != 0)
        paramInt2 = i + k; 
      return paramInt2;
    } 
    throw new ArithmeticException("/ by zero");
  }
  
  public static int factorial(int paramInt) {
    MathPreconditions.checkNonNegative("n", paramInt);
    int[] arrayOfInt = factorials;
    if (paramInt < arrayOfInt.length) {
      paramInt = arrayOfInt[paramInt];
    } else {
      paramInt = Integer.MAX_VALUE;
    } 
    return paramInt;
  }
  
  @Beta
  public static int floorPowerOfTwo(int paramInt) {
    MathPreconditions.checkPositive("x", paramInt);
    return Integer.highestOneBit(paramInt);
  }
  
  public static int gcd(int paramInt1, int paramInt2) {
    MathPreconditions.checkNonNegative("a", paramInt1);
    MathPreconditions.checkNonNegative("b", paramInt2);
    if (paramInt1 == 0)
      return paramInt2; 
    if (paramInt2 == 0)
      return paramInt1; 
    int i = Integer.numberOfTrailingZeros(paramInt1);
    int j = paramInt1 >> i;
    int k = Integer.numberOfTrailingZeros(paramInt2);
    paramInt1 = paramInt2 >> k;
    for (paramInt2 = j; paramInt2 != paramInt1; paramInt2 = j >> Integer.numberOfTrailingZeros(j)) {
      j = paramInt2 - paramInt1;
      paramInt2 = j >> 31 & j;
      j = j - paramInt2 - paramInt2;
      paramInt1 += paramInt2;
    } 
    return paramInt2 << Math.min(i, k);
  }
  
  public static boolean isPowerOfTwo(int paramInt) {
    boolean bool2;
    boolean bool1 = false;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramInt & paramInt - 1) == 0)
      bool1 = true; 
    return bool2 & bool1;
  }
  
  @Beta
  @GwtIncompatible
  public static boolean isPrime(int paramInt) {
    return LongMath.isPrime(paramInt);
  }
  
  @VisibleForTesting
  static int lessThanBranchFree(int paramInt1, int paramInt2) {
    return (paramInt1 - paramInt2 ^ 0xFFFFFFFF ^ 0xFFFFFFFF) >>> 31;
  }
  
  @GwtIncompatible
  public static int log10(int paramInt, RoundingMode paramRoundingMode) {
    boolean bool;
    MathPreconditions.checkPositive("x", paramInt);
    int i = log10Floor(paramInt);
    int j = powersOf10[i];
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        return i + lessThanBranchFree(halfPowersOf10[i], paramInt);
      case UP:
      case CEILING:
        return i + lessThanBranchFree(j, paramInt);
      case UNNECESSARY:
        if (paramInt == j) {
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
  
  private static int log10Floor(int paramInt) {
    byte b = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(paramInt)];
    return b - lessThanBranchFree(paramInt, powersOf10[b]);
  }
  
  public static int log2(int paramInt, RoundingMode paramRoundingMode) {
    int i;
    MathPreconditions.checkPositive("x", paramInt);
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        i = Integer.numberOfLeadingZeros(paramInt);
        return 31 - i + lessThanBranchFree(-1257966797 >>> i, paramInt);
      case UP:
      case CEILING:
        return 32 - Integer.numberOfLeadingZeros(paramInt - 1);
      case UNNECESSARY:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramInt));
        break;
      case DOWN:
      case FLOOR:
        break;
    } 
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  public static int mean(int paramInt1, int paramInt2) {
    return (paramInt1 & paramInt2) + ((paramInt1 ^ paramInt2) >> 1);
  }
  
  public static int mod(int paramInt1, int paramInt2) {
    if (paramInt2 > 0) {
      paramInt1 %= paramInt2;
      if (paramInt1 < 0)
        paramInt1 += paramInt2; 
      return paramInt1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Modulus ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" must be > 0");
    throw new ArithmeticException(stringBuilder.toString());
  }
  
  @GwtIncompatible
  public static int pow(int paramInt1, int paramInt2) {
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    boolean bool = false;
    int i = 0;
    int j = 1;
    switch (paramInt1) {
      default:
        j = 1;
        break;
      case 2:
        paramInt1 = i;
        if (paramInt2 < 32)
          paramInt1 = 1 << paramInt2; 
        return paramInt1;
      case 1:
        return 1;
      case 0:
        paramInt1 = bool;
        if (paramInt2 == 0)
          paramInt1 = 1; 
        return paramInt1;
      case -1:
        if ((paramInt2 & 0x1) == 0) {
          paramInt1 = j;
        } else {
          paramInt1 = -1;
        } 
        return paramInt1;
      case -2:
        if (paramInt2 < 32) {
          if ((paramInt2 & 0x1) == 0) {
            paramInt1 = 1 << paramInt2;
          } else {
            paramInt1 = -(1 << paramInt2);
          } 
          return paramInt1;
        } 
        return 0;
    } 
    while (true) {
      switch (paramInt2) {
        default:
          if ((paramInt2 & 0x1) == 0) {
            i = 1;
            break;
          } 
          i = paramInt1;
          j *= i;
          paramInt1 *= paramInt1;
          paramInt2 >>= 1;
          continue;
        case 1:
          return paramInt1 * j;
        case 0:
          return j;
      } 
      j *= i;
      paramInt1 *= paramInt1;
      paramInt2 >>= 1;
    } 
  }
  
  @Beta
  public static int saturatedAdd(int paramInt1, int paramInt2) {
    return Ints.saturatedCast(paramInt1 + paramInt2);
  }
  
  @Beta
  public static int saturatedMultiply(int paramInt1, int paramInt2) {
    return Ints.saturatedCast(paramInt1 * paramInt2);
  }
  
  @Beta
  public static int saturatedPow(int paramInt1, int paramInt2) {
    int k;
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    int i = -1;
    int j = 0;
    switch (paramInt1) {
      default:
        i = paramInt1;
        k = 1;
        j = paramInt2;
        break;
      case 2:
        return (paramInt2 >= 31) ? Integer.MAX_VALUE : (1 << paramInt2);
      case 1:
        return 1;
      case 0:
        paramInt1 = j;
        if (paramInt2 == 0)
          paramInt1 = 1; 
        return paramInt1;
      case -1:
        paramInt1 = i;
        if ((paramInt2 & 0x1) == 0)
          paramInt1 = 1; 
        return paramInt1;
      case -2:
        if (paramInt2 >= 32)
          return (paramInt2 & 0x1) + Integer.MAX_VALUE; 
        if ((paramInt2 & 0x1) == 0) {
          paramInt1 = 1 << paramInt2;
        } else {
          paramInt1 = -1 << paramInt2;
        } 
        return paramInt1;
    } 
    while (true) {
      int m;
      switch (j) {
        default:
          m = k;
          if ((j & 0x1) != 0)
            m = saturatedMultiply(k, i); 
          break;
        case 1:
          return saturatedMultiply(k, i);
        case 0:
          return k;
      } 
      int n = j >> 1;
      k = m;
      j = n;
      if (n > 0) {
        if (-46340 > i) {
          j = 1;
        } else {
          j = 0;
        } 
        if (i > 46340) {
          k = 1;
        } else {
          k = 0;
        } 
        if ((j | k) != 0)
          return (paramInt1 >>> 31 & paramInt2 & 0x1) + Integer.MAX_VALUE; 
        i *= i;
        k = m;
        j = n;
      } 
    } 
  }
  
  @Beta
  public static int saturatedSubtract(int paramInt1, int paramInt2) {
    return Ints.saturatedCast(paramInt1 - paramInt2);
  }
  
  @GwtIncompatible
  public static int sqrt(int paramInt, RoundingMode paramRoundingMode) {
    boolean bool;
    MathPreconditions.checkNonNegative("x", paramInt);
    int i = sqrtFloor(paramInt);
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        return i + lessThanBranchFree(i * i + i, paramInt);
      case UP:
      case CEILING:
        return i + lessThanBranchFree(i * i, paramInt);
      case UNNECESSARY:
        if (i * i == paramInt) {
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
  
  private static int sqrtFloor(int paramInt) {
    return (int)Math.sqrt(paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\IntMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */