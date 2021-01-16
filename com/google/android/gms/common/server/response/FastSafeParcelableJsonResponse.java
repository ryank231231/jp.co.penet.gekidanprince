package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;

@KeepForSdk
@ShowFirstParty
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
  public final int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!getClass().isInstance(paramObject))
      return false; 
    FastJsonResponse fastJsonResponse = (FastJsonResponse)paramObject;
    paramObject = getFieldMappings().values().iterator();
    while (paramObject.hasNext()) {
      FastJsonResponse.Field field = paramObject.next();
      if (isFieldSet(field)) {
        if (fastJsonResponse.isFieldSet(field)) {
          if (!getFieldValue(field).equals(fastJsonResponse.getFieldValue(field)))
            return false; 
          continue;
        } 
        return false;
      } 
      if (fastJsonResponse.isFieldSet(field))
        return false; 
    } 
    return true;
  }
  
  @VisibleForTesting
  public Object getValueObject(String paramString) {
    return null;
  }
  
  public int hashCode() {
    Iterator<FastJsonResponse.Field> iterator = getFieldMappings().values().iterator();
    int i = 0;
    while (iterator.hasNext()) {
      FastJsonResponse.Field field = iterator.next();
      if (isFieldSet(field))
        i = i * 31 + getFieldValue(field).hashCode(); 
    } 
    return i;
  }
  
  @VisibleForTesting
  public boolean isPrimitiveFieldSet(String paramString) {
    return false;
  }
  
  @KeepForSdk
  public byte[] toByteArray() {
    Parcel parcel = Parcel.obtain();
    writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\response\FastSafeParcelableJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */