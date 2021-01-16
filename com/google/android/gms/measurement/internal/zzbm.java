package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.measurement.zze;
import com.google.android.gms.internal.measurement.zzf;

public final class zzbm implements ServiceConnection {
  private final String packageName;
  
  zzbm(zzbl paramzzbl, String paramString) {
    this.packageName = paramString;
  }
  
  @MainThread
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    if (paramIBinder == null) {
      this.zzmf.zzl.zzad().zzdd().zzaq("Install Referrer connection returned with null binder");
      return;
    } 
    try {
      zze zze = zzf.zza(paramIBinder);
      if (zze == null) {
        this.zzmf.zzl.zzad().zzdd().zzaq("Install Referrer Service implementation was not found");
        return;
      } 
      this.zzmf.zzl.zzad().zzdg().zzaq("Install Referrer Service connected");
      zzbt zzbt = this.zzmf.zzl.zzac();
      zzbn zzbn = new zzbn();
      this(this, zze, this);
      zzbt.zza(zzbn);
      return;
    } catch (Exception exception) {
      this.zzmf.zzl.zzad().zzdd().zza("Exception occurred while calling Install Referrer API", exception);
      return;
    } 
  }
  
  @MainThread
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    this.zzmf.zzl.zzad().zzdg().zzaq("Install Referrer Service disconnected");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */