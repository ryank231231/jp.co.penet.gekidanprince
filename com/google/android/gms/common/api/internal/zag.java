package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag<ResultT> extends zac {
  private final TaskCompletionSource<ResultT> zacm;
  
  private final TaskApiCall<Api.AnyClient, ResultT> zacq;
  
  private final StatusExceptionMapper zacr;
  
  public zag(int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper) {
    super(paramInt);
    this.zacm = paramTaskCompletionSource;
    this.zacq = paramTaskApiCall;
    this.zacr = paramStatusExceptionMapper;
  }
  
  public final void zaa(@NonNull Status paramStatus) {
    this.zacm.trySetException(this.zacr.getException(paramStatus));
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException {
    try {
      this.zacq.doExecute(paramzaa.zaab(), this.zacm);
      return;
    } catch (DeadObjectException deadObjectException) {
      throw deadObjectException;
    } catch (RemoteException remoteException) {
      super.zaa(zab.zab(remoteException));
      return;
    } catch (RuntimeException runtimeException) {
      super.zaa(runtimeException);
      return;
    } 
  }
  
  public final void zaa(@NonNull zaab paramzaab, boolean paramBoolean) {
    paramzaab.zaa(this.zacm, paramBoolean);
  }
  
  public final void zaa(@NonNull RuntimeException paramRuntimeException) {
    this.zacm.trySetException(paramRuntimeException);
  }
  
  @Nullable
  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa) {
    return this.zacq.zabt();
  }
  
  public final boolean zac(GoogleApiManager.zaa<?> paramzaa) {
    return this.zacq.shouldAutoResolveMissingFeatures();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */