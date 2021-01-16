package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class ApiExceptionUtil {
  @NonNull
  @KeepForSdk
  public static ApiException fromStatus(@NonNull Status paramStatus) {
    return (ApiException)(paramStatus.hasResolution() ? new ResolvableApiException(paramStatus) : new ApiException(paramStatus));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\ApiExceptionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */