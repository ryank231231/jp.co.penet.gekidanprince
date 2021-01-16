package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
  
  private long durationMillis;
  
  @VersionField(id = 1)
  private final int versionCode;
  
  @Field(getter = "getTimeMillis", id = 2)
  private final long zzfo;
  
  @Field(getter = "getEventType", id = 11)
  private int zzfp;
  
  @Field(getter = "getWakeLockName", id = 4)
  private final String zzfq;
  
  @Field(getter = "getSecondaryWakeLockName", id = 10)
  private final String zzfr;
  
  @Field(getter = "getCodePackage", id = 17)
  private final String zzfs;
  
  @Field(getter = "getWakeLockType", id = 5)
  private final int zzft;
  
  @Field(getter = "getCallingPackages", id = 6)
  private final List<String> zzfu;
  
  @Field(getter = "getEventKey", id = 12)
  private final String zzfv;
  
  @Field(getter = "getElapsedRealtime", id = 8)
  private final long zzfw;
  
  @Field(getter = "getDeviceState", id = 14)
  private int zzfx;
  
  @Field(getter = "getHostPackage", id = 13)
  private final String zzfy;
  
  @Field(getter = "getBeginPowerPercentage", id = 15)
  private final float zzfz;
  
  @Field(getter = "getTimeout", id = 16)
  private final long zzga;
  
  @Field(getter = "getAcquiredWithTimeout", id = 18)
  private final boolean zzgb;
  
  @Constructor
  WakeLockEvent(@Param(id = 1) int paramInt1, @Param(id = 2) long paramLong1, @Param(id = 11) int paramInt2, @Param(id = 4) String paramString1, @Param(id = 5) int paramInt3, @Param(id = 6) List<String> paramList, @Param(id = 12) String paramString2, @Param(id = 8) long paramLong2, @Param(id = 14) int paramInt4, @Param(id = 10) String paramString3, @Param(id = 13) String paramString4, @Param(id = 15) float paramFloat, @Param(id = 16) long paramLong3, @Param(id = 17) String paramString5, @Param(id = 18) boolean paramBoolean) {
    this.versionCode = paramInt1;
    this.zzfo = paramLong1;
    this.zzfp = paramInt2;
    this.zzfq = paramString1;
    this.zzfr = paramString3;
    this.zzfs = paramString5;
    this.zzft = paramInt3;
    this.durationMillis = -1L;
    this.zzfu = paramList;
    this.zzfv = paramString2;
    this.zzfw = paramLong2;
    this.zzfx = paramInt4;
    this.zzfy = paramString4;
    this.zzfz = paramFloat;
    this.zzga = paramLong3;
    this.zzgb = paramBoolean;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5, boolean paramBoolean) {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5, paramBoolean);
  }
  
  public final int getEventType() {
    return this.zzfp;
  }
  
  public final long getTimeMillis() {
    return this.zzfo;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeLong(paramParcel, 2, super.getTimeMillis());
    SafeParcelWriter.writeString(paramParcel, 4, this.zzfq, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzft);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzfu, false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzfw);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzfr, false);
    SafeParcelWriter.writeInt(paramParcel, 11, super.getEventType());
    SafeParcelWriter.writeString(paramParcel, 12, this.zzfv, false);
    SafeParcelWriter.writeString(paramParcel, 13, this.zzfy, false);
    SafeParcelWriter.writeInt(paramParcel, 14, this.zzfx);
    SafeParcelWriter.writeFloat(paramParcel, 15, this.zzfz);
    SafeParcelWriter.writeLong(paramParcel, 16, this.zzga);
    SafeParcelWriter.writeString(paramParcel, 17, this.zzfs, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzgb);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final long zzu() {
    return this.durationMillis;
  }
  
  public final String zzv() {
    String str2;
    String str1 = this.zzfq;
    int i = this.zzft;
    List<String> list = this.zzfu;
    if (list == null) {
      str2 = "";
    } else {
      str2 = TextUtils.join(",", (Iterable)str2);
    } 
    int j = this.zzfx;
    String str3 = this.zzfr;
    String str4 = str3;
    if (str3 == null)
      str4 = ""; 
    String str5 = this.zzfy;
    str3 = str5;
    if (str5 == null)
      str3 = ""; 
    float f = this.zzfz;
    String str6 = this.zzfs;
    str5 = str6;
    if (str6 == null)
      str5 = ""; 
    boolean bool = this.zzgb;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 51 + String.valueOf(str2).length() + String.valueOf(str4).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
    stringBuilder.append("\t");
    stringBuilder.append(str1);
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(str2);
    stringBuilder.append("\t");
    stringBuilder.append(j);
    stringBuilder.append("\t");
    stringBuilder.append(str4);
    stringBuilder.append("\t");
    stringBuilder.append(str3);
    stringBuilder.append("\t");
    stringBuilder.append(f);
    stringBuilder.append("\t");
    stringBuilder.append(str5);
    stringBuilder.append("\t");
    stringBuilder.append(bool);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\stats\WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */