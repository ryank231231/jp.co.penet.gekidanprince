package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public interface IGmsCallbacks extends IInterface {
  void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle) throws RemoteException;
  
  void zza(int paramInt, Bundle paramBundle) throws RemoteException;
  
  void zza(int paramInt, IBinder paramIBinder, zzb paramzzb) throws RemoteException;
  
  public static abstract class zza extends zzb implements IGmsCallbacks {
    public zza() {
      super("com.google.android.gms.common.internal.IGmsCallbacks");
    }
    
    protected final boolean zza(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      switch (param1Int1) {
        default:
          return false;
        case 3:
          zza(param1Parcel1.readInt(), param1Parcel1.readStrongBinder(), (zzb)zzc.zza(param1Parcel1, zzb.CREATOR));
          param1Parcel2.writeNoException();
          return true;
        case 2:
          zza(param1Parcel1.readInt(), (Bundle)zzc.zza(param1Parcel1, Bundle.CREATOR));
          param1Parcel2.writeNoException();
          return true;
        case 1:
          break;
      } 
      onPostInitComplete(param1Parcel1.readInt(), param1Parcel1.readStrongBinder(), (Bundle)zzc.zza(param1Parcel1, Bundle.CREATOR));
      param1Parcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\IGmsCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */