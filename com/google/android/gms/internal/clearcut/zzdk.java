package com.google.android.gms.internal.clearcut;

import java.util.Map;

final class zzdk implements zzdj {
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
    zzdi zzdi = (zzdi)paramObject1;
    paramObject2 = paramObject2;
    paramObject1 = zzdi;
    if (!paramObject2.isEmpty()) {
      paramObject1 = zzdi;
      if (!zzdi.isMutable())
        paramObject1 = zzdi.zzca(); 
      paramObject1.zza((zzdi)paramObject2);
    } 
    return paramObject1;
  }
  
  public final Map<?, ?> zzg(Object paramObject) {
    return (zzdi)paramObject;
  }
  
  public final Map<?, ?> zzh(Object paramObject) {
    return (zzdi)paramObject;
  }
  
  public final boolean zzi(Object paramObject) {
    return !((zzdi)paramObject).isMutable();
  }
  
  public final Object zzj(Object paramObject) {
    ((zzdi)paramObject).zzv();
    return paramObject;
  }
  
  public final Object zzk(Object paramObject) {
    return zzdi.zzbz().zzca();
  }
  
  public final zzdh<?, ?> zzl(Object paramObject) {
    throw new NoSuchMethodError();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */