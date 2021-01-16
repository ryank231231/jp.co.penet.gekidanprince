package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {
  private final ListenerHolder.ListenerKey<L> zajk;
  
  @KeepForSdk
  protected UnregisterListenerMethod(ListenerHolder.ListenerKey<L> paramListenerKey) {
    this.zajk = paramListenerKey;
  }
  
  @KeepForSdk
  public ListenerHolder.ListenerKey<L> getListenerKey() {
    return this.zajk;
  }
  
  @KeepForSdk
  protected abstract void unregisterListener(A paramA, TaskCompletionSource<Boolean> paramTaskCompletionSource) throws RemoteException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\UnregisterListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */