package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaf extends zad<Void> {
  private final RegisterListenerMethod<Api.AnyClient, ?> zaco;
  
  private final UnregisterListenerMethod<Api.AnyClient, ?> zacp;
  
  public zaf(zabw paramzabw, TaskCompletionSource<Void> paramTaskCompletionSource) {
    super(3, paramTaskCompletionSource);
    this.zaco = paramzabw.zajw;
    this.zacp = paramzabw.zajx;
  }
  
  @Nullable
  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa) {
    return this.zaco.getRequiredFeatures();
  }
  
  public final boolean zac(GoogleApiManager.zaa<?> paramzaa) {
    return this.zaco.shouldAutoResolveMissingFeatures();
  }
  
  public final void zad(GoogleApiManager.zaa<?> paramzaa) throws RemoteException {
    this.zaco.registerListener(paramzaa.zaab(), this.zacm);
    if (this.zaco.getListenerKey() != null)
      paramzaa.zabk().put(this.zaco.getListenerKey(), new zabw(this.zaco, this.zacp)); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */