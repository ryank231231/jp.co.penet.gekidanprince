package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "AppMetadataCreator")
@Reserved({1, 20})
public final class zzm extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzm> CREATOR = new zzn();
  
  @Field(id = 2)
  public final String packageName;
  
  @Field(id = 3)
  public final String zzch;
  
  @Field(id = 12)
  public final String zzcj;
  
  @Field(id = 4)
  public final String zzcn;
  
  @Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
  public final long zzco;
  
  @Field(id = 5)
  public final String zzcp;
  
  @Field(id = 7)
  public final long zzcq;
  
  @Field(defaultValue = "true", id = 9)
  public final boolean zzcr;
  
  @Field(id = 13)
  public final long zzcs;
  
  @Field(defaultValue = "true", id = 16)
  public final boolean zzct;
  
  @Field(defaultValue = "true", id = 17)
  public final boolean zzcu;
  
  @Field(id = 19)
  public final String zzcv;
  
  @Field(id = 21)
  public final Boolean zzcw;
  
  @Field(id = 8)
  public final String zzdn;
  
  @Field(id = 10)
  public final boolean zzdo;
  
  @Field(id = 14)
  public final long zzdp;
  
  @Field(id = 15)
  public final int zzdq;
  
  @Field(id = 18)
  public final boolean zzdr;
  
  @Field(id = 6)
  public final long zzt;
  
  @Field(id = 22)
  public final long zzu;
  
  zzm(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString7, Boolean paramBoolean, long paramLong6) {
    Preconditions.checkNotEmpty(paramString1);
    this.packageName = paramString1;
    if (TextUtils.isEmpty(paramString2))
      paramString2 = null; 
    this.zzch = paramString2;
    this.zzcn = paramString3;
    this.zzco = paramLong1;
    this.zzcp = paramString4;
    this.zzt = paramLong2;
    this.zzcq = paramLong3;
    this.zzdn = paramString5;
    this.zzcr = paramBoolean1;
    this.zzdo = paramBoolean2;
    this.zzcj = paramString6;
    this.zzcs = paramLong4;
    this.zzdp = paramLong5;
    this.zzdq = paramInt;
    this.zzct = paramBoolean3;
    this.zzcu = paramBoolean4;
    this.zzdr = paramBoolean5;
    this.zzcv = paramString7;
    this.zzcw = paramBoolean;
    this.zzu = paramLong6;
  }
  
  @Constructor
  zzm(@Param(id = 2) String paramString1, @Param(id = 3) String paramString2, @Param(id = 4) String paramString3, @Param(id = 5) String paramString4, @Param(id = 6) long paramLong1, @Param(id = 7) long paramLong2, @Param(id = 8) String paramString5, @Param(id = 9) boolean paramBoolean1, @Param(id = 10) boolean paramBoolean2, @Param(id = 11) long paramLong3, @Param(id = 12) String paramString6, @Param(id = 13) long paramLong4, @Param(id = 14) long paramLong5, @Param(id = 15) int paramInt, @Param(id = 16) boolean paramBoolean3, @Param(id = 17) boolean paramBoolean4, @Param(id = 18) boolean paramBoolean5, @Param(id = 19) String paramString7, @Param(id = 21) Boolean paramBoolean, @Param(id = 22) long paramLong6) {
    this.packageName = paramString1;
    this.zzch = paramString2;
    this.zzcn = paramString3;
    this.zzco = paramLong3;
    this.zzcp = paramString4;
    this.zzt = paramLong1;
    this.zzcq = paramLong2;
    this.zzdn = paramString5;
    this.zzcr = paramBoolean1;
    this.zzdo = paramBoolean2;
    this.zzcj = paramString6;
    this.zzcs = paramLong4;
    this.zzdp = paramLong5;
    this.zzdq = paramInt;
    this.zzct = paramBoolean3;
    this.zzcu = paramBoolean4;
    this.zzdr = paramBoolean5;
    this.zzcv = paramString7;
    this.zzcw = paramBoolean;
    this.zzu = paramLong6;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzch, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzcn, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzcp, false);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zzt);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzcq);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzdn, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzcr);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzdo);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzco);
    SafeParcelWriter.writeString(paramParcel, 12, this.zzcj, false);
    SafeParcelWriter.writeLong(paramParcel, 13, this.zzcs);
    SafeParcelWriter.writeLong(paramParcel, 14, this.zzdp);
    SafeParcelWriter.writeInt(paramParcel, 15, this.zzdq);
    SafeParcelWriter.writeBoolean(paramParcel, 16, this.zzct);
    SafeParcelWriter.writeBoolean(paramParcel, 17, this.zzcu);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzdr);
    SafeParcelWriter.writeString(paramParcel, 19, this.zzcv, false);
    SafeParcelWriter.writeBooleanObject(paramParcel, 21, this.zzcw, false);
    SafeParcelWriter.writeLong(paramParcel, 22, this.zzu);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */