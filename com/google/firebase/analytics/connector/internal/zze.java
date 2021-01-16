package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zze implements AppMeasurement.OnEventListener {
  public zze(zzd paramzzd) {}
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    if (!this.zzabj.zzabg.contains(paramString2))
      return; 
    Bundle bundle = new Bundle();
    bundle.putString("events", zzc.zzck(paramString2));
    zzd.zza(this.zzabj).onMessageTriggered(2, bundle);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */