package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@Class(creator = "ScopeCreator")
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<Scope> CREATOR = new zza();
  
  @Field(getter = "getScopeUri", id = 2)
  private final String zzaq;
  
  @VersionField(id = 1)
  private final int zzg;
  
  @Constructor
  Scope(@Param(id = 1) int paramInt, @Param(id = 2) String paramString) {
    Preconditions.checkNotEmpty(paramString, "scopeUri must not be null or empty");
    this.zzg = paramInt;
    this.zzaq = paramString;
  }
  
  public Scope(String paramString) {
    this(1, paramString);
  }
  
  public final boolean equals(Object paramObject) {
    return (this == paramObject) ? true : (!(paramObject instanceof Scope) ? false : this.zzaq.equals(((Scope)paramObject).zzaq));
  }
  
  @KeepForSdk
  public final String getScopeUri() {
    return this.zzaq;
  }
  
  public final int hashCode() {
    return this.zzaq.hashCode();
  }
  
  public final String toString() {
    return this.zzaq;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzg);
    SafeParcelWriter.writeString(paramParcel, 2, getScopeUri(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */