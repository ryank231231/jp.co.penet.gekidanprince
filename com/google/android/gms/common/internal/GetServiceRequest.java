package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@Class(creator = "GetServiceRequestCreator")
@Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
  
  @VersionField(id = 1)
  private final int version = 4;
  
  @Field(id = 2)
  private final int zzdg;
  
  @Field(id = 3)
  private int zzdh;
  
  @Field(id = 5)
  IBinder zzdi;
  
  @Field(id = 6)
  Scope[] zzdj;
  
  @Field(id = 7)
  Bundle zzdk;
  
  @Field(id = 8)
  Account zzdl;
  
  @Field(id = 10)
  Feature[] zzdm;
  
  @Field(id = 11)
  Feature[] zzdn;
  
  @Field(id = 12)
  private boolean zzdo;
  
  @Field(id = 4)
  String zzy;
  
  public GetServiceRequest(int paramInt) {
    this.zzdh = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzdg = paramInt;
    this.zzdo = true;
  }
  
  @Constructor
  GetServiceRequest(@Param(id = 1) int paramInt1, @Param(id = 2) int paramInt2, @Param(id = 3) int paramInt3, @Param(id = 4) String paramString, @Param(id = 5) IBinder paramIBinder, @Param(id = 6) Scope[] paramArrayOfScope, @Param(id = 7) Bundle paramBundle, @Param(id = 8) Account paramAccount, @Param(id = 10) Feature[] paramArrayOfFeature1, @Param(id = 11) Feature[] paramArrayOfFeature2, @Param(id = 12) boolean paramBoolean) {
    this.zzdg = paramInt2;
    this.zzdh = paramInt3;
    if ("com.google.android.gms".equals(paramString)) {
      this.zzy = "com.google.android.gms";
    } else {
      this.zzy = paramString;
    } 
    if (paramInt1 < 2) {
      Account account;
      paramString = null;
      if (paramIBinder != null)
        account = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(paramIBinder)); 
      this.zzdl = account;
    } else {
      this.zzdi = paramIBinder;
      this.zzdl = paramAccount;
    } 
    this.zzdj = paramArrayOfScope;
    this.zzdk = paramBundle;
    this.zzdm = paramArrayOfFeature1;
    this.zzdn = paramArrayOfFeature2;
    this.zzdo = paramBoolean;
  }
  
  @KeepForSdk
  public Bundle getExtraArgs() {
    return this.zzdk;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.version);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzdg);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdh);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzy, false);
    SafeParcelWriter.writeIBinder(paramParcel, 5, this.zzdi, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 6, (Parcelable[])this.zzdj, paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzdk, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, (Parcelable)this.zzdl, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 10, (Parcelable[])this.zzdm, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 11, (Parcelable[])this.zzdn, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 12, this.zzdo);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\GetServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */