package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Comparator;

@Beta
@GwtCompatible
public final class UnsignedLongs {
  public static final long MAX_VALUE = -1L;
  
  private static final int[] maxSafeDigits;
  
  private static final long[] maxValueDivs = new long[37];
  
  private static final int[] maxValueMods = new int[37];
  
  static {
    maxSafeDigits = new int[37];
    BigInteger bigInteger = new BigInteger("10000000000000000", 16);
    for (byte b = 2; b <= 36; b++) {
      long[] arrayOfLong = maxValueDivs;
      long l = b;
      arrayOfLong[b] = divide(-1L, l);
      maxValueMods[b] = (int)remainder(-1L, l);
      maxSafeDigits[b] = bigInteger.toString(b).length() - 1;
    } 
  }
  
  public static int compare(long paramLong1, long paramLong2) {
    return Longs.compare(flip(paramLong1), flip(paramLong2));
  }
  
  @CanIgnoreReturnValue
  public static long decode(String paramString) {
    ParseRequest parseRequest = ParseRequest.fromString(paramString);
    try {
      return parseUnsignedLong(parseRequest.rawValue, parseRequest.radix);
    } catch (NumberFormatException numberFormatException2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error parsing value: ");
      stringBuilder.append(paramString);
      NumberFormatException numberFormatException1 = new NumberFormatException(stringBuilder.toString());
      numberFormatException1.initCause(numberFormatException2);
      throw numberFormatException1;
    } 
  }
  
  public static long divide(long paramLong1, long paramLong2) {
    if (paramLong2 < 0L)
      return (compare(paramLong1, paramLong2) < 0) ? 0L : 1L; 
    if (paramLong1 >= 0L)
      return paramLong1 / paramLong2; 
    boolean bool = true;
    long l = (paramLong1 >>> 1L) / paramLong2 << 1L;
    if (compare(paramLong1 - l * paramLong2, paramLong2) < 0)
      bool = false; 
    return l + bool;
  }
  
  private static long flip(long paramLong) {
    return paramLong ^ Long.MIN_VALUE;
  }
  
  public static String join(String paramString, long... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 5);
    stringBuilder.append(toString(paramVarArgs[0]));
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(toString(paramVarArgs[b]));
    } 
    return stringBuilder.toString();
  }
  
  public static Comparator<long[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static long max(long... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    long l;
    for (l = flip(paramVarArgs[0]); b < paramVarArgs.length; l = l2) {
      long l1 = flip(paramVarArgs[b]);
      long l2 = l;
      if (l1 > l)
        l2 = l1; 
      b++;
    } 
    return flip(l);
  }
  
  public static long min(long... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    long l;
    for (l = flip(paramVarArgs[0]); b < paramVarArgs.length; l = l2) {
      long l1 = flip(paramVarArgs[b]);
      long l2 = l;
      if (l1 < l)
        l2 = l1; 
      b++;
    } 
    return flip(l);
  }
  
  private static boolean overflowInParse(long paramLong, int paramInt1, int paramInt2) {
    boolean bool = true;
    if (paramLong >= 0L) {
      long[] arrayOfLong = maxValueDivs;
      if (paramLong < arrayOfLong[paramInt2])
        return false; 
      if (paramLong > arrayOfLong[paramInt2])
        return true; 
      if (paramInt1 <= maxValueMods[paramInt2])
        bool = false; 
      return bool;
    } 
    return true;
  }
  
  @CanIgnoreReturnValue
  public static long parseUnsignedLong(String paramString) {
    return parseUnsignedLong(paramString, 10);
  }
  
  @CanIgnoreReturnValue
  public static long parseUnsignedLong(String paramString, int paramInt) {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() != 0) {
      if (paramInt >= 2 && paramInt <= 36) {
        int i = maxSafeDigits[paramInt];
        long l = 0L;
        byte b = 0;
        while (b < paramString.length()) {
          int j = Character.digit(paramString.charAt(b), paramInt);
          if (j != -1) {
            if (b <= i - 1 || !overflowInParse(l, j, paramInt)) {
              l = l * paramInt + j;
              b++;
              continue;
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Too large for unsigned long: ");
            stringBuilder1.append(paramString);
            throw new NumberFormatException(stringBuilder1.toString());
          } 
          throw new NumberFormatException(paramString);
        } 
        return l;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("illegal radix: ");
      stringBuilder.append(paramInt);
      throw new NumberFormatException(stringBuilder.toString());
    } 
    throw new NumberFormatException("empty string");
  }
  
  public static long remainder(long paramLong1, long paramLong2) {
    if (paramLong2 < 0L)
      return (compare(paramLong1, paramLong2) < 0) ? paramLong1 : (paramLong1 - paramLong2); 
    if (paramLong1 >= 0L)
      return paramLong1 % paramLong2; 
    paramLong1 -= ((paramLong1 >>> 1L) / paramLong2 << 1L) * paramLong2;
    if (compare(paramLong1, paramLong2) < 0)
      paramLong2 = 0L; 
    return paramLong1 - paramLong2;
  }
  
  public static String toString(long paramLong) {
    return toString(paramLong, 10);
  }
  
  public static String toString(long paramLong, int paramInt) {
    boolean bool;
    int k;
    if (paramInt >= 2 && paramInt <= 36) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", paramInt);
    if (paramLong == 0L)
      return "0"; 
    if (paramLong > 0L)
      return Long.toString(paramLong, paramInt); 
    char[] arrayOfChar = new char[64];
    int i = arrayOfChar.length;
    int j = paramInt - 1;
    if ((paramInt & j) == 0) {
      long l;
      int m = Integer.numberOfTrailingZeros(paramInt);
      do {
        k = i - 1;
        arrayOfChar[k] = Character.forDigit((int)paramLong & j, paramInt);
        l = paramLong >>> m;
        i = k;
        paramLong = l;
      } while (l != 0L);
    } else {
      long l1;
      if ((paramInt & 0x1) == 0) {
        l1 = (paramLong >>> 1L) / (paramInt >>> 1);
      } else {
        l1 = divide(paramLong, paramInt);
      } 
      long l2 = paramInt;
      arrayOfChar[--i] = Character.forDigit((int)(paramLong - l1 * l2), paramInt);
      while (true) {
        k = i;
        if (l1 > 0L) {
          arrayOfChar[--i] = Character.forDigit((int)(l1 % l2), paramInt);
          l1 /= l2;
          continue;
        } 
        break;
      } 
    } 
    return new String(arrayOfChar, k, arrayOfChar.length - k);
  }
  
  enum LexicographicalComparator implements Comparator<long[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
      int i = Math.min(param1ArrayOflong1.length, param1ArrayOflong2.length);
      for (byte b = 0; b < i; b++) {
        if (param1ArrayOflong1[b] != param1ArrayOflong2[b])
          return UnsignedLongs.compare(param1ArrayOflong1[b], param1ArrayOflong2[b]); 
      } 
      return param1ArrayOflong1.length - param1ArrayOflong2.length;
    }
    
    public String toString() {
      return "UnsignedLongs.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\UnsignedLongs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */