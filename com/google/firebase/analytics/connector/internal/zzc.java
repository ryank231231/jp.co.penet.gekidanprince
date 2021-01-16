package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzeb;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzc {
  private static final Set<String> zzaba = new HashSet<String>(Arrays.asList(new String[] { 
          "_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", 
          "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire" }));
  
  private static final List<String> zzabb = Arrays.asList(new String[] { "_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open" });
  
  private static final List<String> zzabc = Arrays.asList(new String[] { "auto", "app", "am" });
  
  private static final List<String> zzabd = Arrays.asList(new String[] { "_r", "_dbg" });
  
  private static final List<String> zzabe = Arrays.asList((String[])ArrayUtils.concat((Object[][])new String[][] { AppMeasurement.UserProperty.zzpc, AppMeasurement.UserProperty.zzpd }));
  
  private static final List<String> zzabf = Arrays.asList(new String[] { "^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$" });
  
  public static boolean zza(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty) {
    if (paramConditionalUserProperty == null)
      return false; 
    String str = paramConditionalUserProperty.origin;
    if (str == null || str.isEmpty())
      return false; 
    if (paramConditionalUserProperty.value != null && zzeb.zza(paramConditionalUserProperty.value) == null)
      return false; 
    if (!zzcg(str))
      return false; 
    if (!zzu(str, paramConditionalUserProperty.name))
      return false; 
    if (paramConditionalUserProperty.expiredEventName != null) {
      if (!zza(paramConditionalUserProperty.expiredEventName, paramConditionalUserProperty.expiredEventParams))
        return false; 
      if (!zzb(str, paramConditionalUserProperty.expiredEventName, paramConditionalUserProperty.expiredEventParams))
        return false; 
    } 
    if (paramConditionalUserProperty.triggeredEventName != null) {
      if (!zza(paramConditionalUserProperty.triggeredEventName, paramConditionalUserProperty.triggeredEventParams))
        return false; 
      if (!zzb(str, paramConditionalUserProperty.triggeredEventName, paramConditionalUserProperty.triggeredEventParams))
        return false; 
    } 
    if (paramConditionalUserProperty.timedOutEventName != null) {
      if (!zza(paramConditionalUserProperty.timedOutEventName, paramConditionalUserProperty.timedOutEventParams))
        return false; 
      if (!zzb(str, paramConditionalUserProperty.timedOutEventName, paramConditionalUserProperty.timedOutEventParams))
        return false; 
    } 
    return true;
  }
  
  public static boolean zza(@NonNull String paramString, @Nullable Bundle paramBundle) {
    if (zzabb.contains(paramString))
      return false; 
    if (paramBundle != null) {
      Iterator<String> iterator = zzabd.iterator();
      while (iterator.hasNext()) {
        if (paramBundle.containsKey(iterator.next()))
          return false; 
      } 
    } 
    return true;
  }
  
  public static AppMeasurement.ConditionalUserProperty zzb(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty) {
    AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
    conditionalUserProperty.mOrigin = paramConditionalUserProperty.origin;
    conditionalUserProperty.mActive = paramConditionalUserProperty.active;
    conditionalUserProperty.mCreationTimestamp = paramConditionalUserProperty.creationTimestamp;
    conditionalUserProperty.mExpiredEventName = paramConditionalUserProperty.expiredEventName;
    if (paramConditionalUserProperty.expiredEventParams != null)
      conditionalUserProperty.mExpiredEventParams = new Bundle(paramConditionalUserProperty.expiredEventParams); 
    conditionalUserProperty.mName = paramConditionalUserProperty.name;
    conditionalUserProperty.mTimedOutEventName = paramConditionalUserProperty.timedOutEventName;
    if (paramConditionalUserProperty.timedOutEventParams != null)
      conditionalUserProperty.mTimedOutEventParams = new Bundle(paramConditionalUserProperty.timedOutEventParams); 
    conditionalUserProperty.mTimeToLive = paramConditionalUserProperty.timeToLive;
    conditionalUserProperty.mTriggeredEventName = paramConditionalUserProperty.triggeredEventName;
    if (paramConditionalUserProperty.triggeredEventParams != null)
      conditionalUserProperty.mTriggeredEventParams = new Bundle(paramConditionalUserProperty.triggeredEventParams); 
    conditionalUserProperty.mTriggeredTimestamp = paramConditionalUserProperty.triggeredTimestamp;
    conditionalUserProperty.mTriggerEventName = paramConditionalUserProperty.triggerEventName;
    conditionalUserProperty.mTriggerTimeout = paramConditionalUserProperty.triggerTimeout;
    if (paramConditionalUserProperty.value != null)
      conditionalUserProperty.mValue = zzeb.zza(paramConditionalUserProperty.value); 
    return conditionalUserProperty;
  }
  
  public static AnalyticsConnector.ConditionalUserProperty zzb(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty) {
    AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
    conditionalUserProperty.origin = paramConditionalUserProperty.mOrigin;
    conditionalUserProperty.active = paramConditionalUserProperty.mActive;
    conditionalUserProperty.creationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
    conditionalUserProperty.expiredEventName = paramConditionalUserProperty.mExpiredEventName;
    if (paramConditionalUserProperty.mExpiredEventParams != null)
      conditionalUserProperty.expiredEventParams = new Bundle(paramConditionalUserProperty.mExpiredEventParams); 
    conditionalUserProperty.name = paramConditionalUserProperty.mName;
    conditionalUserProperty.timedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
    if (paramConditionalUserProperty.mTimedOutEventParams != null)
      conditionalUserProperty.timedOutEventParams = new Bundle(paramConditionalUserProperty.mTimedOutEventParams); 
    conditionalUserProperty.timeToLive = paramConditionalUserProperty.mTimeToLive;
    conditionalUserProperty.triggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
    if (paramConditionalUserProperty.mTriggeredEventParams != null)
      conditionalUserProperty.triggeredEventParams = new Bundle(paramConditionalUserProperty.mTriggeredEventParams); 
    conditionalUserProperty.triggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
    conditionalUserProperty.triggerEventName = paramConditionalUserProperty.mTriggerEventName;
    conditionalUserProperty.triggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
    if (paramConditionalUserProperty.mValue != null)
      conditionalUserProperty.value = zzeb.zza(paramConditionalUserProperty.mValue); 
    return conditionalUserProperty;
  }
  
  public static boolean zzb(@NonNull String paramString1, @NonNull String paramString2, @Nullable Bundle paramBundle) {
    // Byte code:
    //   0: ldc_w '_cmp'
    //   3: aload_1
    //   4: invokevirtual equals : (Ljava/lang/Object;)Z
    //   7: ifne -> 12
    //   10: iconst_1
    //   11: ireturn
    //   12: aload_0
    //   13: invokestatic zzcg : (Ljava/lang/String;)Z
    //   16: ifne -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: ifnonnull -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: getstatic com/google/firebase/analytics/connector/internal/zzc.zzabd : Ljava/util/List;
    //   30: invokeinterface iterator : ()Ljava/util/Iterator;
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface hasNext : ()Z
    //   42: ifeq -> 63
    //   45: aload_2
    //   46: aload_1
    //   47: invokeinterface next : ()Ljava/lang/Object;
    //   52: checkcast java/lang/String
    //   55: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   58: ifeq -> 36
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: invokevirtual hashCode : ()I
    //   67: istore_3
    //   68: iload_3
    //   69: ldc_w 101200
    //   72: if_icmpeq -> 122
    //   75: iload_3
    //   76: ldc_w 101230
    //   79: if_icmpeq -> 107
    //   82: iload_3
    //   83: ldc_w 3142703
    //   86: if_icmpeq -> 92
    //   89: goto -> 137
    //   92: aload_0
    //   93: ldc_w 'fiam'
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifeq -> 137
    //   102: iconst_2
    //   103: istore_3
    //   104: goto -> 139
    //   107: aload_0
    //   108: ldc_w 'fdl'
    //   111: invokevirtual equals : (Ljava/lang/Object;)Z
    //   114: ifeq -> 137
    //   117: iconst_1
    //   118: istore_3
    //   119: goto -> 139
    //   122: aload_0
    //   123: ldc_w 'fcm'
    //   126: invokevirtual equals : (Ljava/lang/Object;)Z
    //   129: ifeq -> 137
    //   132: iconst_0
    //   133: istore_3
    //   134: goto -> 139
    //   137: iconst_m1
    //   138: istore_3
    //   139: iload_3
    //   140: tableswitch default -> 168, 0 -> 194, 1 -> 182, 2 -> 170
    //   168: iconst_0
    //   169: ireturn
    //   170: aload_2
    //   171: ldc_w '_cis'
    //   174: ldc_w 'fiam_integration'
    //   177: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   180: iconst_1
    //   181: ireturn
    //   182: aload_2
    //   183: ldc_w '_cis'
    //   186: ldc_w 'fdl_integration'
    //   189: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   192: iconst_1
    //   193: ireturn
    //   194: aload_2
    //   195: ldc_w '_cis'
    //   198: ldc_w 'fcm_integration'
    //   201: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   204: iconst_1
    //   205: ireturn
  }
  
  public static boolean zzcg(@NonNull String paramString) {
    return !zzabc.contains(paramString);
  }
  
  public static boolean zzch(@NonNull String paramString) {
    return !zzaba.contains(paramString);
  }
  
  public static boolean zzci(String paramString) {
    if (paramString == null)
      return false; 
    if (paramString.length() == 0)
      return false; 
    int i = paramString.codePointAt(0);
    if (!Character.isLetter(i))
      return false; 
    int j = paramString.length();
    for (i = Character.charCount(i); i < j; i += Character.charCount(k)) {
      int k = paramString.codePointAt(i);
      if (k != 95 && !Character.isLetterOrDigit(k))
        return false; 
    } 
    return true;
  }
  
  public static boolean zzcj(String paramString) {
    if (paramString == null)
      return false; 
    if (paramString.length() == 0)
      return false; 
    int i = paramString.codePointAt(0);
    if (!Character.isLetter(i) && i != 95)
      return false; 
    int j = paramString.length();
    for (i = Character.charCount(i); i < j; i += Character.charCount(k)) {
      int k = paramString.codePointAt(i);
      if (k != 95 && !Character.isLetterOrDigit(k))
        return false; 
    } 
    return true;
  }
  
  public static String zzck(String paramString) {
    String str = AppMeasurement.Event.zzbg(paramString);
    return (str != null) ? str : paramString;
  }
  
  public static String zzcl(String paramString) {
    String str = AppMeasurement.Event.zzbh(paramString);
    return (str != null) ? str : paramString;
  }
  
  public static boolean zzu(@NonNull String paramString1, @NonNull String paramString2) {
    if ("_ce1".equals(paramString2) || "_ce2".equals(paramString2))
      return (paramString1.equals("fcm") || paramString1.equals("frc")); 
    if ("_ln".equals(paramString2))
      return (paramString1.equals("fcm") || paramString1.equals("fiam")); 
    if (zzabe.contains(paramString2))
      return false; 
    Iterator<String> iterator = zzabf.iterator();
    while (iterator.hasNext()) {
      if (paramString2.matches(iterator.next()))
        return false; 
    } 
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */