package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzek implements Runnable {
  zzek(zzeg paramzzeg, zzm paramzzm) {}
  
  public final void run() {
    zzam zzam = zzeg.zzd(this.zzqq);
    if (zzam == null) {
      this.zzqq.zzad().zzda().zzaq("Failed to reset data on the service; null service");
      return;
    } 
    try {
      zzam.zzd(this.zzos);
    } catch (RemoteException remoteException) {
      this.zzqq.zzad().zzda().zza("Failed to reset data on the service", remoteException);
    } 
    zzeg.zze(this.zzqq);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */