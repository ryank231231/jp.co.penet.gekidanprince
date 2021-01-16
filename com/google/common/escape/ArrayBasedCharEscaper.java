package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;

@Beta
@GwtCompatible
public abstract class ArrayBasedCharEscaper extends CharEscaper {
  private final char[][] replacements;
  
  private final int replacementsLength;
  
  private final char safeMax;
  
  private final char safeMin;
  
  protected ArrayBasedCharEscaper(ArrayBasedEscaperMap paramArrayBasedEscaperMap, char paramChar1, char paramChar2) {
    Preconditions.checkNotNull(paramArrayBasedEscaperMap);
    this.replacements = paramArrayBasedEscaperMap.getReplacementArray();
    this.replacementsLength = this.replacements.length;
    char c1 = paramChar1;
    char c2 = paramChar2;
    if (paramChar2 < paramChar1) {
      c2 = Character.MIN_VALUE;
      c1 = '￿';
    } 
    this.safeMin = (char)c1;
    this.safeMax = (char)c2;
  }
  
  protected ArrayBasedCharEscaper(Map<Character, String> paramMap, char paramChar1, char paramChar2) {
    this(ArrayBasedEscaperMap.create(paramMap), paramChar1, paramChar2);
  }
  
  public final String escape(String paramString) {
    Preconditions.checkNotNull(paramString);
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if ((c < this.replacementsLength && this.replacements[c] != null) || c > this.safeMax || c < this.safeMin)
        return escapeSlow(paramString, b); 
    } 
    return paramString;
  }
  
  protected final char[] escape(char paramChar) {
    if (paramChar < this.replacementsLength) {
      char[] arrayOfChar = this.replacements[paramChar];
      if (arrayOfChar != null)
        return arrayOfChar; 
    } 
    return (paramChar >= this.safeMin && paramChar <= this.safeMax) ? null : escapeUnsafe(paramChar);
  }
  
  protected abstract char[] escapeUnsafe(char paramChar);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\ArrayBasedCharEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */