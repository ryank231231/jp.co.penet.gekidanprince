package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public class Hex {
  private static final char[] zzgy = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  private static final char[] zzgz = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  @KeepForSdk
  public static String bytesToStringLowercase(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[paramArrayOfbyte.length << 1];
    byte b = 0;
    int i = 0;
    while (b < paramArrayOfbyte.length) {
      int j = paramArrayOfbyte[b] & 0xFF;
      int k = i + 1;
      char[] arrayOfChar1 = zzgz;
      arrayOfChar[i] = (char)arrayOfChar1[j >>> 4];
      i = k + 1;
      arrayOfChar[k] = (char)arrayOfChar1[j & 0xF];
      b++;
    } 
    return new String(arrayOfChar);
  }
  
  @KeepForSdk
  public static String bytesToStringUppercase(byte[] paramArrayOfbyte) {
    return bytesToStringUppercase(paramArrayOfbyte, false);
  }
  
  @KeepForSdk
  public static String bytesToStringUppercase(byte[] paramArrayOfbyte, boolean paramBoolean) {
    int i = paramArrayOfbyte.length;
    StringBuilder stringBuilder = new StringBuilder(i << 1);
    for (byte b = 0; b < i && (!paramBoolean || b != i - 1 || (paramArrayOfbyte[b] & 0xFF) != 0); b++) {
      stringBuilder.append(zzgy[(paramArrayOfbyte[b] & 0xF0) >>> 4]);
      stringBuilder.append(zzgy[paramArrayOfbyte[b] & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  @KeepForSdk
  public static byte[] stringToBytes(String paramString) throws IllegalArgumentException {
    int i = paramString.length();
    if (i % 2 == 0) {
      byte[] arrayOfByte = new byte[i / 2];
      for (int j = 0; j < i; j = m) {
        int k = j / 2;
        int m = j + 2;
        arrayOfByte[k] = (byte)(byte)Integer.parseInt(paramString.substring(j, m), 16);
      } 
      return arrayOfByte;
    } 
    throw new IllegalArgumentException("Hex string has odd number of characters");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */