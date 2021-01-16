package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zze;

public final class zzo extends zza implements zzn {
  zzo(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
  }
  
  public final void zza(zzl paramzzl, zze paramzze) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzl);
    zzc.zza(parcel, (Parcelable)paramzze);
    transactOneway(1, parcel);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */