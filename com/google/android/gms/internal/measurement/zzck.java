package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;

public class zzck {
  private static volatile UserManager zzzg;
  
  private static volatile boolean zzzh = zzji() ^ true;
  
  public static boolean isUserUnlocked(Context paramContext) {
    return (!zzji() || zzn(paramContext));
  }
  
  public static boolean zzji() {
    return (Build.VERSION.SDK_INT >= 24);
  }
  
  @TargetApi(24)
  @RequiresApi(24)
  private static boolean zzn(Context paramContext) {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/measurement/zzck.zzzh : Z
    //   3: istore_1
    //   4: iload_1
    //   5: istore_2
    //   6: iload_1
    //   7: ifne -> 112
    //   10: iconst_1
    //   11: istore_3
    //   12: iload_3
    //   13: iconst_2
    //   14: if_icmpgt -> 100
    //   17: aload_0
    //   18: invokestatic zzo : (Landroid/content/Context;)Landroid/os/UserManager;
    //   21: astore #4
    //   23: aload #4
    //   25: ifnonnull -> 34
    //   28: iconst_1
    //   29: putstatic com/google/android/gms/internal/measurement/zzck.zzzh : Z
    //   32: iconst_1
    //   33: ireturn
    //   34: iload_1
    //   35: istore_2
    //   36: aload #4
    //   38: invokevirtual isUserUnlocked : ()Z
    //   41: ifne -> 65
    //   44: iload_1
    //   45: istore_2
    //   46: aload #4
    //   48: invokestatic myUserHandle : ()Landroid/os/UserHandle;
    //   51: invokevirtual isUserRunning : (Landroid/os/UserHandle;)Z
    //   54: ifne -> 60
    //   57: goto -> 65
    //   60: iconst_0
    //   61: istore_1
    //   62: goto -> 67
    //   65: iconst_1
    //   66: istore_1
    //   67: iload_1
    //   68: istore_2
    //   69: iload_1
    //   70: putstatic com/google/android/gms/internal/measurement/zzck.zzzh : Z
    //   73: goto -> 100
    //   76: astore #4
    //   78: ldc 'DirectBootUtils'
    //   80: ldc 'Failed to check if user is unlocked'
    //   82: aload #4
    //   84: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   87: pop
    //   88: aconst_null
    //   89: putstatic com/google/android/gms/internal/measurement/zzck.zzzg : Landroid/os/UserManager;
    //   92: iinc #3, 1
    //   95: iload_2
    //   96: istore_1
    //   97: goto -> 12
    //   100: iload_1
    //   101: istore_2
    //   102: iload_1
    //   103: ifeq -> 112
    //   106: aconst_null
    //   107: putstatic com/google/android/gms/internal/measurement/zzck.zzzg : Landroid/os/UserManager;
    //   110: iload_1
    //   111: istore_2
    //   112: iload_2
    //   113: ireturn
    // Exception table:
    //   from	to	target	type
    //   36	44	76	java/lang/NullPointerException
    //   46	57	76	java/lang/NullPointerException
    //   69	73	76	java/lang/NullPointerException
  }
  
  @TargetApi(24)
  @RequiresApi(24)
  @VisibleForTesting
  private static UserManager zzo(Context paramContext) {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/measurement/zzck.zzzg : Landroid/os/UserManager;
    //   3: astore_1
    //   4: aload_1
    //   5: astore_2
    //   6: aload_1
    //   7: ifnonnull -> 49
    //   10: ldc com/google/android/gms/internal/measurement/zzck
    //   12: monitorenter
    //   13: getstatic com/google/android/gms/internal/measurement/zzck.zzzg : Landroid/os/UserManager;
    //   16: astore_1
    //   17: aload_1
    //   18: astore_2
    //   19: aload_1
    //   20: ifnonnull -> 37
    //   23: aload_0
    //   24: ldc android/os/UserManager
    //   26: invokevirtual getSystemService : (Ljava/lang/Class;)Ljava/lang/Object;
    //   29: checkcast android/os/UserManager
    //   32: astore_2
    //   33: aload_2
    //   34: putstatic com/google/android/gms/internal/measurement/zzck.zzzg : Landroid/os/UserManager;
    //   37: ldc com/google/android/gms/internal/measurement/zzck
    //   39: monitorexit
    //   40: goto -> 49
    //   43: astore_0
    //   44: ldc com/google/android/gms/internal/measurement/zzck
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    //   49: aload_2
    //   50: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	43	finally
    //   23	37	43	finally
    //   37	40	43	finally
    //   44	47	43	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */