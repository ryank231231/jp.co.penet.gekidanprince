package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzfb {
  private static final Charset ISO_8859_1;
  
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static final byte[] zzahk;
  
  private static final ByteBuffer zzahl;
  
  private static final zzeb zzahm;
  
  static {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    zzahk = arrayOfByte;
    zzahl = ByteBuffer.wrap(arrayOfByte);
    arrayOfByte = zzahk;
    zzahm = zzeb.zza(arrayOfByte, 0, arrayOfByte.length, false);
  }
  
  static <T> T checkNotNull(T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException();
  }
  
  public static int hashCode(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    i = zza(i, paramArrayOfbyte, 0, i);
    return (i == 0) ? 1 : i;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    int i = paramInt1;
    for (paramInt1 = paramInt2; paramInt1 < paramInt2 + paramInt3; paramInt1++)
      i = i * 31 + paramArrayOfbyte[paramInt1]; 
    return i;
  }
  
  static Object zza(Object paramObject1, Object paramObject2) {
    return ((zzgh)paramObject1).zzmk().zza((zzgh)paramObject2).zzmq();
  }
  
  static <T> T zza(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(paramString);
  }
  
  public static int zzba(long paramLong) {
    return (int)(paramLong ^ paramLong >>> 32L);
  }
  
  static boolean zzf(zzgh paramzzgh) {
    return false;
  }
  
  public static boolean zzj(byte[] paramArrayOfbyte) {
    return zzhy.zzj(paramArrayOfbyte);
  }
  
  public static String zzk(byte[] paramArrayOfbyte) {
    return new String(paramArrayOfbyte, UTF_8);
  }
  
  public static int zzo(boolean paramBoolean) {
    return paramBoolean ? 1231 : 1237;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */