package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.GuardedBy;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class zzaw {
  private final SharedPreferences zzde;
  
  private final zzy zzdf;
  
  @GuardedBy("this")
  private final Map<String, zzz> zzdg = (Map<String, zzz>)new ArrayMap();
  
  private final Context zzz;
  
  public zzaw(Context paramContext) {
    this(paramContext, new zzy());
  }
  
  private zzaw(Context paramContext, zzy paramzzy) {
    this.zzz = paramContext;
    this.zzde = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    this.zzdf = paramzzy;
    File file = new File(ContextCompat.getNoBackupFilesDir(this.zzz), "com.google.android.gms.appid-no-backup");
    if (!file.exists())
      try {
        if (file.createNewFile() && !isEmpty()) {
          Log.i("FirebaseInstanceId", "App restored, clearing state");
          zzal();
          FirebaseInstanceId.getInstance().zzn();
        } 
        return;
      } catch (IOException iOException) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
          String str = String.valueOf(iOException.getMessage());
          if (str.length() != 0) {
            str = "Error creating file in no backup dir: ".concat(str);
          } else {
            str = new String("Error creating file in no backup dir: ");
          } 
          Log.d("FirebaseInstanceId", str);
        } 
      }  
  }
  
  private final boolean isEmpty() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzde : Landroid/content/SharedPreferences;
    //   6: invokeinterface getAll : ()Ljava/util/Map;
    //   11: invokeinterface isEmpty : ()Z
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: astore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_2
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	21	finally
  }
  
  private static String zza(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 4 + String.valueOf(paramString2).length() + String.valueOf(paramString3).length());
    stringBuilder.append(paramString1);
    stringBuilder.append("|T|");
    stringBuilder.append(paramString2);
    stringBuilder.append("|");
    stringBuilder.append(paramString3);
    return stringBuilder.toString();
  }
  
  static String zzd(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length());
    stringBuilder.append(paramString1);
    stringBuilder.append("|S|");
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  public final void zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload #4
    //   4: aload #5
    //   6: invokestatic currentTimeMillis : ()J
    //   9: invokestatic zza : (Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   12: astore #4
    //   14: aload #4
    //   16: ifnonnull -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield zzde : Landroid/content/SharedPreferences;
    //   26: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   31: astore #5
    //   33: aload #5
    //   35: aload_1
    //   36: aload_2
    //   37: aload_3
    //   38: invokestatic zza : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: aload #4
    //   43: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   48: pop
    //   49: aload #5
    //   51: invokeinterface commit : ()Z
    //   56: pop
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	60	finally
    //   22	57	60	finally
  }
  
  public final String zzak() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzde : Landroid/content/SharedPreferences;
    //   6: ldc 'topic_operaion_queue'
    //   8: ldc ''
    //   10: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	finally
  }
  
  public final void zzal() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzdg : Ljava/util/Map;
    //   6: invokeinterface clear : ()V
    //   11: aload_0
    //   12: getfield zzz : Landroid/content/Context;
    //   15: invokestatic zza : (Landroid/content/Context;)V
    //   18: aload_0
    //   19: getfield zzde : Landroid/content/SharedPreferences;
    //   22: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   27: invokeinterface clear : ()Landroid/content/SharedPreferences$Editor;
    //   32: invokeinterface commit : ()Z
    //   37: pop
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	38	41	finally
  }
  
  public final zzax zzb(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzde : Landroid/content/SharedPreferences;
    //   6: aload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokestatic zza : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12: aconst_null
    //   13: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic zzi : (Ljava/lang/String;)Lcom/google/firebase/iid/zzax;
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	26	finally
  }
  
  public final void zzc(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_2
    //   4: aload_3
    //   5: invokestatic zza : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_0
    //   10: getfield zzde : Landroid/content/SharedPreferences;
    //   13: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   18: astore_2
    //   19: aload_2
    //   20: aload_1
    //   21: invokeinterface remove : (Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   26: pop
    //   27: aload_2
    //   28: invokeinterface commit : ()Z
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	37	finally
  }
  
  public final void zzf(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzde : Landroid/content/SharedPreferences;
    //   6: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   11: ldc 'topic_operaion_queue'
    //   13: aload_1
    //   14: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   19: invokeinterface apply : ()V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  public final zzz zzg(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzdg : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/google/firebase/iid/zzz
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: aload_0
    //   25: getfield zzdf : Lcom/google/firebase/iid/zzy;
    //   28: aload_0
    //   29: getfield zzz : Landroid/content/Context;
    //   32: aload_1
    //   33: invokevirtual zzb : (Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/zzz;
    //   36: astore_2
    //   37: goto -> 68
    //   40: astore_2
    //   41: ldc 'FirebaseInstanceId'
    //   43: ldc 'Stored data is corrupt, generating new identity'
    //   45: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   48: pop
    //   49: invokestatic getInstance : ()Lcom/google/firebase/iid/FirebaseInstanceId;
    //   52: invokevirtual zzn : ()V
    //   55: aload_0
    //   56: getfield zzdf : Lcom/google/firebase/iid/zzy;
    //   59: aload_0
    //   60: getfield zzz : Landroid/content/Context;
    //   63: aload_1
    //   64: invokevirtual zzc : (Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/zzz;
    //   67: astore_2
    //   68: aload_0
    //   69: getfield zzdg : Ljava/util/Map;
    //   72: aload_1
    //   73: aload_2
    //   74: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	84	finally
    //   24	37	40	com/google/firebase/iid/zzaa
    //   24	37	84	finally
    //   41	68	84	finally
    //   68	80	84	finally
  }
  
  public final void zzh(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   6: ldc '|T|'
    //   8: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield zzde : Landroid/content/SharedPreferences;
    //   16: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   21: astore_2
    //   22: aload_0
    //   23: getfield zzde : Landroid/content/SharedPreferences;
    //   26: invokeinterface getAll : ()Ljava/util/Map;
    //   31: invokeinterface keySet : ()Ljava/util/Set;
    //   36: invokeinterface iterator : ()Ljava/util/Iterator;
    //   41: astore_3
    //   42: aload_3
    //   43: invokeinterface hasNext : ()Z
    //   48: ifeq -> 83
    //   51: aload_3
    //   52: invokeinterface next : ()Ljava/lang/Object;
    //   57: checkcast java/lang/String
    //   60: astore #4
    //   62: aload #4
    //   64: aload_1
    //   65: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   68: ifeq -> 42
    //   71: aload_2
    //   72: aload #4
    //   74: invokeinterface remove : (Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   79: pop
    //   80: goto -> 42
    //   83: aload_2
    //   84: invokeinterface commit : ()Z
    //   89: pop
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	93	finally
    //   42	80	93	finally
    //   83	90	93	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */