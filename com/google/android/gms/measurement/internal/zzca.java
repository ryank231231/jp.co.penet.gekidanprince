package com.google.android.gms.measurement.internal;

import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzca extends zzan {
  private final zzft zzkt;
  
  private Boolean zzoq;
  
  @Nullable
  private String zzor;
  
  public zzca(zzft paramzzft) {
    this(paramzzft, null);
  }
  
  private zzca(zzft paramzzft, @Nullable String paramString) {
    Preconditions.checkNotNull(paramzzft);
    this.zzkt = paramzzft;
    this.zzor = null;
  }
  
  @BinderThread
  private final void zza(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 179
    //   7: iload_2
    //   8: ifeq -> 93
    //   11: aload_0
    //   12: getfield zzoq : Ljava/lang/Boolean;
    //   15: ifnonnull -> 83
    //   18: ldc 'com.google.android.gms'
    //   20: aload_0
    //   21: getfield zzor : Ljava/lang/String;
    //   24: invokevirtual equals : (Ljava/lang/Object;)Z
    //   27: ifne -> 73
    //   30: aload_0
    //   31: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   34: invokevirtual getContext : ()Landroid/content/Context;
    //   37: invokestatic getCallingUid : ()I
    //   40: invokestatic isGooglePlayServicesUid : (Landroid/content/Context;I)Z
    //   43: ifne -> 73
    //   46: aload_0
    //   47: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   50: invokevirtual getContext : ()Landroid/content/Context;
    //   53: invokestatic getInstance : (Landroid/content/Context;)Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   56: invokestatic getCallingUid : ()I
    //   59: invokevirtual isUidGoogleSigned : (I)Z
    //   62: ifeq -> 68
    //   65: goto -> 73
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -> 75
    //   73: iconst_1
    //   74: istore_2
    //   75: aload_0
    //   76: iload_2
    //   77: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   80: putfield zzoq : Ljava/lang/Boolean;
    //   83: aload_0
    //   84: getfield zzoq : Ljava/lang/Boolean;
    //   87: invokevirtual booleanValue : ()Z
    //   90: ifne -> 133
    //   93: aload_0
    //   94: getfield zzor : Ljava/lang/String;
    //   97: ifnonnull -> 122
    //   100: aload_0
    //   101: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   104: invokevirtual getContext : ()Landroid/content/Context;
    //   107: invokestatic getCallingUid : ()I
    //   110: aload_1
    //   111: invokestatic uidHasPackageName : (Landroid/content/Context;ILjava/lang/String;)Z
    //   114: ifeq -> 122
    //   117: aload_0
    //   118: aload_1
    //   119: putfield zzor : Ljava/lang/String;
    //   122: aload_1
    //   123: aload_0
    //   124: getfield zzor : Ljava/lang/String;
    //   127: invokevirtual equals : (Ljava/lang/Object;)Z
    //   130: ifeq -> 134
    //   133: return
    //   134: new java/lang/SecurityException
    //   137: astore_3
    //   138: aload_3
    //   139: ldc 'Unknown calling package name '%s'.'
    //   141: iconst_1
    //   142: anewarray java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokespecial <init> : (Ljava/lang/String;)V
    //   155: aload_3
    //   156: athrow
    //   157: astore_3
    //   158: aload_0
    //   159: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   162: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   165: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   168: ldc 'Measurement Service called with invalid calling package. appId'
    //   170: aload_1
    //   171: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   174: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   177: aload_3
    //   178: athrow
    //   179: aload_0
    //   180: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   183: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   186: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   189: ldc 'Measurement Service called without app package'
    //   191: invokevirtual zzaq : (Ljava/lang/String;)V
    //   194: new java/lang/SecurityException
    //   197: dup
    //   198: ldc 'Measurement Service called without app package'
    //   200: invokespecial <init> : (Ljava/lang/String;)V
    //   203: athrow
    // Exception table:
    //   from	to	target	type
    //   11	65	157	java/lang/SecurityException
    //   75	83	157	java/lang/SecurityException
    //   83	93	157	java/lang/SecurityException
    //   93	122	157	java/lang/SecurityException
    //   122	133	157	java/lang/SecurityException
    //   134	157	157	java/lang/SecurityException
  }
  
  @BinderThread
  private final void zzb(zzm paramzzm, boolean paramBoolean) {
    Preconditions.checkNotNull(paramzzm);
    zza(paramzzm.packageName, false);
    this.zzkt.zzab().zzr(paramzzm.zzch, paramzzm.zzcv);
  }
  
  @VisibleForTesting
  private final void zzc(Runnable paramRunnable) {
    Preconditions.checkNotNull(paramRunnable);
    if (((Boolean)zzal.zzhw.get(null)).booleanValue() && this.zzkt.zzac().zzef()) {
      paramRunnable.run();
      return;
    } 
    this.zzkt.zzac().zza(paramRunnable);
  }
  
  @BinderThread
  public final List<zzga> zza(zzm paramzzm, boolean paramBoolean) {
    zzb(paramzzm, false);
    Future<?> future = this.zzkt.zzac().zza(new zzcq(this, paramzzm));
    try {
      List list = (List)future.get();
      ArrayList<zzga> arrayList = new ArrayList();
      this(list.size());
      for (zzgc zzgc : list) {
        if (paramBoolean || !zzgd.zzbs(zzgc.name)) {
          zzga zzga = new zzga();
          this(zzgc);
          arrayList.add(zzga);
        } 
      } 
      return arrayList;
    } catch (InterruptedException interruptedException) {
    
    } catch (ExecutionException executionException) {}
    this.zzkt.zzad().zzda().zza("Failed to get user attributes. appId", zzau.zzao(paramzzm.packageName), executionException);
    return null;
  }
  
  @BinderThread
  public final List<zzr> zza(String paramString1, String paramString2, zzm paramzzm) {
    zzb(paramzzm, false);
    Future<?> future = this.zzkt.zzac().zza(new zzci(this, paramzzm, paramString1, paramString2));
    try {
      return (List)future.get();
    } catch (InterruptedException interruptedException) {
    
    } catch (ExecutionException executionException) {}
    this.zzkt.zzad().zzda().zza("Failed to get conditional user properties", executionException);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final List<zzga> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    zza(paramString1, true);
    Future<?> future = this.zzkt.zzac().zza(new zzch(this, paramString1, paramString2, paramString3));
    try {
      List list = (List)future.get();
      ArrayList<zzga> arrayList = new ArrayList();
      this(list.size());
      for (zzgc zzgc : list) {
        if (paramBoolean || !zzgd.zzbs(zzgc.name)) {
          zzga zzga = new zzga();
          this(zzgc);
          arrayList.add(zzga);
        } 
      } 
      return arrayList;
    } catch (InterruptedException interruptedException) {
    
    } catch (ExecutionException executionException) {}
    this.zzkt.zzad().zzda().zza("Failed to get user attributes. appId", zzau.zzao(paramString1), executionException);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final List<zzga> zza(String paramString1, String paramString2, boolean paramBoolean, zzm paramzzm) {
    zzb(paramzzm, false);
    Future<?> future = this.zzkt.zzac().zza(new zzcg(this, paramzzm, paramString1, paramString2));
    try {
      List list = (List)future.get();
      ArrayList<zzga> arrayList = new ArrayList();
      this(list.size());
      for (zzgc zzgc : list) {
        if (paramBoolean || !zzgd.zzbs(zzgc.name)) {
          zzga zzga = new zzga();
          this(zzgc);
          arrayList.add(zzga);
        } 
      } 
      return arrayList;
    } catch (InterruptedException interruptedException) {
    
    } catch (ExecutionException executionException) {}
    this.zzkt.zzad().zzda().zza("Failed to get user attributes. appId", zzau.zzao(paramzzm.packageName), executionException);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3) {
    zzc(new zzcs(this, paramString2, paramString3, paramString1, paramLong));
  }
  
  @BinderThread
  public final void zza(zzaj paramzzaj, zzm paramzzm) {
    Preconditions.checkNotNull(paramzzaj);
    zzb(paramzzm, false);
    zzc(new zzcl(this, paramzzaj, paramzzm));
  }
  
  @BinderThread
  public final void zza(zzaj paramzzaj, String paramString1, String paramString2) {
    Preconditions.checkNotNull(paramzzaj);
    Preconditions.checkNotEmpty(paramString1);
    zza(paramString1, true);
    zzc(new zzcm(this, paramzzaj, paramString1));
  }
  
  @BinderThread
  public final void zza(zzga paramzzga, zzm paramzzm) {
    Preconditions.checkNotNull(paramzzga);
    zzb(paramzzm, false);
    if (paramzzga.getValue() == null) {
      zzc(new zzco(this, paramzzga, paramzzm));
      return;
    } 
    zzc(new zzcp(this, paramzzga, paramzzm));
  }
  
  @BinderThread
  public final void zza(zzm paramzzm) {
    zzb(paramzzm, false);
    zzc(new zzcr(this, paramzzm));
  }
  
  @BinderThread
  public final void zza(zzr paramzzr, zzm paramzzm) {
    Preconditions.checkNotNull(paramzzr);
    Preconditions.checkNotNull(paramzzr.zzdv);
    zzb(paramzzm, false);
    zzr zzr1 = new zzr(paramzzr);
    zzr1.packageName = paramzzm.packageName;
    if (paramzzr.zzdv.getValue() == null) {
      zzc(new zzcc(this, zzr1, paramzzm));
      return;
    } 
    zzc(new zzcd(this, zzr1, paramzzm));
  }
  
  @BinderThread
  public final byte[] zza(zzaj paramzzaj, String paramString) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzaj);
    zza(paramString, true);
    this.zzkt.zzad().zzdh().zza("Log and bundle. event", this.zzkt.zzaa().zzal(paramzzaj.name));
    long l = this.zzkt.zzz().nanoTime() / 1000000L;
    Future<?> future = this.zzkt.zzac().zzb(new zzcn(this, paramzzaj, paramString));
    try {
      byte[] arrayOfByte2 = (byte[])future.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        this.zzkt.zzad().zzda().zza("Log and bundle returned null. appId", zzau.zzao(paramString));
        arrayOfByte1 = new byte[0];
      } 
      long l1 = this.zzkt.zzz().nanoTime() / 1000000L;
      this.zzkt.zzad().zzdh().zza("Log and bundle processed. event, size, time_ms", this.zzkt.zzaa().zzal(paramzzaj.name), Integer.valueOf(arrayOfByte1.length), Long.valueOf(l1 - l));
      return arrayOfByte1;
    } catch (InterruptedException interruptedException) {
    
    } catch (ExecutionException executionException) {}
    this.zzkt.zzad().zzda().zza("Failed to log and bundle. appId, event, error", zzau.zzao(paramString), this.zzkt.zzaa().zzal(paramzzaj.name), executionException);
    return null;
  }
  
  @VisibleForTesting
  final zzaj zzb(zzaj paramzzaj, zzm paramzzm) {
    // Byte code:
    //   0: ldc_w '_cmp'
    //   3: aload_1
    //   4: getfield name : Ljava/lang/String;
    //   7: invokevirtual equals : (Ljava/lang/Object;)Z
    //   10: istore_3
    //   11: iconst_0
    //   12: istore #4
    //   14: iload #4
    //   16: istore #5
    //   18: iload_3
    //   19: ifeq -> 124
    //   22: iload #4
    //   24: istore #5
    //   26: aload_1
    //   27: getfield zzfd : Lcom/google/android/gms/measurement/internal/zzag;
    //   30: ifnull -> 124
    //   33: aload_1
    //   34: getfield zzfd : Lcom/google/android/gms/measurement/internal/zzag;
    //   37: invokevirtual size : ()I
    //   40: ifne -> 50
    //   43: iload #4
    //   45: istore #5
    //   47: goto -> 124
    //   50: aload_1
    //   51: getfield zzfd : Lcom/google/android/gms/measurement/internal/zzag;
    //   54: ldc_w '_cis'
    //   57: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   60: astore #6
    //   62: iload #4
    //   64: istore #5
    //   66: aload #6
    //   68: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   71: ifne -> 124
    //   74: ldc_w 'referrer broadcast'
    //   77: aload #6
    //   79: invokevirtual equals : (Ljava/lang/Object;)Z
    //   82: ifne -> 100
    //   85: iload #4
    //   87: istore #5
    //   89: ldc_w 'referrer API'
    //   92: aload #6
    //   94: invokevirtual equals : (Ljava/lang/Object;)Z
    //   97: ifeq -> 124
    //   100: iload #4
    //   102: istore #5
    //   104: aload_0
    //   105: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   108: invokevirtual zzaf : ()Lcom/google/android/gms/measurement/internal/zzt;
    //   111: aload_2
    //   112: getfield packageName : Ljava/lang/String;
    //   115: invokevirtual zzw : (Ljava/lang/String;)Z
    //   118: ifeq -> 124
    //   121: iconst_1
    //   122: istore #5
    //   124: iload #5
    //   126: ifeq -> 172
    //   129: aload_0
    //   130: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   133: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   136: invokevirtual zzdg : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   139: ldc_w 'Event has been filtered '
    //   142: aload_1
    //   143: invokevirtual toString : ()Ljava/lang/String;
    //   146: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   149: new com/google/android/gms/measurement/internal/zzaj
    //   152: dup
    //   153: ldc_w '_cmpx'
    //   156: aload_1
    //   157: getfield zzfd : Lcom/google/android/gms/measurement/internal/zzag;
    //   160: aload_1
    //   161: getfield origin : Ljava/lang/String;
    //   164: aload_1
    //   165: getfield zzfp : J
    //   168: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzag;Ljava/lang/String;J)V
    //   171: areturn
    //   172: aload_1
    //   173: areturn
  }
  
  @BinderThread
  public final void zzb(zzm paramzzm) {
    zzb(paramzzm, false);
    zzc(new zzcb(this, paramzzm));
  }
  
  @BinderThread
  public final void zzb(zzr paramzzr) {
    Preconditions.checkNotNull(paramzzr);
    Preconditions.checkNotNull(paramzzr.zzdv);
    zza(paramzzr.packageName, true);
    zzr zzr1 = new zzr(paramzzr);
    if (paramzzr.zzdv.getValue() == null) {
      zzc(new zzce(this, zzr1));
      return;
    } 
    zzc(new zzcf(this, zzr1));
  }
  
  @BinderThread
  public final String zzc(zzm paramzzm) {
    zzb(paramzzm, false);
    return this.zzkt.zzh(paramzzm);
  }
  
  @BinderThread
  public final List<zzr> zzd(String paramString1, String paramString2, String paramString3) {
    zza(paramString1, true);
    Future<?> future = this.zzkt.zzac().zza(new zzcj(this, paramString1, paramString2, paramString3));
    try {
      return (List)future.get();
    } catch (InterruptedException interruptedException) {
    
    } catch (ExecutionException executionException) {}
    this.zzkt.zzad().zzda().zza("Failed to get conditional user properties", executionException);
    return Collections.emptyList();
  }
  
  @BinderThread
  public final void zzd(zzm paramzzm) {
    zza(paramzzm.packageName, false);
    zzc(new zzck(this, paramzzm));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */