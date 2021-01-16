package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

final class zzay implements Runnable {
  private final zzba zzas;
  
  private final long zzdj;
  
  private final PowerManager.WakeLock zzdk;
  
  private final FirebaseInstanceId zzdl;
  
  @VisibleForTesting
  zzay(FirebaseInstanceId paramFirebaseInstanceId, zzan paramzzan, zzba paramzzba, long paramLong) {
    this.zzdl = paramFirebaseInstanceId;
    this.zzas = paramzzba;
    this.zzdj = paramLong;
    this.zzdk = ((PowerManager)getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    this.zzdk.setReferenceCounted(false);
  }
  
  @VisibleForTesting
  private final boolean zzam() {
    zzax zzax = this.zzdl.zzk();
    if (!this.zzdl.zzr() && !this.zzdl.zza(zzax))
      return true; 
    try {
      String str1 = this.zzdl.zzl();
      if (str1 == null) {
        Log.e("FirebaseInstanceId", "Token retrieval failed: null");
        return false;
      } 
      if (Log.isLoggable("FirebaseInstanceId", 3))
        Log.d("FirebaseInstanceId", "Token successfully retrieved"); 
      if (zzax == null || (zzax != null && !str1.equals(zzax.zzbr))) {
        Context context = getContext();
        Intent intent2 = new Intent();
        this("com.google.firebase.messaging.NEW_TOKEN");
        intent2.putExtra("token", str1);
        zzav.zzc(context, intent2);
        Intent intent1 = new Intent();
        this("com.google.firebase.iid.TOKEN_REFRESH");
        zzav.zzb(context, intent1);
      } 
      return true;
    } catch (IOException iOException) {
    
    } catch (SecurityException securityException) {}
    String str = String.valueOf(securityException.getMessage());
    if (str.length() != 0) {
      str = "Token retrieval failed: ".concat(str);
    } else {
      str = new String("Token retrieval failed: ");
    } 
    Log.e("FirebaseInstanceId", str);
    return false;
  }
  
  final Context getContext() {
    return this.zzdl.zzi().getApplicationContext();
  }
  
  @SuppressLint({"Wakelock"})
  public final void run() {
    try {
      if (zzav.zzai().zzd(getContext()))
        this.zzdk.acquire(); 
      this.zzdl.zza(true);
      if (!this.zzdl.zzo()) {
        this.zzdl.zza(false);
        return;
      } 
      if (zzav.zzai().zze(getContext()) && !zzan()) {
        zzaz zzaz = new zzaz();
        this(this);
        zzaz.zzao();
        return;
      } 
      if (zzam() && this.zzas.zzc(this.zzdl)) {
        this.zzdl.zza(false);
      } else {
        this.zzdl.zza(this.zzdj);
      } 
      return;
    } finally {
      if (zzav.zzai().zzd(getContext()))
        this.zzdk.release(); 
    } 
  }
  
  final boolean zzan() {
    ConnectivityManager connectivityManager = (ConnectivityManager)getContext().getSystemService("connectivity");
    if (connectivityManager != null) {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    } else {
      connectivityManager = null;
    } 
    return (connectivityManager != null && connectivityManager.isConnected());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */