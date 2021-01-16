package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzh;

public final class zzfp extends zzfs {
  private final AlarmManager zzrp = (AlarmManager)super.getContext().getSystemService("alarm");
  
  private final zzab zzrq;
  
  private Integer zzrr;
  
  protected zzfp(zzft paramzzft) {
    super(paramzzft);
    this.zzrq = new zzfq(this, paramzzft.zzgi(), paramzzft);
  }
  
  private final int getJobId() {
    if (this.zzrr == null) {
      String str = String.valueOf(super.getContext().getPackageName());
      if (str.length() != 0) {
        str = "measurement".concat(str);
      } else {
        str = new String("measurement");
      } 
      this.zzrr = Integer.valueOf(str.hashCode());
    } 
    return this.zzrr.intValue();
  }
  
  @TargetApi(24)
  private final void zzfs() {
    JobScheduler jobScheduler = (JobScheduler)super.getContext().getSystemService("jobscheduler");
    int i = getJobId();
    super.zzad().zzdi().zza("Cancelling job. JobID", Integer.valueOf(i));
    jobScheduler.cancel(i);
  }
  
  private final PendingIntent zzft() {
    Context context = super.getContext();
    return PendingIntent.getBroadcast(context, 0, (new Intent()).setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
  }
  
  public final void cancel() {
    zzah();
    this.zzrp.cancel(zzft());
    this.zzrq.cancel();
    if (Build.VERSION.SDK_INT >= 24)
      zzfs(); 
  }
  
  protected final boolean zzak() {
    this.zzrp.cancel(zzft());
    if (Build.VERSION.SDK_INT >= 24)
      zzfs(); 
    return false;
  }
  
  public final void zzv(long paramLong) {
    zzah();
    super.zzag();
    Context context = super.getContext();
    if (!zzbo.zzl(context))
      super.zzad().zzdh().zzaq("Receiver not registered/enabled"); 
    if (!zzgd.zzb(context, false))
      super.zzad().zzdh().zzaq("Service not registered/enabled"); 
    cancel();
    long l = super.zzz().elapsedRealtime();
    if (paramLong < Math.max(0L, ((Long)zzal.zzha.get(null)).longValue()) && !this.zzrq.zzcn()) {
      super.zzad().zzdi().zzaq("Scheduling upload with DelayedRunnable");
      this.zzrq.zzv(paramLong);
    } 
    super.zzag();
    if (Build.VERSION.SDK_INT >= 24) {
      super.zzad().zzdi().zzaq("Scheduling upload with JobScheduler");
      context = super.getContext();
      ComponentName componentName = new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementJobService");
      int i = getJobId();
      PersistableBundle persistableBundle = new PersistableBundle();
      persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
      JobInfo jobInfo = (new JobInfo.Builder(i, componentName)).setMinimumLatency(paramLong).setOverrideDeadline(paramLong << 1L).setExtras(persistableBundle).build();
      super.zzad().zzdi().zza("Scheduling job. JobID", Integer.valueOf(i));
      zzh.zza(context, jobInfo, "com.google.android.gms", "UploadAlarm");
      return;
    } 
    super.zzad().zzdi().zzaq("Scheduling upload with AlarmManager");
    this.zzrp.setInexactRepeating(2, l + paramLong, Math.max(((Long)zzal.zzgv.get(null)).longValue(), paramLong), zzft());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */