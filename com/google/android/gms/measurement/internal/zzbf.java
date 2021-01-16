package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzbf extends zzcu {
  @VisibleForTesting
  static final Pair<String, Long> zzky = new Pair("", Long.valueOf(0L));
  
  private SharedPreferences zzkz;
  
  public zzbj zzla;
  
  public final zzbi zzlb = new zzbi(this, "last_upload", 0L);
  
  public final zzbi zzlc = new zzbi(this, "last_upload_attempt", 0L);
  
  public final zzbi zzld = new zzbi(this, "backoff", 0L);
  
  public final zzbi zzle = new zzbi(this, "last_delete_stale", 0L);
  
  public final zzbi zzlf = new zzbi(this, "midnight_offset", 0L);
  
  public final zzbi zzlg = new zzbi(this, "first_open_time", 0L);
  
  public final zzbi zzlh = new zzbi(this, "app_install_time", 0L);
  
  public final zzbk zzli = new zzbk(this, "app_instance_id", null);
  
  private String zzlj;
  
  private boolean zzlk;
  
  private long zzll;
  
  public final zzbi zzlm = new zzbi(this, "time_before_start", 10000L);
  
  public final zzbi zzln = new zzbi(this, "session_timeout", 1800000L);
  
  public final zzbh zzlo = new zzbh(this, "start_new_session", true);
  
  public final zzbk zzlp = new zzbk(this, "non_personalized_ads", null);
  
  public final zzbh zzlq = new zzbh(this, "use_dynamite_api", false);
  
  public final zzbh zzlr = new zzbh(this, "allow_remote_dynamite", false);
  
  public final zzbi zzls = new zzbi(this, "last_pause_time", 0L);
  
  public final zzbi zzlt = new zzbi(this, "time_active", 0L);
  
  public boolean zzlu;
  
  public zzbh zzlv = new zzbh(this, "app_backgrounded", false);
  
  zzbf(zzby paramzzby) {
    super(paramzzby);
  }
  
  @WorkerThread
  private final SharedPreferences zzdr() {
    zzq();
    zzah();
    return this.zzkz;
  }
  
  @WorkerThread
  final void setMeasurementEnabled(boolean paramBoolean) {
    zzq();
    zzad().zzdi().zza("Setting measurementEnabled", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor editor = zzdr().edit();
    editor.putBoolean("measurement_enabled", paramBoolean);
    editor.apply();
  }
  
  protected final boolean zzak() {
    return true;
  }
  
  @WorkerThread
  protected final void zzal() {
    this.zzkz = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    this.zzlu = this.zzkz.getBoolean("has_been_opened", false);
    if (!this.zzlu) {
      SharedPreferences.Editor editor = this.zzkz.edit();
      editor.putBoolean("has_been_opened", true);
      editor.apply();
    } 
    this.zzla = new zzbj(this, "health_monitor", Math.max(0L, ((Long)zzal.zzgf.get(null)).longValue()), null);
  }
  
  @NonNull
  @WorkerThread
  final Pair<String, Boolean> zzar(String paramString) {
    zzq();
    long l = zzz().elapsedRealtime();
    String str = this.zzlj;
    if (str != null && l < this.zzll)
      return new Pair(str, Boolean.valueOf(this.zzlk)); 
    this.zzll = l + zzaf().zza(paramString, zzal.zzge);
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try {
      AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      if (info != null) {
        this.zzlj = info.getId();
        this.zzlk = info.isLimitAdTrackingEnabled();
      } 
      if (this.zzlj == null)
        this.zzlj = ""; 
    } catch (Exception exception) {
      zzad().zzdh().zza("Unable to get advertising id", exception);
      this.zzlj = "";
    } 
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(this.zzlj, Boolean.valueOf(this.zzlk));
  }
  
  @WorkerThread
  final String zzas(String paramString) {
    zzq();
    paramString = (String)(zzar(paramString)).first;
    MessageDigest messageDigest = zzgd.getMessageDigest();
    return (messageDigest == null) ? null : String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, messageDigest.digest(paramString.getBytes())) });
  }
  
  @WorkerThread
  final void zzat(String paramString) {
    zzq();
    SharedPreferences.Editor editor = zzdr().edit();
    editor.putString("gmp_app_id", paramString);
    editor.apply();
  }
  
  @WorkerThread
  final void zzau(String paramString) {
    zzq();
    SharedPreferences.Editor editor = zzdr().edit();
    editor.putString("admob_app_id", paramString);
    editor.apply();
  }
  
  @WorkerThread
  final void zzd(boolean paramBoolean) {
    zzq();
    zzad().zzdi().zza("Setting useService", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor editor = zzdr().edit();
    editor.putBoolean("use_service", paramBoolean);
    editor.apply();
  }
  
  @WorkerThread
  final String zzds() {
    zzq();
    return zzdr().getString("gmp_app_id", null);
  }
  
  @WorkerThread
  final String zzdt() {
    zzq();
    return zzdr().getString("admob_app_id", null);
  }
  
  @WorkerThread
  final Boolean zzdu() {
    zzq();
    return !zzdr().contains("use_service") ? null : Boolean.valueOf(zzdr().getBoolean("use_service", false));
  }
  
  @WorkerThread
  final void zzdv() {
    zzq();
    zzad().zzdi().zzaq("Clearing collection preferences.");
    if (zzaf().zza(zzal.zzio)) {
      Boolean bool = zzdw();
      SharedPreferences.Editor editor1 = zzdr().edit();
      editor1.clear();
      editor1.apply();
      if (bool != null)
        setMeasurementEnabled(bool.booleanValue()); 
      return;
    } 
    boolean bool1 = zzdr().contains("measurement_enabled");
    boolean bool2 = true;
    if (bool1)
      bool2 = zze(true); 
    SharedPreferences.Editor editor = zzdr().edit();
    editor.clear();
    editor.apply();
    if (bool1)
      setMeasurementEnabled(bool2); 
  }
  
  @WorkerThread
  final Boolean zzdw() {
    zzq();
    return zzdr().contains("measurement_enabled") ? Boolean.valueOf(zzdr().getBoolean("measurement_enabled", true)) : null;
  }
  
  @WorkerThread
  protected final String zzdx() {
    zzq();
    String str1 = zzdr().getString("previous_os_version", null);
    zzy().zzah();
    String str2 = Build.VERSION.RELEASE;
    if (!TextUtils.isEmpty(str2) && !str2.equals(str1)) {
      SharedPreferences.Editor editor = zzdr().edit();
      editor.putString("previous_os_version", str2);
      editor.apply();
    } 
    return str1;
  }
  
  @WorkerThread
  final boolean zzdy() {
    zzq();
    return zzdr().getBoolean("deferred_analytics_collection", false);
  }
  
  @WorkerThread
  final boolean zzdz() {
    return this.zzkz.contains("deferred_analytics_collection");
  }
  
  @WorkerThread
  final boolean zze(boolean paramBoolean) {
    zzq();
    return zzdr().getBoolean("measurement_enabled", paramBoolean);
  }
  
  @WorkerThread
  final void zzf(boolean paramBoolean) {
    zzq();
    zzad().zzdi().zza("Updating deferred analytics collection", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor editor = zzdr().edit();
    editor.putBoolean("deferred_analytics_collection", paramBoolean);
    editor.apply();
  }
  
  final boolean zzx(long paramLong) {
    return (paramLong - this.zzln.get() > this.zzls.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */