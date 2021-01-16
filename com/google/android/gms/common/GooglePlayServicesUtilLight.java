package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
@ShowFirstParty
public class GooglePlayServicesUtilLight {
  @KeepForSdk
  static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
  
  @KeepForSdk
  static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
  
  @KeepForSdk
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
  
  @Deprecated
  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  @Deprecated
  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
  
  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @KeepForSdk
  @VisibleForTesting
  static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
  
  @VisibleForTesting
  private static boolean zzah = false;
  
  @VisibleForTesting
  private static boolean zzai = false;
  
  private static boolean zzaj = false;
  
  @VisibleForTesting
  private static boolean zzak = false;
  
  private static final AtomicBoolean zzal = new AtomicBoolean();
  
  @Deprecated
  @KeepForSdk
  public static void cancelAvailabilityErrorNotifications(Context paramContext) {
    if (sCanceledAvailabilityNotification.getAndSet(true))
      return; 
    try {
      NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
      if (notificationManager != null)
        notificationManager.cancel(10436); 
      return;
    } catch (SecurityException securityException) {
      return;
    } 
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static void enableUsingApkIndependentContext() {
    zzal.set(true);
  }
  
  @Deprecated
  @KeepForSdk
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0) {
      Intent intent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      StringBuilder stringBuilder = new StringBuilder(57);
      stringBuilder.append("GooglePlayServices not available due to error ");
      stringBuilder.append(paramInt);
      Log.e("GooglePlayServicesUtil", stringBuilder.toString());
      if (intent == null)
        throw new GooglePlayServicesNotAvailableException(paramInt); 
      throw new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", intent);
    } 
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getApkVersion(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return packageInfo.versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
      return 0;
    } 
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getClientVersion(Context paramContext) {
    Preconditions.checkState(true);
    return ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
  }
  
  @Deprecated
  @KeepForSdk
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2) {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  @KeepForSdk
  @VisibleForTesting
  public static String getErrorString(int paramInt) {
    return ConnectionResult.zza(paramInt);
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt) {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }
  
  @KeepForSdk
  public static Context getRemoteContext(Context paramContext) {
    try {
      return paramContext.createPackageContext("com.google.android.gms", 3);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  @KeepForSdk
  public static Resources getRemoteResource(Context paramContext) {
    try {
      return paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static boolean honorsDebugCertificates(Context paramContext) {
    if (!zzak)
      try {
        PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.google.android.gms", 64);
        GoogleSignatureVerifier.getInstance(paramContext);
        if (packageInfo != null && !GoogleSignatureVerifier.zza(packageInfo, false) && GoogleSignatureVerifier.zza(packageInfo, true)) {
          zzaj = true;
        } else {
          zzaj = false;
        } 
        zzak = true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", (Throwable)nameNotFoundException);
        zzak = true;
      } finally {} 
    return (zzaj || !DeviceProperties.isUserBuild());
  }
  
  @Deprecated
  @KeepForSdk
  @HideFirstParty
  public static int isGooglePlayServicesAvailable(Context paramContext) {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  @Deprecated
  @KeepForSdk
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt) {
    StringBuilder stringBuilder;
    boolean bool;
    try {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
    } catch (Throwable throwable) {
      Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
    } 
    if (!"com.google.android.gms".equals(paramContext.getPackageName()) && !zzal.get()) {
      int i = zzp.zzd(paramContext);
      if (i != 0) {
        int j = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        if (i != j) {
          stringBuilder = new StringBuilder(320);
          stringBuilder.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
          stringBuilder.append(j);
          stringBuilder.append(" but found ");
          stringBuilder.append(i);
          stringBuilder.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } else {
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      } 
    } 
    if (!DeviceProperties.isWearableWithoutPlayStore((Context)stringBuilder) && !DeviceProperties.zzf((Context)stringBuilder)) {
      bool = true;
    } else {
      bool = false;
    } 
    return zza((Context)stringBuilder, bool, paramInt);
  }
  
  @Deprecated
  @KeepForSdk
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt) {
    return UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt) {
    return (paramInt == 18) ? true : ((paramInt == 1) ? isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms") : false);
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt) {
    return (paramInt == 9) ? isUninstalledAppPossiblyUpdating(paramContext, "com.android.vending") : false;
  }
  
  @TargetApi(18)
  @KeepForSdk
  public static boolean isRestrictedUserProfile(Context paramContext) {
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {
      Bundle bundle = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if (bundle != null && "true".equals(bundle.getString("restricted_profile")))
        return true; 
    } 
    return false;
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static boolean isSidewinderDevice(Context paramContext) {
    return DeviceProperties.isSidewinder(paramContext);
  }
  
  @TargetApi(21)
  static boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString) {
    boolean bool = paramString.equals("com.google.android.gms");
    if (PlatformVersion.isAtLeastLollipop())
      try {
        List list = paramContext.getPackageManager().getPackageInstaller().getAllSessions();
        Iterator<PackageInstaller.SessionInfo> iterator = list.iterator();
        while (iterator.hasNext()) {
          if (paramString.equals(((PackageInstaller.SessionInfo)iterator.next()).getAppPackageName()))
            return true; 
        } 
      } catch (Exception exception) {
        return false;
      }  
    PackageManager packageManager = exception.getPackageManager();
    try {
      ApplicationInfo applicationInfo = packageManager.getApplicationInfo(paramString, 8192);
      if (bool)
        return applicationInfo.enabled; 
      if (applicationInfo.enabled) {
        bool = isRestrictedUserProfile((Context)exception);
        if (!bool)
          return true; 
      } 
      return false;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  @Deprecated
  @KeepForSdk
  public static boolean isUserRecoverableError(int paramInt) {
    if (paramInt != 9)
      switch (paramInt) {
        default:
          return false;
        case 1:
        case 2:
        case 3:
          break;
      }  
    return true;
  }
  
  @Deprecated
  @TargetApi(19)
  @KeepForSdk
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString) {
    return UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
  }
  
  @VisibleForTesting
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    PackageManager packageManager = paramContext.getPackageManager();
    PackageInfo packageInfo = null;
    if (paramBoolean)
      try {
        packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
        return 9;
      }  
    try {
      PackageInfo packageInfo1 = packageManager.getPackageInfo("com.google.android.gms", 64);
      GoogleSignatureVerifier.getInstance((Context)nameNotFoundException);
      if (!GoogleSignatureVerifier.zza(packageInfo1, true)) {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      } 
      if (paramBoolean && (!GoogleSignatureVerifier.zza(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo1.signatures[0]))) {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      } 
      if (zzb.zzc(packageInfo1.versionCode) < zzb.zzc(paramInt)) {
        int i = packageInfo1.versionCode;
        StringBuilder stringBuilder = new StringBuilder(77);
        stringBuilder.append("Google Play services out of date.  Requires ");
        stringBuilder.append(paramInt);
        stringBuilder.append(" but found ");
        stringBuilder.append(i);
        Log.w("GooglePlayServicesUtil", stringBuilder.toString());
        return 2;
      } 
      ApplicationInfo applicationInfo2 = packageInfo1.applicationInfo;
      ApplicationInfo applicationInfo1 = applicationInfo2;
      if (applicationInfo2 == null)
        try {
          applicationInfo1 = packageManager.getApplicationInfo("com.google.android.gms", 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException1) {
          Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", (Throwable)nameNotFoundException1);
          return 1;
        }  
      return !((ApplicationInfo)nameNotFoundException1).enabled ? 3 : 0;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException1) {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
      return 1;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\GooglePlayServicesUtilLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */