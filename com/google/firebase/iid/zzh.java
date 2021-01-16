package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.GuardedBy;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public final class zzh implements ServiceConnection {
  private final Intent zzaa;
  
  private final ScheduledExecutorService zzab;
  
  private final Queue<zzd> zzac = new ArrayDeque<zzd>();
  
  private zzf zzad;
  
  @GuardedBy("this")
  private boolean zzae = false;
  
  private final Context zzz;
  
  public zzh(Context paramContext, String paramString) {
    this(paramContext, paramString, new ScheduledThreadPoolExecutor(0, (ThreadFactory)new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
  }
  
  @VisibleForTesting
  private zzh(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService) {
    this.zzz = paramContext.getApplicationContext();
    this.zzaa = (new Intent(paramString)).setPackage(this.zzz.getPackageName());
    this.zzab = paramScheduledExecutorService;
  }
  
  private final void zzd() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'EnhancedIntentService'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 19
    //   11: ldc 'EnhancedIntentService'
    //   13: ldc 'flush queue called'
    //   15: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_0
    //   20: getfield zzac : Ljava/util/Queue;
    //   23: invokeinterface isEmpty : ()Z
    //   28: ifne -> 232
    //   31: ldc 'EnhancedIntentService'
    //   33: iconst_3
    //   34: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   37: ifeq -> 48
    //   40: ldc 'EnhancedIntentService'
    //   42: ldc 'found intent to be delivered'
    //   44: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   47: pop
    //   48: aload_0
    //   49: getfield zzad : Lcom/google/firebase/iid/zzf;
    //   52: ifnull -> 106
    //   55: aload_0
    //   56: getfield zzad : Lcom/google/firebase/iid/zzf;
    //   59: invokevirtual isBinderAlive : ()Z
    //   62: ifeq -> 106
    //   65: ldc 'EnhancedIntentService'
    //   67: iconst_3
    //   68: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   71: ifeq -> 82
    //   74: ldc 'EnhancedIntentService'
    //   76: ldc 'binder is alive, sending the intent.'
    //   78: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: aload_0
    //   83: getfield zzac : Ljava/util/Queue;
    //   86: invokeinterface poll : ()Ljava/lang/Object;
    //   91: checkcast com/google/firebase/iid/zzd
    //   94: astore_1
    //   95: aload_0
    //   96: getfield zzad : Lcom/google/firebase/iid/zzf;
    //   99: aload_1
    //   100: invokevirtual zza : (Lcom/google/firebase/iid/zzd;)V
    //   103: goto -> 19
    //   106: ldc 'EnhancedIntentService'
    //   108: iconst_3
    //   109: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   112: ifeq -> 162
    //   115: aload_0
    //   116: getfield zzae : Z
    //   119: ifne -> 127
    //   122: iconst_1
    //   123: istore_2
    //   124: goto -> 129
    //   127: iconst_0
    //   128: istore_2
    //   129: new java/lang/StringBuilder
    //   132: astore_1
    //   133: aload_1
    //   134: bipush #39
    //   136: invokespecial <init> : (I)V
    //   139: aload_1
    //   140: ldc 'binder is dead. start connection? '
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_1
    //   147: iload_2
    //   148: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 'EnhancedIntentService'
    //   154: aload_1
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   161: pop
    //   162: aload_0
    //   163: getfield zzae : Z
    //   166: ifne -> 229
    //   169: aload_0
    //   170: iconst_1
    //   171: putfield zzae : Z
    //   174: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   177: aload_0
    //   178: getfield zzz : Landroid/content/Context;
    //   181: aload_0
    //   182: getfield zzaa : Landroid/content/Intent;
    //   185: aload_0
    //   186: bipush #65
    //   188: invokevirtual bindService : (Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   191: istore_2
    //   192: iload_2
    //   193: ifeq -> 199
    //   196: aload_0
    //   197: monitorexit
    //   198: return
    //   199: ldc 'EnhancedIntentService'
    //   201: ldc 'binding to the service failed'
    //   203: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   206: pop
    //   207: goto -> 220
    //   210: astore_1
    //   211: ldc 'EnhancedIntentService'
    //   213: ldc 'Exception while binding the service'
    //   215: aload_1
    //   216: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   219: pop
    //   220: aload_0
    //   221: iconst_0
    //   222: putfield zzae : Z
    //   225: aload_0
    //   226: invokespecial zze : ()V
    //   229: aload_0
    //   230: monitorexit
    //   231: return
    //   232: aload_0
    //   233: monitorexit
    //   234: return
    //   235: astore_1
    //   236: aload_0
    //   237: monitorexit
    //   238: aload_1
    //   239: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	235	finally
    //   19	48	235	finally
    //   48	82	235	finally
    //   82	103	235	finally
    //   106	122	235	finally
    //   129	162	235	finally
    //   162	174	235	finally
    //   174	192	210	java/lang/SecurityException
    //   174	192	235	finally
    //   199	207	210	java/lang/SecurityException
    //   199	207	235	finally
    //   211	220	235	finally
    //   220	229	235	finally
  }
  
  @GuardedBy("this")
  private final void zze() {
    while (!this.zzac.isEmpty())
      ((zzd)this.zzac.poll()).finish(); 
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'EnhancedIntentService'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 64
    //   11: aload_1
    //   12: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual length : ()I
    //   23: istore_3
    //   24: new java/lang/StringBuilder
    //   27: astore #4
    //   29: aload #4
    //   31: iload_3
    //   32: bipush #20
    //   34: iadd
    //   35: invokespecial <init> : (I)V
    //   38: aload #4
    //   40: ldc 'onServiceConnected: '
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: aload_1
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 'EnhancedIntentService'
    //   55: aload #4
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   63: pop
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield zzae : Z
    //   69: aload_2
    //   70: instanceof com/google/firebase/iid/zzf
    //   73: ifne -> 131
    //   76: aload_2
    //   77: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   80: astore_1
    //   81: aload_1
    //   82: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   85: invokevirtual length : ()I
    //   88: istore_3
    //   89: new java/lang/StringBuilder
    //   92: astore_2
    //   93: aload_2
    //   94: iload_3
    //   95: bipush #28
    //   97: iadd
    //   98: invokespecial <init> : (I)V
    //   101: aload_2
    //   102: ldc 'Invalid service connection: '
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 'EnhancedIntentService'
    //   116: aload_2
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: aload_0
    //   125: invokespecial zze : ()V
    //   128: aload_0
    //   129: monitorexit
    //   130: return
    //   131: aload_0
    //   132: aload_2
    //   133: checkcast com/google/firebase/iid/zzf
    //   136: putfield zzad : Lcom/google/firebase/iid/zzf;
    //   139: aload_0
    //   140: invokespecial zzd : ()V
    //   143: aload_0
    //   144: monitorexit
    //   145: return
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Exception table:
    //   from	to	target	type
    //   2	64	146	finally
    //   64	128	146	finally
    //   131	143	146	finally
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    if (Log.isLoggable("EnhancedIntentService", 3)) {
      String str = String.valueOf(paramComponentName);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 23);
      stringBuilder.append("onServiceDisconnected: ");
      stringBuilder.append(str);
      Log.d("EnhancedIntentService", stringBuilder.toString());
    } 
    zzd();
  }
  
  public final void zza(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'EnhancedIntentService'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 19
    //   11: ldc 'EnhancedIntentService'
    //   13: ldc 'new intent queued in the bind-strategy delivery'
    //   15: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_0
    //   20: getfield zzac : Ljava/util/Queue;
    //   23: astore_3
    //   24: new com/google/firebase/iid/zzd
    //   27: astore #4
    //   29: aload #4
    //   31: aload_1
    //   32: aload_2
    //   33: aload_0
    //   34: getfield zzab : Ljava/util/concurrent/ScheduledExecutorService;
    //   37: invokespecial <init> : (Landroid/content/Intent;Landroid/content/BroadcastReceiver$PendingResult;Ljava/util/concurrent/ScheduledExecutorService;)V
    //   40: aload_3
    //   41: aload #4
    //   43: invokeinterface add : (Ljava/lang/Object;)Z
    //   48: pop
    //   49: aload_0
    //   50: invokespecial zzd : ()V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	56	finally
    //   19	53	56	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */