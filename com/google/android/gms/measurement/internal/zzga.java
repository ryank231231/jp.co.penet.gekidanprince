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

@Class(creator = "UserAttributeParcelCreator")
public final class zzga extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzga> CREATOR = new zzgb();
  
  @Field(id = 2)
  public final String name;
  
  @Field(id = 7)
  public final String origin;
  
  @Field(id = 1)
  private final int versionCode;
  
  @Field(id = 6)
  public final String zzki;
  
  @Field(id = 3)
  public final long zzsx;
  
  @Field(id = 4)
  public final Long zzsy;
  
  @Field(id = 5)
  private final Float zzsz;
  
  @Field(id = 8)
  public final Double zzta;
  
  @Constructor
  zzga(@Param(id = 1) int paramInt, @Param(id = 2) String paramString1, @Param(id = 3) long paramLong, @Param(id = 4) Long paramLong1, @Param(id = 5) Float paramFloat, @Param(id = 6) String paramString2, @Param(id = 7) String paramString3, @Param(id = 8) Double paramDouble) {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.zzsx = paramLong;
    this.zzsy = paramLong1;
    paramString1 = null;
    this.zzsz = null;
    if (paramInt == 1) {
      Double double_;
      if (paramFloat != null)
        double_ = Double.valueOf(paramFloat.doubleValue()); 
      this.zzta = double_;
    } else {
      this.zzta = paramDouble;
    } 
    this.zzki = paramString2;
    this.origin = paramString3;
  }
  
  zzga(zzgc paramzzgc) {
    this(paramzzgc.name, paramzzgc.zzsx, paramzzgc.value, paramzzgc.origin);
  }
  
  zzga(String paramString1, long paramLong, Object paramObject, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    this.versionCode = 2;
    this.name = paramString1;
    this.zzsx = paramLong;
    this.origin = paramString2;
    if (paramObject == null) {
      this.zzsy = null;
      this.zzsz = null;
      this.zzta = null;
      this.zzki = null;
      return;
    } 
    if (paramObject instanceof Long) {
      this.zzsy = (Long)paramObject;
      this.zzsz = null;
      this.zzta = null;
      this.zzki = null;
      return;
    } 
    if (paramObject instanceof String) {
      this.zzsy = null;
      this.zzsz = null;
      this.zzta = null;
      this.zzki = (String)paramObject;
      return;
    } 
    if (paramObject instanceof Double) {
      this.zzsy = null;
      this.zzsz = null;
      this.zzta = (Double)paramObject;
      this.zzki = null;
      return;
    } 
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  zzga(String paramString1, long paramLong, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    this.versionCode = 2;
    this.name = paramString1;
    this.zzsx = 0L;
    this.zzsy = null;
    this.zzsz = null;
    this.zzta = null;
    this.zzki = null;
    this.origin = null;
  }
  
  public final Object getValue() {
    Long long_ = this.zzsy;
    if (long_ != null)
      return long_; 
    Double double_ = this.zzta;
    if (double_ != null)
      return double_; 
    String str = this.zzki;
    return (str != null) ? str : null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzsx);
    SafeParcelWriter.writeLongObject(paramParcel, 4, this.zzsy, false);
    SafeParcelWriter.writeFloatObject(paramParcel, 5, null, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzki, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.origin, false);
    SafeParcelWriter.writeDoubleObject(paramParcel, 8, this.zzta, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */