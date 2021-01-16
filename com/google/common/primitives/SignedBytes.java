package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;

@GwtCompatible
public final class SignedBytes {
  public static final byte MAX_POWER_OF_TWO = 64;
  
  public static byte checkedCast(long paramLong) {
    byte b = (byte)(int)paramLong;
    if (b == paramLong)
      return b; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Out of range: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static int compare(byte paramByte1, byte paramByte2) {
    return paramByte1 - paramByte2;
  }
  
  public static String join(String paramString, byte... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 5);
    stringBuilder.append(paramVarArgs[0]);
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(paramVarArgs[b]);
    } 
    return stringBuilder.toString();
  }
  
  public static Comparator<byte[]> lexicographicalComparator() {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static byte max(byte... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    i = paramVarArgs[0];
    int j;
    for (j = i; b < paramVarArgs.length; j = i) {
      i = j;
      if (paramVarArgs[b] > j)
        i = paramVarArgs[b]; 
      b++;
    } 
    return j;
  }
  
  public static byte min(byte... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    i = paramVarArgs[0];
    int j;
    for (j = i; b < paramVarArgs.length; j = i) {
      i = j;
      if (paramVarArgs[b] < j)
        i = paramVarArgs[b]; 
      b++;
    } 
    return j;
  }
  
  public static byte saturatedCast(long paramLong) {
    return (paramLong > 127L) ? Byte.MAX_VALUE : ((paramLong < -128L) ? Byte.MIN_VALUE : (byte)(int)paramLong);
  }
  
  private enum LexicographicalComparator implements Comparator<byte[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      int i = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
      for (byte b = 0; b < i; b++) {
        int j = SignedBytes.compare(param1ArrayOfbyte1[b], param1ArrayOfbyte2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
    }
    
    public String toString() {
      return "SignedBytes.lexicographicalComparator()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\SignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */