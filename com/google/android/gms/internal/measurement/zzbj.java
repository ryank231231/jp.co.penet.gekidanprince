package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbj extends zzaa.zza {
  zzbj(zzaa.zzd paramzzd, Activity paramActivity) {
    super(paramzzd.zzar);
  }
  
  final void zzl() throws RemoteException {
    zzaa.zzc(this.zzbx.zzar).onActivitySaveInstanceState(ObjectWrapper.wrap(activity), this.zzaw, this.zzbs);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */