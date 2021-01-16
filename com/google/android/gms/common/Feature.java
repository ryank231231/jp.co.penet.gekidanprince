package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
  public static final Parcelable.Creator<Feature> CREATOR = new zzb();
  
  @Field(getter = "getName", id = 1)
  private final String name;
  
  @Deprecated
  @Field(getter = "getOldVersion", id = 2)
  private final int zzk;
  
  @Field(defaultValue = "-1", getter = "getVersion", id = 3)
  private final long zzl;
  
  @Constructor
  public Feature(@Param(id = 1) String paramString, @Param(id = 2) int paramInt, @Param(id = 3) long paramLong) {
    this.name = paramString;
    this.zzk = paramInt;
    this.zzl = paramLong;
  }
  
  @KeepForSdk
  public Feature(String paramString, long paramLong) {
    this.name = paramString;
    this.zzl = paramLong;
    this.zzk = -1;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject instanceof Feature) {
      paramObject = paramObject;
      return (((getName() != null && getName().equals(paramObject.getName())) || (getName() == null && paramObject.getName() == null)) && getVersion() == paramObject.getVersion());
    } 
    return false;
  }
  
  @KeepForSdk
  public String getName() {
    return this.name;
  }
  
  @KeepForSdk
  public long getVersion() {
    long l1 = this.zzl;
    long l2 = l1;
    if (l1 == -1L)
      l2 = this.zzk; 
    return l2;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { getName(), Long.valueOf(getVersion()) });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzk);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */