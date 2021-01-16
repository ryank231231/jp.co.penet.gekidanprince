package com.google.android.gms.internal.firebase_messaging;

final class zzk extends zzh {
  private final zzi zzj = new zzi();
  
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2) {
    if (paramThrowable2 != paramThrowable1) {
      if (paramThrowable2 != null) {
        this.zzj.zza(paramThrowable1, true).add(paramThrowable2);
        return;
      } 
      throw new NullPointerException("The suppressed exception cannot be null.");
    } 
    throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */