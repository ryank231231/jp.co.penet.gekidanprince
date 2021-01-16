package com.google.android.gms.common.stats;

import android.content.ComponentName;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class LoggingConstants {
  @KeepForSdk
  public static final String EXTRA_WAKE_LOCK_KEY = "WAKE_LOCK_KEY";
  
  private static int LOG_LEVEL_OFF;
  
  public static final ComponentName zzfg = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
  
  private static int zzfh;
  
  private static int zzfi;
  
  private static int zzfj;
  
  private static int zzfk;
  
  private static int zzfl;
  
  private static int zzfm;
  
  private static int zzfn;
  
  static {
    LOG_LEVEL_OFF = 0;
    zzfh = 1;
    zzfi = 2;
    zzfj = 4;
    zzfk = 8;
    zzfl = 16;
    zzfm = 32;
    zzfn = 1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\stats\LoggingConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */