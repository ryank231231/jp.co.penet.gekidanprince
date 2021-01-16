package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzbo;
import com.google.android.gms.measurement.internal.zzbr;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzbr {
  private zzbo zzo;
  
  public final BroadcastReceiver.PendingResult doGoAsync() {
    return goAsync();
  }
  
  @MainThread
  public final void doStartService(Context paramContext, Intent paramIntent) {
    startWakefulService(paramContext, paramIntent);
  }
  
  @MainThread
  public final void onReceive(Context paramContext, Intent paramIntent) {
    if (this.zzo == null)
      this.zzo = new zzbo(this); 
    this.zzo.onReceive(paramContext, paramIntent);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */