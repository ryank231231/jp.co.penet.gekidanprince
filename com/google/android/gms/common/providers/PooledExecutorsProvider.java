package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
public class PooledExecutorsProvider {
  private static PooledExecutorFactory zzey;
  
  @KeepForSdk
  public static PooledExecutorFactory getInstance() {
    // Byte code:
    //   0: ldc com/google/android/gms/common/providers/PooledExecutorsProvider
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/common/providers/PooledExecutorsProvider.zzey : Lcom/google/android/gms/common/providers/PooledExecutorsProvider$PooledExecutorFactory;
    //   6: ifnonnull -> 21
    //   9: new com/google/android/gms/common/providers/zza
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/google/android/gms/common/providers/PooledExecutorsProvider.zzey : Lcom/google/android/gms/common/providers/PooledExecutorsProvider$PooledExecutorFactory;
    //   21: getstatic com/google/android/gms/common/providers/PooledExecutorsProvider.zzey : Lcom/google/android/gms/common/providers/PooledExecutorsProvider$PooledExecutorFactory;
    //   24: astore_0
    //   25: ldc com/google/android/gms/common/providers/PooledExecutorsProvider
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/google/android/gms/common/providers/PooledExecutorsProvider
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public static interface PooledExecutorFactory {
    @KeepForSdk
    ScheduledExecutorService newSingleThreadScheduledExecutor();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\providers\PooledExecutorsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */