package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.measurement.internal.zzdb;

final class zzax extends zzaa.zza {
  zzax(zzaa paramzzaa, zzdb paramzzdb) {
    super(paramzzaa);
  }
  
  final void zzl() throws RemoteException {
    if (zzaa.zzd(this.zzar).containsKey(this.zzbk)) {
      Log.w(zzaa.zzb(this.zzar), "OnEventListener already registered.");
      return;
    } 
    zzaa.zzc zzc = new zzaa.zzc(this.zzbk);
    zzaa.zzd(this.zzar).put(this.zzbk, zzc);
    zzaa.zzc(this.zzar).registerOnMeasurementEventListener(zzc);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */