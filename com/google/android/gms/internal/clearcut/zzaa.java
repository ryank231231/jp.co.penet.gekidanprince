package com.google.android.gms.internal.clearcut;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class zzaa {
  private static volatile UserManager zzdc;
  
  private static volatile boolean zzdd = zzf() ^ true;
  
  public static boolean zze(Context paramContext) {
    return (zzf() && !zzf(paramContext));
  }
  
  private static boolean zzf() {
    return (Build.VERSION.SDK_INT >= 24);
  }
  
  @TargetApi(24)
  private static boolean zzf(Context paramContext) {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/clearcut/zzaa.zzdd : Z
    //   3: istore_1
    //   4: iload_1
    //   5: istore_2
    //   6: iload_1
    //   7: ifne -> 99
    //   10: getstatic com/google/android/gms/internal/clearcut/zzaa.zzdc : Landroid/os/UserManager;
    //   13: astore_3
    //   14: aload_3
    //   15: astore #4
    //   17: aload_3
    //   18: ifnonnull -> 77
    //   21: ldc com/google/android/gms/internal/clearcut/zzaa
    //   23: monitorenter
    //   24: getstatic com/google/android/gms/internal/clearcut/zzaa.zzdc : Landroid/os/UserManager;
    //   27: astore_3
    //   28: aload_3
    //   29: astore #4
    //   31: aload_3
    //   32: ifnonnull -> 65
    //   35: aload_0
    //   36: ldc android/os/UserManager
    //   38: invokevirtual getSystemService : (Ljava/lang/Class;)Ljava/lang/Object;
    //   41: checkcast android/os/UserManager
    //   44: astore #4
    //   46: aload #4
    //   48: putstatic com/google/android/gms/internal/clearcut/zzaa.zzdc : Landroid/os/UserManager;
    //   51: aload #4
    //   53: ifnonnull -> 65
    //   56: iconst_1
    //   57: putstatic com/google/android/gms/internal/clearcut/zzaa.zzdd : Z
    //   60: ldc com/google/android/gms/internal/clearcut/zzaa
    //   62: monitorexit
    //   63: iconst_1
    //   64: ireturn
    //   65: ldc com/google/android/gms/internal/clearcut/zzaa
    //   67: monitorexit
    //   68: goto -> 77
    //   71: astore_0
    //   72: ldc com/google/android/gms/internal/clearcut/zzaa
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: aload #4
    //   79: invokevirtual isUserUnlocked : ()Z
    //   82: istore_1
    //   83: iload_1
    //   84: putstatic com/google/android/gms/internal/clearcut/zzaa.zzdd : Z
    //   87: iload_1
    //   88: istore_2
    //   89: iload_1
    //   90: ifeq -> 99
    //   93: aconst_null
    //   94: putstatic com/google/android/gms/internal/clearcut/zzaa.zzdc : Landroid/os/UserManager;
    //   97: iload_1
    //   98: istore_2
    //   99: iload_2
    //   100: ireturn
    // Exception table:
    //   from	to	target	type
    //   24	28	71	finally
    //   35	51	71	finally
    //   56	63	71	finally
    //   65	68	71	finally
    //   72	75	71	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */