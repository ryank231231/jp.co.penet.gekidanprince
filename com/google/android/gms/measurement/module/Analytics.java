package com.google.android.gms.measurement.module;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.measurement.internal.zzby;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;

@ShowFirstParty
public class Analytics {
  @KeepForSdk
  @ShowFirstParty
  public static final String CRASH_ORIGIN = "crash";
  
  @KeepForSdk
  @ShowFirstParty
  public static final String FCM_ORIGIN = "fcm";
  
  @KeepForSdk
  @ShowFirstParty
  public static final String FIAM_ORIGIN = "fiam";
  
  private static volatile Analytics zzth;
  
  private final zzby zzl;
  
  private Analytics(zzby paramzzby) {
    Preconditions.checkNotNull(paramzzby);
    this.zzl = paramzzby;
  }
  
  @Keep
  @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  @ShowFirstParty
  public static Analytics getInstance(Context paramContext) {
    // Byte code:
    //   0: getstatic com/google/android/gms/measurement/module/Analytics.zzth : Lcom/google/android/gms/measurement/module/Analytics;
    //   3: ifnonnull -> 46
    //   6: ldc com/google/android/gms/measurement/module/Analytics
    //   8: monitorenter
    //   9: getstatic com/google/android/gms/measurement/module/Analytics.zzth : Lcom/google/android/gms/measurement/module/Analytics;
    //   12: ifnonnull -> 34
    //   15: aload_0
    //   16: aconst_null
    //   17: invokestatic zza : (Landroid/content/Context;Lcom/google/android/gms/internal/measurement/zzy;)Lcom/google/android/gms/measurement/internal/zzby;
    //   20: astore_1
    //   21: new com/google/android/gms/measurement/module/Analytics
    //   24: astore_0
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzby;)V
    //   30: aload_0
    //   31: putstatic com/google/android/gms/measurement/module/Analytics.zzth : Lcom/google/android/gms/measurement/module/Analytics;
    //   34: ldc com/google/android/gms/measurement/module/Analytics
    //   36: monitorexit
    //   37: goto -> 46
    //   40: astore_0
    //   41: ldc com/google/android/gms/measurement/module/Analytics
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: getstatic com/google/android/gms/measurement/module/Analytics.zzth : Lcom/google/android/gms/measurement/module/Analytics;
    //   49: areturn
    // Exception table:
    //   from	to	target	type
    //   9	34	40	finally
    //   34	37	40	finally
    //   41	44	40	finally
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
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\module\Analytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */