package com.google.firebase.iid;

import android.support.v4.util.ArrayMap;
import android.util.Pair;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzaq {
  private final Executor zzbk;
  
  @GuardedBy("this")
  private final Map<Pair<String, String>, Task<InstanceIdResult>> zzcp = (Map<Pair<String, String>, Task<InstanceIdResult>>)new ArrayMap();
  
  zzaq(Executor paramExecutor) {
    this.zzbk = paramExecutor;
  }
  
  final Task<InstanceIdResult> zza(String paramString1, String paramString2, zzas paramzzas) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/util/Pair
    //   5: astore #4
    //   7: aload #4
    //   9: aload_1
    //   10: aload_2
    //   11: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield zzcp : Ljava/util/Map;
    //   18: aload #4
    //   20: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast com/google/android/gms/tasks/Task
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull -> 97
    //   33: ldc 'FirebaseInstanceId'
    //   35: iconst_3
    //   36: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   39: ifeq -> 93
    //   42: aload #4
    //   44: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   52: invokevirtual length : ()I
    //   55: istore #5
    //   57: new java/lang/StringBuilder
    //   60: astore_2
    //   61: aload_2
    //   62: iload #5
    //   64: bipush #29
    //   66: iadd
    //   67: invokespecial <init> : (I)V
    //   70: aload_2
    //   71: ldc 'Joining ongoing request for: '
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc 'FirebaseInstanceId'
    //   85: aload_2
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: areturn
    //   97: ldc 'FirebaseInstanceId'
    //   99: iconst_3
    //   100: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   103: ifeq -> 157
    //   106: aload #4
    //   108: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   111: astore_2
    //   112: aload_2
    //   113: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual length : ()I
    //   119: istore #5
    //   121: new java/lang/StringBuilder
    //   124: astore_1
    //   125: aload_1
    //   126: iload #5
    //   128: bipush #24
    //   130: iadd
    //   131: invokespecial <init> : (I)V
    //   134: aload_1
    //   135: ldc 'Making new request for: '
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: aload_2
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 'FirebaseInstanceId'
    //   149: aload_1
    //   150: invokevirtual toString : ()Ljava/lang/String;
    //   153: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: aload_3
    //   158: invokeinterface zzs : ()Lcom/google/android/gms/tasks/Task;
    //   163: astore_1
    //   164: aload_0
    //   165: getfield zzbk : Ljava/util/concurrent/Executor;
    //   168: astore_3
    //   169: new com/google/firebase/iid/zzar
    //   172: astore_2
    //   173: aload_2
    //   174: aload_0
    //   175: aload #4
    //   177: invokespecial <init> : (Lcom/google/firebase/iid/zzaq;Landroid/util/Pair;)V
    //   180: aload_1
    //   181: aload_3
    //   182: aload_2
    //   183: invokevirtual continueWithTask : (Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/Continuation;)Lcom/google/android/gms/tasks/Task;
    //   186: astore_1
    //   187: aload_0
    //   188: getfield zzcp : Ljava/util/Map;
    //   191: aload #4
    //   193: aload_1
    //   194: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_1
    //   203: areturn
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	204	finally
    //   33	93	204	finally
    //   97	157	204	finally
    //   157	200	204	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */