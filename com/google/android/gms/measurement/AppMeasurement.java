package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.internal.zzby;
import com.google.android.gms.measurement.internal.zzcw;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import com.google.android.gms.measurement.internal.zzcz;
import com.google.android.gms.measurement.internal.zzda;
import com.google.android.gms.measurement.internal.zzdb;
import com.google.android.gms.measurement.internal.zzdy;
import com.google.android.gms.measurement.internal.zzeb;
import com.google.android.gms.measurement.internal.zzga;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
@ShowFirstParty
public class AppMeasurement {
  @KeepForSdk
  @ShowFirstParty
  public static final String CRASH_ORIGIN = "crash";
  
  @KeepForSdk
  @ShowFirstParty
  public static final String FCM_ORIGIN = "fcm";
  
  @KeepForSdk
  @ShowFirstParty
  public static final String FIAM_ORIGIN = "fiam";
  
  private static volatile AppMeasurement zzk;
  
  private final zzby zzl;
  
  private final zzdy zzm;
  
  private final boolean zzn;
  
  private AppMeasurement(zzby paramzzby) {
    Preconditions.checkNotNull(paramzzby);
    this.zzl = paramzzby;
    this.zzm = null;
    this.zzn = false;
  }
  
  private AppMeasurement(zzdy paramzzdy) {
    Preconditions.checkNotNull(paramzzdy);
    this.zzm = paramzzdy;
    this.zzl = null;
    this.zzn = true;
  }
  
  @Deprecated
  @Keep
  @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @ShowFirstParty
  public static AppMeasurement getInstance(Context paramContext) {
    return zza(paramContext, null, null);
  }
  
  public static AppMeasurement zza(Context paramContext, Bundle paramBundle) {
    // Byte code:
    //   0: getstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   3: ifnonnull -> 74
    //   6: ldc com/google/android/gms/measurement/AppMeasurement
    //   8: monitorenter
    //   9: getstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   12: ifnonnull -> 62
    //   15: aload_0
    //   16: aload_1
    //   17: invokestatic zzb : (Landroid/content/Context;Landroid/os/Bundle;)Lcom/google/android/gms/measurement/internal/zzdy;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull -> 41
    //   25: new com/google/android/gms/measurement/AppMeasurement
    //   28: astore_0
    //   29: aload_0
    //   30: aload_2
    //   31: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzdy;)V
    //   34: aload_0
    //   35: putstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   38: goto -> 62
    //   41: aload_0
    //   42: aconst_null
    //   43: aconst_null
    //   44: aload_1
    //   45: invokestatic zza : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/google/android/gms/measurement/internal/zzby;
    //   48: astore_1
    //   49: new com/google/android/gms/measurement/AppMeasurement
    //   52: astore_0
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzby;)V
    //   58: aload_0
    //   59: putstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   62: ldc com/google/android/gms/measurement/AppMeasurement
    //   64: monitorexit
    //   65: goto -> 74
    //   68: astore_0
    //   69: ldc com/google/android/gms/measurement/AppMeasurement
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: getstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   77: areturn
    // Exception table:
    //   from	to	target	type
    //   9	21	68	finally
    //   25	38	68	finally
    //   41	62	68	finally
    //   62	65	68	finally
    //   69	72	68	finally
  }
  
  @VisibleForTesting
  private static AppMeasurement zza(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: getstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   3: ifnonnull -> 74
    //   6: ldc com/google/android/gms/measurement/AppMeasurement
    //   8: monitorenter
    //   9: getstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   12: ifnonnull -> 62
    //   15: aload_0
    //   16: aconst_null
    //   17: invokestatic zzb : (Landroid/content/Context;Landroid/os/Bundle;)Lcom/google/android/gms/measurement/internal/zzdy;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull -> 41
    //   25: new com/google/android/gms/measurement/AppMeasurement
    //   28: astore_0
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzdy;)V
    //   34: aload_0
    //   35: putstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   38: goto -> 62
    //   41: aload_0
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokestatic zza : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/google/android/gms/measurement/internal/zzby;
    //   48: astore_1
    //   49: new com/google/android/gms/measurement/AppMeasurement
    //   52: astore_0
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzby;)V
    //   58: aload_0
    //   59: putstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   62: ldc com/google/android/gms/measurement/AppMeasurement
    //   64: monitorexit
    //   65: goto -> 74
    //   68: astore_0
    //   69: ldc com/google/android/gms/measurement/AppMeasurement
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: getstatic com/google/android/gms/measurement/AppMeasurement.zzk : Lcom/google/android/gms/measurement/AppMeasurement;
    //   77: areturn
    // Exception table:
    //   from	to	target	type
    //   9	21	68	finally
    //   25	38	68	finally
    //   41	62	68	finally
    //   62	65	68	finally
    //   69	72	68	finally
  }
  
  private static zzdy zzb(Context paramContext, Bundle paramBundle) {
    try {
      Class<?> clazz = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      try {
        return (zzdy)clazz.getDeclaredMethod("getScionFrontendApiImplementation", new Class[] { Context.class, Bundle.class }).invoke(null, new Object[] { paramContext, paramBundle });
      } catch (Exception exception) {
        return null;
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  @Keep
  public void beginAdUnitExposure(@NonNull @Size(min = 1L) String paramString) {
    if (this.zzn) {
      this.zzm.beginAdUnitExposure(paramString);
      return;
    } 
    this.zzl.zzr().beginAdUnitExposure(paramString, this.zzl.zzz().elapsedRealtime());
  }
  
  @Keep
  @KeepForSdk
  @ShowFirstParty
  public void clearConditionalUserProperty(@NonNull @Size(max = 24L, min = 1L) String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle) {
    if (this.zzn) {
      this.zzm.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
      return;
    } 
    this.zzl.zzs().clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  @Keep
  @VisibleForTesting
  protected void clearConditionalUserPropertyAs(@NonNull @Size(min = 1L) String paramString1, @NonNull @Size(max = 24L, min = 1L) String paramString2, @Nullable String paramString3, @Nullable Bundle paramBundle) {
    if (!this.zzn) {
      this.zzl.zzs().clearConditionalUserPropertyAs(paramString1, paramString2, paramString3, paramBundle);
      return;
    } 
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  @Keep
  public void endAdUnitExposure(@NonNull @Size(min = 1L) String paramString) {
    if (this.zzn) {
      this.zzm.endAdUnitExposure(paramString);
      return;
    } 
    this.zzl.zzr().endAdUnitExposure(paramString, this.zzl.zzz().elapsedRealtime());
  }
  
  @Keep
  public long generateEventId() {
    return this.zzn ? this.zzm.generateEventId() : this.zzl.zzab().zzgk();
  }
  
  @Keep
  @Nullable
  public String getAppInstanceId() {
    return this.zzn ? this.zzm.zzj() : this.zzl.zzs().zzj();
  }
  
  @KeepForSdk
  public Boolean getBoolean() {
    return this.zzn ? (Boolean)this.zzm.zzb(4) : this.zzl.zzs().zzev();
  }
  
  @Keep
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String paramString1, @Nullable @Size(max = 23L, min = 1L) String paramString2) {
    List list;
    int i;
    if (this.zzn) {
      list = this.zzm.getConditionalUserProperties(paramString1, paramString2);
    } else {
      list = this.zzl.zzs().zzn((String)list, paramString2);
    } 
    if (list == null) {
      i = 0;
    } else {
      i = list.size();
    } 
    ArrayList<ConditionalUserProperty> arrayList = new ArrayList(i);
    Iterator<Bundle> iterator = list.iterator();
    while (iterator.hasNext())
      arrayList.add(new ConditionalUserProperty(iterator.next(), null)); 
    return arrayList;
  }
  
  @Keep
  @WorkerThread
  @VisibleForTesting
  protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(@NonNull @Size(min = 1L) String paramString1, @Nullable String paramString2, @Nullable @Size(max = 23L, min = 1L) String paramString3) {
    if (!this.zzn) {
      ArrayList<ArrayList> arrayList1 = this.zzl.zzs().zze(paramString1, paramString2, paramString3);
      boolean bool = false;
      if (arrayList1 == null) {
        i = 0;
      } else {
        i = arrayList1.size();
      } 
      ArrayList<ConditionalUserProperty> arrayList = new ArrayList(i);
      ArrayList<ArrayList> arrayList2 = arrayList1;
      int j = arrayList2.size();
      int i = bool;
      while (i < j) {
        arrayList1 = arrayList2.get(i);
        i++;
        arrayList.add(new ConditionalUserProperty((Bundle)arrayList1, null));
      } 
      return arrayList;
    } 
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  @Keep
  @Nullable
  public String getCurrentScreenClass() {
    return this.zzn ? this.zzm.getCurrentScreenClass() : this.zzl.zzs().getCurrentScreenClass();
  }
  
  @Keep
  @Nullable
  public String getCurrentScreenName() {
    return this.zzn ? this.zzm.getCurrentScreenName() : this.zzl.zzs().getCurrentScreenName();
  }
  
  @KeepForSdk
  public Double getDouble() {
    return this.zzn ? (Double)this.zzm.zzb(2) : this.zzl.zzs().zzez();
  }
  
  @Keep
  @Nullable
  public String getGmpAppId() {
    return this.zzn ? this.zzm.getGmpAppId() : this.zzl.zzs().getGmpAppId();
  }
  
  @KeepForSdk
  public Integer getInteger() {
    return this.zzn ? (Integer)this.zzm.zzb(3) : this.zzl.zzs().zzey();
  }
  
  @KeepForSdk
  public Long getLong() {
    return this.zzn ? (Long)this.zzm.zzb(1) : this.zzl.zzs().zzex();
  }
  
  @Keep
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public int getMaxUserProperties(@NonNull @Size(min = 1L) String paramString) {
    if (this.zzn)
      return this.zzm.getMaxUserProperties(paramString); 
    this.zzl.zzs();
    Preconditions.checkNotEmpty(paramString);
    return 25;
  }
  
  @KeepForSdk
  public String getString() {
    return this.zzn ? (String)this.zzm.zzb(0) : this.zzl.zzs().zzew();
  }
  
  @Keep
  @WorkerThread
  @VisibleForTesting
  protected Map<String, Object> getUserProperties(@Nullable String paramString1, @Nullable @Size(max = 24L, min = 1L) String paramString2, boolean paramBoolean) {
    return this.zzn ? this.zzm.getUserProperties(paramString1, paramString2, paramBoolean) : this.zzl.zzs().getUserProperties(paramString1, paramString2, paramBoolean);
  }
  
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public Map<String, Object> getUserProperties(boolean paramBoolean) {
    if (this.zzn)
      return this.zzm.getUserProperties(null, null, paramBoolean); 
    List list = this.zzl.zzs().zzh(paramBoolean);
    ArrayMap<String, Object> arrayMap = new ArrayMap(list.size());
    for (zzga zzga : list)
      arrayMap.put(zzga.name, zzga.getValue()); 
    return (Map<String, Object>)arrayMap;
  }
  
  @Keep
  @WorkerThread
  @VisibleForTesting
  protected Map<String, Object> getUserPropertiesAs(@NonNull @Size(min = 1L) String paramString1, @Nullable String paramString2, @Nullable @Size(max = 23L, min = 1L) String paramString3, boolean paramBoolean) {
    if (!this.zzn)
      return this.zzl.zzs().getUserPropertiesAs(paramString1, paramString2, paramString3, paramBoolean); 
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  @Keep
  @ShowFirstParty
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle) {
    if (this.zzn) {
      this.zzm.logEventInternal(paramString1, paramString2, paramBundle);
      return;
    } 
    this.zzl.zzs().logEvent(paramString1, paramString2, paramBundle);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    if (this.zzn) {
      this.zzm.logEventInternalNoInterceptor(paramString1, paramString2, paramBundle, paramLong);
      return;
    } 
    this.zzl.zzs().logEvent(paramString1, paramString2, paramBundle, true, false, paramLong);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener) {
    if (this.zzn) {
      this.zzm.zza(paramOnEventListener);
      return;
    } 
    this.zzl.zzs().zza(paramOnEventListener);
  }
  
  @Keep
  @KeepForSdk
  @ShowFirstParty
  public void setConditionalUserProperty(@NonNull ConditionalUserProperty paramConditionalUserProperty) {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    if (this.zzn) {
      this.zzm.setConditionalUserProperty(ConditionalUserProperty.zza(paramConditionalUserProperty));
      return;
    } 
    this.zzl.zzs().setConditionalUserProperty(ConditionalUserProperty.zza(paramConditionalUserProperty));
  }
  
  @Keep
  @VisibleForTesting
  protected void setConditionalUserPropertyAs(@NonNull ConditionalUserProperty paramConditionalUserProperty) {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    if (!this.zzn) {
      this.zzl.zzs().zzd(ConditionalUserProperty.zza(paramConditionalUserProperty));
      return;
    } 
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  @WorkerThread
  @KeepForSdk
  @ShowFirstParty
  public void setEventInterceptor(EventInterceptor paramEventInterceptor) {
    if (this.zzn) {
      this.zzm.zza(paramEventInterceptor);
      return;
    } 
    this.zzl.zzs().zza(paramEventInterceptor);
  }
  
  @Deprecated
  @KeepForSdk
  public void setMeasurementEnabled(boolean paramBoolean) {
    if (this.zzn) {
      this.zzm.setMeasurementEnabled(paramBoolean);
      return;
    } 
    this.zzl.zzs().setMeasurementEnabled(paramBoolean);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject) {
    Preconditions.checkNotEmpty(paramString1);
    if (this.zzn) {
      this.zzm.setUserPropertyInternal(paramString1, paramString2, paramObject);
      return;
    } 
    this.zzl.zzs().zzb(paramString1, paramString2, paramObject, true);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener) {
    if (this.zzn) {
      this.zzm.zzb(paramOnEventListener);
      return;
    } 
    this.zzl.zzs().zzb(paramOnEventListener);
  }
  
  public final void zza(boolean paramBoolean) {
    if (this.zzn) {
      this.zzm.setDataCollectionEnabled(paramBoolean);
      return;
    } 
    this.zzl.zzs().zza(paramBoolean);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static class ConditionalUserProperty {
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public boolean mActive;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mAppId;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mCreationTimestamp;
    
    @Keep
    public String mExpiredEventName;
    
    @Keep
    public Bundle mExpiredEventParams;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mName;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mOrigin;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTimeToLive;
    
    @Keep
    public String mTimedOutEventName;
    
    @Keep
    public Bundle mTimedOutEventParams;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mTriggerEventName;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggerTimeout;
    
    @Keep
    public String mTriggeredEventName;
    
    @Keep
    public Bundle mTriggeredEventParams;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggeredTimestamp;
    
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public Object mValue;
    
    @KeepForSdk
    public ConditionalUserProperty() {}
    
    private ConditionalUserProperty(@NonNull Bundle param1Bundle) {
      Preconditions.checkNotNull(param1Bundle);
      this.mAppId = (String)zzcw.zza(param1Bundle, "app_id", String.class, null);
      this.mOrigin = (String)zzcw.zza(param1Bundle, "origin", String.class, null);
      this.mName = (String)zzcw.zza(param1Bundle, "name", String.class, null);
      this.mValue = zzcw.zza(param1Bundle, "value", Object.class, null);
      this.mTriggerEventName = (String)zzcw.zza(param1Bundle, "trigger_event_name", String.class, null);
      this.mTriggerTimeout = ((Long)zzcw.zza(param1Bundle, "trigger_timeout", Long.class, Long.valueOf(0L))).longValue();
      this.mTimedOutEventName = (String)zzcw.zza(param1Bundle, "timed_out_event_name", String.class, null);
      this.mTimedOutEventParams = (Bundle)zzcw.zza(param1Bundle, "timed_out_event_params", Bundle.class, null);
      this.mTriggeredEventName = (String)zzcw.zza(param1Bundle, "triggered_event_name", String.class, null);
      this.mTriggeredEventParams = (Bundle)zzcw.zza(param1Bundle, "triggered_event_params", Bundle.class, null);
      this.mTimeToLive = ((Long)zzcw.zza(param1Bundle, "time_to_live", Long.class, Long.valueOf(0L))).longValue();
      this.mExpiredEventName = (String)zzcw.zza(param1Bundle, "expired_event_name", String.class, null);
      this.mExpiredEventParams = (Bundle)zzcw.zza(param1Bundle, "expired_event_params", Bundle.class, null);
    }
    
    @KeepForSdk
    public ConditionalUserProperty(ConditionalUserProperty param1ConditionalUserProperty) {
      Preconditions.checkNotNull(param1ConditionalUserProperty);
      this.mAppId = param1ConditionalUserProperty.mAppId;
      this.mOrigin = param1ConditionalUserProperty.mOrigin;
      this.mCreationTimestamp = param1ConditionalUserProperty.mCreationTimestamp;
      this.mName = param1ConditionalUserProperty.mName;
      Object object = param1ConditionalUserProperty.mValue;
      if (object != null) {
        this.mValue = zzeb.zza(object);
        if (this.mValue == null)
          this.mValue = param1ConditionalUserProperty.mValue; 
      } 
      this.mActive = param1ConditionalUserProperty.mActive;
      this.mTriggerEventName = param1ConditionalUserProperty.mTriggerEventName;
      this.mTriggerTimeout = param1ConditionalUserProperty.mTriggerTimeout;
      this.mTimedOutEventName = param1ConditionalUserProperty.mTimedOutEventName;
      object = param1ConditionalUserProperty.mTimedOutEventParams;
      if (object != null)
        this.mTimedOutEventParams = new Bundle((Bundle)object); 
      this.mTriggeredEventName = param1ConditionalUserProperty.mTriggeredEventName;
      object = param1ConditionalUserProperty.mTriggeredEventParams;
      if (object != null)
        this.mTriggeredEventParams = new Bundle((Bundle)object); 
      this.mTriggeredTimestamp = param1ConditionalUserProperty.mTriggeredTimestamp;
      this.mTimeToLive = param1ConditionalUserProperty.mTimeToLive;
      this.mExpiredEventName = param1ConditionalUserProperty.mExpiredEventName;
      Bundle bundle = param1ConditionalUserProperty.mExpiredEventParams;
      if (bundle != null)
        this.mExpiredEventParams = new Bundle(bundle); 
    }
    
    private final Bundle zzf() {
      Bundle bundle = new Bundle();
      String str = this.mAppId;
      if (str != null)
        bundle.putString("app_id", str); 
      str = this.mOrigin;
      if (str != null)
        bundle.putString("origin", str); 
      str = this.mName;
      if (str != null)
        bundle.putString("name", str); 
      Object object = this.mValue;
      if (object != null)
        zzcw.zza(bundle, object); 
      object = this.mTriggerEventName;
      if (object != null)
        bundle.putString("trigger_event_name", (String)object); 
      bundle.putLong("trigger_timeout", this.mTriggerTimeout);
      object = this.mTimedOutEventName;
      if (object != null)
        bundle.putString("timed_out_event_name", (String)object); 
      object = this.mTimedOutEventParams;
      if (object != null)
        bundle.putBundle("timed_out_event_params", (Bundle)object); 
      object = this.mTriggeredEventName;
      if (object != null)
        bundle.putString("triggered_event_name", (String)object); 
      object = this.mTriggeredEventParams;
      if (object != null)
        bundle.putBundle("triggered_event_params", (Bundle)object); 
      bundle.putLong("time_to_live", this.mTimeToLive);
      object = this.mExpiredEventName;
      if (object != null)
        bundle.putString("expired_event_name", (String)object); 
      object = this.mExpiredEventParams;
      if (object != null)
        bundle.putBundle("expired_event_params", (Bundle)object); 
      bundle.putLong("creation_timestamp", this.mCreationTimestamp);
      bundle.putBoolean("active", this.mActive);
      bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
      return bundle;
    }
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static final class Event extends zzcx {
    @KeepForSdk
    @ShowFirstParty
    public static final String AD_REWARD = "_ar";
    
    @KeepForSdk
    @ShowFirstParty
    public static final String APP_EXCEPTION = "_ae";
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
  
  @KeepForSdk
  @ShowFirstParty
  public static final class Param extends zzcy {
    @KeepForSdk
    @ShowFirstParty
    public static final String FATAL = "fatal";
    
    @KeepForSdk
    @ShowFirstParty
    public static final String TIMESTAMP = "timestamp";
    
    @KeepForSdk
    @ShowFirstParty
    public static final String TYPE = "type";
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static final class UserProperty extends zzcz {
    @KeepForSdk
    @ShowFirstParty
    public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */