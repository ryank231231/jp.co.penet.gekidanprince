package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

public final class zzt extends zzct {
  private Boolean zzdz;
  
  @NonNull
  private zzv zzea = zzu.zzec;
  
  private Boolean zzeb;
  
  zzt(zzby paramzzby) {
    super(paramzzby);
    zzal.zza(paramzzby);
  }
  
  static String zzbo() {
    return zzal.zzgd.get(null);
  }
  
  public static long zzbs() {
    return ((Long)zzal.zzhg.get(null)).longValue();
  }
  
  public static long zzbt() {
    return ((Long)zzal.zzgg.get(null)).longValue();
  }
  
  public static boolean zzbv() {
    return ((Boolean)zzal.zzgc.get(null)).booleanValue();
  }
  
  @WorkerThread
  static boolean zzbx() {
    return ((Boolean)zzal.zzic.get(null)).booleanValue();
  }
  
  @WorkerThread
  public final long zza(String paramString, @NonNull zzal.zza<Long> paramzza) {
    if (paramString == null)
      return ((Long)paramzza.get(null)).longValue(); 
    paramString = this.zzea.zzb(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(paramString))
      return ((Long)paramzza.get(null)).longValue(); 
    try {
      return ((Long)paramzza.get(Long.valueOf(Long.parseLong(paramString)))).longValue();
    } catch (NumberFormatException numberFormatException) {
      return ((Long)paramzza.get(null)).longValue();
    } 
  }
  
  final void zza(@NonNull zzv paramzzv) {
    this.zzea = paramzzv;
  }
  
  public final boolean zza(zzal.zza<Boolean> paramzza) {
    return zzd(null, paramzza);
  }
  
  @WorkerThread
  final boolean zzaa(String paramString) {
    return zzd(paramString, zzal.zzif);
  }
  
  @WorkerThread
  final boolean zzab(String paramString) {
    return zzd(paramString, zzal.zzig);
  }
  
  @WorkerThread
  final boolean zzac(String paramString) {
    return zzd(paramString, zzal.zzil);
  }
  
  public final long zzav() {
    super.zzag();
    return 15300L;
  }
  
  @WorkerThread
  public final int zzb(String paramString, @NonNull zzal.zza<Integer> paramzza) {
    if (paramString == null)
      return ((Integer)paramzza.get(null)).intValue(); 
    paramString = this.zzea.zzb(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(paramString))
      return ((Integer)paramzza.get(null)).intValue(); 
    try {
      return ((Integer)paramzza.get(Integer.valueOf(Integer.parseInt(paramString)))).intValue();
    } catch (NumberFormatException numberFormatException) {
      return ((Integer)paramzza.get(null)).intValue();
    } 
  }
  
  public final boolean zzbp() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzeb : Ljava/lang/Boolean;
    //   4: ifnonnull -> 100
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzeb : Ljava/lang/Boolean;
    //   13: ifnonnull -> 90
    //   16: aload_0
    //   17: invokevirtual getContext : ()Landroid/content/Context;
    //   20: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   23: astore_1
    //   24: invokestatic getMyProcessName : ()Ljava/lang/String;
    //   27: astore_2
    //   28: aload_1
    //   29: ifnull -> 64
    //   32: aload_1
    //   33: getfield processName : Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull -> 54
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifeq -> 54
    //   49: iconst_1
    //   50: istore_3
    //   51: goto -> 56
    //   54: iconst_0
    //   55: istore_3
    //   56: aload_0
    //   57: iload_3
    //   58: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   61: putfield zzeb : Ljava/lang/Boolean;
    //   64: aload_0
    //   65: getfield zzeb : Ljava/lang/Boolean;
    //   68: ifnonnull -> 90
    //   71: aload_0
    //   72: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   75: putfield zzeb : Ljava/lang/Boolean;
    //   78: aload_0
    //   79: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   82: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   85: ldc 'My process not in the list of running processes'
    //   87: invokevirtual zzaq : (Ljava/lang/String;)V
    //   90: aload_0
    //   91: monitorexit
    //   92: goto -> 100
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: aload_0
    //   101: getfield zzeb : Ljava/lang/Boolean;
    //   104: invokevirtual booleanValue : ()Z
    //   107: ireturn
    // Exception table:
    //   from	to	target	type
    //   9	28	95	finally
    //   32	37	95	finally
    //   41	49	95	finally
    //   56	64	95	finally
    //   64	90	95	finally
    //   90	92	95	finally
    //   96	98	95	finally
  }
  
  public final boolean zzbq() {
    super.zzag();
    Boolean bool = zzj("firebase_analytics_collection_deactivated");
    return (bool != null && bool.booleanValue());
  }
  
  public final Boolean zzbr() {
    super.zzag();
    return zzj("firebase_analytics_collection_enabled");
  }
  
  public final String zzbu() {
    try {
      return (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { "debug.firebase.analytics.app", "" });
    } catch (ClassNotFoundException classNotFoundException) {
      super.zzad().zzda().zza("Could not find SystemProperties class", classNotFoundException);
    } catch (NoSuchMethodException noSuchMethodException) {
      super.zzad().zzda().zza("Could not find SystemProperties.get() method", noSuchMethodException);
    } catch (IllegalAccessException illegalAccessException) {
      super.zzad().zzda().zza("Could not access SystemProperties.get()", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      super.zzad().zzda().zza("SystemProperties.get() threw an exception", invocationTargetException);
    } 
    return "";
  }
  
  @WorkerThread
  final boolean zzbw() {
    if (this.zzdz == null) {
      this.zzdz = zzj("app_measurement_lite");
      if (this.zzdz == null)
        this.zzdz = Boolean.valueOf(false); 
    } 
    return (this.zzdz.booleanValue() || !this.zzl.zzep());
  }
  
  @WorkerThread
  public final double zzc(String paramString, @NonNull zzal.zza<Double> paramzza) {
    if (paramString == null)
      return ((Double)paramzza.get(null)).doubleValue(); 
    paramString = this.zzea.zzb(paramString, paramzza.getKey());
    if (TextUtils.isEmpty(paramString))
      return ((Double)paramzza.get(null)).doubleValue(); 
    try {
      return ((Double)paramzza.get(Double.valueOf(Double.parseDouble(paramString)))).doubleValue();
    } catch (NumberFormatException numberFormatException) {
      return ((Double)paramzza.get(null)).doubleValue();
    } 
  }
  
  @WorkerThread
  public final boolean zzd(String paramString, @NonNull zzal.zza<Boolean> paramzza) {
    if (paramString == null)
      return ((Boolean)paramzza.get(null)).booleanValue(); 
    paramString = this.zzea.zzb(paramString, paramzza.getKey());
    return TextUtils.isEmpty(paramString) ? ((Boolean)paramzza.get(null)).booleanValue() : ((Boolean)paramzza.get(Boolean.valueOf(Boolean.parseBoolean(paramString)))).booleanValue();
  }
  
  public final boolean zze(String paramString, zzal.zza<Boolean> paramzza) {
    return zzd(paramString, paramzza);
  }
  
  @WorkerThread
  public final int zzi(@Size(min = 1L) String paramString) {
    return zzb(paramString, zzal.zzgr);
  }
  
  @Nullable
  @VisibleForTesting
  final Boolean zzj(@Size(min = 1L) String paramString) {
    Preconditions.checkNotEmpty(paramString);
    try {
      if (super.getContext().getPackageManager() == null) {
        super.zzad().zzda().zzaq("Failed to load metadata: PackageManager is null");
        return null;
      } 
      ApplicationInfo applicationInfo = Wrappers.packageManager(super.getContext()).getApplicationInfo(super.getContext().getPackageName(), 128);
      if (applicationInfo == null) {
        super.zzad().zzda().zzaq("Failed to load metadata: ApplicationInfo is null");
        return null;
      } 
      if (applicationInfo.metaData == null) {
        super.zzad().zzda().zzaq("Failed to load metadata: Metadata bundle is null");
        return null;
      } 
      if (!applicationInfo.metaData.containsKey(paramString))
        return null; 
      boolean bool = applicationInfo.metaData.getBoolean(paramString);
      return Boolean.valueOf(bool);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      super.zzad().zzda().zza("Failed to load metadata: Package name not found", nameNotFoundException);
      return null;
    } 
  }
  
  public final boolean zzk(String paramString) {
    return "1".equals(this.zzea.zzb(paramString, "gaia_collection_enabled"));
  }
  
  public final boolean zzl(String paramString) {
    return "1".equals(this.zzea.zzb(paramString, "measurement.event_sampling_enabled"));
  }
  
  @WorkerThread
  final boolean zzm(String paramString) {
    return zzd(paramString, zzal.zzhq);
  }
  
  @WorkerThread
  final boolean zzn(String paramString) {
    return zzd(paramString, zzal.zzhs);
  }
  
  @WorkerThread
  final boolean zzo(String paramString) {
    return zzd(paramString, zzal.zzht);
  }
  
  @WorkerThread
  final boolean zzp(String paramString) {
    return zzd(paramString, zzal.zzhk);
  }
  
  @WorkerThread
  final String zzq(String paramString) {
    zzal.zza<String> zza = zzal.zzhl;
    return (paramString == null) ? zza.get(null) : zza.get(this.zzea.zzb(paramString, zza.getKey()));
  }
  
  final boolean zzr(String paramString) {
    return zzd(paramString, zzal.zzhu);
  }
  
  @WorkerThread
  final boolean zzs(String paramString) {
    return zzd(paramString, zzal.zzhv);
  }
  
  final boolean zzt(String paramString) {
    return zzd(paramString, zzal.zzhx);
  }
  
  @WorkerThread
  final boolean zzu(String paramString) {
    return zzd(paramString, zzal.zzhy);
  }
  
  @WorkerThread
  final boolean zzv(String paramString) {
    return zzd(paramString, zzal.zzhz);
  }
  
  @WorkerThread
  final boolean zzw(String paramString) {
    return zzd(paramString, zzal.zzib);
  }
  
  @WorkerThread
  final boolean zzx(String paramString) {
    return zzd(paramString, zzal.zzia);
  }
  
  @WorkerThread
  final boolean zzy(String paramString) {
    return zzd(paramString, zzal.zzid);
  }
  
  @WorkerThread
  final boolean zzz(String paramString) {
    return zzd(paramString, zzal.zzie);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */