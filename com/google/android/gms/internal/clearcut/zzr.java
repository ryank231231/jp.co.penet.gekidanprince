package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "PlayLoggerContextCreator")
@Reserved({1})
public final class zzr extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzr> CREATOR = new zzs();
  
  @Field(id = 2)
  private final String packageName;
  
  @Field(defaultValue = "true", id = 7)
  private final boolean zzay;
  
  @Field(id = 10)
  private final int zzaz;
  
  @Field(id = 3)
  private final int zzi;
  
  @Field(id = 8)
  public final String zzj;
  
  @Field(id = 4)
  public final int zzk;
  
  @Field(id = 5)
  private final String zzl;
  
  @Field(id = 6)
  private final String zzm;
  
  @Field(id = 9)
  private final boolean zzn;
  
  public zzr(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, zzge.zzv.zzb paramzzb) {
    this.packageName = (String)Preconditions.checkNotNull(paramString1);
    this.zzi = paramInt1;
    this.zzk = paramInt2;
    this.zzj = paramString2;
    this.zzl = paramString3;
    this.zzm = paramString4;
    this.zzay = paramBoolean ^ true;
    this.zzn = paramBoolean;
    this.zzaz = paramzzb.zzc();
  }
  
  @Constructor
  public zzr(@Param(id = 2) String paramString1, @Param(id = 3) int paramInt1, @Param(id = 4) int paramInt2, @Param(id = 5) String paramString2, @Param(id = 6) String paramString3, @Param(id = 7) boolean paramBoolean1, @Param(id = 8) String paramString4, @Param(id = 9) boolean paramBoolean2, @Param(id = 10) int paramInt3) {
    this.packageName = paramString1;
    this.zzi = paramInt1;
    this.zzk = paramInt2;
    this.zzl = paramString2;
    this.zzm = paramString3;
    this.zzay = paramBoolean1;
    this.zzj = paramString4;
    this.zzn = paramBoolean2;
    this.zzaz = paramInt3;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof zzr) {
      paramObject = paramObject;
      if (Objects.equal(this.packageName, ((zzr)paramObject).packageName) && this.zzi == ((zzr)paramObject).zzi && this.zzk == ((zzr)paramObject).zzk && Objects.equal(this.zzj, ((zzr)paramObject).zzj) && Objects.equal(this.zzl, ((zzr)paramObject).zzl) && Objects.equal(this.zzm, ((zzr)paramObject).zzm) && this.zzay == ((zzr)paramObject).zzay && this.zzn == ((zzr)paramObject).zzn && this.zzaz == ((zzr)paramObject).zzaz)
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.packageName, Integer.valueOf(this.zzi), Integer.valueOf(this.zzk), this.zzj, this.zzl, this.zzm, Boolean.valueOf(this.zzay), Boolean.valueOf(this.zzn), Integer.valueOf(this.zzaz) });
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PlayLoggerContext[");
    stringBuilder.append("package=");
    stringBuilder.append(this.packageName);
    stringBuilder.append(',');
    stringBuilder.append("packageVersionCode=");
    stringBuilder.append(this.zzi);
    stringBuilder.append(',');
    stringBuilder.append("logSource=");
    stringBuilder.append(this.zzk);
    stringBuilder.append(',');
    stringBuilder.append("logSourceName=");
    stringBuilder.append(this.zzj);
    stringBuilder.append(',');
    stringBuilder.append("uploadAccount=");
    stringBuilder.append(this.zzl);
    stringBuilder.append(',');
    stringBuilder.append("loggingId=");
    stringBuilder.append(this.zzm);
    stringBuilder.append(',');
    stringBuilder.append("logAndroidId=");
    stringBuilder.append(this.zzay);
    stringBuilder.append(',');
    stringBuilder.append("isAnonymous=");
    stringBuilder.append(this.zzn);
    stringBuilder.append(',');
    stringBuilder.append("qosTier=");
    stringBuilder.append(this.zzaz);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzi);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzk);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzl, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzm, false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzay);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzj, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzn);
    SafeParcelWriter.writeInt(paramParcel, 10, this.zzaz);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */