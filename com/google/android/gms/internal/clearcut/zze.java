package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zze extends GoogleApi<Api.ApiOptions.NoOptions> implements zzb {
  @VisibleForTesting
  private zze(@NonNull Context paramContext) {
    super(paramContext, ClearcutLogger.API, null, (StatusExceptionMapper)new ApiExceptionMapper());
  }
  
  public static zzb zzb(@NonNull Context paramContext) {
    return new zze(paramContext);
  }
  
  public final PendingResult<Status> zzb(com.google.android.gms.clearcut.zze paramzze) {
    return (PendingResult<Status>)doBestEffortWrite(new zzh(paramzze, asGoogleApiClient()));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */