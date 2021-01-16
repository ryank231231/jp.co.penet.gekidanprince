package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "GoogleSignInOptionsExtensionCreator")
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
  public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();
  
  @Field(getter = "getBundle", id = 3)
  private Bundle mBundle;
  
  @Field(getter = "getType", id = 2)
  private int mType;
  
  @VersionField(id = 1)
  private final int versionCode;
  
  @Constructor
  GoogleSignInOptionsExtensionParcelable(@Param(id = 1) int paramInt1, @Param(id = 2) int paramInt2, @Param(id = 3) Bundle paramBundle) {
    this.versionCode = paramInt1;
    this.mType = paramInt2;
    this.mBundle = paramBundle;
  }
  
  public GoogleSignInOptionsExtensionParcelable(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension) {
    this(1, paramGoogleSignInOptionsExtension.getExtensionType(), paramGoogleSignInOptionsExtension.toBundle());
  }
  
  @KeepForSdk
  public int getType() {
    return this.mType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeInt(paramParcel, 2, getType());
    SafeParcelWriter.writeBundle(paramParcel, 3, this.mBundle, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\GoogleSignInOptionsExtensionParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */