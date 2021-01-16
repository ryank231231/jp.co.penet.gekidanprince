package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzv extends zza implements zzt {
  zzv(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }
  
  public final int id() throws RemoteException {
    Parcel parcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zzc.zza(parcel, (Parcelable)paramBundle);
    parcel.writeLong(paramLong);
    zza(1, parcel);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */