package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zza;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public class WakeLockTracker {
  private static WakeLockTracker zzgc = new WakeLockTracker();
  
  private static Boolean zzgd;
  
  @VisibleForTesting
  private static boolean zzge = false;
  
  @KeepForSdk
  public static WakeLockTracker getInstance() {
    return zzgc;
  }
  
  private static void zza(Context paramContext, WakeLockEvent paramWakeLockEvent) {
    try {
      Intent intent = new Intent();
      this();
      paramContext.startService(intent.setComponent(LoggingConstants.zzfg).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (Parcelable)paramWakeLockEvent));
      return;
    } catch (Exception exception) {
      Log.wtf("WakeLockTracker", exception);
      return;
    } 
  }
  
  private static boolean zzw() {
    if (zzgd == null)
      zzgd = Boolean.valueOf(false); 
    return zzgd.booleanValue();
  }
  
  @KeepForSdk
  public void registerAcquireEvent(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {
    List<String> list = Arrays.asList(new String[] { paramString4 });
    registerEvent(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 7, paramString1, paramString2, paramString3, paramInt, list);
  }
  
  @KeepForSdk
  public void registerDeadlineEvent(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList, boolean paramBoolean, long paramLong) {
    if (!zzw())
      return; 
    zza(paramContext, new WakeLockEvent(System.currentTimeMillis(), 16, paramString1, paramInt, StatsUtils.zza(paramList), null, paramLong, zza.zzg(paramContext), paramString2, StatsUtils.zzi(paramContext.getPackageName()), zza.zzh(paramContext), 0L, paramString3, paramBoolean));
  }
  
  @KeepForSdk
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList) {
    registerEvent(paramContext, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
  }
  
  @KeepForSdk
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList, long paramLong) {
    String str;
    if (!zzw())
      return; 
    if (TextUtils.isEmpty(paramString1)) {
      str = String.valueOf(paramString1);
      if (str.length() != 0) {
        str = "missing wakeLock key. ".concat(str);
      } else {
        str = new String("missing wakeLock key. ");
      } 
      Log.e("WakeLockTracker", str);
      return;
    } 
    if (7 == paramInt1 || 8 == paramInt1 || 10 == paramInt1 || 11 == paramInt1)
      zza((Context)str, new WakeLockEvent(System.currentTimeMillis(), paramInt1, paramString2, paramInt2, StatsUtils.zza(paramList), paramString1, SystemClock.elapsedRealtime(), zza.zzg((Context)str), paramString3, StatsUtils.zzi(str.getPackageName()), zza.zzh((Context)str), paramLong, paramString4, false)); 
  }
  
  @KeepForSdk
  public void registerReleaseEvent(Context paramContext, Intent paramIntent) {
    registerEvent(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 8, null, null, null, 0, null);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\stats\WakeLockTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */