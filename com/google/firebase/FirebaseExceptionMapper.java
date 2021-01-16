package com.google.firebase;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

@KeepForSdk
public class FirebaseExceptionMapper implements StatusExceptionMapper {
  public Exception getException(Status paramStatus) {
    return (paramStatus.getStatusCode() == 8) ? new FirebaseException(paramStatus.zzg()) : new FirebaseApiNotAvailableException(paramStatus.zzg());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\FirebaseExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */