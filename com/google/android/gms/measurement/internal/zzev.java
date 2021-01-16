package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzq;
import java.util.ArrayList;

final class zzev implements Runnable {
  zzev(zzeg paramzzeg, String paramString1, String paramString2, zzm paramzzm, zzq paramzzq) {}
  
  public final void run() {
    ArrayList<Bundle> arrayList1 = new ArrayList();
    ArrayList<Bundle> arrayList2 = arrayList1;
    ArrayList<Bundle> arrayList3 = arrayList1;
    try {
      zzam zzam = zzeg.zzd(this.zzqq);
      if (zzam == null) {
        arrayList2 = arrayList1;
        arrayList3 = arrayList1;
        this.zzqq.zzad().zzda().zza("Failed to get conditional properties", this.zzao, this.zzav);
        this.zzqq.zzab().zza(this.zzdh, arrayList1);
        return;
      } 
      arrayList2 = arrayList1;
      arrayList3 = arrayList1;
      arrayList1 = zzgd.zzc(zzam.zza(this.zzao, this.zzav, this.zzos));
      arrayList2 = arrayList1;
      arrayList3 = arrayList1;
      zzeg.zze(this.zzqq);
      this.zzqq.zzab().zza(this.zzdh, arrayList1);
      return;
    } catch (RemoteException remoteException) {
      arrayList2 = arrayList3;
      this.zzqq.zzad().zzda().zza("Failed to get conditional properties", this.zzao, this.zzav, remoteException);
      this.zzqq.zzab().zza(this.zzdh, arrayList3);
      return;
    } finally {}
    this.zzqq.zzab().zza(this.zzdh, arrayList2);
    throw arrayList3;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */