package com.squareup.okhttp.internal.http;

public final class HeaderParser {
  public static int parseSeconds(String paramString, int paramInt) {
    try {
      long l = Long.parseLong(paramString);
      return (l > 2147483647L) ? Integer.MAX_VALUE : ((l < 0L) ? 0 : (int)l);
    } catch (NumberFormatException numberFormatException) {
      return paramInt;
    } 
  }
  
  public static int skipUntil(String paramString1, int paramInt, String paramString2) {
    while (paramInt < paramString1.length() && paramString2.indexOf(paramString1.charAt(paramInt)) == -1)
      paramInt++; 
    return paramInt;
  }
  
  public static int skipWhitespace(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (c != ' ' && c != '\t')
        break; 
      paramInt++;
    } 
    return paramInt;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\HeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */