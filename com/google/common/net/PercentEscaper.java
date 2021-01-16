package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

@Beta
@GwtCompatible
public final class PercentEscaper extends UnicodeEscaper {
  private static final char[] PLUS_SIGN = new char[] { '+' };
  
  private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
  
  private final boolean plusForSpace;
  
  private final boolean[] safeOctets;
  
  public PercentEscaper(String paramString, boolean paramBoolean) {
    Preconditions.checkNotNull(paramString);
    if (!paramString.matches(".*[0-9A-Za-z].*")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
      paramString = stringBuilder.toString();
      if (!paramBoolean || !paramString.contains(" ")) {
        this.plusForSpace = paramBoolean;
        this.safeOctets = createSafeOctets(paramString);
        return;
      } 
      throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    } 
    throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
  }
  
  private static boolean[] createSafeOctets(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length;
    boolean bool = false;
    int j = 0;
    int k = -1;
    while (j < i) {
      k = Math.max(arrayOfChar[j], k);
      j++;
    } 
    boolean[] arrayOfBoolean = new boolean[k + 1];
    j = arrayOfChar.length;
    for (k = bool; k < j; k++)
      arrayOfBoolean[arrayOfChar[k]] = true; 
    return arrayOfBoolean;
  }
  
  public String escape(String paramString) {
    Preconditions.checkNotNull(paramString);
    int i = paramString.length();
    for (byte b = 0; b < i; b++) {
      char c = paramString.charAt(b);
      boolean[] arrayOfBoolean = this.safeOctets;
      if (c >= arrayOfBoolean.length || !arrayOfBoolean[c])
        return escapeSlow(paramString, b); 
    } 
    return paramString;
  }
  
  protected char[] escape(int paramInt) {
    boolean[] arrayOfBoolean = this.safeOctets;
    if (paramInt < arrayOfBoolean.length && arrayOfBoolean[paramInt])
      return null; 
    if (paramInt == 32 && this.plusForSpace)
      return PLUS_SIGN; 
    if (paramInt <= 127) {
      char[] arrayOfChar = UPPER_HEX_DIGITS;
      char c = arrayOfChar[paramInt & 0xF];
      return new char[] { '%', arrayOfChar[paramInt >>> 4], c };
    } 
    if (paramInt <= 2047) {
      char[] arrayOfChar = UPPER_HEX_DIGITS;
      char c1 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c2 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c3 = arrayOfChar[paramInt & 0xF];
      return new char[] { '%', arrayOfChar[paramInt >>> 4 | 0xC], c3, '%', c2, c1 };
    } 
    if (paramInt <= 65535) {
      char[] arrayOfChar = UPPER_HEX_DIGITS;
      char c2 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c1 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c3 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c4 = arrayOfChar[paramInt & 0x3 | 0x8];
      return new char[] { '%', 'E', arrayOfChar[paramInt >>> 2], '%', c4, c3, '%', c1, c2 };
    } 
    if (paramInt <= 1114111) {
      char[] arrayOfChar = UPPER_HEX_DIGITS;
      char c1 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c5 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c4 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c3 = arrayOfChar[paramInt & 0x3 | 0x8];
      paramInt >>>= 2;
      char c2 = arrayOfChar[paramInt & 0xF];
      paramInt >>>= 4;
      char c6 = arrayOfChar[paramInt & 0x3 | 0x8];
      return new char[] { 
          '%', 'F', arrayOfChar[paramInt >>> 2 & 0x7], '%', c6, c2, '%', c3, c4, '%', 
          c5, c1 };
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid unicode character value ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  protected int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    Preconditions.checkNotNull(paramCharSequence);
    while (paramInt1 < paramInt2) {
      char c = paramCharSequence.charAt(paramInt1);
      boolean[] arrayOfBoolean = this.safeOctets;
      if (c >= arrayOfBoolean.length || !arrayOfBoolean[c])
        break; 
      paramInt1++;
    } 
    return paramInt1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\net\PercentEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */