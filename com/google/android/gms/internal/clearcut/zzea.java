package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzea {
  private static final zzea zznc = new zzea();
  
  private final zzeg zznd;
  
  private final ConcurrentMap<Class<?>, zzef<?>> zzne = new ConcurrentHashMap<Class<?>, zzef<?>>();
  
  private zzea() {
    zzeg zzeg1 = null;
    byte b = 0;
    while (b) {
      (new String[1])[0] = "com.google.protobuf.AndroidProto3SchemaFactory";
      zzeg zzeg3 = zzk((new String[1])[0]);
      zzeg1 = zzeg3;
      if (zzeg3 == null) {
        b++;
        zzeg1 = zzeg3;
      } 
    } 
    zzeg zzeg2 = zzeg1;
    if (zzeg1 == null)
      zzeg2 = new zzdd(); 
    this.zznd = zzeg2;
  }
  
  public static zzea zzcm() {
    return zznc;
  }
  
  private static zzeg zzk(String paramString) {
    try {
      return Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  public final <T> zzef<T> zze(Class<T> paramClass) {
    zzci.zza(paramClass, "messageType");
    zzef<T> zzef1 = (zzef)this.zzne.get(paramClass);
    zzef<T> zzef2 = zzef1;
    if (zzef1 == null) {
      zzef2 = this.zznd.zzd(paramClass);
      zzci.zza(paramClass, "messageType");
      zzci.zza(zzef2, "schema");
      zzef<T> zzef = (zzef)this.zzne.putIfAbsent(paramClass, zzef2);
      if (zzef != null)
        zzef2 = zzef; 
    } 
    return zzef2;
  }
  
  public final <T> zzef<T> zzp(T paramT) {
    return zze((Class)paramT.getClass());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */