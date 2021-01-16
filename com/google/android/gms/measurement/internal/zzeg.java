package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzeg extends zzf {
  private final zzey zzqj;
  
  private zzam zzqk;
  
  private volatile Boolean zzql;
  
  private final zzab zzqm;
  
  private final zzfo zzqn;
  
  private final List<Runnable> zzqo = new ArrayList<Runnable>();
  
  private final zzab zzqp;
  
  protected zzeg(zzby paramzzby) {
    super(paramzzby);
    this.zzqn = new zzfo(paramzzby.zzz());
    this.zzqj = new zzey(this);
    this.zzqm = new zzeh(this, paramzzby);
    this.zzqp = new zzeq(this, paramzzby);
  }
  
  @WorkerThread
  private final void onServiceDisconnected(ComponentName paramComponentName) {
    super.zzq();
    if (this.zzqk != null) {
      this.zzqk = null;
      super.zzad().zzdi().zza("Disconnected from device MeasurementService", paramComponentName);
      super.zzq();
      zzfh();
    } 
  }
  
  @WorkerThread
  private final void zzd(Runnable paramRunnable) throws IllegalStateException {
    super.zzq();
    if (isConnected()) {
      paramRunnable.run();
      return;
    } 
    if (this.zzqo.size() >= 1000L) {
      super.zzad().zzda().zzaq("Discarding data. Max runnable queue size reached");
      return;
    } 
    this.zzqo.add(paramRunnable);
    this.zzqp.zzv(60000L);
    zzfh();
  }
  
  private final boolean zzff() {
    super.zzag();
    return true;
  }
  
  @WorkerThread
  private final void zzfg() {
    super.zzq();
    this.zzqn.start();
    this.zzqm.zzv(((Long)zzal.zzhj.get(null)).longValue());
  }
  
  @WorkerThread
  private final void zzfj() {
    super.zzq();
    if (!isConnected())
      return; 
    super.zzad().zzdi().zzaq("Inactivity, disconnecting from the service");
    disconnect();
  }
  
  @WorkerThread
  private final void zzfk() {
    super.zzq();
    super.zzad().zzdi().zza("Processing queued up service tasks", Integer.valueOf(this.zzqo.size()));
    for (Runnable runnable : this.zzqo) {
      try {
        runnable.run();
      } catch (Exception exception) {
        super.zzad().zzda().zza("Task exception while flushing queue", exception);
      } 
    } 
    this.zzqo.clear();
    this.zzqp.cancel();
  }
  
  @Nullable
  @WorkerThread
  private final zzm zzi(boolean paramBoolean) {
    String str;
    super.zzag();
    zzap zzap = super.zzt();
    if (paramBoolean) {
      str = super.zzad().zzdk();
    } else {
      str = null;
    } 
    return zzap.zzak(str);
  }
  
  @WorkerThread
  public final void disconnect() {
    super.zzq();
    zzah();
    this.zzqj.zzfl();
    try {
      ConnectionTracker.getInstance().unbindService(super.getContext(), this.zzqj);
    } catch (IllegalStateException|IllegalArgumentException illegalStateException) {}
    this.zzqk = null;
  }
  
  @WorkerThread
  public final void getAppInstanceId(zzq paramzzq) {
    super.zzq();
    zzah();
    zzd(new zzem(this, zzi(false), paramzzq));
  }
  
  @WorkerThread
  public final boolean isConnected() {
    super.zzq();
    zzah();
    return (this.zzqk != null);
  }
  
  @WorkerThread
  protected final void resetAnalyticsData() {
    super.zzq();
    super.zzo();
    zzah();
    zzm zzm = zzi(false);
    if (zzff())
      super.zzw().resetAnalyticsData(); 
    zzd(new zzek(this, zzm));
  }
  
  @WorkerThread
  public final void zza(zzq paramzzq, zzaj paramzzaj, String paramString) {
    super.zzq();
    zzah();
    if (super.zzab().zzd(12451000) != 0) {
      super.zzad().zzdd().zzaq("Not bundling data. Service unavailable or out of date");
      super.zzab().zza(paramzzq, new byte[0]);
      return;
    } 
    zzd(new zzep(this, paramzzaj, paramString, paramzzq));
  }
  
  @WorkerThread
  protected final void zza(zzq paramzzq, String paramString1, String paramString2) {
    super.zzq();
    zzah();
    zzd(new zzev(this, paramString1, paramString2, zzi(false), paramzzq));
  }
  
  @WorkerThread
  protected final void zza(zzq paramzzq, String paramString1, String paramString2, boolean paramBoolean) {
    super.zzq();
    zzah();
    zzd(new zzex(this, paramString1, paramString2, paramBoolean, zzi(false), paramzzq));
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final void zza(zzam paramzzam) {
    super.zzq();
    Preconditions.checkNotNull(paramzzam);
    this.zzqk = paramzzam;
    zzfg();
    zzfk();
  }
  
  @WorkerThread
  @VisibleForTesting
  final void zza(zzam paramzzam, AbstractSafeParcelable paramAbstractSafeParcelable, zzm paramzzm) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzq : ()V
    //   4: aload_0
    //   5: invokevirtual zzo : ()V
    //   8: aload_0
    //   9: invokevirtual zzah : ()V
    //   12: aload_0
    //   13: invokespecial zzff : ()Z
    //   16: istore #4
    //   18: iconst_0
    //   19: istore #5
    //   21: bipush #100
    //   23: istore #6
    //   25: iload #5
    //   27: sipush #1001
    //   30: if_icmpge -> 309
    //   33: iload #6
    //   35: bipush #100
    //   37: if_icmpne -> 309
    //   40: new java/util/ArrayList
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore #7
    //   49: iload #4
    //   51: ifeq -> 92
    //   54: aload_0
    //   55: invokevirtual zzw : ()Lcom/google/android/gms/measurement/internal/zzaq;
    //   58: bipush #100
    //   60: invokevirtual zzc : (I)Ljava/util/List;
    //   63: astore #8
    //   65: aload #8
    //   67: ifnull -> 92
    //   70: aload #7
    //   72: aload #8
    //   74: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   79: pop
    //   80: aload #8
    //   82: invokeinterface size : ()I
    //   87: istore #6
    //   89: goto -> 95
    //   92: iconst_0
    //   93: istore #6
    //   95: aload_2
    //   96: ifnull -> 115
    //   99: iload #6
    //   101: bipush #100
    //   103: if_icmpge -> 115
    //   106: aload #7
    //   108: aload_2
    //   109: invokeinterface add : (Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload #7
    //   117: checkcast java/util/ArrayList
    //   120: astore #8
    //   122: aload #8
    //   124: invokevirtual size : ()I
    //   127: istore #9
    //   129: iconst_0
    //   130: istore #10
    //   132: iload #10
    //   134: iload #9
    //   136: if_icmpge -> 303
    //   139: aload #8
    //   141: iload #10
    //   143: invokevirtual get : (I)Ljava/lang/Object;
    //   146: astore #7
    //   148: iinc #10, 1
    //   151: aload #7
    //   153: checkcast com/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable
    //   156: astore #7
    //   158: aload #7
    //   160: instanceof com/google/android/gms/measurement/internal/zzaj
    //   163: ifeq -> 201
    //   166: aload_1
    //   167: aload #7
    //   169: checkcast com/google/android/gms/measurement/internal/zzaj
    //   172: aload_3
    //   173: invokeinterface zza : (Lcom/google/android/gms/measurement/internal/zzaj;Lcom/google/android/gms/measurement/internal/zzm;)V
    //   178: goto -> 132
    //   181: astore #7
    //   183: aload_0
    //   184: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   187: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   190: ldc_w 'Failed to send event to the service'
    //   193: aload #7
    //   195: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   198: goto -> 132
    //   201: aload #7
    //   203: instanceof com/google/android/gms/measurement/internal/zzga
    //   206: ifeq -> 244
    //   209: aload_1
    //   210: aload #7
    //   212: checkcast com/google/android/gms/measurement/internal/zzga
    //   215: aload_3
    //   216: invokeinterface zza : (Lcom/google/android/gms/measurement/internal/zzga;Lcom/google/android/gms/measurement/internal/zzm;)V
    //   221: goto -> 132
    //   224: astore #7
    //   226: aload_0
    //   227: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   230: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   233: ldc_w 'Failed to send attribute to the service'
    //   236: aload #7
    //   238: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   241: goto -> 132
    //   244: aload #7
    //   246: instanceof com/google/android/gms/measurement/internal/zzr
    //   249: ifeq -> 287
    //   252: aload_1
    //   253: aload #7
    //   255: checkcast com/google/android/gms/measurement/internal/zzr
    //   258: aload_3
    //   259: invokeinterface zza : (Lcom/google/android/gms/measurement/internal/zzr;Lcom/google/android/gms/measurement/internal/zzm;)V
    //   264: goto -> 132
    //   267: astore #7
    //   269: aload_0
    //   270: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   273: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   276: ldc_w 'Failed to send conditional property to the service'
    //   279: aload #7
    //   281: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   284: goto -> 132
    //   287: aload_0
    //   288: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   291: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   294: ldc_w 'Discarding data. Unrecognized parcel type.'
    //   297: invokevirtual zzaq : (Ljava/lang/String;)V
    //   300: goto -> 132
    //   303: iinc #5, 1
    //   306: goto -> 25
    //   309: return
    // Exception table:
    //   from	to	target	type
    //   166	178	181	android/os/RemoteException
    //   209	221	224	android/os/RemoteException
    //   252	264	267	android/os/RemoteException
  }
  
  @WorkerThread
  protected final void zza(zzec paramzzec) {
    super.zzq();
    zzah();
    zzd(new zzeo(this, paramzzec));
  }
  
  @WorkerThread
  public final void zza(AtomicReference<String> paramAtomicReference) {
    super.zzq();
    zzah();
    zzd(new zzel(this, paramAtomicReference, zzi(false)));
  }
  
  @WorkerThread
  protected final void zza(AtomicReference<List<zzr>> paramAtomicReference, String paramString1, String paramString2, String paramString3) {
    super.zzq();
    zzah();
    zzd(new zzeu(this, paramAtomicReference, paramString1, paramString2, paramString3, zzi(false)));
  }
  
  @WorkerThread
  protected final void zza(AtomicReference<List<zzga>> paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    super.zzq();
    zzah();
    zzd(new zzew(this, paramAtomicReference, paramString1, paramString2, paramString3, paramBoolean, zzi(false)));
  }
  
  @WorkerThread
  protected final void zza(AtomicReference<List<zzga>> paramAtomicReference, boolean paramBoolean) {
    super.zzq();
    zzah();
    zzd(new zzej(this, paramAtomicReference, zzi(false), paramBoolean));
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  @WorkerThread
  protected final void zzb(zzga paramzzga) {
    boolean bool;
    super.zzq();
    zzah();
    if (zzff() && super.zzw().zza(paramzzga)) {
      bool = true;
    } else {
      bool = false;
    } 
    zzd(new zzei(this, bool, paramzzga, zzi(true)));
  }
  
  @WorkerThread
  protected final void zzc(zzaj paramzzaj, String paramString) {
    boolean bool1;
    Preconditions.checkNotNull(paramzzaj);
    super.zzq();
    zzah();
    boolean bool = zzff();
    if (bool && super.zzw().zza(paramzzaj)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    zzd(new zzes(this, bool, bool1, paramzzaj, zzi(true), paramString));
  }
  
  @WorkerThread
  protected final void zzd(zzr paramzzr) {
    boolean bool;
    Preconditions.checkNotNull(paramzzr);
    super.zzq();
    zzah();
    super.zzag();
    if (super.zzw().zzc(paramzzr)) {
      bool = true;
    } else {
      bool = false;
    } 
    zzd(new zzet(this, true, bool, new zzr(paramzzr), zzi(true), paramzzr));
  }
  
  @WorkerThread
  protected final void zzfb() {
    super.zzq();
    zzah();
    zzd(new zzen(this, zzi(true)));
  }
  
  @WorkerThread
  protected final void zzfe() {
    super.zzq();
    zzah();
    zzd(new zzer(this, zzi(true)));
  }
  
  @WorkerThread
  final void zzfh() {
    super.zzq();
    zzah();
    if (isConnected())
      return; 
    Boolean bool = this.zzql;
    boolean bool1 = false;
    if (bool == null) {
      boolean bool2;
      super.zzq();
      zzah();
      bool = super.zzae().zzdu();
      if (bool != null && bool.booleanValue()) {
        bool2 = true;
      } else {
        boolean bool3;
        int i;
        super.zzag();
        if (super.zzt().zzcy() == 1) {
          bool3 = true;
          i = 1;
        } else {
          super.zzad().zzdi().zzaq("Checking service availability");
          i = super.zzab().zzd(12451000);
          if (i != 9) {
            if (i != 18) {
              switch (i) {
                default:
                  super.zzad().zzdd().zza("Unexpected service status", Integer.valueOf(i));
                  bool3 = false;
                  i = 0;
                  break;
                case 3:
                  super.zzad().zzdd().zzaq("Service disabled");
                  bool3 = false;
                  i = 0;
                  break;
                case 2:
                  super.zzad().zzdh().zzaq("Service container out of date");
                  if (super.zzab().zzgm() < 15000) {
                    bool3 = false;
                    i = 1;
                    break;
                  } 
                  bool = super.zzae().zzdu();
                  if (bool == null || bool.booleanValue()) {
                    bool3 = true;
                  } else {
                    bool3 = false;
                  } 
                  i = 0;
                  break;
                case 1:
                  super.zzad().zzdi().zzaq("Service missing");
                  bool3 = false;
                  i = 1;
                  break;
                case 0:
                  super.zzad().zzdi().zzaq("Service available");
                  bool3 = true;
                  i = 1;
                  break;
              } 
            } else {
              super.zzad().zzdd().zzaq("Service updating");
              bool3 = true;
              i = 1;
            } 
          } else {
            super.zzad().zzdd().zzaq("Service invalid");
            bool3 = false;
            i = 0;
          } 
        } 
        int j = i;
        if (!bool3) {
          j = i;
          if (super.zzaf().zzbw()) {
            super.zzad().zzda().zzaq("No way to upload. Consider using the full version of Analytics");
            j = 0;
          } 
        } 
        bool2 = bool3;
        if (j != 0) {
          super.zzae().zzd(bool3);
          bool2 = bool3;
        } 
      } 
      this.zzql = Boolean.valueOf(bool2);
    } 
    if (this.zzql.booleanValue()) {
      this.zzqj.zzfm();
      return;
    } 
    if (!super.zzaf().zzbw()) {
      super.zzag();
      List list = super.getContext().getPackageManager().queryIntentServices((new Intent()).setClassName(super.getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
      boolean bool2 = bool1;
      if (list != null) {
        bool2 = bool1;
        if (list.size() > 0)
          bool2 = true; 
      } 
      if (bool2) {
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context context = super.getContext();
        super.zzag();
        intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
        this.zzqj.zzb(intent);
        return;
      } 
      super.zzad().zzda().zzaq("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    } 
  }
  
  final Boolean zzfi() {
    return this.zzql;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */