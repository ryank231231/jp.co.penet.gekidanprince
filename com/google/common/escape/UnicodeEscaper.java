package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
public abstract class UnicodeEscaper extends Escaper {
  private static final int DEST_PAD = 32;
  
  protected static int codePointAt(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    Preconditions.checkNotNull(paramCharSequence);
    if (paramInt1 < paramInt2) {
      int i = paramInt1 + 1;
      char c = paramCharSequence.charAt(paramInt1);
      if (c < '?' || c > '?')
        return c; 
      if (c <= '?') {
        if (i == paramInt2)
          return -c; 
        char c1 = paramCharSequence.charAt(i);
        if (Character.isLowSurrogate(c1))
          return Character.toCodePoint(c, c1); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Expected low surrogate but got char '");
        stringBuilder1.append(c1);
        stringBuilder1.append("' with value ");
        stringBuilder1.append(c1);
        stringBuilder1.append(" at index ");
        stringBuilder1.append(i);
        stringBuilder1.append(" in '");
        stringBuilder1.append(paramCharSequence);
        stringBuilder1.append("'");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected low surrogate character '");
      stringBuilder.append(c);
      stringBuilder.append("' with value ");
      stringBuilder.append(c);
      stringBuilder.append(" at index ");
      stringBuilder.append(i - 1);
      stringBuilder.append(" in '");
      stringBuilder.append(paramCharSequence);
      stringBuilder.append("'");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }
  
  private static char[] growBuffer(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0)
      System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramInt1); 
    return arrayOfChar;
  }
  
  public String escape(String paramString) {
    Preconditions.checkNotNull(paramString);
    int i = paramString.length();
    int j = nextEscapeIndex(paramString, 0, i);
    if (j != i)
      paramString = escapeSlow(paramString, j); 
    return paramString;
  }
  
  protected abstract char[] escape(int paramInt);
  
  protected final String escapeSlow(String paramString, int paramInt) {
    int i = paramString.length();
    char[] arrayOfChar = Platform.charBufferFromThreadLocal();
    int j = 0;
    int k = 0;
    int m = paramInt;
    paramInt = k;
    while (m < i) {
      k = codePointAt(paramString, m, i);
      if (k >= 0) {
        char[] arrayOfChar1 = escape(k);
        if (Character.isSupplementaryCodePoint(k)) {
          k = 2;
        } else {
          k = 1;
        } 
        int n = k + m;
        int i1 = j;
        k = paramInt;
        char[] arrayOfChar2 = arrayOfChar;
        if (arrayOfChar1 != null) {
          int i2 = m - j;
          i1 = paramInt + i2;
          k = arrayOfChar1.length + i1;
          arrayOfChar2 = arrayOfChar;
          if (arrayOfChar.length < k)
            arrayOfChar2 = growBuffer(arrayOfChar, paramInt, k + i - m + 32); 
          k = paramInt;
          if (i2 > 0) {
            paramString.getChars(j, m, arrayOfChar2, paramInt);
            k = i1;
          } 
          paramInt = k;
          if (arrayOfChar1.length > 0) {
            System.arraycopy(arrayOfChar1, 0, arrayOfChar2, k, arrayOfChar1.length);
            paramInt = k + arrayOfChar1.length;
          } 
          i1 = n;
          k = paramInt;
        } 
        m = nextEscapeIndex(paramString, n, i);
        j = i1;
        paramInt = k;
        arrayOfChar = arrayOfChar2;
        continue;
      } 
      throw new IllegalArgumentException("Trailing high surrogate at end of input");
    } 
    k = i - j;
    if (k > 0) {
      k += paramInt;
      char[] arrayOfChar1 = arrayOfChar;
      if (arrayOfChar.length < k)
        arrayOfChar1 = growBuffer(arrayOfChar, paramInt, k); 
      paramString.getChars(j, i, arrayOfChar1, paramInt);
      arrayOfChar = arrayOfChar1;
      paramInt = k;
    } 
    return new String(arrayOfChar, 0, paramInt);
  }
  
  protected int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      int i = codePointAt(paramCharSequence, paramInt1, paramInt2);
      if (i < 0 || escape(i) != null)
        break; 
      if (Character.isSupplementaryCodePoint(i)) {
        i = 2;
      } else {
        i = 1;
      } 
      paramInt1 += i;
    } 
    return paramInt1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\UnicodeEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */