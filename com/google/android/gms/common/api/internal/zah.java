package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah extends zad<Boolean> {
  private final ListenerHolder.ListenerKey<?> zacs;
  
  public zah(ListenerHolder.ListenerKey<?> paramListenerKey, TaskCompletionSource<Boolean> paramTaskCompletionSource) {
    super(4, paramTaskCompletionSource);
    this.zacs = paramListenerKey;
  }
  
  @Nullable
  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa) {
    zabw zabw = paramzaa.zabk().get(this.zacs);
    return (zabw == null) ? null : zabw.zajw.getRequiredFeatures();
  }
  
  public final boolean zac(GoogleApiManager.zaa<?> paramzaa) {
    zabw zabw = paramzaa.zabk().get(this.zacs);
    return (zabw != null && zabw.zajw.shouldAutoResolveMissingFeatures());
  }
  
  public final void zad(GoogleApiManager.zaa<?> paramzaa) throws RemoteException {
    zabw zabw = paramzaa.zabk().remove(this.zacs);
    if (zabw != null) {
      zabw.zajx.unregisterListener(paramzaa.zaab(), this.zacm);
      zabw.zajw.clearListener();
      return;
    } 
    this.zacm.trySetResult(Boolean.valueOf(false));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */