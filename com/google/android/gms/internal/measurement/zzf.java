package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzf extends zzb implements zze {
  public static zze zza(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    return (iInterface instanceof zze) ? (zze)iInterface : new zzg(paramIBinder);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */