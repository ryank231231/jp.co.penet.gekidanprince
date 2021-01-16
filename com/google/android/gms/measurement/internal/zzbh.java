package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbh {
  private boolean value;
  
  private final String zzjf;
  
  private final boolean zzlw;
  
  private boolean zzlx;
  
  public zzbh(zzbf paramzzbf, String paramString, boolean paramBoolean) {
    Preconditions.checkNotEmpty(paramString);
    this.zzjf = paramString;
    this.zzlw = paramBoolean;
  }
  
  @WorkerThread
  public final boolean get() {
    if (!this.zzlx) {
      this.zzlx = true;
      this.value = zzbf.zza(this.zzly).getBoolean(this.zzjf, this.zzlw);
    } 
    return this.value;
  }
  
  @WorkerThread
  public final void set(boolean paramBoolean) {
    SharedPreferences.Editor editor = zzbf.zza(this.zzly).edit();
    editor.putBoolean(this.zzjf, paramBoolean);
    editor.apply();
    this.value = paramBoolean;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */