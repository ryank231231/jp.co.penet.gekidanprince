package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface RemoteCall<T, U> {
  @KeepForSdk
  void accept(T paramT, U paramU) throws RemoteException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\RemoteCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */