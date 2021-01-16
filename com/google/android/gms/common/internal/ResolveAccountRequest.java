package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "ResolveAccountRequestCreator")
public class ResolveAccountRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zam();
  
  @VersionField(id = 1)
  private final int zale;
  
  @Field(getter = "getSessionId", id = 3)
  private final int zaoz;
  
  @Field(getter = "getSignInAccountHint", id = 4)
  private final GoogleSignInAccount zapa;
  
  @Field(getter = "getAccount", id = 2)
  private final Account zax;
  
  @Constructor
  ResolveAccountRequest(@Param(id = 1) int paramInt1, @Param(id = 2) Account paramAccount, @Param(id = 3) int paramInt2, @Param(id = 4) GoogleSignInAccount paramGoogleSignInAccount) {
    this.zale = paramInt1;
    this.zax = paramAccount;
    this.zaoz = paramInt2;
    this.zapa = paramGoogleSignInAccount;
  }
  
  public ResolveAccountRequest(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount) {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public Account getAccount() {
    return this.zax;
  }
  
  public int getSessionId() {
    return this.zaoz;
  }
  
  @Nullable
  public GoogleSignInAccount getSignInAccountHint() {
    return this.zapa;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)getAccount(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getSessionId());
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)getSignInAccountHint(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\ResolveAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */