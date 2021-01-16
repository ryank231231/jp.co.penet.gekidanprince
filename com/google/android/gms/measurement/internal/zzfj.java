package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzfj extends zzf {
  private Handler handler;
  
  @VisibleForTesting
  private long zzrk = super.zzz().elapsedRealtime();
  
  @VisibleForTesting
  private long zzrl = this.zzrk;
  
  private final zzab zzrm = new zzfk(this, this.zzl);
  
  private final zzab zzrn = new zzfl(this, this.zzl);
  
  zzfj(zzby paramzzby) {
    super(paramzzby);
  }
  
  @WorkerThread
  private final void zzaa(long paramLong) {
    super.zzq();
    zzfn();
    if (super.zzaf().zze(super.zzt().zzan(), zzal.zzih))
      (super.zzae()).zzlv.set(false); 
    super.zzad().zzdi().zza("Activity resumed, time", Long.valueOf(paramLong));
    this.zzrk = paramLong;
    this.zzrl = this.zzrk;
    if (super.zzaf().zzaa(super.zzt().zzan())) {
      zzab(super.zzz().currentTimeMillis());
      return;
    } 
    this.zzrm.cancel();
    this.zzrn.cancel();
    if (super.zzae().zzx(super.zzz().currentTimeMillis())) {
      (super.zzae()).zzlo.set(true);
      (super.zzae()).zzlt.set(0L);
    } 
    if ((super.zzae()).zzlo.get()) {
      this.zzrm.zzv(Math.max(0L, (super.zzae()).zzlm.get() - (super.zzae()).zzlt.get()));
      return;
    } 
    this.zzrn.zzv(Math.max(0L, 3600000L - (super.zzae()).zzlt.get()));
  }
  
  @WorkerThread
  private final void zzac(long paramLong) {
    super.zzq();
    zzfn();
    if (super.zzaf().zze(super.zzt().zzan(), zzal.zzih))
      (super.zzae()).zzlv.set(true); 
    this.zzrm.cancel();
    this.zzrn.cancel();
    super.zzad().zzdi().zza("Activity paused, time", Long.valueOf(paramLong));
    if (this.zzrk != 0L)
      (super.zzae()).zzlt.set((super.zzae()).zzlt.get() + paramLong - this.zzrk); 
  }
  
  @WorkerThread
  private final void zzad(long paramLong) {
    Long long_;
    super.zzq();
    long l = super.zzz().elapsedRealtime();
    super.zzad().zzdi().zza("Session started, time", Long.valueOf(l));
    if (super.zzaf().zzy(super.zzt().zzan())) {
      long_ = Long.valueOf(paramLong / 1000L);
    } else {
      long_ = null;
    } 
    super.zzs().zza("auto", "_sid", long_, paramLong);
    (super.zzae()).zzlo.set(false);
    Bundle bundle = new Bundle();
    if (super.zzaf().zzy(super.zzt().zzan()))
      bundle.putLong("_sid", long_.longValue()); 
    super.zzs().zza("auto", "_s", paramLong, bundle);
    (super.zzae()).zzls.set(paramLong);
  }
  
  private final void zzfn() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield handler : Landroid/os/Handler;
    //   6: ifnonnull -> 25
    //   9: new com/google/android/gms/internal/measurement/zzk
    //   12: astore_1
    //   13: aload_1
    //   14: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   17: invokespecial <init> : (Landroid/os/Looper;)V
    //   20: aload_0
    //   21: aload_1
    //   22: putfield handler : Landroid/os/Handler;
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	28	finally
    //   25	27	28	finally
    //   29	31	28	finally
  }
  
  @WorkerThread
  private final void zzfr() {
    super.zzq();
    zza(false, false);
    super.zzr().zzc(super.zzz().elapsedRealtime());
  }
  
  @WorkerThread
  final void zza(long paramLong, boolean paramBoolean) {
    super.zzq();
    zzfn();
    this.zzrm.cancel();
    this.zzrn.cancel();
    if (super.zzae().zzx(paramLong)) {
      (super.zzae()).zzlo.set(true);
      (super.zzae()).zzlt.set(0L);
    } 
    if (paramBoolean && super.zzaf().zzab(super.zzt().zzan()))
      (super.zzae()).zzls.set(paramLong); 
    if ((super.zzae()).zzlo.get()) {
      zzad(paramLong);
      return;
    } 
    this.zzrn.zzv(Math.max(0L, 3600000L - (super.zzae()).zzlt.get()));
  }
  
  @WorkerThread
  public final boolean zza(boolean paramBoolean1, boolean paramBoolean2) {
    super.zzq();
    zzah();
    long l1 = super.zzz().elapsedRealtime();
    (super.zzae()).zzls.set(super.zzz().currentTimeMillis());
    long l2 = l1 - this.zzrk;
    if (!paramBoolean1 && l2 < 1000L) {
      super.zzad().zzdi().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(l2));
      return false;
    } 
    (super.zzae()).zzlt.set(l2);
    super.zzad().zzdi().zza("Recording user engagement, ms", Long.valueOf(l2));
    Bundle bundle = new Bundle();
    bundle.putLong("_et", l2);
    zzed.zza(super.zzv().zzfc(), bundle, true);
    if (super.zzaf().zzac(super.zzt().zzan()))
      if (super.zzaf().zze(super.zzt().zzan(), zzal.zzim)) {
        if (!paramBoolean2)
          zzfq(); 
      } else if (paramBoolean2) {
        bundle.putLong("_fr", 1L);
      } else {
        zzfq();
      }  
    if (!super.zzaf().zze(super.zzt().zzan(), zzal.zzim) || !paramBoolean2)
      super.zzs().logEvent("auto", "_e", bundle); 
    this.zzrk = l1;
    this.zzrn.cancel();
    this.zzrn.zzv(Math.max(0L, 3600000L - (super.zzae()).zzlt.get()));
    return true;
  }
  
  @WorkerThread
  final void zzab(long paramLong) {
    super.zzq();
    zzfn();
    zza(paramLong, false);
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  @WorkerThread
  final void zzfo() {
    super.zzq();
    this.zzrm.cancel();
    this.zzrn.cancel();
    this.zzrk = 0L;
    this.zzrl = this.zzrk;
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final void zzfp() {
    super.zzq();
    zzad(super.zzz().currentTimeMillis());
  }
  
  @WorkerThread
  @VisibleForTesting
  final long zzfq() {
    long l1 = super.zzz().elapsedRealtime();
    long l2 = this.zzrl;
    this.zzrl = l1;
    return l1 - l2;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */