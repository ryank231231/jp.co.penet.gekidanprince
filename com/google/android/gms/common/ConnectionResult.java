package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable {
  public static final int API_UNAVAILABLE = 16;
  
  public static final int CANCELED = 13;
  
  public static final Parcelable.Creator<ConnectionResult> CREATOR;
  
  public static final int DEVELOPER_ERROR = 10;
  
  @Deprecated
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  
  public static final int INTERNAL_ERROR = 8;
  
  public static final int INTERRUPTED = 15;
  
  public static final int INVALID_ACCOUNT = 5;
  
  public static final int LICENSE_CHECK_FAILED = 11;
  
  public static final int NETWORK_ERROR = 7;
  
  public static final int RESOLUTION_REQUIRED = 6;
  
  public static final int RESTRICTED_PROFILE = 20;
  
  @KeepForSdk
  public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
  
  public static final int SERVICE_DISABLED = 3;
  
  public static final int SERVICE_INVALID = 9;
  
  public static final int SERVICE_MISSING = 1;
  
  public static final int SERVICE_MISSING_PERMISSION = 19;
  
  public static final int SERVICE_UPDATING = 18;
  
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  
  public static final int SIGN_IN_FAILED = 17;
  
  public static final int SIGN_IN_REQUIRED = 4;
  
  public static final int SUCCESS = 0;
  
  public static final int TIMEOUT = 14;
  
  @KeepForSdk
  public static final int UNKNOWN = -1;
  
  @VersionField(id = 1)
  private final int zzg;
  
  @Field(getter = "getErrorCode", id = 2)
  private final int zzh;
  
  @Field(getter = "getResolution", id = 3)
  private final PendingIntent zzi;
  
  @Field(getter = "getErrorMessage", id = 4)
  private final String zzj;
  
  static {
    CREATOR = new zza();
  }
  
  public ConnectionResult(int paramInt) {
    this(paramInt, null, null);
  }
  
  @Constructor
  ConnectionResult(@Param(id = 1) int paramInt1, @Param(id = 2) int paramInt2, @Param(id = 3) PendingIntent paramPendingIntent, @Param(id = 4) String paramString) {
    this.zzg = paramInt1;
    this.zzh = paramInt2;
    this.zzi = paramPendingIntent;
    this.zzj = paramString;
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent) {
    this(paramInt, paramPendingIntent, null);
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString) {
    this(1, paramInt, paramPendingIntent, paramString);
  }
  
  static String zza(int paramInt) {
    if (paramInt != 99) {
      if (paramInt != 1500) {
        StringBuilder stringBuilder;
        switch (paramInt) {
          default:
            switch (paramInt) {
              default:
                stringBuilder = new StringBuilder(31);
                stringBuilder.append("UNKNOWN_ERROR_CODE(");
                stringBuilder.append(paramInt);
                stringBuilder.append(")");
                return stringBuilder.toString();
              case 21:
                return "API_VERSION_UPDATE_REQUIRED";
              case 20:
                return "RESTRICTED_PROFILE";
              case 19:
                return "SERVICE_MISSING_PERMISSION";
              case 18:
                return "SERVICE_UPDATING";
              case 17:
                return "SIGN_IN_FAILED";
              case 16:
                return "API_UNAVAILABLE";
              case 15:
                return "INTERRUPTED";
              case 14:
                return "TIMEOUT";
              case 13:
                break;
            } 
            return "CANCELED";
          case 11:
            return "LICENSE_CHECK_FAILED";
          case 10:
            return "DEVELOPER_ERROR";
          case 9:
            return "SERVICE_INVALID";
          case 8:
            return "INTERNAL_ERROR";
          case 7:
            return "NETWORK_ERROR";
          case 6:
            return "RESOLUTION_REQUIRED";
          case 5:
            return "INVALID_ACCOUNT";
          case 4:
            return "SIGN_IN_REQUIRED";
          case 3:
            return "SERVICE_DISABLED";
          case 2:
            return "SERVICE_VERSION_UPDATE_REQUIRED";
          case 1:
            return "SERVICE_MISSING";
          case 0:
            return "SUCCESS";
          case -1:
            break;
        } 
        return "UNKNOWN";
      } 
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    } 
    return "UNFINISHED";
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ConnectionResult))
      return false; 
    paramObject = paramObject;
    return (this.zzh == ((ConnectionResult)paramObject).zzh && Objects.equal(this.zzi, ((ConnectionResult)paramObject).zzi) && Objects.equal(this.zzj, ((ConnectionResult)paramObject).zzj));
  }
  
  public final int getErrorCode() {
    return this.zzh;
  }
  
  @Nullable
  public final String getErrorMessage() {
    return this.zzj;
  }
  
  @Nullable
  public final PendingIntent getResolution() {
    return this.zzi;
  }
  
  public final boolean hasResolution() {
    return (this.zzh != 0 && this.zzi != null);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzh), this.zzi, this.zzj });
  }
  
  public final boolean isSuccess() {
    return (this.zzh == 0);
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    if (!hasResolution())
      return; 
    paramActivity.startIntentSenderForResult(this.zzi.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public final String toString() {
    return Objects.toStringHelper(this).add("statusCode", zza(this.zzh)).add("resolution", this.zzi).add("message", this.zzj).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzg);
    SafeParcelWriter.writeInt(paramParcel, 2, getErrorCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)getResolution(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getErrorMessage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\ConnectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */