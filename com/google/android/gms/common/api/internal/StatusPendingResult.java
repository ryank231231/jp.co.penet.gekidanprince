package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class StatusPendingResult extends BasePendingResult<Status> {
  @Deprecated
  public StatusPendingResult(Looper paramLooper) {
    super(paramLooper);
  }
  
  public StatusPendingResult(GoogleApiClient paramGoogleApiClient) {
    super(paramGoogleApiClient);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\StatusPendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */