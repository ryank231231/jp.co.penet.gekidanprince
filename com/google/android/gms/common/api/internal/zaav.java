package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Iterator;

public final class zaav implements zabd {
  private final zabe zafs;
  
  public zaav(zabe paramzabe) {
    this.zafs = paramzabe;
  }
  
  public final void begin() {
    Iterator<Api.Client> iterator = this.zafs.zagy.values().iterator();
    while (iterator.hasNext())
      ((Api.Client)iterator.next()).disconnect(); 
    this.zafs.zaed.zagz = Collections.emptySet();
  }
  
  public final void connect() {
    this.zafs.zaaz();
  }
  
  public final boolean disconnect() {
    return true;
  }
  
  public final <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT) {
    this.zafs.zaed.zafb.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T execute(T paramT) {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt) {}
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */