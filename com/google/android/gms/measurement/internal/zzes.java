package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzes implements Runnable {
  zzes(zzeg paramzzeg, boolean paramBoolean1, boolean paramBoolean2, zzaj paramzzaj, zzm paramzzm, String paramString) {}
  
  public final void run() {
    zzam zzam = zzeg.zzd(this.zzqq);
    if (zzam == null) {
      this.zzqq.zzad().zzda().zzaq("Discarding data. Failed to send event to service");
      return;
    } 
    if (this.zzqt) {
      zzaj zzaj1;
      zzeg zzeg1 = this.zzqq;
      if (this.zzqr) {
        zzaj1 = null;
      } else {
        zzaj1 = this.zzdj;
      } 
      zzeg1.zza(zzam, zzaj1, this.zzos);
    } else {
      try {
        if (TextUtils.isEmpty(this.zzdk)) {
          zzam.zza(this.zzdj, this.zzos);
        } else {
          zzam.zza(this.zzdj, this.zzdk, this.zzqq.zzad().zzdk());
        } 
      } catch (RemoteException remoteException) {
        this.zzqq.zzad().zzda().zza("Failed to send event to the service", remoteException);
      } 
    } 
    zzeg.zze(this.zzqq);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */