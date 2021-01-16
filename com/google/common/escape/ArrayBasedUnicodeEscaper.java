package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
  private final char[][] replacements;
  
  private final int replacementsLength;
  
  private final int safeMax;
  
  private final char safeMaxChar;
  
  private final int safeMin;
  
  private final char safeMinChar;
  
  protected ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap paramArrayBasedEscaperMap, int paramInt1, int paramInt2, @Nullable String paramString) {
    Preconditions.checkNotNull(paramArrayBasedEscaperMap);
    this.replacements = paramArrayBasedEscaperMap.getReplacementArray();
    this.replacementsLength = this.replacements.length;
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt2 < paramInt1) {
      j = -1;
      i = Integer.MAX_VALUE;
    } 
    this.safeMin = i;
    this.safeMax = j;
    if (i >= 55296) {
      this.safeMinChar = (char)Character.MAX_VALUE;
      this.safeMaxChar = (char)Character.MIN_VALUE;
    } else {
      this.safeMinChar = (char)(char)i;
      this.safeMaxChar = (char)(char)Math.min(j, 55295);
    } 
  }
  
  protected ArrayBasedUnicodeEscaper(Map<Character, String> paramMap, int paramInt1, int paramInt2, @Nullable String paramString) {
    this(ArrayBasedEscaperMap.create(paramMap), paramInt1, paramInt2, paramString);
  }
  
  public final String escape(String paramString) {
    Preconditions.checkNotNull(paramString);
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if ((c < this.replacementsLength && this.replacements[c] != null) || c > this.safeMaxChar || c < this.safeMinChar)
        return escapeSlow(paramString, b); 
    } 
    return paramString;
  }
  
  protected final char[] escape(int paramInt) {
    if (paramInt < this.replacementsLength) {
      char[] arrayOfChar = this.replacements[paramInt];
      if (arrayOfChar != null)
        return arrayOfChar; 
    } 
    return (paramInt >= this.safeMin && paramInt <= this.safeMax) ? null : escapeUnsafe(paramInt);
  }
  
  protected abstract char[] escapeUnsafe(int paramInt);
  
  protected final int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      char c = paramCharSequence.charAt(paramInt1);
      if ((c < this.replacementsLength && this.replacements[c] != null) || c > this.safeMaxChar || c < this.safeMinChar)
        break; 
      paramInt1++;
    } 
    return paramInt1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\ArrayBasedUnicodeEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */