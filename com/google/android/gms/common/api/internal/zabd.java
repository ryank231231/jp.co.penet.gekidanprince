package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;

public interface zabd {
  void begin();
  
  void connect();
  
  boolean disconnect();
  
  <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT);
  
  <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T execute(T paramT);
  
  void onConnected(Bundle paramBundle);
  
  void onConnectionSuspended(int paramInt);
  
  void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zabd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */