package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zax implements zabs {
  private final Looper zabj;
  
  private final GoogleApiManager zabm;
  
  private final Lock zaen;
  
  private final ClientSettings zaes;
  
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaet = new HashMap<Api.AnyClientKey<?>, zaw<?>>();
  
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaeu = new HashMap<Api.AnyClientKey<?>, zaw<?>>();
  
  private final Map<Api<?>, Boolean> zaev;
  
  private final zaaw zaew;
  
  private final GoogleApiAvailabilityLight zaex;
  
  private final Condition zaey;
  
  private final boolean zaez;
  
  private final boolean zafa;
  
  private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafb = new LinkedList<BaseImplementation.ApiMethodImpl<?, ?>>();
  
  @GuardedBy("mLock")
  private boolean zafc;
  
  @GuardedBy("mLock")
  private Map<zai<?>, ConnectionResult> zafd;
  
  @GuardedBy("mLock")
  private Map<zai<?>, ConnectionResult> zafe;
  
  @GuardedBy("mLock")
  private zaaa zaff;
  
  @GuardedBy("mLock")
  private ConnectionResult zafg;
  
  public zax(Context paramContext, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList, zaaw paramzaaw, boolean paramBoolean) {
    this.zaen = paramLock;
    this.zabj = paramLooper;
    this.zaey = paramLock.newCondition();
    this.zaex = paramGoogleApiAvailabilityLight;
    this.zaew = paramzaaw;
    this.zaev = paramMap1;
    this.zaes = paramClientSettings;
    this.zaez = paramBoolean;
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    for (Api<?> api : paramMap1.keySet())
      hashMap1.put(api.getClientKey(), api); 
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    ArrayList<zaq> arrayList = paramArrayList;
    int i = arrayList.size();
    byte b = 0;
    while (b < i) {
      paramArrayList = (ArrayList<zaq>)arrayList.get(b);
      b++;
      zaq zaq = (zaq)paramArrayList;
      hashMap2.put(zaq.mApi, zaq);
    } 
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    paramBoolean = true;
    boolean bool = false;
    i = 1;
    b = 0;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Api<Api.ApiOptions> api = (Api)hashMap1.get(entry.getKey());
      Api.Client client = (Api.Client)entry.getValue();
      if (client.requiresGooglePlayServices()) {
        if (!((Boolean)this.zaev.get(api)).booleanValue()) {
          b = 1;
          bool = true;
        } else {
          bool = true;
        } 
      } else {
        i = 0;
      } 
      zaw<Api.ApiOptions> zaw = new zaw<Api.ApiOptions>(paramContext, api, paramLooper, client, (zaq)hashMap2.get(api), paramClientSettings, paramAbstractClientBuilder);
      this.zaet.put((Api.AnyClientKey)entry.getKey(), zaw);
      if (client.requiresSignIn())
        this.zaeu.put((Api.AnyClientKey)entry.getKey(), zaw); 
    } 
    if (!bool || i != 0 || b != 0)
      paramBoolean = false; 
    this.zafa = paramBoolean;
    this.zabm = GoogleApiManager.zabc();
  }
  
  @Nullable
  private final ConnectionResult zaa(@NonNull Api.AnyClientKey<?> paramAnyClientKey) {
    this.zaen.lock();
    try {
      zaw zaw = this.zaet.get(paramAnyClientKey);
      if (this.zafd != null && zaw != null)
        return this.zafd.get(zaw.zak()); 
      return null;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  private final boolean zaa(zaw<?> paramzaw, ConnectionResult paramConnectionResult) {
    return (!paramConnectionResult.isSuccess() && !paramConnectionResult.hasResolution() && ((Boolean)this.zaev.get(paramzaw.getApi())).booleanValue() && paramzaw.zaab().requiresGooglePlayServices() && this.zaex.isUserResolvableError(paramConnectionResult.getErrorCode()));
  }
  
  private final boolean zaac() {
    this.zaen.lock();
    try {
      if (!this.zafc || !this.zaez)
        return false; 
      Iterator<Api.AnyClientKey> iterator = this.zaeu.keySet().iterator();
      while (iterator.hasNext()) {
        ConnectionResult connectionResult = zaa(iterator.next());
        if (connectionResult != null) {
          boolean bool = connectionResult.isSuccess();
          if (!bool)
            return false; 
          continue;
        } 
        return false;
      } 
      return true;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  @GuardedBy("mLock")
  private final void zaad() {
    ClientSettings clientSettings = this.zaes;
    if (clientSettings == null) {
      this.zaew.zagz = Collections.emptySet();
      return;
    } 
    HashSet<Scope> hashSet = new HashSet(clientSettings.getRequiredScopes());
    Map map = this.zaes.getOptionalApiSettings();
    for (Api<?> api : (Iterable<Api<?>>)map.keySet()) {
      ConnectionResult connectionResult = getConnectionResult(api);
      if (connectionResult != null && connectionResult.isSuccess())
        hashSet.addAll(((ClientSettings.OptionalApiSettings)map.get(api)).mScopes); 
    } 
    this.zaew.zagz = hashSet;
  }
  
  @GuardedBy("mLock")
  private final void zaae() {
    while (!this.zafb.isEmpty())
      execute(this.zafb.remove()); 
    this.zaew.zab((Bundle)null);
  }
  
  @Nullable
  @GuardedBy("mLock")
  private final ConnectionResult zaaf() {
    Iterator<zaw> iterator = this.zaet.values().iterator();
    ConnectionResult connectionResult1 = null;
    ConnectionResult connectionResult2 = null;
    int i = 0;
    int j = 0;
    while (iterator.hasNext()) {
      zaw zaw = iterator.next();
      Api api = zaw.getApi();
      zai zai = zaw.zak();
      ConnectionResult connectionResult = this.zafd.get(zai);
      if (!connectionResult.isSuccess() && (!((Boolean)this.zaev.get(api)).booleanValue() || connectionResult.hasResolution() || this.zaex.isUserResolvableError(connectionResult.getErrorCode()))) {
        if (connectionResult.getErrorCode() == 4 && this.zaez) {
          int m = api.zah().getPriority();
          if (connectionResult2 == null || j > m) {
            connectionResult2 = connectionResult;
            j = m;
          } 
          continue;
        } 
        int k = api.zah().getPriority();
        if (connectionResult1 == null || i > k) {
          connectionResult1 = connectionResult;
          i = k;
        } 
      } 
    } 
    return (connectionResult1 != null && connectionResult2 != null && i > j) ? connectionResult2 : connectionResult1;
  }
  
  private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zab(@NonNull T paramT) {
    Api.AnyClientKey<?> anyClientKey = paramT.getClientKey();
    ConnectionResult connectionResult = zaa(anyClientKey);
    if (connectionResult != null && connectionResult.getErrorCode() == 4) {
      paramT.setFailedResult(new Status(4, null, this.zabm.zaa(((zaw)this.zaet.get(anyClientKey)).zak(), System.identityHashCode(this.zaew))));
      return true;
    } 
    return false;
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect() {
    connect();
    while (isConnecting()) {
      try {
        this.zaey.await();
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      } 
    } 
    if (isConnected())
      return ConnectionResult.RESULT_SUCCESS; 
    ConnectionResult connectionResult = this.zafg;
    return (connectionResult != null) ? connectionResult : new ConnectionResult(13, null);
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit) {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zaey.awaitNanos(paramLong)) {
      if (paramLong <= 0L)
        try {
          disconnect();
          return new ConnectionResult(14, null);
        } catch (InterruptedException interruptedException) {
          Thread.currentThread().interrupt();
          return new ConnectionResult(15, null);
        }  
    } 
    if (isConnected())
      return ConnectionResult.RESULT_SUCCESS; 
    ConnectionResult connectionResult = this.zafg;
    return (connectionResult != null) ? connectionResult : new ConnectionResult(13, null);
  }
  
  public final void connect() {
    this.zaen.lock();
    try {
      boolean bool = this.zafc;
      if (bool)
        return; 
      this.zafc = true;
      this.zafd = null;
      this.zafe = null;
      this.zaff = null;
      this.zafg = null;
      this.zabm.zao();
      Task<Map<zai<?>, String>> task = this.zabm.zaa(this.zaet.values());
      HandlerExecutor handlerExecutor = new HandlerExecutor();
      this(this.zabj);
      zaz zaz = new zaz();
      this(this, null);
      task.addOnCompleteListener((Executor)handlerExecutor, zaz);
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void disconnect() {
    this.zaen.lock();
    try {
      this.zafc = false;
      this.zafd = null;
      this.zafe = null;
      if (this.zaff != null) {
        this.zaff.cancel();
        this.zaff = null;
      } 
      this.zafg = null;
      while (!this.zafb.isEmpty()) {
        BaseImplementation.ApiMethodImpl apiMethodImpl = this.zafb.remove();
        apiMethodImpl.zaa((zacs)null);
        apiMethodImpl.cancel();
      } 
      this.zaey.signalAll();
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT) {
    if (this.zaez && zab((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>)paramT))
      return paramT; 
    if (!isConnected()) {
      this.zafb.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
      return paramT;
    } 
    this.zaew.zahe.zab((BasePendingResult<? extends Result>)paramT);
    return (T)((zaw)this.zaet.get(paramT.getClientKey())).doRead((BaseImplementation.ApiMethodImpl)paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT) {
    Api.AnyClientKey anyClientKey = paramT.getClientKey();
    if (this.zaez && zab((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>)paramT))
      return paramT; 
    this.zaew.zahe.zab((BasePendingResult<? extends Result>)paramT);
    return (T)((zaw)this.zaet.get(anyClientKey)).doWrite((BaseImplementation.ApiMethodImpl)paramT);
  }
  
  @Nullable
  public final ConnectionResult getConnectionResult(@NonNull Api<?> paramApi) {
    return zaa(paramApi.getClientKey());
  }
  
  public final boolean isConnected() {
    this.zaen.lock();
    try {
      if (this.zafd != null) {
        ConnectionResult connectionResult = this.zafg;
        if (connectionResult == null)
          return true; 
      } 
      return false;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final boolean isConnecting() {
    this.zaen.lock();
    try {
      if (this.zafd == null) {
        boolean bool = this.zafc;
        if (bool) {
          bool = true;
          return bool;
        } 
      } 
      return false;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener) {
    this.zaen.lock();
    try {
      if (this.zafc && !zaac()) {
        this.zabm.zao();
        zaaa zaaa1 = new zaaa();
        this(this, paramSignInConnectionListener);
        this.zaff = zaaa1;
        Task<Map<zai<?>, String>> task = this.zabm.zaa(this.zaeu.values());
        HandlerExecutor handlerExecutor = new HandlerExecutor();
        this(this.zabj);
        task.addOnCompleteListener((Executor)handlerExecutor, this.zaff);
        return true;
      } 
      return false;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void maybeSignOut() {
    this.zaen.lock();
    try {
      this.zabm.maybeSignOut();
      if (this.zaff != null) {
        this.zaff.cancel();
        this.zaff = null;
      } 
      if (this.zafe == null) {
        ArrayMap arrayMap = new ArrayMap();
        this(this.zaeu.size());
        this.zafe = (Map<zai<?>, ConnectionResult>)arrayMap;
      } 
      ConnectionResult connectionResult = new ConnectionResult();
      this(4);
      for (zaw<?> zaw : this.zaeu.values())
        this.zafe.put(zaw.zak(), connectionResult); 
      if (this.zafd != null)
        this.zafd.putAll(this.zafe); 
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void zaw() {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */