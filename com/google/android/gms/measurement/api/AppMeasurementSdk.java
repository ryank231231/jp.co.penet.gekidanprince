package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.measurement.internal.zzda;
import com.google.android.gms.measurement.internal.zzdb;
import java.util.List;
import java.util.Map;

@KeepForSdk
public class AppMeasurementSdk {
  private final zzaa zzq;
  
  public AppMeasurementSdk(zzaa paramzzaa) {
    this.zzq = paramzzaa;
  }
  
  @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @KeepForSdk
  public static AppMeasurementSdk getInstance(@NonNull Context paramContext) {
    return zzaa.zza(paramContext).zzh();
  }
  
  @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @KeepForSdk
  public static AppMeasurementSdk getInstance(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, Bundle paramBundle) {
    return zzaa.zza(paramContext, paramString1, paramString2, paramString3, paramBundle).zzh();
  }
  
  @KeepForSdk
  public void beginAdUnitExposure(@NonNull @Size(min = 1L) String paramString) {
    this.zzq.beginAdUnitExposure(paramString);
  }
  
  @KeepForSdk
  public void clearConditionalUserProperty(@NonNull @Size(max = 24L, min = 1L) String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle) {
    this.zzq.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  @KeepForSdk
  public void endAdUnitExposure(@NonNull @Size(min = 1L) String paramString) {
    this.zzq.endAdUnitExposure(paramString);
  }
  
  @KeepForSdk
  public long generateEventId() {
    return this.zzq.generateEventId();
  }
  
  @KeepForSdk
  public String getAppIdOrigin() {
    return this.zzq.getAppIdOrigin();
  }
  
  @Nullable
  @KeepForSdk
  public String getAppInstanceId() {
    return this.zzq.zzj();
  }
  
  @WorkerThread
  @KeepForSdk
  public List<Bundle> getConditionalUserProperties(@Nullable String paramString1, @Nullable @Size(max = 23L, min = 1L) String paramString2) {
    return this.zzq.getConditionalUserProperties(paramString1, paramString2);
  }
  
  @Nullable
  @KeepForSdk
  public String getCurrentScreenClass() {
    return this.zzq.getCurrentScreenClass();
  }
  
  @Nullable
  @KeepForSdk
  public String getCurrentScreenName() {
    return this.zzq.getCurrentScreenName();
  }
  
  @Nullable
  @KeepForSdk
  public String getGmpAppId() {
    return this.zzq.getGmpAppId();
  }
  
  @WorkerThread
  @KeepForSdk
  public int getMaxUserProperties(@NonNull @Size(min = 1L) String paramString) {
    return this.zzq.getMaxUserProperties(paramString);
  }
  
  @WorkerThread
  @KeepForSdk
  public Map<String, Object> getUserProperties(@Nullable String paramString1, @Nullable @Size(max = 24L, min = 1L) String paramString2, boolean paramBoolean) {
    return this.zzq.getUserProperties(paramString1, paramString2, paramBoolean);
  }
  
  @KeepForSdk
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle) {
    this.zzq.logEventInternal(paramString1, paramString2, paramBundle);
  }
  
  @KeepForSdk
  public void logEventNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    this.zzq.logEventInternalNoInterceptor(paramString1, paramString2, paramBundle, paramLong);
  }
  
  @KeepForSdk
  public void performAction(Bundle paramBundle) {
    this.zzq.zza(paramBundle, false);
  }
  
  @KeepForSdk
  public Bundle performActionWithResponse(Bundle paramBundle) {
    return this.zzq.zza(paramBundle, true);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener) {
    this.zzq.zza(paramOnEventListener);
  }
  
  @KeepForSdk
  public void setConditionalUserProperty(@NonNull Bundle paramBundle) {
    this.zzq.setConditionalUserProperty(paramBundle);
  }
  
  @KeepForSdk
  public void setCurrentScreen(@NonNull Activity paramActivity, @Nullable @Size(max = 36L, min = 1L) String paramString1, @Nullable @Size(max = 36L, min = 1L) String paramString2) {
    this.zzq.setCurrentScreen(paramActivity, paramString1, paramString2);
  }
  
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public void setEventInterceptor(EventInterceptor paramEventInterceptor) {
    this.zzq.zza(paramEventInterceptor);
  }
  
  @KeepForSdk
  public void setMeasurementEnabled(boolean paramBoolean) {
    this.zzq.setMeasurementEnabled(paramBoolean);
  }
  
  @KeepForSdk
  public void setUserProperty(String paramString1, String paramString2, Object paramObject) {
    this.zzq.setUserPropertyInternal(paramString1, paramString2, paramObject);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener) {
    this.zzq.zzb(paramOnEventListener);
  }
  
  @KeepForSdk
  public static final class ConditionalUserProperty {
    @KeepForSdk
    public static final String ACTIVE = "active";
    
    @KeepForSdk
    public static final String CREATION_TIMESTAMP = "creation_timestamp";
    
    @KeepForSdk
    public static final String EXPIRED_EVENT_NAME = "expired_event_name";
    
    @KeepForSdk
    public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
    
    @KeepForSdk
    public static final String NAME = "name";
    
    @KeepForSdk
    public static final String ORIGIN = "origin";
    
    @KeepForSdk
    public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
    
    @KeepForSdk
    public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
    
    @KeepForSdk
    public static final String TIME_TO_LIVE = "time_to_live";
    
    @KeepForSdk
    public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
    
    @KeepForSdk
    public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
    
    @KeepForSdk
    public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
    
    @KeepForSdk
    public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
    
    @KeepForSdk
    public static final String TRIGGER_TIMEOUT = "trigger_timeout";
    
    @KeepForSdk
    public static final String VALUE = "value";
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static interface EventInterceptor extends zzda {
    @WorkerThread
    @KeepForSdk
    @ShowFirstParty
    void interceptEvent(String param1String1, String param1String2, Bundle param1Bundle, long param1Long);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static interface OnEventListener extends zzdb {
    @WorkerThread
    @KeepForSdk
    @ShowFirstParty
    void onEvent(String param1String1, String param1String2, Bundle param1Bundle, long param1Long);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\api\AppMeasurementSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */