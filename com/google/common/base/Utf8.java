package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
public final class Utf8 {
  public static int encodedLength(CharSequence paramCharSequence) {
    int k;
    int i = paramCharSequence.length();
    byte b;
    for (b = 0; b < i && paramCharSequence.charAt(b) < ''; b++);
    int j = i;
    while (true) {
      k = j;
      if (b < i) {
        k = paramCharSequence.charAt(b);
        if (k < 2048) {
          j += 127 - k >>> 31;
          b++;
          continue;
        } 
        k = j + encodedLengthGeneral(paramCharSequence, b);
      } 
      break;
    } 
    if (k >= i)
      return k; 
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length();
    int j = 0;
    while (paramInt < i) {
      int k;
      char c = paramCharSequence.charAt(paramInt);
      if (c < 'ࠀ') {
        j += 127 - c >>> 31;
        k = paramInt;
      } else {
        int m = j + 2;
        j = m;
        k = paramInt;
        if ('?' <= c) {
          j = m;
          k = paramInt;
          if (c <= '?')
            if (Character.codePointAt(paramCharSequence, paramInt) != c) {
              k = paramInt + 1;
              j = m;
            } else {
              throw new IllegalArgumentException(unpairedSurrogateMsg(paramInt));
            }  
        } 
      } 
      paramInt = k + 1;
    } 
    return j;
  }
  
  public static boolean isWellFormed(byte[] paramArrayOfbyte) {
    return isWellFormed(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static boolean isWellFormed(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramInt2 += paramInt1;
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, paramArrayOfbyte.length);
    while (paramInt1 < paramInt2) {
      if (paramArrayOfbyte[paramInt1] < 0)
        return isWellFormedSlowPath(paramArrayOfbyte, paramInt1, paramInt2); 
      paramInt1++;
    } 
    return true;
  }
  
  private static boolean isWellFormedSlowPath(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    while (true) {
      if (paramInt1 >= paramInt2)
        return true; 
      int i = paramInt1 + 1;
      paramInt1 = paramArrayOfbyte[paramInt1];
      if (paramInt1 < 0) {
        if (paramInt1 < -32) {
          if (i == paramInt2)
            return false; 
          if (paramInt1 >= -62) {
            paramInt1 = i + 1;
            if (paramArrayOfbyte[i] > -65)
              return false; 
            continue;
          } 
          return false;
        } 
        if (paramInt1 < -16) {
          int k = i + 1;
          if (k >= paramInt2)
            return false; 
          i = paramArrayOfbyte[i];
          if (i <= -65 && (paramInt1 != -32 || i >= -96) && (paramInt1 != -19 || -96 > i)) {
            paramInt1 = k + 1;
            if (paramArrayOfbyte[k] > -65)
              return false; 
            continue;
          } 
          return false;
        } 
        if (i + 2 >= paramInt2)
          return false; 
        int j = i + 1;
        i = paramArrayOfbyte[i];
        if (i <= -65 && (paramInt1 << 28) + i + 112 >> 30 == 0) {
          paramInt1 = j + 1;
          if (paramArrayOfbyte[j] <= -65 && paramArrayOfbyte[paramInt1] <= -65) {
            paramInt1++;
            continue;
          } 
        } 
        return false;
      } 
      paramInt1 = i;
    } 
  }
  
  private static String unpairedSurrogateMsg(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unpaired surrogate at index ");
    stringBuilder.append(paramInt);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */