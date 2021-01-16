package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class GoogleApi<O extends Api.ApiOptions> {
  private final Api<O> mApi;
  
  private final Context mContext;
  
  private final int mId;
  
  private final O zabh;
  
  private final zai<O> zabi;
  
  private final Looper zabj;
  
  private final GoogleApiClient zabk;
  
  private final StatusExceptionMapper zabl;
  
  protected final GoogleApiManager zabm;
  
  @MainThread
  @KeepForSdk
  public GoogleApi(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, Settings paramSettings) {
    Preconditions.checkNotNull(paramActivity, "Null activity is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.mContext = paramActivity.getApplicationContext();
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zabj = paramSettings.zabo;
    this.zabi = zai.zaa(this.mApi, (Api.ApiOptions)this.zabh);
    this.zabk = (GoogleApiClient)new zabp(this);
    this.zabm = GoogleApiManager.zab(this.mContext);
    this.mId = this.zabm.zabd();
    this.zabl = paramSettings.zabn;
    if (!(paramActivity instanceof GoogleApiActivity))
      zaae.zaa(paramActivity, this.zabm, this.zabi); 
    this.zabm.zaa(this);
  }
  
  @Deprecated
  @KeepForSdk
  public GoogleApi(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper) {
    this(paramActivity, paramApi, paramO, (new Settings.Builder()).setMapper(paramStatusExceptionMapper).setLooper(paramActivity.getMainLooper()).build());
  }
  
  @KeepForSdk
  protected GoogleApi(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper) {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.mApi = paramApi;
    this.zabh = null;
    this.zabj = paramLooper;
    this.zabi = zai.zaa(paramApi);
    this.zabk = (GoogleApiClient)new zabp(this);
    this.zabm = GoogleApiManager.zab(this.mContext);
    this.mId = this.zabm.zabd();
    this.zabl = (StatusExceptionMapper)new ApiExceptionMapper();
  }
  
  @Deprecated
  @KeepForSdk
  public GoogleApi(@NonNull Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper, StatusExceptionMapper paramStatusExceptionMapper) {
    this(paramContext, paramApi, paramO, (new Settings.Builder()).setLooper(paramLooper).setMapper(paramStatusExceptionMapper).build());
  }
  
  @KeepForSdk
  public GoogleApi(@NonNull Context paramContext, Api<O> paramApi, O paramO, Settings paramSettings) {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.mContext = paramContext.getApplicationContext();
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zabj = paramSettings.zabo;
    this.zabi = zai.zaa(this.mApi, (Api.ApiOptions)this.zabh);
    this.zabk = (GoogleApiClient)new zabp(this);
    this.zabm = GoogleApiManager.zab(this.mContext);
    this.mId = this.zabm.zabd();
    this.zabl = paramSettings.zabn;
    this.zabm.zaa(this);
  }
  
  @Deprecated
  @KeepForSdk
  public GoogleApi(@NonNull Context paramContext, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper) {
    this(paramContext, paramApi, paramO, (new Settings.Builder()).setMapper(paramStatusExceptionMapper).build());
  }
  
  private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaa(int paramInt, @NonNull T paramT) {
    paramT.zau();
    this.zabm.zaa(this, paramInt, (BaseImplementation.ApiMethodImpl)paramT);
    return paramT;
  }
  
  private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int paramInt, @NonNull TaskApiCall<A, TResult> paramTaskApiCall) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.zabm.zaa(this, paramInt, paramTaskApiCall, taskCompletionSource, this.zabl);
    return taskCompletionSource.getTask();
  }
  
  @KeepForSdk
  public GoogleApiClient asGoogleApiClient() {
    return this.zabk;
  }
  
  @KeepForSdk
  protected ClientSettings.Builder createClientSettingsBuilder() {
    // Byte code:
    //   0: new com/google/android/gms/common/internal/ClientSettings$Builder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield zabh : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   12: astore_2
    //   13: aload_2
    //   14: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   17: ifeq -> 42
    //   20: aload_2
    //   21: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   24: invokeinterface getGoogleSignInAccount : ()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull -> 42
    //   34: aload_2
    //   35: invokevirtual getAccount : ()Landroid/accounts/Account;
    //   38: astore_2
    //   39: goto -> 69
    //   42: aload_0
    //   43: getfield zabh : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   46: astore_2
    //   47: aload_2
    //   48: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasAccountOptions
    //   51: ifeq -> 67
    //   54: aload_2
    //   55: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasAccountOptions
    //   58: invokeinterface getAccount : ()Landroid/accounts/Account;
    //   63: astore_2
    //   64: goto -> 69
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual setAccount : (Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   74: astore_1
    //   75: aload_0
    //   76: getfield zabh : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   79: astore_2
    //   80: aload_2
    //   81: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   84: ifeq -> 109
    //   87: aload_2
    //   88: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   91: invokeinterface getGoogleSignInAccount : ()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull -> 109
    //   101: aload_2
    //   102: invokevirtual getRequestedScopes : ()Ljava/util/Set;
    //   105: astore_2
    //   106: goto -> 113
    //   109: invokestatic emptySet : ()Ljava/util/Set;
    //   112: astore_2
    //   113: aload_1
    //   114: aload_2
    //   115: invokevirtual addAllRequiredScopes : (Ljava/util/Collection;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   118: aload_0
    //   119: getfield mContext : Landroid/content/Context;
    //   122: invokevirtual getClass : ()Ljava/lang/Class;
    //   125: invokevirtual getName : ()Ljava/lang/String;
    //   128: invokevirtual setRealClientClassName : (Ljava/lang/String;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   131: aload_0
    //   132: getfield mContext : Landroid/content/Context;
    //   135: invokevirtual getPackageName : ()Ljava/lang/String;
    //   138: invokevirtual setRealClientPackageName : (Ljava/lang/String;)Lcom/google/android/gms/common/internal/ClientSettings$Builder;
    //   141: areturn
  }
  
  @KeepForSdk
  protected Task<Boolean> disconnectService() {
    return this.zabm.zac(this);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(@NonNull T paramT) {
    return zaa(2, paramT);
  }
  
  @KeepForSdk
  public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> paramTaskApiCall) {
    return zaa(2, paramTaskApiCall);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(@NonNull T paramT) {
    return zaa(0, paramT);
  }
  
  @KeepForSdk
  public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> paramTaskApiCall) {
    return zaa(0, paramTaskApiCall);
  }
  
  @Deprecated
  @KeepForSdk
  public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(@NonNull T paramT, U paramU) {
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramU);
    Preconditions.checkNotNull(paramT.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramU.getListenerKey(), "Listener has already been released.");
    Preconditions.checkArgument(paramT.getListenerKey().equals(paramU.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return this.zabm.zaa(this, (RegisterListenerMethod)paramT, (UnregisterListenerMethod)paramU);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(@NonNull RegistrationMethods<A, ?> paramRegistrationMethods) {
    Preconditions.checkNotNull(paramRegistrationMethods);
    Preconditions.checkNotNull(paramRegistrationMethods.zajy.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramRegistrationMethods.zajz.getListenerKey(), "Listener has already been released.");
    return this.zabm.zaa(this, paramRegistrationMethods.zajy, paramRegistrationMethods.zajz);
  }
  
  @KeepForSdk
  public Task<Boolean> doUnregisterEventListener(@NonNull ListenerHolder.ListenerKey<?> paramListenerKey) {
    Preconditions.checkNotNull(paramListenerKey, "Listener key cannot be null.");
    return this.zabm.zaa(this, paramListenerKey);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(@NonNull T paramT) {
    return zaa(1, paramT);
  }
  
  @KeepForSdk
  public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> paramTaskApiCall) {
    return zaa(1, paramTaskApiCall);
  }
  
  public final Api<O> getApi() {
    return this.mApi;
  }
  
  @KeepForSdk
  public O getApiOptions() {
    return this.zabh;
  }
  
  @KeepForSdk
  public Context getApplicationContext() {
    return this.mContext;
  }
  
  public final int getInstanceId() {
    return this.mId;
  }
  
  @KeepForSdk
  public Looper getLooper() {
    return this.zabj;
  }
  
  @KeepForSdk
  public <L> ListenerHolder<L> registerListener(@NonNull L paramL, String paramString) {
    return ListenerHolders.createListenerHolder(paramL, this.zabj, paramString);
  }
  
  @WorkerThread
  public Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa) {
    ClientSettings clientSettings = createClientSettingsBuilder().build();
    return this.mApi.zai().buildClient(this.mContext, paramLooper, clientSettings, this.zabh, (GoogleApiClient.ConnectionCallbacks)paramzaa, (GoogleApiClient.OnConnectionFailedListener)paramzaa);
  }
  
  public zace zaa(Context paramContext, Handler paramHandler) {
    return new zace(paramContext, paramHandler, createClientSettingsBuilder().build());
  }
  
  public final zai<O> zak() {
    return this.zabi;
  }
  
  @KeepForSdk
  public static class Settings {
    @KeepForSdk
    public static final Settings DEFAULT_SETTINGS = (new Builder()).build();
    
    public final StatusExceptionMapper zabn;
    
    public final Looper zabo;
    
    @KeepForSdk
    private Settings(StatusExceptionMapper param1StatusExceptionMapper, Account param1Account, Looper param1Looper) {
      this.zabn = param1StatusExceptionMapper;
      this.zabo = param1Looper;
    }
    
    @KeepForSdk
    public static class Builder {
      private Looper zabj;
      
      private StatusExceptionMapper zabl;
      
      @KeepForSdk
      public GoogleApi.Settings build() {
        if (this.zabl == null)
          this.zabl = (StatusExceptionMapper)new ApiExceptionMapper(); 
        if (this.zabj == null)
          this.zabj = Looper.getMainLooper(); 
        return new GoogleApi.Settings(this.zabl, null, this.zabj, null);
      }
      
      @KeepForSdk
      public Builder setLooper(Looper param2Looper) {
        Preconditions.checkNotNull(param2Looper, "Looper must not be null.");
        this.zabj = param2Looper;
        return this;
      }
      
      @KeepForSdk
      public Builder setMapper(StatusExceptionMapper param2StatusExceptionMapper) {
        Preconditions.checkNotNull(param2StatusExceptionMapper, "StatusExceptionMapper must not be null.");
        this.zabl = param2StatusExceptionMapper;
        return this;
      }
    }
  }
  
  @KeepForSdk
  public static class Builder {
    private Looper zabj;
    
    private StatusExceptionMapper zabl;
    
    @KeepForSdk
    public GoogleApi.Settings build() {
      if (this.zabl == null)
        this.zabl = (StatusExceptionMapper)new ApiExceptionMapper(); 
      if (this.zabj == null)
        this.zabj = Looper.getMainLooper(); 
      return new GoogleApi.Settings(this.zabl, null, this.zabj, null);
    }
    
    @KeepForSdk
    public Builder setLooper(Looper param1Looper) {
      Preconditions.checkNotNull(param1Looper, "Looper must not be null.");
      this.zabj = param1Looper;
      return this;
    }
    
    @KeepForSdk
    public Builder setMapper(StatusExceptionMapper param1StatusExceptionMapper) {
      Preconditions.checkNotNull(param1StatusExceptionMapper, "StatusExceptionMapper must not be null.");
      this.zabl = param1StatusExceptionMapper;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\GoogleApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */