package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;

@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, GmsClientEventManager.GmsClientEventState {
  private final Set<Scope> mScopes;
  
  private final ClientSettings zaes;
  
  private final Account zax;
  
  @KeepForSdk
  @VisibleForTesting
  protected GmsClient(Context paramContext, Handler paramHandler, int paramInt, ClientSettings paramClientSettings) {
    this(paramContext, paramHandler, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, (GoogleApiClient.ConnectionCallbacks)null, (GoogleApiClient.OnConnectionFailedListener)null);
  }
  
  @VisibleForTesting
  protected GmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramHandler, paramGmsClientSupervisor, (GoogleApiAvailabilityLight)paramGoogleApiAvailability, paramInt, zaa(paramConnectionCallbacks), zaa(paramOnConnectionFailedListener));
    this.zaes = Preconditions.<ClientSettings>checkNotNull(paramClientSettings);
    this.zax = paramClientSettings.getAccount();
    this.mScopes = zaa(paramClientSettings.getAllRequestedScopes());
  }
  
  @KeepForSdk
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings) {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, (GoogleApiClient.ConnectionCallbacks)null, (GoogleApiClient.OnConnectionFailedListener)null);
  }
  
  @KeepForSdk
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, Preconditions.<GoogleApiClient.ConnectionCallbacks>checkNotNull(paramConnectionCallbacks), Preconditions.<GoogleApiClient.OnConnectionFailedListener>checkNotNull(paramOnConnectionFailedListener));
  }
  
  @VisibleForTesting
  protected GmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramLooper, paramGmsClientSupervisor, (GoogleApiAvailabilityLight)paramGoogleApiAvailability, paramInt, zaa(paramConnectionCallbacks), zaa(paramOnConnectionFailedListener), paramClientSettings.getRealClientClassName());
    this.zaes = paramClientSettings;
    this.zax = paramClientSettings.getAccount();
    this.mScopes = zaa(paramClientSettings.getAllRequestedScopes());
  }
  
  @Nullable
  private static BaseGmsClient.BaseConnectionCallbacks zaa(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    return (paramConnectionCallbacks == null) ? null : new zaf(paramConnectionCallbacks);
  }
  
  @Nullable
  private static BaseGmsClient.BaseOnConnectionFailedListener zaa(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    return (paramOnConnectionFailedListener == null) ? null : new zag(paramOnConnectionFailedListener);
  }
  
  private final Set<Scope> zaa(@NonNull Set<Scope> paramSet) {
    Set<Scope> set = validateScopes(paramSet);
    Iterator<Scope> iterator = set.iterator();
    while (iterator.hasNext()) {
      if (paramSet.contains(iterator.next()))
        continue; 
      throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
    } 
    return set;
  }
  
  public final Account getAccount() {
    return this.zax;
  }
  
  @KeepForSdk
  protected final ClientSettings getClientSettings() {
    return this.zaes;
  }
  
  public int getMinApkVersion() {
    return super.getMinApkVersion();
  }
  
  @KeepForSdk
  public Feature[] getRequiredFeatures() {
    return new Feature[0];
  }
  
  protected final Set<Scope> getScopes() {
    return this.mScopes;
  }
  
  @NonNull
  @KeepForSdk
  protected Set<Scope> validateScopes(@NonNull Set<Scope> paramSet) {
    return paramSet;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\GmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */