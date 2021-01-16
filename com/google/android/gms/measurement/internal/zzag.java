package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;

@Class(creator = "EventParamsCreator")
@Reserved({1})
public final class zzag extends AbstractSafeParcelable implements Iterable<String> {
  public static final Parcelable.Creator<zzag> CREATOR = new zzai();
  
  @Field(getter = "z", id = 2)
  private final Bundle zzfm;
  
  @Constructor
  zzag(@Param(id = 2) Bundle paramBundle) {
    this.zzfm = paramBundle;
  }
  
  final Object get(String paramString) {
    return this.zzfm.get(paramString);
  }
  
  final Long getLong(String paramString) {
    return Long.valueOf(this.zzfm.getLong(paramString));
  }
  
  final String getString(String paramString) {
    return this.zzfm.getString(paramString);
  }
  
  public final Iterator<String> iterator() {
    return new zzah(this);
  }
  
  public final int size() {
    return this.zzfm.size();
  }
  
  public final String toString() {
    return this.zzfm.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, zzct(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  final Double zzaj(String paramString) {
    return Double.valueOf(this.zzfm.getDouble(paramString));
  }
  
  public final Bundle zzct() {
    return new Bundle(this.zzfm);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */