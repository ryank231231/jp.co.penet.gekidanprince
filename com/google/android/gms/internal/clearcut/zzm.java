package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzm extends zzb implements zzl {
  public zzm() {
    super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    switch (paramInt1) {
      default:
        return false;
      case 9:
        zzb(zzc.<Status>zza(paramParcel1, Status.CREATOR), zzc.<zzc>zza(paramParcel1, zzc.CREATOR));
        return true;
      case 8:
        zza(zzc.<Status>zza(paramParcel1, Status.CREATOR), zzc.<zzc>zza(paramParcel1, zzc.CREATOR));
        return true;
      case 7:
        zza(zzc.<DataHolder>zza(paramParcel1, DataHolder.CREATOR));
        return true;
      case 6:
        zza(zzc.<Status>zza(paramParcel1, Status.CREATOR), (zze[])paramParcel1.createTypedArray(zze.CREATOR));
        return true;
      case 5:
        zzb(zzc.<Status>zza(paramParcel1, Status.CREATOR), paramParcel1.readLong());
        return true;
      case 4:
        zzc(zzc.<Status>zza(paramParcel1, Status.CREATOR));
        return true;
      case 3:
        zza(zzc.<Status>zza(paramParcel1, Status.CREATOR), paramParcel1.readLong());
        return true;
      case 2:
        zzb(zzc.<Status>zza(paramParcel1, Status.CREATOR));
        return true;
      case 1:
        break;
    } 
    zza(zzc.<Status>zza(paramParcel1, Status.CREATOR));
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */