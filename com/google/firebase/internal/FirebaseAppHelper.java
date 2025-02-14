package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;

@Deprecated
@KeepForSdk
public class FirebaseAppHelper {
  @KeepForSdk
  public static void addIdTokenListener(FirebaseApp paramFirebaseApp, FirebaseApp.IdTokenListener paramIdTokenListener) {
    paramFirebaseApp.addIdTokenListener(paramIdTokenListener);
  }
  
  @KeepForSdk
  public static Task<GetTokenResult> getToken(FirebaseApp paramFirebaseApp, boolean paramBoolean) {
    return paramFirebaseApp.getToken(paramBoolean);
  }
  
  @KeepForSdk
  public static String getUid(FirebaseApp paramFirebaseApp) throws FirebaseApiNotAvailableException {
    return paramFirebaseApp.getUid();
  }
  
  @KeepForSdk
  public static void removeIdTokenListener(FirebaseApp paramFirebaseApp, FirebaseApp.IdTokenListener paramIdTokenListener) {
    paramFirebaseApp.removeIdTokenListener(paramIdTokenListener);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\internal\FirebaseAppHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */