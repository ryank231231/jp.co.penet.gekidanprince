package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@ShowFirstParty
@Class(creator = "FieldMappingDictionaryEntryCreator")
public final class zal extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zal> CREATOR = new zao();
  
  @Field(id = 2)
  final String className;
  
  @VersionField(id = 1)
  private final int versionCode;
  
  @Field(id = 3)
  final ArrayList<zam> zaqx;
  
  @Constructor
  zal(@Param(id = 1) int paramInt, @Param(id = 2) String paramString, @Param(id = 3) ArrayList<zam> paramArrayList) {
    this.versionCode = paramInt;
    this.className = paramString;
    this.zaqx = paramArrayList;
  }
  
  zal(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap) {
    String str;
    this.versionCode = 1;
    this.className = paramString;
    if (paramMap == null) {
      paramString = null;
    } else {
      ArrayList<zam> arrayList = new ArrayList();
      Iterator<String> iterator = paramMap.keySet().iterator();
      while (true) {
        ArrayList<zam> arrayList1 = arrayList;
        if (iterator.hasNext()) {
          str = iterator.next();
          arrayList.add(new zam(str, paramMap.get(str)));
          continue;
        } 
        break;
      } 
    } 
    this.zaqx = (ArrayList<zam>)str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.className, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zaqx, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\response\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */