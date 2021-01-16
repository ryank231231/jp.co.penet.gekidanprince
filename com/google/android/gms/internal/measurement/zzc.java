package com.google.android.gms.internal.measurement;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class zzc {
  private static final ClassLoader zzd = zzc.class.getClassLoader();
  
  public static void writeBoolean(Parcel paramParcel, boolean paramBoolean) {
    paramParcel.writeInt(paramBoolean);
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator) {
    return (T)((paramParcel.readInt() == 0) ? null : (Parcelable)paramCreator.createFromParcel(paramParcel));
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface) {
    if (paramIInterface == null) {
      paramParcel.writeStrongBinder(null);
      return;
    } 
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
  }
  
  public static void zza(Parcel paramParcel, Parcelable paramParcelable) {
    if (paramParcelable == null) {
      paramParcel.writeInt(0);
      return;
    } 
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
  
  public static boolean zza(Parcel paramParcel) {
    return (paramParcel.readInt() != 0);
  }
  
  public static HashMap zzb(Parcel paramParcel) {
    return paramParcel.readHashMap(zzd);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */