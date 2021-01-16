package com.google.android.gms.internal.clearcut;

final class zzdd implements zzeg {
  private static final zzdn zzlz = new zzde();
  
  private final zzdn zzly;
  
  public zzdd() {
    this(new zzdf(new zzdn[] { zzcf.zzay(), zzby() }));
  }
  
  private zzdd(zzdn paramzzdn) {
    this.zzly = zzci.<zzdn>zza(paramzzdn, "messageInfoFactory");
  }
  
  private static boolean zza(zzdm paramzzdm) {
    return (paramzzdm.zzcf() == zzcg.zzg.zzkl);
  }
  
  private static zzdn zzby() {
    try {
      return (zzdn)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      return zzlz;
    } 
  }
  
  public final <T> zzef<T> zzd(Class<T> paramClass) {
    zzeh.zzf(paramClass);
    zzdm zzdm = this.zzly.zzb(paramClass);
    return (zzef<T>)(zzdm.zzcg() ? (zzcg.class.isAssignableFrom(paramClass) ? zzdu.zza(zzeh.zzdo(), zzbx.zzap(), zzdm.zzch()) : zzdu.zza(zzeh.zzdm(), zzbx.zzaq(), zzdm.zzch())) : (zzcg.class.isAssignableFrom(paramClass) ? (zza(zzdm) ? zzds.zza(paramClass, zzdm, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), zzbx.zzap(), zzdl.zzcd()) : zzds.zza(paramClass, zzdm, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), (zzbu<?>)null, zzdl.zzcd())) : (zza(zzdm) ? zzds.zza(paramClass, zzdm, zzdy.zzcj(), zzcy.zzbv(), zzeh.zzdm(), zzbx.zzaq(), zzdl.zzcc()) : zzds.zza(paramClass, zzdm, zzdy.zzcj(), zzcy.zzbv(), zzeh.zzdn(), (zzbu<?>)null, zzdl.zzcc()))));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */