package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzap extends zzf {
  private String zzcf;
  
  private String zzch;
  
  private String zzcn;
  
  private String zzcp;
  
  private long zzcs;
  
  private String zzcv;
  
  private int zzdq;
  
  private int zzjg;
  
  private String zzjh;
  
  private long zzji;
  
  private long zzu;
  
  zzap(zzby paramzzby, long paramLong) {
    super(paramzzby);
    this.zzu = paramLong;
  }
  
  @WorkerThread
  @VisibleForTesting
  private final String zzcw() {
    try {
      Class<?> clazz = super.getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
      if (clazz == null)
        return null; 
      try {
        Object object = clazz.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { super.getContext() });
        if (object == null)
          return null; 
        try {
          return (String)clazz.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(object, new Object[0]);
        } catch (Exception exception) {
          super.zzad().zzdf().zzaq("Failed to retrieve Firebase Instance Id");
          return null;
        } 
      } catch (Exception exception) {
        super.zzad().zzde().zzaq("Failed to obtain Firebase Analytics instance");
        return null;
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  final String getGmpAppId() {
    zzah();
    return this.zzch;
  }
  
  @WorkerThread
  final zzm zzak(String paramString) {
    String str5;
    super.zzq();
    super.zzo();
    String str1 = zzan();
    String str2 = getGmpAppId();
    zzah();
    String str3 = this.zzcn;
    long l1 = zzcx();
    zzah();
    String str4 = this.zzcp;
    long l2 = super.zzaf().zzav();
    zzah();
    super.zzq();
    if (this.zzji == 0L)
      this.zzji = this.zzl.zzab().zzc(super.getContext(), super.getContext().getPackageName()); 
    long l3 = this.zzji;
    boolean bool1 = this.zzl.isEnabled();
    boolean bool2 = (super.zzae()).zzlu;
    super.zzq();
    super.zzo();
    if (super.zzaf().zzr(this.zzcf) && !this.zzl.isEnabled()) {
      str5 = null;
    } else {
      str5 = zzcw();
    } 
    zzah();
    long l4 = this.zzcs;
    long l5 = this.zzl.zzer();
    int i = zzcy();
    zzt zzt2 = super.zzaf();
    zzt2.zzo();
    Boolean bool4 = zzt2.zzj("google_analytics_adid_collection_enabled");
    if (bool4 == null || bool4.booleanValue()) {
      bool5 = true;
    } else {
      bool5 = false;
    } 
    boolean bool6 = Boolean.valueOf(bool5).booleanValue();
    zzt zzt1 = super.zzaf();
    zzt1.zzo();
    Boolean bool3 = zzt1.zzj("google_analytics_ssaid_collection_enabled");
    if (bool3 == null || bool3.booleanValue()) {
      bool5 = true;
    } else {
      bool5 = false;
    } 
    boolean bool7 = Boolean.valueOf(bool5).booleanValue();
    boolean bool5 = super.zzae().zzdy();
    String str6 = zzao();
    if (super.zzaf().zze(zzan(), zzal.zzin)) {
      bool3 = super.zzaf().zzj("google_analytics_default_allow_ad_personalization_signals");
      if (bool3 != null) {
        bool3 = Boolean.valueOf(bool3.booleanValue() ^ true);
        return new zzm(str1, str2, str3, l1, str4, l2, l3, paramString, bool1, bool2 ^ true, str5, l4, l5, i, bool6, bool7, bool5, str6, bool3, this.zzu);
      } 
    } 
    bool3 = null;
    return new zzm(str1, str2, str3, l1, str4, l2, l3, paramString, bool1, bool2 ^ true, str5, l4, l5, i, bool6, bool7, bool5, str6, bool3, this.zzu);
  }
  
  protected final boolean zzak() {
    return true;
  }
  
  protected final void zzal() {
    String str5;
    String str6;
    String str1 = "unknown";
    String str2 = "Unknown";
    String str3 = "Unknown";
    String str4 = super.getContext().getPackageName();
    PackageManager packageManager = super.getContext().getPackageManager();
    int i = Integer.MIN_VALUE;
    if (packageManager == null) {
      super.zzad().zzda().zza("PackageManager is null, app identity information might be inaccurate. appId", zzau.zzao(str4));
      str5 = str1;
      str6 = str2;
      str1 = str3;
      j = i;
    } else {
      String str;
      try {
        str = packageManager.getInstallerPackageName(str4);
        str1 = str;
      } catch (IllegalArgumentException illegalArgumentException) {
        super.zzad().zzda().zza("Error retrieving app installer package name. appId", zzau.zzao(str4));
      } 
      if (str1 == null) {
        str = "manual_install";
      } else {
        str = str1;
        if ("com.android.vending".equals(str1))
          str = ""; 
      } 
      str6 = str2;
      str5 = str3;
      try {
        PackageInfo packageInfo = packageManager.getPackageInfo(super.getContext().getPackageName(), 0);
        str5 = str;
        str6 = str2;
        str1 = str3;
        j = i;
        if (packageInfo != null) {
          str6 = str2;
          str5 = str3;
          CharSequence charSequence = packageManager.getApplicationLabel(packageInfo.applicationInfo);
          str1 = str3;
          str6 = str2;
          str5 = str3;
          if (!TextUtils.isEmpty(charSequence)) {
            str6 = str2;
            str5 = str3;
            str1 = charSequence.toString();
          } 
          str6 = str2;
          str5 = str1;
          str3 = packageInfo.versionName;
          str6 = str3;
          str5 = str1;
          j = packageInfo.versionCode;
          str5 = str;
          str6 = str3;
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        super.zzad().zzda().zza("Error retrieving package info. appId, appName", zzau.zzao(str4), str5);
        j = i;
        str1 = str5;
        str5 = str;
      } 
    } 
    this.zzcf = str4;
    this.zzcp = str5;
    this.zzcn = str6;
    this.zzjg = j;
    this.zzjh = str1;
    this.zzji = 0L;
    super.zzag();
    Status status = GoogleServices.initialize(super.getContext());
    boolean bool = true;
    if (status != null && status.isSuccess()) {
      j = 1;
    } else {
      j = 0;
    } 
    if (!TextUtils.isEmpty(this.zzl.zzem()) && "am".equals(this.zzl.zzen())) {
      i = 1;
    } else {
      i = 0;
    } 
    j |= i;
    if (j == 0)
      if (status == null) {
        super.zzad().zzda().zzaq("GoogleService failed to initialize (no status)");
      } else {
        super.zzad().zzda().zza("GoogleService failed to initialize, status", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
      }  
    if (j != 0) {
      Boolean bool1 = super.zzaf().zzbr();
      if (super.zzaf().zzbq()) {
        if (this.zzl.zzel())
          super.zzad().zzdg().zzaq("Collection disabled with firebase_analytics_collection_deactivated=1"); 
      } else if (bool1 != null && !bool1.booleanValue()) {
        if (this.zzl.zzel())
          super.zzad().zzdg().zzaq("Collection disabled with firebase_analytics_collection_enabled=0"); 
      } else if (bool1 == null && GoogleServices.isMeasurementExplicitlyDisabled()) {
        super.zzad().zzdg().zzaq("Collection disabled with google_app_measurement_enable=0");
      } else {
        super.zzad().zzdi().zzaq("Collection enabled");
        j = bool;
        this.zzch = "";
        this.zzcv = "";
        this.zzcs = 0L;
        super.zzag();
      } 
    } 
    int j = 0;
    this.zzch = "";
    this.zzcv = "";
    this.zzcs = 0L;
    super.zzag();
  }
  
  final String zzan() {
    zzah();
    return this.zzcf;
  }
  
  final String zzao() {
    zzah();
    return this.zzcv;
  }
  
  final int zzcx() {
    zzah();
    return this.zzjg;
  }
  
  final int zzcy() {
    zzah();
    return this.zzdq;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */