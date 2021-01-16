package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@GwtCompatible(emulated = true)
public final class BigIntegerMath {
  private static final double LN_10;
  
  private static final double LN_2;
  
  @VisibleForTesting
  static final BigInteger SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
  
  @VisibleForTesting
  static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;
  
  static {
    LN_10 = Math.log(10.0D);
    LN_2 = Math.log(2.0D);
  }
  
  public static BigInteger binomial(int paramInt1, int paramInt2) {
    boolean bool;
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    byte b = 1;
    if (paramInt2 <= paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "k (%s) > n (%s)", paramInt2, paramInt1);
    int i = paramInt2;
    if (paramInt2 > paramInt1 >> 1)
      i = paramInt1 - paramInt2; 
    if (i < LongMath.biggestBinomials.length && paramInt1 <= LongMath.biggestBinomials[i])
      return BigInteger.valueOf(LongMath.binomial(paramInt1, i)); 
    BigInteger bigInteger = BigInteger.ONE;
    long l1 = paramInt1;
    long l2 = 1L;
    int j = LongMath.log2(l1, RoundingMode.CEILING);
    paramInt2 = j;
    while (b < i) {
      int k = paramInt1 - b;
      b++;
      paramInt2 += j;
      if (paramInt2 >= 63) {
        bigInteger = bigInteger.multiply(BigInteger.valueOf(l1)).divide(BigInteger.valueOf(l2));
        l1 = k;
        l2 = b;
        paramInt2 = j;
        continue;
      } 
      l1 *= k;
      l2 *= b;
    } 
    return bigInteger.multiply(BigInteger.valueOf(l1)).divide(BigInteger.valueOf(l2));
  }
  
  @Beta
  public static BigInteger ceilingPowerOfTwo(BigInteger paramBigInteger) {
    return BigInteger.ZERO.setBit(log2(paramBigInteger, RoundingMode.CEILING));
  }
  
  @GwtIncompatible
  public static BigInteger divide(BigInteger paramBigInteger1, BigInteger paramBigInteger2, RoundingMode paramRoundingMode) {
    return (new BigDecimal(paramBigInteger1)).divide(new BigDecimal(paramBigInteger2), 0, paramRoundingMode).toBigIntegerExact();
  }
  
  public static BigInteger factorial(int paramInt) {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt < LongMath.factorials.length)
      return BigInteger.valueOf(LongMath.factorials[paramInt]); 
    ArrayList<BigInteger> arrayList = new ArrayList(IntMath.divide(IntMath.log2(paramInt, RoundingMode.CEILING) * paramInt, 64, RoundingMode.CEILING));
    int i = LongMath.factorials.length;
    long l1 = LongMath.factorials[i - 1];
    int j = Long.numberOfTrailingZeros(l1);
    l1 >>= j;
    int k = LongMath.log2(l1, RoundingMode.FLOOR) + 1;
    long l2 = i;
    int m = LongMath.log2(l2, RoundingMode.FLOOR) + 1;
    int n;
    for (n = 1 << m - 1; l2 <= paramInt; n = i) {
      int i1 = m;
      i = n;
      if ((n & l2) != 0L) {
        i = n << 1;
        i1 = m + 1;
      } 
      n = Long.numberOfTrailingZeros(l2);
      j += n;
      long l = l1;
      if (i1 - n + k >= 64) {
        arrayList.add(BigInteger.valueOf(l1));
        l = 1L;
      } 
      l1 = l * (l2 >> n);
      k = LongMath.log2(l1, RoundingMode.FLOOR) + 1;
      l2++;
      m = i1;
    } 
    if (l1 > 1L)
      arrayList.add(BigInteger.valueOf(l1)); 
    return listProduct(arrayList).shiftLeft(j);
  }
  
  @GwtIncompatible
  static boolean fitsInLong(BigInteger paramBigInteger) {
    boolean bool;
    if (paramBigInteger.bitLength() <= 63) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Beta
  public static BigInteger floorPowerOfTwo(BigInteger paramBigInteger) {
    return BigInteger.ZERO.setBit(log2(paramBigInteger, RoundingMode.FLOOR));
  }
  
  public static boolean isPowerOfTwo(BigInteger paramBigInteger) {
    Preconditions.checkNotNull(paramBigInteger);
    int i = paramBigInteger.signum();
    boolean bool = true;
    if (i <= 0 || paramBigInteger.getLowestSetBit() != paramBigInteger.bitLength() - 1)
      bool = false; 
    return bool;
  }
  
  static BigInteger listProduct(List<BigInteger> paramList) {
    return listProduct(paramList, 0, paramList.size());
  }
  
  static BigInteger listProduct(List<BigInteger> paramList, int paramInt1, int paramInt2) {
    int i;
    switch (paramInt2 - paramInt1) {
      default:
        i = paramInt2 + paramInt1 >>> 1;
        return listProduct(paramList, paramInt1, i).multiply(listProduct(paramList, i, paramInt2));
      case 3:
        return ((BigInteger)paramList.get(paramInt1)).multiply(paramList.get(paramInt1 + 1)).multiply(paramList.get(paramInt1 + 2));
      case 2:
        return ((BigInteger)paramList.get(paramInt1)).multiply(paramList.get(paramInt1 + 1));
      case 1:
        return paramList.get(paramInt1);
      case 0:
        break;
    } 
    return BigInteger.ONE;
  }
  
  @GwtIncompatible
  public static int log10(BigInteger paramBigInteger, RoundingMode paramRoundingMode) {
    int k;
    boolean bool;
    MathPreconditions.checkPositive("x", paramBigInteger);
    if (fitsInLong(paramBigInteger))
      return LongMath.log10(paramBigInteger.longValue(), paramRoundingMode); 
    double d1 = log2(paramBigInteger, RoundingMode.FLOOR);
    double d2 = LN_2;
    Double.isNaN(d1);
    int i = (int)(d1 * d2 / LN_10);
    BigInteger bigInteger = BigInteger.TEN.pow(i);
    int j = bigInteger.compareTo(paramBigInteger);
    if (j > 0) {
      BigInteger bigInteger1 = bigInteger;
      do {
        k = i - 1;
        bigInteger = bigInteger1.divide(BigInteger.TEN);
        j = bigInteger.compareTo(paramBigInteger);
        i = k;
        bigInteger1 = bigInteger;
      } while (j > 0);
      i = k;
      k = j;
    } else {
      BigInteger bigInteger1 = BigInteger.TEN.multiply(bigInteger);
      k = bigInteger1.compareTo(paramBigInteger);
      while (k <= 0) {
        i++;
        BigInteger bigInteger2 = BigInteger.TEN.multiply(bigInteger1);
        int m = bigInteger2.compareTo(paramBigInteger);
        bigInteger = bigInteger1;
        j = k;
        k = m;
        bigInteger1 = bigInteger2;
      } 
      k = j;
    } 
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        if (paramBigInteger.pow(2).compareTo(bigInteger.pow(2).multiply(BigInteger.TEN)) > 0)
          i++; 
        return i;
      case UP:
      case CEILING:
        if (!bigInteger.equals(paramBigInteger))
          i++; 
        return i;
      case UNNECESSARY:
        if (k == 0) {
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
  
  public static int log2(BigInteger paramBigInteger, RoundingMode paramRoundingMode) {
    MathPreconditions.checkPositive("x", (BigInteger)Preconditions.checkNotNull(paramBigInteger));
    int i = paramBigInteger.bitLength() - 1;
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        if (i < 256)
          return (paramBigInteger.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - i)) <= 0) ? i : (i + 1); 
        if (paramBigInteger.pow(2).bitLength() - 1 >= i * 2 + 1)
          i++; 
        return i;
      case UP:
      case CEILING:
        if (!isPowerOfTwo(paramBigInteger))
          i++; 
        return i;
      case UNNECESSARY:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramBigInteger));
        break;
      case DOWN:
      case FLOOR:
        break;
    } 
    return i;
  }
  
  @GwtIncompatible
  public static BigInteger sqrt(BigInteger paramBigInteger, RoundingMode paramRoundingMode) {
    int i;
    MathPreconditions.checkNonNegative("x", paramBigInteger);
    if (fitsInLong(paramBigInteger))
      return BigInteger.valueOf(LongMath.sqrt(paramBigInteger.longValue(), paramRoundingMode)); 
    BigInteger bigInteger = sqrtFloor(paramBigInteger);
    switch (paramRoundingMode) {
      default:
        throw new AssertionError();
      case HALF_DOWN:
      case HALF_UP:
      case HALF_EVEN:
        if (bigInteger.pow(2).add(bigInteger).compareTo(paramBigInteger) < 0)
          bigInteger = bigInteger.add(BigInteger.ONE); 
        return bigInteger;
      case UP:
      case CEILING:
        i = bigInteger.intValue();
        if (i * i == paramBigInteger.intValue() && bigInteger.pow(2).equals(paramBigInteger)) {
          i = 1;
        } else {
          i = 0;
        } 
        if (i == 0)
          bigInteger = bigInteger.add(BigInteger.ONE); 
        return bigInteger;
      case UNNECESSARY:
        MathPreconditions.checkRoundingUnnecessary(bigInteger.pow(2).equals(paramBigInteger));
        break;
      case DOWN:
      case FLOOR:
        break;
    } 
    return bigInteger;
  }
  
  @GwtIncompatible
  private static BigInteger sqrtApproxWithDoubles(BigInteger paramBigInteger) {
    return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(paramBigInteger)), RoundingMode.HALF_EVEN);
  }
  
  @GwtIncompatible
  private static BigInteger sqrtFloor(BigInteger paramBigInteger) {
    BigInteger bigInteger1;
    int i = log2(paramBigInteger, RoundingMode.FLOOR);
    if (i < 1023) {
      bigInteger1 = sqrtApproxWithDoubles(paramBigInteger);
    } else {
      i = i - 52 & 0xFFFFFFFE;
      bigInteger1 = sqrtApproxWithDoubles(paramBigInteger.shiftRight(i)).shiftLeft(i >> 1);
    } 
    BigInteger bigInteger2 = bigInteger1.add(paramBigInteger.divide(bigInteger1)).shiftRight(1);
    BigInteger bigInteger3 = bigInteger2;
    if (bigInteger1.equals(bigInteger2))
      return bigInteger1; 
    while (true) {
      bigInteger1 = bigInteger3.add(paramBigInteger.divide(bigInteger3)).shiftRight(1);
      if (bigInteger1.compareTo(bigInteger3) >= 0)
        return bigInteger3; 
      bigInteger3 = bigInteger1;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\BigIntegerMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */