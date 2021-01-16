package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

public final class zzd implements zza {
  private AppMeasurement zzaau;
  
  Set<String> zzabg;
  
  private AnalyticsConnector.AnalyticsConnectorListener zzabh;
  
  private zze zzabi;
  
  public zzd(AppMeasurement paramAppMeasurement, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener) {
    this.zzabh = paramAnalyticsConnectorListener;
    this.zzaau = paramAppMeasurement;
    this.zzabi = new zze(this);
    this.zzaau.registerOnMeasurementEventListener(this.zzabi);
    this.zzabg = new HashSet<String>();
  }
  
  public final void registerEventNames(Set<String> paramSet) {
    this.zzabg.clear();
    Set<String> set = this.zzabg;
    HashSet<String> hashSet = new HashSet();
    for (String str : paramSet) {
      if (hashSet.size() < 50)
        if (zzc.zzcj(str) && zzc.zzci(str))
          hashSet.add(zzc.zzcl(str));  
    } 
    set.addAll(hashSet);
  }
  
  public final void unregisterEventNames() {
    this.zzabg.clear();
  }
  
  public final AnalyticsConnector.AnalyticsConnectorListener zzju() {
    return this.zzabh;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */