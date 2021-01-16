package com.google.android.gms.internal.clearcut;

import java.io.IOException;

final class zzax {
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, zzay paramzzay) throws zzco {
    if (paramInt1 >>> 3 != 0) {
      int i = paramInt1 & 0x7;
      if (i != 5) {
        int j;
        switch (i) {
          default:
            throw zzco.zzbm();
          case 3:
            j = paramInt1 & 0xFFFFFFF8 | 0x4;
            paramInt1 = 0;
            while (true) {
              i = paramInt1;
              paramInt1 = paramInt2;
              if (paramInt2 < paramInt3) {
                int k = zza(paramArrayOfbyte, paramInt2, paramzzay);
                paramInt2 = paramzzay.zzfd;
                i = paramInt2;
                paramInt1 = k;
                if (paramInt2 != j) {
                  i = zza(paramInt2, paramArrayOfbyte, k, paramInt3, paramzzay);
                  paramInt1 = paramInt2;
                  paramInt2 = i;
                  continue;
                } 
              } 
              break;
            } 
            if (paramInt1 <= paramInt3 && i == j)
              return paramInt1; 
            throw zzco.zzbo();
          case 2:
            return zza(paramArrayOfbyte, paramInt2, paramzzay) + paramzzay.zzfd;
          case 1:
            return paramInt2 + 8;
          case 0:
            break;
        } 
        return zzb(paramArrayOfbyte, paramInt2, paramzzay);
      } 
      return paramInt2 + 4;
    } 
    throw zzco.zzbm();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, zzcn<?> paramzzcn, zzay paramzzay) {
    paramzzcn = paramzzcn;
    paramInt2 = zza(paramArrayOfbyte, paramInt2, paramzzay);
    while (true) {
      paramzzcn.zzac(paramzzay.zzfd);
      if (paramInt2 < paramInt3) {
        int i = zza(paramArrayOfbyte, paramInt2, paramzzay);
        if (paramInt1 == paramzzay.zzfd) {
          paramInt2 = zza(paramArrayOfbyte, i, paramzzay);
          continue;
        } 
      } 
      break;
    } 
    return paramInt2;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, zzey paramzzey, zzay paramzzay) throws IOException {
    if (paramInt1 >>> 3 != 0) {
      zzbb zzbb;
      int i = paramInt1 & 0x7;
      if (i != 5) {
        zzey zzey1;
        int j;
        int k;
        switch (i) {
          default:
            throw zzco.zzbm();
          case 3:
            zzey1 = zzey.zzeb();
            j = paramInt1 & 0xFFFFFFF8 | 0x4;
            i = 0;
            while (true) {
              k = i;
              i = paramInt2;
              if (paramInt2 < paramInt3) {
                i = zza(paramArrayOfbyte, paramInt2, paramzzay);
                paramInt2 = paramzzay.zzfd;
                if (paramInt2 != j) {
                  k = zza(paramInt2, paramArrayOfbyte, i, paramInt3, zzey1, paramzzay);
                  i = paramInt2;
                  paramInt2 = k;
                  continue;
                } 
                k = paramInt2;
              } 
              break;
            } 
            if (i <= paramInt3 && k == j) {
              paramzzey.zzb(paramInt1, zzey1);
              return i;
            } 
            throw zzco.zzbo();
          case 2:
            paramInt3 = zza(paramArrayOfbyte, paramInt2, paramzzay);
            paramInt2 = paramzzay.zzfd;
            if (paramInt2 == 0) {
              zzbb = zzbb.zzfi;
            } else {
              zzbb = zzbb.zzb((byte[])zzbb, paramInt3, paramInt2);
            } 
            paramzzey.zzb(paramInt1, zzbb);
            return paramInt3 + paramInt2;
          case 1:
            paramzzey.zzb(paramInt1, Long.valueOf(zzd((byte[])zzbb, paramInt2)));
            return paramInt2 + 8;
          case 0:
            break;
        } 
        paramInt2 = zzb((byte[])zzbb, paramInt2, paramzzay);
        paramzzey.zzb(paramInt1, Long.valueOf(paramzzay.zzfe));
        return paramInt2;
      } 
      paramzzey.zzb(paramInt1, Integer.valueOf(zzc((byte[])zzbb, paramInt2)));
      return paramInt2 + 4;
    } 
    throw zzco.zzbm();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, zzay paramzzay) {
    int i = paramInt1 & 0x7F;
    paramInt1 = paramInt2 + 1;
    paramInt2 = paramArrayOfbyte[paramInt2];
    if (paramInt2 >= 0) {
      paramInt2 <<= 7;
      paramzzay.zzfd = i | paramInt2;
      return paramInt1;
    } 
    i |= (paramInt2 & 0x7F) << 7;
    paramInt2 = paramInt1 + 1;
    paramInt1 = paramArrayOfbyte[paramInt1];
    if (paramInt1 >= 0) {
      int k = paramInt1 << 14;
      paramInt1 = paramInt2;
      paramInt2 = k;
      paramzzay.zzfd = i | paramInt2;
      return paramInt1;
    } 
    i |= (paramInt1 & 0x7F) << 14;
    int j = paramInt2 + 1;
    paramInt1 = paramArrayOfbyte[paramInt2];
    if (paramInt1 >= 0) {
      paramInt2 = paramInt1 << 21;
      paramInt1 = j;
      paramzzay.zzfd = i | paramInt2;
      return paramInt1;
    } 
    i |= (paramInt1 & 0x7F) << 21;
    paramInt1 = j + 1;
    j = paramArrayOfbyte[j];
    if (j >= 0) {
      paramInt2 = j << 28;
      paramzzay.zzfd = i | paramInt2;
      return paramInt1;
    } 
    while (true) {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfbyte[paramInt1] >= 0) {
        paramzzay.zzfd = i | (j & 0x7F) << 28;
        return paramInt2;
      } 
      paramInt1 = paramInt2;
    } 
  }
  
  static int zza(byte[] paramArrayOfbyte, int paramInt, zzay paramzzay) {
    int i = paramInt + 1;
    paramInt = paramArrayOfbyte[paramInt];
    if (paramInt >= 0) {
      paramzzay.zzfd = paramInt;
      return i;
    } 
    return zza(paramInt, paramArrayOfbyte, i, paramzzay);
  }
  
  static int zza(byte[] paramArrayOfbyte, int paramInt, zzcn<?> paramzzcn, zzay paramzzay) throws IOException {
    paramzzcn = paramzzcn;
    paramInt = zza(paramArrayOfbyte, paramInt, paramzzay);
    int i = paramzzay.zzfd + paramInt;
    while (paramInt < i) {
      paramInt = zza(paramArrayOfbyte, paramInt, paramzzay);
      paramzzcn.zzac(paramzzay.zzfd);
    } 
    if (paramInt == i)
      return paramInt; 
    throw zzco.zzbl();
  }
  
  static int zzb(byte[] paramArrayOfbyte, int paramInt, zzay paramzzay) {
    int i = paramInt + 1;
    long l = paramArrayOfbyte[paramInt];
    if (l >= 0L) {
      paramzzay.zzfe = l;
      return i;
    } 
    paramInt = i + 1;
    byte b = paramArrayOfbyte[i];
    l = l & 0x7FL | (b & Byte.MAX_VALUE) << 7L;
    i = 7;
    while (b < 0) {
      b = paramArrayOfbyte[paramInt];
      i += 7;
      l |= (b & Byte.MAX_VALUE) << i;
      paramInt++;
    } 
    paramzzay.zzfe = l;
    return paramInt;
  }
  
  static int zzc(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
  
  static int zzc(byte[] paramArrayOfbyte, int paramInt, zzay paramzzay) {
    int i = zza(paramArrayOfbyte, paramInt, paramzzay);
    paramInt = paramzzay.zzfd;
    if (paramInt == 0) {
      paramzzay.zzff = "";
      return i;
    } 
    paramzzay.zzff = new String(paramArrayOfbyte, i, paramInt, zzci.UTF_8);
    return i + paramInt;
  }
  
  static int zzd(byte[] paramArrayOfbyte, int paramInt, zzay paramzzay) throws IOException {
    int i = zza(paramArrayOfbyte, paramInt, paramzzay);
    int j = paramzzay.zzfd;
    if (j == 0) {
      paramzzay.zzff = "";
      return i;
    } 
    paramInt = i + j;
    if (zzff.zze(paramArrayOfbyte, i, paramInt)) {
      paramzzay.zzff = new String(paramArrayOfbyte, i, j, zzci.UTF_8);
      return paramInt;
    } 
    throw zzco.zzbp();
  }
  
  static long zzd(byte[] paramArrayOfbyte, int paramInt) {
    long l1 = paramArrayOfbyte[paramInt];
    long l2 = paramArrayOfbyte[paramInt + 1];
    long l3 = paramArrayOfbyte[paramInt + 2];
    long l4 = paramArrayOfbyte[paramInt + 3];
    long l5 = paramArrayOfbyte[paramInt + 4];
    long l6 = paramArrayOfbyte[paramInt + 5];
    long l7 = paramArrayOfbyte[paramInt + 6];
    return (paramArrayOfbyte[paramInt + 7] & 0xFFL) << 56L | l1 & 0xFFL | (l2 & 0xFFL) << 8L | (l3 & 0xFFL) << 16L | (l4 & 0xFFL) << 24L | (l5 & 0xFFL) << 32L | (l6 & 0xFFL) << 40L | (l7 & 0xFFL) << 48L;
  }
  
  static double zze(byte[] paramArrayOfbyte, int paramInt) {
    return Double.longBitsToDouble(zzd(paramArrayOfbyte, paramInt));
  }
  
  static int zze(byte[] paramArrayOfbyte, int paramInt, zzay paramzzay) {
    int i = zza(paramArrayOfbyte, paramInt, paramzzay);
    paramInt = paramzzay.zzfd;
    if (paramInt == 0) {
      paramzzay.zzff = zzbb.zzfi;
      return i;
    } 
    paramzzay.zzff = zzbb.zzb(paramArrayOfbyte, i, paramInt);
    return i + paramInt;
  }
  
  static float zzf(byte[] paramArrayOfbyte, int paramInt) {
    return Float.intBitsToFloat(zzc(paramArrayOfbyte, paramInt));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */