package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzer implements Runnable {
  zzer(zzeg paramzzeg, zzm paramzzm) {}
  
  public final void run() {
    zzam zzam = zzeg.zzd(this.zzqq);
    if (zzam == null) {
      this.zzqq.zzad().zzda().zzaq("Failed to send measurementEnabled to service");
      return;
    } 
    try {
      zzam.zzb(this.zzos);
      zzeg.zze(this.zzqq);
      return;
    } catch (RemoteException remoteException) {
      this.zzqq.zzad().zzda().zza("Failed to send measurementEnabled to the service", remoteException);
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */