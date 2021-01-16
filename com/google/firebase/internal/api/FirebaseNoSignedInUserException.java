package com.google.firebase.internal.api;

import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseException;

@KeepForSdk
public class FirebaseNoSignedInUserException extends FirebaseException {
  @KeepForSdk
  public FirebaseNoSignedInUserException(@NonNull String paramString) {
    super(paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\internal\api\FirebaseNoSignedInUserException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */