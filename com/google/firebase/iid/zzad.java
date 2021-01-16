package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.SparseArray;
import com.google.android.gms.internal.firebase_messaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

final class zzad implements ServiceConnection {
  @GuardedBy("this")
  int state = 0;
  
  final Messenger zzby = new Messenger((Handler)new zze(Looper.getMainLooper(), new zzae(this)));
  
  zzai zzbz;
  
  @GuardedBy("this")
  final Queue<zzak<?>> zzca = new ArrayDeque<zzak<?>>();
  
  @GuardedBy("this")
  final SparseArray<zzak<?>> zzcb = new SparseArray();
  
  private zzad(zzab paramzzab) {}
  
  private final void zzy() {
    zzab.zzb(this.zzcc).execute(new zzag(this));
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_2
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 19
    //   11: ldc 'MessengerIpcClient'
    //   13: ldc 'Service connected'
    //   15: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_2
    //   20: ifnonnull -> 33
    //   23: aload_0
    //   24: iconst_0
    //   25: ldc 'Null service connection'
    //   27: invokevirtual zza : (ILjava/lang/String;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new com/google/firebase/iid/zzai
    //   36: astore_1
    //   37: aload_1
    //   38: aload_2
    //   39: invokespecial <init> : (Landroid/os/IBinder;)V
    //   42: aload_0
    //   43: aload_1
    //   44: putfield zzbz : Lcom/google/firebase/iid/zzai;
    //   47: aload_0
    //   48: iconst_2
    //   49: putfield state : I
    //   52: aload_0
    //   53: invokespecial zzy : ()V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: iconst_0
    //   62: aload_1
    //   63: invokevirtual getMessage : ()Ljava/lang/String;
    //   66: invokevirtual zza : (ILjava/lang/String;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	72	finally
    //   23	30	72	finally
    //   33	47	59	android/os/RemoteException
    //   33	47	72	finally
    //   47	56	72	finally
    //   60	69	72	finally
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_2
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 19
    //   11: ldc 'MessengerIpcClient'
    //   13: ldc 'Service disconnected'
    //   15: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_0
    //   20: iconst_2
    //   21: ldc 'Service disconnected'
    //   23: invokevirtual zza : (ILjava/lang/String;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	29	finally
    //   19	26	29	finally
  }
  
  final void zza(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzcb : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/google/firebase/iid/zzak
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 79
    //   18: new java/lang/StringBuilder
    //   21: astore_3
    //   22: aload_3
    //   23: bipush #31
    //   25: invokespecial <init> : (I)V
    //   28: aload_3
    //   29: ldc 'Timing out request: '
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: iload_1
    //   37: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 'MessengerIpcClient'
    //   43: aload_3
    //   44: invokevirtual toString : ()Ljava/lang/String;
    //   47: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aload_0
    //   52: getfield zzcb : Landroid/util/SparseArray;
    //   55: iload_1
    //   56: invokevirtual remove : (I)V
    //   59: new com/google/firebase/iid/zzal
    //   62: astore_3
    //   63: aload_3
    //   64: iconst_3
    //   65: ldc 'Timed out waiting for response'
    //   67: invokespecial <init> : (ILjava/lang/String;)V
    //   70: aload_2
    //   71: aload_3
    //   72: invokevirtual zza : (Lcom/google/firebase/iid/zzal;)V
    //   75: aload_0
    //   76: invokevirtual zzz : ()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	82	finally
    //   18	79	82	finally
  }
  
  final void zza(int paramInt, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 50
    //   11: aload_2
    //   12: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual length : ()I
    //   20: ifeq -> 33
    //   23: ldc 'Disconnected: '
    //   25: aload_3
    //   26: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_3
    //   30: goto -> 43
    //   33: new java/lang/String
    //   36: dup
    //   37: ldc 'Disconnected: '
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: astore_3
    //   43: ldc 'MessengerIpcClient'
    //   45: aload_3
    //   46: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: aload_0
    //   51: getfield state : I
    //   54: tableswitch default -> 88, 0 -> 240, 1 -> 106, 2 -> 106, 3 -> 98, 4 -> 95
    //   88: new java/lang/IllegalStateException
    //   91: astore_2
    //   92: goto -> 250
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: aload_0
    //   99: iconst_4
    //   100: putfield state : I
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: ldc 'MessengerIpcClient'
    //   108: iconst_2
    //   109: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   112: ifeq -> 123
    //   115: ldc 'MessengerIpcClient'
    //   117: ldc 'Unbinding service'
    //   119: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   122: pop
    //   123: aload_0
    //   124: iconst_4
    //   125: putfield state : I
    //   128: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   131: aload_0
    //   132: getfield zzcc : Lcom/google/firebase/iid/zzab;
    //   135: invokestatic zza : (Lcom/google/firebase/iid/zzab;)Landroid/content/Context;
    //   138: aload_0
    //   139: invokevirtual unbindService : (Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   142: new com/google/firebase/iid/zzal
    //   145: astore_3
    //   146: aload_3
    //   147: iload_1
    //   148: aload_2
    //   149: invokespecial <init> : (ILjava/lang/String;)V
    //   152: aload_0
    //   153: getfield zzca : Ljava/util/Queue;
    //   156: invokeinterface iterator : ()Ljava/util/Iterator;
    //   161: astore_2
    //   162: aload_2
    //   163: invokeinterface hasNext : ()Z
    //   168: ifeq -> 187
    //   171: aload_2
    //   172: invokeinterface next : ()Ljava/lang/Object;
    //   177: checkcast com/google/firebase/iid/zzak
    //   180: aload_3
    //   181: invokevirtual zza : (Lcom/google/firebase/iid/zzal;)V
    //   184: goto -> 162
    //   187: aload_0
    //   188: getfield zzca : Ljava/util/Queue;
    //   191: invokeinterface clear : ()V
    //   196: iconst_0
    //   197: istore_1
    //   198: iload_1
    //   199: aload_0
    //   200: getfield zzcb : Landroid/util/SparseArray;
    //   203: invokevirtual size : ()I
    //   206: if_icmpge -> 230
    //   209: aload_0
    //   210: getfield zzcb : Landroid/util/SparseArray;
    //   213: iload_1
    //   214: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   217: checkcast com/google/firebase/iid/zzak
    //   220: aload_3
    //   221: invokevirtual zza : (Lcom/google/firebase/iid/zzal;)V
    //   224: iinc #1, 1
    //   227: goto -> 198
    //   230: aload_0
    //   231: getfield zzcb : Landroid/util/SparseArray;
    //   234: invokevirtual clear : ()V
    //   237: aload_0
    //   238: monitorexit
    //   239: return
    //   240: new java/lang/IllegalStateException
    //   243: astore_2
    //   244: aload_2
    //   245: invokespecial <init> : ()V
    //   248: aload_2
    //   249: athrow
    //   250: aload_0
    //   251: getfield state : I
    //   254: istore_1
    //   255: new java/lang/StringBuilder
    //   258: astore_3
    //   259: aload_3
    //   260: bipush #26
    //   262: invokespecial <init> : (I)V
    //   265: aload_3
    //   266: ldc 'Unknown state: '
    //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_3
    //   273: iload_1
    //   274: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: aload_3
    //   280: invokevirtual toString : ()Ljava/lang/String;
    //   283: invokespecial <init> : (Ljava/lang/String;)V
    //   286: aload_2
    //   287: athrow
    //   288: astore_2
    //   289: aload_0
    //   290: monitorexit
    //   291: aload_2
    //   292: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	288	finally
    //   33	43	288	finally
    //   43	50	288	finally
    //   50	88	288	finally
    //   88	92	288	finally
    //   98	103	288	finally
    //   106	123	288	finally
    //   123	162	288	finally
    //   162	184	288	finally
    //   187	196	288	finally
    //   198	224	288	finally
    //   230	237	288	finally
    //   240	250	288	finally
    //   250	288	288	finally
  }
  
  final boolean zza(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield arg1 : I
    //   4: istore_2
    //   5: ldc 'MessengerIpcClient'
    //   7: iconst_3
    //   8: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   11: ifeq -> 47
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: bipush #41
    //   20: invokespecial <init> : (I)V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc 'Received response to request: '
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 'MessengerIpcClient'
    //   39: aload_3
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: aload_0
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield zzcb : Landroid/util/SparseArray;
    //   53: iload_2
    //   54: invokevirtual get : (I)Ljava/lang/Object;
    //   57: checkcast com/google/firebase/iid/zzak
    //   60: astore_3
    //   61: aload_3
    //   62: ifnonnull -> 102
    //   65: new java/lang/StringBuilder
    //   68: astore_1
    //   69: aload_1
    //   70: bipush #50
    //   72: invokespecial <init> : (I)V
    //   75: aload_1
    //   76: ldc 'Received response for unknown request: '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_1
    //   83: iload_2
    //   84: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 'MessengerIpcClient'
    //   90: aload_1
    //   91: invokevirtual toString : ()Ljava/lang/String;
    //   94: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aload_0
    //   99: monitorexit
    //   100: iconst_1
    //   101: ireturn
    //   102: aload_0
    //   103: getfield zzcb : Landroid/util/SparseArray;
    //   106: iload_2
    //   107: invokevirtual remove : (I)V
    //   110: aload_0
    //   111: invokevirtual zzz : ()V
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: invokevirtual getData : ()Landroid/os/Bundle;
    //   120: astore_1
    //   121: aload_1
    //   122: ldc 'unsupported'
    //   124: iconst_0
    //   125: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   128: ifeq -> 149
    //   131: aload_3
    //   132: new com/google/firebase/iid/zzal
    //   135: dup
    //   136: iconst_4
    //   137: ldc_w 'Not supported by GmsCore'
    //   140: invokespecial <init> : (ILjava/lang/String;)V
    //   143: invokevirtual zza : (Lcom/google/firebase/iid/zzal;)V
    //   146: goto -> 154
    //   149: aload_3
    //   150: aload_1
    //   151: invokevirtual zzb : (Landroid/os/Bundle;)V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Exception table:
    //   from	to	target	type
    //   49	61	156	finally
    //   65	100	156	finally
    //   102	116	156	finally
    //   157	159	156	finally
  }
  
  final void zzaa() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : I
    //   6: iconst_1
    //   7: if_icmpne -> 18
    //   10: aload_0
    //   11: iconst_1
    //   12: ldc_w 'Timed out while binding'
    //   15: invokevirtual zza : (ILjava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  final boolean zzb(zzak paramzzak) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : I
    //   6: tableswitch default -> 40, 0 -> 85, 1 -> 70, 2 -> 51, 3 -> 47, 4 -> 47
    //   40: new java/lang/IllegalStateException
    //   43: astore_2
    //   44: goto -> 221
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_0
    //   50: ireturn
    //   51: aload_0
    //   52: getfield zzca : Ljava/util/Queue;
    //   55: aload_1
    //   56: invokeinterface add : (Ljava/lang/Object;)Z
    //   61: pop
    //   62: aload_0
    //   63: invokespecial zzy : ()V
    //   66: aload_0
    //   67: monitorexit
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield zzca : Ljava/util/Queue;
    //   74: aload_1
    //   75: invokeinterface add : (Ljava/lang/Object;)Z
    //   80: pop
    //   81: aload_0
    //   82: monitorexit
    //   83: iconst_1
    //   84: ireturn
    //   85: aload_0
    //   86: getfield zzca : Ljava/util/Queue;
    //   89: aload_1
    //   90: invokeinterface add : (Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_0
    //   97: getfield state : I
    //   100: ifne -> 108
    //   103: iconst_1
    //   104: istore_3
    //   105: goto -> 110
    //   108: iconst_0
    //   109: istore_3
    //   110: iload_3
    //   111: invokestatic checkState : (Z)V
    //   114: ldc 'MessengerIpcClient'
    //   116: iconst_2
    //   117: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   120: ifeq -> 132
    //   123: ldc 'MessengerIpcClient'
    //   125: ldc_w 'Starting bind to GmsCore'
    //   128: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield state : I
    //   137: new android/content/Intent
    //   140: astore_1
    //   141: aload_1
    //   142: ldc_w 'com.google.android.c2dm.intent.REGISTER'
    //   145: invokespecial <init> : (Ljava/lang/String;)V
    //   148: aload_1
    //   149: ldc_w 'com.google.android.gms'
    //   152: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   159: aload_0
    //   160: getfield zzcc : Lcom/google/firebase/iid/zzab;
    //   163: invokestatic zza : (Lcom/google/firebase/iid/zzab;)Landroid/content/Context;
    //   166: aload_1
    //   167: aload_0
    //   168: iconst_1
    //   169: invokevirtual bindService : (Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   172: ifne -> 186
    //   175: aload_0
    //   176: iconst_0
    //   177: ldc_w 'Unable to bind to service'
    //   180: invokevirtual zza : (ILjava/lang/String;)V
    //   183: goto -> 217
    //   186: aload_0
    //   187: getfield zzcc : Lcom/google/firebase/iid/zzab;
    //   190: invokestatic zzb : (Lcom/google/firebase/iid/zzab;)Ljava/util/concurrent/ScheduledExecutorService;
    //   193: astore_2
    //   194: new com/google/firebase/iid/zzaf
    //   197: astore_1
    //   198: aload_1
    //   199: aload_0
    //   200: invokespecial <init> : (Lcom/google/firebase/iid/zzad;)V
    //   203: aload_2
    //   204: aload_1
    //   205: ldc2_w 30
    //   208: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   211: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   216: pop
    //   217: aload_0
    //   218: monitorexit
    //   219: iconst_1
    //   220: ireturn
    //   221: aload_0
    //   222: getfield state : I
    //   225: istore #4
    //   227: new java/lang/StringBuilder
    //   230: astore_1
    //   231: aload_1
    //   232: bipush #26
    //   234: invokespecial <init> : (I)V
    //   237: aload_1
    //   238: ldc 'Unknown state: '
    //   240: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_1
    //   245: iload #4
    //   247: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_2
    //   252: aload_1
    //   253: invokevirtual toString : ()Ljava/lang/String;
    //   256: invokespecial <init> : (Ljava/lang/String;)V
    //   259: aload_2
    //   260: athrow
    //   261: astore_1
    //   262: aload_0
    //   263: monitorexit
    //   264: aload_1
    //   265: athrow
    // Exception table:
    //   from	to	target	type
    //   2	40	261	finally
    //   40	44	261	finally
    //   51	66	261	finally
    //   70	81	261	finally
    //   85	103	261	finally
    //   110	132	261	finally
    //   132	183	261	finally
    //   186	217	261	finally
    //   221	261	261	finally
  }
  
  final void zzz() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : I
    //   6: iconst_2
    //   7: if_icmpne -> 69
    //   10: aload_0
    //   11: getfield zzca : Ljava/util/Queue;
    //   14: invokeinterface isEmpty : ()Z
    //   19: ifeq -> 69
    //   22: aload_0
    //   23: getfield zzcb : Landroid/util/SparseArray;
    //   26: invokevirtual size : ()I
    //   29: ifne -> 69
    //   32: ldc 'MessengerIpcClient'
    //   34: iconst_2
    //   35: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   38: ifeq -> 50
    //   41: ldc 'MessengerIpcClient'
    //   43: ldc_w 'Finished handling requests, unbinding'
    //   46: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: aload_0
    //   51: iconst_3
    //   52: putfield state : I
    //   55: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   58: aload_0
    //   59: getfield zzcc : Lcom/google/firebase/iid/zzab;
    //   62: invokestatic zza : (Lcom/google/firebase/iid/zzab;)Landroid/content/Context;
    //   65: aload_0
    //   66: invokevirtual unbindService : (Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   2	50	72	finally
    //   50	69	72	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */