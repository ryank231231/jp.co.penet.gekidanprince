package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {
  private final DataHolder mDataHolder;
  
  @KeepForSdk
  protected DataHolderNotifier(DataHolder paramDataHolder) {
    this.mDataHolder = paramDataHolder;
  }
  
  @KeepForSdk
  public final void notifyListener(L paramL) {
    notifyListener(paramL, this.mDataHolder);
  }
  
  @KeepForSdk
  protected abstract void notifyListener(L paramL, DataHolder paramDataHolder);
  
  @KeepForSdk
  public void onNotifyListenerFailed() {
    DataHolder dataHolder = this.mDataHolder;
    if (dataHolder != null)
      dataHolder.close(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\DataHolderNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */