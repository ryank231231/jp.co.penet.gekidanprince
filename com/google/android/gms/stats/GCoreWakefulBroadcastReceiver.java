package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.WakeLockTracker;

@KeepForSdk
@ShowFirstParty
public abstract class GCoreWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
  private static String TAG = "GCoreWakefulBroadcastReceiver";
  
  @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
  @KeepForSdk
  public static boolean completeWakefulIntent(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return false; 
    if (paramContext != null) {
      WakeLockTracker.getInstance().registerReleaseEvent(paramContext, paramIntent);
    } else {
      String str2 = TAG;
      String str1 = String.valueOf(paramIntent.toUri(0));
      if (str1.length() != 0) {
        str1 = "context shouldn't be null. intent: ".concat(str1);
      } else {
        str1 = new String("context shouldn't be null. intent: ");
      } 
      Log.w(str2, str1);
    } 
    return WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\stats\GCoreWakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */