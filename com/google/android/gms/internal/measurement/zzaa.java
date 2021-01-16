package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzda;
import com.google.android.gms.measurement.internal.zzdb;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

public class zzaa {
  private static Boolean zzaf;
  
  private static Boolean zzag;
  
  @VisibleForTesting
  private static String zzah = "use_dynamite_api";
  
  @VisibleForTesting
  private static String zzai = "allow_remote_dynamite";
  
  private static boolean zzaj = false;
  
  private static boolean zzak = false;
  
  private static volatile zzaa zzz;
  
  protected final Clock zzaa;
  
  private final ExecutorService zzab;
  
  private final AppMeasurementSdk zzac;
  
  private Map<zzdb, zzc> zzad;
  
  private int zzae;
  
  private boolean zzal;
  
  private String zzam;
  
  private zzn zzan;
  
  private final String zzw;
  
  private zzaa(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    boolean bool2;
    if (paramString1 == null || !zza(paramString2, paramString3)) {
      this.zzw = "FA";
    } else {
      this.zzw = paramString1;
    } 
    this.zzaa = DefaultClock.getInstance();
    this.zzab = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    this.zzac = new AppMeasurementSdk(this);
    boolean bool = zzb(paramContext);
    boolean bool1 = false;
    if (!bool || zzi()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (!bool2) {
      this.zzam = null;
      this.zzal = true;
      Log.w(this.zzw, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
      return;
    } 
    if (!zza(paramString2, paramString3)) {
      this.zzam = "fa";
      if (paramString2 != null && paramString3 != null) {
        Log.v(this.zzw, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
        this.zzal = true;
        return;
      } 
      if (paramString2 == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (paramString3 == null)
        bool1 = true; 
      if ((bool2 ^ bool1) != 0)
        Log.w(this.zzw, "Specified origin or custom app id is null. Both parameters will be ignored."); 
    } else {
      this.zzam = paramString2;
    } 
    zza(new zzab(this, paramString2, paramString3, paramContext, paramBundle));
    Application application = (Application)paramContext.getApplicationContext();
    if (application == null) {
      Log.w(this.zzw, "Unable to register lifecycle notifications. Application null.");
      return;
    } 
    application.registerActivityLifecycleCallbacks(new zzd(this));
  }
  
  public static zzaa zza(@Nonnull Context paramContext) {
    return zza(paramContext, (String)null, (String)null, (String)null, (Bundle)null);
  }
  
  public static zzaa zza(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: getstatic com/google/android/gms/internal/measurement/zzaa.zzz : Lcom/google/android/gms/internal/measurement/zzaa;
    //   8: ifnonnull -> 53
    //   11: ldc com/google/android/gms/internal/measurement/zzaa
    //   13: monitorenter
    //   14: getstatic com/google/android/gms/internal/measurement/zzaa.zzz : Lcom/google/android/gms/internal/measurement/zzaa;
    //   17: ifnonnull -> 41
    //   20: new com/google/android/gms/internal/measurement/zzaa
    //   23: astore #5
    //   25: aload #5
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: aload_3
    //   31: aload #4
    //   33: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   36: aload #5
    //   38: putstatic com/google/android/gms/internal/measurement/zzaa.zzz : Lcom/google/android/gms/internal/measurement/zzaa;
    //   41: ldc com/google/android/gms/internal/measurement/zzaa
    //   43: monitorexit
    //   44: goto -> 53
    //   47: astore_0
    //   48: ldc com/google/android/gms/internal/measurement/zzaa
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: getstatic com/google/android/gms/internal/measurement/zzaa.zzz : Lcom/google/android/gms/internal/measurement/zzaa;
    //   56: areturn
    // Exception table:
    //   from	to	target	type
    //   14	41	47	finally
    //   41	44	47	finally
    //   48	51	47	finally
  }
  
  private final void zza(zza paramzza) {
    this.zzab.execute(paramzza);
  }
  
  private final void zza(Exception paramException, boolean paramBoolean1, boolean paramBoolean2) {
    this.zzal |= paramBoolean1;
    if (paramBoolean1) {
      Log.w(this.zzw, "Data collection startup failed. No data will be collected.", paramException);
      return;
    } 
    if (paramBoolean2)
      zza(5, "Error with data collection. Data lost.", paramException, (Object)null, (Object)null); 
    Log.w(this.zzw, "Error with data collection. Data lost.", paramException);
  }
  
  private final void zza(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, Long paramLong) {
    zza(new zzbb(this, paramLong, paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2));
  }
  
  private final void zza(String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
    zza(new zzbc(this, paramString1, paramString2, paramObject, paramBoolean));
  }
  
  private static boolean zza(Context paramContext, @Size(min = 1L) String paramString) {
    Preconditions.checkNotEmpty(paramString);
    try {
      ApplicationInfo applicationInfo = Wrappers.packageManager(paramContext).getApplicationInfo(paramContext.getPackageName(), 128);
      return (applicationInfo == null || applicationInfo.metaData == null) ? false : applicationInfo.metaData.getBoolean(paramString);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  private static boolean zza(String paramString1, String paramString2) {
    return (paramString2 != null && paramString1 != null && !zzi());
  }
  
  private static boolean zzb(Context paramContext) {
    try {
      GoogleServices.initialize(paramContext);
      String str = GoogleServices.getGoogleAppId();
      return (str != null);
    } catch (IllegalStateException illegalStateException) {
      return false;
    } 
  }
  
  private static int zzc(Context paramContext) {
    return DynamiteModule.getRemoteVersion(paramContext, "com.google.android.gms.measurement.dynamite");
  }
  
  private static int zzd(Context paramContext) {
    return DynamiteModule.getLocalVersion(paramContext, "com.google.android.gms.measurement.dynamite");
  }
  
  private static void zze(Context paramContext) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/google/android/gms/internal/measurement/zzaa}} */
    try {
      if (zzaf != null) {
        Boolean bool = zzag;
        if (bool != null) {
          /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/google/android/gms/internal/measurement/zzaa}} */
          return;
        } 
      } 
      if (zza(paramContext, "app_measurement_internal_disable_startup_flags")) {
        zzaf = Boolean.valueOf(false);
        zzag = Boolean.valueOf(false);
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/google/android/gms/internal/measurement/zzaa}} */
        return;
      } 
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
      zzaf = Boolean.valueOf(sharedPreferences.getBoolean(zzah, false));
      zzag = Boolean.valueOf(sharedPreferences.getBoolean(zzai, false));
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.remove(zzah);
      editor.remove(zzai);
      editor.apply();
    } catch (NullPointerException nullPointerException) {
      Log.e("FA", "Exception reading flag from SharedPreferences.", nullPointerException);
      zzaf = Boolean.valueOf(false);
      zzag = Boolean.valueOf(false);
    } catch (ClassCastException classCastException) {
    
    } catch (IllegalStateException illegalStateException) {
    
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/google/android/gms/internal/measurement/zzaa}} */
  }
  
  public static boolean zzf(Context paramContext) {
    zze(paramContext);
    return zzaf.booleanValue();
  }
  
  private static boolean zzi() {
    try {
      Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  public final void beginAdUnitExposure(String paramString) {
    zza(new zzak(this, paramString));
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle) {
    zza(new zzac(this, paramString1, paramString2, paramBundle));
  }
  
  public final void endAdUnitExposure(String paramString) {
    zza(new zzal(this, paramString));
  }
  
  public final long generateEventId() {
    zzm zzm = new zzm();
    zza(new zzap(this, zzm));
    Long long_ = zzm.<Long>zza(zzm.zzb(500L), Long.class);
    if (long_ == null) {
      long l = (new Random(System.nanoTime() ^ this.zzaa.currentTimeMillis())).nextLong();
      int i = this.zzae + 1;
      this.zzae = i;
      return l + i;
    } 
    return long_.longValue();
  }
  
  public final String getAppIdOrigin() {
    return this.zzam;
  }
  
  @WorkerThread
  public final String getAppInstanceId() {
    zzm zzm = new zzm();
    zza(new zzaw(this, zzm));
    return zzm.zza(120000L);
  }
  
  public final List<Bundle> getConditionalUserProperties(String paramString1, String paramString2) {
    zzm zzm = new zzm();
    zza(new zzad(this, paramString1, paramString2, zzm));
    List<Bundle> list = zzm.<List>zza(zzm.zzb(5000L), List.class);
    return (list == null) ? Collections.emptyList() : list;
  }
  
  public final String getCurrentScreenClass() {
    zzm zzm = new zzm();
    zza(new zzar(this, zzm));
    return zzm.zza(500L);
  }
  
  public final String getCurrentScreenName() {
    zzm zzm = new zzm();
    zza(new zzaq(this, zzm));
    return zzm.zza(500L);
  }
  
  public final String getGmpAppId() {
    zzm zzm = new zzm();
    zza(new zzan(this, zzm));
    return zzm.zza(500L);
  }
  
  public final int getMaxUserProperties(String paramString) {
    zzm zzm = new zzm();
    zza(new zzav(this, paramString, zzm));
    Integer integer = zzm.<Integer>zza(zzm.zzb(10000L), Integer.class);
    return (integer == null) ? 25 : integer.intValue();
  }
  
  public final Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean) {
    zzm zzm = new zzm();
    zza(new zzas(this, paramString1, paramString2, paramBoolean, zzm));
    Bundle bundle = zzm.zzb(5000L);
    if (bundle == null || bundle.size() == 0)
      return Collections.emptyMap(); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(bundle.size());
    for (String paramString2 : bundle.keySet()) {
      Object object = bundle.get(paramString2);
      if (object instanceof Double || object instanceof Long || object instanceof String)
        hashMap.put(paramString2, object); 
    } 
    return (Map)hashMap;
  }
  
  public final void logEvent(@Nonnull String paramString, Bundle paramBundle) {
    zza(null, paramString, paramBundle, false, true, null);
  }
  
  public final void logEventInternal(String paramString1, String paramString2, Bundle paramBundle) {
    zza(paramString1, paramString2, paramBundle, true, true, null);
  }
  
  public final void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    zza(paramString1, paramString2, paramBundle, true, false, Long.valueOf(paramLong));
  }
  
  public final void resetAnalyticsData() {
    zza(new zzah(this));
  }
  
  public final void setConditionalUserProperty(Bundle paramBundle) {
    zza(new zzbd(this, paramBundle));
  }
  
  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2) {
    zza(new zzaf(this, paramActivity, paramString1, paramString2));
  }
  
  public final void setDataCollectionEnabled(boolean paramBoolean) {
    zza(new zzaz(this, paramBoolean));
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean) {
    zza(new zzag(this, paramBoolean));
  }
  
  public final void setMinimumSessionDuration(long paramLong) {
    zza(new zzai(this, paramLong));
  }
  
  public final void setSessionTimeoutDuration(long paramLong) {
    zza(new zzaj(this, paramLong));
  }
  
  public final void setUserId(String paramString) {
    zza(new zzae(this, paramString));
  }
  
  public final void setUserProperty(String paramString1, String paramString2) {
    zza((String)null, paramString1, paramString2, false);
  }
  
  public final void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject) {
    zza(paramString1, paramString2, paramObject, true);
  }
  
  public final Bundle zza(Bundle paramBundle, boolean paramBoolean) {
    zzm zzm = new zzm();
    zza(new zzau(this, paramBundle, zzm));
    return paramBoolean ? zzm.zzb(5000L) : null;
  }
  
  protected final zzn zza(Context paramContext, boolean paramBoolean) {
    if (paramBoolean)
      try {
        DynamiteModule.VersionPolicy versionPolicy1 = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
        return zzo.asInterface(DynamiteModule.load(paramContext, versionPolicy1, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
      } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loadingException) {
        zza((Exception)loadingException, true, false);
        return null;
      }  
    DynamiteModule.VersionPolicy versionPolicy = DynamiteModule.PREFER_LOCAL;
    return zzo.asInterface(DynamiteModule.load((Context)loadingException, versionPolicy, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
  }
  
  public final void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    zza(new zzat(this, false, 5, paramString, paramObject1, null, null));
  }
  
  public final void zza(zzda paramzzda) {
    zza(new zzam(this, paramzzda));
  }
  
  public final void zza(zzdb paramzzdb) {
    zza(new zzax(this, paramzzdb));
  }
  
  public final Object zzb(int paramInt) {
    zzm zzm = new zzm();
    zza(new zzay(this, zzm, paramInt));
    return zzm.zza(zzm.zzb(15000L), Object.class);
  }
  
  public final void zzb(zzdb paramzzdb) {
    zza(new zzba(this, paramzzdb));
  }
  
  public final AppMeasurementSdk zzh() {
    return this.zzac;
  }
  
  public final String zzj() {
    zzm zzm = new zzm();
    zza(new zzao(this, zzm));
    return zzm.zza(50L);
  }
  
  abstract class zza implements Runnable {
    final long timestamp = zzaa.this.zzaa.currentTimeMillis();
    
    final long zzbs = zzaa.this.zzaa.elapsedRealtime();
    
    private final boolean zzbt;
    
    zza() {
      this(true);
    }
    
    zza(boolean param1Boolean) {
      this.zzbt = param1Boolean;
    }
    
    public void run() {
      if (zzaa.zza(this.zzar)) {
        zzm();
        return;
      } 
      try {
        zzl();
        return;
      } catch (Exception exception) {
        zzaa.zza(this.zzar, exception, false, this.zzbt);
        zzm();
        return;
      } 
    }
    
    abstract void zzl() throws RemoteException;
    
    protected void zzm() {}
  }
  
  static final class zzb extends zzu {
    private final zzda zzbu;
    
    zzb(zzda param1zzda) {
      this.zzbu = param1zzda;
    }
    
    public final int id() {
      return this.zzbu.hashCode();
    }
    
    public final void onEvent(String param1String1, String param1String2, Bundle param1Bundle, long param1Long) {
      this.zzbu.interceptEvent(param1String1, param1String2, param1Bundle, param1Long);
    }
  }
  
  static final class zzc extends zzu {
    private final zzdb zzbv;
    
    zzc(zzdb param1zzdb) {
      this.zzbv = param1zzdb;
    }
    
    public final int id() {
      return this.zzbv.hashCode();
    }
    
    public final void onEvent(String param1String1, String param1String2, Bundle param1Bundle, long param1Long) {
      this.zzbv.onEvent(param1String1, param1String2, param1Bundle, param1Long);
    }
  }
  
  final class zzd implements Application.ActivityLifecycleCallbacks {
    zzd(zzaa this$0) {}
    
    public final void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {
      zzaa.zza(this.zzar, new zzbe(this, param1Activity, param1Bundle));
    }
    
    public final void onActivityDestroyed(Activity param1Activity) {
      zzaa.zza(this.zzar, new zzbk(this, param1Activity));
    }
    
    public final void onActivityPaused(Activity param1Activity) {
      zzaa.zza(this.zzar, new zzbh(this, param1Activity));
    }
    
    public final void onActivityResumed(Activity param1Activity) {
      zzaa.zza(this.zzar, new zzbg(this, param1Activity));
    }
    
    public final void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {
      zzm zzm = new zzm();
      zzaa.zza(this.zzar, new zzbj(this, param1Activity, zzm));
      Bundle bundle = zzm.zzb(50L);
      if (bundle != null)
        param1Bundle.putAll(bundle); 
    }
    
    public final void onActivityStarted(Activity param1Activity) {
      zzaa.zza(this.zzar, new zzbf(this, param1Activity));
    }
    
    public final void onActivityStopped(Activity param1Activity) {
      zzaa.zza(this.zzar, new zzbi(this, param1Activity));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */