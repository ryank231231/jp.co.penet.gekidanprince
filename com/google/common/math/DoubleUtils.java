package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

@GwtIncompatible
final class DoubleUtils {
  static final int EXPONENT_BIAS = 1023;
  
  static final long EXPONENT_MASK = 9218868437227405312L;
  
  static final long IMPLICIT_BIT = 4503599627370496L;
  
  private static final long ONE_BITS = Double.doubleToRawLongBits(1.0D);
  
  static final int SIGNIFICAND_BITS = 52;
  
  static final long SIGNIFICAND_MASK = 4503599627370495L;
  
  static final long SIGN_MASK = -9223372036854775808L;
  
  static double bigToDouble(BigInteger paramBigInteger) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual abs : ()Ljava/math/BigInteger;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual bitLength : ()I
    //   9: istore_2
    //   10: iconst_1
    //   11: istore_3
    //   12: iload_2
    //   13: iconst_1
    //   14: isub
    //   15: istore #4
    //   17: iload #4
    //   19: bipush #63
    //   21: if_icmpge -> 30
    //   24: aload_0
    //   25: invokevirtual longValue : ()J
    //   28: l2d
    //   29: dreturn
    //   30: iload #4
    //   32: sipush #1023
    //   35: if_icmple -> 58
    //   38: aload_0
    //   39: invokevirtual signum : ()I
    //   42: i2d
    //   43: dstore #5
    //   45: dload #5
    //   47: invokestatic isNaN : (D)Z
    //   50: pop
    //   51: dload #5
    //   53: ldc2_w Infinity
    //   56: dmul
    //   57: dreturn
    //   58: iload #4
    //   60: bipush #52
    //   62: isub
    //   63: iconst_1
    //   64: isub
    //   65: istore #7
    //   67: aload_1
    //   68: iload #7
    //   70: invokevirtual shiftRight : (I)Ljava/math/BigInteger;
    //   73: invokevirtual longValue : ()J
    //   76: lstore #8
    //   78: lload #8
    //   80: iconst_1
    //   81: lshr
    //   82: ldc2_w 4503599627370495
    //   85: land
    //   86: lstore #10
    //   88: lload #8
    //   90: lconst_1
    //   91: land
    //   92: lconst_0
    //   93: lcmp
    //   94: ifeq -> 122
    //   97: iload_3
    //   98: istore_2
    //   99: lload #10
    //   101: lconst_1
    //   102: land
    //   103: lconst_0
    //   104: lcmp
    //   105: ifne -> 124
    //   108: aload_1
    //   109: invokevirtual getLowestSetBit : ()I
    //   112: iload #7
    //   114: if_icmpge -> 122
    //   117: iload_3
    //   118: istore_2
    //   119: goto -> 124
    //   122: iconst_0
    //   123: istore_2
    //   124: lload #10
    //   126: lstore #8
    //   128: iload_2
    //   129: ifeq -> 138
    //   132: lload #10
    //   134: lconst_1
    //   135: ladd
    //   136: lstore #8
    //   138: iload #4
    //   140: sipush #1023
    //   143: iadd
    //   144: i2l
    //   145: bipush #52
    //   147: lshl
    //   148: lload #8
    //   150: ladd
    //   151: aload_0
    //   152: invokevirtual signum : ()I
    //   155: i2l
    //   156: ldc2_w -9223372036854775808
    //   159: land
    //   160: lor
    //   161: invokestatic longBitsToDouble : (J)D
    //   164: dreturn
  }
  
  static double ensureNonNegative(double paramDouble) {
    Preconditions.checkArgument(Double.isNaN(paramDouble) ^ true);
    return (paramDouble > 0.0D) ? paramDouble : 0.0D;
  }
  
  static long getSignificand(double paramDouble) {
    Preconditions.checkArgument(isFinite(paramDouble), "not a normal value");
    int i = Math.getExponent(paramDouble);
    long l = Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFFFFFFFL;
    if (i == -1023) {
      l <<= 1L;
    } else {
      l |= 0x10000000000000L;
    } 
    return l;
  }
  
  static boolean isFinite(double paramDouble) {
    boolean bool;
    if (Math.getExponent(paramDouble) <= 1023) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static boolean isNormal(double paramDouble) {
    boolean bool;
    if (Math.getExponent(paramDouble) >= -1022) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static double nextDown(double paramDouble) {
    return -Math.nextUp(-paramDouble);
  }
  
  static double scaleNormalize(double paramDouble) {
    return Double.longBitsToDouble(Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFFFFFFFL | ONE_BITS);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\math\DoubleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */