package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "SignInRequestCreator")
public final class zah extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zah> CREATOR = new zai();
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(getter = "getResolveAccountRequest", id = 2)
  private final ResolveAccountRequest zasa;
  
  @Constructor
  zah(@Param(id = 1) int paramInt, @Param(id = 2) ResolveAccountRequest paramResolveAccountRequest) {
    this.zale = paramInt;
    this.zasa = paramResolveAccountRequest;
  }
  
  public zah(ResolveAccountRequest paramResolveAccountRequest) {
    this(1, paramResolveAccountRequest);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zasa, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\signin\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */