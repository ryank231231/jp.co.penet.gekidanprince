package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible
public final class Strings {
  public static String commonPrefix(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    Preconditions.checkNotNull(paramCharSequence1);
    Preconditions.checkNotNull(paramCharSequence2);
    int i = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    byte b;
    for (b = 0; b < i && paramCharSequence1.charAt(b) == paramCharSequence2.charAt(b); b++);
    int j = b - 1;
    if (!validSurrogatePairAt(paramCharSequence1, j)) {
      i = b;
      if (validSurrogatePairAt(paramCharSequence2, j)) {
        i = b - 1;
        return paramCharSequence1.subSequence(0, i).toString();
      } 
      return paramCharSequence1.subSequence(0, i).toString();
    } 
    i = b - 1;
    return paramCharSequence1.subSequence(0, i).toString();
  }
  
  public static String commonSuffix(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    Preconditions.checkNotNull(paramCharSequence1);
    Preconditions.checkNotNull(paramCharSequence2);
    int i = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    byte b;
    for (b = 0; b < i && paramCharSequence1.charAt(paramCharSequence1.length() - b - 1) == paramCharSequence2.charAt(paramCharSequence2.length() - b - 1); b++);
    if (!validSurrogatePairAt(paramCharSequence1, paramCharSequence1.length() - b - 1)) {
      i = b;
      if (validSurrogatePairAt(paramCharSequence2, paramCharSequence2.length() - b - 1)) {
        i = b - 1;
        return paramCharSequence1.subSequence(paramCharSequence1.length() - i, paramCharSequence1.length()).toString();
      } 
      return paramCharSequence1.subSequence(paramCharSequence1.length() - i, paramCharSequence1.length()).toString();
    } 
    i = b - 1;
    return paramCharSequence1.subSequence(paramCharSequence1.length() - i, paramCharSequence1.length()).toString();
  }
  
  @Nullable
  public static String emptyToNull(@Nullable String paramString) {
    String str = paramString;
    if (isNullOrEmpty(paramString))
      str = null; 
    return str;
  }
  
  public static boolean isNullOrEmpty(@Nullable String paramString) {
    return Platform.stringIsNullOrEmpty(paramString);
  }
  
  public static String nullToEmpty(@Nullable String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public static String padEnd(String paramString, int paramInt, char paramChar) {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() >= paramInt)
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder(paramInt);
    stringBuilder.append(paramString);
    for (int i = paramString.length(); i < paramInt; i++)
      stringBuilder.append(paramChar); 
    return stringBuilder.toString();
  }
  
  public static String padStart(String paramString, int paramInt, char paramChar) {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() >= paramInt)
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder(paramInt);
    for (int i = paramString.length(); i < paramInt; i++)
      stringBuilder.append(paramChar); 
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static String repeat(String paramString, int paramInt) {
    Preconditions.checkNotNull(paramString);
    boolean bool = true;
    if (paramInt <= 1) {
      if (paramInt < 0)
        bool = false; 
      Preconditions.checkArgument(bool, "invalid count: %s", paramInt);
      if (paramInt == 0)
        paramString = ""; 
      return paramString;
    } 
    int i = paramString.length();
    long l = i * paramInt;
    int j = (int)l;
    if (j == l) {
      char[] arrayOfChar = new char[j];
      paramString.getChars(0, i, arrayOfChar, 0);
      paramInt = i;
      while (true) {
        i = j - paramInt;
        if (paramInt < i) {
          System.arraycopy(arrayOfChar, 0, arrayOfChar, paramInt, paramInt);
          paramInt <<= 1;
          continue;
        } 
        System.arraycopy(arrayOfChar, 0, arrayOfChar, paramInt, i);
        return new String(arrayOfChar);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Required array size too large: ");
    stringBuilder.append(l);
    throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
  }
  
  @VisibleForTesting
  static boolean validSurrogatePairAt(CharSequence paramCharSequence, int paramInt) {
    boolean bool = true;
    if (paramInt < 0 || paramInt > paramCharSequence.length() - 2 || !Character.isHighSurrogate(paramCharSequence.charAt(paramInt)) || !Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1)))
      bool = false; 
    return bool;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */