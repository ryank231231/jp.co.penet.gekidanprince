package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Deprecated
@Class(creator = "ValidateAccountRequestCreator")
public final class zzr extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzr> CREATOR = new zzs();
  
  @VersionField(id = 1)
  private final int zzg;
  
  @Constructor
  zzr(@Param(id = 1) int paramInt) {
    this.zzg = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzg);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */