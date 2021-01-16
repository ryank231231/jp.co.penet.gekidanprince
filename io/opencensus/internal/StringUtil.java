package io.opencensus.internal;

public final class StringUtil {
  private static boolean isPrintableChar(char paramChar) {
    boolean bool;
    if (paramChar >= ' ' && paramChar <= '~') {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isPrintableString(String paramString) {
    for (byte b = 0; b < paramString.length(); b++) {
      if (!isPrintableChar(paramString.charAt(b)))
        return false; 
    } 
    return true;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\internal\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */