package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Ascii {
  public static final byte ACK = 6;
  
  public static final byte BEL = 7;
  
  public static final byte BS = 8;
  
  public static final byte CAN = 24;
  
  public static final byte CR = 13;
  
  public static final byte DC1 = 17;
  
  public static final byte DC2 = 18;
  
  public static final byte DC3 = 19;
  
  public static final byte DC4 = 20;
  
  public static final byte DEL = 127;
  
  public static final byte DLE = 16;
  
  public static final byte EM = 25;
  
  public static final byte ENQ = 5;
  
  public static final byte EOT = 4;
  
  public static final byte ESC = 27;
  
  public static final byte ETB = 23;
  
  public static final byte ETX = 3;
  
  public static final byte FF = 12;
  
  public static final byte FS = 28;
  
  public static final byte GS = 29;
  
  public static final byte HT = 9;
  
  public static final byte LF = 10;
  
  public static final char MAX = '';
  
  public static final char MIN = '\000';
  
  public static final byte NAK = 21;
  
  public static final byte NL = 10;
  
  public static final byte NUL = 0;
  
  public static final byte RS = 30;
  
  public static final byte SI = 15;
  
  public static final byte SO = 14;
  
  public static final byte SOH = 1;
  
  public static final byte SP = 32;
  
  public static final byte SPACE = 32;
  
  public static final byte STX = 2;
  
  public static final byte SUB = 26;
  
  public static final byte SYN = 22;
  
  public static final byte US = 31;
  
  public static final byte VT = 11;
  
  public static final byte XOFF = 19;
  
  public static final byte XON = 17;
  
  public static boolean equalsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    int i = paramCharSequence1.length();
    if (paramCharSequence1 == paramCharSequence2)
      return true; 
    if (i != paramCharSequence2.length())
      return false; 
    for (byte b = 0; b < i; b++) {
      char c1 = paramCharSequence1.charAt(b);
      char c2 = paramCharSequence2.charAt(b);
      if (c1 != c2) {
        int j = getAlphaIndex(c1);
        if (j >= 26 || j != getAlphaIndex(c2))
          return false; 
      } 
    } 
    return true;
  }
  
  private static int getAlphaIndex(char paramChar) {
    return (char)((paramChar | 0x20) - 97);
  }
  
  public static boolean isLowerCase(char paramChar) {
    boolean bool;
    if (paramChar >= 'a' && paramChar <= 'z') {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isUpperCase(char paramChar) {
    boolean bool;
    if (paramChar >= 'A' && paramChar <= 'Z') {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static char toLowerCase(char paramChar) {
    char c = paramChar;
    if (isUpperCase(paramChar)) {
      char c1 = (char)(paramChar ^ 0x20);
      c = c1;
    } 
    return c;
  }
  
  public static String toLowerCase(CharSequence paramCharSequence) {
    if (paramCharSequence instanceof String)
      return toLowerCase((String)paramCharSequence); 
    char[] arrayOfChar = new char[paramCharSequence.length()];
    for (byte b = 0; b < arrayOfChar.length; b++)
      arrayOfChar[b] = toLowerCase(paramCharSequence.charAt(b)); 
    return String.valueOf(arrayOfChar);
  }
  
  public static String toLowerCase(String paramString) {
    char[] arrayOfChar;
    int i = paramString.length();
    for (byte b = 0; b < i; b++) {
      if (isUpperCase(paramString.charAt(b))) {
        arrayOfChar = paramString.toCharArray();
        while (b < i) {
          char c = arrayOfChar[b];
          if (isUpperCase(c))
            arrayOfChar[b] = (char)(char)(c ^ 0x20); 
          b++;
        } 
        return String.valueOf(arrayOfChar);
      } 
    } 
    return (String)arrayOfChar;
  }
  
  public static char toUpperCase(char paramChar) {
    char c = paramChar;
    if (isLowerCase(paramChar)) {
      char c1 = (char)(paramChar & 0x5F);
      c = c1;
    } 
    return c;
  }
  
  public static String toUpperCase(CharSequence paramCharSequence) {
    if (paramCharSequence instanceof String)
      return toUpperCase((String)paramCharSequence); 
    char[] arrayOfChar = new char[paramCharSequence.length()];
    for (byte b = 0; b < arrayOfChar.length; b++)
      arrayOfChar[b] = toUpperCase(paramCharSequence.charAt(b)); 
    return String.valueOf(arrayOfChar);
  }
  
  public static String toUpperCase(String paramString) {
    char[] arrayOfChar;
    int i = paramString.length();
    for (byte b = 0; b < i; b++) {
      if (isLowerCase(paramString.charAt(b))) {
        arrayOfChar = paramString.toCharArray();
        while (b < i) {
          char c = arrayOfChar[b];
          if (isLowerCase(c))
            arrayOfChar[b] = (char)(char)(c & 0x5F); 
          b++;
        } 
        return String.valueOf(arrayOfChar);
      } 
    } 
    return (String)arrayOfChar;
  }
  
  public static String truncate(CharSequence paramCharSequence, int paramInt, String paramString) {
    boolean bool;
    Preconditions.checkNotNull(paramCharSequence);
    int i = paramInt - paramString.length();
    if (i >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "maxLength (%s) must be >= length of the truncation indicator (%s)", paramInt, paramString.length());
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence.length() <= paramInt) {
      paramCharSequence = paramCharSequence.toString();
      charSequence = paramCharSequence;
      if (paramCharSequence.length() <= paramInt)
        return (String)paramCharSequence; 
    } 
    paramCharSequence = new StringBuilder(paramInt);
    paramCharSequence.append(charSequence, 0, i);
    paramCharSequence.append(paramString);
    return paramCharSequence.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Ascii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */