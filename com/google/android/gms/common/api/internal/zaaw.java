package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zaaw extends GoogleApiClient implements zabt {
  private final Context mContext;
  
  private final Looper zabj;
  
  private final int zaca;
  
  private final GoogleApiAvailability zacc;
  
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd;
  
  private boolean zacg;
  
  private final Lock zaen;
  
  private final ClientSettings zaes;
  
  private final Map<Api<?>, Boolean> zaev;
  
  @VisibleForTesting
  final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafb;
  
  private final GmsClientEventManager zagr;
  
  private zabs zags;
  
  private volatile boolean zagt;
  
  private long zagu;
  
  private long zagv;
  
  private final zabb zagw;
  
  @VisibleForTesting
  private zabq zagx;
  
  final Map<Api.AnyClientKey<?>, Api.Client> zagy;
  
  Set<Scope> zagz;
  
  private final ListenerHolders zaha;
  
  private final ArrayList<zaq> zahb;
  
  private Integer zahc;
  
  Set<zacm> zahd;
  
  final zacp zahe;
  
  private final GmsClientEventManager.GmsClientEventState zahf;
  
  public zaaw(Context paramContext, Lock paramLock, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiAvailability paramGoogleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Map<Api<?>, Boolean> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, int paramInt1, int paramInt2, ArrayList<zaq> paramArrayList, boolean paramBoolean) {
    long l;
    this.zags = null;
    this.zafb = new LinkedList<BaseImplementation.ApiMethodImpl<?, ?>>();
    if (ClientLibraryUtils.isPackageSide()) {
      l = 10000L;
    } else {
      l = 120000L;
    } 
    this.zagu = l;
    this.zagv = 5000L;
    this.zagz = new HashSet<Scope>();
    this.zaha = new ListenerHolders();
    this.zahc = null;
    this.zahd = null;
    this.zahf = new zaax(this);
    this.mContext = paramContext;
    this.zaen = paramLock;
    this.zacg = false;
    this.zagr = new GmsClientEventManager(paramLooper, this.zahf);
    this.zabj = paramLooper;
    this.zagw = new zabb(this, paramLooper);
    this.zacc = paramGoogleApiAvailability;
    this.zaca = paramInt1;
    if (this.zaca >= 0)
      this.zahc = Integer.valueOf(paramInt2); 
    this.zaev = paramMap;
    this.zagy = paramMap1;
    this.zahb = paramArrayList;
    this.zahe = new zacp(this.zagy);
    for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : paramList)
      this.zagr.registerConnectionCallbacks(connectionCallbacks); 
    for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : paramList1)
      this.zagr.registerConnectionFailedListener(onConnectionFailedListener); 
    this.zaes = paramClientSettings;
    this.zacd = paramAbstractClientBuilder;
  }
  
  private final void resume() {
    this.zaen.lock();
    try {
      if (this.zagt)
        zaau(); 
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public static int zaa(Iterable<Api.Client> paramIterable, boolean paramBoolean) {
    Iterator<Api.Client> iterator = paramIterable.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    while (iterator.hasNext()) {
      Api.Client client = iterator.next();
      boolean bool = bool1;
      if (client.requiresSignIn())
        bool = true; 
      bool1 = bool;
      if (client.providesSignIn()) {
        bool2 = true;
        bool1 = bool;
      } 
    } 
    return bool1 ? ((bool2 && paramBoolean) ? 2 : 1) : 3;
  }
  
  private final void zaa(GoogleApiClient paramGoogleApiClient, StatusPendingResult paramStatusPendingResult, boolean paramBoolean) {
    Common.zaph.zaa(paramGoogleApiClient).setResultCallback(new zaba(this, paramStatusPendingResult, paramBoolean, paramGoogleApiClient));
  }
  
  @GuardedBy("mLock")
  private final void zaau() {
    this.zagr.enableCallbacks();
    this.zags.connect();
  }
  
  private final void zaav() {
    this.zaen.lock();
    try {
      if (zaaw())
        zaau(); 
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  private final void zae(int paramInt) {
    Integer integer = this.zahc;
    if (integer == null) {
      this.zahc = Integer.valueOf(paramInt);
    } else if (integer.intValue() != paramInt) {
      String str2 = zaf(paramInt);
      String str1 = zaf(this.zahc.intValue());
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 51 + String.valueOf(str1).length());
      stringBuilder.append("Cannot use sign-in mode: ");
      stringBuilder.append(str2);
      stringBuilder.append(". Mode was already set to ");
      stringBuilder.append(str1);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    if (this.zags != null)
      return; 
    Iterator<Api.Client> iterator = this.zagy.values().iterator();
    boolean bool = false;
    paramInt = 0;
    while (iterator.hasNext()) {
      Api.Client client = iterator.next();
      boolean bool1 = bool;
      if (client.requiresSignIn())
        bool1 = true; 
      bool = bool1;
      if (client.providesSignIn()) {
        paramInt = 1;
        bool = bool1;
      } 
    } 
    switch (this.zahc.intValue()) {
      case 2:
        if (bool) {
          if (this.zacg) {
            this.zags = new zax(this.mContext, this.zaen, this.zabj, (GoogleApiAvailabilityLight)this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb, this, true);
            return;
          } 
          this.zags = zas.zaa(this.mContext, this, this.zaen, this.zabj, (GoogleApiAvailabilityLight)this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb);
          return;
        } 
        break;
      case 1:
        if (bool) {
          if (paramInt == 0)
            break; 
          throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
        } 
        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
    } 
    if (this.zacg && paramInt == 0) {
      this.zags = new zax(this.mContext, this.zaen, this.zabj, (GoogleApiAvailabilityLight)this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb, this, false);
      return;
    } 
    this.zags = new zabe(this.mContext, this, this.zaen, this.zabj, (GoogleApiAvailabilityLight)this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb, this);
  }
  
  private static String zaf(int paramInt) {
    switch (paramInt) {
      default:
        return "UNKNOWN";
      case 3:
        return "SIGN_IN_MODE_NONE";
      case 2:
        return "SIGN_IN_MODE_OPTIONAL";
      case 1:
        break;
    } 
    return "SIGN_IN_MODE_REQUIRED";
  }
  
  public final ConnectionResult blockingConnect() {
    boolean bool2;
    null = Looper.myLooper();
    Looper looper = Looper.getMainLooper();
    boolean bool1 = true;
    if (null != looper) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "blockingConnect must not be called on the UI thread");
    this.zaen.lock();
    try {
      if (this.zaca >= 0) {
        if (this.zahc != null) {
          bool2 = bool1;
        } else {
          bool2 = false;
        } 
        Preconditions.checkState(bool2, "Sign-in mode should have been set explicitly by auto-manage.");
      } else if (this.zahc == null) {
        this.zahc = Integer.valueOf(zaa(this.zagy.values(), false));
      } else if (this.zahc.intValue() == 2) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
        throw illegalStateException;
      } 
      zae(this.zahc.intValue());
      this.zagr.enableCallbacks();
      return this.zags.blockingConnect();
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit) {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "blockingConnect must not be called on the UI thread");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    this.zaen.lock();
    try {
      IllegalStateException illegalStateException;
      if (this.zahc == null) {
        this.zahc = Integer.valueOf(zaa(this.zagy.values(), false));
      } else if (this.zahc.intValue() == 2) {
        illegalStateException = new IllegalStateException();
        this("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
        throw illegalStateException;
      } 
      zae(this.zahc.intValue());
      this.zagr.enableCallbacks();
      return this.zags.blockingConnect(paramLong, (TimeUnit)illegalStateException);
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final PendingResult<Status> clearDefaultAccountAndReconnect() {
    boolean bool;
    Preconditions.checkState(super.isConnected(), "GoogleApiClient is not connected yet.");
    if (this.zahc.intValue() != 2) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
    StatusPendingResult statusPendingResult = new StatusPendingResult(this);
    if (this.zagy.containsKey(Common.CLIENT_KEY)) {
      zaa(this, statusPendingResult, false);
    } else {
      AtomicReference<GoogleApiClient> atomicReference = new AtomicReference();
      zaay zaay = new zaay(this, atomicReference, statusPendingResult);
      zaaz zaaz = new zaaz(this, statusPendingResult);
      GoogleApiClient googleApiClient = (new GoogleApiClient.Builder(this.mContext)).addApi(Common.API).addConnectionCallbacks(zaay).addOnConnectionFailedListener(zaaz).setHandler((Handler)this.zagw).build();
      atomicReference.set(googleApiClient);
      googleApiClient.connect();
    } 
    return statusPendingResult;
  }
  
  public final void connect() {
    this.zaen.lock();
    try {
      int i = this.zaca;
      boolean bool = false;
      if (i >= 0) {
        if (this.zahc != null)
          bool = true; 
        Preconditions.checkState(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      } else if (this.zahc == null) {
        this.zahc = Integer.valueOf(zaa(this.zagy.values(), false));
      } else if (this.zahc.intValue() == 2) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
        throw illegalStateException;
      } 
      super.connect(this.zahc.intValue());
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void connect(int paramInt) {
    this.zaen.lock();
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramInt != 3) {
      bool2 = bool1;
      if (paramInt != 1)
        if (paramInt == 2) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }  
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this(33);
      stringBuilder.append("Illegal sign-in mode: ");
      stringBuilder.append(paramInt);
      Preconditions.checkArgument(bool2, stringBuilder.toString());
      zae(paramInt);
      zaau();
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void disconnect() {
    this.zaen.lock();
    try {
      this.zahe.release();
      if (this.zags != null)
        this.zags.disconnect(); 
      this.zaha.release();
      for (BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl : this.zafb) {
        apiMethodImpl.zaa((zacs)null);
        apiMethodImpl.cancel();
      } 
      this.zafb.clear();
      zabs zabs1 = this.zags;
      if (zabs1 == null)
        return; 
      zaaw();
      this.zagr.disableCallbacks();
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zagt);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zafb.size());
    zacp zacp1 = this.zahe;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(zacp1.zaky.size());
    zabs zabs1 = this.zags;
    if (zabs1 != null)
      zabs1.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT) {
    String str;
    if (paramT.getClientKey() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
    boolean bool = this.zagy.containsKey(paramT.getClientKey());
    if (paramT.getApi() != null) {
      str = paramT.getApi().getName();
    } else {
      str = "the API";
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
    stringBuilder.append("GoogleApiClient is not configured to use ");
    stringBuilder.append(str);
    stringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, stringBuilder.toString());
    this.zaen.lock();
    try {
      if (this.zags == null) {
        this.zafb.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
        return paramT;
      } 
      paramT = this.zags.enqueue(paramT);
      return paramT;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT) {
    String str;
    if (paramT.getClientKey() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "This task can not be executed (it's probably a Batch or malformed)");
    boolean bool = this.zagy.containsKey(paramT.getClientKey());
    if (paramT.getApi() != null) {
      str = paramT.getApi().getName();
    } else {
      str = "the API";
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
    stringBuilder.append("GoogleApiClient is not configured to use ");
    stringBuilder.append(str);
    stringBuilder.append(" required for this call.");
    Preconditions.checkArgument(bool, stringBuilder.toString());
    this.zaen.lock();
    try {
      if (this.zags != null) {
        if (this.zagt) {
          this.zafb.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
          while (!this.zafb.isEmpty()) {
            BaseImplementation.ApiMethodImpl<? extends Result> apiMethodImpl = (BaseImplementation.ApiMethodImpl)this.zafb.remove();
            this.zahe.zab(apiMethodImpl);
            apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
          } 
          return paramT;
        } 
        paramT = this.zags.execute(paramT);
        return paramT;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      this("GoogleApiClient is not connected yet.");
      throw illegalStateException;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  @NonNull
  public final <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> paramAnyClientKey) {
    Api.Client client = this.zagy.get(paramAnyClientKey);
    Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
    return (C)client;
  }
  
  @NonNull
  public final ConnectionResult getConnectionResult(@NonNull Api<?> paramApi) {
    this.zaen.lock();
    try {
      if (super.isConnected() || this.zagt) {
        ConnectionResult connectionResult;
        if (this.zagy.containsKey(paramApi.getClientKey())) {
          String str;
          ConnectionResult connectionResult1 = this.zags.getConnectionResult(paramApi);
          if (connectionResult1 == null) {
            ConnectionResult connectionResult2;
            if (this.zagt) {
              connectionResult2 = ConnectionResult.RESULT_SUCCESS;
              return connectionResult2;
            } 
            Log.w("GoogleApiClientImpl", zaay());
            str = String.valueOf(connectionResult2.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map");
            Exception exception = new Exception();
            this();
            Log.wtf("GoogleApiClientImpl", str, exception);
            connectionResult = new ConnectionResult(8, null);
            return connectionResult;
          } 
          return (ConnectionResult)str;
        } 
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        this(String.valueOf(connectionResult.getName()).concat(" was never registered with GoogleApiClient"));
        throw illegalArgumentException;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      this("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
      throw illegalStateException;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final Context getContext() {
    return this.mContext;
  }
  
  public final Looper getLooper() {
    return this.zabj;
  }
  
  public final boolean hasApi(@NonNull Api<?> paramApi) {
    return this.zagy.containsKey(paramApi.getClientKey());
  }
  
  public final boolean hasConnectedApi(@NonNull Api<?> paramApi) {
    if (!super.isConnected())
      return false; 
    Api.Client client = this.zagy.get(paramApi.getClientKey());
    return (client != null && client.isConnected());
  }
  
  public final boolean isConnected() {
    zabs zabs1 = this.zags;
    return (zabs1 != null && zabs1.isConnected());
  }
  
  public final boolean isConnecting() {
    zabs zabs1 = this.zags;
    return (zabs1 != null && zabs1.isConnecting());
  }
  
  public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    return this.zagr.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    return this.zagr.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener) {
    zabs zabs1 = this.zags;
    return (zabs1 != null && zabs1.maybeSignIn(paramSignInConnectionListener));
  }
  
  public final void maybeSignOut() {
    zabs zabs1 = this.zags;
    if (zabs1 != null)
      zabs1.maybeSignOut(); 
  }
  
  public final void reconnect() {
    super.disconnect();
    super.connect();
  }
  
  public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    this.zagr.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zagr.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final <L> ListenerHolder<L> registerListener(@NonNull L paramL) {
    this.zaen.lock();
    try {
      return this.zaha.zaa(paramL, this.zabj, "NO_TYPE");
    } finally {
      this.zaen.unlock();
    } 
  }
  
  public final void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity) {
    LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity)paramFragmentActivity);
    if (this.zaca >= 0) {
      zaj.zaa(lifecycleActivity).zaa(this.zaca);
      return;
    } 
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    this.zagr.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zagr.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final void zaa(zacm paramzacm) {
    this.zaen.lock();
    try {
      if (this.zahd == null) {
        HashSet<zacm> hashSet = new HashSet();
        this();
        this.zahd = hashSet;
      } 
      this.zahd.add(paramzacm);
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  @GuardedBy("mLock")
  final boolean zaaw() {
    if (!this.zagt)
      return false; 
    this.zagt = false;
    this.zagw.removeMessages(2);
    this.zagw.removeMessages(1);
    zabq zabq1 = this.zagx;
    if (zabq1 != null) {
      zabq1.unregister();
      this.zagx = null;
    } 
    return true;
  }
  
  final boolean zaax() {
    this.zaen.lock();
    try {
      Set<zacm> set = this.zahd;
      if (set == null)
        return false; 
      boolean bool = this.zahd.isEmpty();
      return bool ^ true;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  final String zaay() {
    StringWriter stringWriter = new StringWriter();
    super.dump("", null, new PrintWriter(stringWriter), null);
    return stringWriter.toString();
  }
  
  @GuardedBy("mLock")
  public final void zab(int paramInt, boolean paramBoolean) {
    if (paramInt == 1 && !paramBoolean && !this.zagt) {
      this.zagt = true;
      if (this.zagx == null && !ClientLibraryUtils.isPackageSide())
        this.zagx = this.zacc.zaa(this.mContext.getApplicationContext(), new zabc(this)); 
      zabb zabb1 = this.zagw;
      zabb1.sendMessageDelayed(zabb1.obtainMessage(1), this.zagu);
      zabb1 = this.zagw;
      zabb1.sendMessageDelayed(zabb1.obtainMessage(2), this.zagv);
    } 
    this.zahe.zabx();
    this.zagr.onUnintentionalDisconnection(paramInt);
    this.zagr.disableCallbacks();
    if (paramInt == 2)
      zaau(); 
  }
  
  @GuardedBy("mLock")
  public final void zab(Bundle paramBundle) {
    while (!this.zafb.isEmpty())
      super.execute(this.zafb.remove()); 
    this.zagr.onConnectionSuccess(paramBundle);
  }
  
  public final void zab(zacm paramzacm) {
    this.zaen.lock();
    try {
      Exception exception;
      if (this.zahd == null) {
        exception = new Exception();
        this();
        Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", exception);
      } else if (!this.zahd.remove(exception)) {
        exception = new Exception();
        this();
        Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", exception);
      } else if (!zaax()) {
        this.zags.zaw();
      } 
      return;
    } finally {
      this.zaen.unlock();
    } 
  }
  
  @GuardedBy("mLock")
  public final void zac(ConnectionResult paramConnectionResult) {
    if (!this.zacc.isPlayServicesPossiblyUpdating(this.mContext, paramConnectionResult.getErrorCode()))
      zaaw(); 
    if (!this.zagt) {
      this.zagr.onConnectionFailure(paramConnectionResult);
      this.zagr.disableCallbacks();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */