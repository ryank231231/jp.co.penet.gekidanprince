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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "EventParcelCreator")
@Reserved({1})
public final class zzaj extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
  
  @Field(id = 2)
  public final String name;
  
  @Field(id = 4)
  public final String origin;
  
  @Field(id = 3)
  public final zzag zzfd;
  
  @Field(id = 5)
  public final long zzfp;
  
  zzaj(zzaj paramzzaj, long paramLong) {
    Preconditions.checkNotNull(paramzzaj);
    this.name = paramzzaj.name;
    this.zzfd = paramzzaj.zzfd;
    this.origin = paramzzaj.origin;
    this.zzfp = paramLong;
  }
  
  @Constructor
  public zzaj(@Param(id = 2) String paramString1, @Param(id = 3) zzag paramzzag, @Param(id = 4) String paramString2, @Param(id = 5) long paramLong) {
    this.name = paramString1;
    this.zzfd = paramzzag;
    this.origin = paramString2;
    this.zzfp = paramLong;
  }
  
  public final String toString() {
    String str1 = this.origin;
    String str2 = this.name;
    String str3 = String.valueOf(this.zzfd);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str2).length() + String.valueOf(str3).length());
    stringBuilder.append("origin=");
    stringBuilder.append(str1);
    stringBuilder.append(",name=");
    stringBuilder.append(str2);
    stringBuilder.append(",params=");
    stringBuilder.append(str3);
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zzfd, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.origin, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzfp);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */