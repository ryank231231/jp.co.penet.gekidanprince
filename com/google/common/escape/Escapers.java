package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Escapers {
  private static final Escaper NULL_ESCAPER = new CharEscaper() {
      public String escape(String param1String) {
        return (String)Preconditions.checkNotNull(param1String);
      }
      
      protected char[] escape(char param1Char) {
        return null;
      }
    };
  
  static UnicodeEscaper asUnicodeEscaper(Escaper paramEscaper) {
    Preconditions.checkNotNull(paramEscaper);
    if (paramEscaper instanceof UnicodeEscaper)
      return (UnicodeEscaper)paramEscaper; 
    if (paramEscaper instanceof CharEscaper)
      return wrap((CharEscaper)paramEscaper); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot create a UnicodeEscaper from: ");
    stringBuilder.append(paramEscaper.getClass().getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public static String computeReplacement(CharEscaper paramCharEscaper, char paramChar) {
    return stringOrNull(paramCharEscaper.escape(paramChar));
  }
  
  public static String computeReplacement(UnicodeEscaper paramUnicodeEscaper, int paramInt) {
    return stringOrNull(paramUnicodeEscaper.escape(paramInt));
  }
  
  public static Escaper nullEscaper() {
    return NULL_ESCAPER;
  }
  
  private static String stringOrNull(char[] paramArrayOfchar) {
    String str;
    if (paramArrayOfchar == null) {
      paramArrayOfchar = null;
    } else {
      str = new String(paramArrayOfchar);
    } 
    return str;
  }
  
  private static UnicodeEscaper wrap(final CharEscaper escaper) {
    return new UnicodeEscaper() {
        protected char[] escape(int param1Int) {
          byte b;
          if (param1Int < 65536)
            return escaper.escape((char)param1Int); 
          char[] arrayOfChar1 = new char[2];
          boolean bool = false;
          Character.toChars(param1Int, arrayOfChar1, 0);
          char[] arrayOfChar2 = escaper.escape(arrayOfChar1[0]);
          char[] arrayOfChar3 = escaper.escape(arrayOfChar1[1]);
          if (arrayOfChar2 == null && arrayOfChar3 == null)
            return null; 
          if (arrayOfChar2 != null) {
            param1Int = arrayOfChar2.length;
          } else {
            param1Int = 1;
          } 
          if (arrayOfChar3 != null) {
            b = arrayOfChar3.length;
          } else {
            b = 1;
          } 
          char[] arrayOfChar4 = new char[b + param1Int];
          if (arrayOfChar2 != null) {
            for (b = 0; b < arrayOfChar2.length; b++)
              arrayOfChar4[b] = (char)arrayOfChar2[b]; 
          } else {
            arrayOfChar4[0] = arrayOfChar1[0];
          } 
          if (arrayOfChar3 != null) {
            for (b = bool; b < arrayOfChar3.length; b++)
              arrayOfChar4[param1Int + b] = (char)arrayOfChar3[b]; 
          } else {
            arrayOfChar4[param1Int] = arrayOfChar1[1];
          } 
          return arrayOfChar4;
        }
      };
  }
  
  @Beta
  public static final class Builder {
    private final Map<Character, String> replacementMap = new HashMap<Character, String>();
    
    private char safeMax = (char)Character.MAX_VALUE;
    
    private char safeMin = (char)Character.MIN_VALUE;
    
    private String unsafeReplacement = null;
    
    private Builder() {}
    
    @CanIgnoreReturnValue
    public Builder addEscape(char param1Char, String param1String) {
      Preconditions.checkNotNull(param1String);
      this.replacementMap.put(Character.valueOf(param1Char), param1String);
      return this;
    }
    
    public Escaper build() {
      return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
          private final char[] replacementChars;
          
          protected char[] escapeUnsafe(char param2Char) {
            return this.replacementChars;
          }
        };
    }
    
    @CanIgnoreReturnValue
    public Builder setSafeRange(char param1Char1, char param1Char2) {
      this.safeMin = (char)param1Char1;
      this.safeMax = (char)param1Char2;
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder setUnsafeReplacement(@Nullable String param1String) {
      this.unsafeReplacement = param1String;
      return this;
    }
  }
  
  class null extends ArrayBasedCharEscaper {
    private final char[] replacementChars;
    
    null(Map<Character, String> param1Map, char param1Char1, char param1Char2) {
      super(param1Map, param1Char1, param1Char2);
      if (this.this$0.unsafeReplacement != null) {
        char[] arrayOfChar = this.this$0.unsafeReplacement.toCharArray();
      } else {
        Escapers.this = null;
      } 
      this.replacementChars = (char[])Escapers.this;
    }
    
    protected char[] escapeUnsafe(char param1Char) {
      return this.replacementChars;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\escape\Escapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */