package com.google.firebase.iid;

import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

final class zzba {
  @GuardedBy("itself")
  private final zzaw zzal;
  
  @GuardedBy("this")
  private int zzdn = 0;
  
  @GuardedBy("this")
  private final Map<Integer, TaskCompletionSource<Void>> zzdo = (Map<Integer, TaskCompletionSource<Void>>)new ArrayMap();
  
  zzba(zzaw paramzzaw) {
    this.zzal = paramzzaw;
  }
  
  @WorkerThread
  private static boolean zza(FirebaseInstanceId paramFirebaseInstanceId, String paramString) {
    String[] arrayOfString = paramString.split("!");
    if (arrayOfString.length == 2) {
      paramString = arrayOfString[0];
      String str = arrayOfString[1];
      byte b = -1;
      try {
        int i = paramString.hashCode();
        if (i != 83) {
          if (i == 85 && paramString.equals("U"))
            b = 1; 
        } else if (paramString.equals("S")) {
          b = 0;
        } 
        switch (b) {
          default:
            return true;
          case 1:
            paramFirebaseInstanceId.zzc(str);
            if (FirebaseInstanceId.zzm())
              Log.d("FirebaseInstanceId", "unsubscribe operation succeeded"); 
          case 0:
            break;
        } 
        paramFirebaseInstanceId.zzb(str);
        if (FirebaseInstanceId.zzm())
          Log.d("FirebaseInstanceId", "subscribe operation succeeded"); 
      } catch (IOException iOException) {
        String str1 = String.valueOf(iOException.getMessage());
        if (str1.length() != 0) {
          str1 = "Topic sync failed: ".concat(str1);
        } else {
          str1 = new String("Topic sync failed: ");
        } 
        Log.e("FirebaseInstanceId", str1);
        return false;
      } 
    } 
  }
  
  @GuardedBy("this")
  @Nullable
  private final String zzaq() {
    zzaw zzaw1;
    String[] arrayOfString;
    synchronized (this.zzal) {
      String str = this.zzal.zzak();
      if (!TextUtils.isEmpty(str)) {
        arrayOfString = str.split(",");
        if (arrayOfString.length > 1 && !TextUtils.isEmpty(arrayOfString[1]))
          return arrayOfString[1]; 
      } 
      return null;
    } 
  }
  
  private final boolean zzk(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzal : Lcom/google/firebase/iid/zzaw;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzal : Lcom/google/firebase/iid/zzaw;
    //   13: invokevirtual zzak : ()Ljava/lang/String;
    //   16: astore_3
    //   17: ldc ','
    //   19: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore #4
    //   24: aload_1
    //   25: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   28: astore #5
    //   30: aload #5
    //   32: invokevirtual length : ()I
    //   35: ifeq -> 50
    //   38: aload #4
    //   40: aload #5
    //   42: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   45: astore #5
    //   47: goto -> 61
    //   50: new java/lang/String
    //   53: dup
    //   54: aload #4
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: astore #5
    //   61: aload_3
    //   62: aload #5
    //   64: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   67: ifeq -> 132
    //   70: ldc ','
    //   72: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   75: astore #5
    //   77: aload_1
    //   78: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual length : ()I
    //   86: ifeq -> 99
    //   89: aload #5
    //   91: aload_1
    //   92: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_1
    //   96: goto -> 109
    //   99: new java/lang/String
    //   102: dup
    //   103: aload #5
    //   105: invokespecial <init> : (Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual length : ()I
    //   114: invokevirtual substring : (I)Ljava/lang/String;
    //   117: astore_1
    //   118: aload_0
    //   119: getfield zzal : Lcom/google/firebase/iid/zzaw;
    //   122: aload_1
    //   123: invokevirtual zzf : (Ljava/lang/String;)V
    //   126: aload_2
    //   127: monitorexit
    //   128: aload_0
    //   129: monitorexit
    //   130: iconst_1
    //   131: ireturn
    //   132: aload_2
    //   133: monitorexit
    //   134: aload_0
    //   135: monitorexit
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	143	finally
    //   9	47	138	finally
    //   50	61	138	finally
    //   61	96	138	finally
    //   99	109	138	finally
    //   109	128	138	finally
    //   132	134	138	finally
    //   139	141	138	finally
    //   141	143	143	finally
  }
  
  final Task<Void> zza(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzal : Lcom/google/firebase/iid/zzaw;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzal : Lcom/google/firebase/iid/zzaw;
    //   13: invokevirtual zzak : ()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_0
    //   18: getfield zzal : Lcom/google/firebase/iid/zzaw;
    //   21: astore #4
    //   23: aload_3
    //   24: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokevirtual length : ()I
    //   30: istore #5
    //   32: aload_1
    //   33: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual length : ()I
    //   39: istore #6
    //   41: new java/lang/StringBuilder
    //   44: astore #7
    //   46: aload #7
    //   48: iload #5
    //   50: iconst_1
    //   51: iadd
    //   52: iload #6
    //   54: iadd
    //   55: invokespecial <init> : (I)V
    //   58: aload #7
    //   60: aload_3
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #7
    //   67: ldc ','
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #7
    //   75: aload_1
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #4
    //   82: aload #7
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokevirtual zzf : (Ljava/lang/String;)V
    //   90: aload_2
    //   91: monitorexit
    //   92: new com/google/android/gms/tasks/TaskCompletionSource
    //   95: astore_1
    //   96: aload_1
    //   97: invokespecial <init> : ()V
    //   100: aload_0
    //   101: getfield zzdo : Ljava/util/Map;
    //   104: astore_2
    //   105: aload_3
    //   106: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   109: ifeq -> 118
    //   112: iconst_0
    //   113: istore #6
    //   115: goto -> 129
    //   118: aload_3
    //   119: ldc ','
    //   121: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   124: arraylength
    //   125: iconst_1
    //   126: isub
    //   127: istore #6
    //   129: aload_2
    //   130: aload_0
    //   131: getfield zzdn : I
    //   134: iload #6
    //   136: iadd
    //   137: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   140: aload_1
    //   141: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: aload_1
    //   148: invokevirtual getTask : ()Lcom/google/android/gms/tasks/Task;
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: areturn
    //   156: astore_1
    //   157: aload_2
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	161	finally
    //   9	92	156	finally
    //   92	112	161	finally
    //   118	129	161	finally
    //   129	152	161	finally
    //   157	159	156	finally
    //   159	161	161	finally
  }
  
  final boolean zzap() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial zzaq : ()Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  @WorkerThread
  final boolean zzc(FirebaseInstanceId paramFirebaseInstanceId) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial zzaq : ()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull -> 29
    //   11: invokestatic zzm : ()Z
    //   14: ifeq -> 25
    //   17: ldc 'FirebaseInstanceId'
    //   19: ldc 'topic sync succeeded'
    //   21: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: iconst_1
    //   28: ireturn
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: aload_2
    //   33: invokestatic zza : (Lcom/google/firebase/iid/FirebaseInstanceId;Ljava/lang/String;)Z
    //   36: ifne -> 41
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_0
    //   44: getfield zzdo : Ljava/util/Map;
    //   47: aload_0
    //   48: getfield zzdn : I
    //   51: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   54: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast com/google/android/gms/tasks/TaskCompletionSource
    //   62: astore_3
    //   63: aload_0
    //   64: aload_2
    //   65: invokespecial zzk : (Ljava/lang/String;)Z
    //   68: pop
    //   69: aload_0
    //   70: aload_0
    //   71: getfield zzdn : I
    //   74: iconst_1
    //   75: iadd
    //   76: putfield zzdn : I
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_3
    //   82: ifnull -> 0
    //   85: aload_3
    //   86: aconst_null
    //   87: invokevirtual setResult : (Ljava/lang/Object;)V
    //   90: goto -> 0
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	98	finally
    //   11	25	98	finally
    //   25	27	98	finally
    //   29	31	98	finally
    //   43	81	93	finally
    //   94	96	93	finally
    //   99	101	98	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */