package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import java.util.ArrayList;
import java.util.List;

public final class zzao extends zza implements zzam {
  zzao(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  public final List<zzga> zza(zzm paramzzm, boolean paramBoolean) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzm);
    zzc.writeBoolean(parcel, paramBoolean);
    parcel = transactAndReadException(7, parcel);
    ArrayList<zzga> arrayList = parcel.createTypedArrayList(zzga.CREATOR);
    parcel.recycle();
    return arrayList;
  }
  
  public final List<zzr> zza(String paramString1, String paramString2, zzm paramzzm) throws RemoteException {
    Parcel parcel2 = obtainAndWriteInterfaceToken();
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    zzc.zza(parcel2, (Parcelable)paramzzm);
    Parcel parcel1 = transactAndReadException(16, parcel2);
    ArrayList<zzr> arrayList = parcel1.createTypedArrayList(zzr.CREATOR);
    parcel1.recycle();
    return arrayList;
  }
  
  public final List<zzga> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws RemoteException {
    Parcel parcel2 = obtainAndWriteInterfaceToken();
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString(paramString3);
    zzc.writeBoolean(parcel2, paramBoolean);
    Parcel parcel1 = transactAndReadException(15, parcel2);
    ArrayList<zzga> arrayList = parcel1.createTypedArrayList(zzga.CREATOR);
    parcel1.recycle();
    return arrayList;
  }
  
  public final List<zzga> zza(String paramString1, String paramString2, boolean paramBoolean, zzm paramzzm) throws RemoteException {
    Parcel parcel2 = obtainAndWriteInterfaceToken();
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    zzc.writeBoolean(parcel2, paramBoolean);
    zzc.zza(parcel2, (Parcelable)paramzzm);
    Parcel parcel1 = transactAndReadException(14, parcel2);
    ArrayList<zzga> arrayList = parcel1.createTypedArrayList(zzga.CREATOR);
    parcel1.recycle();
    return arrayList;
  }
  
  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeLong(paramLong);
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    parcel.writeString(paramString3);
    zza(10, parcel);
  }
  
  public final void zza(zzaj paramzzaj, zzm paramzzm) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzaj);
    zzc.zza(parcel, (Parcelable)paramzzm);
    zza(1, parcel);
  }
  
  public final void zza(zzaj paramzzaj, String paramString1, String paramString2) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzaj);
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zza(5, parcel);
  }
  
  public final void zza(zzga paramzzga, zzm paramzzm) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzga);
    zzc.zza(parcel, (Parcelable)paramzzm);
    zza(2, parcel);
  }
  
  public final void zza(zzm paramzzm) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzm);
    zza(4, parcel);
  }
  
  public final void zza(zzr paramzzr, zzm paramzzm) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzr);
    zzc.zza(parcel, (Parcelable)paramzzm);
    zza(12, parcel);
  }
  
  public final byte[] zza(zzaj paramzzaj, String paramString) throws RemoteException {
    Parcel parcel2 = obtainAndWriteInterfaceToken();
    zzc.zza(parcel2, (Parcelable)paramzzaj);
    parcel2.writeString(paramString);
    Parcel parcel1 = transactAndReadException(9, parcel2);
    byte[] arrayOfByte = parcel1.createByteArray();
    parcel1.recycle();
    return arrayOfByte;
  }
  
  public final void zzb(zzm paramzzm) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzm);
    zza(6, parcel);
  }
  
  public final void zzb(zzr paramzzr) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzr);
    zza(13, parcel);
  }
  
  public final String zzc(zzm paramzzm) throws RemoteException {
    Parcel parcel2 = obtainAndWriteInterfaceToken();
    zzc.zza(parcel2, (Parcelable)paramzzm);
    Parcel parcel1 = transactAndReadException(11, parcel2);
    String str = parcel1.readString();
    parcel1.recycle();
    return str;
  }
  
  public final List<zzr> zzd(String paramString1, String paramString2, String paramString3) throws RemoteException {
    Parcel parcel2 = obtainAndWriteInterfaceToken();
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString(paramString3);
    Parcel parcel1 = transactAndReadException(17, parcel2);
    ArrayList<zzr> arrayList = parcel1.createTypedArrayList(zzr.CREATOR);
    parcel1.recycle();
    return arrayList;
  }
  
  public final void zzd(zzm paramzzm) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramzzm);
    zza(18, parcel);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */