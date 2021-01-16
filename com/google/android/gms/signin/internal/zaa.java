package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "AuthAccountResultCreator")
public final class zaa extends AbstractSafeParcelable implements Result {
  public static final Parcelable.Creator<zaa> CREATOR = new zab();
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(getter = "getConnectionResultCode", id = 2)
  private int zarw;
  
  @Field(getter = "getRawAuthResolutionIntent", id = 3)
  private Intent zarx;
  
  public zaa() {
    this(0, null);
  }
  
  @Constructor
  zaa(@Param(id = 1) int paramInt1, @Param(id = 2) int paramInt2, @Param(id = 3) Intent paramIntent) {
    this.zale = paramInt1;
    this.zarw = paramInt2;
    this.zarx = paramIntent;
  }
  
  private zaa(int paramInt, Intent paramIntent) {
    this(2, 0, null);
  }
  
  public final Status getStatus() {
    return (this.zarw == 0) ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zarw);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zarx, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\signin\internal\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */