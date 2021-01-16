package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbk {
  private String value;
  
  private final String zzjf;
  
  private boolean zzlx;
  
  private final String zzme;
  
  public zzbk(zzbf paramzzbf, String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    this.zzjf = paramString1;
    this.zzme = null;
  }
  
  @WorkerThread
  public final void zzav(String paramString) {
    if (zzgd.zzs(paramString, this.value))
      return; 
    SharedPreferences.Editor editor = zzbf.zza(this.zzly).edit();
    editor.putString(this.zzjf, paramString);
    editor.apply();
    this.value = paramString;
  }
  
  @WorkerThread
  public final String zzed() {
    if (!this.zzlx) {
      this.zzlx = true;
      this.value = zzbf.zza(this.zzly).getString(this.zzjf, null);
    } 
    return this.value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */