package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzgd implements zzgc {
  public final int zzb(int paramInt, Object paramObject1, Object paramObject2) {
    paramObject1 = paramObject1;
    if (paramObject1.isEmpty())
      return 0; 
    paramObject1 = paramObject1.entrySet().iterator();
    if (!paramObject1.hasNext())
      return 0; 
    paramObject1 = paramObject1.next();
    paramObject1.getKey();
    paramObject1.getValue();
    throw new NoSuchMethodError();
  }
  
  public final Object zzb(Object paramObject1, Object paramObject2) {
    zzgb zzgb = (zzgb)paramObject1;
    paramObject2 = paramObject2;
    paramObject1 = zzgb;
    if (!paramObject2.isEmpty()) {
      paramObject1 = zzgb;
      if (!zzgb.isMutable())
        paramObject1 = zzgb.zznn(); 
      paramObject1.zza((zzgb)paramObject2);
    } 
    return paramObject1;
  }
  
  public final Map<?, ?> zzm(Object paramObject) {
    return (zzgb)paramObject;
  }
  
  public final Map<?, ?> zzn(Object paramObject) {
    return (zzgb)paramObject;
  }
  
  public final boolean zzo(Object paramObject) {
    return !((zzgb)paramObject).isMutable();
  }
  
  public final Object zzp(Object paramObject) {
    ((zzgb)paramObject).zzjz();
    return paramObject;
  }
  
  public final Object zzq(Object paramObject) {
    return zzgb.zznm().zznn();
  }
  
  public final zzga<?, ?> zzr(Object paramObject) {
    throw new NoSuchMethodError();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */