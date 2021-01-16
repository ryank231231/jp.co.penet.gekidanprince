package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;

public final class zza extends zze {
  private final Map<String, Long> zzby = (Map<String, Long>)new ArrayMap();
  
  private final Map<String, Integer> zzbz = (Map<String, Integer>)new ArrayMap();
  
  private long zzca;
  
  public zza(zzby paramzzby) {
    super(paramzzby);
  }
  
  @WorkerThread
  private final void zza(long paramLong, zzec paramzzec) {
    if (paramzzec == null) {
      super.zzad().zzdi().zzaq("Not logging ad exposure. No active activity");
      return;
    } 
    if (paramLong < 1000L) {
      super.zzad().zzdi().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    } 
    Bundle bundle = new Bundle();
    bundle.putLong("_xt", paramLong);
    zzed.zza(paramzzec, bundle, true);
    super.zzs().logEvent("am", "_xa", bundle);
  }
  
  @WorkerThread
  private final void zza(String paramString, long paramLong) {
    super.zzo();
    super.zzq();
    Preconditions.checkNotEmpty(paramString);
    if (this.zzbz.isEmpty())
      this.zzca = paramLong; 
    Integer integer = this.zzbz.get(paramString);
    if (integer != null) {
      this.zzbz.put(paramString, Integer.valueOf(integer.intValue() + 1));
      return;
    } 
    if (this.zzbz.size() >= 100) {
      super.zzad().zzdd().zzaq("Too many ads visible");
      return;
    } 
    this.zzbz.put(paramString, Integer.valueOf(1));
    this.zzby.put(paramString, Long.valueOf(paramLong));
  }
  
  @WorkerThread
  private final void zza(String paramString, long paramLong, zzec paramzzec) {
    if (paramzzec == null) {
      super.zzad().zzdi().zzaq("Not logging ad unit exposure. No active activity");
      return;
    } 
    if (paramLong < 1000L) {
      super.zzad().zzdi().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    } 
    Bundle bundle = new Bundle();
    bundle.putString("_ai", paramString);
    bundle.putLong("_xt", paramLong);
    zzed.zza(paramzzec, bundle, true);
    super.zzs().logEvent("am", "_xu", bundle);
  }
  
  @WorkerThread
  private final void zzb(String paramString, long paramLong) {
    super.zzo();
    super.zzq();
    Preconditions.checkNotEmpty(paramString);
    Integer integer = this.zzbz.get(paramString);
    if (integer != null) {
      zzec zzec = super.zzv().zzfc();
      int i = integer.intValue() - 1;
      if (i == 0) {
        this.zzbz.remove(paramString);
        Long long_ = this.zzby.get(paramString);
        if (long_ == null) {
          super.zzad().zzda().zzaq("First ad unit exposure time was never set");
        } else {
          long l = long_.longValue();
          this.zzby.remove(paramString);
          zza(paramString, paramLong - l, zzec);
        } 
        if (this.zzbz.isEmpty()) {
          long l = this.zzca;
          if (l == 0L) {
            super.zzad().zzda().zzaq("First ad exposure time was never set");
            return;
          } 
          zza(paramLong - l, zzec);
          this.zzca = 0L;
        } 
        return;
      } 
      this.zzbz.put(paramString, Integer.valueOf(i));
      return;
    } 
    super.zzad().zzda().zza("Call to endAdUnitExposure for unknown ad unit id", paramString);
  }
  
  @WorkerThread
  private final void zzd(long paramLong) {
    for (String str : this.zzby.keySet())
      this.zzby.put(str, Long.valueOf(paramLong)); 
    if (!this.zzby.isEmpty())
      this.zzca = paramLong; 
  }
  
  public final void beginAdUnitExposure(String paramString, long paramLong) {
    if (paramString == null || paramString.length() == 0) {
      super.zzad().zzda().zzaq("Ad unit id must be a non-empty string");
      return;
    } 
    super.zzac().zza(new zzb(this, paramString, paramLong));
  }
  
  public final void endAdUnitExposure(String paramString, long paramLong) {
    if (paramString == null || paramString.length() == 0) {
      super.zzad().zzda().zzaq("Ad unit id must be a non-empty string");
      return;
    } 
    super.zzac().zza(new zzc(this, paramString, paramLong));
  }
  
  @WorkerThread
  public final void zzc(long paramLong) {
    zzec zzec = super.zzv().zzfc();
    for (String str : this.zzby.keySet())
      zza(str, paramLong - ((Long)this.zzby.get(str)).longValue(), zzec); 
    if (!this.zzby.isEmpty())
      zza(paramLong - this.zzca, zzec); 
    zzd(paramLong);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */