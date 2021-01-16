package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
  private final ListenerHolder<L> zajt;
  
  private final Feature[] zaju;
  
  private final boolean zajv;
  
  @KeepForSdk
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder) {
    this.zajt = paramListenerHolder;
    this.zaju = null;
    this.zajv = false;
  }
  
  @KeepForSdk
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean) {
    this.zajt = paramListenerHolder;
    this.zaju = paramArrayOfFeature;
    this.zajv = paramBoolean;
  }
  
  @KeepForSdk
  public void clearListener() {
    this.zajt.clear();
  }
  
  @KeepForSdk
  public ListenerHolder.ListenerKey<L> getListenerKey() {
    return this.zajt.getListenerKey();
  }
  
  @Nullable
  @KeepForSdk
  public Feature[] getRequiredFeatures() {
    return this.zaju;
  }
  
  @KeepForSdk
  protected abstract void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource) throws RemoteException;
  
  public final boolean shouldAutoResolveMissingFeatures() {
    return this.zajv;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\RegisterListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */