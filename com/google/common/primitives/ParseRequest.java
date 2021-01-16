package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class ParseRequest {
  final int radix;
  
  final String rawValue;
  
  private ParseRequest(String paramString, int paramInt) {
    this.rawValue = paramString;
    this.radix = paramInt;
  }
  
  static ParseRequest fromString(String paramString) {
    if (paramString.length() != 0) {
      char c = paramString.charAt(0);
      boolean bool = paramString.startsWith("0x");
      byte b = 16;
      if (bool || paramString.startsWith("0X")) {
        paramString = paramString.substring(2);
        return new ParseRequest(paramString, b);
      } 
      if (c == '#') {
        paramString = paramString.substring(1);
      } else if (c == '0' && paramString.length() > 1) {
        paramString = paramString.substring(1);
        b = 8;
      } else {
        b = 10;
      } 
      return new ParseRequest(paramString, b);
    } 
    throw new NumberFormatException("empty string");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\ParseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */