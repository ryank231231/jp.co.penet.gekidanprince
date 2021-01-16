package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzfe;
import com.google.android.gms.measurement.internal.zzfi;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzfi {
  private zzfe<AppMeasurementJobService> zzp;
  
  private final zzfe<AppMeasurementJobService> zzg() {
    if (this.zzp == null)
      this.zzp = new zzfe((Context)this); 
    return this.zzp;
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
  
  public final boolean onStartJob(JobParameters paramJobParameters) {
    return zzg().onStartJob(paramJobParameters);
  }
  
  public final boolean onStopJob(JobParameters paramJobParameters) {
    return false;
  }
  
  @MainThread
  public final boolean onUnbind(Intent paramIntent) {
    return zzg().onUnbind(paramIntent);
  }
  
  @TargetApi(24)
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean) {
    jobFinished(paramJobParameters, false);
  }
  
  public final void zza(Intent paramIntent) {}
  
  public final boolean zza(int paramInt) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */