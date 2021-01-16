package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;

final class zaf implements BaseGmsClient.BaseConnectionCallbacks {
  zaf(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {}
  
  public final void onConnected(@Nullable Bundle paramBundle) {
    this.zaoi.onConnected(paramBundle);
  }
  
  public final void onConnectionSuspended(int paramInt) {
    this.zaoi.onConnectionSuspended(paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */