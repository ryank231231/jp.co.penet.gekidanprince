package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties {
  private static Boolean zzgn;
  
  private static Boolean zzgo;
  
  private static Boolean zzgp;
  
  private static Boolean zzgq;
  
  private static Boolean zzgr;
  
  private static Boolean zzgs;
  
  private static Boolean zzgt;
  
  private static Boolean zzgu;
  
  @KeepForSdk
  public static boolean isAuto(Context paramContext) {
    if (zzgt == null) {
      boolean bool;
      if (PlatformVersion.isAtLeastO() && paramContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzgt = Boolean.valueOf(bool);
    } 
    return zzgt.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isLatchsky(Context paramContext) {
    if (zzgr == null) {
      boolean bool;
      PackageManager packageManager = paramContext.getPackageManager();
      if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzgr = Boolean.valueOf(bool);
    } 
    return zzgr.booleanValue();
  }
  
  @TargetApi(21)
  @KeepForSdk
  public static boolean isSidewinder(Context paramContext) {
    if (zzgq == null) {
      boolean bool;
      if (PlatformVersion.isAtLeastLollipop() && paramContext.getPackageManager().hasSystemFeature("cn.google")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzgq = Boolean.valueOf(bool);
    } 
    return zzgq.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isTablet(Resources paramResources) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: ifnonnull -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: getstatic com/google/android/gms/common/util/DeviceProperties.zzgn : Ljava/lang/Boolean;
    //   11: ifnonnull -> 105
    //   14: aload_0
    //   15: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   18: getfield screenLayout : I
    //   21: bipush #15
    //   23: iand
    //   24: iconst_3
    //   25: if_icmple -> 33
    //   28: iconst_1
    //   29: istore_2
    //   30: goto -> 35
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: ifne -> 96
    //   39: getstatic com/google/android/gms/common/util/DeviceProperties.zzgo : Ljava/lang/Boolean;
    //   42: ifnonnull -> 85
    //   45: aload_0
    //   46: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   49: astore_0
    //   50: aload_0
    //   51: getfield screenLayout : I
    //   54: bipush #15
    //   56: iand
    //   57: iconst_3
    //   58: if_icmpgt -> 76
    //   61: aload_0
    //   62: getfield smallestScreenWidthDp : I
    //   65: sipush #600
    //   68: if_icmplt -> 76
    //   71: iconst_1
    //   72: istore_3
    //   73: goto -> 78
    //   76: iconst_0
    //   77: istore_3
    //   78: iload_3
    //   79: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   82: putstatic com/google/android/gms/common/util/DeviceProperties.zzgo : Ljava/lang/Boolean;
    //   85: iload_1
    //   86: istore_3
    //   87: getstatic com/google/android/gms/common/util/DeviceProperties.zzgo : Ljava/lang/Boolean;
    //   90: invokevirtual booleanValue : ()Z
    //   93: ifeq -> 98
    //   96: iconst_1
    //   97: istore_3
    //   98: iload_3
    //   99: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   102: putstatic com/google/android/gms/common/util/DeviceProperties.zzgn : Ljava/lang/Boolean;
    //   105: getstatic com/google/android/gms/common/util/DeviceProperties.zzgn : Ljava/lang/Boolean;
    //   108: invokevirtual booleanValue : ()Z
    //   111: ireturn
  }
  
  @KeepForSdk
  public static boolean isTv(Context paramContext) {
    if (zzgu == null) {
      boolean bool;
      PackageManager packageManager = paramContext.getPackageManager();
      if (packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzgu = Boolean.valueOf(bool);
    } 
    return zzgu.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isUserBuild() {
    return "user".equals(Build.TYPE);
  }
  
  @TargetApi(20)
  @KeepForSdk
  public static boolean isWearable(Context paramContext) {
    if (zzgp == null) {
      boolean bool;
      if (PlatformVersion.isAtLeastKitKatWatch() && paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzgp = Boolean.valueOf(bool);
    } 
    return zzgp.booleanValue();
  }
  
  @TargetApi(26)
  @KeepForSdk
  public static boolean isWearableWithoutPlayStore(Context paramContext) {
    return (isWearable(paramContext) && (!PlatformVersion.isAtLeastN() || (isSidewinder(paramContext) && !PlatformVersion.isAtLeastO())));
  }
  
  public static boolean zzf(Context paramContext) {
    if (zzgs == null) {
      boolean bool;
      if (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot") || paramContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
        bool = true;
      } else {
        bool = false;
      } 
      zzgs = Boolean.valueOf(bool);
    } 
    return zzgs.booleanValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\DeviceProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */