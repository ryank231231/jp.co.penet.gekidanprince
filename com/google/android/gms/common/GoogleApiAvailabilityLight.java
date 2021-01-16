package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
@ShowFirstParty
public class GoogleApiAvailabilityLight {
  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  
  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @KeepForSdk
  static final String TRACKING_SOURCE_DIALOG = "d";
  
  @KeepForSdk
  static final String TRACKING_SOURCE_NOTIFICATION = "n";
  
  private static final GoogleApiAvailabilityLight zzm = new GoogleApiAvailabilityLight();
  
  @KeepForSdk
  public static GoogleApiAvailabilityLight getInstance() {
    return zzm;
  }
  
  @VisibleForTesting
  private static String zza(@Nullable Context paramContext, @Nullable String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("gcore_");
    stringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    stringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString))
      stringBuilder.append(paramString); 
    stringBuilder.append("-");
    if (paramContext != null)
      stringBuilder.append(paramContext.getPackageName()); 
    stringBuilder.append("-");
    if (paramContext != null)
      try {
        stringBuilder.append((Wrappers.packageManager(paramContext).getPackageInfo(paramContext.getPackageName(), 0)).versionCode);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {} 
    return stringBuilder.toString();
  }
  
  @KeepForSdk
  public void cancelAvailabilityErrorNotifications(Context paramContext) {
    GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(paramContext);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public int getApkVersion(Context paramContext) {
    return GooglePlayServicesUtilLight.getApkVersion(paramContext);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public int getClientVersion(Context paramContext) {
    return GooglePlayServicesUtilLight.getClientVersion(paramContext);
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(int paramInt) {
    return getErrorResolutionIntent(null, paramInt, null);
  }
  
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, @Nullable String paramString) {
    switch (paramInt) {
      default:
        return null;
      case 3:
        return zzg.zzg("com.google.android.gms");
      case 1:
      case 2:
        break;
    } 
    return (paramContext != null && DeviceProperties.isWearableWithoutPlayStore(paramContext)) ? zzg.zzs() : zzg.zza("com.google.android.gms", zza(paramContext, paramString));
  }
  
  @Nullable
  @KeepForSdk
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2) {
    return getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2, null);
  }
  
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2, @Nullable String paramString) {
    Intent intent = getErrorResolutionIntent(paramContext, paramInt1, paramString);
    return (intent == null) ? null : PendingIntent.getActivity(paramContext, paramInt2, intent, 134217728);
  }
  
  @KeepForSdk
  public String getErrorString(int paramInt) {
    return GooglePlayServicesUtilLight.getErrorString(paramInt);
  }
  
  @KeepForSdk
  @HideFirstParty
  public int isGooglePlayServicesAvailable(Context paramContext) {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  @KeepForSdk
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt) {
    int i = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
    paramInt = i;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, i))
      paramInt = 18; 
    return paramInt;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt) {
    return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt) {
    return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt);
  }
  
  @KeepForSdk
  public boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString) {
    return GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(paramContext, paramString);
  }
  
  @KeepForSdk
  public boolean isUserResolvableError(int paramInt) {
    return GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
  }
  
  @KeepForSdk
  public void verifyGooglePlayServicesIsAvailable(Context paramContext, int paramInt) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailabilityLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */