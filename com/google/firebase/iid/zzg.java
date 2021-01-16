package com.google.firebase.iid;

import android.util.Log;

final class zzg implements Runnable {
  zzg(zzf paramzzf, zzd paramzzd) {}
  
  public final void run() {
    if (Log.isLoggable("EnhancedIntentService", 3))
      Log.d("EnhancedIntentService", "bg processing of the intent starting now"); 
    zzf.zza(this.zzy).zzd(this.zzx.intent);
    this.zzx.finish();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */