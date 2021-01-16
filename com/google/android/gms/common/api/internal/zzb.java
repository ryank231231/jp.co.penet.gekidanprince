package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzb implements Runnable {
  zzb(zza paramzza, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run() {
    if (zza.zza(this.zzbk) > 0) {
      Bundle bundle;
      LifecycleCallback lifecycleCallback = this.zzbi;
      if (zza.zzb(this.zzbk) != null) {
        bundle = zza.zzb(this.zzbk).getBundle(this.zzbj);
      } else {
        bundle = null;
      } 
      lifecycleCallback.onCreate(bundle);
    } 
    if (zza.zza(this.zzbk) >= 2)
      this.zzbi.onStart(); 
    if (zza.zza(this.zzbk) >= 3)
      this.zzbi.onResume(); 
    if (zza.zza(this.zzbk) >= 4)
      this.zzbi.onStop(); 
    if (zza.zza(this.zzbk) >= 5)
      this.zzbi.onDestroy(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */