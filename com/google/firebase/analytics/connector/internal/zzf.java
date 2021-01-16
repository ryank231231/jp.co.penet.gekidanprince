package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

public final class zzf implements zza {
  private AppMeasurement zzaau;
  
  private AnalyticsConnector.AnalyticsConnectorListener zzabh;
  
  private zzg zzabk;
  
  public zzf(AppMeasurement paramAppMeasurement, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener) {
    this.zzabh = paramAnalyticsConnectorListener;
    this.zzaau = paramAppMeasurement;
    this.zzabk = new zzg(this);
    this.zzaau.registerOnMeasurementEventListener(this.zzabk);
  }
  
  public final void registerEventNames(Set<String> paramSet) {}
  
  public final void unregisterEventNames() {}
  
  public final AnalyticsConnector.AnalyticsConnectorListener zzju() {
    return this.zzabh;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */