package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzs extends zza implements zzq {
  zzs(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }
  
  public final void zzb(Bundle paramBundle) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramBundle);
    zza(1, parcel);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */