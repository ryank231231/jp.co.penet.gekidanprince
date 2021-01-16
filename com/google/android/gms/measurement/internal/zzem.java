package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzq;

final class zzem implements Runnable {
  zzem(zzeg paramzzeg, zzm paramzzm, zzq paramzzq) {}
  
  public final void run() {
    String str1 = null;
    String str2 = null;
    String str3 = str2;
    String str4 = str1;
    try {
      zzam zzam = zzeg.zzd(this.zzqq);
      if (zzam == null) {
        str3 = str2;
        str4 = str1;
        this.zzqq.zzad().zzda().zzaq("Failed to get app instance id");
        this.zzqq.zzab().zzb(this.zzdh, (String)null);
        return;
      } 
      str3 = str2;
      str4 = str1;
      str2 = zzam.zzc(this.zzos);
      if (str2 != null) {
        str3 = str2;
        str4 = str2;
        this.zzqq.zzs().zzbi(str2);
        str3 = str2;
        str4 = str2;
        (this.zzqq.zzae()).zzli.zzav(str2);
      } 
      str3 = str2;
      str4 = str2;
      zzeg.zze(this.zzqq);
      this.zzqq.zzab().zzb(this.zzdh, str2);
      return;
    } catch (RemoteException remoteException) {
      str3 = str4;
      this.zzqq.zzad().zzda().zza("Failed to get app instance id", remoteException);
      this.zzqq.zzab().zzb(this.zzdh, str4);
      return;
    } finally {}
    this.zzqq.zzab().zzb(this.zzdh, str3);
    throw str4;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */