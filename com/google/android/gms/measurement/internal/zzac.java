package com.google.android.gms.measurement.internal;

final class zzac implements Runnable {
  zzac(zzab paramzzab, zzcv paramzzcv) {}
  
  public final void run() {
    this.zzeu.zzag();
    if (zzq.isMainThread()) {
      this.zzeu.zzac().zza(this);
      return;
    } 
    boolean bool = this.zzev.zzcn();
    zzab.zza(this.zzev, 0L);
    if (bool)
      this.zzev.run(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */