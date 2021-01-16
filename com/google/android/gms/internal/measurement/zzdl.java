package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzdl {
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, zzdm paramzzdm) throws zzfh {
    if (paramInt1 >>> 3 != 0) {
      int i = paramInt1 & 0x7;
      if (i != 5) {
        int j;
        switch (i) {
          default:
            throw zzfh.zzmx();
          case 3:
            j = paramInt1 & 0xFFFFFFF8 | 0x4;
            paramInt1 = 0;
            while (true) {
              i = paramInt2;
              if (paramInt2 < paramInt3) {
                int k = zza(paramArrayOfbyte, paramInt2, paramzzdm);
                paramInt2 = paramzzdm.zzabs;
                paramInt1 = paramInt2;
                i = k;
                if (paramInt2 != j) {
                  i = zza(paramInt2, paramArrayOfbyte, k, paramInt3, paramzzdm);
                  paramInt1 = paramInt2;
                  paramInt2 = i;
                  continue;
                } 
              } 
              break;
            } 
            if (i <= paramInt3 && paramInt1 == j)
              return i; 
            throw zzfh.zznb();
          case 2:
            return zza(paramArrayOfbyte, paramInt2, paramzzdm) + paramzzdm.zzabs;
          case 1:
            return paramInt2 + 8;
          case 0:
            break;
        } 
        return zzb(paramArrayOfbyte, paramInt2, paramzzdm);
      } 
      return paramInt2 + 4;
    } 
    throw zzfh.zzmx();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, zzfg<?> paramzzfg, zzdm paramzzdm) {
    paramzzfg = paramzzfg;
    paramInt2 = zza(paramArrayOfbyte, paramInt2, paramzzdm);
    paramzzfg.zzau(paramzzdm.zzabs);
    while (paramInt2 < paramInt3) {
      int i = zza(paramArrayOfbyte, paramInt2, paramzzdm);
      if (paramInt1 == paramzzdm.zzabs) {
        paramInt2 = zza(paramArrayOfbyte, i, paramzzdm);
        paramzzfg.zzau(paramzzdm.zzabs);
      } 
    } 
    return paramInt2;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, zzhr paramzzhr, zzdm paramzzdm) throws zzfh {
    if (paramInt1 >>> 3 != 0) {
      int i = paramInt1 & 0x7;
      if (i != 5) {
        zzhr zzhr1;
        int j;
        int k;
        switch (i) {
          default:
            throw zzfh.zzmx();
          case 3:
            zzhr1 = zzhr.zzos();
            j = paramInt1 & 0xFFFFFFF8 | 0x4;
            i = 0;
            while (true) {
              k = i;
              i = paramInt2;
              if (paramInt2 < paramInt3) {
                i = zza(paramArrayOfbyte, paramInt2, paramzzdm);
                paramInt2 = paramzzdm.zzabs;
                if (paramInt2 != j) {
                  k = zza(paramInt2, paramArrayOfbyte, i, paramInt3, zzhr1, paramzzdm);
                  i = paramInt2;
                  paramInt2 = k;
                  continue;
                } 
                k = paramInt2;
              } 
              break;
            } 
            if (i <= paramInt3 && k == j) {
              paramzzhr.zzb(paramInt1, zzhr1);
              return i;
            } 
            throw zzfh.zznb();
          case 2:
            paramInt3 = zza(paramArrayOfbyte, paramInt2, paramzzdm);
            paramInt2 = paramzzdm.zzabs;
            if (paramInt2 >= 0) {
              if (paramInt2 <= paramArrayOfbyte.length - paramInt3) {
                if (paramInt2 == 0) {
                  paramzzhr.zzb(paramInt1, zzdp.zzaby);
                } else {
                  paramzzhr.zzb(paramInt1, zzdp.zzb(paramArrayOfbyte, paramInt3, paramInt2));
                } 
                return paramInt3 + paramInt2;
              } 
              throw zzfh.zzmu();
            } 
            throw zzfh.zzmv();
          case 1:
            paramzzhr.zzb(paramInt1, Long.valueOf(zzb(paramArrayOfbyte, paramInt2)));
            return paramInt2 + 8;
          case 0:
            break;
        } 
        paramInt2 = zzb(paramArrayOfbyte, paramInt2, paramzzdm);
        paramzzhr.zzb(paramInt1, Long.valueOf(paramzzdm.zzabt));
        return paramInt2;
      } 
      paramzzhr.zzb(paramInt1, Integer.valueOf(zza(paramArrayOfbyte, paramInt2)));
      return paramInt2 + 4;
    } 
    throw zzfh.zzmx();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, zzdm paramzzdm) {
    paramInt1 &= 0x7F;
    int i = paramInt2 + 1;
    paramInt2 = paramArrayOfbyte[paramInt2];
    if (paramInt2 >= 0) {
      paramzzdm.zzabs = paramInt1 | paramInt2 << 7;
      return i;
    } 
    paramInt2 = paramInt1 | (paramInt2 & 0x7F) << 7;
    paramInt1 = i + 1;
    i = paramArrayOfbyte[i];
    if (i >= 0) {
      paramzzdm.zzabs = paramInt2 | i << 14;
      return paramInt1;
    } 
    i = paramInt2 | (i & 0x7F) << 14;
    paramInt2 = paramInt1 + 1;
    paramInt1 = paramArrayOfbyte[paramInt1];
    if (paramInt1 >= 0) {
      paramzzdm.zzabs = i | paramInt1 << 21;
      return paramInt2;
    } 
    i |= (paramInt1 & 0x7F) << 21;
    paramInt1 = paramInt2 + 1;
    byte b = paramArrayOfbyte[paramInt2];
    if (b >= 0) {
      paramzzdm.zzabs = i | b << 28;
      return paramInt1;
    } 
    while (true) {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfbyte[paramInt1] >= 0) {
        paramzzdm.zzabs = i | (b & Byte.MAX_VALUE) << 28;
        return paramInt2;
      } 
      paramInt1 = paramInt2;
    } 
  }
  
  static int zza(zzgy<?> paramzzgy, int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, zzfg<?> paramzzfg, zzdm paramzzdm) throws IOException {
    paramInt2 = zza(paramzzgy, paramArrayOfbyte, paramInt2, paramInt3, paramzzdm);
    paramzzfg.add(paramzzdm.zzabu);
    while (paramInt2 < paramInt3) {
      int i = zza(paramArrayOfbyte, paramInt2, paramzzdm);
      if (paramInt1 == paramzzdm.zzabs) {
        paramInt2 = zza(paramzzgy, paramArrayOfbyte, i, paramInt3, paramzzdm);
        paramzzfg.add(paramzzdm.zzabu);
      } 
    } 
    return paramInt2;
  }
  
  static int zza(zzgy<Object> paramzzgy, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, zzdm paramzzdm) throws IOException {
    paramzzgy = paramzzgy;
    Object object = paramzzgy.newInstance();
    paramInt1 = paramzzgy.zza(object, paramArrayOfbyte, paramInt1, paramInt2, paramInt3, paramzzdm);
    paramzzgy.zzi(object);
    paramzzdm.zzabu = object;
    return paramInt1;
  }
  
  static int zza(zzgy<Object> paramzzgy, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, zzdm paramzzdm) throws IOException {
    int i = paramInt1 + 1;
    int j = paramArrayOfbyte[paramInt1];
    if (j < 0) {
      paramInt1 = zza(j, paramArrayOfbyte, i, paramzzdm);
      j = paramzzdm.zzabs;
    } else {
      paramInt1 = i;
    } 
    if (j >= 0 && j <= paramInt2 - paramInt1) {
      Object object = paramzzgy.newInstance();
      paramInt2 = j + paramInt1;
      paramzzgy.zza(object, paramArrayOfbyte, paramInt1, paramInt2, paramzzdm);
      paramzzgy.zzi(object);
      paramzzdm.zzabu = object;
      return paramInt2;
    } 
    throw zzfh.zzmu();
  }
  
  static int zza(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
  
  static int zza(byte[] paramArrayOfbyte, int paramInt, zzdm paramzzdm) {
    int i = paramInt + 1;
    paramInt = paramArrayOfbyte[paramInt];
    if (paramInt >= 0) {
      paramzzdm.zzabs = paramInt;
      return i;
    } 
    return zza(paramInt, paramArrayOfbyte, i, paramzzdm);
  }
  
  static int zza(byte[] paramArrayOfbyte, int paramInt, zzfg<?> paramzzfg, zzdm paramzzdm) throws IOException {
    paramzzfg = paramzzfg;
    paramInt = zza(paramArrayOfbyte, paramInt, paramzzdm);
    int i = paramzzdm.zzabs + paramInt;
    while (paramInt < i) {
      paramInt = zza(paramArrayOfbyte, paramInt, paramzzdm);
      paramzzfg.zzau(paramzzdm.zzabs);
    } 
    if (paramInt == i)
      return paramInt; 
    throw zzfh.zzmu();
  }
  
  static int zzb(byte[] paramArrayOfbyte, int paramInt, zzdm paramzzdm) {
    int i = paramInt + 1;
    long l = paramArrayOfbyte[paramInt];
    if (l >= 0L) {
      paramzzdm.zzabt = l;
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
    paramzzdm.zzabt = l;
    return paramInt;
  }
  
  static long zzb(byte[] paramArrayOfbyte, int paramInt) {
    long l1 = paramArrayOfbyte[paramInt];
    long l2 = paramArrayOfbyte[paramInt + 1];
    long l3 = paramArrayOfbyte[paramInt + 2];
    long l4 = paramArrayOfbyte[paramInt + 3];
    long l5 = paramArrayOfbyte[paramInt + 4];
    long l6 = paramArrayOfbyte[paramInt + 5];
    long l7 = paramArrayOfbyte[paramInt + 6];
    return (paramArrayOfbyte[paramInt + 7] & 0xFFL) << 56L | l1 & 0xFFL | (l2 & 0xFFL) << 8L | (l3 & 0xFFL) << 16L | (l4 & 0xFFL) << 24L | (l5 & 0xFFL) << 32L | (l6 & 0xFFL) << 40L | (l7 & 0xFFL) << 48L;
  }
  
  static double zzc(byte[] paramArrayOfbyte, int paramInt) {
    return Double.longBitsToDouble(zzb(paramArrayOfbyte, paramInt));
  }
  
  static int zzc(byte[] paramArrayOfbyte, int paramInt, zzdm paramzzdm) throws zzfh {
    paramInt = zza(paramArrayOfbyte, paramInt, paramzzdm);
    int i = paramzzdm.zzabs;
    if (i >= 0) {
      if (i == 0) {
        paramzzdm.zzabu = "";
        return paramInt;
      } 
      paramzzdm.zzabu = new String(paramArrayOfbyte, paramInt, i, zzfb.UTF_8);
      return paramInt + i;
    } 
    throw zzfh.zzmv();
  }
  
  static float zzd(byte[] paramArrayOfbyte, int paramInt) {
    return Float.intBitsToFloat(zza(paramArrayOfbyte, paramInt));
  }
  
  static int zzd(byte[] paramArrayOfbyte, int paramInt, zzdm paramzzdm) throws zzfh {
    int i = zza(paramArrayOfbyte, paramInt, paramzzdm);
    paramInt = paramzzdm.zzabs;
    if (paramInt >= 0) {
      if (paramInt == 0) {
        paramzzdm.zzabu = "";
        return i;
      } 
      paramzzdm.zzabu = zzhy.zzh(paramArrayOfbyte, i, paramInt);
      return i + paramInt;
    } 
    throw zzfh.zzmv();
  }
  
  static int zze(byte[] paramArrayOfbyte, int paramInt, zzdm paramzzdm) throws zzfh {
    int i = zza(paramArrayOfbyte, paramInt, paramzzdm);
    paramInt = paramzzdm.zzabs;
    if (paramInt >= 0) {
      if (paramInt <= paramArrayOfbyte.length - i) {
        if (paramInt == 0) {
          paramzzdm.zzabu = zzdp.zzaby;
          return i;
        } 
        paramzzdm.zzabu = zzdp.zzb(paramArrayOfbyte, i, paramInt);
        return i + paramInt;
      } 
      throw zzfh.zzmu();
    } 
    throw zzfh.zzmv();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */