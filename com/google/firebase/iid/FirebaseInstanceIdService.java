package com.google.firebase.iid;

import android.content.Intent;
import android.support.annotation.WorkerThread;
import android.util.Log;

@Deprecated
public class FirebaseInstanceIdService extends zzb {
  @Deprecated
  @WorkerThread
  public void onTokenRefresh() {}
  
  protected final Intent zzb(Intent paramIntent) {
    return (zzav.zzai()).zzdc.poll();
  }
  
  public final void zzd(Intent paramIntent) {
    if ("com.google.firebase.iid.TOKEN_REFRESH".equals(paramIntent.getAction())) {
      onTokenRefresh();
      return;
    } 
    String str = paramIntent.getStringExtra("CMD");
    if (str != null) {
      if (Log.isLoggable("FirebaseInstanceId", 3)) {
        String str1 = String.valueOf(paramIntent.getExtras());
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str1).length());
        stringBuilder.append("Received command: ");
        stringBuilder.append(str);
        stringBuilder.append(" - ");
        stringBuilder.append(str1);
        Log.d("FirebaseInstanceId", stringBuilder.toString());
      } 
      if ("RST".equals(str) || "RST_FULL".equals(str)) {
        FirebaseInstanceId.getInstance().zzn();
        return;
      } 
      if ("SYNC".equals(str))
        FirebaseInstanceId.getInstance().zzp(); 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\FirebaseInstanceIdService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */