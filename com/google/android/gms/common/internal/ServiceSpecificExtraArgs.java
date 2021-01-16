package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ServiceSpecificExtraArgs {
  @KeepForSdk
  public static interface CastExtraArgs {
    @KeepForSdk
    public static final String LISTENER = "listener";
  }
  
  @KeepForSdk
  public static interface GamesExtraArgs {
    @KeepForSdk
    public static final String DESIRED_LOCALE = "com.google.android.gms.games.key.desiredLocale";
    
    @KeepForSdk
    public static final String GAME_PACKAGE_NAME = "com.google.android.gms.games.key.gamePackageName";
    
    @KeepForSdk
    public static final String SIGNIN_OPTIONS = "com.google.android.gms.games.key.signInOptions";
    
    @KeepForSdk
    public static final String WINDOW_TOKEN = "com.google.android.gms.games.key.popupWindowToken";
  }
  
  @KeepForSdk
  public static interface PlusExtraArgs {
    @KeepForSdk
    public static final String PLUS_AUTH_PACKAGE = "auth_package";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\ServiceSpecificExtraArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */