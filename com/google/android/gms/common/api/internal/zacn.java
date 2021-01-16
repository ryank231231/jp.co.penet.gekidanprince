package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

final class zacn implements Runnable {
  zacn(zacm paramzacm, Result paramResult) {}
  
  @WorkerThread
  public final void run() {
    Exception exception;
    try {
      BasePendingResult.zadm.set(Boolean.valueOf(true));
      PendingResult pendingResult = zacm.zac(this.zakv).onSuccess(this.zaku);
      zacm.zad(this.zakv).sendMessage(zacm.zad(this.zakv).obtainMessage(0, pendingResult));
      BasePendingResult.zadm.set(Boolean.valueOf(false));
      zacm.zaa(this.zakv, this.zaku);
      GoogleApiClient googleApiClient1 = zacm.zae(this.zakv).get();
      if (googleApiClient1 != null)
        googleApiClient1.zab(this.zakv); 
      return;
    } catch (RuntimeException runtimeException) {
      zacm.zad(this.zakv).sendMessage(zacm.zad(this.zakv).obtainMessage(1, runtimeException));
      BasePendingResult.zadm.set(Boolean.valueOf(false));
      zacm.zaa(this.zakv, this.zaku);
      GoogleApiClient googleApiClient1 = zacm.zae(this.zakv).get();
      if (googleApiClient1 != null)
        googleApiClient1.zab(this.zakv); 
      return;
    } finally {}
    BasePendingResult.zadm.set(Boolean.valueOf(false));
    zacm.zaa(this.zakv, this.zaku);
    GoogleApiClient googleApiClient = zacm.zae(this.zakv).get();
    if (googleApiClient != null)
      googleApiClient.zab(this.zakv); 
    throw exception;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zacn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */