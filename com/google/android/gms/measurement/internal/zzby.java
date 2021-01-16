package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcw;
import com.google.android.gms.internal.measurement.zzy;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class zzby implements zzcv {
  private static volatile zzby zznn;
  
  private final Clock zzaa;
  
  private boolean zzce;
  
  private final long zzdp;
  
  private final zzq zzfq;
  
  private final Context zzno;
  
  private final String zznp;
  
  private final String zznq;
  
  private final zzt zznr;
  
  private final zzbf zzns;
  
  private final zzau zznt;
  
  private final zzbt zznu;
  
  private final zzfj zznv;
  
  private final zzgd zznw;
  
  private final zzas zznx;
  
  private final zzed zzny;
  
  private final zzdd zznz;
  
  private final zza zzoa;
  
  private final zzdz zzob;
  
  private zzaq zzoc;
  
  private zzeg zzod;
  
  private zzad zzoe;
  
  private zzap zzof;
  
  private zzbl zzog;
  
  private Boolean zzoh;
  
  private long zzoi;
  
  private volatile Boolean zzoj;
  
  @VisibleForTesting
  private Boolean zzok;
  
  @VisibleForTesting
  private Boolean zzol;
  
  private int zzom;
  
  private AtomicInteger zzon;
  
  private final boolean zzv;
  
  private final String zzx;
  
  private zzby(zzdc paramzzdc) {
    boolean bool1 = false;
    this.zzce = false;
    this.zzon = new AtomicInteger(0);
    Preconditions.checkNotNull(paramzzdc);
    this.zzfq = new zzq(paramzzdc.zzno);
    zzal.zza(this.zzfq);
    this.zzno = paramzzdc.zzno;
    this.zzx = paramzzdc.zzx;
    this.zznp = paramzzdc.zznp;
    this.zznq = paramzzdc.zznq;
    this.zzv = paramzzdc.zzv;
    this.zzoj = paramzzdc.zzoj;
    zzy zzy = paramzzdc.zzpe;
    if (zzy != null && zzy.zzy != null) {
      Object object2 = zzy.zzy.get("measurementEnabled");
      if (object2 instanceof Boolean)
        this.zzok = (Boolean)object2; 
      Object object1 = zzy.zzy.get("measurementDeactivated");
      if (object1 instanceof Boolean)
        this.zzol = (Boolean)object1; 
    } 
    zzcw.zzq(this.zzno);
    this.zzaa = DefaultClock.getInstance();
    this.zzdp = this.zzaa.currentTimeMillis();
    this.zznr = new zzt(this);
    zzbf zzbf1 = new zzbf(this);
    zzbf1.zzai();
    this.zzns = zzbf1;
    zzau zzau1 = new zzau(this);
    zzau1.zzai();
    this.zznt = zzau1;
    zzgd zzgd1 = new zzgd(this);
    zzgd1.zzai();
    this.zznw = zzgd1;
    zzas zzas1 = new zzas(this);
    zzas1.zzai();
    this.zznx = zzas1;
    this.zzoa = new zza(this);
    zzed zzed1 = new zzed(this);
    zzed1.zzai();
    this.zzny = zzed1;
    zzdd zzdd1 = new zzdd(this);
    zzdd1.zzai();
    this.zznz = zzdd1;
    zzfj zzfj1 = new zzfj(this);
    zzfj1.zzai();
    this.zznv = zzfj1;
    zzdz zzdz1 = new zzdz(this);
    zzdz1.zzai();
    this.zzob = zzdz1;
    zzbt zzbt1 = new zzbt(this);
    zzbt1.zzai();
    this.zznu = zzbt1;
    boolean bool2 = bool1;
    if (paramzzdc.zzpe != null) {
      bool2 = bool1;
      if (paramzzdc.zzpe.zzu != 0L)
        bool2 = true; 
    } 
    zzq zzq1 = this.zzfq;
    if (this.zzno.getApplicationContext() instanceof Application) {
      zzdd zzdd2 = zzs();
      if (zzdd2.getContext().getApplicationContext() instanceof Application) {
        Application application = (Application)zzdd2.getContext().getApplicationContext();
        if (zzdd2.zzpf == null)
          zzdd2.zzpf = new zzdx(zzdd2, null); 
        if ((bool2 ^ true) != 0) {
          application.unregisterActivityLifecycleCallbacks(zzdd2.zzpf);
          application.registerActivityLifecycleCallbacks(zzdd2.zzpf);
          zzdd2.zzad().zzdi().zzaq("Registered activity lifecycle callback");
        } 
      } 
    } else {
      zzad().zzdd().zzaq("Application context is not an Application");
    } 
    this.zznu.zza(new zzbz(this, paramzzdc));
  }
  
  public static zzby zza(Context paramContext, zzy paramzzy) {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull -> 52
    //   6: aload_1
    //   7: getfield origin : Ljava/lang/String;
    //   10: ifnull -> 22
    //   13: aload_1
    //   14: astore_2
    //   15: aload_1
    //   16: getfield zzx : Ljava/lang/String;
    //   19: ifnonnull -> 52
    //   22: new com/google/android/gms/internal/measurement/zzy
    //   25: dup
    //   26: aload_1
    //   27: getfield zzt : J
    //   30: aload_1
    //   31: getfield zzu : J
    //   34: aload_1
    //   35: getfield zzv : Z
    //   38: aload_1
    //   39: getfield zzw : Ljava/lang/String;
    //   42: aconst_null
    //   43: aconst_null
    //   44: aload_1
    //   45: getfield zzy : Landroid/os/Bundle;
    //   48: invokespecial <init> : (JJZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   51: astore_2
    //   52: aload_0
    //   53: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   61: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: getstatic com/google/android/gms/measurement/internal/zzby.zznn : Lcom/google/android/gms/measurement/internal/zzby;
    //   68: ifnonnull -> 115
    //   71: ldc com/google/android/gms/measurement/internal/zzby
    //   73: monitorenter
    //   74: getstatic com/google/android/gms/measurement/internal/zzby.zznn : Lcom/google/android/gms/measurement/internal/zzby;
    //   77: ifnonnull -> 103
    //   80: new com/google/android/gms/measurement/internal/zzdc
    //   83: astore_1
    //   84: aload_1
    //   85: aload_0
    //   86: aload_2
    //   87: invokespecial <init> : (Landroid/content/Context;Lcom/google/android/gms/internal/measurement/zzy;)V
    //   90: new com/google/android/gms/measurement/internal/zzby
    //   93: astore_0
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzdc;)V
    //   99: aload_0
    //   100: putstatic com/google/android/gms/measurement/internal/zzby.zznn : Lcom/google/android/gms/measurement/internal/zzby;
    //   103: ldc com/google/android/gms/measurement/internal/zzby
    //   105: monitorexit
    //   106: goto -> 155
    //   109: astore_0
    //   110: ldc com/google/android/gms/measurement/internal/zzby
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    //   115: aload_2
    //   116: ifnull -> 155
    //   119: aload_2
    //   120: getfield zzy : Landroid/os/Bundle;
    //   123: ifnull -> 155
    //   126: aload_2
    //   127: getfield zzy : Landroid/os/Bundle;
    //   130: ldc_w 'dataCollectionDefaultEnabled'
    //   133: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   136: ifeq -> 155
    //   139: getstatic com/google/android/gms/measurement/internal/zzby.zznn : Lcom/google/android/gms/measurement/internal/zzby;
    //   142: aload_2
    //   143: getfield zzy : Landroid/os/Bundle;
    //   146: ldc_w 'dataCollectionDefaultEnabled'
    //   149: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   152: invokevirtual zza : (Z)V
    //   155: getstatic com/google/android/gms/measurement/internal/zzby.zznn : Lcom/google/android/gms/measurement/internal/zzby;
    //   158: areturn
    // Exception table:
    //   from	to	target	type
    //   74	103	109	finally
    //   103	106	109	finally
    //   110	113	109	finally
  }
  
  @VisibleForTesting
  public static zzby zza(Context paramContext, String paramString1, String paramString2, Bundle paramBundle) {
    return zza(paramContext, new zzy(0L, 0L, true, null, null, null, paramBundle));
  }
  
  private static void zza(zzct paramzzct) {
    if (paramzzct != null)
      return; 
    throw new IllegalStateException("Component not created");
  }
  
  private static void zza(zzcu paramzzcu) {
    if (paramzzcu != null) {
      if (paramzzcu.isInitialized())
        return; 
      String str = String.valueOf(paramzzcu.getClass());
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
      stringBuilder.append("Component not initialized: ");
      stringBuilder.append(str);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("Component not created");
  }
  
  @WorkerThread
  private final void zza(zzdc paramzzdc) {
    zzac().zzq();
    zzt.zzbo();
    zzad zzad1 = new zzad(this);
    zzad1.zzai();
    this.zzoe = zzad1;
    zzap zzap1 = new zzap(this, paramzzdc.zzu);
    zzap1.zzai();
    this.zzof = zzap1;
    zzaq zzaq1 = new zzaq(this);
    zzaq1.zzai();
    this.zzoc = zzaq1;
    zzeg zzeg1 = new zzeg(this);
    zzeg1.zzai();
    this.zzod = zzeg1;
    this.zznw.zzaj();
    this.zzns.zzaj();
    this.zzog = new zzbl(this);
    this.zzof.zzaj();
    zzad().zzdg().zza("App measurement is starting up, version", Long.valueOf(this.zznr.zzav()));
    zzq zzq1 = this.zzfq;
    zzad().zzdg().zzaq("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
    zzq1 = this.zzfq;
    String str = zzap1.zzan();
    if (TextUtils.isEmpty(this.zzx)) {
      zzaw zzaw;
      if (zzab().zzbt(str)) {
        zzaw = zzad().zzdg();
        str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
      } else {
        zzaw = zzad().zzdg();
        str = String.valueOf(str);
        if (str.length() != 0) {
          str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(str);
        } else {
          str = new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        } 
      } 
      zzaw.zzaq(str);
    } 
    zzad().zzdh().zzaq("Debug-level message logging enabled");
    if (this.zzom != this.zzon.get())
      zzad().zzda().zza("Not all components initialized", Integer.valueOf(this.zzom), Integer.valueOf(this.zzon.get())); 
    this.zzce = true;
  }
  
  private static void zza(zzf paramzzf) {
    if (paramzzf != null) {
      if (paramzzf.isInitialized())
        return; 
      String str = String.valueOf(paramzzf.getClass());
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
      stringBuilder.append("Component not initialized: ");
      stringBuilder.append(str);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("Component not created");
  }
  
  private final void zzah() {
    if (this.zzce)
      return; 
    throw new IllegalStateException("AppMeasurement is not initialized");
  }
  
  public final Context getContext() {
    return this.zzno;
  }
  
  @WorkerThread
  public final boolean isEnabled() {
    boolean bool1;
    zzac().zzq();
    zzah();
    if (this.zznr.zza(zzal.zzio)) {
      if (this.zznr.zzbq())
        return false; 
      Boolean bool2 = this.zzol;
      if (bool2 != null && bool2.booleanValue())
        return false; 
      bool2 = zzae().zzdw();
      if (bool2 != null)
        return bool2.booleanValue(); 
      bool2 = this.zznr.zzbr();
      if (bool2 != null)
        return bool2.booleanValue(); 
      bool2 = this.zzok;
      return (bool2 != null) ? bool2.booleanValue() : (GoogleServices.isMeasurementExplicitlyDisabled() ? false : ((this.zznr.zza(zzal.zzik) && this.zzoj != null) ? this.zzoj.booleanValue() : true));
    } 
    if (this.zznr.zzbq())
      return false; 
    Boolean bool = this.zznr.zzbr();
    if (bool != null) {
      bool1 = bool.booleanValue();
    } else {
      int j = GoogleServices.isMeasurementExplicitlyDisabled() ^ true;
      int i = j;
      if (j != 0) {
        i = j;
        if (this.zzoj != null) {
          i = j;
          if (((Boolean)zzal.zzik.get(null)).booleanValue())
            bool1 = this.zzoj.booleanValue(); 
        } 
      } 
    } 
    return zzae().zze(bool1);
  }
  
  @WorkerThread
  protected final void start() {
    zzac().zzq();
    if ((zzae()).zzlb.get() == 0L)
      (zzae()).zzlb.set(this.zzaa.currentTimeMillis()); 
    if (Long.valueOf((zzae()).zzlg.get()).longValue() == 0L) {
      zzad().zzdi().zza("Persisting first open", Long.valueOf(this.zzdp));
      (zzae()).zzlg.set(this.zzdp);
    } 
    if (!zzet()) {
      if (isEnabled()) {
        if (!zzab().zzbr("android.permission.INTERNET"))
          zzad().zzda().zzaq("App is missing INTERNET permission"); 
        if (!zzab().zzbr("android.permission.ACCESS_NETWORK_STATE"))
          zzad().zzda().zzaq("App is missing ACCESS_NETWORK_STATE permission"); 
        zzq zzq1 = this.zzfq;
        if (!Wrappers.packageManager(this.zzno).isCallerInstantApp() && !this.zznr.zzbw()) {
          if (!zzbo.zzl(this.zzno))
            zzad().zzda().zzaq("AppMeasurementReceiver not registered/enabled"); 
          if (!zzgd.zzb(this.zzno, false))
            zzad().zzda().zzaq("AppMeasurementService not registered/enabled"); 
        } 
        zzad().zzda().zzaq("Uploading is not possible. App measurement disabled");
      } 
    } else {
      zzq zzq1 = this.zzfq;
      if (!TextUtils.isEmpty(zzt().getGmpAppId()) || !TextUtils.isEmpty(zzt().zzao())) {
        zzab();
        if (zzgd.zza(zzt().getGmpAppId(), zzae().zzds(), zzt().zzao(), zzae().zzdt())) {
          zzad().zzdg().zzaq("Rechecking which service to use due to a GMP App Id change");
          zzae().zzdv();
          zzw().resetAnalyticsData();
          this.zzod.disconnect();
          this.zzod.zzfh();
          (zzae()).zzlg.set(this.zzdp);
          (zzae()).zzli.zzav(null);
        } 
        zzae().zzat(zzt().getGmpAppId());
        zzae().zzau(zzt().zzao());
        if (this.zznr.zzaa(zzt().zzan()))
          this.zznv.zzab(this.zzdp); 
      } 
      zzs().zzbi((zzae()).zzli.zzed());
      zzq1 = this.zzfq;
      if (!TextUtils.isEmpty(zzt().getGmpAppId()) || !TextUtils.isEmpty(zzt().zzao())) {
        boolean bool = isEnabled();
        if (!zzae().zzdz() && !this.zznr.zzbq())
          zzae().zzf(bool ^ true); 
        if (!this.zznr.zzs(zzt().zzan()) || bool)
          zzs().zzfb(); 
        zzu().zza(new AtomicReference<String>());
      } 
    } 
    (zzae()).zzlq.set(this.zznr.zza(zzal.zziw));
    (zzae()).zzlr.set(this.zznr.zza(zzal.zzix));
  }
  
  @WorkerThread
  final void zza(boolean paramBoolean) {
    this.zzoj = Boolean.valueOf(paramBoolean);
  }
  
  public final zzas zzaa() {
    zza(this.zznx);
    return this.zznx;
  }
  
  public final zzgd zzab() {
    zza(this.zznw);
    return this.zznw;
  }
  
  public final zzbt zzac() {
    zza(this.zznu);
    return this.zznu;
  }
  
  public final zzau zzad() {
    zza(this.zznt);
    return this.zznt;
  }
  
  public final zzbf zzae() {
    zza(this.zzns);
    return this.zzns;
  }
  
  public final zzt zzaf() {
    return this.zznr;
  }
  
  public final zzq zzag() {
    return this.zzfq;
  }
  
  final void zzb(zzcu paramzzcu) {
    this.zzom++;
  }
  
  final void zzb(zzf paramzzf) {
    this.zzom++;
  }
  
  public final zzau zzei() {
    zzau zzau1 = this.zznt;
    return (zzau1 != null && zzau1.isInitialized()) ? this.zznt : null;
  }
  
  public final zzbl zzej() {
    return this.zzog;
  }
  
  final zzbt zzek() {
    return this.zznu;
  }
  
  public final boolean zzel() {
    return TextUtils.isEmpty(this.zzx);
  }
  
  public final String zzem() {
    return this.zzx;
  }
  
  public final String zzen() {
    return this.zznp;
  }
  
  public final String zzeo() {
    return this.zznq;
  }
  
  public final boolean zzep() {
    return this.zzv;
  }
  
  @WorkerThread
  public final boolean zzeq() {
    return (this.zzoj != null && this.zzoj.booleanValue());
  }
  
  final long zzer() {
    Long long_ = Long.valueOf((zzae()).zzlg.get());
    return (long_.longValue() == 0L) ? this.zzdp : Math.min(this.zzdp, long_.longValue());
  }
  
  final void zzes() {
    this.zzon.incrementAndGet();
  }
  
  @WorkerThread
  protected final boolean zzet() {
    zzah();
    zzac().zzq();
    Boolean bool = this.zzoh;
    if (bool == null || this.zzoi == 0L || (bool != null && !bool.booleanValue() && Math.abs(this.zzaa.elapsedRealtime() - this.zzoi) > 1000L)) {
      this.zzoi = this.zzaa.elapsedRealtime();
      zzq zzq1 = this.zzfq;
      boolean bool1 = zzab().zzbr("android.permission.INTERNET");
      boolean bool2 = true;
      if (bool1 && zzab().zzbr("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzno).isCallerInstantApp() || this.zznr.zzbw() || (zzbo.zzl(this.zzno) && zzgd.zzb(this.zzno, false)))) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.zzoh = Boolean.valueOf(bool1);
      if (this.zzoh.booleanValue()) {
        bool1 = bool2;
        if (!zzab().zzr(zzt().getGmpAppId(), zzt().zzao()))
          if (!TextUtils.isEmpty(zzt().zzao())) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }  
        this.zzoh = Boolean.valueOf(bool1);
      } 
    } 
    return this.zzoh.booleanValue();
  }
  
  final void zzn() {
    zzq zzq1 = this.zzfq;
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  final void zzo() {
    zzq zzq1 = this.zzfq;
  }
  
  public final zza zzr() {
    zza zza1 = this.zzoa;
    if (zza1 != null)
      return zza1; 
    throw new IllegalStateException("Component not created");
  }
  
  public final zzdd zzs() {
    zza(this.zznz);
    return this.zznz;
  }
  
  public final zzap zzt() {
    zza(this.zzof);
    return this.zzof;
  }
  
  public final zzeg zzu() {
    zza(this.zzod);
    return this.zzod;
  }
  
  public final zzed zzv() {
    zza(this.zzny);
    return this.zzny;
  }
  
  public final zzaq zzw() {
    zza(this.zzoc);
    return this.zzoc;
  }
  
  public final zzfj zzx() {
    zza(this.zznv);
    return this.zznv;
  }
  
  public final zzad zzy() {
    zza(this.zzoe);
    return this.zzoe;
  }
  
  public final Clock zzz() {
    return this.zzaa;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */