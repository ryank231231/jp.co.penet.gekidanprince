package com.google.android.gms.tasks;

public class CancellationTokenSource {
  private final zza zzc = new zza();
  
  public void cancel() {
    this.zzc.cancel();
  }
  
  public CancellationToken getToken() {
    return this.zzc;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\tasks\CancellationTokenSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */