package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

@WorkerThread
final class zzbb implements Runnable {
  private final String packageName;
  
  private final int status;
  
  private final zzba zzkk;
  
  private final Throwable zzkl;
  
  private final byte[] zzkm;
  
  private final Map<String, List<String>> zzkn;
  
  private zzbb(String paramString, zzba paramzzba, int paramInt, Throwable paramThrowable, byte[] paramArrayOfbyte, Map<String, List<String>> paramMap) {
    Preconditions.checkNotNull(paramzzba);
    this.zzkk = paramzzba;
    this.status = paramInt;
    this.zzkl = paramThrowable;
    this.zzkm = paramArrayOfbyte;
    this.packageName = paramString;
    this.zzkn = paramMap;
  }
  
  public final void run() {
    this.zzkk.zza(this.packageName, this.status, this.zzkl, this.zzkm, this.zzkn);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */