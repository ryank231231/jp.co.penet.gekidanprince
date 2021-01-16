package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@Class(creator = "FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
  @KeepForSdk
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(id = 2)
  private final String zapi;
  
  @Field(id = 3)
  private final int zapj;
  
  @Constructor
  public FavaDiagnosticsEntity(@Param(id = 1) int paramInt1, @Param(id = 2) String paramString, @Param(id = 3) int paramInt2) {
    this.zale = paramInt1;
    this.zapi = paramString;
    this.zapj = paramInt2;
  }
  
  @KeepForSdk
  public FavaDiagnosticsEntity(String paramString, int paramInt) {
    this.zale = 1;
    this.zapi = paramString;
    this.zapj = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeString(paramParcel, 2, this.zapi, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zapj);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\FavaDiagnosticsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */