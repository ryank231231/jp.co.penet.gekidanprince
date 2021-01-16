package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzbo;
import com.google.android.gms.measurement.internal.zzbr;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzbr {
  private zzbo zzo;
  
  public final BroadcastReceiver.PendingResult doGoAsync() {
    return goAsync();
  }
  
  public final void doStartService(Context paramContext, Intent paramIntent) {}
  
  @MainThread
  public final void onReceive(Context paramContext, Intent paramIntent) {
    if (this.zzo == null)
      this.zzo = new zzbo(this); 
    this.zzo.onReceive(paramContext, paramIntent);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementInstallReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */