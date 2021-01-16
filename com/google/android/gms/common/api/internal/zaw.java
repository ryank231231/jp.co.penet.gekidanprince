package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

public final class zaw<O extends Api.ApiOptions> extends GoogleApi<O> {
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd;
  
  private final Api.Client zaeq;
  
  private final zaq zaer;
  
  private final ClientSettings zaes;
  
  public zaw(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper, @NonNull Api.Client paramClient, @NonNull zaq paramzaq, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder) {
    super(paramContext, paramApi, paramLooper);
    this.zaeq = paramClient;
    this.zaer = paramzaq;
    this.zaes = paramClientSettings;
    this.zacd = paramAbstractClientBuilder;
    this.zabm.zaa(this);
  }
  
  public final Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa) {
    this.zaer.zaa(paramzaa);
    return this.zaeq;
  }
  
  public final zace zaa(Context paramContext, Handler paramHandler) {
    return new zace(paramContext, paramHandler, this.zaes, this.zacd);
  }
  
  public final Api.Client zaab() {
    return this.zaeq;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */