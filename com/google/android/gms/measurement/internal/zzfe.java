package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;

public final class zzfe<T extends Context & zzfi> {
  private final T zzrb;
  
  public zzfe(T paramT) {
    Preconditions.checkNotNull(paramT);
    this.zzrb = paramT;
  }
  
  private final zzau zzad() {
    return zzby.zza((Context)this.zzrb, (zzy)null).zzad();
  }
  
  private final void zze(Runnable paramRunnable) {
    zzft zzft = zzft.zzm((Context)this.zzrb);
    zzft.zzac().zza(new zzfh(this, zzft, paramRunnable));
  }
  
  @MainThread
  public final IBinder onBind(Intent paramIntent) {
    if (paramIntent == null) {
      zzad().zzda().zzaq("onBind called with null intent");
      return null;
    } 
    String str = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(str))
      return (IBinder)new zzca(zzft.zzm((Context)this.zzrb)); 
    zzad().zzdd().zza("onBind received unknown action", str);
    return null;
  }
  
  @MainThread
  public final void onCreate() {
    zzby zzby = zzby.zza((Context)this.zzrb, (zzy)null);
    zzau zzau = zzby.zzad();
    zzby.zzag();
    zzau.zzdi().zzaq("Local AppMeasurementService is starting up");
  }
  
  @MainThread
  public final void onDestroy() {
    zzby zzby = zzby.zza((Context)this.zzrb, (zzy)null);
    zzau zzau = zzby.zzad();
    zzby.zzag();
    zzau.zzdi().zzaq("Local AppMeasurementService is shutting down");
  }
  
  @MainThread
  public final void onRebind(Intent paramIntent) {
    if (paramIntent == null) {
      zzad().zzda().zzaq("onRebind called with null intent");
      return;
    } 
    String str = paramIntent.getAction();
    zzad().zzdi().zza("onRebind called. action", str);
  }
  
  @MainThread
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    zzby zzby = zzby.zza((Context)this.zzrb, (zzy)null);
    zzau zzau = zzby.zzad();
    if (paramIntent == null) {
      zzau.zzdd().zzaq("AppMeasurementService started with null intent");
      return 2;
    } 
    String str = paramIntent.getAction();
    zzby.zzag();
    zzau.zzdi().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str))
      zze(new zzff(this, paramInt2, zzau, paramIntent)); 
    return 2;
  }
  
  @TargetApi(24)
  @MainThread
  public final boolean onStartJob(JobParameters paramJobParameters) {
    zzby zzby = zzby.zza((Context)this.zzrb, (zzy)null);
    zzau zzau = zzby.zzad();
    String str = paramJobParameters.getExtras().getString("action");
    zzby.zzag();
    zzau.zzdi().zza("Local AppMeasurementJobService called. action", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str))
      zze(new zzfg(this, zzau, paramJobParameters)); 
    return true;
  }
  
  @MainThread
  public final boolean onUnbind(Intent paramIntent) {
    if (paramIntent == null) {
      zzad().zzda().zzaq("onUnbind called with null intent");
      return true;
    } 
    String str = paramIntent.getAction();
    zzad().zzdi().zza("onUnbind called for intent. action", str);
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */