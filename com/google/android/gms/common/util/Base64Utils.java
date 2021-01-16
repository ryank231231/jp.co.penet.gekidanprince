package com.google.android.gms.common.util;

import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Base64Utils {
  @KeepForSdk
  public static byte[] decode(String paramString) {
    return (paramString == null) ? null : Base64.decode(paramString, 0);
  }
  
  @KeepForSdk
  public static byte[] decodeUrlSafe(String paramString) {
    return (paramString == null) ? null : Base64.decode(paramString, 10);
  }
  
  @KeepForSdk
  public static byte[] decodeUrlSafeNoPadding(String paramString) {
    return (paramString == null) ? null : Base64.decode(paramString, 11);
  }
  
  @KeepForSdk
  public static String encode(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.encodeToString(paramArrayOfbyte, 0);
  }
  
  @KeepForSdk
  public static String encodeUrlSafe(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.encodeToString(paramArrayOfbyte, 10);
  }
  
  @KeepForSdk
  public static String encodeUrlSafeNoPadding(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.encodeToString(paramArrayOfbyte, 11);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\Base64Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */