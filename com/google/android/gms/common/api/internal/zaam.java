package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

final class zaam implements BaseGmsClient.ConnectionProgressReportCallbacks {
  private final Api<?> mApi;
  
  private final boolean zaeb;
  
  private final WeakReference<zaak> zagj;
  
  public zaam(zaak paramzaak, Api<?> paramApi, boolean paramBoolean) {
    this.zagj = new WeakReference<zaak>(paramzaak);
    this.mApi = paramApi;
    this.zaeb = paramBoolean;
  }
  
  public final void onReportServiceBinding(@NonNull ConnectionResult paramConnectionResult) {
    boolean bool;
    zaak zaak = this.zagj.get();
    if (zaak == null)
      return; 
    if (Looper.myLooper() == (zaak.zad(zaak)).zaed.getLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zaak.zac(zaak).lock();
    try {
      bool = zaak.zaa(zaak, 0);
      if (!bool)
        return; 
      if (!paramConnectionResult.isSuccess())
        zaak.zaa(zaak, paramConnectionResult, this.mApi, this.zaeb); 
      if (zaak.zak(zaak))
        zaak.zaj(zaak); 
      return;
    } finally {
      zaak.zac(zaak).unlock();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */