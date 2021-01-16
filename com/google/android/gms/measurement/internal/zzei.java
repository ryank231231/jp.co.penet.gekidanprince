package com.google.android.gms.measurement.internal;

final class zzei implements Runnable {
  zzei(zzeg paramzzeg, boolean paramBoolean, zzga paramzzga, zzm paramzzm) {}
  
  public final void run() {
    zzga zzga1;
    zzam zzam = zzeg.zzd(this.zzqq);
    if (zzam == null) {
      this.zzqq.zzad().zzda().zzaq("Discarding data. Failed to set user attribute");
      return;
    } 
    zzeg zzeg1 = this.zzqq;
    if (this.zzqr) {
      zzga1 = null;
    } else {
      zzga1 = this.zzov;
    } 
    zzeg1.zza(zzam, zzga1, this.zzos);
    zzeg.zze(this.zzqq);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */