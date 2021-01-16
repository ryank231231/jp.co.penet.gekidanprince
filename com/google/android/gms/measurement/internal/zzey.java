package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzey implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
  private volatile boolean zzqw;
  
  private volatile zzat zzqx;
  
  protected zzey(zzeg paramzzeg) {}
  
  @MainThread
  public final void onConnected(@Nullable Bundle paramBundle) {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
    /* monitor enter ThisExpression{ObjectType{com/google/android/gms/measurement/internal/zzey}} */
    try {
      zzam zzam = (zzam)this.zzqx.getService();
      zzbt zzbt = this.zzqq.zzac();
      zzfb zzfb = new zzfb();
      this(this, zzam);
      zzbt.zza(zzfb);
    } catch (DeadObjectException|IllegalStateException deadObjectException) {
      this.zzqx = null;
      this.zzqw = false;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/google/android/gms/measurement/internal/zzey}} */
  }
  
  @MainThread
  public final void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult) {
    // Byte code:
    //   0: ldc 'MeasurementServiceConnection.onConnectionFailed'
    //   2: invokestatic checkMainThread : (Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   9: getfield zzl : Lcom/google/android/gms/measurement/internal/zzby;
    //   12: invokevirtual zzei : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull -> 30
    //   20: aload_2
    //   21: invokevirtual zzdd : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   24: ldc 'Service connection failed'
    //   26: aload_1
    //   27: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield zzqw : Z
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield zzqx : Lcom/google/android/gms/measurement/internal/zzat;
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   48: invokevirtual zzac : ()Lcom/google/android/gms/measurement/internal/zzbt;
    //   51: new com/google/android/gms/measurement/internal/zzfd
    //   54: dup
    //   55: aload_0
    //   56: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzey;)V
    //   59: invokevirtual zza : (Ljava/lang/Runnable;)V
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   32	44	63	finally
    //   64	66	63	finally
  }
  
  @MainThread
  public final void onConnectionSuspended(int paramInt) {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
    this.zzqq.zzad().zzdh().zzaq("Service connection suspended");
    this.zzqq.zzac().zza(new zzfc(this));
  }
  
  @MainThread
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: ldc 'MeasurementServiceConnection.onServiceConnected'
    //   2: invokestatic checkMainThread : (Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_2
    //   8: ifnonnull -> 38
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield zzqw : Z
    //   16: aload_0
    //   17: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   20: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   23: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   26: ldc 'Service connected with null binder'
    //   28: invokevirtual zzaq : (Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: goto -> 252
    //   38: aconst_null
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_3
    //   42: aconst_null
    //   43: astore #4
    //   45: aload_1
    //   46: astore #5
    //   48: aload_2
    //   49: invokeinterface getInterfaceDescriptor : ()Ljava/lang/String;
    //   54: astore #6
    //   56: aload_1
    //   57: astore #5
    //   59: ldc 'com.google.android.gms.measurement.internal.IMeasurementService'
    //   61: aload #6
    //   63: invokevirtual equals : (Ljava/lang/Object;)Z
    //   66: ifeq -> 148
    //   69: aload_2
    //   70: ifnonnull -> 79
    //   73: aload #4
    //   75: astore_1
    //   76: goto -> 127
    //   79: aload_1
    //   80: astore #5
    //   82: aload_2
    //   83: ldc 'com.google.android.gms.measurement.internal.IMeasurementService'
    //   85: invokeinterface queryLocalInterface : (Ljava/lang/String;)Landroid/os/IInterface;
    //   90: astore #4
    //   92: aload_1
    //   93: astore #5
    //   95: aload #4
    //   97: instanceof com/google/android/gms/measurement/internal/zzam
    //   100: ifeq -> 115
    //   103: aload_1
    //   104: astore #5
    //   106: aload #4
    //   108: checkcast com/google/android/gms/measurement/internal/zzam
    //   111: astore_1
    //   112: goto -> 127
    //   115: aload_1
    //   116: astore #5
    //   118: new com/google/android/gms/measurement/internal/zzao
    //   121: dup
    //   122: aload_2
    //   123: invokespecial <init> : (Landroid/os/IBinder;)V
    //   126: astore_1
    //   127: aload_1
    //   128: astore #5
    //   130: aload_0
    //   131: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   134: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   137: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   140: ldc 'Bound to IMeasurementService interface'
    //   142: invokevirtual zzaq : (Ljava/lang/String;)V
    //   145: goto -> 192
    //   148: aload_1
    //   149: astore #5
    //   151: aload_0
    //   152: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   155: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   158: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   161: ldc 'Got binder with a wrong descriptor'
    //   163: aload #6
    //   165: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   168: aload_3
    //   169: astore_1
    //   170: goto -> 192
    //   173: astore_1
    //   174: aload_0
    //   175: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   178: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   181: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   184: ldc 'Service connect failed to get IMeasurementService'
    //   186: invokevirtual zzaq : (Ljava/lang/String;)V
    //   189: aload #5
    //   191: astore_1
    //   192: aload_1
    //   193: ifnonnull -> 224
    //   196: aload_0
    //   197: iconst_0
    //   198: putfield zzqw : Z
    //   201: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   204: aload_0
    //   205: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   208: invokevirtual getContext : ()Landroid/content/Context;
    //   211: aload_0
    //   212: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   215: invokestatic zza : (Lcom/google/android/gms/measurement/internal/zzeg;)Lcom/google/android/gms/measurement/internal/zzey;
    //   218: invokevirtual unbindService : (Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   221: goto -> 249
    //   224: aload_0
    //   225: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   228: invokevirtual zzac : ()Lcom/google/android/gms/measurement/internal/zzbt;
    //   231: astore #5
    //   233: new com/google/android/gms/measurement/internal/zzez
    //   236: astore_2
    //   237: aload_2
    //   238: aload_0
    //   239: aload_1
    //   240: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzey;Lcom/google/android/gms/measurement/internal/zzam;)V
    //   243: aload #5
    //   245: aload_2
    //   246: invokevirtual zza : (Ljava/lang/Runnable;)V
    //   249: aload_0
    //   250: monitorexit
    //   251: return
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: goto -> 249
    // Exception table:
    //   from	to	target	type
    //   11	33	34	finally
    //   48	56	173	android/os/RemoteException
    //   48	56	34	finally
    //   59	69	173	android/os/RemoteException
    //   59	69	34	finally
    //   82	92	173	android/os/RemoteException
    //   82	92	34	finally
    //   95	103	173	android/os/RemoteException
    //   95	103	34	finally
    //   106	112	173	android/os/RemoteException
    //   106	112	34	finally
    //   118	127	173	android/os/RemoteException
    //   118	127	34	finally
    //   130	145	173	android/os/RemoteException
    //   130	145	34	finally
    //   151	168	173	android/os/RemoteException
    //   151	168	34	finally
    //   174	189	34	finally
    //   196	201	34	finally
    //   201	221	256	java/lang/IllegalArgumentException
    //   201	221	34	finally
    //   224	249	34	finally
    //   249	251	34	finally
    //   252	254	34	finally
  }
  
  @MainThread
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
    this.zzqq.zzad().zzdh().zzaq("Service disconnected");
    this.zzqq.zzac().zza(new zzfa(this, paramComponentName));
  }
  
  @WorkerThread
  public final void zzb(Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   4: invokevirtual zzq : ()V
    //   7: aload_0
    //   8: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   11: invokevirtual getContext : ()Landroid/content/Context;
    //   14: astore_2
    //   15: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   18: astore_3
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield zzqw : Z
    //   25: ifeq -> 46
    //   28: aload_0
    //   29: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   32: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   35: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   38: ldc 'Connection attempt already in progress'
    //   40: invokevirtual zzaq : (Ljava/lang/String;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   50: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   53: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   56: ldc 'Using local app measurement service'
    //   58: invokevirtual zzaq : (Ljava/lang/String;)V
    //   61: aload_0
    //   62: iconst_1
    //   63: putfield zzqw : Z
    //   66: aload_3
    //   67: aload_2
    //   68: aload_1
    //   69: aload_0
    //   70: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   73: invokestatic zza : (Lcom/google/android/gms/measurement/internal/zzeg;)Lcom/google/android/gms/measurement/internal/zzey;
    //   76: sipush #129
    //   79: invokevirtual bindService : (Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   82: pop
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   21	45	86	finally
    //   46	85	86	finally
    //   87	89	86	finally
  }
  
  @WorkerThread
  public final void zzfl() {
    if (this.zzqx != null && (this.zzqx.isConnected() || this.zzqx.isConnecting()))
      this.zzqx.disconnect(); 
    this.zzqx = null;
  }
  
  @WorkerThread
  public final void zzfm() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   4: invokevirtual zzq : ()V
    //   7: aload_0
    //   8: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   11: invokevirtual getContext : ()Landroid/content/Context;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield zzqw : Z
    //   21: ifeq -> 42
    //   24: aload_0
    //   25: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   28: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   31: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   34: ldc 'Connection attempt already in progress'
    //   36: invokevirtual zzaq : (Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield zzqx : Lcom/google/android/gms/measurement/internal/zzat;
    //   46: ifnull -> 87
    //   49: aload_0
    //   50: getfield zzqx : Lcom/google/android/gms/measurement/internal/zzat;
    //   53: invokevirtual isConnecting : ()Z
    //   56: ifne -> 69
    //   59: aload_0
    //   60: getfield zzqx : Lcom/google/android/gms/measurement/internal/zzat;
    //   63: invokevirtual isConnected : ()Z
    //   66: ifeq -> 87
    //   69: aload_0
    //   70: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   73: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   76: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   79: ldc 'Already awaiting connection attempt'
    //   81: invokevirtual zzaq : (Ljava/lang/String;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: new com/google/android/gms/measurement/internal/zzat
    //   90: astore_2
    //   91: aload_2
    //   92: aload_1
    //   93: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   96: aload_0
    //   97: aload_0
    //   98: invokespecial <init> : (Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/BaseGmsClient$BaseConnectionCallbacks;Lcom/google/android/gms/common/internal/BaseGmsClient$BaseOnConnectionFailedListener;)V
    //   101: aload_0
    //   102: aload_2
    //   103: putfield zzqx : Lcom/google/android/gms/measurement/internal/zzat;
    //   106: aload_0
    //   107: getfield zzqq : Lcom/google/android/gms/measurement/internal/zzeg;
    //   110: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   113: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   116: ldc 'Connecting to remote service'
    //   118: invokevirtual zzaq : (Ljava/lang/String;)V
    //   121: aload_0
    //   122: iconst_1
    //   123: putfield zzqw : Z
    //   126: aload_0
    //   127: getfield zzqx : Lcom/google/android/gms/measurement/internal/zzat;
    //   130: invokevirtual checkAvailabilityAndConnect : ()V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_2
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    // Exception table:
    //   from	to	target	type
    //   17	41	136	finally
    //   42	69	136	finally
    //   69	86	136	finally
    //   87	135	136	finally
    //   137	139	136	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */