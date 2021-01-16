package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "InitializationParamsCreator")
public final class zzy extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzy> CREATOR = new zzz();
  
  @Field(id = 5)
  public final String origin;
  
  @Field(id = 1)
  public final long zzt;
  
  @Field(id = 2)
  public final long zzu;
  
  @Field(id = 3)
  public final boolean zzv;
  
  @Field(id = 4)
  public final String zzw;
  
  @Field(id = 6)
  public final String zzx;
  
  @Field(id = 7)
  public final Bundle zzy;
  
  @Constructor
  public zzy(@Param(id = 1) long paramLong1, @Param(id = 2) long paramLong2, @Param(id = 3) boolean paramBoolean, @Param(id = 4) String paramString1, @Param(id = 5) String paramString2, @Param(id = 6) String paramString3, @Param(id = 7) Bundle paramBundle) {
    this.zzt = paramLong1;
    this.zzu = paramLong2;
    this.zzv = paramBoolean;
    this.zzw = paramString1;
    this.origin = paramString2;
    this.zzx = paramString3;
    this.zzy = paramBundle;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzt);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzu);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzv);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzw, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.origin, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzx, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzy, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */