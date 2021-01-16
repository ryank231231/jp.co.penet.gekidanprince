package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@Class(creator = "AuthAccountRequestCreator")
public class AuthAccountRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zaa();
  
  @VersionField(id = 1)
  private final int zale;
  
  @Deprecated
  @Field(id = 2)
  private final IBinder zanw;
  
  @Field(id = 3)
  private final Scope[] zanx;
  
  @Field(id = 4)
  private Integer zany;
  
  @Field(id = 5)
  private Integer zanz;
  
  @Field(id = 6, type = "android.accounts.Account")
  private Account zax;
  
  @Constructor
  AuthAccountRequest(@Param(id = 1) int paramInt, @Param(id = 2) IBinder paramIBinder, @Param(id = 3) Scope[] paramArrayOfScope, @Param(id = 4) Integer paramInteger1, @Param(id = 5) Integer paramInteger2, @Param(id = 6) Account paramAccount) {
    this.zale = paramInt;
    this.zanw = paramIBinder;
    this.zanx = paramArrayOfScope;
    this.zany = paramInteger1;
    this.zanz = paramInteger2;
    this.zax = paramAccount;
  }
  
  public AuthAccountRequest(Account paramAccount, Set<Scope> paramSet) {
    this(3, null, paramSet.<Scope>toArray(new Scope[paramSet.size()]), null, null, Preconditions.<Account>checkNotNull(paramAccount));
  }
  
  @Deprecated
  public AuthAccountRequest(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet) {
    this(3, paramIAccountAccessor.asBinder(), paramSet.<Scope>toArray(new Scope[paramSet.size()]), null, null, null);
  }
  
  public Account getAccount() {
    IBinder iBinder;
    Account account = this.zax;
    if (account == null) {
      iBinder = this.zanw;
      if (iBinder != null) {
        Account account1 = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder));
      } else {
        iBinder = null;
      } 
    } 
    return (Account)iBinder;
  }
  
  @Nullable
  public Integer getOauthPolicy() {
    return this.zany;
  }
  
  @Nullable
  public Integer getPolicyAction() {
    return this.zanz;
  }
  
  public Set<Scope> getScopes() {
    return new HashSet<Scope>(Arrays.asList(this.zanx));
  }
  
  public AuthAccountRequest setOauthPolicy(@Nullable Integer paramInteger) {
    this.zany = paramInteger;
    return this;
  }
  
  public AuthAccountRequest setPolicyAction(@Nullable Integer paramInteger) {
    this.zanz = paramInteger;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zanw, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, (Parcelable[])this.zanx, paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 4, this.zany, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, this.zanz, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, (Parcelable)this.zax, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\AuthAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */