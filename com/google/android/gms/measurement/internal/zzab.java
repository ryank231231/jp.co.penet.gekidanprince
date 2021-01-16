package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

abstract class zzab {
  private static volatile Handler handler;
  
  private final zzcv zzer;
  
  private final Runnable zzes;
  
  private volatile long zzet;
  
  zzab(zzcv paramzzcv) {
    Preconditions.checkNotNull(paramzzcv);
    this.zzer = paramzzcv;
    this.zzes = new zzac(this, paramzzcv);
  }
  
  private final Handler getHandler() {
    // Byte code:
    //   0: getstatic com/google/android/gms/measurement/internal/zzab.handler : Landroid/os/Handler;
    //   3: ifnull -> 10
    //   6: getstatic com/google/android/gms/measurement/internal/zzab.handler : Landroid/os/Handler;
    //   9: areturn
    //   10: ldc com/google/android/gms/measurement/internal/zzab
    //   12: monitorenter
    //   13: getstatic com/google/android/gms/measurement/internal/zzab.handler : Landroid/os/Handler;
    //   16: ifnonnull -> 43
    //   19: new com/google/android/gms/internal/measurement/zzk
    //   22: astore_1
    //   23: aload_1
    //   24: aload_0
    //   25: getfield zzer : Lcom/google/android/gms/measurement/internal/zzcv;
    //   28: invokeinterface getContext : ()Landroid/content/Context;
    //   33: invokevirtual getMainLooper : ()Landroid/os/Looper;
    //   36: invokespecial <init> : (Landroid/os/Looper;)V
    //   39: aload_1
    //   40: putstatic com/google/android/gms/measurement/internal/zzab.handler : Landroid/os/Handler;
    //   43: getstatic com/google/android/gms/measurement/internal/zzab.handler : Landroid/os/Handler;
    //   46: astore_1
    //   47: ldc com/google/android/gms/measurement/internal/zzab
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: ldc com/google/android/gms/measurement/internal/zzab
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   13	43	52	finally
    //   43	50	52	finally
    //   53	56	52	finally
  }
  
  final void cancel() {
    this.zzet = 0L;
    getHandler().removeCallbacks(this.zzes);
  }
  
  public abstract void run();
  
  public final boolean zzcn() {
    return (this.zzet != 0L);
  }
  
  public final void zzv(long paramLong) {
    cancel();
    if (paramLong >= 0L) {
      this.zzet = this.zzer.zzz().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzes, paramLong))
        this.zzer.zzad().zzda().zza("Failed to schedule delayed post. time", Long.valueOf(paramLong)); 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */