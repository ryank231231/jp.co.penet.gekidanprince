package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzfu extends zzfr {
  private zzfu() {
    super(null);
  }
  
  private static <E> zzfg<E> zzd(Object paramObject, long paramLong) {
    return (zzfg<E>)zzhw.zzp(paramObject, paramLong);
  }
  
  final <L> List<L> zza(Object paramObject, long paramLong) {
    zzfg<?> zzfg1 = zzd(paramObject, paramLong);
    zzfg<?> zzfg2 = zzfg1;
    if (!zzfg1.zzjy()) {
      int i = zzfg1.size();
      if (i == 0) {
        i = 10;
      } else {
        i <<= 1;
      } 
      zzfg2 = zzfg1.zzq(i);
      zzhw.zza(paramObject, paramLong, zzfg2);
    } 
    return (List)zzfg2;
  }
  
  final <E> void zza(Object paramObject1, Object<?> paramObject2, long paramLong) {
    Object<?> object;
    zzfg<?> zzfg1 = zzd(paramObject1, paramLong);
    zzfg<?> zzfg2 = zzd(paramObject2, paramLong);
    int i = zzfg1.size();
    int j = zzfg2.size();
    paramObject2 = (Object<?>)zzfg1;
    if (i > 0) {
      paramObject2 = (Object<?>)zzfg1;
      if (j > 0) {
        paramObject2 = (Object<?>)zzfg1;
        if (!zzfg1.zzjy())
          paramObject2 = (Object<?>)zzfg1.zzq(j + i); 
        paramObject2.addAll(zzfg2);
      } 
    } 
    zzfg1 = zzfg2;
    if (i > 0)
      object = paramObject2; 
    zzhw.zza(paramObject1, paramLong, object);
  }
  
  final void zzb(Object paramObject, long paramLong) {
    zzd(paramObject, paramLong).zzjz();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */