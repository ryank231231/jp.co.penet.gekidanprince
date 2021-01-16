package com.google.android.gms.measurement.internal;

final class zzfb implements Runnable {
  zzfb(zzey paramzzey, zzam paramzzam) {}
  
  public final void run() {
    synchronized (this.zzqz) {
      zzey.zza(this.zzqz, false);
      if (!this.zzqz.zzqq.isConnected()) {
        this.zzqz.zzqq.zzad().zzdh().zzaq("Connected to remote service");
        this.zzqz.zzqq.zza(this.zzra);
      } 
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */