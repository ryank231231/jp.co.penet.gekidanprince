package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IInterface;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

@Deprecated
public abstract class LegacyInternalGmsClient<T extends IInterface> extends GmsClient<T> {
  private final GmsClientEventManager zagr;
  
  public LegacyInternalGmsClient(Context paramContext, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramContext.getMainLooper(), paramInt, paramClientSettings);
    this.zagr = new GmsClientEventManager(paramContext.getMainLooper(), this);
    this.zagr.registerConnectionCallbacks(paramConnectionCallbacks);
    this.zagr.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void checkAvailabilityAndConnect() {
    this.zagr.enableCallbacks();
    super.checkAvailabilityAndConnect();
  }
  
  public void disconnect() {
    this.zagr.disableCallbacks();
    super.disconnect();
  }
  
  public int getMinApkVersion() {
    return super.getMinApkVersion();
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    return this.zagr.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    return this.zagr.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void onConnectedLocked(@NonNull T paramT) {
    super.onConnectedLocked(paramT);
    this.zagr.onConnectionSuccess(getConnectionHint());
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult) {
    super.onConnectionFailed(paramConnectionResult);
    this.zagr.onConnectionFailure(paramConnectionResult);
  }
  
  public void onConnectionSuspended(int paramInt) {
    super.onConnectionSuspended(paramInt);
    this.zagr.onUnintentionalDisconnection(paramInt);
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    this.zagr.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zagr.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    this.zagr.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zagr.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\LegacyInternalGmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */