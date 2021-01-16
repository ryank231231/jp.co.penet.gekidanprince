package com.google.android.gms.measurement.internal;

final class zzez implements Runnable {
  zzez(zzey paramzzey, zzam paramzzam) {}
  
  public final void run() {
    synchronized (this.zzqz) {
      zzey.zza(this.zzqz, false);
      if (!this.zzqz.zzqq.isConnected()) {
        this.zzqz.zzqq.zzad().zzdi().zzaq("Connected to service");
        this.zzqz.zzqq.zza(this.zzqy);
      } 
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */