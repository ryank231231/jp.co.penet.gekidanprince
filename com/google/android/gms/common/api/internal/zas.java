package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

final class zas implements zabs {
  private final Context mContext;
  
  private final Looper zabj;
  
  private final zaaw zaed;
  
  private final zabe zaee;
  
  private final zabe zaef;
  
  private final Map<Api.AnyClientKey<?>, zabe> zaeg;
  
  private final Set<SignInConnectionListener> zaeh = Collections.newSetFromMap(new WeakHashMap<SignInConnectionListener, Boolean>());
  
  private final Api.Client zaei;
  
  private Bundle zaej;
  
  private ConnectionResult zaek = null;
  
  private ConnectionResult zael = null;
  
  private boolean zaem = false;
  
  private final Lock zaen;
  
  @GuardedBy("mLock")
  private int zaeo = 0;
  
  private zas(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, Map<Api.AnyClientKey<?>, Api.Client> paramMap2, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Api.Client paramClient, ArrayList<zaq> paramArrayList1, ArrayList<zaq> paramArrayList2, Map<Api<?>, Boolean> paramMap3, Map<Api<?>, Boolean> paramMap4) {
    this.mContext = paramContext;
    this.zaed = paramzaaw;
    this.zaen = paramLock;
    this.zabj = paramLooper;
    this.zaei = paramClient;
    this.zaee = new zabe(paramContext, this.zaed, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap2, null, paramMap4, null, paramArrayList2, new zau(this, null));
    this.zaef = new zabe(paramContext, this.zaed, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap1, paramClientSettings, paramMap3, paramAbstractClientBuilder, paramArrayList1, new zav(this, null));
    ArrayMap arrayMap = new ArrayMap();
    Iterator<Api.AnyClientKey> iterator = paramMap2.keySet().iterator();
    while (iterator.hasNext())
      arrayMap.put(iterator.next(), this.zaee); 
    iterator = paramMap1.keySet().iterator();
    while (iterator.hasNext())
      arrayMap.put(iterator.next(), this.zaef); 
    this.zaeg = Collections.unmodifiableMap((Map<? extends Api.AnyClientKey<?>, ? extends zabe>)arrayMap);
  }
  
  public static zas zaa(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList) {
    Api.Client client;
    ArrayMap<Api.AnyClientKey, Api.Client> arrayMap1 = new ArrayMap();
    ArrayMap<Api.AnyClientKey, Api.Client> arrayMap2 = new ArrayMap();
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    paramMap = null;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Api.Client client1 = (Api.Client)entry.getValue();
      if (client1.providesSignIn())
        client = client1; 
      if (client1.requiresSignIn()) {
        arrayMap1.put((Api.AnyClientKey)entry.getKey(), client1);
        continue;
      } 
      arrayMap2.put((Api.AnyClientKey)entry.getKey(), client1);
    } 
    Preconditions.checkState(arrayMap1.isEmpty() ^ true, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    ArrayMap<Api, Boolean> arrayMap3 = new ArrayMap();
    ArrayMap<Api, Boolean> arrayMap4 = new ArrayMap();
    for (Api<?> api : paramMap1.keySet()) {
      Api.AnyClientKey anyClientKey = api.getClientKey();
      if (arrayMap1.containsKey(anyClientKey)) {
        arrayMap3.put(api, paramMap1.get(api));
        continue;
      } 
      if (arrayMap2.containsKey(anyClientKey)) {
        arrayMap4.put(api, paramMap1.get(api));
        continue;
      } 
      throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
    } 
    ArrayList<zaq> arrayList1 = new ArrayList();
    ArrayList<zaq> arrayList2 = new ArrayList();
    paramArrayList = paramArrayList;
    int i = paramArrayList.size();
    byte b = 0;
    while (b < i) {
      zaq zaq = (zaq)paramArrayList.get(b);
      b++;
      zaq = zaq;
      if (arrayMap3.containsKey(zaq.mApi)) {
        arrayList1.add(zaq);
        continue;
      } 
      if (arrayMap4.containsKey(zaq.mApi)) {
        arrayList2.add(zaq);
        continue;
      } 
      throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
    } 
    return new zas(paramContext, paramzaaw, paramLock, paramLooper, paramGoogleApiAvailabilityLight, (Map)arrayMap1, (Map)arrayMap2, paramClientSettings, paramAbstractClientBuilder, client, arrayList1, arrayList2, (Map)arrayMap3, (Map)arrayMap4);
  }
  
  @GuardedBy("mLock")
  private final void zaa(int paramInt, boolean paramBoolean) {
    this.zaed.zab(paramInt, paramBoolean);
    this.zael = null;
    this.zaek = null;
  }
  
  private final void zaa(Bundle paramBundle) {
    Bundle bundle = this.zaej;
    if (bundle == null) {
      this.zaej = paramBundle;
      return;
    } 
    if (paramBundle != null)
      bundle.putAll(paramBundle); 
  }
  
  @GuardedBy("mLock")
  private final void zaa(ConnectionResult paramConnectionResult) {
    switch (this.zaeo) {
      default:
        Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        break;
      case 2:
        this.zaed.zac(paramConnectionResult);
      case 1:
        zay();
        break;
    } 
    this.zaeo = 0;
  }
  
  private final boolean zaa(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> paramApiMethodImpl) {
    Api.AnyClientKey<? extends Api.AnyClient> anyClientKey = paramApiMethodImpl.getClientKey();
    Preconditions.checkArgument(this.zaeg.containsKey(anyClientKey), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zabe)this.zaeg.get(anyClientKey)).equals(this.zaef);
  }
  
  @Nullable
  private final PendingIntent zaaa() {
    return (this.zaei == null) ? null : PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zaed), this.zaei.getSignInIntent(), 134217728);
  }
  
  private static boolean zab(ConnectionResult paramConnectionResult) {
    return (paramConnectionResult != null && paramConnectionResult.isSuccess());
  }
  
  @GuardedBy("mLock")
  private final void zax() {
    if (zab(this.zaek)) {
      if (zab(this.zael) || zaz()) {
        switch (this.zaeo) {
          default:
            Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            break;
          case 2:
            this.zaed.zab(this.zaej);
          case 1:
            zay();
            break;
        } 
        this.zaeo = 0;
        return;
      } 
      ConnectionResult connectionResult = this.zael;
      if (connectionResult != null) {
        if (this.zaeo == 1) {
          zay();
          return;
        } 
        zaa(connectionResult);
        this.zaee.disconnect();
        return;
      } 
    } else {
      if (this.zaek != null && zab(this.zael)) {
        this.zaef.disconnect();
        zaa(this.zaek);
        return;
      } 
      ConnectionResult connectionResult = this.zaek;
      if (connectionResult != null && this.zael != null) {
        if (this.zaef.zahr < this.zaee.zahr)
          connectionResult = this.zael; 
        zaa(connectionResult);
      } 
    } 
  }
  
  @GuardedBy("mLock")
  private final void zay() {
    Iterator<SignInConnectionListener> iterator = this.zaeh.iterator();
    while (iterator.hasNext())
      ((SignInConnectionListener)iterator.next()).onComplete(); 
    this.zaeh.clear();
  }
  
  @GuardedBy("mLock")
  private final boolean zaz() {
    ConnectionResult connectionResult = this.zael;
    return (connectionResult != null && connectionResult.getErrorCode() == 4);
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect() {
    throw new UnsupportedOperationException();
  }
  
  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit) {
    throw new UnsupportedOperationException();
  }
  
  @GuardedBy("mLock")
  public final void connect() {
    this.zaeo = 2;
    this.zaem = false;
    this.zael = null;
    this.zaek = null;
    this.zaee.connect();
    this.zaef.connect();
  }
  
  @GuardedBy("mLock")
  public final void disconnect() {
    this.zael = null;
    this.zaek = null;
    this.zaeo = 0;
    this.zaee.disconnect();
    this.zaef.disconnect();
    zay();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zaef.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.zaee.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT) {
    if (zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>)paramT)) {
      if (zaz()) {
        paramT.setFailedResult(new Status(4, null, zaaa()));
        return paramT;
      } 
      return this.zaef.enqueue(paramT);
    } 
    return this.zaee.enqueue(paramT);
  }
  
  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT) {
    if (zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>)paramT)) {
      if (zaz()) {
        paramT.setFailedResult(new Status(4, null, zaaa()));
        return paramT;
      } 
      return this.zaef.execute(paramT);
    } 
    return this.zaee.execute(paramT);
  }
  
  @Nullable
  @GuardedBy("mLock")
  public final ConnectionResult getConnectionResult(@NonNull Api<?> paramApi) {
    return ((zabe)this.zaeg.get(paramApi.getClientKey())).equals(this.zaef) ? (zaz() ? new ConnectionResult(4, zaaa()) : this.zaef.getConnectionResult(paramApi)) : this.zaee.getConnectionResult(paramApi);
  }
  
  public final boolean isConnected() {
    this.zaen.lock();
    try {
      boolean bool = this.zaee.isConnected();
      boolean bool1 = true;
      if (bool) {
        bool = bool1;
        if (!this.zaef.isConnected()) {
          bool = bool1;
          if (!zaz()) {
            int i = this.zaeo;
            if (i == 1) {
              bool = bool1;
              return bool;
            } 
          } else {
            return bool;
          } 
        } else {
          return bool;
        } 
      } 
      bool = false;
      return bool;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final boolean isConnecting() {
    this.zaen.lock();
    try {
      boolean bool;
      int i = this.zaeo;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener) {
    this.zaen.lock();
    try {
      if ((isConnecting() || isConnected()) && !this.zaef.isConnected()) {
        this.zaeh.add(paramSignInConnectionListener);
        if (this.zaeo == 0)
          this.zaeo = 1; 
        this.zael = null;
        this.zaef.connect();
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
      boolean bool = isConnecting();
      this.zaef.disconnect();
      ConnectionResult connectionResult = new ConnectionResult();
      this(4);
      this.zael = connectionResult;
      if (bool) {
        zal zal = new zal();
        this(this.zabj);
        zat zat = new zat();
        this(this);
        zal.post(zat);
      } else {
        zay();
      } 
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  @GuardedBy("mLock")
  public final void zaw() {
    this.zaee.zaw();
    this.zaef.zaw();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */