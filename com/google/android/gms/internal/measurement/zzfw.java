package com.google.android.gms.internal.measurement;

final class zzfw implements zzgz {
  private static final zzgg zzaiq = new zzfx();
  
  private final zzgg zzaip;
  
  public zzfw() {
    this(new zzfy(new zzgg[] { zzey.zzmf(), zznl() }));
  }
  
  private zzfw(zzgg paramzzgg) {
    this.zzaip = zzfb.<zzgg>zza(paramzzgg, "messageInfoFactory");
  }
  
  private static boolean zza(zzgf paramzzgf) {
    return (paramzzgf.zzns() == zzez.zze.zzahc);
  }
  
  private static zzgg zznl() {
    try {
      return (zzgg)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      return zzaiq;
    } 
  }
  
  public final <T> zzgy<T> zze(Class<T> paramClass) {
    zzha.zzg(paramClass);
    zzgf zzgf = this.zzaip.zzc(paramClass);
    return (zzgy<T>)(zzgf.zznt() ? (zzez.class.isAssignableFrom(paramClass) ? zzgn.zza(zzha.zzof(), zzep.zzlv(), zzgf.zznu()) : zzgn.zza(zzha.zzod(), zzep.zzlw(), zzgf.zznu())) : (zzez.class.isAssignableFrom(paramClass) ? (zza(zzgf) ? zzgl.zza(paramClass, zzgf, zzgr.zznx(), zzfr.zznj(), zzha.zzof(), zzep.zzlv(), zzge.zznq()) : zzgl.zza(paramClass, zzgf, zzgr.zznx(), zzfr.zznj(), zzha.zzof(), (zzen<?>)null, zzge.zznq())) : (zza(zzgf) ? zzgl.zza(paramClass, zzgf, zzgr.zznw(), zzfr.zzni(), zzha.zzod(), zzep.zzlw(), zzge.zznp()) : zzgl.zza(paramClass, zzgf, zzgr.zznw(), zzfr.zzni(), zzha.zzoe(), (zzen<?>)null, zzge.zznp()))));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */