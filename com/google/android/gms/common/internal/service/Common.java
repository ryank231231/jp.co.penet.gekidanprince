package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

public final class Common {
  @KeepForSdk
  public static final Api<Api.ApiOptions.NoOptions> API;
  
  @KeepForSdk
  public static final Api.ClientKey<zai> CLIENT_KEY = new Api.ClientKey();
  
  private static final Api.AbstractClientBuilder<zai, Api.ApiOptions.NoOptions> zapg = new zab();
  
  public static final zac zaph;
  
  static {
    API = new Api("Common.API", zapg, CLIENT_KEY);
    zaph = new zad();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\service\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */