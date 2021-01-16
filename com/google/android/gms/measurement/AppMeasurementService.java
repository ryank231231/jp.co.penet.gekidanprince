package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzfe;
import com.google.android.gms.measurement.internal.zzfi;

public final class AppMeasurementService extends Service implements zzfi {
  private zzfe<AppMeasurementService> zzp;
  
  private final zzfe<AppMeasurementService> zzg() {
    if (this.zzp == null)
      this.zzp = new zzfe((Context)this); 
    return this.zzp;
  }
  
  @MainThread
  public final IBinder onBind(Intent paramIntent) {
    return zzg().onBind(paramIntent);
  }
  
  @MainThread
  public final void onCreate() {
    super.onCreate();
    zzg().onCreate();
  }
  
  @MainThread
  public final void onDestroy() {
    zzg().onDestroy();
    super.onDestroy();
  }
  
  @MainThread
  public final void onRebind(Intent paramIntent) {
    zzg().onRebind(paramIntent);
  }
  
  @MainThread
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    return zzg().onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  @MainThread
  public final boolean onUnbind(Intent paramIntent) {
    return zzg().onUnbind(paramIntent);
  }
  
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean) {
    throw new UnsupportedOperationException();
  }
  
  public final void zza(Intent paramIntent) {
    AppMeasurementReceiver.completeWakefulIntent(paramIntent);
  }
  
  public final boolean zza(int paramInt) {
    return stopSelfResult(paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */