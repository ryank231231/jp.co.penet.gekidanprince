package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class StatusCallback extends IStatusCallback.Stub {
  @KeepForSdk
  private final BaseImplementation.ResultHolder<Status> mResultHolder;
  
  @KeepForSdk
  public StatusCallback(BaseImplementation.ResultHolder<Status> paramResultHolder) {
    this.mResultHolder = paramResultHolder;
  }
  
  @KeepForSdk
  public void onResult(Status paramStatus) {
    this.mResultHolder.setResult(paramStatus);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\StatusCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */