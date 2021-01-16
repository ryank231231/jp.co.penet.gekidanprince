package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzci {
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  
  private static final Uri zzyu = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  
  public static final Pattern zzyv = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  
  public static final Pattern zzyw = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  
  private static final AtomicBoolean zzyx = new AtomicBoolean();
  
  private static HashMap<String, String> zzyy;
  
  private static final HashMap<String, Boolean> zzyz = new HashMap<String, Boolean>();
  
  private static final HashMap<String, Integer> zzza = new HashMap<String, Integer>();
  
  private static final HashMap<String, Long> zzzb = new HashMap<String, Long>();
  
  private static final HashMap<String, Float> zzzc = new HashMap<String, Float>();
  
  private static Object zzzd;
  
  private static boolean zzze;
  
  private static String[] zzzf = new String[0];
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/measurement/zzci
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic zza : (Landroid/content/ContentResolver;)V
    //   7: getstatic com/google/android/gms/internal/measurement/zzci.zzzd : Ljava/lang/Object;
    //   10: astore_3
    //   11: getstatic com/google/android/gms/internal/measurement/zzci.zzyy : Ljava/util/HashMap;
    //   14: aload_1
    //   15: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   18: ifeq -> 46
    //   21: getstatic com/google/android/gms/internal/measurement/zzci.zzyy : Ljava/util/HashMap;
    //   24: aload_1
    //   25: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast java/lang/String
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull -> 39
    //   36: goto -> 41
    //   39: aconst_null
    //   40: astore_0
    //   41: ldc com/google/android/gms/internal/measurement/zzci
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: getstatic com/google/android/gms/internal/measurement/zzci.zzzf : [Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: arraylength
    //   52: istore #4
    //   54: iconst_0
    //   55: istore #5
    //   57: iload #5
    //   59: iload #4
    //   61: if_icmpge -> 155
    //   64: aload_1
    //   65: aload_2
    //   66: iload #5
    //   68: aaload
    //   69: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   72: ifeq -> 149
    //   75: getstatic com/google/android/gms/internal/measurement/zzci.zzze : Z
    //   78: ifeq -> 90
    //   81: getstatic com/google/android/gms/internal/measurement/zzci.zzyy : Ljava/util/HashMap;
    //   84: invokevirtual isEmpty : ()Z
    //   87: ifeq -> 144
    //   90: getstatic com/google/android/gms/internal/measurement/zzci.zzzf : [Ljava/lang/String;
    //   93: astore_2
    //   94: getstatic com/google/android/gms/internal/measurement/zzci.zzyy : Ljava/util/HashMap;
    //   97: aload_0
    //   98: aload_2
    //   99: invokestatic zza : (Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   102: invokevirtual putAll : (Ljava/util/Map;)V
    //   105: iconst_1
    //   106: putstatic com/google/android/gms/internal/measurement/zzci.zzze : Z
    //   109: getstatic com/google/android/gms/internal/measurement/zzci.zzyy : Ljava/util/HashMap;
    //   112: aload_1
    //   113: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   116: ifeq -> 144
    //   119: getstatic com/google/android/gms/internal/measurement/zzci.zzyy : Ljava/util/HashMap;
    //   122: aload_1
    //   123: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast java/lang/String
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull -> 137
    //   134: goto -> 139
    //   137: aconst_null
    //   138: astore_0
    //   139: ldc com/google/android/gms/internal/measurement/zzci
    //   141: monitorexit
    //   142: aload_0
    //   143: areturn
    //   144: ldc com/google/android/gms/internal/measurement/zzci
    //   146: monitorexit
    //   147: aconst_null
    //   148: areturn
    //   149: iinc #5, 1
    //   152: goto -> 57
    //   155: ldc com/google/android/gms/internal/measurement/zzci
    //   157: monitorexit
    //   158: aload_0
    //   159: getstatic com/google/android/gms/internal/measurement/zzci.CONTENT_URI : Landroid/net/Uri;
    //   162: aconst_null
    //   163: aconst_null
    //   164: iconst_1
    //   165: anewarray java/lang/String
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: aastore
    //   172: aconst_null
    //   173: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   176: astore #6
    //   178: aload #6
    //   180: ifnonnull -> 197
    //   183: aload #6
    //   185: ifnull -> 195
    //   188: aload #6
    //   190: invokeinterface close : ()V
    //   195: aconst_null
    //   196: areturn
    //   197: aload #6
    //   199: invokeinterface moveToFirst : ()Z
    //   204: ifne -> 227
    //   207: aload_3
    //   208: aload_1
    //   209: aconst_null
    //   210: invokestatic zza : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload #6
    //   215: ifnull -> 225
    //   218: aload #6
    //   220: invokeinterface close : ()V
    //   225: aconst_null
    //   226: areturn
    //   227: aload #6
    //   229: iconst_1
    //   230: invokeinterface getString : (I)Ljava/lang/String;
    //   235: astore_2
    //   236: aload_2
    //   237: astore_0
    //   238: aload_2
    //   239: ifnull -> 254
    //   242: aload_2
    //   243: astore_0
    //   244: aload_2
    //   245: aconst_null
    //   246: invokevirtual equals : (Ljava/lang/Object;)Z
    //   249: ifeq -> 254
    //   252: aconst_null
    //   253: astore_0
    //   254: aload_3
    //   255: aload_1
    //   256: aload_0
    //   257: invokestatic zza : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_0
    //   261: ifnull -> 267
    //   264: goto -> 269
    //   267: aconst_null
    //   268: astore_0
    //   269: aload #6
    //   271: ifnull -> 281
    //   274: aload #6
    //   276: invokeinterface close : ()V
    //   281: aload_0
    //   282: areturn
    //   283: astore_0
    //   284: aload #6
    //   286: ifnull -> 296
    //   289: aload #6
    //   291: invokeinterface close : ()V
    //   296: aload_0
    //   297: athrow
    //   298: astore_0
    //   299: ldc com/google/android/gms/internal/measurement/zzci
    //   301: monitorexit
    //   302: aload_0
    //   303: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	298	finally
    //   41	44	298	finally
    //   46	54	298	finally
    //   64	90	298	finally
    //   90	130	298	finally
    //   139	142	298	finally
    //   144	147	298	finally
    //   155	158	298	finally
    //   197	213	283	finally
    //   227	236	283	finally
    //   244	252	283	finally
    //   254	260	283	finally
    //   299	302	298	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs) {
    Cursor cursor = paramContentResolver.query(zzyu, null, null, paramVarArgs, null);
    null = new TreeMap<Object, Object>();
    if (cursor == null)
      return (Map)null; 
    try {
      while (cursor.moveToNext())
        null.put(cursor.getString(0), cursor.getString(1)); 
      return (Map)null;
    } finally {
      cursor.close();
    } 
  }
  
  private static void zza(ContentResolver paramContentResolver) {
    if (zzyy == null) {
      zzyx.set(false);
      zzyy = new HashMap<String, String>();
      zzzd = new Object();
      zzze = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzcj(null));
      return;
    } 
    if (zzyx.getAndSet(false)) {
      zzyy.clear();
      zzyz.clear();
      zzza.clear();
      zzzb.clear();
      zzzc.clear();
      zzzd = new Object();
      zzze = false;
    } 
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/measurement/zzci
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic com/google/android/gms/internal/measurement/zzci.zzzd : Ljava/lang/Object;
    //   7: if_acmpne -> 19
    //   10: getstatic com/google/android/gms/internal/measurement/zzci.zzyy : Ljava/util/HashMap;
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: pop
    //   19: ldc com/google/android/gms/internal/measurement/zzci
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/google/android/gms/internal/measurement/zzci
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
    //   19	22	23	finally
    //   24	27	23	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */