package com.google.android.gms.measurement.internal;

final class zzdu implements Runnable {
  zzdu(zzdd paramzzdd, boolean paramBoolean) {}
  
  public final void run() {
    boolean bool1 = this.zzpm.zzl.isEnabled();
    boolean bool2 = this.zzpm.zzl.zzeq();
    this.zzpm.zzl.zza(this.zzaz);
    if (bool2 == this.zzaz)
      this.zzpm.zzl.zzad().zzdi().zza("Default data collection state already set to", Boolean.valueOf(this.zzaz)); 
    if (this.zzpm.zzl.isEnabled() == bool1 || this.zzpm.zzl.isEnabled() != this.zzpm.zzl.zzeq())
      this.zzpm.zzl.zzad().zzdf().zza("Default data collection is different than actual status", Boolean.valueOf(this.zzaz), Boolean.valueOf(bool1)); 
    zzdd.zza(this.zzpm);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */