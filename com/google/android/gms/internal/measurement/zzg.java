package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzg extends zza implements zze {
  zzg(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
  }
  
  public final Bundle zza(Bundle paramBundle) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramBundle);
    parcel = transactAndReadException(1, parcel);
    paramBundle = zzc.<Bundle>zza(parcel, Bundle.CREATOR);
    parcel.recycle();
    return paramBundle;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */