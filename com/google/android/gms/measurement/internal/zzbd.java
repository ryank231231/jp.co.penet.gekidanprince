package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

class zzbd extends BroadcastReceiver {
  @VisibleForTesting
  private static final String zzks = "com.google.android.gms.measurement.internal.zzbd";
  
  private final zzft zzkt;
  
  private boolean zzku;
  
  private boolean zzkv;
  
  zzbd(zzft paramzzft) {
    Preconditions.checkNotNull(paramzzft);
    this.zzkt = paramzzft;
  }
  
  @MainThread
  public void onReceive(Context paramContext, Intent paramIntent) {
    this.zzkt.zzfy();
    String str = paramIntent.getAction();
    this.zzkt.zzad().zzdi().zza("NetworkBroadcastReceiver received action", str);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
      boolean bool = this.zzkt.zzfu().zzdl();
      if (this.zzkv != bool) {
        this.zzkv = bool;
        this.zzkt.zzac().zza(new zzbe(this, bool));
      } 
      return;
    } 
    this.zzkt.zzad().zzdd().zza("NetworkBroadcastReceiver received unknown action", str);
  }
  
  @WorkerThread
  public final void unregister() {
    this.zzkt.zzfy();
    this.zzkt.zzac().zzq();
    this.zzkt.zzac().zzq();
    if (!this.zzku)
      return; 
    this.zzkt.zzad().zzdi().zzaq("Unregistering connectivity change receiver");
    this.zzku = false;
    this.zzkv = false;
    Context context = this.zzkt.getContext();
    try {
      context.unregisterReceiver(this);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      this.zzkt.zzad().zzda().zza("Failed to unregister the network broadcast receiver", illegalArgumentException);
      return;
    } 
  }
  
  @WorkerThread
  public final void zzdq() {
    this.zzkt.zzfy();
    this.zzkt.zzac().zzq();
    if (this.zzku)
      return; 
    this.zzkt.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.zzkv = this.zzkt.zzfu().zzdl();
    this.zzkt.zzad().zzdi().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzkv));
    this.zzku = true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */