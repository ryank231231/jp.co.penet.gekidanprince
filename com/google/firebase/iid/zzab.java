package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzab {
  @GuardedBy("MessengerIpcClient.class")
  private static zzab zzbu;
  
  private final ScheduledExecutorService zzbv;
  
  @GuardedBy("this")
  private zzad zzbw = new zzad(this, null);
  
  @GuardedBy("this")
  private int zzbx = 1;
  
  private final Context zzz;
  
  @VisibleForTesting
  private zzab(Context paramContext, ScheduledExecutorService paramScheduledExecutorService) {
    this.zzbv = paramScheduledExecutorService;
    this.zzz = paramContext.getApplicationContext();
  }
  
  private final <T> Task<T> zza(zzak<T> paramzzak) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 64
    //   11: aload_1
    //   12: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual length : ()I
    //   23: istore_3
    //   24: new java/lang/StringBuilder
    //   27: astore #4
    //   29: aload #4
    //   31: iload_3
    //   32: bipush #9
    //   34: iadd
    //   35: invokespecial <init> : (I)V
    //   38: aload #4
    //   40: ldc 'Queueing '
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: aload_2
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 'MessengerIpcClient'
    //   55: aload #4
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   63: pop
    //   64: aload_0
    //   65: getfield zzbw : Lcom/google/firebase/iid/zzad;
    //   68: aload_1
    //   69: invokevirtual zzb : (Lcom/google/firebase/iid/zzak;)Z
    //   72: ifne -> 102
    //   75: new com/google/firebase/iid/zzad
    //   78: astore #4
    //   80: aload #4
    //   82: aload_0
    //   83: aconst_null
    //   84: invokespecial <init> : (Lcom/google/firebase/iid/zzab;Lcom/google/firebase/iid/zzac;)V
    //   87: aload_0
    //   88: aload #4
    //   90: putfield zzbw : Lcom/google/firebase/iid/zzad;
    //   93: aload_0
    //   94: getfield zzbw : Lcom/google/firebase/iid/zzad;
    //   97: aload_1
    //   98: invokevirtual zzb : (Lcom/google/firebase/iid/zzak;)Z
    //   101: pop
    //   102: aload_1
    //   103: getfield zzch : Lcom/google/android/gms/tasks/TaskCompletionSource;
    //   106: invokevirtual getTask : ()Lcom/google/android/gms/tasks/Task;
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: areturn
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Exception table:
    //   from	to	target	type
    //   2	64	114	finally
    //   64	102	114	finally
    //   102	110	114	finally
  }
  
  public static zzab zzc(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/firebase/iid/zzab
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/zzab.zzbu : Lcom/google/firebase/iid/zzab;
    //   6: ifnonnull -> 46
    //   9: new com/google/firebase/iid/zzab
    //   12: astore_1
    //   13: invokestatic zza : ()Lcom/google/android/gms/internal/firebase_messaging/zza;
    //   16: astore_2
    //   17: new com/google/android/gms/common/util/concurrent/NamedThreadFactory
    //   20: astore_3
    //   21: aload_3
    //   22: ldc 'MessengerIpcClient'
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: aload_1
    //   28: aload_0
    //   29: aload_2
    //   30: iconst_1
    //   31: aload_3
    //   32: bipush #9
    //   34: invokeinterface zza : (ILjava/util/concurrent/ThreadFactory;I)Ljava/util/concurrent/ScheduledExecutorService;
    //   39: invokespecial <init> : (Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;)V
    //   42: aload_1
    //   43: putstatic com/google/firebase/iid/zzab.zzbu : Lcom/google/firebase/iid/zzab;
    //   46: getstatic com/google/firebase/iid/zzab.zzbu : Lcom/google/firebase/iid/zzab;
    //   49: astore_0
    //   50: ldc com/google/firebase/iid/zzab
    //   52: monitorexit
    //   53: aload_0
    //   54: areturn
    //   55: astore_0
    //   56: ldc com/google/firebase/iid/zzab
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   3	46	55	finally
    //   46	50	55	finally
  }
  
  private final int zzx() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzbx : I
    //   6: istore_1
    //   7: aload_0
    //   8: iload_1
    //   9: iconst_1
    //   10: iadd
    //   11: putfield zzbx : I
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
  }
  
  public final Task<Void> zza(int paramInt, Bundle paramBundle) {
    return zza(new zzaj(zzx(), 2, paramBundle));
  }
  
  public final Task<Bundle> zzb(int paramInt, Bundle paramBundle) {
    return zza(new zzam(zzx(), 1, paramBundle));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */