package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public class SimpleClientAdapter<T extends IInterface> extends GmsClient<T> {
  private final Api.SimpleClient<T> zapf;
  
  public SimpleClientAdapter(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings, Api.SimpleClient<T> paramSimpleClient) {
    super(paramContext, paramLooper, paramInt, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zapf = paramSimpleClient;
  }
  
  protected T createServiceInterface(IBinder paramIBinder) {
    return (T)this.zapf.createServiceInterface(paramIBinder);
  }
  
  public Api.SimpleClient<T> getClient() {
    return this.zapf;
  }
  
  public int getMinApkVersion() {
    return super.getMinApkVersion();
  }
  
  protected String getServiceDescriptor() {
    return this.zapf.getServiceDescriptor();
  }
  
  protected String getStartServiceAction() {
    return this.zapf.getStartServiceAction();
  }
  
  protected void onSetConnectState(int paramInt, T paramT) {
    this.zapf.setState(paramInt, (IInterface)paramT);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\SimpleClientAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */