package com.google.android.gms.tasks;

final class zzh implements Runnable {
  zzh(zzg paramzzg) {}
  
  public final void run() {
    synchronized (zzg.zza(this.zzk)) {
      if (zzg.zzb(this.zzk) != null)
        zzg.zzb(this.zzk).onCanceled(); 
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */