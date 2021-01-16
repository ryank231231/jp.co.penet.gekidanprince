package com.google.android.gms.common.config;

import android.content.Context;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GservicesValue<T> {
  private static final Object sLock = new Object();
  
  private static zza zzbm = null;
  
  private static int zzbn = 0;
  
  private static Context zzbo;
  
  @GuardedBy("sLock")
  private static HashSet<String> zzbp;
  
  protected final String mKey;
  
  protected final T zzbq;
  
  private T zzbr = null;
  
  protected GservicesValue(String paramString, T paramT) {
    this.mKey = paramString;
    this.zzbq = paramT;
  }
  
  @KeepForSdk
  public static boolean isInitialized() {
    synchronized (sLock) {
      return false;
    } 
  }
  
  @KeepForSdk
  public static GservicesValue<Float> value(String paramString, Float paramFloat) {
    return new zzd(paramString, paramFloat);
  }
  
  @KeepForSdk
  public static GservicesValue<Integer> value(String paramString, Integer paramInteger) {
    return new zzc(paramString, paramInteger);
  }
  
  @KeepForSdk
  public static GservicesValue<Long> value(String paramString, Long paramLong) {
    return new zzb(paramString, paramLong);
  }
  
  @KeepForSdk
  public static GservicesValue<String> value(String paramString1, String paramString2) {
    return new zze(paramString1, paramString2);
  }
  
  @KeepForSdk
  public static GservicesValue<Boolean> value(String paramString, boolean paramBoolean) {
    return new zza(paramString, Boolean.valueOf(paramBoolean));
  }
  
  private static boolean zzi() {
    synchronized (sLock) {
      return false;
    } 
  }
  
  @KeepForSdk
  public final T get() {
    T t = this.zzbr;
    if (t != null)
      return t; 
    null = StrictMode.allowThreadDiskReads();
    synchronized (sLock) {
      synchronized (sLock) {
        zzbp = null;
        zzbo = null;
        try {
          null = zzd(this.mKey);
          StrictMode.setThreadPolicy(null);
          return (T)null;
        } catch (SecurityException null) {
          long l = Binder.clearCallingIdentity();
          try {
            null = (SecurityException)zzd(this.mKey);
            Binder.restoreCallingIdentity(l);
            return (T)null;
          } finally {
            Binder.restoreCallingIdentity(l);
          } 
        } finally {}
        StrictMode.setThreadPolicy(null);
        throw null;
      } 
    } 
  }
  
  @Deprecated
  @KeepForSdk
  public final T getBinderSafe() {
    return get();
  }
  
  @KeepForSdk
  @VisibleForTesting
  public void override(T paramT) {
    Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
    this.zzbr = paramT;
    synchronized (sLock) {
      zzi();
      return;
    } 
  }
  
  @KeepForSdk
  @VisibleForTesting
  public void resetOverride() {
    this.zzbr = null;
  }
  
  protected abstract T zzd(String paramString);
  
  private static interface zza {
    Long getLong(String param1String, Long param1Long);
    
    String getString(String param1String1, String param1String2);
    
    Boolean zza(String param1String, Boolean param1Boolean);
    
    Float zza(String param1String, Float param1Float);
    
    Integer zza(String param1String, Integer param1Integer);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\config\GservicesValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */