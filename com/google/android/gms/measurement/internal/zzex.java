package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzq;

final class zzex implements Runnable {
  zzex(zzeg paramzzeg, String paramString1, String paramString2, boolean paramBoolean, zzm paramzzm, zzq paramzzq) {}
  
  public final void run() {
    Bundle bundle1 = new Bundle();
    Bundle bundle2 = bundle1;
    Bundle bundle3 = bundle1;
    try {
      zzam zzam = zzeg.zzd(this.zzqq);
      if (zzam == null) {
        bundle2 = bundle1;
        bundle3 = bundle1;
        this.zzqq.zzad().zzda().zza("Failed to get user properties", this.zzao, this.zzav);
        this.zzqq.zzab().zza(this.zzdh, bundle1);
        return;
      } 
      bundle2 = bundle1;
      bundle3 = bundle1;
      bundle1 = zzgd.zzb(zzam.zza(this.zzao, this.zzav, this.zzbd, this.zzos));
      bundle2 = bundle1;
      bundle3 = bundle1;
      zzeg.zze(this.zzqq);
      this.zzqq.zzab().zza(this.zzdh, bundle1);
      return;
    } catch (RemoteException remoteException) {
      bundle2 = bundle3;
      this.zzqq.zzad().zzda().zza("Failed to get user properties", this.zzao, remoteException);
      this.zzqq.zzab().zza(this.zzdh, bundle3);
      return;
    } finally {}
    this.zzqq.zzab().zza(this.zzdh, bundle2);
    throw bundle3;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */