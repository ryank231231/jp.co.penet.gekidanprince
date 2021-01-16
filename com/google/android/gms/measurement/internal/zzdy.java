package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.List;
import java.util.Map;

public interface zzdy {
  void beginAdUnitExposure(String paramString);
  
  void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle);
  
  void endAdUnitExposure(String paramString);
  
  long generateEventId();
  
  List<Bundle> getConditionalUserProperties(String paramString1, String paramString2);
  
  String getCurrentScreenClass();
  
  String getCurrentScreenName();
  
  String getGmpAppId();
  
  int getMaxUserProperties(String paramString);
  
  Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean);
  
  void logEventInternal(String paramString1, String paramString2, Bundle paramBundle);
  
  void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  
  void setConditionalUserProperty(Bundle paramBundle);
  
  void setDataCollectionEnabled(boolean paramBoolean);
  
  void setMeasurementEnabled(boolean paramBoolean);
  
  void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject);
  
  void zza(zzda paramzzda);
  
  void zza(zzdb paramzzdb);
  
  Object zzb(int paramInt);
  
  void zzb(zzdb paramzzdb);
  
  String zzj();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */