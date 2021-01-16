package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzb extends Binder implements IInterface {
  private static zzd zzc;
  
  protected zzb(String paramString) {
    attachInterface(this, paramString);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    boolean bool;
    if (paramInt1 > 16777215) {
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    } else {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
      bool = false;
    } 
    return bool ? true : zza(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
  
  protected boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    return false;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */