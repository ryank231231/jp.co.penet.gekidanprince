package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzd implements Runnable {
  zzd(zzc paramzzc, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run() {
    if (zzc.zza(this.zzbl) > 0) {
      Bundle bundle;
      LifecycleCallback lifecycleCallback = this.zzbi;
      if (zzc.zzb(this.zzbl) != null) {
        bundle = zzc.zzb(this.zzbl).getBundle(this.zzbj);
      } else {
        bundle = null;
      } 
      lifecycleCallback.onCreate(bundle);
    } 
    if (zzc.zza(this.zzbl) >= 2)
      this.zzbi.onStart(); 
    if (zzc.zza(this.zzbl) >= 3)
      this.zzbi.onResume(); 
    if (zzc.zza(this.zzbl) >= 4)
      this.zzbi.onStop(); 
    if (zzc.zza(this.zzbl) >= 5)
      this.zzbi.onDestroy(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */