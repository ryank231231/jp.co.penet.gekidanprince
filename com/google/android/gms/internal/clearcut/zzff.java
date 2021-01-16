package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

final class zzff {
  private static final zzfg zzqb;
  
  static {
    boolean bool;
    zzfh zzfh;
    if (zzfd.zzed() && zzfd.zzee()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      zzfj zzfj = new zzfj();
    } else {
      zzfh = new zzfh();
    } 
    zzqb = zzfh;
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
                  throw new zzfi(k, i1);
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
    return zzqb.zzb(paramCharSequence, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    zzfg zzfg1 = zzqb;
    if (paramByteBuffer.hasArray()) {
      int i = paramByteBuffer.arrayOffset();
      paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.position() + i, paramByteBuffer.remaining()) - i);
      return;
    } 
    if (paramByteBuffer.isDirect()) {
      zzfg1.zzb(paramCharSequence, paramByteBuffer);
      return;
    } 
    zzfg.zzc(paramCharSequence, paramByteBuffer);
  }
  
  private static int zzam(int paramInt) {
    int i = paramInt;
    if (paramInt > -12)
      i = -1; 
    return i;
  }
  
  private static int zzd(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > -12 || paramInt2 > -65 || paramInt3 > -65) ? -1 : (paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16);
  }
  
  public static boolean zze(byte[] paramArrayOfbyte) {
    return zzqb.zze(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static boolean zze(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return zzqb.zze(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private static int zzf(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte b = paramArrayOfbyte[paramInt1 - 1];
    switch (paramInt2 - paramInt1) {
      default:
        throw new AssertionError();
      case 2:
        return zzd(b, paramArrayOfbyte[paramInt1], paramArrayOfbyte[paramInt1 + 1]);
      case 1:
        return zzp(b, paramArrayOfbyte[paramInt1]);
      case 0:
        break;
    } 
    return zzam(b);
  }
  
  private static int zzp(int paramInt1, int paramInt2) {
    return (paramInt1 > -12 || paramInt2 > -65) ? -1 : (paramInt1 ^ paramInt2 << 8);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */