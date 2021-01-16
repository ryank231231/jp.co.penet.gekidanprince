package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
public final class zzh {
  @Nullable
  private static final Method zzf = zza();
  
  @Nullable
  private static final Method zzg = zzb();
  
  private static volatile zzj zzh = zzi.zzi;
  
  private final JobScheduler zze;
  
  private zzh(JobScheduler paramJobScheduler) {
    this.zze = paramJobScheduler;
  }
  
  private final int zza(JobInfo paramJobInfo, String paramString1, int paramInt, String paramString2) {
    Method method = zzf;
    if (method != null) {
      try {
        return ((Integer)method.invoke(this.zze, new Object[] { paramJobInfo, paramString1, Integer.valueOf(paramInt), paramString2 })).intValue();
      } catch (IllegalAccessException illegalAccessException) {
      
      } catch (InvocationTargetException invocationTargetException) {}
      Log.e(paramString2, "error calling scheduleAsPackage", invocationTargetException);
    } 
    return this.zze.schedule(paramJobInfo);
  }
  
  public static int zza(Context paramContext, JobInfo paramJobInfo, String paramString1, String paramString2) {
    JobScheduler jobScheduler = (JobScheduler)paramContext.getSystemService("jobscheduler");
    return (zzf == null || !zzh.zze() || paramContext.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) ? jobScheduler.schedule(paramJobInfo) : (new zzh(jobScheduler)).zza(paramJobInfo, paramString1, zzc(), paramString2);
  }
  
  @Nullable
  private static Method zza() {
    if (Build.VERSION.SDK_INT >= 24)
      try {
        return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[] { JobInfo.class, String.class, int.class, String.class });
      } catch (NoSuchMethodException noSuchMethodException) {
        if (Log.isLoggable("JobSchedulerCompat", 6))
          Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule"); 
      }  
    return null;
  }
  
  @Nullable
  private static Method zzb() {
    if (Build.VERSION.SDK_INT >= 24)
      try {
        return UserHandle.class.getDeclaredMethod("myUserId", null);
      } catch (NoSuchMethodException noSuchMethodException) {
        if (Log.isLoggable("JobSchedulerCompat", 6))
          Log.e("JobSchedulerCompat", "No myUserId method available"); 
      }  
    return null;
  }
  
  private static int zzc() {
    Method method = zzg;
    if (method != null) {
      try {
        return ((Integer)method.invoke(null, new Object[0])).intValue();
      } catch (IllegalAccessException illegalAccessException) {
      
      } catch (InvocationTargetException invocationTargetException) {}
      if (Log.isLoggable("JobSchedulerCompat", 6))
        Log.e("JobSchedulerCompat", "myUserId invocation illegal", invocationTargetException); 
    } 
    return 0;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */