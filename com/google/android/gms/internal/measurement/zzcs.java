package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.util.Log;

final class zzcs implements zzcp {
  @GuardedBy("GservicesLoader.class")
  static zzcs zzzq;
  
  private final Context zzno = null;
  
  private zzcs() {}
  
  private zzcs(Context paramContext) {
    this.zzno.getContentResolver().registerContentObserver(zzci.CONTENT_URI, true, new zzcu(this, null));
  }
  
  private final String zzcb(String paramString) {
    if (this.zzno == null)
      return null; 
    try {
      zzct zzct = new zzct();
      this(this, paramString);
      return zzcq.<String>zza(zzct);
    } catch (SecurityException securityException) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Unable to read GServices for: ".concat(paramString);
      } else {
        paramString = new String("Unable to read GServices for: ");
      } 
      Log.e("GservicesLoader", paramString, securityException);
      return null;
    } 
  }
  
  static zzcs zzp(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/measurement/zzcs
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/internal/measurement/zzcs.zzzq : Lcom/google/android/gms/internal/measurement/zzcs;
    //   6: ifnonnull -> 55
    //   9: aload_0
    //   10: ldc 'com.google.android.providers.gsf.permission.READ_GSERVICES'
    //   12: invokestatic checkSelfPermission : (Landroid/content/Context;Ljava/lang/String;)I
    //   15: ifne -> 23
    //   18: iconst_1
    //   19: istore_1
    //   20: goto -> 25
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_1
    //   26: ifeq -> 43
    //   29: new com/google/android/gms/internal/measurement/zzcs
    //   32: astore_2
    //   33: aload_2
    //   34: aload_0
    //   35: invokespecial <init> : (Landroid/content/Context;)V
    //   38: aload_2
    //   39: astore_0
    //   40: goto -> 51
    //   43: new com/google/android/gms/internal/measurement/zzcs
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: astore_0
    //   51: aload_0
    //   52: putstatic com/google/android/gms/internal/measurement/zzcs.zzzq : Lcom/google/android/gms/internal/measurement/zzcs;
    //   55: getstatic com/google/android/gms/internal/measurement/zzcs.zzzq : Lcom/google/android/gms/internal/measurement/zzcs;
    //   58: astore_0
    //   59: ldc com/google/android/gms/internal/measurement/zzcs
    //   61: monitorexit
    //   62: aload_0
    //   63: areturn
    //   64: astore_0
    //   65: ldc com/google/android/gms/internal/measurement/zzcs
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	64	finally
    //   29	38	64	finally
    //   43	51	64	finally
    //   51	55	64	finally
    //   55	62	64	finally
    //   65	68	64	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */