package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;

@KeepForSdk
@VisibleForTesting
public final class SafeParcelableSerializer {
  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromBytes(byte[] paramArrayOfbyte, Parcelable.Creator<T> paramCreator) {
    Preconditions.checkNotNull(paramCreator);
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    parcel.setDataPosition(0);
    SafeParcelable safeParcelable = (SafeParcelable)paramCreator.createFromParcel(parcel);
    parcel.recycle();
    return (T)safeParcelable;
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator) {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra(paramString);
    return (arrayOfByte == null) ? null : deserializeFromBytes(arrayOfByte, paramCreator);
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromString(String paramString, Parcelable.Creator<T> paramCreator) {
    return deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
  }
  
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle paramBundle, String paramString, Parcelable.Creator<T> paramCreator) {
    ArrayList<ArrayList> arrayList1 = (ArrayList)paramBundle.getSerializable(paramString);
    if (arrayList1 == null)
      return null; 
    ArrayList<T> arrayList = new ArrayList(arrayList1.size());
    ArrayList<ArrayList> arrayList2 = arrayList1;
    int i = arrayList2.size();
    byte b = 0;
    while (b < i) {
      arrayList1 = arrayList2.get(b);
      b++;
      arrayList.add(deserializeFromBytes((byte[])arrayList1, paramCreator));
    } 
    return arrayList;
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator) {
    ArrayList<ArrayList> arrayList1 = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (arrayList1 == null)
      return null; 
    ArrayList<T> arrayList = new ArrayList(arrayList1.size());
    ArrayList<ArrayList> arrayList2 = arrayList1;
    int i = arrayList2.size();
    byte b = 0;
    while (b < i) {
      arrayList1 = arrayList2.get(b);
      b++;
      arrayList.add(deserializeFromBytes((byte[])arrayList1, paramCreator));
    } 
    return arrayList;
  }
  
  public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> paramIterable, Bundle paramBundle, String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramBundle.putSerializable(paramString, arrayList);
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> paramIterable, Intent paramIntent, String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramIntent.putExtra(paramString, arrayList);
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> byte[] serializeToBytes(T paramT) {
    Parcel parcel = Parcel.obtain();
    paramT.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> void serializeToIntentExtra(T paramT, Intent paramIntent, String paramString) {
    paramIntent.putExtra(paramString, serializeToBytes(paramT));
  }
  
  @KeepForSdk
  public static <T extends SafeParcelable> String serializeToString(T paramT) {
    return Base64Utils.encodeUrlSafe(serializeToBytes(paramT));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\safeparcel\SafeParcelableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */