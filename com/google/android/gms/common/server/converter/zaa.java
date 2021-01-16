package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;

@Class(creator = "ConverterWrapperCreator")
public final class zaa extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zaa> CREATOR = new zab();
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(getter = "getStringToIntConverter", id = 2)
  private final StringToIntConverter zapk;
  
  @Constructor
  zaa(@Param(id = 1) int paramInt, @Param(id = 2) StringToIntConverter paramStringToIntConverter) {
    this.zale = paramInt;
    this.zapk = paramStringToIntConverter;
  }
  
  private zaa(StringToIntConverter paramStringToIntConverter) {
    this.zale = 1;
    this.zapk = paramStringToIntConverter;
  }
  
  public static zaa zaa(FastJsonResponse.FieldConverter<?, ?> paramFieldConverter) {
    if (paramFieldConverter instanceof StringToIntConverter)
      return new zaa((StringToIntConverter)paramFieldConverter); 
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zapk, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final FastJsonResponse.FieldConverter<?, ?> zaci() {
    StringToIntConverter stringToIntConverter = this.zapk;
    if (stringToIntConverter != null)
      return stringToIntConverter; 
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\converter\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */