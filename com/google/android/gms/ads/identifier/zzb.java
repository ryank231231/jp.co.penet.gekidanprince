package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public final class zzb {
  private SharedPreferences zzs;
  
  public zzb(Context paramContext) {
    try {
      SharedPreferences sharedPreferences;
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext == null) {
        paramContext = null;
      } else {
        sharedPreferences = paramContext.getSharedPreferences("google_ads_flags", 0);
      } 
      this.zzs = sharedPreferences;
      return;
    } catch (Throwable throwable) {
      Log.w("GmscoreFlag", "Error while getting SharedPreferences ", throwable);
      this.zzs = null;
      return;
    } 
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean) {
    try {
      return (this.zzs == null) ? false : this.zzs.getBoolean(paramString, false);
    } catch (Throwable throwable) {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", throwable);
      return false;
    } 
  }
  
  final float getFloat(String paramString, float paramFloat) {
    try {
      return (this.zzs == null) ? 0.0F : this.zzs.getFloat(paramString, 0.0F);
    } catch (Throwable throwable) {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", throwable);
      return 0.0F;
    } 
  }
  
  final String getString(String paramString1, String paramString2) {
    try {
      return (this.zzs == null) ? paramString2 : this.zzs.getString(paramString1, paramString2);
    } catch (Throwable throwable) {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", throwable);
      return paramString2;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\ads\identifier\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */