package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "CollectForDebugParcelableCreator")
public final class zzc extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzc> CREATOR = new zzd();
  
  @Field(defaultValue = "false", id = 1)
  private final boolean zzad;
  
  @Field(id = 3)
  private final long zzae;
  
  @Field(id = 2)
  private final long zzaf;
  
  @Constructor
  public zzc(@Param(id = 1) boolean paramBoolean, @Param(id = 3) long paramLong1, @Param(id = 2) long paramLong2) {
    this.zzad = paramBoolean;
    this.zzae = paramLong1;
    this.zzaf = paramLong2;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof zzc) {
      paramObject = paramObject;
      if (this.zzad == ((zzc)paramObject).zzad && this.zzae == ((zzc)paramObject).zzae && this.zzaf == ((zzc)paramObject).zzaf)
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Boolean.valueOf(this.zzad), Long.valueOf(this.zzae), Long.valueOf(this.zzaf) });
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("CollectForDebugParcelable[skipPersistentStorage: ");
    stringBuilder.append(this.zzad);
    stringBuilder.append(",collectForDebugStartTimeMillis: ");
    stringBuilder.append(this.zzae);
    stringBuilder.append(",collectForDebugExpiryTimeMillis: ");
    stringBuilder.append(this.zzaf);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, this.zzad);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzaf);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzae);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\clearcut\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */