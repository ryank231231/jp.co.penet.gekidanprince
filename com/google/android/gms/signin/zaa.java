package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zaa {
  public static final Api<SignInOptions> API;
  
  private static final Api.ClientKey<SignInClientImpl> CLIENT_KEY = new Api.ClientKey();
  
  public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zapg;
  
  private static final Scope zar;
  
  @ShowFirstParty
  private static final Api.ClientKey<SignInClientImpl> zarp = new Api.ClientKey();
  
  private static final Api.AbstractClientBuilder<SignInClientImpl, Object> zarq;
  
  private static final Api<Object> zarr;
  
  private static final Scope zas;
  
  static {
    zapg = new zab();
    zarq = new zac();
    zar = new Scope("profile");
    zas = new Scope("email");
    API = new Api("SignIn.API", zapg, CLIENT_KEY);
    zarr = new Api("SignIn.INTERNAL_API", zarq, zarp);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\signin\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */