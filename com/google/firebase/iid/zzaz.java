package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
final class zzaz extends BroadcastReceiver {
  @Nullable
  private zzay zzdm;
  
  public zzaz(zzay paramzzay) {
    this.zzdm = paramzzay;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    zzay zzay1 = this.zzdm;
    if (zzay1 == null)
      return; 
    if (!zzay1.zzan())
      return; 
    if (FirebaseInstanceId.zzm())
      Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync."); 
    FirebaseInstanceId.zza(this.zzdm, 0L);
    this.zzdm.getContext().unregisterReceiver(this);
    this.zzdm = null;
  }
  
  public final void zzao() {
    if (FirebaseInstanceId.zzm())
      Log.d("FirebaseInstanceId", "Connectivity change received registered"); 
    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.zzdm.getContext().registerReceiver(this, intentFilter);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */