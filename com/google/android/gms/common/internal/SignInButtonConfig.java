package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "SignInButtonConfigCreator")
public class SignInButtonConfig extends AbstractSafeParcelable {
  public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zao();
  
  @VersionField(id = 1)
  private final int zale;
  
  @Deprecated
  @Field(getter = "getScopes", id = 4)
  private final Scope[] zanx;
  
  @Field(getter = "getButtonSize", id = 2)
  private final int zapc;
  
  @Field(getter = "getColorScheme", id = 3)
  private final int zapd;
  
  @Constructor
  SignInButtonConfig(@Param(id = 1) int paramInt1, @Param(id = 2) int paramInt2, @Param(id = 3) int paramInt3, @Param(id = 4) Scope[] paramArrayOfScope) {
    this.zale = paramInt1;
    this.zapc = paramInt2;
    this.zapd = paramInt3;
    this.zanx = paramArrayOfScope;
  }
  
  public SignInButtonConfig(int paramInt1, int paramInt2, Scope[] paramArrayOfScope) {
    this(1, paramInt1, paramInt2, null);
  }
  
  public int getButtonSize() {
    return this.zapc;
  }
  
  public int getColorScheme() {
    return this.zapd;
  }
  
  @Deprecated
  public Scope[] getScopes() {
    return this.zanx;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeInt(paramParcel, 2, getButtonSize());
    SafeParcelWriter.writeInt(paramParcel, 3, getColorScheme());
    SafeParcelWriter.writeTypedArray(paramParcel, 4, (Parcelable[])getScopes(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\SignInButtonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */