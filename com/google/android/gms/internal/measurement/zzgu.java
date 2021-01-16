package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzgu {
  private static final zzgu zzajt = new zzgu();
  
  private final zzgz zzaju = new zzfw();
  
  private final ConcurrentMap<Class<?>, zzgy<?>> zzajv = new ConcurrentHashMap<Class<?>, zzgy<?>>();
  
  public static zzgu zznz() {
    return zzajt;
  }
  
  public final <T> zzgy<T> zzf(Class<T> paramClass) {
    zzfb.zza(paramClass, "messageType");
    zzgy<T> zzgy1 = (zzgy)this.zzajv.get(paramClass);
    zzgy<T> zzgy2 = zzgy1;
    if (zzgy1 == null) {
      zzgy2 = this.zzaju.zze(paramClass);
      zzfb.zza(paramClass, "messageType");
      zzfb.zza(zzgy2, "schema");
      zzgy<T> zzgy = (zzgy)this.zzajv.putIfAbsent(paramClass, zzgy2);
      if (zzgy != null)
        zzgy2 = zzgy; 
    } 
    return zzgy2;
  }
  
  public final <T> zzgy<T> zzv(T paramT) {
    return zzf((Class)paramT.getClass());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */