package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConnectionInfoCreator")
public final class zzb extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzb> CREATOR = new zzc();
  
  @Field(id = 1)
  Bundle zzda;
  
  @Field(id = 2)
  Feature[] zzdb;
  
  public zzb() {}
  
  @Constructor
  zzb(@Param(id = 1) Bundle paramBundle, @Param(id = 2) Feature[] paramArrayOfFeature) {
    this.zzda = paramBundle;
    this.zzdb = paramArrayOfFeature;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 1, this.zzda, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, (Parcelable[])this.zzdb, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */