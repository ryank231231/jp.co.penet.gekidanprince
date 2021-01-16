package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzen implements Runnable {
  zzen(zzeg paramzzeg, zzm paramzzm) {}
  
  public final void run() {
    zzam zzam = zzeg.zzd(this.zzqq);
    if (zzam == null) {
      this.zzqq.zzad().zzda().zzaq("Discarding data. Failed to send app launch");
      return;
    } 
    try {
      zzam.zza(this.zzos);
      this.zzqq.zza(zzam, (AbstractSafeParcelable)null, this.zzos);
      zzeg.zze(this.zzqq);
      return;
    } catch (RemoteException remoteException) {
      this.zzqq.zzad().zzda().zza("Failed to send app launch to the service", remoteException);
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */