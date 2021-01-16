package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class zzhq<T, B> {
  abstract void zza(B paramB, int paramInt, long paramLong);
  
  abstract void zza(B paramB, int paramInt, zzdp paramzzdp);
  
  abstract void zza(B paramB, int paramInt, T paramT);
  
  abstract void zza(T paramT, zzil paramzzil) throws IOException;
  
  abstract boolean zza(zzgx paramzzgx);
  
  final boolean zza(B paramB, zzgx paramzzgx) throws IOException {
    B b;
    int i = paramzzgx.getTag();
    int j = i >>> 3;
    switch (i & 0x7) {
      default:
        throw zzfh.zzmz();
      case 5:
        zzc(paramB, j, paramzzgx.zzko());
        return true;
      case 4:
        return false;
      case 3:
        b = zzoq();
        do {
        
        } while (paramzzgx.zzlh() != Integer.MAX_VALUE && zza(b, paramzzgx));
        if ((j << 3 | 0x4) == paramzzgx.getTag()) {
          zza(paramB, j, zzp(b));
          return true;
        } 
        throw zzfh.zzmy();
      case 2:
        zza(paramB, j, paramzzgx.zzkr());
        return true;
      case 1:
        zzb(paramB, j, paramzzgx.zzkn());
        return true;
      case 0:
        break;
    } 
    zza(paramB, j, paramzzgx.zzkl());
    return true;
  }
  
  abstract void zzb(B paramB, int paramInt, long paramLong);
  
  abstract void zzc(B paramB, int paramInt1, int paramInt2);
  
  abstract void zzc(T paramT, zzil paramzzil) throws IOException;
  
  abstract void zze(Object paramObject, T paramT);
  
  abstract void zzf(Object paramObject, B paramB);
  
  abstract T zzg(T paramT1, T paramT2);
  
  abstract void zzi(Object paramObject);
  
  abstract B zzoq();
  
  abstract T zzp(B paramB);
  
  abstract int zzs(T paramT);
  
  abstract T zzw(Object paramObject);
  
  abstract B zzx(Object paramObject);
  
  abstract int zzy(T paramT);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */