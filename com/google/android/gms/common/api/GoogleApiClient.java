package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient {
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  
  @GuardedBy("sAllClients")
  private static final Set<GoogleApiClient> zabq = Collections.newSetFromMap(new WeakHashMap<GoogleApiClient, Boolean>());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    // Byte code:
    //   0: getstatic com/google/android/gms/common/api/GoogleApiClient.zabq : Ljava/util/Set;
    //   3: astore #4
    //   5: aload #4
    //   7: monitorenter
    //   8: iconst_0
    //   9: istore #5
    //   11: aload_0
    //   12: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   15: ldc '  '
    //   17: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   20: astore #6
    //   22: getstatic com/google/android/gms/common/api/GoogleApiClient.zabq : Ljava/util/Set;
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore #7
    //   32: aload #7
    //   34: invokeinterface hasNext : ()Z
    //   39: ifeq -> 85
    //   42: aload #7
    //   44: invokeinterface next : ()Ljava/lang/Object;
    //   49: checkcast com/google/android/gms/common/api/GoogleApiClient
    //   52: astore #8
    //   54: aload_2
    //   55: aload_0
    //   56: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   59: ldc 'GoogleApiClient#'
    //   61: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
    //   64: iload #5
    //   66: invokevirtual println : (I)V
    //   69: aload #8
    //   71: aload #6
    //   73: aload_1
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   79: iinc #5, 1
    //   82: goto -> 32
    //   85: aload #4
    //   87: monitorexit
    //   88: return
    //   89: astore_0
    //   90: aload #4
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   11	32	89	finally
    //   32	79	89	finally
    //   85	88	89	finally
    //   90	93	89	finally
  }
  
  @KeepForSdk
  public static Set<GoogleApiClient> getAllClients() {
    synchronized (zabq) {
      return zabq;
    } 
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @KeepForSdk
  public <A extends Api.AnyClient, R extends Result, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T paramT) {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T paramT) {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  @KeepForSdk
  public <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> paramAnyClientKey) {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  public abstract ConnectionResult getConnectionResult(@NonNull Api<?> paramApi);
  
  @KeepForSdk
  public Context getContext() {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public Looper getLooper() {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public boolean hasApi(@NonNull Api<?> paramApi) {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(@NonNull Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @KeepForSdk
  public boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener) {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public void maybeSignOut() {
    throw new UnsupportedOperationException();
  }
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @KeepForSdk
  public <L> ListenerHolder<L> registerListener(@NonNull L paramL) {
    throw new UnsupportedOperationException();
  }
  
  public abstract void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public void zaa(zacm paramzacm) {
    throw new UnsupportedOperationException();
  }
  
  public void zab(zacm paramzacm) {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public static final class Builder {
    private final Context mContext;
    
    private Looper zabj;
    
    private final Set<Scope> zabr = new HashSet<Scope>();
    
    private final Set<Scope> zabs = new HashSet<Scope>();
    
    private int zabt;
    
    private View zabu;
    
    private String zabv;
    
    private String zabw;
    
    private final Map<Api<?>, ClientSettings.OptionalApiSettings> zabx = (Map<Api<?>, ClientSettings.OptionalApiSettings>)new ArrayMap();
    
    private final Map<Api<?>, Api.ApiOptions> zaby = (Map<Api<?>, Api.ApiOptions>)new ArrayMap();
    
    private LifecycleActivity zabz;
    
    private int zaca = -1;
    
    private GoogleApiClient.OnConnectionFailedListener zacb;
    
    private GoogleApiAvailability zacc = GoogleApiAvailability.getInstance();
    
    private Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd = zaa.zapg;
    
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zace = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
    
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zacf = new ArrayList<GoogleApiClient.OnConnectionFailedListener>();
    
    private boolean zacg = false;
    
    private Account zax;
    
    @KeepForSdk
    public Builder(@NonNull Context param1Context) {
      this.mContext = param1Context;
      this.zabj = param1Context.getMainLooper();
      this.zabv = param1Context.getPackageName();
      this.zabw = param1Context.getClass().getName();
    }
    
    @KeepForSdk
    public Builder(@NonNull Context param1Context, @NonNull GoogleApiClient.ConnectionCallbacks param1ConnectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      this(param1Context);
      Preconditions.checkNotNull(param1ConnectionCallbacks, "Must provide a connected listener");
      this.zace.add(param1ConnectionCallbacks);
      Preconditions.checkNotNull(param1OnConnectionFailedListener, "Must provide a connection failed listener");
      this.zacf.add(param1OnConnectionFailedListener);
    }
    
    private final <O extends Api.ApiOptions> void zaa(Api<O> param1Api, O param1O, Scope... param1VarArgs) {
      HashSet<Scope> hashSet = new HashSet<Scope>(param1Api.zah().getImpliedScopes(param1O));
      int i = param1VarArgs.length;
      for (byte b = 0; b < i; b++)
        hashSet.add(param1VarArgs[b]); 
      this.zabx.put(param1Api, new ClientSettings.OptionalApiSettings(hashSet));
    }
    
    public final Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> param1Api) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      this.zaby.put(param1Api, null);
      List<Scope> list = param1Api.zah().getImpliedScopes(null);
      this.zabs.addAll(list);
      this.zabr.addAll(list);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> param1Api, @NonNull O param1O) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      Preconditions.checkNotNull(param1O, "Null options are not permitted for this Api");
      this.zaby.put(param1Api, (Api.ApiOptions)param1O);
      List<Scope> list = param1Api.zah().getImpliedScopes(param1O);
      this.zabs.addAll(list);
      this.zabr.addAll(list);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> param1Api, @NonNull O param1O, Scope... param1VarArgs) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      Preconditions.checkNotNull(param1O, "Null options are not permitted for this Api");
      this.zaby.put(param1Api, (Api.ApiOptions)param1O);
      zaa((Api)param1Api, (Api.ApiOptions)param1O, param1VarArgs);
      return this;
    }
    
    public final Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> param1Api, Scope... param1VarArgs) {
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      this.zaby.put(param1Api, null);
      zaa(param1Api, null, param1VarArgs);
      return this;
    }
    
    public final Builder addConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks param1ConnectionCallbacks) {
      Preconditions.checkNotNull(param1ConnectionCallbacks, "Listener must not be null");
      this.zace.add(param1ConnectionCallbacks);
      return this;
    }
    
    public final Builder addOnConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      Preconditions.checkNotNull(param1OnConnectionFailedListener, "Listener must not be null");
      this.zacf.add(param1OnConnectionFailedListener);
      return this;
    }
    
    public final Builder addScope(@NonNull Scope param1Scope) {
      Preconditions.checkNotNull(param1Scope, "Scope must not be null");
      this.zabr.add(param1Scope);
      return this;
    }
    
    @KeepForSdk
    public final Builder addScopeNames(String[] param1ArrayOfString) {
      for (byte b = 0; b < param1ArrayOfString.length; b++)
        this.zabr.add(new Scope(param1ArrayOfString[b])); 
      return this;
    }
    
    public final GoogleApiClient build() {
      String str;
      StringBuilder stringBuilder;
      Preconditions.checkArgument(this.zaby.isEmpty() ^ true, "must call addApi() to add at least one API");
      ClientSettings clientSettings = buildClientSettings();
      Api api = null;
      Map map = clientSettings.getOptionalApiSettings();
      ArrayMap<Api, Boolean> arrayMap = new ArrayMap();
      ArrayMap<Api.AnyClientKey<?>, zaq> arrayMap1 = new ArrayMap();
      ArrayList<zaq> arrayList = new ArrayList();
      Iterator<Api> iterator = this.zaby.keySet().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        boolean bool1;
        Api api1 = iterator.next();
        Object object = this.zaby.get(api1);
        if (map.get(api1) != null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        arrayMap.put(api1, Boolean.valueOf(bool1));
        zaq zaq = new zaq(api1, bool1);
        arrayList.add(zaq);
        Api.AbstractClientBuilder abstractClientBuilder = api1.zai();
        zaq = (zaq)abstractClientBuilder.buildClient(this.mContext, this.zabj, clientSettings, object, (GoogleApiClient.ConnectionCallbacks)zaq, (GoogleApiClient.OnConnectionFailedListener)zaq);
        arrayMap1.put(api1.getClientKey(), zaq);
        boolean bool2 = bool;
        if (abstractClientBuilder.getPriority() == 1)
          if (object != null) {
            bool2 = true;
          } else {
            bool2 = false;
          }  
        bool = bool2;
        if (zaq.providesSignIn()) {
          if (api == null) {
            api = api1;
            bool = bool2;
            continue;
          } 
          String str1 = api1.getName();
          str = api.getName();
          stringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str).length());
          stringBuilder.append(str1);
          stringBuilder.append(" cannot be used with ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } 
      if (stringBuilder != null)
        if (!bool) {
          boolean bool1;
          if (this.zax == null) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          Preconditions.checkState(bool1, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { stringBuilder.getName() });
          Preconditions.checkState(this.zabr.equals(this.zabs), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { stringBuilder.getName() });
        } else {
          String str1 = stringBuilder.getName();
          StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str1).length() + 82);
          stringBuilder1.append("With using ");
          stringBuilder1.append(str1);
          stringBuilder1.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
          throw new IllegalStateException(stringBuilder1.toString());
        }  
      int i = zaaw.zaa(arrayMap1.values(), true);
      null = new zaaw(this.mContext, new ReentrantLock(), this.zabj, (ClientSettings)str, this.zacc, this.zacd, (Map)arrayMap, this.zace, this.zacf, (Map)arrayMap1, this.zaca, i, arrayList, false);
      synchronized (GoogleApiClient.zal()) {
        GoogleApiClient.zal().add(null);
        if (this.zaca >= 0)
          zaj.zaa(this.zabz).zaa(this.zaca, (GoogleApiClient)null, this.zacb); 
        return (GoogleApiClient)null;
      } 
    }
    
    @KeepForSdk
    @VisibleForTesting
    public final ClientSettings buildClientSettings() {
      SignInOptions signInOptions = SignInOptions.DEFAULT;
      if (this.zaby.containsKey(zaa.API))
        signInOptions = (SignInOptions)this.zaby.get(zaa.API); 
      return new ClientSettings(this.zax, this.zabr, this.zabx, this.zabt, this.zabu, this.zabv, this.zabw, signInOptions);
    }
    
    public final Builder enableAutoManage(@NonNull FragmentActivity param1FragmentActivity, int param1Int, @Nullable GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      boolean bool;
      LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity)param1FragmentActivity);
      if (param1Int >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "clientId must be non-negative");
      this.zaca = param1Int;
      this.zacb = param1OnConnectionFailedListener;
      this.zabz = lifecycleActivity;
      return this;
    }
    
    public final Builder enableAutoManage(@NonNull FragmentActivity param1FragmentActivity, @Nullable GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      return enableAutoManage(param1FragmentActivity, 0, param1OnConnectionFailedListener);
    }
    
    public final Builder setAccountName(String param1String) {
      Account account;
      if (param1String == null) {
        param1String = null;
      } else {
        account = new Account(param1String, "com.google");
      } 
      this.zax = account;
      return this;
    }
    
    public final Builder setGravityForPopups(int param1Int) {
      this.zabt = param1Int;
      return this;
    }
    
    public final Builder setHandler(@NonNull Handler param1Handler) {
      Preconditions.checkNotNull(param1Handler, "Handler must not be null");
      this.zabj = param1Handler.getLooper();
      return this;
    }
    
    public final Builder setViewForPopups(@NonNull View param1View) {
      Preconditions.checkNotNull(param1View, "View must not be null");
      this.zabu = param1View;
      return this;
    }
    
    public final Builder useDefaultAccount() {
      return setAccountName("<<default account>>");
    }
  }
  
  public static interface ConnectionCallbacks {
    public static final int CAUSE_NETWORK_LOST = 2;
    
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    void onConnected(@Nullable Bundle param1Bundle);
    
    void onConnectionSuspended(int param1Int);
  }
  
  public static interface OnConnectionFailedListener {
    void onConnectionFailed(@NonNull ConnectionResult param1ConnectionResult);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */