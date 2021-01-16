package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@KeepForSdk
@ShowFirstParty
@ThreadSafe
public class WakeLock {
  private static ScheduledExecutorService zzn;
  
  private static volatile zza zzo = new zza();
  
  private final Object zza = this;
  
  private final PowerManager.WakeLock zzb;
  
  private WorkSource zzc;
  
  private final int zzd;
  
  private final String zze;
  
  private final String zzf;
  
  private final String zzg;
  
  private final Context zzh;
  
  private boolean zzi = true;
  
  private final Map<String, Integer[]> zzj = (Map)new HashMap<String, Integer>();
  
  private final Set<Future<?>> zzk = Collections.synchronizedSet(new HashSet<Future<?>>());
  
  private int zzl;
  
  private AtomicInteger zzm = new AtomicInteger(0);
  
  @KeepForSdk
  public WakeLock(@NonNull Context paramContext, int paramInt, @NonNull String paramString) {
    this(paramContext, paramInt, paramString, null, str);
  }
  
  private WakeLock(@NonNull Context paramContext, int paramInt, @NonNull String paramString1, @Nullable String paramString2, @NonNull String paramString3) {
    this(paramContext, paramInt, paramString1, null, paramString3, null);
  }
  
  @SuppressLint({"UnwrappedWakeLock"})
  private WakeLock(@NonNull Context paramContext, int paramInt, @NonNull String paramString1, @Nullable String paramString2, @NonNull String paramString3, @Nullable String paramString4) {
    Preconditions.checkNotNull(paramContext, "WakeLock: context must not be null");
    Preconditions.checkNotEmpty(paramString1, "WakeLock: wakeLockName must not be empty");
    this.zzd = paramInt;
    this.zzf = null;
    this.zzg = null;
    this.zzh = paramContext.getApplicationContext();
    if (!"com.google.android.gms".equals(paramContext.getPackageName())) {
      paramString4 = String.valueOf("*gcore*:");
      paramString2 = String.valueOf(paramString1);
      if (paramString2.length() != 0) {
        paramString2 = paramString4.concat(paramString2);
      } else {
        paramString2 = new String(paramString4);
      } 
      this.zze = paramString2;
    } else {
      this.zze = paramString1;
    } 
    this.zzb = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
    if (WorkSourceUtil.hasWorkSourcePermission(paramContext)) {
      paramString1 = paramString3;
      if (Strings.isEmptyOrWhitespace(paramString3))
        paramString1 = paramContext.getPackageName(); 
      this.zzc = WorkSourceUtil.fromPackage(paramContext, paramString1);
      WorkSource workSource = this.zzc;
      if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzh)) {
        WorkSource workSource1 = this.zzc;
        if (workSource1 != null) {
          workSource1.add(workSource);
        } else {
          this.zzc = workSource;
        } 
        workSource1 = this.zzc;
        try {
          this.zzb.setWorkSource(workSource1);
        } catch (IllegalArgumentException illegalArgumentException) {
          Log.wtf("WakeLock", illegalArgumentException.toString());
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
      } 
    } 
    if (zzn == null)
      zzn = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor(); 
  }
  
  private final String zza(String paramString) {
    return this.zzi ? (!TextUtils.isEmpty(paramString) ? paramString : this.zzf) : this.zzf;
  }
  
  private final List<String> zza() {
    return WorkSourceUtil.getNames(this.zzc);
  }
  
  private final void zza(int paramInt) {
    if (this.zzb.isHeld()) {
      try {
        this.zzb.release();
      } catch (RuntimeException runtimeException) {
        if (runtimeException.getClass().equals(RuntimeException.class)) {
          Log.e("WakeLock", String.valueOf(this.zze).concat(" was already released!"), runtimeException);
        } else {
          throw runtimeException;
        } 
      } 
      this.zzb.isHeld();
    } 
  }
  
  @KeepForSdk
  public void acquire(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzm : Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: invokevirtual incrementAndGet : ()I
    //   7: pop
    //   8: aload_0
    //   9: aconst_null
    //   10: invokespecial zza : (Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_3
    //   14: aload_0
    //   15: getfield zza : Ljava/lang/Object;
    //   18: astore #4
    //   20: aload #4
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield zzj : Ljava/util/Map;
    //   27: invokeinterface isEmpty : ()Z
    //   32: istore #5
    //   34: iconst_0
    //   35: istore #6
    //   37: iload #5
    //   39: ifeq -> 49
    //   42: aload_0
    //   43: getfield zzl : I
    //   46: ifle -> 73
    //   49: aload_0
    //   50: getfield zzb : Landroid/os/PowerManager$WakeLock;
    //   53: invokevirtual isHeld : ()Z
    //   56: ifne -> 73
    //   59: aload_0
    //   60: getfield zzj : Ljava/util/Map;
    //   63: invokeinterface clear : ()V
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield zzl : I
    //   73: aload_0
    //   74: getfield zzi : Z
    //   77: ifeq -> 149
    //   80: aload_0
    //   81: getfield zzj : Ljava/util/Map;
    //   84: aload_3
    //   85: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast [Ljava/lang/Integer;
    //   93: astore #7
    //   95: aload #7
    //   97: ifnonnull -> 128
    //   100: aload_0
    //   101: getfield zzj : Ljava/util/Map;
    //   104: aload_3
    //   105: iconst_1
    //   106: anewarray java/lang/Integer
    //   109: dup
    //   110: iconst_0
    //   111: iconst_1
    //   112: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   115: aastore
    //   116: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: iconst_1
    //   123: istore #6
    //   125: goto -> 144
    //   128: aload #7
    //   130: iconst_0
    //   131: aload #7
    //   133: iconst_0
    //   134: aaload
    //   135: invokevirtual intValue : ()I
    //   138: iconst_1
    //   139: iadd
    //   140: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   143: aastore
    //   144: iload #6
    //   146: ifne -> 163
    //   149: aload_0
    //   150: getfield zzi : Z
    //   153: ifne -> 208
    //   156: aload_0
    //   157: getfield zzl : I
    //   160: ifne -> 208
    //   163: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/WakeLockTracker;
    //   166: aload_0
    //   167: getfield zzh : Landroid/content/Context;
    //   170: aload_0
    //   171: getfield zzb : Landroid/os/PowerManager$WakeLock;
    //   174: aload_3
    //   175: invokestatic getEventKey : (Landroid/os/PowerManager$WakeLock;Ljava/lang/String;)Ljava/lang/String;
    //   178: bipush #7
    //   180: aload_0
    //   181: getfield zze : Ljava/lang/String;
    //   184: aload_3
    //   185: aconst_null
    //   186: aload_0
    //   187: getfield zzd : I
    //   190: aload_0
    //   191: invokespecial zza : ()Ljava/util/List;
    //   194: lload_1
    //   195: invokevirtual registerEvent : (Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;J)V
    //   198: aload_0
    //   199: aload_0
    //   200: getfield zzl : I
    //   203: iconst_1
    //   204: iadd
    //   205: putfield zzl : I
    //   208: aload #4
    //   210: monitorexit
    //   211: aload_0
    //   212: getfield zzb : Landroid/os/PowerManager$WakeLock;
    //   215: invokevirtual acquire : ()V
    //   218: lload_1
    //   219: lconst_0
    //   220: lcmp
    //   221: ifle -> 245
    //   224: getstatic com/google/android/gms/stats/WakeLock.zzn : Ljava/util/concurrent/ScheduledExecutorService;
    //   227: new com/google/android/gms/stats/zzb
    //   230: dup
    //   231: aload_0
    //   232: invokespecial <init> : (Lcom/google/android/gms/stats/WakeLock;)V
    //   235: lload_1
    //   236: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   239: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   244: pop
    //   245: return
    //   246: astore_3
    //   247: aload #4
    //   249: monitorexit
    //   250: aload_3
    //   251: athrow
    // Exception table:
    //   from	to	target	type
    //   23	34	246	finally
    //   42	49	246	finally
    //   49	73	246	finally
    //   73	95	246	finally
    //   100	122	246	finally
    //   128	144	246	finally
    //   149	163	246	finally
    //   163	208	246	finally
    //   208	211	246	finally
    //   247	250	246	finally
  }
  
  @KeepForSdk
  public boolean isHeld() {
    return this.zzb.isHeld();
  }
  
  @KeepForSdk
  public void release() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzm : Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: invokevirtual decrementAndGet : ()I
    //   7: ifge -> 29
    //   10: ldc 'WakeLock'
    //   12: aload_0
    //   13: getfield zze : Ljava/lang/String;
    //   16: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   19: ldc_w ' release without a matched acquire!'
    //   22: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: aconst_null
    //   31: invokespecial zza : (Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_1
    //   35: aload_0
    //   36: getfield zza : Ljava/lang/Object;
    //   39: astore_2
    //   40: aload_2
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield zzi : Z
    //   46: ifeq -> 122
    //   49: aload_0
    //   50: getfield zzj : Ljava/util/Map;
    //   53: aload_1
    //   54: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast [Ljava/lang/Integer;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnonnull -> 73
    //   67: iconst_0
    //   68: istore #4
    //   70: goto -> 117
    //   73: aload_3
    //   74: iconst_0
    //   75: aaload
    //   76: invokevirtual intValue : ()I
    //   79: iconst_1
    //   80: if_icmpne -> 100
    //   83: aload_0
    //   84: getfield zzj : Ljava/util/Map;
    //   87: aload_1
    //   88: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: iconst_1
    //   95: istore #4
    //   97: goto -> 117
    //   100: aload_3
    //   101: iconst_0
    //   102: aload_3
    //   103: iconst_0
    //   104: aaload
    //   105: invokevirtual intValue : ()I
    //   108: iconst_1
    //   109: isub
    //   110: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   113: aastore
    //   114: iconst_0
    //   115: istore #4
    //   117: iload #4
    //   119: ifne -> 137
    //   122: aload_0
    //   123: getfield zzi : Z
    //   126: ifne -> 181
    //   129: aload_0
    //   130: getfield zzl : I
    //   133: iconst_1
    //   134: if_icmpne -> 181
    //   137: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/WakeLockTracker;
    //   140: aload_0
    //   141: getfield zzh : Landroid/content/Context;
    //   144: aload_0
    //   145: getfield zzb : Landroid/os/PowerManager$WakeLock;
    //   148: aload_1
    //   149: invokestatic getEventKey : (Landroid/os/PowerManager$WakeLock;Ljava/lang/String;)Ljava/lang/String;
    //   152: bipush #8
    //   154: aload_0
    //   155: getfield zze : Ljava/lang/String;
    //   158: aload_1
    //   159: aconst_null
    //   160: aload_0
    //   161: getfield zzd : I
    //   164: aload_0
    //   165: invokespecial zza : ()Ljava/util/List;
    //   168: invokevirtual registerEvent : (Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V
    //   171: aload_0
    //   172: aload_0
    //   173: getfield zzl : I
    //   176: iconst_1
    //   177: isub
    //   178: putfield zzl : I
    //   181: aload_2
    //   182: monitorexit
    //   183: aload_0
    //   184: iconst_0
    //   185: invokespecial zza : (I)V
    //   188: return
    //   189: astore_1
    //   190: aload_2
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    // Exception table:
    //   from	to	target	type
    //   42	63	189	finally
    //   73	94	189	finally
    //   100	114	189	finally
    //   122	137	189	finally
    //   137	181	189	finally
    //   181	183	189	finally
    //   190	192	189	finally
  }
  
  @KeepForSdk
  public void setReferenceCounted(boolean paramBoolean) {
    this.zzb.setReferenceCounted(paramBoolean);
    this.zzi = paramBoolean;
  }
  
  public static interface zza {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\stats\WakeLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */