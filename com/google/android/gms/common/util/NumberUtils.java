package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public class NumberUtils {
  @KeepForSdk
  public static long parseHexLong(String paramString) {
    if (paramString.length() <= 16) {
      if (paramString.length() == 16) {
        long l = Long.parseLong(paramString.substring(8), 16);
        return Long.parseLong(paramString.substring(0, 8), 16) << 32L | l;
      } 
      return Long.parseLong(paramString, 16);
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 37);
    stringBuilder.append("Invalid input: ");
    stringBuilder.append(paramString);
    stringBuilder.append(" exceeds 16 characters");
    throw new NumberFormatException(stringBuilder.toString());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\NumberUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */