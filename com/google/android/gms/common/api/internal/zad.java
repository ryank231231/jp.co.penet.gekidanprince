package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T> extends zac {
  protected final TaskCompletionSource<T> zacm;
  
  public zad(int paramInt, TaskCompletionSource<T> paramTaskCompletionSource) {
    super(paramInt);
    this.zacm = paramTaskCompletionSource;
  }
  
  public void zaa(@NonNull Status paramStatus) {
    this.zacm.trySetException((Exception)new ApiException(paramStatus));
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException {
    try {
      zad(paramzaa);
      return;
    } catch (DeadObjectException deadObjectException) {
      super.zaa(zab.zab((RemoteException)deadObjectException));
      throw deadObjectException;
    } catch (RemoteException remoteException) {
      super.zaa(zab.zab(remoteException));
      return;
    } catch (RuntimeException runtimeException) {
      super.zaa(runtimeException);
      return;
    } 
  }
  
  public void zaa(@NonNull zaab paramzaab, boolean paramBoolean) {}
  
  public void zaa(@NonNull RuntimeException paramRuntimeException) {
    this.zacm.trySetException(paramRuntimeException);
  }
  
  protected abstract void zad(GoogleApiManager.zaa<?> paramzaa) throws RemoteException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */