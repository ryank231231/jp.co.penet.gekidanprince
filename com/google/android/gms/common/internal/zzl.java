package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzl extends zza implements IGmsCallbacks {
  zzl(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    parcel.writeStrongBinder(paramIBinder);
    zzc.zza(parcel, (Parcelable)paramBundle);
    zzb(1, parcel);
  }
  
  public final void zza(int paramInt, Bundle paramBundle) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    zzc.zza(parcel, (Parcelable)paramBundle);
    zzb(2, parcel);
  }
  
  public final void zza(int paramInt, IBinder paramIBinder, zzb paramzzb) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    parcel.writeStrongBinder(paramIBinder);
    zzc.zza(parcel, (Parcelable)paramzzb);
    zzb(3, parcel);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */