package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ApiException extends Exception {
  protected final Status mStatus;
  
  public ApiException(@NonNull Status paramStatus) {
    super(stringBuilder.toString());
    String str;
    this.mStatus = paramStatus;
  }
  
  public int getStatusCode() {
    return this.mStatus.getStatusCode();
  }
  
  @Deprecated
  @Nullable
  public String getStatusMessage() {
    return this.mStatus.getStatusMessage();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\ApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */