package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzg implements AppMeasurement.OnEventListener {
  public zzg(zzf paramzzf) {}
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    if (paramString1 != null && !paramString1.equals("crash") && zzc.zzch(paramString2)) {
      Bundle bundle = new Bundle();
      bundle.putString("name", paramString2);
      bundle.putLong("timestampInMillis", paramLong);
      bundle.putBundle("params", paramBundle);
      zzf.zza(this.zzabl).onMessageTriggered(3, bundle);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */