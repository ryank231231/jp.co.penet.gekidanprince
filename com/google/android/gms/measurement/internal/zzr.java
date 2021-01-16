package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzr extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzr> CREATOR = new zzs();
  
  @Field(id = 6)
  public boolean active;
  
  @Field(id = 5)
  public long creationTimestamp;
  
  @Field(id = 3)
  public String origin;
  
  @Field(id = 2)
  public String packageName;
  
  @Field(id = 11)
  public long timeToLive;
  
  @Field(id = 7)
  public String triggerEventName;
  
  @Field(id = 9)
  public long triggerTimeout;
  
  @Field(id = 4)
  public zzga zzdv;
  
  @Field(id = 8)
  public zzaj zzdw;
  
  @Field(id = 10)
  public zzaj zzdx;
  
  @Field(id = 12)
  public zzaj zzdy;
  
  zzr(zzr paramzzr) {
    Preconditions.checkNotNull(paramzzr);
    this.packageName = paramzzr.packageName;
    this.origin = paramzzr.origin;
    this.zzdv = paramzzr.zzdv;
    this.creationTimestamp = paramzzr.creationTimestamp;
    this.active = paramzzr.active;
    this.triggerEventName = paramzzr.triggerEventName;
    this.zzdw = paramzzr.zzdw;
    this.triggerTimeout = paramzzr.triggerTimeout;
    this.zzdx = paramzzr.zzdx;
    this.timeToLive = paramzzr.timeToLive;
    this.zzdy = paramzzr.zzdy;
  }
  
  @Constructor
  zzr(@Param(id = 2) String paramString1, @Param(id = 3) String paramString2, @Param(id = 4) zzga paramzzga, @Param(id = 5) long paramLong1, @Param(id = 6) boolean paramBoolean, @Param(id = 7) String paramString3, @Param(id = 8) zzaj paramzzaj1, @Param(id = 9) long paramLong2, @Param(id = 10) zzaj paramzzaj2, @Param(id = 11) long paramLong3, @Param(id = 12) zzaj paramzzaj3) {
    this.packageName = paramString1;
    this.origin = paramString2;
    this.zzdv = paramzzga;
    this.creationTimestamp = paramLong1;
    this.active = paramBoolean;
    this.triggerEventName = paramString3;
    this.zzdw = paramzzaj1;
    this.triggerTimeout = paramLong2;
    this.zzdx = paramzzaj2;
    this.timeToLive = paramLong3;
    this.zzdy = paramzzaj3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.origin, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)this.zzdv, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.creationTimestamp);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.active);
    SafeParcelWriter.writeString(paramParcel, 7, this.triggerEventName, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, (Parcelable)this.zzdw, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, this.triggerTimeout);
    SafeParcelWriter.writeParcelable(paramParcel, 10, (Parcelable)this.zzdx, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 11, this.timeToLive);
    SafeParcelWriter.writeParcelable(paramParcel, 12, (Parcelable)this.zzdy, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */