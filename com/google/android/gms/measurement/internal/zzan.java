package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import java.util.List;

public abstract class zzan extends zzb implements zzam {
  public zzan() {
    super("com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    List<zzr> list1;
    String str;
    byte[] arrayOfByte;
    List<zzga> list;
    switch (paramInt1) {
      default:
        return false;
      case 18:
        zzd((zzm)zzc.zza(paramParcel1, zzm.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 17:
        list1 = zzd(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(list1);
        return true;
      case 16:
        list1 = zza(list1.readString(), list1.readString(), (zzm)zzc.zza((Parcel)list1, zzm.CREATOR));
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(list1);
        return true;
      case 15:
        list1 = (List)zza(list1.readString(), list1.readString(), list1.readString(), zzc.zza((Parcel)list1));
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(list1);
        return true;
      case 14:
        list1 = (List)zza(list1.readString(), list1.readString(), zzc.zza((Parcel)list1), (zzm)zzc.zza((Parcel)list1, zzm.CREATOR));
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(list1);
        return true;
      case 13:
        zzb((zzr)zzc.zza((Parcel)list1, zzr.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 12:
        zza((zzr)zzc.zza((Parcel)list1, zzr.CREATOR), (zzm)zzc.zza((Parcel)list1, zzm.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 11:
        str = zzc((zzm)zzc.zza((Parcel)list1, zzm.CREATOR));
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        return true;
      case 10:
        zza(str.readLong(), str.readString(), str.readString(), str.readString());
        paramParcel2.writeNoException();
        return true;
      case 9:
        arrayOfByte = zza((zzaj)zzc.zza((Parcel)str, zzaj.CREATOR), str.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(arrayOfByte);
        return true;
      case 7:
        list = zza((zzm)zzc.zza((Parcel)arrayOfByte, zzm.CREATOR), zzc.zza((Parcel)arrayOfByte));
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(list);
        return true;
      case 6:
        zzb((zzm)zzc.zza((Parcel)list, zzm.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 5:
        zza((zzaj)zzc.zza((Parcel)list, zzaj.CREATOR), list.readString(), list.readString());
        paramParcel2.writeNoException();
        return true;
      case 4:
        zza((zzm)zzc.zza((Parcel)list, zzm.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 2:
        zza((zzga)zzc.zza((Parcel)list, zzga.CREATOR), (zzm)zzc.zza((Parcel)list, zzm.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 1:
        break;
    } 
    zza((zzaj)zzc.zza((Parcel)list, zzaj.CREATOR), (zzm)zzc.zza((Parcel)list, zzm.CREATOR));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */