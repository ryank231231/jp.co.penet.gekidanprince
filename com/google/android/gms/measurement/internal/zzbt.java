package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbt extends zzcu {
  private static final AtomicLong zzng = new AtomicLong(Long.MIN_VALUE);
  
  private zzbx zzmx;
  
  private zzbx zzmy;
  
  private final PriorityBlockingQueue<zzbw<?>> zzmz = new PriorityBlockingQueue<zzbw<?>>();
  
  private final BlockingQueue<zzbw<?>> zzna = new LinkedBlockingQueue<zzbw<?>>();
  
  private final Thread.UncaughtExceptionHandler zznb = new zzbv(this, "Thread death: Uncaught exception on worker thread");
  
  private final Thread.UncaughtExceptionHandler zznc = new zzbv(this, "Thread death: Uncaught exception on network thread");
  
  private final Object zznd = new Object();
  
  private final Semaphore zzne = new Semaphore(2);
  
  private volatile boolean zznf;
  
  zzbt(zzby paramzzby) {
    super(paramzzby);
  }
  
  private final void zza(zzbw<?> paramzzbw) {
    synchronized (this.zznd) {
      this.zzmz.add(paramzzbw);
      if (this.zzmx == null) {
        zzbx zzbx1 = new zzbx();
        this(this, "Measurement Worker", this.zzmz);
        this.zzmx = zzbx1;
        this.zzmx.setUncaughtExceptionHandler(this.zznb);
        this.zzmx.start();
      } else {
        this.zzmx.zzeh();
      } 
      return;
    } 
  }
  
  final <T> T zza(AtomicReference<T> paramAtomicReference, long paramLong, String paramString, Runnable paramRunnable) {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual zzac : ()Lcom/google/android/gms/measurement/internal/zzbt;
    //   6: aload #5
    //   8: invokevirtual zza : (Ljava/lang/Runnable;)V
    //   11: aload_1
    //   12: ldc2_w 15000
    //   15: invokevirtual wait : (J)V
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_1
    //   21: invokevirtual get : ()Ljava/lang/Object;
    //   24: astore #6
    //   26: aload #6
    //   28: ifnonnull -> 79
    //   31: aload_0
    //   32: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   35: invokevirtual zzdd : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   38: astore #5
    //   40: aload #4
    //   42: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual length : ()I
    //   50: ifeq -> 63
    //   53: ldc 'Timed out waiting for '
    //   55: aload_1
    //   56: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: goto -> 73
    //   63: new java/lang/String
    //   66: dup
    //   67: ldc 'Timed out waiting for '
    //   69: invokespecial <init> : (Ljava/lang/String;)V
    //   72: astore_1
    //   73: aload #5
    //   75: aload_1
    //   76: invokevirtual zzaq : (Ljava/lang/String;)V
    //   79: aload #6
    //   81: areturn
    //   82: astore #5
    //   84: aload_0
    //   85: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   88: invokevirtual zzdd : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   91: astore #5
    //   93: aload #4
    //   95: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   98: astore #4
    //   100: aload #4
    //   102: invokevirtual length : ()I
    //   105: ifeq -> 120
    //   108: ldc 'Interrupted waiting for '
    //   110: aload #4
    //   112: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   115: astore #4
    //   117: goto -> 131
    //   120: new java/lang/String
    //   123: dup
    //   124: ldc 'Interrupted waiting for '
    //   126: invokespecial <init> : (Ljava/lang/String;)V
    //   129: astore #4
    //   131: aload #5
    //   133: aload #4
    //   135: invokevirtual zzaq : (Ljava/lang/String;)V
    //   138: aload_1
    //   139: monitorexit
    //   140: aconst_null
    //   141: areturn
    //   142: astore #4
    //   144: aload_1
    //   145: monitorexit
    //   146: aload #4
    //   148: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	142	finally
    //   11	18	82	java/lang/InterruptedException
    //   11	18	142	finally
    //   18	20	142	finally
    //   84	117	142	finally
    //   120	131	142	finally
    //   131	140	142	finally
    //   144	146	142	finally
  }
  
  public final <V> Future<V> zza(Callable<V> paramCallable) throws IllegalStateException {
    zzah();
    Preconditions.checkNotNull(paramCallable);
    zzbw<V> zzbw = new zzbw<V>(this, paramCallable, false, "Task exception on worker thread");
    if (Thread.currentThread() == this.zzmx) {
      if (!this.zzmz.isEmpty())
        super.zzad().zzdd().zzaq("Callable skipped the worker queue."); 
      zzbw.run();
    } else {
      zza(zzbw);
    } 
    return zzbw;
  }
  
  public final void zza(Runnable paramRunnable) throws IllegalStateException {
    zzah();
    Preconditions.checkNotNull(paramRunnable);
    zza(new zzbw(this, paramRunnable, false, "Task exception on worker thread"));
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  public final <V> Future<V> zzb(Callable<V> paramCallable) throws IllegalStateException {
    zzah();
    Preconditions.checkNotNull(paramCallable);
    zzbw<V> zzbw = new zzbw<V>(this, paramCallable, true, "Task exception on worker thread");
    if (Thread.currentThread() == this.zzmx) {
      zzbw.run();
    } else {
      zza(zzbw);
    } 
    return zzbw;
  }
  
  public final void zzb(Runnable paramRunnable) throws IllegalStateException {
    zzah();
    Preconditions.checkNotNull(paramRunnable);
    null = new zzbw(this, paramRunnable, false, "Task exception on network thread");
    synchronized (this.zznd) {
      this.zzna.add(null);
      if (this.zzmy == null) {
        zzbx zzbx1 = new zzbx();
        this(this, "Measurement Network", this.zzna);
        this.zzmy = zzbx1;
        this.zzmy.setUncaughtExceptionHandler(this.zznc);
        this.zzmy.start();
      } else {
        this.zzmy.zzeh();
      } 
      return;
    } 
  }
  
  public final boolean zzef() {
    return (Thread.currentThread() == this.zzmx);
  }
  
  public final void zzp() {
    if (Thread.currentThread() == this.zzmy)
      return; 
    throw new IllegalStateException("Call expected from network thread");
  }
  
  public final void zzq() {
    if (Thread.currentThread() == this.zzmx)
      return; 
    throw new IllegalStateException("Call expected from worker thread");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */