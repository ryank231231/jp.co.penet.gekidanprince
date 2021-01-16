package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzy {
  private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  
  private static final Uri zzcq = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  
  public static final Pattern zzcr = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  
  public static final Pattern zzcs = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  
  private static final AtomicBoolean zzct = new AtomicBoolean();
  
  private static HashMap<String, String> zzcu;
  
  private static final HashMap<String, Boolean> zzcv = new HashMap<String, Boolean>();
  
  private static final HashMap<String, Integer> zzcw = new HashMap<String, Integer>();
  
  private static final HashMap<String, Long> zzcx = new HashMap<String, Long>();
  
  private static final HashMap<String, Float> zzcy = new HashMap<String, Float>();
  
  private static Object zzcz;
  
  private static boolean zzda;
  
  private static String[] zzdb = new String[0];
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong) {
    Long long_1;
    Object object = zzb(paramContentResolver);
    HashMap<String, Long> hashMap = zzcx;
    paramLong = 0L;
    Long long_2 = zza(hashMap, paramString, Long.valueOf(0L));
    if (long_2 != null)
      return long_2.longValue(); 
    String str = zza(paramContentResolver, paramString, (String)null);
    if (str == null) {
      long_1 = long_2;
    } else {
      try {
        long l = Long.parseLong((String)long_1);
        long_1 = Long.valueOf(l);
        paramLong = l;
      } catch (NumberFormatException numberFormatException) {
        long_1 = long_2;
      } 
    } 
    zza(object, zzcx, paramString, long_1);
    return paramLong;
  }
  
  private static <T> T zza(HashMap<String, T> paramHashMap, String paramString, T paramT) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/clearcut/zzy
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   8: ifeq -> 31
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull -> 24
    //   21: goto -> 26
    //   24: aload_2
    //   25: astore_0
    //   26: ldc com/google/android/gms/internal/clearcut/zzy
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: ldc com/google/android/gms/internal/clearcut/zzy
    //   33: monitorexit
    //   34: aconst_null
    //   35: areturn
    //   36: astore_0
    //   37: ldc com/google/android/gms/internal/clearcut/zzy
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	36	finally
    //   26	29	36	finally
    //   31	34	36	finally
    //   37	40	36	finally
  }
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/clearcut/zzy
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic zza : (Landroid/content/ContentResolver;)V
    //   7: getstatic com/google/android/gms/internal/clearcut/zzy.zzcz : Ljava/lang/Object;
    //   10: astore_3
    //   11: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   14: aload_1
    //   15: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   18: ifeq -> 46
    //   21: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   24: aload_1
    //   25: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast java/lang/String
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull -> 39
    //   36: goto -> 41
    //   39: aconst_null
    //   40: astore_0
    //   41: ldc com/google/android/gms/internal/clearcut/zzy
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: getstatic com/google/android/gms/internal/clearcut/zzy.zzdb : [Ljava/lang/String;
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
    //   75: getstatic com/google/android/gms/internal/clearcut/zzy.zzda : Z
    //   78: ifeq -> 90
    //   81: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   84: invokevirtual isEmpty : ()Z
    //   87: ifeq -> 144
    //   90: getstatic com/google/android/gms/internal/clearcut/zzy.zzdb : [Ljava/lang/String;
    //   93: astore_2
    //   94: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   97: aload_0
    //   98: aload_2
    //   99: invokestatic zza : (Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   102: invokevirtual putAll : (Ljava/util/Map;)V
    //   105: iconst_1
    //   106: putstatic com/google/android/gms/internal/clearcut/zzy.zzda : Z
    //   109: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   112: aload_1
    //   113: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   116: ifeq -> 144
    //   119: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   122: aload_1
    //   123: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast java/lang/String
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull -> 137
    //   134: goto -> 139
    //   137: aconst_null
    //   138: astore_0
    //   139: ldc com/google/android/gms/internal/clearcut/zzy
    //   141: monitorexit
    //   142: aload_0
    //   143: areturn
    //   144: ldc com/google/android/gms/internal/clearcut/zzy
    //   146: monitorexit
    //   147: aconst_null
    //   148: areturn
    //   149: iinc #5, 1
    //   152: goto -> 57
    //   155: ldc com/google/android/gms/internal/clearcut/zzy
    //   157: monitorexit
    //   158: aload_0
    //   159: getstatic com/google/android/gms/internal/clearcut/zzy.CONTENT_URI : Landroid/net/Uri;
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
    //   180: ifnull -> 252
    //   183: aload #6
    //   185: invokeinterface moveToFirst : ()Z
    //   190: ifne -> 196
    //   193: goto -> 252
    //   196: aload #6
    //   198: iconst_1
    //   199: invokeinterface getString : (I)Ljava/lang/String;
    //   204: astore_2
    //   205: aload_2
    //   206: astore_0
    //   207: aload_2
    //   208: ifnull -> 223
    //   211: aload_2
    //   212: astore_0
    //   213: aload_2
    //   214: aconst_null
    //   215: invokevirtual equals : (Ljava/lang/Object;)Z
    //   218: ifeq -> 223
    //   221: aconst_null
    //   222: astore_0
    //   223: aload_3
    //   224: aload_1
    //   225: aload_0
    //   226: invokestatic zza : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_0
    //   230: ifnull -> 236
    //   233: goto -> 238
    //   236: aconst_null
    //   237: astore_0
    //   238: aload #6
    //   240: ifnull -> 250
    //   243: aload #6
    //   245: invokeinterface close : ()V
    //   250: aload_0
    //   251: areturn
    //   252: aload_3
    //   253: aload_1
    //   254: aconst_null
    //   255: invokestatic zza : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload #6
    //   260: ifnull -> 270
    //   263: aload #6
    //   265: invokeinterface close : ()V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_0
    //   273: aload #6
    //   275: ifnull -> 285
    //   278: aload #6
    //   280: invokeinterface close : ()V
    //   285: aload_0
    //   286: athrow
    //   287: astore_0
    //   288: ldc com/google/android/gms/internal/clearcut/zzy
    //   290: monitorexit
    //   291: aload_0
    //   292: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	287	finally
    //   41	44	287	finally
    //   46	54	287	finally
    //   64	90	287	finally
    //   90	130	287	finally
    //   139	142	287	finally
    //   144	147	287	finally
    //   155	158	287	finally
    //   183	193	272	finally
    //   196	205	272	finally
    //   213	221	272	finally
    //   223	229	272	finally
    //   252	258	272	finally
    //   288	291	287	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs) {
    Cursor cursor = paramContentResolver.query(zzcq, null, null, paramVarArgs, null);
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
    if (zzcu == null) {
      zzct.set(false);
      zzcu = new HashMap<String, String>();
      zzcz = new Object();
      zzda = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzz(null));
      return;
    } 
    if (zzct.getAndSet(false)) {
      zzcu.clear();
      zzcv.clear();
      zzcw.clear();
      zzcx.clear();
      zzcy.clear();
      zzcz = new Object();
      zzda = false;
    } 
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/clearcut/zzy
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic com/google/android/gms/internal/clearcut/zzy.zzcz : Ljava/lang/Object;
    //   7: if_acmpne -> 19
    //   10: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: pop
    //   19: ldc com/google/android/gms/internal/clearcut/zzy
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/google/android/gms/internal/clearcut/zzy
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
    //   19	22	23	finally
    //   24	27	23	finally
  }
  
  private static <T> void zza(Object paramObject, HashMap<String, T> paramHashMap, String paramString, T paramT) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/clearcut/zzy
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic com/google/android/gms/internal/clearcut/zzy.zzcz : Ljava/lang/Object;
    //   7: if_acmpne -> 25
    //   10: aload_1
    //   11: aload_2
    //   12: aload_3
    //   13: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: getstatic com/google/android/gms/internal/clearcut/zzy.zzcu : Ljava/util/HashMap;
    //   20: aload_2
    //   21: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: pop
    //   25: ldc com/google/android/gms/internal/clearcut/zzy
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: ldc com/google/android/gms/internal/clearcut/zzy
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	29	finally
    //   25	28	29	finally
    //   30	33	29	finally
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean) {
    Object object = zzb(paramContentResolver);
    Boolean bool2 = zza(zzcv, paramString, Boolean.valueOf(paramBoolean));
    if (bool2 != null)
      return bool2.booleanValue(); 
    String str = zza(paramContentResolver, paramString, (String)null);
    Boolean bool1 = bool2;
    boolean bool = paramBoolean;
    if (str != null)
      if (str.equals("")) {
        bool1 = bool2;
        bool = paramBoolean;
      } else if (zzcr.matcher(str).matches()) {
        bool1 = Boolean.valueOf(true);
        bool = true;
      } else if (zzcs.matcher(str).matches()) {
        bool1 = Boolean.valueOf(false);
        bool = false;
      } else {
        StringBuilder stringBuilder = new StringBuilder("attempt to read gservices key ");
        stringBuilder.append(paramString);
        stringBuilder.append(" (value \"");
        stringBuilder.append(str);
        stringBuilder.append("\") as boolean");
        Log.w("Gservices", stringBuilder.toString());
        bool = paramBoolean;
        bool1 = bool2;
      }  
    zza(object, zzcv, paramString, bool1);
    return bool;
  }
  
  private static Object zzb(ContentResolver paramContentResolver) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/clearcut/zzy
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic zza : (Landroid/content/ContentResolver;)V
    //   7: getstatic com/google/android/gms/internal/clearcut/zzy.zzcz : Ljava/lang/Object;
    //   10: astore_0
    //   11: ldc com/google/android/gms/internal/clearcut/zzy
    //   13: monitorexit
    //   14: aload_0
    //   15: areturn
    //   16: astore_0
    //   17: ldc com/google/android/gms/internal/clearcut/zzy
    //   19: monitorexit
    //   20: aload_0
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	16	finally
    //   17	20	16	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */