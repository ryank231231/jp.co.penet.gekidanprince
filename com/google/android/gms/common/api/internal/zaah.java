package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import java.util.Iterator;

public final class zaah implements zabd {
  private final zabe zafs;
  
  private boolean zaft = false;
  
  public zaah(zabe paramzabe) {
    this.zafs = paramzabe;
  }
  
  public final void begin() {}
  
  public final void connect() {
    if (this.zaft) {
      this.zaft = false;
      this.zafs.zaa(new zaaj(this, this));
    } 
  }
  
  public final boolean disconnect() {
    if (this.zaft)
      return false; 
    if (this.zafs.zaed.zaax()) {
      this.zaft = true;
      Iterator<zacm> iterator = this.zafs.zaed.zahd.iterator();
      while (iterator.hasNext())
        ((zacm)iterator.next()).zabv(); 
      return false;
    } 
    this.zafs.zaf(null);
    return true;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT) {
    return (T)execute((BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>)paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT) {
    try {
      this.zafs.zaed.zahe.zab((BasePendingResult<? extends Result>)paramT);
      zaaw zaaw = this.zafs.zaed;
      Api.AnyClientKey anyClientKey = paramT.getClientKey();
      Api.Client client = zaaw.zagy.get(anyClientKey);
      Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
      if (!client.isConnected() && this.zafs.zaho.containsKey(paramT.getClientKey())) {
        Status status = new Status();
        this(17);
        paramT.setFailedResult(status);
      } else {
        Api.SimpleClient simpleClient;
        Api.Client client1 = client;
        if (client instanceof SimpleClientAdapter)
          simpleClient = ((SimpleClientAdapter)client).getClient(); 
        paramT.run(simpleClient);
      } 
    } catch (DeadObjectException deadObjectException) {
      this.zafs.zaa(new zaai(this, this));
    } 
    return paramT;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt) {
    this.zafs.zaf(null);
    this.zafs.zahs.zab(paramInt, this.zaft);
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  final void zaam() {
    if (this.zaft) {
      this.zaft = false;
      this.zafs.zaed.zahe.release();
      disconnect();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */