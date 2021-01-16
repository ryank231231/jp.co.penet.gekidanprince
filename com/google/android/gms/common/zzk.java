package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesQueryCreator")
public final class zzk extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzk> CREATOR = new zzl();
  
  @Field(getter = "getAllowTestKeys", id = 3)
  private final boolean zzaa;
  
  @Field(defaultValue = "false", getter = "getForbidTestKeys", id = 4)
  private final boolean zzab;
  
  @Field(getter = "getCallingPackage", id = 1)
  private final String zzy;
  
  @Nullable
  @Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
  private final zze zzz;
  
  @Constructor
  zzk(@Param(id = 1) String paramString, @Nullable @Param(id = 2) IBinder paramIBinder, @Param(id = 3) boolean paramBoolean1, @Param(id = 4) boolean paramBoolean2) {
    this.zzy = paramString;
    this.zzz = zza(paramIBinder);
    this.zzaa = paramBoolean1;
    this.zzab = paramBoolean2;
  }
  
  zzk(String paramString, @Nullable zze paramzze, boolean paramBoolean1, boolean paramBoolean2) {
    this.zzy = paramString;
    this.zzz = paramzze;
    this.zzaa = paramBoolean1;
    this.zzab = paramBoolean2;
  }
  
  @Nullable
  private static zze zza(@Nullable IBinder paramIBinder) {
    byte[] arrayOfByte = null;
    if (paramIBinder == null)
      return null; 
    try {
      byte[] arrayOfByte1;
      IObjectWrapper iObjectWrapper = zzj.zzb(paramIBinder).zzb();
      if (iObjectWrapper == null) {
        iObjectWrapper = null;
      } else {
        arrayOfByte1 = (byte[])ObjectWrapper.unwrap(iObjectWrapper);
      } 
      if (arrayOfByte1 != null) {
        zzf zzf = new zzf(arrayOfByte1);
      } else {
        Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
        arrayOfByte1 = arrayOfByte;
      } 
      return (zze)arrayOfByte1;
    } catch (RemoteException remoteException) {
      Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", (Throwable)remoteException);
      return null;
    } 
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    IBinder iBinder;
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzy, false);
    zze zze1 = this.zzz;
    if (zze1 == null) {
      Log.w("GoogleCertificatesQuery", "certificate binder is null");
      zze1 = null;
    } else {
      iBinder = zze1.asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 2, iBinder, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzaa);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzab);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */