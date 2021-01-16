package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

@Beta
@GwtCompatible
public final class CharEscaperBuilder {
  private final Map<Character, String> map = new HashMap<Character, String>();
  
  private int max = -1;
  
  @CanIgnoreReturnValue
  public CharEscaperBuilder addEscape(char paramChar, String paramString) {
    this.map.put(Character.valueOf(paramChar), Preconditions.checkNotNull(paramString));
    if (paramChar > this.max)
      this.max = paramChar; 
    return this;
  }
  
  @CanIgnoreReturnValue
  public CharEscaperBuilder addEscapes(char[] paramArrayOfchar, String paramString) {
    Preconditions.checkNotNull(paramString);
    int i = paramArrayOfchar.length;
    for (byte b = 0; b < i; b++)
      addEscape(paramArrayOfchar[b], paramString); 
    return this;
  }
  
  public char[][] toArray() {
    char[][] arrayOfChar = new char[this.max + 1][];
    for (Map.Entry<Character, String> entry : this.map.entrySet())
      arrayOfChar[((Character)entry.getKey()).charValue()] = ((String)entry.getValue()).toCharArray(); 
    return arrayOfChar;
  }
  
  public Escaper toEscaper() {
    return new CharArrayDecorator(toArray());
  }
  
  private static class CharArrayDecorator extends CharEscaper {
    private final int replaceLength;
    
    private final char[][] replacements;
    
    CharArrayDecorator(char[][] param1ArrayOfchar) {
      this.replacements = param1ArrayOfchar;
      this.replaceLength = param1ArrayOfchar.length;
    }
    
    public String escape(String param1String) {
      int i = param1String.length();
      for (byte b = 0; b < i; b++) {
        char c = param1String.charAt(b);
        char[][] arrayOfChar = this.replacements;
        if (c < arrayOfChar.length && arrayOfChar[c] != null)
          return escapeSlow(param1String, b); 
      } 
      return param1String;
    }
    
    protected char[] escape(char param1Char) {
      char[] arrayOfChar;
      if (param1Char < this.replaceLength) {
        arrayOfChar = this.replacements[param1Char];
      } else {
        arrayOfChar = null;
      } 
      return arrayOfChar;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\CharEscaperBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */