package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbi extends zzaa.zza {
  zzbi(zzaa.zzd paramzzd) {
    super(paramzzd.zzar);
  }
  
  final void zzl() throws RemoteException {
    zzaa.zzc(this.zzbx.zzar).onActivityStopped(ObjectWrapper.wrap(activity), this.zzbs);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */