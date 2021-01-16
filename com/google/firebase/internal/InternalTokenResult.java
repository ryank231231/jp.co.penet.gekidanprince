package com.google.firebase.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;

@KeepForSdk
public class InternalTokenResult {
  private String token;
  
  @KeepForSdk
  public InternalTokenResult(@Nullable String paramString) {
    this.token = paramString;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof InternalTokenResult))
      return false; 
    paramObject = paramObject;
    return Objects.equal(this.token, ((InternalTokenResult)paramObject).token);
  }
  
  @Nullable
  @KeepForSdk
  public String getToken() {
    return this.token;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.token });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("token", this.token).toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\internal\InternalTokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */