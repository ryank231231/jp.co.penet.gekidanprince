package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
@KeepForSdk
public final class GoogleServices {
  private static final Object sLock = new Object();
  
  @GuardedBy("sLock")
  private static GoogleServices zzay;
  
  private final String zzaz;
  
  private final Status zzba;
  
  private final boolean zzbb;
  
  private final boolean zzbc;
  
  @KeepForSdk
  @VisibleForTesting
  GoogleServices(Context paramContext) {
    Resources resources = paramContext.getResources();
    int i = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool1 = true;
    boolean bool2 = true;
    if (i != 0) {
      if (resources.getInteger(i) == 0)
        bool2 = false; 
      this.zzbc = bool2 ^ true;
    } else {
      this.zzbc = false;
      bool2 = bool1;
    } 
    this.zzbb = bool2;
    String str2 = zzp.zzc(paramContext);
    String str1 = str2;
    if (str2 == null)
      str1 = (new StringResourceValueReader(paramContext)).getString("google_app_id"); 
    if (TextUtils.isEmpty(str1)) {
      this.zzba = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.zzaz = null;
      return;
    } 
    this.zzaz = str1;
    this.zzba = Status.RESULT_SUCCESS;
  }
  
  @KeepForSdk
  @VisibleForTesting
  GoogleServices(String paramString, boolean paramBoolean) {
    this.zzaz = paramString;
    this.zzba = Status.RESULT_SUCCESS;
    this.zzbb = paramBoolean;
    this.zzbc = paramBoolean ^ true;
  }
  
  @KeepForSdk
  private static GoogleServices checkInitialized(String paramString) {
    synchronized (sLock) {
      GoogleServices googleServices;
      if (zzay != null) {
        googleServices = zzay;
        return googleServices;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      int i = String.valueOf(googleServices).length();
      StringBuilder stringBuilder = new StringBuilder();
      this(i + 34);
      stringBuilder.append("Initialize must be called before ");
      stringBuilder.append((String)googleServices);
      stringBuilder.append(".");
      this(stringBuilder.toString());
      throw illegalStateException;
    } 
  }
  
  @KeepForSdk
  @VisibleForTesting
  static void clearInstanceForTest() {
    synchronized (sLock) {
      zzay = null;
      return;
    } 
  }
  
  @KeepForSdk
  public static String getGoogleAppId() {
    return (checkInitialized("getGoogleAppId")).zzaz;
  }
  
  @KeepForSdk
  public static Status initialize(Context paramContext) {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    synchronized (sLock) {
      if (zzay == null) {
        GoogleServices googleServices = new GoogleServices();
        this(paramContext);
        zzay = googleServices;
      } 
      return zzay.zzba;
    } 
  }
  
  @KeepForSdk
  public static Status initialize(Context paramContext, String paramString, boolean paramBoolean) {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    synchronized (sLock) {
      if (zzay != null) {
        status = zzay.checkGoogleAppId(paramString);
        return status;
      } 
      GoogleServices googleServices = new GoogleServices();
      this((String)status, paramBoolean);
      zzay = googleServices;
      Status status = googleServices.zzba;
      return status;
    } 
  }
  
  @KeepForSdk
  public static boolean isMeasurementEnabled() {
    GoogleServices googleServices = checkInitialized("isMeasurementEnabled");
    return (googleServices.zzba.isSuccess() && googleServices.zzbb);
  }
  
  @KeepForSdk
  public static boolean isMeasurementExplicitlyDisabled() {
    return (checkInitialized("isMeasurementExplicitlyDisabled")).zzbc;
  }
  
  @KeepForSdk
  @VisibleForTesting
  final Status checkGoogleAppId(String paramString) {
    String str = this.zzaz;
    if (str != null && !str.equals(paramString)) {
      paramString = this.zzaz;
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 97);
      stringBuilder.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
      stringBuilder.append(paramString);
      stringBuilder.append("'.");
      return new Status(10, stringBuilder.toString());
    } 
    return Status.RESULT_SUCCESS;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\GoogleServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */