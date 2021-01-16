package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {
  private final IBinder zza;
  
  private final String zzb;
  
  protected zza(IBinder paramIBinder, String paramString) {
    this.zza = paramIBinder;
    this.zzb = paramString;
  }
  
  public IBinder asBinder() {
    return this.zza;
  }
  
  protected final Parcel obtainAndWriteInterfaceToken() {
    Parcel parcel = Parcel.obtain();
    parcel.writeInterfaceToken(this.zzb);
    return parcel;
  }
  
  protected final void transactOneway(int paramInt, Parcel paramParcel) throws RemoteException {
    try {
      this.zza.transact(1, paramParcel, null, 1);
      return;
    } finally {
      paramParcel.recycle();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */