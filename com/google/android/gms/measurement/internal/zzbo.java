package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;

public final class zzbo {
  private final zzbr zzmj;
  
  public zzbo(zzbr paramzzbr) {
    Preconditions.checkNotNull(paramzzbr);
    this.zzmj = paramzzbr;
  }
  
  public static boolean zzl(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      if (packageManager == null)
        return false; 
      ComponentName componentName = new ComponentName();
      this(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver");
      ActivityInfo activityInfo = packageManager.getReceiverInfo(componentName, 0);
      if (activityInfo != null) {
        boolean bool = activityInfo.enabled;
        if (bool)
          return true; 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return false;
  }
  
  @MainThread
  public final void onReceive(Context paramContext, Intent paramIntent) {
    zzby zzby = zzby.zza(paramContext, (zzy)null);
    zzau zzau = zzby.zzad();
    if (paramIntent == null) {
      zzau.zzdd().zzaq("Receiver called with null intent");
      return;
    } 
    zzby.zzag();
    String str = paramIntent.getAction();
    zzau.zzdi().zza("Local receiver got", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      paramIntent = (new Intent()).setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
      paramIntent.setAction("com.google.android.gms.measurement.UPLOAD");
      zzau.zzdi().zzaq("Starting wakeful intent.");
      this.zzmj.doStartService(paramContext, paramIntent);
      return;
    } 
    if ("com.android.vending.INSTALL_REFERRER".equals(str)) {
      try {
        zzbt zzbt = zzby.zzac();
        zzbp zzbp = new zzbp();
        this(this, zzby, zzau);
        zzbt.zza(zzbp);
      } catch (Exception exception) {
        zzau.zzdd().zza("Install Referrer Reporter encountered a problem", exception);
      } 
      BroadcastReceiver.PendingResult pendingResult = this.zzmj.doGoAsync();
      String str1 = paramIntent.getStringExtra("referrer");
      if (str1 == null) {
        zzau.zzdi().zzaq("Install referrer extras are null");
        if (pendingResult != null)
          pendingResult.finish(); 
        return;
      } 
      zzau.zzdg().zza("Install referrer extras are", str1);
      str = str1;
      if (!str1.contains("?")) {
        str = String.valueOf(str1);
        if (str.length() != 0) {
          str = "?".concat(str);
        } else {
          str = new String("?");
        } 
      } 
      Uri uri = Uri.parse(str);
      Bundle bundle = zzby.zzab().zza(uri);
      if (bundle == null) {
        zzau.zzdi().zzaq("No campaign defined in install referrer broadcast");
        if (pendingResult != null) {
          pendingResult.finish();
          return;
        } 
      } else {
        long l = paramIntent.getLongExtra("referrer_timestamp_seconds", 0L) * 1000L;
        if (l == 0L)
          zzau.zzdd().zzaq("Install referrer is missing timestamp"); 
        zzby.zzac().zza(new zzbq(this, zzby, l, bundle, paramContext, zzau, pendingResult));
      } 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */