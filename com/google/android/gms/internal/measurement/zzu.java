package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzu extends zzb implements zzt {
  public zzu() {
    super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    switch (paramInt1) {
      default:
        return false;
      case 2:
        paramInt1 = id();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 1:
        break;
    } 
    onEvent(paramParcel1.readString(), paramParcel1.readString(), zzc.<Bundle>zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */