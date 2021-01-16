package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends Api.ApiOptions> {
  private final String mName;
  
  private final AbstractClientBuilder<?, O> zaau;
  
  private final zaa<?, O> zaav;
  
  private final ClientKey<?> zaaw;
  
  private final zab<?> zaax;
  
  public <C extends Client> Api(String paramString, AbstractClientBuilder<C, O> paramAbstractClientBuilder, ClientKey<C> paramClientKey) {
    Preconditions.checkNotNull(paramAbstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
    Preconditions.checkNotNull(paramClientKey, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.zaau = paramAbstractClientBuilder;
    this.zaav = null;
    this.zaaw = paramClientKey;
    this.zaax = null;
  }
  
  public final AnyClientKey<?> getClientKey() {
    ClientKey<?> clientKey = this.zaaw;
    if (clientKey != null)
      return clientKey; 
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
  
  public final String getName() {
    return this.mName;
  }
  
  public final BaseClientBuilder<?, O> zah() {
    return this.zaau;
  }
  
  public final AbstractClientBuilder<?, O> zai() {
    boolean bool;
    if (this.zaau != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
    return this.zaau;
  }
  
  @KeepForSdk
  @VisibleForTesting
  public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
    @KeepForSdk
    public abstract T buildClient(Context param1Context, Looper param1Looper, ClientSettings param1ClientSettings, O param1O, GoogleApiClient.ConnectionCallbacks param1ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener param1OnConnectionFailedListener);
  }
  
  @KeepForSdk
  public static interface AnyClient {}
  
  @KeepForSdk
  public static class AnyClientKey<C extends AnyClient> {}
  
  public static interface ApiOptions {
    public static interface HasAccountOptions extends HasOptions, NotRequiredOptions {
      Account getAccount();
    }
    
    public static interface HasGoogleSignInAccountOptions extends HasOptions {
      GoogleSignInAccount getGoogleSignInAccount();
    }
    
    public static interface HasOptions extends ApiOptions {}
    
    public static final class NoOptions implements NotRequiredOptions {}
    
    public static interface NotRequiredOptions extends ApiOptions {}
    
    public static interface Optional extends HasOptions, NotRequiredOptions {}
  }
  
  public static interface HasAccountOptions extends ApiOptions.HasOptions, ApiOptions.NotRequiredOptions {
    Account getAccount();
  }
  
  public static interface HasGoogleSignInAccountOptions extends ApiOptions.HasOptions {
    GoogleSignInAccount getGoogleSignInAccount();
  }
  
  public static interface HasOptions extends ApiOptions {}
  
  public static final class NoOptions implements ApiOptions.NotRequiredOptions {}
  
  public static interface NotRequiredOptions extends ApiOptions {}
  
  public static interface Optional extends ApiOptions.HasOptions, ApiOptions.NotRequiredOptions {}
  
  @KeepForSdk
  @VisibleForTesting
  public static class BaseClientBuilder<T extends AnyClient, O> {
    @KeepForSdk
    public static final int API_PRIORITY_GAMES = 1;
    
    @KeepForSdk
    public static final int API_PRIORITY_OTHER = 2147483647;
    
    @KeepForSdk
    public static final int API_PRIORITY_PLUS = 2;
    
    @KeepForSdk
    public List<Scope> getImpliedScopes(O param1O) {
      return Collections.emptyList();
    }
    
    @KeepForSdk
    public int getPriority() {
      return Integer.MAX_VALUE;
    }
  }
  
  @KeepForSdk
  public static interface Client extends AnyClient {
    @KeepForSdk
    void connect(BaseGmsClient.ConnectionProgressReportCallbacks param1ConnectionProgressReportCallbacks);
    
    @KeepForSdk
    void disconnect();
    
    @KeepForSdk
    void dump(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString);
    
    @KeepForSdk
    Feature[] getAvailableFeatures();
    
    @KeepForSdk
    String getEndpointPackageName();
    
    @KeepForSdk
    int getMinApkVersion();
    
    @KeepForSdk
    void getRemoteService(IAccountAccessor param1IAccountAccessor, Set<Scope> param1Set);
    
    @KeepForSdk
    Feature[] getRequiredFeatures();
    
    @Nullable
    @KeepForSdk
    IBinder getServiceBrokerBinder();
    
    @KeepForSdk
    Intent getSignInIntent();
    
    @KeepForSdk
    boolean isConnected();
    
    @KeepForSdk
    boolean isConnecting();
    
    @KeepForSdk
    void onUserSignOut(BaseGmsClient.SignOutCallbacks param1SignOutCallbacks);
    
    @KeepForSdk
    boolean providesSignIn();
    
    @KeepForSdk
    boolean requiresAccount();
    
    @KeepForSdk
    boolean requiresGooglePlayServices();
    
    @KeepForSdk
    boolean requiresSignIn();
  }
  
  @KeepForSdk
  @VisibleForTesting
  public static final class ClientKey<C extends Client> extends AnyClientKey<C> {}
  
  public static interface SimpleClient<T extends android.os.IInterface> extends AnyClient {
    T createServiceInterface(IBinder param1IBinder);
    
    Context getContext();
    
    String getServiceDescriptor();
    
    String getStartServiceAction();
    
    void setState(int param1Int, T param1T);
  }
  
  @VisibleForTesting
  public static class zaa<T extends SimpleClient, O> extends BaseClientBuilder<T, O> {}
  
  @VisibleForTesting
  public static final class zab<C extends SimpleClient> extends AnyClientKey<C> {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */