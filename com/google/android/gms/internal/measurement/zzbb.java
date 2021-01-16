package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzbb extends zzaa.zza {
  zzbb(zzaa paramzzaa, Long paramLong, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramzzaa);
  }
  
  final void zzl() throws RemoteException {
    long l;
    Long long_ = this.zzbm;
    if (long_ == null) {
      l = this.timestamp;
    } else {
      l = long_.longValue();
    } 
    zzaa.zzc(this.zzar).logEvent(this.zzao, this.zzbn, this.zzbo, this.zzbp, this.zzbq, l);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */