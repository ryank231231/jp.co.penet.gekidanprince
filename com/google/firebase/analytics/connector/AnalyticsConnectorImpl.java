package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zzf;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
  private static volatile AnalyticsConnector zzaat;
  
  @VisibleForTesting
  private final AppMeasurement zzaau;
  
  @VisibleForTesting
  final Map<String, zza> zzaav;
  
  private AnalyticsConnectorImpl(AppMeasurement paramAppMeasurement) {
    Preconditions.checkNotNull(paramAppMeasurement);
    this.zzaau = paramAppMeasurement;
    this.zzaav = new ConcurrentHashMap<String, zza>();
  }
  
  @KeepForSdk
  public static AnalyticsConnector getInstance() {
    return getInstance(FirebaseApp.getInstance());
  }
  
  @KeepForSdk
  public static AnalyticsConnector getInstance(FirebaseApp paramFirebaseApp) {
    return (AnalyticsConnector)paramFirebaseApp.get(AnalyticsConnector.class);
  }
  
  @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @KeepForSdk
  public static AnalyticsConnector getInstance(FirebaseApp paramFirebaseApp, Context paramContext, Subscriber paramSubscriber) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_2
    //   11: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: pop
    //   15: aload_1
    //   16: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   19: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: pop
    //   23: getstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzaat : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   26: ifnonnull -> 107
    //   29: ldc com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   31: monitorenter
    //   32: getstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzaat : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   35: ifnonnull -> 95
    //   38: new android/os/Bundle
    //   41: astore_3
    //   42: aload_3
    //   43: iconst_1
    //   44: invokespecial <init> : (I)V
    //   47: aload_0
    //   48: invokevirtual isDefaultApp : ()Z
    //   51: ifeq -> 78
    //   54: aload_2
    //   55: ldc com/google/firebase/DataCollectionDefaultChange
    //   57: getstatic com/google/firebase/analytics/connector/zza.zzaaw : Ljava/util/concurrent/Executor;
    //   60: getstatic com/google/firebase/analytics/connector/zzb.zzaax : Lcom/google/firebase/events/EventHandler;
    //   63: invokeinterface subscribe : (Ljava/lang/Class;Ljava/util/concurrent/Executor;Lcom/google/firebase/events/EventHandler;)V
    //   68: aload_3
    //   69: ldc 'dataCollectionDefaultEnabled'
    //   71: aload_0
    //   72: invokevirtual isDataCollectionDefaultEnabled : ()Z
    //   75: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   78: new com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   81: astore_0
    //   82: aload_0
    //   83: aload_1
    //   84: aload_3
    //   85: invokestatic zza : (Landroid/content/Context;Landroid/os/Bundle;)Lcom/google/android/gms/measurement/AppMeasurement;
    //   88: invokespecial <init> : (Lcom/google/android/gms/measurement/AppMeasurement;)V
    //   91: aload_0
    //   92: putstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzaat : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   95: ldc com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   97: monitorexit
    //   98: goto -> 107
    //   101: astore_0
    //   102: ldc com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    //   107: getstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzaat : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   110: areturn
    // Exception table:
    //   from	to	target	type
    //   32	78	101	finally
    //   78	95	101	finally
    //   95	98	101	finally
    //   102	105	101	finally
  }
  
  private final boolean zzcf(@NonNull String paramString) {
    return (!paramString.isEmpty() && this.zzaav.containsKey(paramString) && this.zzaav.get(paramString) != null);
  }
  
  @KeepForSdk
  public void clearConditionalUserProperty(@NonNull @Size(max = 24L, min = 1L) String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle) {
    if (paramString2 != null && !zzc.zza(paramString2, paramBundle))
      return; 
    this.zzaau.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  @WorkerThread
  @KeepForSdk
  public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String paramString1, @Nullable @Size(max = 23L, min = 1L) String paramString2) {
    ArrayList<AnalyticsConnector.ConditionalUserProperty> arrayList = new ArrayList();
    Iterator<AppMeasurement.ConditionalUserProperty> iterator = this.zzaau.getConditionalUserProperties(paramString1, paramString2).iterator();
    while (iterator.hasNext())
      arrayList.add(zzc.zzb(iterator.next())); 
    return arrayList;
  }
  
  @WorkerThread
  @KeepForSdk
  public int getMaxUserProperties(@NonNull @Size(min = 1L) String paramString) {
    return this.zzaau.getMaxUserProperties(paramString);
  }
  
  @WorkerThread
  @KeepForSdk
  public Map<String, Object> getUserProperties(boolean paramBoolean) {
    return this.zzaau.getUserProperties(paramBoolean);
  }
  
  @KeepForSdk
  public void logEvent(@NonNull String paramString1, @NonNull String paramString2, Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    if (!zzc.zzcg(paramString1))
      return; 
    if (!zzc.zza(paramString2, bundle))
      return; 
    if (!zzc.zzb(paramString1, paramString2, bundle))
      return; 
    this.zzaau.logEventInternal(paramString1, paramString2, bundle);
  }
  
  @WorkerThread
  @KeepForSdk
  public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String paramString, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener) {
    zzd zzd;
    Preconditions.checkNotNull(paramAnalyticsConnectorListener);
    if (!zzc.zzcg(paramString))
      return null; 
    if (zzcf(paramString))
      return null; 
    AppMeasurement appMeasurement = this.zzaau;
    if ("fiam".equals(paramString)) {
      zzd = new zzd(appMeasurement, paramAnalyticsConnectorListener);
    } else if ("crash".equals(paramString)) {
      zzf zzf = new zzf(appMeasurement, (AnalyticsConnector.AnalyticsConnectorListener)zzd);
    } else {
      zzd = null;
    } 
    if (zzd != null) {
      this.zzaav.put(paramString, zzd);
      return new AnalyticsConnector.AnalyticsConnectorHandle(this, paramString) {
          @KeepForSdk
          public void registerEventNames(Set<String> param1Set) {
            if (!AnalyticsConnectorImpl.zza(this.zzaay, this.zzao) || !this.zzao.equals("fiam") || param1Set == null || param1Set.isEmpty())
              return; 
            ((zza)this.zzaay.zzaav.get(this.zzao)).registerEventNames(param1Set);
          }
          
          public void unregister() {
            if (!AnalyticsConnectorImpl.zza(this.zzaay, this.zzao))
              return; 
            AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener = ((zza)this.zzaay.zzaav.get(this.zzao)).zzju();
            if (analyticsConnectorListener != null)
              analyticsConnectorListener.onMessageTriggered(0, null); 
            this.zzaay.zzaav.remove(this.zzao);
          }
          
          @KeepForSdk
          public void unregisterEventNames() {
            if (!AnalyticsConnectorImpl.zza(this.zzaay, this.zzao) || !this.zzao.equals("fiam"))
              return; 
            ((zza)this.zzaay.zzaav.get(this.zzao)).unregisterEventNames();
          }
        };
    } 
    return null;
  }
  
  @KeepForSdk
  public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty) {
    if (!zzc.zza(paramConditionalUserProperty))
      return; 
    this.zzaau.setConditionalUserProperty(zzc.zzb(paramConditionalUserProperty));
  }
  
  @KeepForSdk
  public void setUserProperty(@NonNull String paramString1, @NonNull String paramString2, Object paramObject) {
    if (!zzc.zzcg(paramString1))
      return; 
    if (!zzc.zzu(paramString1, paramString2))
      return; 
    this.zzaau.setUserPropertyInternal(paramString1, paramString2, paramObject);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\connector\AnalyticsConnectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */