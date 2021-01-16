package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzaf extends zzaa.zza {
  zzaf(zzaa paramzzaa, Activity paramActivity, String paramString1) {
    super(paramzzaa);
  }
  
  final void zzl() throws RemoteException {
    zzaa.zzc(this.zzar).setCurrentScreen(ObjectWrapper.wrap(activity), this.zzax, this.zzay, this.timestamp);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */