package com.google.android.gms.measurement.internal;

final class zzcs implements Runnable {
  zzcs(zzca paramzzca, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public final void run() {
    String str = this.zzow;
    if (str == null) {
      zzca.zza(this.zzot).zzgi().zzv().zza(this.zzdk, (zzec)null);
      return;
    } 
    zzec zzec = new zzec(this.zzax, str, this.zzox);
    zzca.zza(this.zzot).zzgi().zzv().zza(this.zzdk, zzec);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */