package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
  private final Feature zzas;
  
  @KeepForSdk
  public UnsupportedApiCallException(Feature paramFeature) {
    this.zzas = paramFeature;
  }
  
  public final String getMessage() {
    String str = String.valueOf(this.zzas);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 8);
    stringBuilder.append("Missing ");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\UnsupportedApiCallException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */