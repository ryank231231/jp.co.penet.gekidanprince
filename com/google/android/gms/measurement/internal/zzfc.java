package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzfc implements Runnable {
  zzfc(zzey paramzzey) {}
  
  public final void run() {
    zzeg zzeg = this.zzqz.zzqq;
    Context context = this.zzqz.zzqq.getContext();
    this.zzqz.zzqq.zzag();
    zzeg.zza(zzeg, new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */