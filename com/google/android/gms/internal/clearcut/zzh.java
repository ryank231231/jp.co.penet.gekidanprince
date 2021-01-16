package com.google.android.gms.internal.clearcut;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zzh extends BaseImplementation.ApiMethodImpl<Status, zzj> {
  private final zze zzao;
  
  zzh(zze paramzze, GoogleApiClient paramGoogleApiClient) {
    super(ClearcutLogger.API, paramGoogleApiClient);
    this.zzao = paramzze;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */