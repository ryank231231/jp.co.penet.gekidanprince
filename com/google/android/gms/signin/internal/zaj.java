package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "SignInResponseCreator")
public final class zaj extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zaj> CREATOR = new zak();
  
  @Field(getter = "getConnectionResult", id = 2)
  private final ConnectionResult zadh;
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(getter = "getResolveAccountResponse", id = 3)
  private final ResolveAccountResponse zasb;
  
  public zaj(int paramInt) {
    this(new ConnectionResult(8, null), null);
  }
  
  @Constructor
  zaj(@Param(id = 1) int paramInt, @Param(id = 2) ConnectionResult paramConnectionResult, @Param(id = 3) ResolveAccountResponse paramResolveAccountResponse) {
    this.zale = paramInt;
    this.zadh = paramConnectionResult;
    this.zasb = paramResolveAccountResponse;
  }
  
  private zaj(ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse) {
    this(1, paramConnectionResult, null);
  }
  
  public final ConnectionResult getConnectionResult() {
    return this.zadh;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zadh, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zasb, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final ResolveAccountResponse zacw() {
    return this.zasb;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\signin\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */