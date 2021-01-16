package com.google.firebase.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

@Deprecated
@KeepForSdk
public interface InternalTokenProvider {
  @KeepForSdk
  Task<GetTokenResult> getAccessToken(boolean paramBoolean);
  
  @Nullable
  @KeepForSdk
  String getUid();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\internal\InternalTokenProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */