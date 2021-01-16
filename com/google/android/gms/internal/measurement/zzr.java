package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzr extends zzb implements zzq {
  public zzr() {
    super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 1) {
      zzb(zzc.<Bundle>zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      return true;
    } 
    return false;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */