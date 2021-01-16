package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public interface GoogleSignInOptionsExtension {
  @KeepForSdk
  public static final int FITNESS = 3;
  
  @KeepForSdk
  public static final int GAMES = 1;
  
  @KeepForSdk
  int getExtensionType();
  
  @Nullable
  @KeepForSdk
  List<Scope> getImpliedScopes();
  
  Bundle toBundle();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInOptionsExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */