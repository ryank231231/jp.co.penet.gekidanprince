package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.Arrays;

@Class(creator = "LogEventParcelableCreator")
@Reserved({1})
public final class zze extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zze> CREATOR = new zzf();
  
  public final zzha zzaa;
  
  @Field(id = 2)
  public zzr zzag;
  
  @Field(id = 3)
  public byte[] zzah;
  
  @Field(id = 4)
  private int[] zzai;
  
  @Field(id = 5)
  private String[] zzaj;
  
  @Field(id = 6)
  private int[] zzak;
  
  @Field(id = 7)
  private byte[][] zzal;
  
  @Field(id = 9)
  private ExperimentTokens[] zzam;
  
  public final ClearcutLogger.zzb zzan;
  
  public final ClearcutLogger.zzb zzt;
  
  @Field(defaultValue = "true", id = 8)
  private boolean zzz;
  
  public zze(zzr paramzzr, zzha paramzzha, ClearcutLogger.zzb paramzzb1, ClearcutLogger.zzb paramzzb2, int[] paramArrayOfint1, String[] paramArrayOfString, int[] paramArrayOfint2, byte[][] paramArrayOfbyte, ExperimentTokens[] paramArrayOfExperimentTokens, boolean paramBoolean) {
    this.zzag = paramzzr;
    this.zzaa = paramzzha;
    this.zzt = paramzzb1;
    this.zzan = null;
    this.zzai = paramArrayOfint1;
    this.zzaj = null;
    this.zzak = paramArrayOfint2;
    this.zzal = null;
    this.zzam = null;
    this.zzz = paramBoolean;
  }
  
  @Constructor
  zze(@Param(id = 2) zzr paramzzr, @Param(id = 3) byte[] paramArrayOfbyte, @Param(id = 4) int[] paramArrayOfint1, @Param(id = 5) String[] paramArrayOfString, @Param(id = 6) int[] paramArrayOfint2, @Param(id = 7) byte[][] paramArrayOfbyte1, @Param(id = 8) boolean paramBoolean, @Param(id = 9) ExperimentTokens[] paramArrayOfExperimentTokens) {
    this.zzag = paramzzr;
    this.zzah = paramArrayOfbyte;
    this.zzai = paramArrayOfint1;
    this.zzaj = paramArrayOfString;
    this.zzaa = null;
    this.zzt = null;
    this.zzan = null;
    this.zzak = paramArrayOfint2;
    this.zzal = paramArrayOfbyte1;
    this.zzam = paramArrayOfExperimentTokens;
    this.zzz = paramBoolean;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof zze) {
      paramObject = paramObject;
      if (Objects.equal(this.zzag, ((zze)paramObject).zzag) && Arrays.equals(this.zzah, ((zze)paramObject).zzah) && Arrays.equals(this.zzai, ((zze)paramObject).zzai) && Arrays.equals((Object[])this.zzaj, (Object[])((zze)paramObject).zzaj) && Objects.equal(this.zzaa, ((zze)paramObject).zzaa) && Objects.equal(this.zzt, ((zze)paramObject).zzt) && Objects.equal(this.zzan, ((zze)paramObject).zzan) && Arrays.equals(this.zzak, ((zze)paramObject).zzak) && Arrays.deepEquals((Object[])this.zzal, (Object[])((zze)paramObject).zzal) && Arrays.equals((Object[])this.zzam, (Object[])((zze)paramObject).zzam) && this.zzz == ((zze)paramObject).zzz)
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { 
          this.zzag, this.zzah, this.zzai, this.zzaj, this.zzaa, this.zzt, this.zzan, this.zzak, this.zzal, this.zzam, 
          Boolean.valueOf(this.zzz) });
  }
  
  public final String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder("LogEventParcelable[");
    stringBuilder.append(this.zzag);
    stringBuilder.append(", LogEventBytes: ");
    byte[] arrayOfByte = this.zzah;
    if (arrayOfByte == null) {
      arrayOfByte = null;
    } else {
      str = new String(arrayOfByte);
    } 
    stringBuilder.append(str);
    stringBuilder.append(", TestCodes: ");
    stringBuilder.append(Arrays.toString(this.zzai));
    stringBuilder.append(", MendelPackages: ");
    stringBuilder.append(Arrays.toString((Object[])this.zzaj));
    stringBuilder.append(", LogEvent: ");
    stringBuilder.append(this.zzaa);
    stringBuilder.append(", ExtensionProducer: ");
    stringBuilder.append(this.zzt);
    stringBuilder.append(", VeProducer: ");
    stringBuilder.append(this.zzan);
    stringBuilder.append(", ExperimentIDs: ");
    stringBuilder.append(Arrays.toString(this.zzak));
    stringBuilder.append(", ExperimentTokens: ");
    stringBuilder.append(Arrays.toString((Object[])this.zzal));
    stringBuilder.append(", ExperimentTokensParcelables: ");
    stringBuilder.append(Arrays.toString((Object[])this.zzam));
    stringBuilder.append(", AddPhenotypeExperimentTokens: ");
    stringBuilder.append(this.zzz);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zzag, paramInt, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, this.zzah, false);
    SafeParcelWriter.writeIntArray(paramParcel, 4, this.zzai, false);
    SafeParcelWriter.writeStringArray(paramParcel, 5, this.zzaj, false);
    SafeParcelWriter.writeIntArray(paramParcel, 6, this.zzak, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 7, this.zzal, false);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzz);
    SafeParcelWriter.writeTypedArray(paramParcel, 9, (Parcelable[])this.zzam, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\clearcut\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */