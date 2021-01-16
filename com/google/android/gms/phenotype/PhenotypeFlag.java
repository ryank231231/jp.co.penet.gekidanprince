package com.google.android.gms.phenotype;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.phenotype.zzf;
import com.google.android.gms.internal.phenotype.zzh;
import javax.annotation.Nullable;

@Deprecated
@KeepForSdk
public abstract class PhenotypeFlag<T> {
  private static final Object zzak = new Object();
  
  @SuppressLint({"StaticFieldLeak"})
  private static Context zzal = null;
  
  private static boolean zzam = false;
  
  private static Boolean zzan = null;
  
  private final Factory zzao;
  
  final String zzap;
  
  private final String zzaq;
  
  private final T zzar;
  
  private T zzas = null;
  
  private PhenotypeFlag(Factory paramFactory, String paramString, T paramT) {
    if (Factory.zza(paramFactory) != null || Factory.zzb(paramFactory) != null) {
      if (Factory.zza(paramFactory) == null || Factory.zzb(paramFactory) == null) {
        this.zzao = paramFactory;
        String str2 = String.valueOf(Factory.zzc(paramFactory));
        String str3 = String.valueOf(paramString);
        if (str3.length() != 0) {
          str3 = str2.concat(str3);
        } else {
          str3 = new String(str2);
        } 
        this.zzaq = str3;
        String str1 = String.valueOf(Factory.zzd(paramFactory));
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          str1 = str1.concat(paramString);
        } else {
          str1 = new String(str1);
        } 
        this.zzap = str1;
        this.zzar = paramT;
        return;
      } 
      throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
    } 
    throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
  }
  
  @KeepForSdk
  public static void maybeInit(Context paramContext) {
    zzh.maybeInit(paramContext);
    if (zzal == null) {
      zzh.init(paramContext);
      synchronized (zzak) {
        if (Build.VERSION.SDK_INT < 24 || !paramContext.isDeviceProtectedStorage()) {
          Context context = paramContext.getApplicationContext();
          if (context != null)
            paramContext = context; 
        } 
        if (zzal != paramContext)
          zzan = null; 
        zzal = paramContext;
        zzam = false;
      } 
    } 
  }
  
  private static PhenotypeFlag<String> zza(Factory paramFactory, String paramString1, String paramString2) {
    return new zzs(paramFactory, paramString1, paramString2);
  }
  
  private static <V> V zza(zza<V> paramzza) {
    V v;
    try {
      V v1 = paramzza.zzh();
      v = v1;
    } catch (SecurityException securityException) {
      long l = Binder.clearCallingIdentity();
      try {
        v = v.zzh();
        return v;
      } finally {
        Binder.restoreCallingIdentity(l);
      } 
    } 
    return v;
  }
  
  static boolean zza(String paramString, boolean paramBoolean) {
    return zzf() ? ((Boolean)zza(new zzq(paramString, false))).booleanValue() : false;
  }
  
  @Nullable
  @TargetApi(24)
  private final T zzd() {
    if (!zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
      if (Factory.zzb(this.zzao) != null) {
        String str = zza(new zzo(this, zza.zza(zzal.getContentResolver(), Factory.zzb(this.zzao))));
        if (str != null)
          return zza(str); 
      } else if (Factory.zza(this.zzao) != null) {
        if (Build.VERSION.SDK_INT >= 24 && !zzal.isDeviceProtectedStorage() && !((UserManager)zzal.getSystemService(UserManager.class)).isUserUnlocked())
          return null; 
        SharedPreferences sharedPreferences = zzal.getSharedPreferences(Factory.zza(this.zzao), 0);
        if (sharedPreferences.contains(this.zzap))
          return zza(sharedPreferences); 
      } 
    } else {
      String str = String.valueOf(this.zzap);
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
  private final T zze() {
    if (!Factory.zzf(this.zzao) && zzf()) {
      String str = zza(new zzp(this));
      if (str != null)
        return zza(str); 
    } 
    return null;
  }
  
  private static boolean zzf() {
    if (zzan == null) {
      Context context = zzal;
      boolean bool = false;
      if (context != null) {
        if (PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0)
          bool = true; 
        zzan = Boolean.valueOf(bool);
      } else {
        return false;
      } 
    } 
    return zzan.booleanValue();
  }
  
  @KeepForSdk
  public T get() {
    if (zzal != null) {
      if (Factory.zze(this.zzao)) {
        T t = zze();
        if (t != null)
          return t; 
        t = zzd();
        if (t != null)
          return t; 
      } else {
        T t = zzd();
        if (t != null)
          return t; 
        t = zze();
        if (t != null)
          return t; 
      } 
      return this.zzar;
    } 
    throw new IllegalStateException("Must call PhenotypeFlag.init() first");
  }
  
  public abstract T zza(SharedPreferences paramSharedPreferences);
  
  public abstract T zza(String paramString);
  
  @KeepForSdk
  public static class Factory {
    private final String zzax;
    
    private final Uri zzay;
    
    private final String zzaz;
    
    private final String zzba;
    
    private final boolean zzbb;
    
    private final boolean zzbc;
    
    @KeepForSdk
    public Factory(Uri param1Uri) {
      this(null, param1Uri, "", "", false, false);
    }
    
    private Factory(String param1String1, Uri param1Uri, String param1String2, String param1String3, boolean param1Boolean1, boolean param1Boolean2) {
      this.zzax = param1String1;
      this.zzay = param1Uri;
      this.zzaz = param1String2;
      this.zzba = param1String3;
      this.zzbb = param1Boolean1;
      this.zzbc = param1Boolean2;
    }
    
    @KeepForSdk
    public PhenotypeFlag<String> createFlag(String param1String1, String param1String2) {
      return PhenotypeFlag.zzb(this, param1String1, param1String2);
    }
    
    @KeepForSdk
    public Factory withGservicePrefix(String param1String) {
      boolean bool = this.zzbb;
      if (!bool)
        return new Factory(this.zzax, this.zzay, param1String, this.zzba, bool, this.zzbc); 
      throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }
    
    @KeepForSdk
    public Factory withPhenotypePrefix(String param1String) {
      return new Factory(this.zzax, this.zzay, this.zzaz, param1String, this.zzbb, this.zzbc);
    }
  }
  
  static interface zza<V> {
    V zzh();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\phenotype\PhenotypeFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */