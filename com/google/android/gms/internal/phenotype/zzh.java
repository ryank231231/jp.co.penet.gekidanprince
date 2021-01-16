package com.google.android.gms.internal.phenotype;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

public final class zzh<T> {
  private static final Object zzak = new Object();
  
  @SuppressLint({"StaticFieldLeak"})
  private static Context zzal = null;
  
  private static boolean zzam = false;
  
  private static volatile Boolean zzan = null;
  
  private static volatile Boolean zzbq = null;
  
  public static void init(Context paramContext) {
    synchronized (zzak) {
      if (Build.VERSION.SDK_INT < 24 || !paramContext.isDeviceProtectedStorage()) {
        Context context = paramContext.getApplicationContext();
        if (context != null)
          paramContext = context; 
      } 
      if (zzal != paramContext)
        zzan = null; 
      zzal = paramContext;
      zzam = false;
      return;
    } 
  }
  
  public static void maybeInit(Context paramContext) {
    if (zzal == null)
      init(paramContext); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\phenotype\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */