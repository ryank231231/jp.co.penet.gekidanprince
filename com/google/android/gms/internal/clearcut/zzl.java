package com.google.android.gms.internal.clearcut;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzl extends IInterface {
  void zza(Status paramStatus) throws RemoteException;
  
  void zza(Status paramStatus, long paramLong) throws RemoteException;
  
  void zza(Status paramStatus, zzc paramzzc) throws RemoteException;
  
  void zza(Status paramStatus, zze[] paramArrayOfzze) throws RemoteException;
  
  void zza(DataHolder paramDataHolder) throws RemoteException;
  
  void zzb(Status paramStatus) throws RemoteException;
  
  void zzb(Status paramStatus, long paramLong) throws RemoteException;
  
  void zzb(Status paramStatus, zzc paramzzc) throws RemoteException;
  
  void zzc(Status paramStatus) throws RemoteException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */