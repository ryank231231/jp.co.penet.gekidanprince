package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzq;

final class zzep implements Runnable {
  zzep(zzeg paramzzeg, zzaj paramzzaj, String paramString, zzq paramzzq) {}
  
  public final void run() {
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = arrayOfByte2;
    byte[] arrayOfByte4 = arrayOfByte1;
    try {
      zzam zzam = zzeg.zzd(this.zzqq);
      if (zzam == null) {
        arrayOfByte3 = arrayOfByte2;
        arrayOfByte4 = arrayOfByte1;
        this.zzqq.zzad().zzda().zzaq("Discarding data. Failed to send event to service to bundle");
        this.zzqq.zzab().zza(this.zzdh, (byte[])null);
        return;
      } 
      arrayOfByte3 = arrayOfByte2;
      arrayOfByte4 = arrayOfByte1;
      arrayOfByte2 = zzam.zza(this.zzdj, this.zzdk);
      arrayOfByte3 = arrayOfByte2;
      arrayOfByte4 = arrayOfByte2;
      zzeg.zze(this.zzqq);
      this.zzqq.zzab().zza(this.zzdh, arrayOfByte2);
      return;
    } catch (RemoteException remoteException) {
      arrayOfByte3 = arrayOfByte4;
      this.zzqq.zzad().zzda().zza("Failed to send event to the service to bundle", remoteException);
      this.zzqq.zzab().zza(this.zzdh, arrayOfByte4);
      return;
    } finally {}
    this.zzqq.zzab().zza(this.zzdh, arrayOfByte3);
    throw arrayOfByte4;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */