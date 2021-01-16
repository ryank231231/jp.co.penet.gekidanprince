package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzg;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
public class AndroidUtilsLight {
  private static volatile int zzgf = -1;
  
  @Deprecated
  @TargetApi(24)
  @KeepForSdk
  public static Context getDeviceProtectedStorageContext(Context paramContext) {
    return zzg.zzam() ? zzg.getDeviceProtectedStorageContext(paramContext) : paramContext;
  }
  
  @KeepForSdk
  public static byte[] getPackageCertificateHashBytes(Context paramContext, String paramString) throws PackageManager.NameNotFoundException {
    PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
    if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
      MessageDigest messageDigest = zzj("SHA1");
      if (messageDigest != null)
        return messageDigest.digest(packageInfo.signatures[0].toByteArray()); 
    } 
    return null;
  }
  
  public static MessageDigest zzj(String paramString) {
    byte b = 0;
    while (true) {
      if (b < 2) {
        try {
          MessageDigest messageDigest = MessageDigest.getInstance(paramString);
          if (messageDigest != null)
            return messageDigest; 
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        b++;
        continue;
      } 
      return null;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\AndroidUtilsLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */