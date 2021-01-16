package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable {
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zan();
  
  @Field(getter = "getConnectionResult", id = 3)
  private ConnectionResult zadh;
  
  @Field(getter = "getSaveDefaultAccount", id = 4)
  private boolean zagf;
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(id = 2)
  private IBinder zanw;
  
  @Field(getter = "isFromCrossClientAuth", id = 5)
  private boolean zapb;
  
  public ResolveAccountResponse(int paramInt) {
    this(new ConnectionResult(paramInt, null));
  }
  
  @Constructor
  ResolveAccountResponse(@Param(id = 1) int paramInt, @Param(id = 2) IBinder paramIBinder, @Param(id = 3) ConnectionResult paramConnectionResult, @Param(id = 4) boolean paramBoolean1, @Param(id = 5) boolean paramBoolean2) {
    this.zale = paramInt;
    this.zanw = paramIBinder;
    this.zadh = paramConnectionResult;
    this.zagf = paramBoolean1;
    this.zapb = paramBoolean2;
  }
  
  public ResolveAccountResponse(ConnectionResult paramConnectionResult) {
    this(1, null, paramConnectionResult, false, false);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof ResolveAccountResponse))
      return false; 
    paramObject = paramObject;
    return (this.zadh.equals(((ResolveAccountResponse)paramObject).zadh) && getAccountAccessor().equals(paramObject.getAccountAccessor()));
  }
  
  public IAccountAccessor getAccountAccessor() {
    return IAccountAccessor.Stub.asInterface(this.zanw);
  }
  
  public ConnectionResult getConnectionResult() {
    return this.zadh;
  }
  
  public boolean getSaveDefaultAccount() {
    return this.zagf;
  }
  
  public boolean isFromCrossClientAuth() {
    return this.zapb;
  }
  
  public ResolveAccountResponse setAccountAccessor(IAccountAccessor paramIAccountAccessor) {
    IBinder iBinder;
    if (paramIAccountAccessor == null) {
      paramIAccountAccessor = null;
    } else {
      iBinder = paramIAccountAccessor.asBinder();
    } 
    this.zanw = iBinder;
    return this;
  }
  
  public ResolveAccountResponse setIsFromCrossClientAuth(boolean paramBoolean) {
    this.zapb = paramBoolean;
    return this;
  }
  
  public ResolveAccountResponse setSaveDefaultAccount(boolean paramBoolean) {
    this.zagf = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zanw, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, getSaveDefaultAccount());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isFromCrossClientAuth());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\ResolveAccountResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */