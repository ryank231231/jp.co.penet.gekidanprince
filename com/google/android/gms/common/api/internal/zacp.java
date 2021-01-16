package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacp {
  public static final Status zakw = new Status(8, "The connection to Google Play services was lost");
  
  private static final BasePendingResult<?>[] zakx = (BasePendingResult<?>[])new BasePendingResult[0];
  
  private final Map<Api.AnyClientKey<?>, Api.Client> zagy;
  
  @VisibleForTesting
  final Set<BasePendingResult<?>> zaky = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<BasePendingResult<?>, Boolean>()));
  
  private final zacs zakz = new zacq(this);
  
  public zacp(Map<Api.AnyClientKey<?>, Api.Client> paramMap) {
    this.zagy = paramMap;
  }
  
  public final void release() {
    for (BasePendingResult basePendingResult : (BasePendingResult[])this.zaky.<BasePendingResult>toArray((BasePendingResult[])zakx)) {
      basePendingResult.zaa((zacs)null);
      if (basePendingResult.zam() == null) {
        if (basePendingResult.zat())
          this.zaky.remove(basePendingResult); 
      } else {
        basePendingResult.setResultCallback(null);
        IBinder iBinder = ((Api.Client)this.zagy.get(((BaseImplementation.ApiMethodImpl)basePendingResult).getClientKey())).getServiceBrokerBinder();
        if (basePendingResult.isReady()) {
          basePendingResult.zaa(new zacr(basePendingResult, null, iBinder, null));
        } else if (iBinder != null && iBinder.isBinderAlive()) {
          zacr zacr = new zacr(basePendingResult, null, iBinder, null);
          basePendingResult.zaa(zacr);
          try {
            iBinder.linkToDeath(zacr, 0);
          } catch (RemoteException remoteException) {
            basePendingResult.cancel();
            basePendingResult.zam().intValue();
            throw new NullPointerException();
          } 
        } else {
          basePendingResult.zaa((zacs)null);
          basePendingResult.cancel();
          basePendingResult.zam().intValue();
          throw new NullPointerException();
        } 
        this.zaky.remove(basePendingResult);
      } 
    } 
  }
  
  final void zab(BasePendingResult<? extends Result> paramBasePendingResult) {
    this.zaky.add(paramBasePendingResult);
    paramBasePendingResult.zaa(this.zakz);
  }
  
  public final void zabx() {
    BasePendingResult[] arrayOfBasePendingResult = this.zaky.<BasePendingResult>toArray((BasePendingResult[])zakx);
    int i = arrayOfBasePendingResult.length;
    for (byte b = 0; b < i; b++)
      arrayOfBasePendingResult[b].zab(zakw); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zacp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */