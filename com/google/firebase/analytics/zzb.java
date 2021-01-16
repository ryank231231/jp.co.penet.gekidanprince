package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.measurement.internal.zzda;
import com.google.android.gms.measurement.internal.zzdb;
import com.google.android.gms.measurement.internal.zzdy;
import java.util.List;
import java.util.Map;

final class zzb implements zzdy {
  zzb(zzaa paramzzaa) {}
  
  public final void beginAdUnitExposure(String paramString) {
    this.zzaas.beginAdUnitExposure(paramString);
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle) {
    this.zzaas.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  public final void endAdUnitExposure(String paramString) {
    this.zzaas.endAdUnitExposure(paramString);
  }
  
  public final long generateEventId() {
    return this.zzaas.generateEventId();
  }
  
  public final List<Bundle> getConditionalUserProperties(String paramString1, String paramString2) {
    return this.zzaas.getConditionalUserProperties(paramString1, paramString2);
  }
  
  public final String getCurrentScreenClass() {
    return this.zzaas.getCurrentScreenClass();
  }
  
  public final String getCurrentScreenName() {
    return this.zzaas.getCurrentScreenName();
  }
  
  public final String getGmpAppId() {
    return this.zzaas.getGmpAppId();
  }
  
  public final int getMaxUserProperties(String paramString) {
    return this.zzaas.getMaxUserProperties(paramString);
  }
  
  public final Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean) {
    return this.zzaas.getUserProperties(paramString1, paramString2, paramBoolean);
  }
  
  public final void logEventInternal(String paramString1, String paramString2, Bundle paramBundle) {
    this.zzaas.logEventInternal(paramString1, paramString2, paramBundle);
  }
  
  public final void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    this.zzaas.logEventInternalNoInterceptor(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public final void setConditionalUserProperty(Bundle paramBundle) {
    this.zzaas.setConditionalUserProperty(paramBundle);
  }
  
  public final void setDataCollectionEnabled(boolean paramBoolean) {
    this.zzaas.setDataCollectionEnabled(paramBoolean);
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean) {
    this.zzaas.setMeasurementEnabled(paramBoolean);
  }
  
  public final void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject) {
    this.zzaas.setUserPropertyInternal(paramString1, paramString2, paramObject);
  }
  
  public final void zza(zzda paramzzda) {
    this.zzaas.zza(paramzzda);
  }
  
  public final void zza(zzdb paramzzdb) {
    this.zzaas.zza(paramzzdb);
  }
  
  public final Object zzb(int paramInt) {
    return this.zzaas.zzb(paramInt);
  }
  
  public final void zzb(zzdb paramzzdb) {
    this.zzaas.zzb(paramzzdb);
  }
  
  public final String zzj() {
    return this.zzaas.zzj();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */