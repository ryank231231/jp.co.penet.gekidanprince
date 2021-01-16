package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;

@PublicApi
public class FirebaseAuthException extends FirebaseException {
  private final String errorCode;
  
  @PublicApi
  public FirebaseAuthException(@NonNull String paramString1, @NonNull String paramString2) {
    super(paramString2);
    this.errorCode = Preconditions.checkNotEmpty(paramString1);
  }
  
  @NonNull
  @PublicApi
  public String getErrorCode() {
    return this.errorCode;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\auth\FirebaseAuthException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */