package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@KeepForSdk
@Class(creator = "ExperimentTokensCreator")
@Reserved({1})
public class ExperimentTokens extends AbstractSafeParcelable {
  @KeepForSdk
  public static final Parcelable.Creator<ExperimentTokens> CREATOR = new zzh();
  
  private static final zza zzaa;
  
  private static final byte[][] zzn = new byte[0][];
  
  private static final ExperimentTokens zzo;
  
  private static final zza zzx = new zzd();
  
  private static final zza zzy = new zze();
  
  private static final zza zzz = new zzf();
  
  @Field(id = 2)
  private final String zzp;
  
  @Field(id = 3)
  private final byte[] zzq;
  
  @Field(id = 4)
  private final byte[][] zzr;
  
  @Field(id = 5)
  private final byte[][] zzs;
  
  @Field(id = 6)
  private final byte[][] zzt;
  
  @Field(id = 7)
  private final byte[][] zzu;
  
  @Field(id = 8)
  private final int[] zzv;
  
  @Field(id = 9)
  private final byte[][] zzw;
  
  static {
    zzaa = new zzg();
  }
  
  @Constructor
  public ExperimentTokens(@Param(id = 2) String paramString, @Param(id = 3) byte[] paramArrayOfbyte, @Param(id = 4) byte[][] paramArrayOfbyte1, @Param(id = 5) byte[][] paramArrayOfbyte2, @Param(id = 6) byte[][] paramArrayOfbyte3, @Param(id = 7) byte[][] paramArrayOfbyte4, @Param(id = 8) int[] paramArrayOfint, @Param(id = 9) byte[][] paramArrayOfbyte5) {
    this.zzp = paramString;
    this.zzq = paramArrayOfbyte;
    this.zzr = paramArrayOfbyte1;
    this.zzs = paramArrayOfbyte2;
    this.zzt = paramArrayOfbyte3;
    this.zzu = paramArrayOfbyte4;
    this.zzv = paramArrayOfint;
    this.zzw = paramArrayOfbyte5;
  }
  
  private static List<Integer> zza(int[] paramArrayOfint) {
    if (paramArrayOfint == null)
      return Collections.emptyList(); 
    ArrayList<Integer> arrayList = new ArrayList(paramArrayOfint.length);
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i; b++)
      arrayList.add(Integer.valueOf(paramArrayOfint[b])); 
    Collections.sort(arrayList);
    return arrayList;
  }
  
  private static List<String> zza(byte[][] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return Collections.emptyList(); 
    ArrayList<String> arrayList = new ArrayList(paramArrayOfbyte.length);
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++)
      arrayList.add(Base64.encodeToString(paramArrayOfbyte[b], 3)); 
    Collections.sort(arrayList);
    return arrayList;
  }
  
  private static void zza(StringBuilder paramStringBuilder, String paramString, byte[][] paramArrayOfbyte) {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("=");
    if (paramArrayOfbyte == null) {
      paramString = "null";
    } else {
      paramStringBuilder.append("(");
      int i = paramArrayOfbyte.length;
      byte b = 0;
      boolean bool;
      for (bool = true; b < i; bool = false) {
        byte[] arrayOfByte = paramArrayOfbyte[b];
        if (!bool)
          paramStringBuilder.append(", "); 
        paramStringBuilder.append("'");
        paramStringBuilder.append(Base64.encodeToString(arrayOfByte, 3));
        paramStringBuilder.append("'");
        b++;
      } 
      paramString = ")";
    } 
    paramStringBuilder.append(paramString);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof ExperimentTokens) {
      paramObject = paramObject;
      if (zzn.equals(this.zzp, ((ExperimentTokens)paramObject).zzp) && Arrays.equals(this.zzq, ((ExperimentTokens)paramObject).zzq) && zzn.equals(zza(this.zzr), zza(((ExperimentTokens)paramObject).zzr)) && zzn.equals(zza(this.zzs), zza(((ExperimentTokens)paramObject).zzs)) && zzn.equals(zza(this.zzt), zza(((ExperimentTokens)paramObject).zzt)) && zzn.equals(zza(this.zzu), zza(((ExperimentTokens)paramObject).zzu)) && zzn.equals(zza(this.zzv), zza(((ExperimentTokens)paramObject).zzv)) && zzn.equals(zza(this.zzw), zza(((ExperimentTokens)paramObject).zzw)))
        return true; 
    } 
    return false;
  }
  
  public String toString() {
    String str4;
    String str3;
    String str2;
    StringBuilder stringBuilder = new StringBuilder("ExperimentTokens");
    stringBuilder.append("(");
    String str1 = this.zzp;
    if (str1 == null) {
      str4 = "null";
    } else {
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str1).length() + 2);
      stringBuilder1.append("'");
      stringBuilder1.append(str1);
      stringBuilder1.append("'");
      str4 = stringBuilder1.toString();
    } 
    stringBuilder.append(str4);
    stringBuilder.append(", ");
    byte[] arrayOfByte = this.zzq;
    stringBuilder.append("direct");
    stringBuilder.append("=");
    if (arrayOfByte == null) {
      str3 = "null";
    } else {
      stringBuilder.append("'");
      stringBuilder.append(Base64.encodeToString((byte[])str3, 3));
      str3 = "'";
    } 
    stringBuilder.append(str3);
    stringBuilder.append(", ");
    zza(stringBuilder, "GAIA", this.zzr);
    stringBuilder.append(", ");
    zza(stringBuilder, "PSEUDO", this.zzs);
    stringBuilder.append(", ");
    zza(stringBuilder, "ALWAYS", this.zzt);
    stringBuilder.append(", ");
    zza(stringBuilder, "OTHER", this.zzu);
    stringBuilder.append(", ");
    int[] arrayOfInt = this.zzv;
    stringBuilder.append("weak");
    stringBuilder.append("=");
    if (arrayOfInt == null) {
      str2 = "null";
    } else {
      stringBuilder.append("(");
      int i = str2.length;
      byte b = 0;
      boolean bool;
      for (bool = true; b < i; bool = false) {
        String str = str2[b];
        if (!bool)
          stringBuilder.append(", "); 
        stringBuilder.append(str);
        b++;
      } 
      str2 = ")";
    } 
    stringBuilder.append(str2);
    stringBuilder.append(", ");
    zza(stringBuilder, "directs", this.zzw);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzp, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, this.zzq, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 4, this.zzr, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 5, this.zzs, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 6, this.zzt, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 7, this.zzu, false);
    SafeParcelWriter.writeIntArray(paramParcel, 8, this.zzv, false);
    SafeParcelWriter.writeByteArrayArray(paramParcel, 9, this.zzw, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  static {
    byte[][] arrayOfByte = zzn;
    zzo = new ExperimentTokens("", null, arrayOfByte, arrayOfByte, arrayOfByte, arrayOfByte, null, null);
  }
  
  private static interface zza {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\phenotype\ExperimentTokens.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */