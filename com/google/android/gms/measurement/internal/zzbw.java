package com.google.android.gms.measurement.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzbw<V> extends FutureTask<V> implements Comparable<zzbw> {
  private final String zznh;
  
  private final long zznj;
  
  final boolean zznk;
  
  zzbw(zzbt paramzzbt, Runnable paramRunnable, boolean paramBoolean, String paramString) {
    super(paramRunnable, null);
    Preconditions.checkNotNull(paramString);
    this.zznj = zzbt.zzeg().getAndIncrement();
    this.zznh = paramString;
    this.zznk = false;
    if (this.zznj == Long.MAX_VALUE)
      paramzzbt.zzad().zzda().zzaq("Tasks index overflow"); 
  }
  
  zzbw(zzbt paramzzbt, Callable<V> paramCallable, boolean paramBoolean, String paramString) {
    super(paramCallable);
    Preconditions.checkNotNull(paramString);
    this.zznj = zzbt.zzeg().getAndIncrement();
    this.zznh = paramString;
    this.zznk = paramBoolean;
    if (this.zznj == Long.MAX_VALUE)
      paramzzbt.zzad().zzda().zzaq("Tasks index overflow"); 
  }
  
  protected final void setException(Throwable paramThrowable) {
    this.zzni.zzad().zzda().zza(this.zznh, paramThrowable);
    if (paramThrowable instanceof zzbu)
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramThrowable); 
    super.setException(paramThrowable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */