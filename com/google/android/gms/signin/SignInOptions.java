package com.google.android.gms.signin;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

public final class SignInOptions implements Api.ApiOptions.Optional {
  public static final SignInOptions DEFAULT = new SignInOptions(false, false, null, false, null, false, null, null);
  
  private final boolean zaaa = false;
  
  private final String zaab = null;
  
  private final String zaac = null;
  
  private final boolean zars = false;
  
  private final boolean zart = false;
  
  private final Long zaru = null;
  
  private final Long zarv = null;
  
  private final boolean zay = false;
  
  private SignInOptions(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, String paramString2, boolean paramBoolean4, Long paramLong1, Long paramLong2) {}
  
  @Nullable
  public final Long getAuthApiSignInModuleVersion() {
    return this.zaru;
  }
  
  @Nullable
  public final String getHostedDomain() {
    return this.zaac;
  }
  
  @Nullable
  public final Long getRealClientLibraryVersion() {
    return this.zarv;
  }
  
  public final String getServerClientId() {
    return this.zaab;
  }
  
  public final boolean isForceCodeForRefreshToken() {
    return this.zaaa;
  }
  
  public final boolean isIdTokenRequested() {
    return this.zay;
  }
  
  public final boolean isOfflineAccessRequested() {
    return this.zars;
  }
  
  public final boolean waitForAccessTokenRefresh() {
    return this.zart;
  }
  
  static {
    new zaa();
  }
  
  public static final class zaa {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\signin\SignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */