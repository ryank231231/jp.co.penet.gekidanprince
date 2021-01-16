package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzda;

final class zzam extends zzaa.zza {
  zzam(zzaa paramzzaa, zzda paramzzda) {
    super(paramzzaa);
  }
  
  final void zzl() throws RemoteException {
    zzaa.zzc(this.zzar).setEventInterceptor(new zzaa.zzb(this.zzbc));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */