package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
public class BooleanResult implements Result {
  private final Status mStatus;
  
  private final boolean zabg;
  
  @KeepForSdk
  @ShowFirstParty
  public BooleanResult(Status paramStatus, boolean paramBoolean) {
    this.mStatus = (Status)Preconditions.checkNotNull(paramStatus, "Status must not be null");
    this.zabg = paramBoolean;
  }
  
  @KeepForSdk
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof BooleanResult))
      return false; 
    paramObject = paramObject;
    return (this.mStatus.equals(((BooleanResult)paramObject).mStatus) && this.zabg == ((BooleanResult)paramObject).zabg);
  }
  
  @KeepForSdk
  public Status getStatus() {
    return this.mStatus;
  }
  
  @KeepForSdk
  public boolean getValue() {
    return this.zabg;
  }
  
  @KeepForSdk
  public final int hashCode() {
    return (this.mStatus.hashCode() + 527) * 31 + this.zabg;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\BooleanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */