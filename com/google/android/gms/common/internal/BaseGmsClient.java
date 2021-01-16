package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {
  @KeepForSdk
  public static final int CONNECT_STATE_CONNECTED = 4;
  
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTED = 1;
  
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTING = 5;
  
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  
  @KeepForSdk
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES;
  
  @KeepForSdk
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  
  private static final Feature[] zzbt = new Feature[0];
  
  private final Context mContext;
  
  final Handler mHandler;
  
  private final Object mLock = new Object();
  
  private int zzbu;
  
  private long zzbv;
  
  private long zzbw;
  
  private int zzbx;
  
  private long zzby;
  
  @VisibleForTesting
  private zzh zzbz;
  
  private final Looper zzca;
  
  private final GmsClientSupervisor zzcb;
  
  private final GoogleApiAvailabilityLight zzcc;
  
  private final Object zzcd = new Object();
  
  @GuardedBy("mServiceBrokerLock")
  private IGmsServiceBroker zzce;
  
  @VisibleForTesting
  protected ConnectionProgressReportCallbacks zzcf;
  
  @GuardedBy("mLock")
  private T zzcg;
  
  private final ArrayList<zzc<?>> zzch = new ArrayList<zzc<?>>();
  
  @GuardedBy("mLock")
  private zze zzci;
  
  @GuardedBy("mLock")
  private int zzcj = 1;
  
  private final BaseConnectionCallbacks zzck;
  
  private final BaseOnConnectionFailedListener zzcl;
  
  private final int zzcm;
  
  private final String zzcn;
  
  private ConnectionResult zzco = null;
  
  private boolean zzcp = false;
  
  private volatile zzb zzcq = null;
  
  @VisibleForTesting
  protected AtomicInteger zzcr = new AtomicInteger(0);
  
  static {
    GOOGLE_PLUS_REQUIRED_FEATURES = new String[] { "service_esmobile", "service_googleme" };
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener) {
    this.mContext = Preconditions.<Context>checkNotNull(paramContext, "Context must not be null");
    this.mHandler = Preconditions.<Handler>checkNotNull(paramHandler, "Handler must not be null");
    this.zzca = paramHandler.getLooper();
    this.zzcb = Preconditions.<GmsClientSupervisor>checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    this.zzcc = Preconditions.<GoogleApiAvailabilityLight>checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    this.zzcm = paramInt;
    this.zzck = paramBaseConnectionCallbacks;
    this.zzcl = paramBaseOnConnectionFailedListener;
    this.zzcn = null;
  }
  
  @KeepForSdk
  protected BaseGmsClient(Context paramContext, Looper paramLooper, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString) {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailabilityLight.getInstance(), paramInt, Preconditions.<BaseConnectionCallbacks>checkNotNull(paramBaseConnectionCallbacks), Preconditions.<BaseOnConnectionFailedListener>checkNotNull(paramBaseOnConnectionFailedListener), paramString);
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString) {
    this.mContext = Preconditions.<Context>checkNotNull(paramContext, "Context must not be null");
    this.zzca = Preconditions.<Looper>checkNotNull(paramLooper, "Looper must not be null");
    this.zzcb = Preconditions.<GmsClientSupervisor>checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    this.zzcc = Preconditions.<GoogleApiAvailabilityLight>checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    this.mHandler = (Handler)new zzb(this, paramLooper);
    this.zzcm = paramInt;
    this.zzck = paramBaseConnectionCallbacks;
    this.zzcl = paramBaseOnConnectionFailedListener;
    this.zzcn = paramString;
  }
  
  private final void zza(int paramInt, T paramT) {
    int i;
    byte b;
    boolean bool;
    if (paramInt == 4) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramT != null) {
      b = 1;
    } else {
      b = 0;
    } 
    if (i == b) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    synchronized (this.mLock) {
      zze zze1;
      zzh zzh1;
      String str1;
      zze zze2;
      String str2;
      GmsClientSupervisor gmsClientSupervisor;
      String str3;
      GmsClientSupervisor.zza zza;
      this.zzcj = paramInt;
      this.zzcg = paramT;
      onSetConnectState(paramInt, paramT);
      switch (paramInt) {
        case 4:
          onConnectedLocked(paramT);
          break;
        case 2:
        case 3:
          if (this.zzci != null && this.zzbz != null) {
            String str4 = this.zzbz.zzt();
            String str5 = this.zzbz.getPackageName();
            paramInt = String.valueOf(str4).length();
            i = String.valueOf(str5).length();
            StringBuilder stringBuilder = new StringBuilder();
            this(paramInt + 70 + i);
            stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
            stringBuilder.append(str4);
            stringBuilder.append(" on ");
            stringBuilder.append(str5);
            Log.e("GmsClient", stringBuilder.toString());
            this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
            this.zzcr.incrementAndGet();
          } 
          zze1 = new zze();
          this(this, this.zzcr.get());
          this.zzci = zze1;
          if (this.zzcj == 3 && getLocalStartServiceAction() != null) {
            zzh1 = new zzh();
            this(getContext().getPackageName(), getLocalStartServiceAction(), true, 129);
          } else {
            zzh1 = new zzh(getStartServicePackage(), getStartServiceAction(), false, 129);
          } 
          this.zzbz = zzh1;
          gmsClientSupervisor = this.zzcb;
          str3 = this.zzbz.zzt();
          str1 = this.zzbz.getPackageName();
          paramInt = this.zzbz.zzq();
          zze2 = this.zzci;
          str2 = zzj();
          zza = new GmsClientSupervisor.zza();
          this(str3, str1, paramInt);
          if (!gmsClientSupervisor.zza(zza, zze2, str2)) {
            str1 = this.zzbz.zzt();
            str2 = this.zzbz.getPackageName();
            i = String.valueOf(str1).length();
            paramInt = String.valueOf(str2).length();
            StringBuilder stringBuilder = new StringBuilder();
            this(i + 34 + paramInt);
            stringBuilder.append("unable to connect to service: ");
            stringBuilder.append(str1);
            stringBuilder.append(" on ");
            stringBuilder.append(str2);
            Log.e("GmsClient", stringBuilder.toString());
            zza(16, (Bundle)null, this.zzcr.get());
          } 
          break;
        case 1:
          if (this.zzci != null) {
            this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
            this.zzci = null;
          } 
          break;
      } 
      return;
    } 
  }
  
  private final void zza(zzb paramzzb) {
    this.zzcq = paramzzb;
  }
  
  private final boolean zza(int paramInt1, int paramInt2, T paramT) {
    synchronized (this.mLock) {
      if (this.zzcj != paramInt1)
        return false; 
      zza(paramInt2, paramT);
      return true;
    } 
  }
  
  private final void zzb(int paramInt) {
    if (zzk()) {
      paramInt = 5;
      this.zzcp = true;
    } else {
      paramInt = 4;
    } 
    Handler handler = this.mHandler;
    handler.sendMessage(handler.obtainMessage(paramInt, this.zzcr.get(), 16));
  }
  
  @Nullable
  private final String zzj() {
    String str1 = this.zzcn;
    String str2 = str1;
    if (str1 == null)
      str2 = this.mContext.getClass().getName(); 
    return str2;
  }
  
  private final boolean zzk() {
    synchronized (this.mLock) {
      boolean bool;
      if (this.zzcj == 3) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } 
  }
  
  private final boolean zzl() {
    if (this.zzcp)
      return false; 
    if (TextUtils.isEmpty(getServiceDescriptor()))
      return false; 
    if (TextUtils.isEmpty(getLocalStartServiceAction()))
      return false; 
    try {
      Class.forName(getServiceDescriptor());
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  @KeepForSdk
  public void checkAvailabilityAndConnect() {
    int i = this.zzcc.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
    if (i != 0) {
      zza(1, (T)null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(this), i, null);
      return;
    } 
    connect(new LegacyClientCallbackAdapter(this));
  }
  
  @KeepForSdk
  protected final void checkConnected() {
    if (isConnected())
      return; 
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  @KeepForSdk
  public void connect(@NonNull ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks) {
    this.zzcf = Preconditions.<ConnectionProgressReportCallbacks>checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    zza(2, (T)null);
  }
  
  @Nullable
  @KeepForSdk
  protected abstract T createServiceInterface(IBinder paramIBinder);
  
  @KeepForSdk
  public void disconnect() {
    this.zzcr.incrementAndGet();
    synchronized (this.zzch) {
      int i = this.zzch.size();
      for (byte b = 0; b < i; b++)
        ((zzc)this.zzch.get(b)).removeListener(); 
      this.zzch.clear();
      synchronized (this.zzcd) {
        this.zzce = null;
        zza(1, (T)null);
        return;
      } 
    } 
  }
  
  @KeepForSdk
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    synchronized (this.mLock) {
      int i = this.zzcj;
      T t = this.zzcg;
      synchronized (this.zzcd) {
        IGmsServiceBroker iGmsServiceBroker = this.zzce;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i) {
          default:
            paramPrintWriter.print("UNKNOWN");
            break;
          case 5:
            paramPrintWriter.print("DISCONNECTING");
            break;
          case 4:
            paramPrintWriter.print("CONNECTED");
            break;
          case 3:
            paramPrintWriter.print("LOCAL_CONNECTING");
            break;
          case 2:
            paramPrintWriter.print("REMOTE_CONNECTING");
            break;
          case 1:
            paramPrintWriter.print("DISCONNECTED");
            break;
        } 
        paramPrintWriter.append(" mService=");
        if (t == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(t.asBinder())));
        } 
        paramPrintWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        } 
        null = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzbw > 0L) {
          PrintWriter printWriter = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          long l = this.zzbw;
          String str = null.format(new Date(l));
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          printWriter.println(stringBuilder.toString());
        } 
        if (this.zzbv > 0L) {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          i = this.zzbu;
          switch (i) {
            default:
              paramPrintWriter.append(String.valueOf(i));
              break;
            case 2:
              paramPrintWriter.append("CAUSE_NETWORK_LOST");
              break;
            case 1:
              paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
              break;
          } 
          PrintWriter printWriter = paramPrintWriter.append(" lastSuspendedTime=");
          long l = this.zzbv;
          String str = null.format(new Date(l));
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          printWriter.println(stringBuilder.toString());
        } 
        if (this.zzby > 0L) {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzbx));
          PrintWriter printWriter = paramPrintWriter.append(" lastFailedTime=");
          long l = this.zzby;
          String str = null.format(new Date(l));
          null = new StringBuilder(String.valueOf(str).length() + 21);
          null.append(l);
          null.append(" ");
          null.append(str);
          printWriter.println(null.toString());
        } 
        return;
      } 
    } 
  }
  
  @KeepForSdk
  protected boolean enableLocalFallback() {
    return false;
  }
  
  @KeepForSdk
  public Account getAccount() {
    return null;
  }
  
  @KeepForSdk
  public Feature[] getApiFeatures() {
    return zzbt;
  }
  
  @Nullable
  @KeepForSdk
  public final Feature[] getAvailableFeatures() {
    zzb zzb1 = this.zzcq;
    return (zzb1 == null) ? null : zzb1.zzdb;
  }
  
  @KeepForSdk
  public Bundle getConnectionHint() {
    return null;
  }
  
  @KeepForSdk
  public final Context getContext() {
    return this.mContext;
  }
  
  @KeepForSdk
  public String getEndpointPackageName() {
    if (isConnected()) {
      zzh zzh1 = this.zzbz;
      if (zzh1 != null)
        return zzh1.getPackageName(); 
    } 
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  @KeepForSdk
  protected Bundle getGetServiceRequestExtraArgs() {
    return new Bundle();
  }
  
  @Nullable
  @KeepForSdk
  protected String getLocalStartServiceAction() {
    return null;
  }
  
  @KeepForSdk
  public final Looper getLooper() {
    return this.zzca;
  }
  
  @KeepForSdk
  public int getMinApkVersion() {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  @WorkerThread
  @KeepForSdk
  public void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet) {
    Bundle bundle = getGetServiceRequestExtraArgs();
    GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzcm);
    getServiceRequest.zzy = this.mContext.getPackageName();
    getServiceRequest.zzdk = bundle;
    if (paramSet != null)
      getServiceRequest.zzdj = paramSet.<Scope>toArray(new Scope[paramSet.size()]); 
    if (requiresSignIn()) {
      Account account;
      if (getAccount() != null) {
        account = getAccount();
      } else {
        account = new Account("<<default account>>", "com.google");
      } 
      getServiceRequest.zzdl = account;
      if (paramIAccountAccessor != null)
        getServiceRequest.zzdi = paramIAccountAccessor.asBinder(); 
    } else if (requiresAccount()) {
      getServiceRequest.zzdl = getAccount();
    } 
    getServiceRequest.zzdm = zzbt;
    getServiceRequest.zzdn = getApiFeatures();
    try {
      synchronized (this.zzcd) {
        if (this.zzce != null) {
          IGmsServiceBroker iGmsServiceBroker = this.zzce;
          zzd zzd = new zzd();
          this(this, this.zzcr.get());
          iGmsServiceBroker.getService(zzd, getServiceRequest);
        } else {
          Log.w("GmsClient", "mServiceBroker is null, client disconnected");
        } 
        return;
      } 
    } catch (DeadObjectException deadObjectException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)deadObjectException);
      triggerConnectionSuspended(1);
      return;
    } catch (SecurityException securityException) {
      throw securityException;
    } catch (RemoteException remoteException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)remoteException);
      onPostInitHandler(8, null, null, this.zzcr.get());
      return;
    } catch (RuntimeException runtimeException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", runtimeException);
      onPostInitHandler(8, null, null, this.zzcr.get());
      return;
    } 
  }
  
  @KeepForSdk
  protected Set<Scope> getScopes() {
    return Collections.EMPTY_SET;
  }
  
  @KeepForSdk
  public final T getService() throws DeadObjectException {
    synchronized (this.mLock) {
      if (this.zzcj != 5) {
        boolean bool;
        checkConnected();
        if (this.zzcg != null) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "Client is connected but service is null");
        return this.zzcg;
      } 
      DeadObjectException deadObjectException = new DeadObjectException();
      this();
      throw deadObjectException;
    } 
  }
  
  @Nullable
  @KeepForSdk
  public IBinder getServiceBrokerBinder() {
    synchronized (this.zzcd) {
      if (this.zzce == null)
        return null; 
      return this.zzce.asBinder();
    } 
  }
  
  @NonNull
  @KeepForSdk
  protected abstract String getServiceDescriptor();
  
  @KeepForSdk
  public Intent getSignInIntent() {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  @NonNull
  @KeepForSdk
  protected abstract String getStartServiceAction();
  
  @KeepForSdk
  protected String getStartServicePackage() {
    return "com.google.android.gms";
  }
  
  @KeepForSdk
  public boolean isConnected() {
    synchronized (this.mLock) {
      boolean bool;
      if (this.zzcj == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } 
  }
  
  @KeepForSdk
  public boolean isConnecting() {
    synchronized (this.mLock) {
      if (this.zzcj == 2 || this.zzcj == 3)
        return true; 
      return false;
    } 
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectedLocked(@NonNull T paramT) {
    this.zzbw = System.currentTimeMillis();
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectionFailed(ConnectionResult paramConnectionResult) {
    this.zzbx = paramConnectionResult.getErrorCode();
    this.zzby = System.currentTimeMillis();
  }
  
  @CallSuper
  @KeepForSdk
  protected void onConnectionSuspended(int paramInt) {
    this.zzbu = paramInt;
    this.zzbv = System.currentTimeMillis();
  }
  
  @KeepForSdk
  protected void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2) {
    Handler handler = this.mHandler;
    handler.sendMessage(handler.obtainMessage(1, paramInt2, -1, new zzf(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  @KeepForSdk
  void onSetConnectState(int paramInt, T paramT) {}
  
  @KeepForSdk
  public void onUserSignOut(@NonNull SignOutCallbacks paramSignOutCallbacks) {
    paramSignOutCallbacks.onSignOutComplete();
  }
  
  @KeepForSdk
  public boolean providesSignIn() {
    return false;
  }
  
  @KeepForSdk
  public boolean requiresAccount() {
    return false;
  }
  
  @KeepForSdk
  public boolean requiresGooglePlayServices() {
    return true;
  }
  
  @KeepForSdk
  public boolean requiresSignIn() {
    return false;
  }
  
  @KeepForSdk
  public void triggerConnectionSuspended(int paramInt) {
    Handler handler = this.mHandler;
    handler.sendMessage(handler.obtainMessage(6, this.zzcr.get(), paramInt));
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, @Nullable PendingIntent paramPendingIntent) {
    this.zzcf = Preconditions.<ConnectionProgressReportCallbacks>checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    Handler handler = this.mHandler;
    handler.sendMessage(handler.obtainMessage(3, this.zzcr.get(), paramInt, paramPendingIntent));
  }
  
  protected final void zza(int paramInt1, @Nullable Bundle paramBundle, int paramInt2) {
    Handler handler = this.mHandler;
    handler.sendMessage(handler.obtainMessage(7, paramInt2, -1, new zzg(this, paramInt1, null)));
  }
  
  @KeepForSdk
  public static interface BaseConnectionCallbacks {
    @KeepForSdk
    void onConnected(@Nullable Bundle param1Bundle);
    
    @KeepForSdk
    void onConnectionSuspended(int param1Int);
  }
  
  @KeepForSdk
  public static interface BaseOnConnectionFailedListener {
    void onConnectionFailed(@NonNull ConnectionResult param1ConnectionResult);
  }
  
  @KeepForSdk
  public static interface ConnectionProgressReportCallbacks {
    @KeepForSdk
    void onReportServiceBinding(@NonNull ConnectionResult param1ConnectionResult);
  }
  
  protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
    @KeepForSdk
    public LegacyClientCallbackAdapter(BaseGmsClient this$0) {}
    
    public void onReportServiceBinding(@NonNull ConnectionResult param1ConnectionResult) {
      BaseGmsClient baseGmsClient;
      if (param1ConnectionResult.isSuccess()) {
        baseGmsClient = this.zzct;
        baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
        return;
      } 
      if (BaseGmsClient.zzg(this.zzct) != null)
        BaseGmsClient.zzg(this.zzct).onConnectionFailed((ConnectionResult)baseGmsClient); 
    }
  }
  
  @KeepForSdk
  public static interface SignOutCallbacks {
    @KeepForSdk
    void onSignOutComplete();
  }
  
  private abstract class zza extends zzc<Boolean> {
    private final int statusCode;
    
    private final Bundle zzcs;
    
    @BinderThread
    protected zza(BaseGmsClient this$0, int param1Int, Bundle param1Bundle) {
      super(this$0, Boolean.valueOf(true));
      this.statusCode = param1Int;
      this.zzcs = param1Bundle;
    }
    
    protected abstract void zza(ConnectionResult param1ConnectionResult);
    
    protected abstract boolean zzm();
    
    protected final void zzn() {}
  }
  
  final class zzb extends com.google.android.gms.internal.common.zze {
    public zzb(BaseGmsClient this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    private static void zza(Message param1Message) {
      BaseGmsClient.zzc zzc = (BaseGmsClient.zzc)param1Message.obj;
      zzc.zzn();
      zzc.unregister();
    }
    
    private static boolean zzb(Message param1Message) {
      return (param1Message.what == 2 || param1Message.what == 1 || param1Message.what == 7);
    }
    
    public final void handleMessage(Message param1Message) {
      ConnectionResult connectionResult;
      if (this.zzct.zzcr.get() != param1Message.arg1) {
        if (zzb(param1Message))
          zza(param1Message); 
        return;
      } 
      if ((param1Message.what == 1 || param1Message.what == 7 || (param1Message.what == 4 && !this.zzct.enableLocalFallback()) || param1Message.what == 5) && !this.zzct.isConnecting()) {
        zza(param1Message);
        return;
      } 
      int i = param1Message.what;
      PendingIntent pendingIntent = null;
      if (i == 4) {
        BaseGmsClient.zza(this.zzct, new ConnectionResult(param1Message.arg2));
        if (BaseGmsClient.zzb(this.zzct) && !BaseGmsClient.zzc(this.zzct)) {
          BaseGmsClient.zza(this.zzct, 3, (IInterface)null);
          return;
        } 
        if (BaseGmsClient.zzd(this.zzct) != null) {
          connectionResult = BaseGmsClient.zzd(this.zzct);
        } else {
          connectionResult = new ConnectionResult(8);
        } 
        this.zzct.zzcf.onReportServiceBinding(connectionResult);
        this.zzct.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 5) {
        if (BaseGmsClient.zzd(this.zzct) != null) {
          connectionResult = BaseGmsClient.zzd(this.zzct);
        } else {
          connectionResult = new ConnectionResult(8);
        } 
        this.zzct.zzcf.onReportServiceBinding(connectionResult);
        this.zzct.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 3) {
        if (((Message)connectionResult).obj instanceof PendingIntent)
          pendingIntent = (PendingIntent)((Message)connectionResult).obj; 
        connectionResult = new ConnectionResult(((Message)connectionResult).arg2, pendingIntent);
        this.zzct.zzcf.onReportServiceBinding(connectionResult);
        this.zzct.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 6) {
        BaseGmsClient.zza(this.zzct, 5, (IInterface)null);
        if (BaseGmsClient.zze(this.zzct) != null)
          BaseGmsClient.zze(this.zzct).onConnectionSuspended(((Message)connectionResult).arg2); 
        this.zzct.onConnectionSuspended(((Message)connectionResult).arg2);
        BaseGmsClient.zza(this.zzct, 5, 1, null);
        return;
      } 
      if (((Message)connectionResult).what == 2 && !this.zzct.isConnected()) {
        zza((Message)connectionResult);
        return;
      } 
      if (zzb((Message)connectionResult)) {
        ((BaseGmsClient.zzc)((Message)connectionResult).obj).zzo();
        return;
      } 
      i = ((Message)connectionResult).what;
      StringBuilder stringBuilder = new StringBuilder(45);
      stringBuilder.append("Don't know how to handle message: ");
      stringBuilder.append(i);
      Log.wtf("GmsClient", stringBuilder.toString(), new Exception());
    }
  }
  
  protected abstract class zzc<TListener> {
    private TListener zzcu;
    
    private boolean zzcv;
    
    public zzc(BaseGmsClient this$0, TListener param1TListener) {
      this.zzcu = param1TListener;
      this.zzcv = false;
    }
    
    public final void removeListener() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aconst_null
      //   4: putfield zzcu : Ljava/lang/Object;
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_1
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	10	finally
      //   11	13	10	finally
    }
    
    public final void unregister() {
      removeListener();
      synchronized (BaseGmsClient.zzf(this.zzct)) {
        BaseGmsClient.zzf(this.zzct).remove(this);
        return;
      } 
    }
    
    protected abstract void zza(TListener param1TListener);
    
    protected abstract void zzn();
    
    public final void zzo() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield zzcu : Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield zzcv : Z
      //   11: ifeq -> 75
      //   14: aload_0
      //   15: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   18: astore_2
      //   19: aload_2
      //   20: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   23: invokevirtual length : ()I
      //   26: istore_3
      //   27: new java/lang/StringBuilder
      //   30: astore #4
      //   32: aload #4
      //   34: iload_3
      //   35: bipush #47
      //   37: iadd
      //   38: invokespecial <init> : (I)V
      //   41: aload #4
      //   43: ldc 'Callback proxy '
      //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: pop
      //   49: aload #4
      //   51: aload_2
      //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: pop
      //   56: aload #4
      //   58: ldc ' being reused. This is not safe.'
      //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   63: pop
      //   64: ldc 'GmsClient'
      //   66: aload #4
      //   68: invokevirtual toString : ()Ljava/lang/String;
      //   71: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
      //   74: pop
      //   75: aload_0
      //   76: monitorexit
      //   77: aload_1
      //   78: ifnull -> 98
      //   81: aload_0
      //   82: aload_1
      //   83: invokevirtual zza : (Ljava/lang/Object;)V
      //   86: goto -> 102
      //   89: astore #4
      //   91: aload_0
      //   92: invokevirtual zzn : ()V
      //   95: aload #4
      //   97: athrow
      //   98: aload_0
      //   99: invokevirtual zzn : ()V
      //   102: aload_0
      //   103: monitorenter
      //   104: aload_0
      //   105: iconst_1
      //   106: putfield zzcv : Z
      //   109: aload_0
      //   110: monitorexit
      //   111: aload_0
      //   112: invokevirtual unregister : ()V
      //   115: return
      //   116: astore #4
      //   118: aload_0
      //   119: monitorexit
      //   120: aload #4
      //   122: athrow
      //   123: astore #4
      //   125: aload_0
      //   126: monitorexit
      //   127: aload #4
      //   129: athrow
      // Exception table:
      //   from	to	target	type
      //   2	75	123	finally
      //   75	77	123	finally
      //   81	86	89	java/lang/RuntimeException
      //   104	111	116	finally
      //   118	120	116	finally
      //   125	127	123	finally
    }
  }
  
  @VisibleForTesting
  public static final class zzd extends IGmsCallbacks.zza {
    private BaseGmsClient zzcw;
    
    private final int zzcx;
    
    public zzd(@NonNull BaseGmsClient param1BaseGmsClient, int param1Int) {
      this.zzcw = param1BaseGmsClient;
      this.zzcx = param1Int;
    }
    
    @BinderThread
    public final void onPostInitComplete(int param1Int, @NonNull IBinder param1IBinder, @Nullable Bundle param1Bundle) {
      Preconditions.checkNotNull(this.zzcw, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zzcw.onPostInitHandler(param1Int, param1IBinder, param1Bundle, this.zzcx);
      this.zzcw = null;
    }
    
    @BinderThread
    public final void zza(int param1Int, @Nullable Bundle param1Bundle) {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
    
    @BinderThread
    public final void zza(int param1Int, @NonNull IBinder param1IBinder, @NonNull zzb param1zzb) {
      Preconditions.checkNotNull(this.zzcw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
      Preconditions.checkNotNull(param1zzb);
      BaseGmsClient.zza(this.zzcw, param1zzb);
      onPostInitComplete(param1Int, param1IBinder, param1zzb.zzda);
    }
  }
  
  @VisibleForTesting
  public final class zze implements ServiceConnection {
    private final int zzcx;
    
    public zze(BaseGmsClient this$0, int param1Int) {
      this.zzcx = param1Int;
    }
    
    public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      if (param1IBinder == null) {
        BaseGmsClient.zza(this.zzct, 16);
        return;
      } 
      synchronized (BaseGmsClient.zza(this.zzct)) {
        IInterface iInterface;
        BaseGmsClient baseGmsClient = this.zzct;
        if (param1IBinder == null) {
          param1ComponentName = null;
        } else {
          iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
          if (iInterface != null && iInterface instanceof IGmsServiceBroker) {
            iInterface = iInterface;
          } else {
            iInterface = new IGmsServiceBroker.Stub.zza(param1IBinder);
          } 
        } 
        BaseGmsClient.zza(baseGmsClient, (IGmsServiceBroker)iInterface);
        this.zzct.zza(0, (Bundle)null, this.zzcx);
        return;
      } 
    }
    
    public final void onServiceDisconnected(ComponentName param1ComponentName) {
      synchronized (BaseGmsClient.zza(this.zzct)) {
        BaseGmsClient.zza(this.zzct, (IGmsServiceBroker)null);
        this.zzct.mHandler.sendMessage(this.zzct.mHandler.obtainMessage(6, this.zzcx, 1));
        return;
      } 
    }
  }
  
  protected final class zzf extends zza {
    private final IBinder zzcy;
    
    @BinderThread
    public zzf(BaseGmsClient this$0, int param1Int, IBinder param1IBinder, Bundle param1Bundle) {
      super(this$0, param1Int, param1Bundle);
      this.zzcy = param1IBinder;
    }
    
    protected final void zza(ConnectionResult param1ConnectionResult) {
      if (BaseGmsClient.zzg(this.zzct) != null)
        BaseGmsClient.zzg(this.zzct).onConnectionFailed(param1ConnectionResult); 
      this.zzct.onConnectionFailed(param1ConnectionResult);
    }
    
    protected final boolean zzm() {
      try {
        String str = this.zzcy.getInterfaceDescriptor();
        if (!this.zzct.getServiceDescriptor().equals(str)) {
          String str1 = this.zzct.getServiceDescriptor();
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 34 + String.valueOf(str).length());
          stringBuilder.append("service descriptor mismatch: ");
          stringBuilder.append(str1);
          stringBuilder.append(" vs. ");
          stringBuilder.append(str);
          Log.e("GmsClient", stringBuilder.toString());
          return false;
        } 
        IInterface iInterface = (IInterface)this.zzct.createServiceInterface(this.zzcy);
        if (iInterface != null && (BaseGmsClient.zza(this.zzct, 2, 4, iInterface) || BaseGmsClient.zza(this.zzct, 3, 4, iInterface))) {
          BaseGmsClient.zza(this.zzct, (ConnectionResult)null);
          Bundle bundle = this.zzct.getConnectionHint();
          if (BaseGmsClient.zze(this.zzct) != null)
            BaseGmsClient.zze(this.zzct).onConnected(bundle); 
          return true;
        } 
        return false;
      } catch (RemoteException remoteException) {
        Log.w("GmsClient", "service probably died");
        return false;
      } 
    }
  }
  
  protected final class zzg extends zza {
    @BinderThread
    public zzg(BaseGmsClient this$0, @Nullable int param1Int, Bundle param1Bundle) {
      super(this$0, param1Int, null);
    }
    
    protected final void zza(ConnectionResult param1ConnectionResult) {
      if (this.zzct.enableLocalFallback() && BaseGmsClient.zzb(this.zzct)) {
        BaseGmsClient.zza(this.zzct, 16);
        return;
      } 
      this.zzct.zzcf.onReportServiceBinding(param1ConnectionResult);
      this.zzct.onConnectionFailed(param1ConnectionResult);
    }
    
    protected final boolean zzm() {
      this.zzct.zzcf.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
      return true;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\BaseGmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */