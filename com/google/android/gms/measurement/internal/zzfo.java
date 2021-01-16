package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzfo {
  private long startTime;
  
  private final Clock zzaa;
  
  public zzfo(Clock paramClock) {
    Preconditions.checkNotNull(paramClock);
    this.zzaa = paramClock;
  }
  
  public final void clear() {
    this.startTime = 0L;
  }
  
  public final void start() {
    this.startTime = this.zzaa.elapsedRealtime();
  }
  
  public final boolean zzae(long paramLong) {
    return (this.startTime == 0L) ? true : ((this.zzaa.elapsedRealtime() - this.startTime >= 3600000L));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */