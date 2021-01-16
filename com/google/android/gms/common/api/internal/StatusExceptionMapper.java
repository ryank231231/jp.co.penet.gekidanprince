package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public interface StatusExceptionMapper {
  @KeepForSdk
  Exception getException(Status paramStatus);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\StatusExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */