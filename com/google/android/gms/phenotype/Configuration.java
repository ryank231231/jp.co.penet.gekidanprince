package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@KeepForSdk
@Class(creator = "ConfigurationCreator")
@Reserved({1})
public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {
  @KeepForSdk
  public static final Parcelable.Creator<Configuration> CREATOR = new zzc();
  
  @Field(id = 2)
  private final int zzc;
  
  @Field(id = 3)
  private final zzi[] zzd;
  
  @Field(id = 4)
  private final String[] zze;
  
  private final Map<String, zzi> zzf;
  
  @Constructor
  public Configuration(@Param(id = 2) int paramInt, @Param(id = 3) zzi[] paramArrayOfzzi, @Param(id = 4) String[] paramArrayOfString) {
    this.zzc = paramInt;
    this.zzd = paramArrayOfzzi;
    this.zzf = new TreeMap<String, zzi>();
    int i = paramArrayOfzzi.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      zzi zzi1 = paramArrayOfzzi[paramInt];
      this.zzf.put(zzi1.name, zzi1);
    } 
    this.zze = paramArrayOfString;
    String[] arrayOfString = this.zze;
    if (arrayOfString != null)
      Arrays.sort((Object[])arrayOfString); 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Configuration) {
      paramObject = paramObject;
      if (this.zzc == ((Configuration)paramObject).zzc && zzn.equals(this.zzf, ((Configuration)paramObject).zzf) && Arrays.equals((Object[])this.zze, (Object[])((Configuration)paramObject).zze))
        return true; 
    } 
    return false;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("Configuration(");
    stringBuilder.append(this.zzc);
    stringBuilder.append(", ");
    stringBuilder.append("(");
    Iterator<zzi> iterator = this.zzf.values().iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next());
      stringBuilder.append(", ");
    } 
    stringBuilder.append(")");
    stringBuilder.append(", ");
    stringBuilder.append("(");
    String[] arrayOfString = this.zze;
    if (arrayOfString != null) {
      int i = arrayOfString.length;
      for (byte b = 0; b < i; b++) {
        stringBuilder.append(arrayOfString[b]);
        stringBuilder.append(", ");
      } 
    } else {
      stringBuilder.append("null");
    } 
    stringBuilder.append(")");
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzc);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, (Parcelable[])this.zzd, paramInt, false);
    SafeParcelWriter.writeStringArray(paramParcel, 4, this.zze, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\phenotype\Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */