package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzet implements Runnable {
  zzet(zzeg paramzzeg, boolean paramBoolean1, boolean paramBoolean2, zzr paramzzr1, zzm paramzzm, zzr paramzzr2) {}
  
  public final void run() {
    zzam zzam = zzeg.zzd(this.zzqq);
    if (zzam == null) {
      this.zzqq.zzad().zzda().zzaq("Discarding data. Failed to send conditional user property to service");
      return;
    } 
    if (this.zzqt) {
      zzr zzr1;
      zzeg zzeg1 = this.zzqq;
      if (this.zzqr) {
        zzr1 = null;
      } else {
        zzr1 = this.zzqu;
      } 
      zzeg1.zza(zzam, zzr1, this.zzos);
    } else {
      try {
        if (TextUtils.isEmpty(this.zzqv.packageName)) {
          zzam.zza(this.zzqu, this.zzos);
        } else {
          zzam.zzb(this.zzqu);
        } 
      } catch (RemoteException remoteException) {
        this.zzqq.zzad().zzda().zza("Failed to send conditional user property to the service", remoteException);
      } 
    } 
    zzeg.zze(this.zzqq);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */