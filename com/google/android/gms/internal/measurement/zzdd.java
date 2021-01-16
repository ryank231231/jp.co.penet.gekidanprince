package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzdd implements zzcp {
  @GuardedBy("SharedPreferencesLoader.class")
  static final Map<String, zzdd> zzaai = new HashMap<String, zzdd>();
  
  private final SharedPreferences zzaaj;
  
  private final SharedPreferences.OnSharedPreferenceChangeListener zzaak = new zzde(this);
  
  private final Object zzzk = new Object();
  
  private volatile Map<String, ?> zzzl;
  
  @GuardedBy("this")
  private final List<zzco> zzzm = new ArrayList<zzco>();
  
  private zzdd(SharedPreferences paramSharedPreferences) {
    this.zzaaj = paramSharedPreferences;
    this.zzaaj.registerOnSharedPreferenceChangeListener(this.zzaak);
  }
  
  static zzdd zze(Context paramContext, String paramString) {
    // Byte code:
    //   0: invokestatic zzji : ()Z
    //   3: ifeq -> 23
    //   6: aload_1
    //   7: ldc 'direct_boot:'
    //   9: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   12: ifne -> 23
    //   15: aload_0
    //   16: invokestatic isUserUnlocked : (Landroid/content/Context;)Z
    //   19: istore_2
    //   20: goto -> 25
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: ifne -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: ldc com/google/android/gms/internal/measurement/zzdd
    //   33: monitorenter
    //   34: getstatic com/google/android/gms/internal/measurement/zzdd.zzaai : Ljava/util/Map;
    //   37: aload_1
    //   38: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast com/google/android/gms/internal/measurement/zzdd
    //   46: astore_3
    //   47: aload_3
    //   48: astore #4
    //   50: aload_3
    //   51: ifnonnull -> 124
    //   54: new com/google/android/gms/internal/measurement/zzdd
    //   57: astore_3
    //   58: aload_1
    //   59: ldc 'direct_boot:'
    //   61: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   64: ifeq -> 98
    //   67: aload_0
    //   68: astore #4
    //   70: invokestatic zzji : ()Z
    //   73: ifeq -> 82
    //   76: aload_0
    //   77: invokevirtual createDeviceProtectedStorageContext : ()Landroid/content/Context;
    //   80: astore #4
    //   82: aload #4
    //   84: aload_1
    //   85: bipush #12
    //   87: invokevirtual substring : (I)Ljava/lang/String;
    //   90: iconst_0
    //   91: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   94: astore_0
    //   95: goto -> 105
    //   98: aload_0
    //   99: aload_1
    //   100: iconst_0
    //   101: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   104: astore_0
    //   105: aload_3
    //   106: aload_0
    //   107: invokespecial <init> : (Landroid/content/SharedPreferences;)V
    //   110: getstatic com/google/android/gms/internal/measurement/zzdd.zzaai : Ljava/util/Map;
    //   113: aload_1
    //   114: aload_3
    //   115: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload_3
    //   122: astore #4
    //   124: ldc com/google/android/gms/internal/measurement/zzdd
    //   126: monitorexit
    //   127: aload #4
    //   129: areturn
    //   130: astore_0
    //   131: ldc com/google/android/gms/internal/measurement/zzdd
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   34	47	130	finally
    //   54	67	130	finally
    //   70	82	130	finally
    //   82	95	130	finally
    //   98	105	130	finally
    //   105	121	130	finally
    //   124	127	130	finally
    //   131	134	130	finally
  }
  
  public final Object zzca(String paramString) {
    Map<String, ?> map1 = this.zzzl;
    Map<String, ?> map2 = map1;
    if (map1 == null)
      synchronized (this.zzzk) {
        map1 = this.zzzl;
        map2 = map1;
        if (map1 == null) {
          map2 = this.zzaaj.getAll();
          this.zzzl = map2;
        } 
      }  
    return (map2 != null) ? map2.get(paramString) : null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */