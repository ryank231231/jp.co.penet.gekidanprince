package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.GuardedBy;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzcl implements zzcp {
  @GuardedBy("ConfigurationContentLoader.class")
  static final Map<Uri, zzcl> zzzi = (Map<Uri, zzcl>)new ArrayMap();
  
  private static final String[] zzzn = new String[] { "key", "value" };
  
  private final Uri uri;
  
  private final ContentResolver zzzj;
  
  private final Object zzzk = new Object();
  
  private volatile Map<String, String> zzzl;
  
  @GuardedBy("this")
  private final List<zzco> zzzm = new ArrayList<zzco>();
  
  private zzcl(ContentResolver paramContentResolver, Uri paramUri) {
    this.zzzj = paramContentResolver;
    this.uri = paramUri;
    this.zzzj.registerContentObserver(paramUri, false, new zzcn(this, null));
  }
  
  public static zzcl zza(ContentResolver paramContentResolver, Uri paramUri) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/measurement/zzcl
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/internal/measurement/zzcl.zzzi : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/google/android/gms/internal/measurement/zzcl
    //   15: astore_2
    //   16: aload_2
    //   17: astore_3
    //   18: aload_2
    //   19: ifnonnull -> 47
    //   22: new com/google/android/gms/internal/measurement/zzcl
    //   25: astore_3
    //   26: aload_3
    //   27: aload_0
    //   28: aload_1
    //   29: invokespecial <init> : (Landroid/content/ContentResolver;Landroid/net/Uri;)V
    //   32: getstatic com/google/android/gms/internal/measurement/zzcl.zzzi : Ljava/util/Map;
    //   35: aload_1
    //   36: aload_3
    //   37: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: goto -> 47
    //   46: astore_0
    //   47: ldc com/google/android/gms/internal/measurement/zzcl
    //   49: monitorexit
    //   50: aload_3
    //   51: areturn
    //   52: astore_0
    //   53: ldc com/google/android/gms/internal/measurement/zzcl
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: aload_2
    //   60: astore_3
    //   61: goto -> 47
    // Exception table:
    //   from	to	target	type
    //   3	16	52	finally
    //   22	32	58	java/lang/SecurityException
    //   22	32	52	finally
    //   32	43	46	java/lang/SecurityException
    //   32	43	52	finally
    //   47	50	52	finally
    //   53	56	52	finally
  }
  
  private final Map<String, String> zzjl() {
    try {
      zzcm zzcm = new zzcm();
      this(this);
      return zzcq.<Map>zza(zzcm);
    } catch (SecurityException|android.database.sqlite.SQLiteException|IllegalStateException securityException) {
      Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
      return null;
    } 
  }
  
  public final Map<String, String> zzjj() {
    Map<String, String> map1 = this.zzzl;
    Map<String, String> map2 = map1;
    if (map1 == null)
      synchronized (this.zzzk) {
        map1 = this.zzzl;
        map2 = map1;
        if (map1 == null) {
          map2 = zzjl();
          this.zzzl = map2;
        } 
      }  
    return (map2 != null) ? map2 : Collections.emptyMap();
  }
  
  public final void zzjk() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzzk : Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield zzzl : Ljava/util/Map;
    //   12: invokestatic zzjp : ()V
    //   15: aload_1
    //   16: monitorexit
    //   17: aload_0
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield zzzm : Ljava/util/List;
    //   23: invokeinterface iterator : ()Ljava/util/Iterator;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface hasNext : ()Z
    //   35: ifeq -> 55
    //   38: aload_2
    //   39: invokeinterface next : ()Ljava/lang/Object;
    //   44: checkcast com/google/android/gms/internal/measurement/zzco
    //   47: invokeinterface zzjo : ()V
    //   52: goto -> 29
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    //   63: astore_2
    //   64: aload_1
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   7	17	63	finally
    //   19	29	58	finally
    //   29	52	58	finally
    //   55	57	58	finally
    //   59	61	58	finally
    //   64	66	63	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */