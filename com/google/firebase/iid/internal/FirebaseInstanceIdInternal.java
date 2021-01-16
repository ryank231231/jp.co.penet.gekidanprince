package com.google.firebase.iid.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface FirebaseInstanceIdInternal {
  @KeepForSdk
  String getId();
  
  @Nullable
  @KeepForSdk
  String getToken();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\internal\FirebaseInstanceIdInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */