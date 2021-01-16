package com.google.android.gms.internal.phenotype;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzf {
  private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  
  private static final Uri zzbe = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  
  private static final Pattern zzbf = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  
  private static final Pattern zzbg = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  
  private static final AtomicBoolean zzbh = new AtomicBoolean();
  
  private static HashMap<String, String> zzbi;
  
  private static final HashMap<String, Boolean> zzbj = new HashMap<String, Boolean>();
  
  private static final HashMap<String, Integer> zzbk = new HashMap<String, Integer>();
  
  private static final HashMap<String, Long> zzbl = new HashMap<String, Long>();
  
  private static final HashMap<String, Float> zzbm = new HashMap<String, Float>();
  
  private static Object zzbn;
  
  private static boolean zzbo;
  
  private static String[] zzbp = new String[0];
  
  private static <T> T zza(HashMap<String, T> paramHashMap, String paramString, T paramT) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/phenotype/zzf
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
    //   18: ifnull -> 26
    //   21: aload_0
    //   22: astore_2
    //   23: goto -> 26
    //   26: ldc com/google/android/gms/internal/phenotype/zzf
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: ldc com/google/android/gms/internal/phenotype/zzf
    //   33: monitorexit
    //   34: aconst_null
    //   35: areturn
    //   36: astore_0
    //   37: ldc com/google/android/gms/internal/phenotype/zzf
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
    //   0: ldc com/google/android/gms/internal/phenotype/zzf
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic zza : (Landroid/content/ContentResolver;)V
    //   7: getstatic com/google/android/gms/internal/phenotype/zzf.zzbn : Ljava/lang/Object;
    //   10: astore_3
    //   11: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   14: aload_1
    //   15: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   18: ifeq -> 46
    //   21: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   24: aload_1
    //   25: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast java/lang/String
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull -> 39
    //   36: goto -> 41
    //   39: aconst_null
    //   40: astore_0
    //   41: ldc com/google/android/gms/internal/phenotype/zzf
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: getstatic com/google/android/gms/internal/phenotype/zzf.zzbp : [Ljava/lang/String;
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
    //   75: getstatic com/google/android/gms/internal/phenotype/zzf.zzbo : Z
    //   78: ifeq -> 90
    //   81: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   84: invokevirtual isEmpty : ()Z
    //   87: ifeq -> 144
    //   90: getstatic com/google/android/gms/internal/phenotype/zzf.zzbp : [Ljava/lang/String;
    //   93: astore_2
    //   94: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   97: aload_0
    //   98: aload_2
    //   99: invokestatic zza : (Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   102: invokevirtual putAll : (Ljava/util/Map;)V
    //   105: iconst_1
    //   106: putstatic com/google/android/gms/internal/phenotype/zzf.zzbo : Z
    //   109: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   112: aload_1
    //   113: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   116: ifeq -> 144
    //   119: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   122: aload_1
    //   123: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast java/lang/String
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull -> 137
    //   134: goto -> 139
    //   137: aconst_null
    //   138: astore_0
    //   139: ldc com/google/android/gms/internal/phenotype/zzf
    //   141: monitorexit
    //   142: aload_0
    //   143: areturn
    //   144: ldc com/google/android/gms/internal/phenotype/zzf
    //   146: monitorexit
    //   147: aconst_null
    //   148: areturn
    //   149: iinc #5, 1
    //   152: goto -> 57
    //   155: ldc com/google/android/gms/internal/phenotype/zzf
    //   157: monitorexit
    //   158: aload_0
    //   159: getstatic com/google/android/gms/internal/phenotype/zzf.CONTENT_URI : Landroid/net/Uri;
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
    //   288: ldc com/google/android/gms/internal/phenotype/zzf
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
    Cursor cursor = paramContentResolver.query(zzbe, null, null, paramVarArgs, null);
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
    if (zzbi == null) {
      zzbh.set(false);
      zzbi = new HashMap<String, String>();
      zzbn = new Object();
      zzbo = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzg(null));
      return;
    } 
    if (zzbh.getAndSet(false)) {
      zzbi.clear();
      zzbj.clear();
      zzbk.clear();
      zzbl.clear();
      zzbm.clear();
      zzbn = new Object();
      zzbo = false;
    } 
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/phenotype/zzf
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic com/google/android/gms/internal/phenotype/zzf.zzbn : Ljava/lang/Object;
    //   7: if_acmpne -> 19
    //   10: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: pop
    //   19: ldc com/google/android/gms/internal/phenotype/zzf
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/google/android/gms/internal/phenotype/zzf
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
    //   19	22	23	finally
    //   24	27	23	finally
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic zzb : (Landroid/content/ContentResolver;)Ljava/lang/Object;
    //   4: astore_3
    //   5: getstatic com/google/android/gms/internal/phenotype/zzf.zzbj : Ljava/util/HashMap;
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   13: invokestatic zza : (Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast java/lang/Boolean
    //   19: astore #4
    //   21: aload #4
    //   23: ifnull -> 32
    //   26: aload #4
    //   28: invokevirtual booleanValue : ()Z
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: aconst_null
    //   35: invokestatic zza : (Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore #5
    //   40: aload #4
    //   42: astore_0
    //   43: iload_2
    //   44: istore #6
    //   46: aload #5
    //   48: ifnull -> 173
    //   51: aload #5
    //   53: ldc ''
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 70
    //   61: aload #4
    //   63: astore_0
    //   64: iload_2
    //   65: istore #6
    //   67: goto -> 173
    //   70: getstatic com/google/android/gms/internal/phenotype/zzf.zzbf : Ljava/util/regex/Pattern;
    //   73: aload #5
    //   75: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   78: invokevirtual matches : ()Z
    //   81: ifeq -> 95
    //   84: iconst_1
    //   85: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   88: astore_0
    //   89: iconst_1
    //   90: istore #6
    //   92: goto -> 173
    //   95: getstatic com/google/android/gms/internal/phenotype/zzf.zzbg : Ljava/util/regex/Pattern;
    //   98: aload #5
    //   100: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   103: invokevirtual matches : ()Z
    //   106: ifeq -> 120
    //   109: iconst_0
    //   110: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   113: astore_0
    //   114: iconst_0
    //   115: istore #6
    //   117: goto -> 173
    //   120: new java/lang/StringBuilder
    //   123: dup
    //   124: ldc 'attempt to read gservices key '
    //   126: invokespecial <init> : (Ljava/lang/String;)V
    //   129: astore_0
    //   130: aload_0
    //   131: aload_1
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_0
    //   137: ldc ' (value "'
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_0
    //   144: aload #5
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_0
    //   151: ldc '") as boolean'
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 'Gservices'
    //   159: aload_0
    //   160: invokevirtual toString : ()Ljava/lang/String;
    //   163: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: iload_2
    //   168: istore #6
    //   170: aload #4
    //   172: astore_0
    //   173: getstatic com/google/android/gms/internal/phenotype/zzf.zzbj : Ljava/util/HashMap;
    //   176: astore #4
    //   178: ldc com/google/android/gms/internal/phenotype/zzf
    //   180: monitorenter
    //   181: aload_3
    //   182: getstatic com/google/android/gms/internal/phenotype/zzf.zzbn : Ljava/lang/Object;
    //   185: if_acmpne -> 204
    //   188: aload #4
    //   190: aload_1
    //   191: aload_0
    //   192: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: pop
    //   196: getstatic com/google/android/gms/internal/phenotype/zzf.zzbi : Ljava/util/HashMap;
    //   199: aload_1
    //   200: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: ldc com/google/android/gms/internal/phenotype/zzf
    //   206: monitorexit
    //   207: iload #6
    //   209: ireturn
    //   210: astore_0
    //   211: ldc com/google/android/gms/internal/phenotype/zzf
    //   213: monitorexit
    //   214: aload_0
    //   215: athrow
    // Exception table:
    //   from	to	target	type
    //   181	204	210	finally
    //   204	207	210	finally
    //   211	214	210	finally
  }
  
  private static Object zzb(ContentResolver paramContentResolver) {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/phenotype/zzf
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic zza : (Landroid/content/ContentResolver;)V
    //   7: getstatic com/google/android/gms/internal/phenotype/zzf.zzbn : Ljava/lang/Object;
    //   10: astore_0
    //   11: ldc com/google/android/gms/internal/phenotype/zzf
    //   13: monitorexit
    //   14: aload_0
    //   15: areturn
    //   16: astore_0
    //   17: ldc com/google/android/gms/internal/phenotype/zzf
    //   19: monitorexit
    //   20: aload_0
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	16	finally
    //   17	20	16	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\phenotype\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */