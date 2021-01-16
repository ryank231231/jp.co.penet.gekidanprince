package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zze;
import java.util.List;

public final class zzbl {
  final zzby zzl;
  
  zzbl(zzby paramzzby) {
    this.zzl = paramzzby;
  }
  
  @VisibleForTesting
  private final boolean zzee() {
    boolean bool = false;
    try {
      PackageManagerWrapper packageManagerWrapper = Wrappers.packageManager(this.zzl.getContext());
      if (packageManagerWrapper == null) {
        this.zzl.zzad().zzdg().zzaq("Failed to retrieve Package Manager to check Play Store compatibility");
        return false;
      } 
      int i = (packageManagerWrapper.getPackageInfo("com.android.vending", 128)).versionCode;
      if (i >= 80837300)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      this.zzl.zzad().zzdg().zza("Failed to retrieve Play Store version", exception);
      return false;
    } 
  }
  
  @Nullable
  @WorkerThread
  @VisibleForTesting
  final Bundle zza(String paramString, zze paramzze) {
    this.zzl.zzac().zzq();
    if (paramzze == null) {
      this.zzl.zzad().zzdd().zzaq("Attempting to use Install Referrer Service while it is not initialized");
      return null;
    } 
    Bundle bundle = new Bundle();
    bundle.putString("package_name", paramString);
    try {
      Bundle bundle1 = paramzze.zza(bundle);
      if (bundle1 == null) {
        this.zzl.zzad().zzda().zzaq("Install Referrer Service returned a null response");
        return null;
      } 
      return bundle1;
    } catch (Exception exception) {
      this.zzl.zzad().zzda().zza("Exception occurred while retrieving the Install Referrer", exception.getMessage());
      return null;
    } 
  }
  
  @WorkerThread
  protected final void zzaw(String paramString) {
    if (paramString == null || paramString.isEmpty()) {
      this.zzl.zzad().zzdg().zzaq("Install Referrer Reporter was called with invalid app package name");
      return;
    } 
    this.zzl.zzac().zzq();
    if (!zzee()) {
      this.zzl.zzad().zzdg().zzaq("Install Referrer Reporter is not available");
      return;
    } 
    this.zzl.zzad().zzdg().zzaq("Install Referrer Reporter is initializing");
    zzbm zzbm = new zzbm(this, paramString);
    this.zzl.zzac().zzq();
    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
    PackageManager packageManager = this.zzl.getContext().getPackageManager();
    if (packageManager == null) {
      this.zzl.zzad().zzdd().zzaq("Failed to obtain Package Manager to verify binding conditions");
      return;
    } 
    List<ResolveInfo> list = packageManager.queryIntentServices(intent, 0);
    if (list != null && !list.isEmpty()) {
      ResolveInfo resolveInfo = list.get(0);
      if (resolveInfo.serviceInfo != null) {
        String str = resolveInfo.serviceInfo.packageName;
        if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str) && zzee()) {
          intent = new Intent(intent);
          try {
            String str1;
            boolean bool = ConnectionTracker.getInstance().bindService(this.zzl.getContext(), intent, zzbm, 1);
            zzaw zzaw = this.zzl.zzad().zzdg();
            if (bool) {
              str1 = "available";
            } else {
              str1 = "not available";
            } 
            zzaw.zza("Install Referrer Service is", str1);
            return;
          } catch (Exception exception) {
            this.zzl.zzad().zzda().zza("Exception occurred while binding to Install Referrer Service", exception.getMessage());
            return;
          } 
        } 
        this.zzl.zzad().zzdg().zzaq("Play Store missing or incompatible. Version 8.3.73 or later required");
      } 
      return;
    } 
    this.zzl.zzad().zzdg().zzaq("Play Service for fetching Install Referrer is unavailable on device");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */