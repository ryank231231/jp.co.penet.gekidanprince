package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zaak implements zabd {
  private final Context mContext;
  
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd;
  
  private final Lock zaen;
  
  private final ClientSettings zaes;
  
  private final Map<Api<?>, Boolean> zaev;
  
  private final GoogleApiAvailabilityLight zaex;
  
  private ConnectionResult zafg;
  
  private final zabe zafs;
  
  private int zafv;
  
  private int zafw = 0;
  
  private int zafx;
  
  private final Bundle zafy = new Bundle();
  
  private final Set<Api.AnyClientKey> zafz = new HashSet<Api.AnyClientKey>();
  
  private zad zaga;
  
  private boolean zagb;
  
  private boolean zagc;
  
  private boolean zagd;
  
  private IAccountAccessor zage;
  
  private boolean zagf;
  
  private boolean zagg;
  
  private ArrayList<Future<?>> zagh = new ArrayList<Future<?>>();
  
  public zaak(zabe paramzabe, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Lock paramLock, Context paramContext) {
    this.zafs = paramzabe;
    this.zaes = paramClientSettings;
    this.zaev = paramMap;
    this.zaex = paramGoogleApiAvailabilityLight;
    this.zacd = paramAbstractClientBuilder;
    this.zaen = paramLock;
    this.mContext = paramContext;
  }
  
  @GuardedBy("mLock")
  private final void zaa(zaj paramzaj) {
    String str;
    if (!zac(0))
      return; 
    ConnectionResult connectionResult = paramzaj.getConnectionResult();
    if (connectionResult.isSuccess()) {
      ResolveAccountResponse resolveAccountResponse = paramzaj.zacw();
      ConnectionResult connectionResult1 = resolveAccountResponse.getConnectionResult();
      if (!connectionResult1.isSuccess()) {
        str = String.valueOf(connectionResult1);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
        stringBuilder.append("Sign-in succeeded with resolve account failure: ");
        stringBuilder.append(str);
        Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
        zae(connectionResult1);
        return;
      } 
      this.zagd = true;
      this.zage = str.getAccountAccessor();
      this.zagf = str.getSaveDefaultAccount();
      this.zagg = str.isFromCrossClientAuth();
      zaap();
      return;
    } 
    if (zad((ConnectionResult)str)) {
      zaar();
      zaap();
      return;
    } 
    zae((ConnectionResult)str);
  }
  
  @GuardedBy("mLock")
  private final boolean zaao() {
    int i = --this.zafx;
    if (i > 0)
      return false; 
    if (i < 0) {
      Log.w("GoogleApiClientConnecting", this.zafs.zaed.zaay());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zae(new ConnectionResult(8, null));
      return false;
    } 
    ConnectionResult connectionResult = this.zafg;
    if (connectionResult != null) {
      this.zafs.zahr = this.zafv;
      zae(connectionResult);
      return false;
    } 
    return true;
  }
  
  @GuardedBy("mLock")
  private final void zaap() {
    if (this.zafx != 0)
      return; 
    if (!this.zagc || this.zagd) {
      ArrayList<Api.Client> arrayList = new ArrayList();
      this.zafw = 1;
      this.zafx = this.zafs.zagy.size();
      for (Api.AnyClientKey<?> anyClientKey : this.zafs.zagy.keySet()) {
        if (this.zafs.zaho.containsKey(anyClientKey)) {
          if (zaao())
            zaaq(); 
          continue;
        } 
        arrayList.add(this.zafs.zagy.get(anyClientKey));
      } 
      if (!arrayList.isEmpty())
        this.zagh.add(zabh.zabb().submit(new zaaq(this, arrayList))); 
    } 
  }
  
  @GuardedBy("mLock")
  private final void zaaq() {
    Bundle bundle;
    this.zafs.zaba();
    zabh.zabb().execute(new zaal(this));
    zad zad1 = this.zaga;
    if (zad1 != null) {
      if (this.zagf)
        zad1.zaa(this.zage, this.zagg); 
      zab(false);
    } 
    for (Api.AnyClientKey<?> anyClientKey : this.zafs.zaho.keySet())
      ((Api.Client)this.zafs.zagy.get(anyClientKey)).disconnect(); 
    if (this.zafy.isEmpty()) {
      zad1 = null;
    } else {
      bundle = this.zafy;
    } 
    this.zafs.zahs.zab(bundle);
  }
  
  @GuardedBy("mLock")
  private final void zaar() {
    this.zagc = false;
    this.zafs.zaed.zagz = Collections.emptySet();
    for (Api.AnyClientKey<?> anyClientKey : this.zafz) {
      if (!this.zafs.zaho.containsKey(anyClientKey))
        this.zafs.zaho.put(anyClientKey, new ConnectionResult(17, null)); 
    } 
  }
  
  private final void zaas() {
    ArrayList<Future<?>> arrayList = this.zagh;
    int i = arrayList.size();
    byte b = 0;
    while (b < i) {
      Future future = (Future)arrayList.get(b);
      b++;
      ((Future)future).cancel(true);
    } 
    this.zagh.clear();
  }
  
  private final Set<Scope> zaat() {
    ClientSettings clientSettings = this.zaes;
    if (clientSettings == null)
      return Collections.emptySet(); 
    HashSet<Scope> hashSet = new HashSet(clientSettings.getRequiredScopes());
    Map map = this.zaes.getOptionalApiSettings();
    for (Api api : map.keySet()) {
      if (!this.zafs.zaho.containsKey(api.getClientKey()))
        hashSet.addAll(((ClientSettings.OptionalApiSettings)map.get(api)).mScopes); 
    } 
    return hashSet;
  }
  
  @GuardedBy("mLock")
  private final void zab(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual zah : ()Lcom/google/android/gms/common/api/Api$BaseClientBuilder;
    //   4: invokevirtual getPriority : ()I
    //   7: istore #4
    //   9: iconst_0
    //   10: istore #5
    //   12: iload_3
    //   13: ifeq -> 61
    //   16: aload_1
    //   17: invokevirtual hasResolution : ()Z
    //   20: ifeq -> 29
    //   23: iconst_1
    //   24: istore #6
    //   26: goto -> 52
    //   29: aload_0
    //   30: getfield zaex : Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   33: aload_1
    //   34: invokevirtual getErrorCode : ()I
    //   37: invokevirtual getErrorResolutionIntent : (I)Landroid/content/Intent;
    //   40: ifnull -> 49
    //   43: iconst_1
    //   44: istore #6
    //   46: goto -> 52
    //   49: iconst_0
    //   50: istore #6
    //   52: iload #5
    //   54: istore #7
    //   56: iload #6
    //   58: ifeq -> 84
    //   61: aload_0
    //   62: getfield zafg : Lcom/google/android/gms/common/ConnectionResult;
    //   65: ifnull -> 81
    //   68: iload #5
    //   70: istore #7
    //   72: iload #4
    //   74: aload_0
    //   75: getfield zafv : I
    //   78: if_icmpge -> 84
    //   81: iconst_1
    //   82: istore #7
    //   84: iload #7
    //   86: ifeq -> 100
    //   89: aload_0
    //   90: aload_1
    //   91: putfield zafg : Lcom/google/android/gms/common/ConnectionResult;
    //   94: aload_0
    //   95: iload #4
    //   97: putfield zafv : I
    //   100: aload_0
    //   101: getfield zafs : Lcom/google/android/gms/common/api/internal/zabe;
    //   104: getfield zaho : Ljava/util/Map;
    //   107: aload_2
    //   108: invokevirtual getClientKey : ()Lcom/google/android/gms/common/api/Api$AnyClientKey;
    //   111: aload_1
    //   112: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: return
  }
  
  private final void zab(boolean paramBoolean) {
    zad zad1 = this.zaga;
    if (zad1 != null) {
      if (zad1.isConnected() && paramBoolean)
        this.zaga.zacv(); 
      this.zaga.disconnect();
      this.zage = null;
    } 
  }
  
  @GuardedBy("mLock")
  private final boolean zac(int paramInt) {
    if (this.zafw != paramInt) {
      Log.w("GoogleApiClientConnecting", this.zafs.zaed.zaay());
      String str1 = String.valueOf(this);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 23);
      stringBuilder.append("Unexpected callback in ");
      stringBuilder.append(str1);
      Log.w("GoogleApiClientConnecting", stringBuilder.toString());
      int i = this.zafx;
      stringBuilder = new StringBuilder(33);
      stringBuilder.append("mRemainingConnections=");
      stringBuilder.append(i);
      Log.w("GoogleApiClientConnecting", stringBuilder.toString());
      str1 = zad(this.zafw);
      String str2 = zad(paramInt);
      stringBuilder = new StringBuilder(String.valueOf(str1).length() + 70 + String.valueOf(str2).length());
      stringBuilder.append("GoogleApiClient connecting is in step ");
      stringBuilder.append(str1);
      stringBuilder.append(" but received callback for step ");
      stringBuilder.append(str2);
      Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
      zae(new ConnectionResult(8, null));
      return false;
    } 
    return true;
  }
  
  private static String zad(int paramInt) {
    switch (paramInt) {
      default:
        return "UNKNOWN";
      case 1:
        return "STEP_GETTING_REMOTE_SERVICE";
      case 0:
        break;
    } 
    return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
  }
  
  @GuardedBy("mLock")
  private final boolean zad(ConnectionResult paramConnectionResult) {
    return (this.zagb && !paramConnectionResult.hasResolution());
  }
  
  @GuardedBy("mLock")
  private final void zae(ConnectionResult paramConnectionResult) {
    zaas();
    zab(paramConnectionResult.hasResolution() ^ true);
    this.zafs.zaf(paramConnectionResult);
    this.zafs.zahs.zac(paramConnectionResult);
  }
  
  public final void begin() {
    this.zafs.zaho.clear();
    this.zagc = false;
    this.zafg = null;
    this.zafw = 0;
    this.zagb = true;
    this.zagd = false;
    this.zagf = false;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Iterator<Api> iterator = this.zaev.keySet().iterator();
    int i = 0;
    while (iterator.hasNext()) {
      byte b;
      Api<?> api = iterator.next();
      Api.Client client = this.zafs.zagy.get(api.getClientKey());
      if (api.zah().getPriority() == 1) {
        b = 1;
      } else {
        b = 0;
      } 
      i |= b;
      boolean bool = ((Boolean)this.zaev.get(api)).booleanValue();
      if (client.requiresSignIn()) {
        this.zagc = true;
        if (bool) {
          this.zafz.add(api.getClientKey());
        } else {
          this.zagb = false;
        } 
      } 
      hashMap.put(client, new zaam(this, api, bool));
    } 
    if (i != 0)
      this.zagc = false; 
    if (this.zagc) {
      this.zaes.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zafs.zaed)));
      zaat zaat = new zaat(this, null);
      Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.zacd;
      Context context = this.mContext;
      Looper looper = this.zafs.zaed.getLooper();
      ClientSettings clientSettings = this.zaes;
      this.zaga = (zad)abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), zaat, zaat);
    } 
    this.zafx = this.zafs.zagy.size();
    this.zagh.add(zabh.zabb().submit(new zaan(this, (Map)hashMap)));
  }
  
  public final void connect() {}
  
  public final boolean disconnect() {
    zaas();
    zab(true);
    this.zafs.zaf(null);
    return true;
  }
  
  public final <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT) {
    this.zafs.zaed.zafb.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T execute(T paramT) {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  @GuardedBy("mLock")
  public final void onConnected(Bundle paramBundle) {
    if (!zac(1))
      return; 
    if (paramBundle != null)
      this.zafy.putAll(paramBundle); 
    if (zaao())
      zaaq(); 
  }
  
  @GuardedBy("mLock")
  public final void onConnectionSuspended(int paramInt) {
    zae(new ConnectionResult(8, null));
  }
  
  @GuardedBy("mLock")
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {
    if (!zac(1))
      return; 
    zab(paramConnectionResult, paramApi, paramBoolean);
    if (zaao())
      zaaq(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */