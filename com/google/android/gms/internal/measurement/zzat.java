package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzat extends zzaa.zza {
  zzat(zzaa paramzzaa, boolean paramBoolean, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    super(paramzzaa, false);
  }
  
  final void zzl() throws RemoteException {
    zzaa.zzc(this.zzar).logHealthData(this.zzbe, this.zzbf, ObjectWrapper.wrap(this.zzbg), ObjectWrapper.wrap(this.zzbh), ObjectWrapper.wrap(this.zzbi));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */