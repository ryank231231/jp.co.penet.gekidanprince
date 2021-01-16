package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zag implements BaseGmsClient.BaseOnConnectionFailedListener {
  zag(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {}
  
  public final void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult) {
    this.zaoj.onConnectionFailed(paramConnectionResult);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */