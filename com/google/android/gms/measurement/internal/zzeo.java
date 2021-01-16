package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzeo implements Runnable {
  zzeo(zzeg paramzzeg, zzec paramzzec) {}
  
  public final void run() {
    zzam zzam = zzeg.zzd(this.zzqq);
    if (zzam == null) {
      this.zzqq.zzad().zzda().zzaq("Failed to send current screen to service");
      return;
    } 
    try {
      if (this.zzqi == null) {
        zzam.zza(0L, (String)null, (String)null, this.zzqq.getContext().getPackageName());
      } else {
        zzam.zza(this.zzqi.zzpw, this.zzqi.zzpu, this.zzqi.zzpv, this.zzqq.getContext().getPackageName());
      } 
      zzeg.zze(this.zzqq);
      return;
    } catch (RemoteException remoteException) {
      this.zzqq.zzad().zzda().zza("Failed to send current screen to the service", remoteException);
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzeo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */