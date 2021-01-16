package com.google.android.gms.internal.clearcut;

final class zzec implements zzdm {
  private final String info;
  
  private final zzdo zzmn;
  
  private final zzed zzng;
  
  zzec(zzdo paramzzdo, String paramString, Object[] paramArrayOfObject) {
    this.zzmn = paramzzdo;
    this.info = paramString;
    this.zzng = new zzed(paramzzdo.getClass(), paramString, paramArrayOfObject);
  }
  
  public final int getFieldCount() {
    return zzed.zzd(this.zzng);
  }
  
  public final int zzcf() {
    return ((zzed.zza(this.zzng) & 0x1) == 1) ? zzcg.zzg.zzkl : zzcg.zzg.zzkm;
  }
  
  public final boolean zzcg() {
    return ((zzed.zza(this.zzng) & 0x2) == 2);
  }
  
  public final zzdo zzch() {
    return this.zzmn;
  }
  
  final zzed zzco() {
    return this.zzng;
  }
  
  public final int zzcp() {
    return zzed.zzb(this.zzng);
  }
  
  public final int zzcq() {
    return zzed.zzc(this.zzng);
  }
  
  public final int zzcr() {
    return zzed.zze(this.zzng);
  }
  
  public final int zzcs() {
    return zzed.zzf(this.zzng);
  }
  
  final int[] zzct() {
    return zzed.zzg(this.zzng);
  }
  
  public final int zzcu() {
    return zzed.zzh(this.zzng);
  }
  
  public final int zzcv() {
    return zzed.zzi(this.zzng);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */