package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ShowFirstParty
@Class(creator = "FieldMappingDictionaryCreator")
public final class zak extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zak> CREATOR = new zan();
  
  @VersionField(id = 1)
  private final int zale;
  
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zaqu;
  
  @Field(getter = "getSerializedDictionary", id = 2)
  private final ArrayList<zal> zaqv;
  
  @Field(getter = "getRootClassName", id = 3)
  private final String zaqw;
  
  @Constructor
  zak(@Param(id = 1) int paramInt, @Param(id = 2) ArrayList<zal> paramArrayList, @Param(id = 3) String paramString) {
    this.zale = paramInt;
    this.zaqv = null;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = paramArrayList.size();
    for (paramInt = 0; paramInt < i; paramInt++) {
      zal zal = paramArrayList.get(paramInt);
      String str = zal.className;
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
      int j = zal.zaqx.size();
      for (byte b = 0; b < j; b++) {
        zam zam = zal.zaqx.get(b);
        hashMap1.put(zam.zaqy, zam.zaqz);
      } 
      hashMap.put(str, hashMap1);
    } 
    this.zaqu = (HashMap)hashMap;
    this.zaqw = (String)Preconditions.checkNotNull(paramString);
    zacr();
  }
  
  public zak(Class<? extends FastJsonResponse> paramClass) {
    this.zale = 1;
    this.zaqv = null;
    this.zaqu = new HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>>();
    this.zaqw = paramClass.getCanonicalName();
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : this.zaqu.keySet()) {
      stringBuilder.append(str);
      stringBuilder.append(":\n");
      Map map = this.zaqu.get(str);
      for (String str1 : map.keySet()) {
        stringBuilder.append("  ");
        stringBuilder.append(str1);
        stringBuilder.append(": ");
        stringBuilder.append(map.get(str1));
      } 
    } 
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    ArrayList<zal> arrayList = new ArrayList();
    for (String str : this.zaqu.keySet())
      arrayList.add(new zal(str, this.zaqu.get(str))); 
    SafeParcelWriter.writeTypedList(paramParcel, 2, arrayList, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zaqw, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final void zaa(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap) {
    this.zaqu.put(paramClass.getCanonicalName(), paramMap);
  }
  
  public final boolean zaa(Class<? extends FastJsonResponse> paramClass) {
    return this.zaqu.containsKey(paramClass.getCanonicalName());
  }
  
  public final void zacr() {
    for (String str : this.zaqu.keySet()) {
      Map map = this.zaqu.get(str);
      Iterator<String> iterator = map.keySet().iterator();
      while (iterator.hasNext())
        ((FastJsonResponse.Field)map.get(iterator.next())).zaa(this); 
    } 
  }
  
  public final void zacs() {
    for (String str : this.zaqu.keySet()) {
      Map map = this.zaqu.get(str);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      for (String str1 : map.keySet())
        hashMap.put(str1, ((FastJsonResponse.Field)map.get(str1)).zacl()); 
      this.zaqu.put(str, hashMap);
    } 
  }
  
  public final String zact() {
    return this.zaqw;
  }
  
  public final Map<String, FastJsonResponse.Field<?, ?>> zai(String paramString) {
    return this.zaqu.get(paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\response\zak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */