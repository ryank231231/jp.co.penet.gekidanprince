package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbc extends zzaa.zza {
  zzbc(zzaa paramzzaa, String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
    super(paramzzaa);
  }
  
  final void zzl() throws RemoteException {
    zzaa.zzc(this.zzar).setUserProperty(this.zzao, this.zzbn, ObjectWrapper.wrap(this.zzbr), this.zzbp, this.timestamp);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */