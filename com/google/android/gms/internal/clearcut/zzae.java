package com.google.android.gms.internal.clearcut;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import javax.annotation.Nullable;

public abstract class zzae<T> {
  private static final Object zzdn = new Object();
  
  private static boolean zzdo;
  
  private static volatile Boolean zzdp;
  
  private static volatile Boolean zzdq;
  
  @SuppressLint({"StaticFieldLeak"})
  private static Context zzh = null;
  
  private final zzao zzdr;
  
  final String zzds;
  
  private final String zzdt;
  
  private final T zzdu;
  
  private T zzdv = null;
  
  private volatile zzab zzdw = null;
  
  private volatile SharedPreferences zzdx = null;
  
  static {
    zzdo = false;
    zzdp = null;
    zzdq = null;
  }
  
  private zzae(zzao paramzzao, String paramString, T paramT) {
    if (zzao.zza(paramzzao) != null || zzao.zzb(paramzzao) != null) {
      if (zzao.zza(paramzzao) == null || zzao.zzb(paramzzao) == null) {
        this.zzdr = paramzzao;
        String str2 = String.valueOf(zzao.zzc(paramzzao));
        String str3 = String.valueOf(paramString);
        if (str3.length() != 0) {
          str2 = str2.concat(str3);
        } else {
          str2 = new String(str2);
        } 
        this.zzdt = str2;
        String str1 = String.valueOf(zzao.zzd(paramzzao));
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          str1 = str1.concat(paramString);
        } else {
          str1 = new String(str1);
        } 
        this.zzds = str1;
        this.zzdu = paramT;
        return;
      } 
      throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
    } 
    throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
  }
  
  public static void maybeInit(Context paramContext) {
    if (zzh == null)
      synchronized (zzdn) {
        if (Build.VERSION.SDK_INT < 24 || !paramContext.isDeviceProtectedStorage()) {
          Context context = paramContext.getApplicationContext();
          if (context != null)
            paramContext = context; 
        } 
        if (zzh != paramContext)
          zzdp = null; 
        zzh = paramContext;
        zzdo = false;
      }  
  }
  
  private static <T> zzae<T> zza(zzao paramzzao, String paramString, T paramT, zzan<T> paramzzan) {
    return new zzal(paramzzao, paramString, paramT, paramzzan);
  }
  
  private static zzae<String> zza(zzao paramzzao, String paramString1, String paramString2) {
    return new zzak(paramzzao, paramString1, paramString2);
  }
  
  private static zzae<Boolean> zza(zzao paramzzao, String paramString, boolean paramBoolean) {
    return new zzaj(paramzzao, paramString, Boolean.valueOf(paramBoolean));
  }
  
  private static <V> V zza(zzam<V> paramzzam) {
    V v;
    try {
      V v1 = paramzzam.zzp();
      v = v1;
    } catch (SecurityException securityException) {
      long l = Binder.clearCallingIdentity();
      try {
        v = v.zzp();
        return v;
      } finally {
        Binder.restoreCallingIdentity(l);
      } 
    } 
    return v;
  }
  
  static boolean zza(String paramString, boolean paramBoolean) {
    return zzn() ? ((Boolean)zza(new zzah(paramString, false))).booleanValue() : false;
  }
  
  @Nullable
  @TargetApi(24)
  private final T zzl() {
    if (!zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
      if (zzao.zzb(this.zzdr) != null) {
        if (this.zzdw == null)
          this.zzdw = zzab.zza(zzh.getContentResolver(), zzao.zzb(this.zzdr)); 
        String str = zza(new zzaf(this, this.zzdw));
        if (str != null)
          return zzb(str); 
      } else if (zzao.zza(this.zzdr) != null) {
        boolean bool;
        if (Build.VERSION.SDK_INT >= 24 && !zzh.isDeviceProtectedStorage()) {
          if (zzdq == null || !zzdq.booleanValue())
            zzdq = Boolean.valueOf(((UserManager)zzh.getSystemService(UserManager.class)).isUserUnlocked()); 
          bool = zzdq.booleanValue();
        } else {
          bool = true;
        } 
        if (!bool)
          return null; 
        if (this.zzdx == null)
          this.zzdx = zzh.getSharedPreferences(zzao.zza(this.zzdr), 0); 
        SharedPreferences sharedPreferences = this.zzdx;
        if (sharedPreferences.contains(this.zzds))
          return zza(sharedPreferences); 
      } 
    } else {
      String str = String.valueOf(this.zzds);
      if (str.length() != 0) {
        str = "Bypass reading Phenotype values for flag: ".concat(str);
      } else {
        str = new String("Bypass reading Phenotype values for flag: ");
      } 
      Log.w("PhenotypeFlag", str);
    } 
    return null;
  }
  
  @Nullable
  private final T zzm() {
    if (!zzao.zzf(this.zzdr) && zzn()) {
      String str = zza(new zzag(this));
      if (str != null)
        return zzb(str); 
    } 
    return null;
  }
  
  private static boolean zzn() {
    if (zzdp == null) {
      Context context = zzh;
      boolean bool = false;
      if (context != null) {
        if (PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0)
          bool = true; 
        zzdp = Boolean.valueOf(bool);
      } else {
        return false;
      } 
    } 
    return zzdp.booleanValue();
  }
  
  public final T get() {
    if (zzh != null) {
      if (zzao.zze(this.zzdr)) {
        T t = zzm();
        if (t != null)
          return t; 
        t = zzl();
        if (t != null)
          return t; 
      } else {
        T t = zzl();
        if (t != null)
          return t; 
        t = zzm();
        if (t != null)
          return t; 
      } 
      return this.zzdu;
    } 
    throw new IllegalStateException("Must call PhenotypeFlag.init() first");
  }
  
  protected abstract T zza(SharedPreferences paramSharedPreferences);
  
  protected abstract T zzb(String paramString);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */