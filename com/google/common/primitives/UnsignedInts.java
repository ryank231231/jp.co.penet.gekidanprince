package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;

@Beta
@GwtCompatible
public final class UnsignedInts {
  static final long INT_MASK = 4294967295L;
  
  public static int compare(int paramInt1, int paramInt2) {
    return Ints.compare(flip(paramInt1), flip(paramInt2));
  }
  
  @CanIgnoreReturnValue
  public static int decode(String paramString) {
    ParseRequest parseRequest = ParseRequest.fromString(paramString);
    try {
      return parseUnsignedInt(parseRequest.rawValue, parseRequest.radix);
    } catch (NumberFormatException numberFormatException2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error parsing value: ");
      stringBuilder.append(paramString);
      NumberFormatException numberFormatException1 = new NumberFormatException(stringBuilder.toString());
      numberFormatException1.initCause(numberFormatException2);
      throw numberFormatException1;
    } 
  }
  
  public static int divide(int paramInt1, int paramInt2) {
    return (int)(toLong(paramInt1) / toLong(paramInt2));
  }
  
  static int flip(int paramInt) {
    return paramInt ^ Integer.MIN_VALUE;
  }
  
  public static String join(String paramString, int... paramVarArgs) {
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
  
  public static Comparator<int[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static int max(int... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    int j;
    for (j = flip(paramVarArgs[0]); b < paramVarArgs.length; j = i) {
      int k = flip(paramVarArgs[b]);
      i = j;
      if (k > j)
        i = k; 
      b++;
    } 
    return flip(j);
  }
  
  public static int min(int... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    for (i = flip(paramVarArgs[0]); b < paramVarArgs.length; i = k) {
      int j = flip(paramVarArgs[b]);
      int k = i;
      if (j < i)
        k = j; 
      b++;
    } 
    return flip(i);
  }
  
  @CanIgnoreReturnValue
  public static int parseUnsignedInt(String paramString) {
    return parseUnsignedInt(paramString, 10);
  }
  
  @CanIgnoreReturnValue
  public static int parseUnsignedInt(String paramString, int paramInt) {
    Preconditions.checkNotNull(paramString);
    long l = Long.parseLong(paramString, paramInt);
    if ((0xFFFFFFFFL & l) == l)
      return (int)l; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Input ");
    stringBuilder.append(paramString);
    stringBuilder.append(" in base ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" is not in the range of an unsigned integer");
    throw new NumberFormatException(stringBuilder.toString());
  }
  
  public static int remainder(int paramInt1, int paramInt2) {
    return (int)(toLong(paramInt1) % toLong(paramInt2));
  }
  
  public static long toLong(int paramInt) {
    return paramInt & 0xFFFFFFFFL;
  }
  
  public static String toString(int paramInt) {
    return toString(paramInt, 10);
  }
  
  public static String toString(int paramInt1, int paramInt2) {
    return Long.toString(paramInt1 & 0xFFFFFFFFL, paramInt2);
  }
  
  enum LexicographicalComparator implements Comparator<int[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
      int i = Math.min(param1ArrayOfint1.length, param1ArrayOfint2.length);
      for (byte b = 0; b < i; b++) {
        if (param1ArrayOfint1[b] != param1ArrayOfint2[b])
          return UnsignedInts.compare(param1ArrayOfint1[b], param1ArrayOfint2[b]); 
      } 
      return param1ArrayOfint1.length - param1ArrayOfint2.length;
    }
    
    public String toString() {
      return "UnsignedInts.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\UnsignedInts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */