package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;
import java.util.Comparator;

@Class(creator = "FlagCreator")
@Reserved({1})
public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
  public static final Parcelable.Creator<zzi> CREATOR = new zzk();
  
  private static final Comparator<zzi> zzai = new zzj();
  
  @Field(id = 2)
  public final String name;
  
  @Field(id = 3)
  private final long zzab;
  
  @Field(id = 4)
  private final boolean zzac;
  
  @Field(id = 5)
  private final double zzad;
  
  @Field(id = 6)
  private final String zzae;
  
  @Field(id = 7)
  private final byte[] zzaf;
  
  @Field(id = 8)
  private final int zzag;
  
  @Field(id = 9)
  public final int zzah;
  
  @Constructor
  public zzi(@Param(id = 2) String paramString1, @Param(id = 3) long paramLong, @Param(id = 4) boolean paramBoolean, @Param(id = 5) double paramDouble, @Param(id = 6) String paramString2, @Param(id = 7) byte[] paramArrayOfbyte, @Param(id = 8) int paramInt1, @Param(id = 9) int paramInt2) {
    this.name = paramString1;
    this.zzab = paramLong;
    this.zzac = paramBoolean;
    this.zzad = paramDouble;
    this.zzae = paramString2;
    this.zzaf = paramArrayOfbyte;
    this.zzag = paramInt1;
    this.zzah = paramInt2;
  }
  
  private static int compare(int paramInt1, int paramInt2) {
    return (paramInt1 < paramInt2) ? -1 : ((paramInt1 == paramInt2) ? 0 : 1);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject instanceof zzi) {
      paramObject = paramObject;
      if (zzn.equals(this.name, ((zzi)paramObject).name)) {
        int i = this.zzag;
        if (i == ((zzi)paramObject).zzag && this.zzah == ((zzi)paramObject).zzah) {
          switch (i) {
            default:
              paramObject = new StringBuilder(31);
              paramObject.append("Invalid enum value: ");
              paramObject.append(i);
              throw new AssertionError(paramObject.toString());
            case 5:
              return Arrays.equals(this.zzaf, ((zzi)paramObject).zzaf);
            case 4:
              return zzn.equals(this.zzae, ((zzi)paramObject).zzae);
            case 3:
              return (this.zzad == ((zzi)paramObject).zzad);
            case 2:
              return (this.zzac == ((zzi)paramObject).zzac);
            case 1:
              break;
          } 
          if (this.zzab == ((zzi)paramObject).zzab)
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  public final String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Flag(");
    stringBuilder.append(this.name);
    stringBuilder.append(", ");
    int i = this.zzag;
    switch (i) {
      default:
        str = this.name;
        stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
        stringBuilder.append("Invalid type: ");
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(i);
        throw new AssertionError(stringBuilder.toString());
      case 5:
        if (this.zzaf == null) {
          str = "null";
        } else {
          stringBuilder.append("'");
          str = Base64.encodeToString(this.zzaf, 3);
          stringBuilder.append(str);
          str = "'";
        } 
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzag);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzah);
        stringBuilder.append(")");
        return stringBuilder.toString();
      case 4:
        stringBuilder.append("'");
        str = this.zzae;
        stringBuilder.append(str);
        str = "'";
      case 3:
        stringBuilder.append(this.zzad);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzag);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzah);
        stringBuilder.append(")");
        return stringBuilder.toString();
      case 2:
        stringBuilder.append(this.zzac);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzag);
        stringBuilder.append(", ");
        stringBuilder.append(this.zzah);
        stringBuilder.append(")");
        return stringBuilder.toString();
      case 1:
        break;
    } 
    stringBuilder.append(this.zzab);
    stringBuilder.append(", ");
    stringBuilder.append(this.zzag);
    stringBuilder.append(", ");
    stringBuilder.append(this.zzah);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzab);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzac);
    SafeParcelWriter.writeDouble(paramParcel, 5, this.zzad);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzae, false);
    SafeParcelWriter.writeByteArray(paramParcel, 7, this.zzaf, false);
    SafeParcelWriter.writeInt(paramParcel, 8, this.zzag);
    SafeParcelWriter.writeInt(paramParcel, 9, this.zzah);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\phenotype\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */