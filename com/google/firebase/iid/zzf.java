package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class zzf extends Binder {
  private final zzb zzw;
  
  zzf(zzb paramzzb) {
    this.zzw = paramzzb;
  }
  
  public final void zza(zzd paramzzd) {
    if (Binder.getCallingUid() == Process.myUid()) {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "service received new intent via bind strategy"); 
      if (this.zzw.zzc(paramzzd.intent)) {
        paramzzd.finish();
        return;
      } 
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "intent being queued for bg execution"); 
      this.zzw.zzk.execute(new zzg(this, paramzzd));
      return;
    } 
    throw new SecurityException("Binding only allowed within app");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */