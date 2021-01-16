package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbi {
  private long value;
  
  private final String zzjf;
  
  private boolean zzlx;
  
  private final long zzlz;
  
  public zzbi(zzbf paramzzbf, String paramString, long paramLong) {
    Preconditions.checkNotEmpty(paramString);
    this.zzjf = paramString;
    this.zzlz = paramLong;
  }
  
  @WorkerThread
  public final long get() {
    if (!this.zzlx) {
      this.zzlx = true;
      this.value = zzbf.zza(this.zzly).getLong(this.zzjf, this.zzlz);
    } 
    return this.value;
  }
  
  @WorkerThread
  public final void set(long paramLong) {
    SharedPreferences.Editor editor = zzbf.zza(this.zzly).edit();
    editor.putLong(this.zzjf, paramLong);
    editor.apply();
    this.value = paramLong;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */