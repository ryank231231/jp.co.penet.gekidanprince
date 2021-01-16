package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
@Class(creator = "StringToIntConverterCreator")
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
  public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zac();
  
  @VersionField(id = 1)
  private final int zale = 1;
  
  private final HashMap<String, Integer> zapl = new HashMap<String, Integer>();
  
  private final SparseArray<String> zapm = new SparseArray();
  
  @Field(getter = "getSerializedMap", id = 2)
  private final ArrayList<zaa> zapn = null;
  
  @KeepForSdk
  public StringToIntConverter() {}
  
  @Constructor
  StringToIntConverter(@Param(id = 1) int paramInt, @Param(id = 2) ArrayList<zaa> paramArrayList) {
    paramArrayList = paramArrayList;
    int i = paramArrayList.size();
    paramInt = 0;
    while (paramInt < i) {
      zaa zaa = (zaa)paramArrayList.get(paramInt);
      paramInt++;
      zaa = zaa;
      add(zaa.zapo, zaa.zapp);
    } 
  }
  
  @KeepForSdk
  public final StringToIntConverter add(String paramString, int paramInt) {
    this.zapl.put(paramString, Integer.valueOf(paramInt));
    this.zapm.put(paramInt, paramString);
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    ArrayList<zaa> arrayList = new ArrayList();
    for (String str : this.zapl.keySet())
      arrayList.add(new zaa(str, ((Integer)this.zapl.get(str)).intValue())); 
    SafeParcelWriter.writeTypedList(paramParcel, 2, arrayList, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final int zacj() {
    return 7;
  }
  
  public final int zack() {
    return 0;
  }
  
  @Class(creator = "StringToIntConverterEntryCreator")
  public static final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zad();
    
    @VersionField(id = 1)
    private final int versionCode;
    
    @Field(id = 2)
    final String zapo;
    
    @Field(id = 3)
    final int zapp;
    
    @Constructor
    zaa(@Param(id = 1) int param1Int1, @Param(id = 2) String param1String, @Param(id = 3) int param1Int2) {
      this.versionCode = param1Int1;
      this.zapo = param1String;
      this.zapp = param1Int2;
    }
    
    zaa(String param1String, int param1Int) {
      this.versionCode = 1;
      this.zapo = param1String;
      this.zapp = param1Int;
    }
    
    public final void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Int = SafeParcelWriter.beginObjectHeader(param1Parcel);
      SafeParcelWriter.writeInt(param1Parcel, 1, this.versionCode);
      SafeParcelWriter.writeString(param1Parcel, 2, this.zapo, false);
      SafeParcelWriter.writeInt(param1Parcel, 3, this.zapp);
      SafeParcelWriter.finishObjectHeader(param1Parcel, param1Int);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\converter\StringToIntConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */