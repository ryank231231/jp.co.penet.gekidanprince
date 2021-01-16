package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzbv implements Thread.UncaughtExceptionHandler {
  private final String zznh;
  
  public zzbv(zzbt paramzzbt, String paramString) {
    Preconditions.checkNotNull(paramString);
    this.zznh = paramString;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzni : Lcom/google/android/gms/measurement/internal/zzbt;
    //   6: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   9: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   12: aload_0
    //   13: getfield zznh : Ljava/lang/String;
    //   16: aload_2
    //   17: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */