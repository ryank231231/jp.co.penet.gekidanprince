package com.google.firebase.analytics.connector;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnalyticsConnector {
  @KeepForSdk
  void clearConditionalUserProperty(@NonNull @Size(max = 24L, min = 1L) String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle);
  
  @WorkerThread
  @KeepForSdk
  List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String paramString1, @Nullable @Size(max = 23L, min = 1L) String paramString2);
  
  @WorkerThread
  @KeepForSdk
  int getMaxUserProperties(@NonNull @Size(min = 1L) String paramString);
  
  @WorkerThread
  @KeepForSdk
  Map<String, Object> getUserProperties(boolean paramBoolean);
  
  @KeepForSdk
  void logEvent(@NonNull String paramString1, @NonNull String paramString2, Bundle paramBundle);
  
  @KeepForSdk
  AnalyticsConnectorHandle registerAnalyticsConnectorListener(String paramString, AnalyticsConnectorListener paramAnalyticsConnectorListener);
  
  @KeepForSdk
  void setConditionalUserProperty(@NonNull ConditionalUserProperty paramConditionalUserProperty);
  
  @KeepForSdk
  void setUserProperty(@NonNull String paramString1, @NonNull String paramString2, Object paramObject);
  
  @KeepForSdk
  public static interface AnalyticsConnectorHandle {
    @KeepForSdk
    void registerEventNames(Set<String> param1Set);
    
    @KeepForSdk
    void unregister();
    
    @KeepForSdk
    void unregisterEventNames();
  }
  
  @KeepForSdk
  public static interface AnalyticsConnectorListener {
    @KeepForSdk
    void onMessageTriggered(int param1Int, @Nullable Bundle param1Bundle);
  }
  
  @KeepForSdk
  public static class ConditionalUserProperty {
    @KeepForSdk
    public boolean active;
    
    @KeepForSdk
    public long creationTimestamp;
    
    @KeepForSdk
    public String expiredEventName;
    
    @KeepForSdk
    public Bundle expiredEventParams;
    
    @KeepForSdk
    public String name;
    
    @KeepForSdk
    public String origin;
    
    @KeepForSdk
    public long timeToLive;
    
    @KeepForSdk
    public String timedOutEventName;
    
    @KeepForSdk
    public Bundle timedOutEventParams;
    
    @KeepForSdk
    public String triggerEventName;
    
    @KeepForSdk
    public long triggerTimeout;
    
    @KeepForSdk
    public String triggeredEventName;
    
    @KeepForSdk
    public Bundle triggeredEventParams;
    
    @KeepForSdk
    public long triggeredTimestamp;
    
    @KeepForSdk
    public Object value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\connector\AnalyticsConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */