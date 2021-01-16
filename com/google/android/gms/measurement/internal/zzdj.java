package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdj implements Runnable {
  zzdj(zzdd paramzzdd, long paramLong) {}
  
  public final void run() {
    zzdd zzdd1 = this.zzpm;
    long l = this.zzps;
    zzdd1.zzq();
    zzdd1.zzo();
    zzdd1.zzah();
    zzdd1.zzad().zzdh().zzaq("Resetting analytics data (FE)");
    zzdd1.zzx().zzfo();
    if (zzdd1.zzaf().zzu(zzdd1.zzt().zzan()))
      (zzdd1.zzae()).zzlg.set(l); 
    boolean bool = zzdd1.zzl.isEnabled();
    if (!zzdd1.zzaf().zzbq())
      zzdd1.zzae().zzf(bool ^ true); 
    zzdd1.zzu().resetAnalyticsData();
    zzdd1.zzpk = bool ^ true;
    this.zzpm.zzu().zza(new AtomicReference<String>());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */