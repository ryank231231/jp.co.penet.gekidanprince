package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.text.TextUtils;

@TargetApi(14)
@MainThread
final class zzdx implements Application.ActivityLifecycleCallbacks {
  private zzdx(zzdd paramzzdd) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    try {
      this.zzpm.zzad().zzdi().zzaq("onActivityCreated");
      Intent intent = paramActivity.getIntent();
      if (intent != null) {
        Uri uri = intent.getData();
        if (uri != null && uri.isHierarchical()) {
          boolean bool;
          if (paramBundle == null) {
            String str1;
            Bundle bundle = this.zzpm.zzab().zza(uri);
            this.zzpm.zzab();
            if (zzgd.zzc(intent)) {
              str1 = "gs";
            } else {
              str1 = "auto";
            } 
            if (bundle != null)
              this.zzpm.logEvent(str1, "_cmp", bundle); 
          } 
          String str = uri.getQueryParameter("referrer");
          if (TextUtils.isEmpty(str))
            return; 
          if (str.contains("gclid") && (str.contains("utm_campaign") || str.contains("utm_source") || str.contains("utm_medium") || str.contains("utm_term") || str.contains("utm_content"))) {
            bool = true;
          } else {
            bool = false;
          } 
          if (!bool) {
            this.zzpm.zzad().zzdh().zzaq("Activity created with data 'referrer' param without gclid and at least one utm field");
            return;
          } 
          this.zzpm.zzad().zzdh().zza("Activity created with referrer", str);
          if (!TextUtils.isEmpty(str))
            this.zzpm.zzb("auto", "_ldl", str, true); 
        } 
      } 
    } catch (Exception exception) {
      this.zzpm.zzad().zzda().zza("Throwable caught in onActivityCreated", exception);
    } 
    this.zzpm.zzv().onActivityCreated(paramActivity, paramBundle);
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {
    this.zzpm.zzv().onActivityDestroyed(paramActivity);
  }
  
  @MainThread
  public final void onActivityPaused(Activity paramActivity) {
    this.zzpm.zzv().onActivityPaused(paramActivity);
    zzfj zzfj = this.zzpm.zzx();
    long l = zzfj.zzz().elapsedRealtime();
    zzfj.zzac().zza(new zzfn(zzfj, l));
  }
  
  @MainThread
  public final void onActivityResumed(Activity paramActivity) {
    this.zzpm.zzv().onActivityResumed(paramActivity);
    zzfj zzfj = this.zzpm.zzx();
    long l = zzfj.zzz().elapsedRealtime();
    zzfj.zzac().zza(new zzfm(zzfj, l));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {
    this.zzpm.zzv().onActivitySaveInstanceState(paramActivity, paramBundle);
  }
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */