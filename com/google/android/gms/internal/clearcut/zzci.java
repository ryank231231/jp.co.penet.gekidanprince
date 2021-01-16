package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzci {
  private static final Charset ISO_8859_1;
  
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static final byte[] zzkt;
  
  private static final ByteBuffer zzku;
  
  private static final zzbk zzkv;
  
  static {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    zzkt = arrayOfByte;
    zzku = ByteBuffer.wrap(arrayOfByte);
    arrayOfByte = zzkt;
    zzkv = zzbk.zza(arrayOfByte, 0, arrayOfByte.length, false);
  }
  
  static <T> T checkNotNull(T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException();
  }
  
  public static int hashCode(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    int j = zza(i, paramArrayOfbyte, 0, i);
    i = j;
    if (j == 0)
      i = 1; 
    return i;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    int i = paramInt1;
    for (paramInt1 = paramInt2; paramInt1 < paramInt2 + paramInt3; paramInt1++)
      i = i * 31 + paramArrayOfbyte[paramInt1]; 
    return i;
  }
  
  static Object zza(Object paramObject1, Object paramObject2) {
    return ((zzdo)paramObject1).zzbc().zza((zzdo)paramObject2).zzbi();
  }
  
  static <T> T zza(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(paramString);
  }
  
  public static int zzc(boolean paramBoolean) {
    return paramBoolean ? 1231 : 1237;
  }
  
  public static boolean zze(byte[] paramArrayOfbyte) {
    return zzff.zze(paramArrayOfbyte);
  }
  
  public static String zzf(byte[] paramArrayOfbyte) {
    return new String(paramArrayOfbyte, UTF_8);
  }
  
  static boolean zzf(zzdo paramzzdo) {
    return false;
  }
  
  public static int zzl(long paramLong) {
    return (int)(paramLong ^ paramLong >>> 32L);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */