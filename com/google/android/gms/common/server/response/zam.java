package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@ShowFirstParty
@Class(creator = "FieldMapPairCreator")
public final class zam extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zam> CREATOR = new zaj();
  
  @VersionField(id = 1)
  private final int versionCode;
  
  @Field(id = 2)
  final String zaqy;
  
  @Field(id = 3)
  final FastJsonResponse.Field<?, ?> zaqz;
  
  @Constructor
  zam(@Param(id = 1) int paramInt, @Param(id = 2) String paramString, @Param(id = 3) FastJsonResponse.Field<?, ?> paramField) {
    this.versionCode = paramInt;
    this.zaqy = paramString;
    this.zaqz = paramField;
  }
  
  zam(String paramString, FastJsonResponse.Field<?, ?> paramField) {
    this.versionCode = 1;
    this.zaqy = paramString;
    this.zaqz = paramField;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.zaqy, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zaqz, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\response\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */