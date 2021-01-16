package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
public abstract class CharEscaper extends Escaper {
  private static final int DEST_PAD_MULTIPLIER = 2;
  
  private static char[] growBuffer(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0)
      System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramInt1); 
    return arrayOfChar;
  }
  
  public String escape(String paramString) {
    Preconditions.checkNotNull(paramString);
    int i = paramString.length();
    for (byte b = 0; b < i; b++) {
      if (escape(paramString.charAt(b)) != null)
        return escapeSlow(paramString, b); 
    } 
    return paramString;
  }
  
  protected abstract char[] escape(char paramChar);
  
  protected final String escapeSlow(String paramString, int paramInt) {
    int i = paramString.length();
    char[] arrayOfChar = Platform.charBufferFromThreadLocal();
    int j = arrayOfChar.length;
    int k = 0;
    int m = 0;
    int n = paramInt;
    paramInt = m;
    while (n < i) {
      char[] arrayOfChar1 = escape(paramString.charAt(n));
      if (arrayOfChar1 != null) {
        int i1 = arrayOfChar1.length;
        int i2 = n - k;
        int i3 = paramInt + i2;
        int i4 = i3 + i1;
        m = j;
        char[] arrayOfChar2 = arrayOfChar;
        if (j < i4) {
          m = (i - n) * 2 + i4;
          arrayOfChar2 = growBuffer(arrayOfChar, paramInt, m);
        } 
        j = paramInt;
        if (i2 > 0) {
          paramString.getChars(k, n, arrayOfChar2, paramInt);
          j = i3;
        } 
        paramInt = j;
        if (i1 > 0) {
          System.arraycopy(arrayOfChar1, 0, arrayOfChar2, j, i1);
          paramInt = j + i1;
        } 
        k = n + 1;
        arrayOfChar = arrayOfChar2;
        j = m;
      } 
      n++;
    } 
    m = i - k;
    if (m > 0) {
      m += paramInt;
      char[] arrayOfChar1 = arrayOfChar;
      if (j < m)
        arrayOfChar1 = growBuffer(arrayOfChar, paramInt, m); 
      paramString.getChars(k, i, arrayOfChar1, paramInt);
      arrayOfChar = arrayOfChar1;
      paramInt = m;
    } 
    return new String(arrayOfChar, 0, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\CharEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */