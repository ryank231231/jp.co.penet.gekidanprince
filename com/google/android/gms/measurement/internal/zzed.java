package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

public final class zzed extends zzf {
  @VisibleForTesting
  protected zzec zzpy;
  
  private volatile zzec zzpz;
  
  private zzec zzqa;
  
  private final Map<Activity, zzec> zzqb = (Map<Activity, zzec>)new ArrayMap();
  
  private zzec zzqc;
  
  private String zzqd;
  
  public zzed(zzby paramzzby) {
    super(paramzzby);
  }
  
  @MainThread
  private final zzec zza(@NonNull Activity paramActivity) {
    Preconditions.checkNotNull(paramActivity);
    zzec zzec1 = this.zzqb.get(paramActivity);
    zzec zzec2 = zzec1;
    if (zzec1 == null) {
      zzec2 = new zzec(null, zzbj(paramActivity.getClass().getCanonicalName()), super.zzab().zzgk());
      this.zzqb.put(paramActivity, zzec2);
    } 
    return zzec2;
  }
  
  @MainThread
  private final void zza(Activity paramActivity, zzec paramzzec, boolean paramBoolean) {
    zzec zzec1;
    if (this.zzpz == null) {
      zzec1 = this.zzqa;
    } else {
      zzec1 = this.zzpz;
    } 
    zzec zzec2 = paramzzec;
    if (paramzzec.zzpv == null)
      zzec2 = new zzec(paramzzec.zzpu, zzbj(paramActivity.getClass().getCanonicalName()), paramzzec.zzpw); 
    this.zzqa = this.zzpz;
    this.zzpz = zzec2;
    super.zzac().zza(new zzee(this, paramBoolean, zzec1, zzec2));
  }
  
  public static void zza(zzec paramzzec, Bundle paramBundle, boolean paramBoolean) {
    if (paramBundle != null && paramzzec != null && (!paramBundle.containsKey("_sc") || paramBoolean)) {
      if (paramzzec.zzpu != null) {
        paramBundle.putString("_sn", paramzzec.zzpu);
      } else {
        paramBundle.remove("_sn");
      } 
      paramBundle.putString("_sc", paramzzec.zzpv);
      paramBundle.putLong("_si", paramzzec.zzpw);
      return;
    } 
    if (paramBundle != null && paramzzec == null && paramBoolean) {
      paramBundle.remove("_sn");
      paramBundle.remove("_sc");
      paramBundle.remove("_si");
    } 
  }
  
  @WorkerThread
  private final void zza(@NonNull zzec paramzzec, boolean paramBoolean) {
    super.zzr().zzc(super.zzz().elapsedRealtime());
    if (super.zzx().zza(paramzzec.zzpx, paramBoolean))
      paramzzec.zzpx = false; 
  }
  
  @VisibleForTesting
  private static String zzbj(String paramString) {
    String str;
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length > 0) {
      str = arrayOfString[arrayOfString.length - 1];
    } else {
      str = "";
    } 
    return (str.length() > 100) ? str.substring(0, 100) : str;
  }
  
  @MainThread
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    if (paramBundle == null)
      return; 
    paramBundle = paramBundle.getBundle("com.google.app_measurement.screen_service");
    if (paramBundle == null)
      return; 
    zzec zzec1 = new zzec(paramBundle.getString("name"), paramBundle.getString("referrer_name"), paramBundle.getLong("id"));
    this.zzqb.put(paramActivity, zzec1);
  }
  
  @MainThread
  public final void onActivityDestroyed(Activity paramActivity) {
    this.zzqb.remove(paramActivity);
  }
  
  @MainThread
  public final void onActivityPaused(Activity paramActivity) {
    zzec zzec1 = zza(paramActivity);
    this.zzqa = this.zzpz;
    this.zzpz = null;
    super.zzac().zza(new zzef(this, zzec1));
  }
  
  @MainThread
  public final void onActivityResumed(Activity paramActivity) {
    zza(paramActivity, zza(paramActivity), false);
    zza zza = super.zzr();
    long l = zza.zzz().elapsedRealtime();
    zza.zzac().zza(new zzd(zza, l));
  }
  
  @MainThread
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {
    if (paramBundle == null)
      return; 
    zzec zzec1 = this.zzqb.get(paramActivity);
    if (zzec1 == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putLong("id", zzec1.zzpw);
    bundle.putString("name", zzec1.zzpu);
    bundle.putString("referrer_name", zzec1.zzpv);
    paramBundle.putBundle("com.google.app_measurement.screen_service", bundle);
  }
  
  public final void setCurrentScreen(@NonNull Activity paramActivity, @Nullable @Size(max = 36L, min = 1L) String paramString1, @Nullable @Size(max = 36L, min = 1L) String paramString2) {
    if (this.zzpz == null) {
      super.zzad().zzdd().zzaq("setCurrentScreen cannot be called while no activity active");
      return;
    } 
    if (this.zzqb.get(paramActivity) == null) {
      super.zzad().zzdd().zzaq("setCurrentScreen must be called with an activity in the activity lifecycle");
      return;
    } 
    String str = paramString2;
    if (paramString2 == null)
      str = zzbj(paramActivity.getClass().getCanonicalName()); 
    boolean bool1 = this.zzpz.zzpv.equals(str);
    boolean bool2 = zzgd.zzs(this.zzpz.zzpu, paramString1);
    if (bool1 && bool2) {
      super.zzad().zzdf().zzaq("setCurrentScreen cannot be called with the same class and name");
      return;
    } 
    if (paramString1 != null && (paramString1.length() <= 0 || paramString1.length() > 100)) {
      super.zzad().zzdd().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(paramString1.length()));
      return;
    } 
    if (str != null && (str.length() <= 0 || str.length() > 100)) {
      super.zzad().zzdd().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
      return;
    } 
    zzaw zzaw = super.zzad().zzdi();
    if (paramString1 == null) {
      paramString2 = "null";
    } else {
      paramString2 = paramString1;
    } 
    zzaw.zza("Setting current screen to name, class", paramString2, str);
    zzec zzec1 = new zzec(paramString1, str, super.zzab().zzgk());
    this.zzqb.put(paramActivity, zzec1);
    zza(paramActivity, zzec1, true);
  }
  
  @WorkerThread
  public final void zza(String paramString, zzec paramzzec) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzq : ()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield zzqd : Ljava/lang/String;
    //   10: ifnull -> 28
    //   13: aload_0
    //   14: getfield zzqd : Ljava/lang/String;
    //   17: aload_1
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifne -> 28
    //   24: aload_2
    //   25: ifnull -> 38
    //   28: aload_0
    //   29: aload_1
    //   30: putfield zzqd : Ljava/lang/String;
    //   33: aload_0
    //   34: aload_2
    //   35: putfield zzqc : Lcom/google/android/gms/measurement/internal/zzec;
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   6	24	41	finally
    //   28	38	41	finally
    //   38	40	41	finally
    //   42	44	41	finally
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  @WorkerThread
  public final zzec zzfc() {
    zzah();
    super.zzq();
    return this.zzpy;
  }
  
  public final zzec zzfd() {
    super.zzo();
    return this.zzpz;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */