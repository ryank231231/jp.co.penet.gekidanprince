package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

public final class zzg {
  private static volatile boolean zziy = zzam() ^ true;
  
  @TargetApi(24)
  @RequiresApi(24)
  public static Context getDeviceProtectedStorageContext(Context paramContext) {
    return paramContext.isDeviceProtectedStorage() ? paramContext : paramContext.createDeviceProtectedStorageContext();
  }
  
  public static boolean zzam() {
    return (Build.VERSION.SDK_INT >= 24);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\common\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */