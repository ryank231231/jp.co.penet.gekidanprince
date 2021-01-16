package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
public class StatsUtils {
  @KeepForSdk
  public static String getEventKey(Context paramContext, Intent paramIntent) {
    long l = System.identityHashCode(paramContext);
    return String.valueOf(System.identityHashCode(paramIntent) | l << 32L);
  }
  
  @KeepForSdk
  public static String getEventKey(PowerManager.WakeLock paramWakeLock, String paramString) {
    String str2 = String.valueOf(String.valueOf(Process.myPid() << 32L | System.identityHashCode(paramWakeLock)));
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString))
      str1 = ""; 
    str1 = String.valueOf(str1);
    return (str1.length() != 0) ? str2.concat(str1) : new String(str2);
  }
  
  @Nullable
  static List<String> zza(@Nullable List<String> paramList) {
    List<String> list = paramList;
    if (paramList != null) {
      list = paramList;
      if (paramList.size() == 1) {
        list = paramList;
        if ("com.google.android.gms".equals(paramList.get(0)))
          list = null; 
      } 
    } 
    return list;
  }
  
  @Nullable
  static String zzi(String paramString) {
    return "com.google.android.gms".equals(paramString) ? null : paramString;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\stats\StatsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */