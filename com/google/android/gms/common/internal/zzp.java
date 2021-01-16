package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

public final class zzp {
  private static Object sLock = new Object();
  
  @GuardedBy("sLock")
  private static boolean zzeo;
  
  private static String zzep;
  
  private static int zzeq;
  
  public static String zzc(Context paramContext) {
    zze(paramContext);
    return zzep;
  }
  
  public static int zzd(Context paramContext) {
    zze(paramContext);
    return zzeq;
  }
  
  private static void zze(Context paramContext) {
    synchronized (sLock) {
      if (zzeo)
        return; 
      zzeo = true;
      String str = paramContext.getPackageName();
      PackageManagerWrapper packageManagerWrapper = Wrappers.packageManager(paramContext);
      try {
        Bundle bundle = (packageManagerWrapper.getApplicationInfo(str, 128)).metaData;
        if (bundle == null)
          return; 
        zzep = bundle.getString("com.google.app.id");
        zzeq = bundle.getInt("com.google.android.gms.version");
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.wtf("MetadataValueReader", "This should never happen.", (Throwable)nameNotFoundException);
      } 
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */