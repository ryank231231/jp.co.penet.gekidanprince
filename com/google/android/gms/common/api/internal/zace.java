package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace extends zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
  private static Api.AbstractClientBuilder<? extends zad, SignInOptions> zakh = zaa.zapg;
  
  private final Context mContext;
  
  private final Handler mHandler;
  
  private Set<Scope> mScopes;
  
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zaau;
  
  private ClientSettings zaes;
  
  private zad zaga;
  
  private zach zaki;
  
  @WorkerThread
  public zace(Context paramContext, Handler paramHandler, @NonNull ClientSettings paramClientSettings) {
    this(paramContext, paramHandler, paramClientSettings, zakh);
  }
  
  @WorkerThread
  public zace(Context paramContext, Handler paramHandler, @NonNull ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder) {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.zaes = (ClientSettings)Preconditions.checkNotNull(paramClientSettings, "ClientSettings must not be null");
    this.mScopes = paramClientSettings.getRequiredScopes();
    this.zaau = paramAbstractClientBuilder;
  }
  
  @WorkerThread
  private final void zac(zaj paramzaj) {
    String str;
    ConnectionResult connectionResult = paramzaj.getConnectionResult();
    if (connectionResult.isSuccess()) {
      ResolveAccountResponse resolveAccountResponse = paramzaj.zacw();
      ConnectionResult connectionResult1 = resolveAccountResponse.getConnectionResult();
      if (!connectionResult1.isSuccess()) {
        str = String.valueOf(connectionResult1);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
        stringBuilder.append("Sign-in succeeded with resolve account failure: ");
        stringBuilder.append(str);
        Log.wtf("SignInCoordinator", stringBuilder.toString(), new Exception());
        this.zaki.zag(connectionResult1);
        this.zaga.disconnect();
        return;
      } 
      this.zaki.zaa(str.getAccountAccessor(), this.mScopes);
    } else {
      this.zaki.zag((ConnectionResult)str);
    } 
    this.zaga.disconnect();
  }
  
  @WorkerThread
  public final void onConnected(@Nullable Bundle paramBundle) {
    this.zaga.zaa((zad)this);
  }
  
  @WorkerThread
  public final void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult) {
    this.zaki.zag(paramConnectionResult);
  }
  
  @WorkerThread
  public final void onConnectionSuspended(int paramInt) {
    this.zaga.disconnect();
  }
  
  @WorkerThread
  public final void zaa(zach paramzach) {
    zad zad1 = this.zaga;
    if (zad1 != null)
      zad1.disconnect(); 
    this.zaes.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
    Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.zaau;
    Context context = this.mContext;
    Looper looper = this.mHandler.getLooper();
    ClientSettings clientSettings = this.zaes;
    this.zaga = (zad)abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), this, this);
    this.zaki = paramzach;
    Set<Scope> set = this.mScopes;
    if (set == null || set.isEmpty()) {
      this.mHandler.post(new zacf(this));
      return;
    } 
    this.zaga.connect();
  }
  
  @BinderThread
  public final void zab(zaj paramzaj) {
    this.mHandler.post(new zacg(this, paramzaj));
  }
  
  public final zad zabq() {
    return this.zaga;
  }
  
  public final void zabs() {
    zad zad1 = this.zaga;
    if (zad1 != null)
      zad1.disconnect(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */