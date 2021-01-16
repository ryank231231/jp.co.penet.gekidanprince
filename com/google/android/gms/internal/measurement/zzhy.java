package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

final class zzhy {
  private static final zzia zzalq;
  
  static {
    boolean bool;
    zzib zzib;
    if (zzhw.zzou() && zzhw.zzov()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && !zzdk.zzkb()) {
      zzid zzid = new zzid();
    } else {
      zzib = new zzib();
    } 
    zzalq = zzib;
  }
  
  static int zza(CharSequence paramCharSequence) {
    int n;
    int i = paramCharSequence.length();
    int j = 0;
    int k;
    for (k = 0; k < i && paramCharSequence.charAt(k) < ''; k++);
    int m = i;
    while (true) {
      n = m;
      if (k < i) {
        n = paramCharSequence.charAt(k);
        if (n < 2048) {
          m += 127 - n >>> 31;
          k++;
          continue;
        } 
        int i1 = paramCharSequence.length();
        n = j;
        while (k < i1) {
          char c = paramCharSequence.charAt(k);
          if (c < 'ࠀ') {
            n += 127 - c >>> 31;
            j = k;
          } else {
            int i2 = n + 2;
            n = i2;
            j = k;
            if ('?' <= c) {
              n = i2;
              j = k;
              if (c <= '?')
                if (Character.codePointAt(paramCharSequence, k) >= 65536) {
                  j = k + 1;
                  n = i2;
                } else {
                  throw new zzic(k, i1);
                }  
            } 
          } 
          k = j + 1;
        } 
        n = m + n;
      } 
      break;
    } 
    if (n >= i)
      return n; 
    long l = n;
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(l + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  static int zza(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return zzalq.zzb(paramCharSequence, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    zzia zzia1 = zzalq;
    if (paramByteBuffer.hasArray()) {
      int i = paramByteBuffer.arrayOffset();
      paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.position() + i, paramByteBuffer.remaining()) - i);
      return;
    } 
    if (paramByteBuffer.isDirect()) {
      zzia1.zzb(paramCharSequence, paramByteBuffer);
      return;
    } 
    zzia.zzc(paramCharSequence, paramByteBuffer);
  }
  
  private static int zzbh(int paramInt) {
    int i = paramInt;
    if (paramInt > -12)
      i = -1; 
    return i;
  }
  
  private static int zzc(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > -12 || paramInt2 > -65 || paramInt3 > -65) ? -1 : (paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16);
  }
  
  public static boolean zzf(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return zzalq.zzf(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private static int zzg(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte b = paramArrayOfbyte[paramInt1 - 1];
    switch (paramInt2 - paramInt1) {
      default:
        throw new AssertionError();
      case 2:
        return zzc(b, paramArrayOfbyte[paramInt1], paramArrayOfbyte[paramInt1 + 1]);
      case 1:
        return zzr(b, paramArrayOfbyte[paramInt1]);
      case 0:
        break;
    } 
    return zzbh(b);
  }
  
  static String zzh(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws zzfh {
    return zzalq.zzh(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public static boolean zzj(byte[] paramArrayOfbyte) {
    return zzalq.zzf(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  private static int zzr(int paramInt1, int paramInt2) {
    return (paramInt1 > -12 || paramInt2 > -65) ? -1 : (paramInt1 ^ paramInt2 << 8);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */