package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.measurement.internal.zzdb;

final class zzba extends zzaa.zza {
  zzba(zzaa paramzzaa, zzdb paramzzdb) {
    super(paramzzaa);
  }
  
  final void zzl() throws RemoteException {
    zzaa.zzc zzc = (zzaa.zzc)zzaa.zzd(this.zzar).get(this.zzbk);
    if (zzc == null) {
      Log.w(zzaa.zzb(this.zzar), "OnEventListener had not been registered.");
      return;
    } 
    zzaa.zzc(this.zzar).unregisterOnMeasurementEventListener(zzc);
    zzaa.zzd(this.zzar).remove(this.zzbk);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */