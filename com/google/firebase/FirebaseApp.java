package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.internal.DefaultIdTokenListenersCountChangedListener;
import com.google.firebase.internal.InternalTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

@PublicApi
public class FirebaseApp {
  private static final List<String> API_INITIALIZERS = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
  
  private static final String AUTH_CLASSNAME = "com.google.firebase.auth.FirebaseAuth";
  
  private static final Set<String> CORE_CLASSES;
  
  private static final String CRASH_CLASSNAME = "com.google.firebase.crash.FirebaseCrash";
  
  @VisibleForTesting
  static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
  
  private static final List<String> DEFAULT_APP_API_INITITALIZERS = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
  
  public static final String DEFAULT_APP_NAME = "[DEFAULT]";
  
  private static final List<String> DEFAULT_CONTEXT_API_INITITALIZERS = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
  
  private static final List<String> DIRECT_BOOT_COMPATIBLE_API_INITIALIZERS = Arrays.asList(new String[0]);
  
  private static final String FIREBASE_ANDROID = "fire-android";
  
  private static final String FIREBASE_APP_PREFS = "com.google.firebase.common.prefs:";
  
  private static final String FIREBASE_COMMON = "fire-core";
  
  private static final String IID_CLASSNAME = "com.google.firebase.iid.FirebaseInstanceId";
  
  @GuardedBy("LOCK")
  static final Map<String, FirebaseApp> INSTANCES;
  
  private static final Object LOCK;
  
  private static final String LOG_TAG = "FirebaseApp";
  
  private static final String MEASUREMENT_CLASSNAME = "com.google.android.gms.measurement.AppMeasurement";
  
  private static final Executor UI_EXECUTOR;
  
  private final Context applicationContext;
  
  private final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
  
  private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList<BackgroundStateChangeListener>();
  
  private final ComponentRuntime componentRuntime;
  
  private final AtomicBoolean dataCollectionDefaultEnabled;
  
  private final AtomicBoolean deleted = new AtomicBoolean();
  
  private final List<IdTokenListener> idTokenListeners = new CopyOnWriteArrayList<IdTokenListener>();
  
  private IdTokenListenersCountChangedListener idTokenListenersCountChangedListener;
  
  private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList<FirebaseAppLifecycleListener>();
  
  private final String name;
  
  private final FirebaseOptions options;
  
  private final Publisher publisher;
  
  private final SharedPreferences sharedPreferences;
  
  private InternalTokenProvider tokenProvider;
  
  static {
    CORE_CLASSES = Collections.emptySet();
    LOCK = new Object();
    UI_EXECUTOR = new UiExecutor();
    INSTANCES = (Map<String, FirebaseApp>)new ArrayMap();
  }
  
  protected FirebaseApp(Context paramContext, String paramString, FirebaseOptions paramFirebaseOptions) {
    this.applicationContext = (Context)Preconditions.checkNotNull(paramContext);
    this.name = Preconditions.checkNotEmpty(paramString);
    this.options = (FirebaseOptions)Preconditions.checkNotNull(paramFirebaseOptions);
    this.idTokenListenersCountChangedListener = (IdTokenListenersCountChangedListener)new DefaultIdTokenListenersCountChangedListener();
    this.sharedPreferences = paramContext.getSharedPreferences(getSharedPrefsName(paramString), 0);
    this.dataCollectionDefaultEnabled = new AtomicBoolean(readAutoDataCollectionEnabled());
    List list = ComponentDiscovery.forContext(paramContext).discover();
    this.componentRuntime = new ComponentRuntime(UI_EXECUTOR, list, new Component[] { Component.of(paramContext, Context.class, new Class[0]), Component.of(this, FirebaseApp.class, new Class[0]), Component.of(paramFirebaseOptions, FirebaseOptions.class, new Class[0]), LibraryVersionComponent.create("fire-android", ""), LibraryVersionComponent.create("fire-core", "16.1.0"), DefaultUserAgentPublisher.component() });
    this.publisher = (Publisher)this.componentRuntime.get(Publisher.class);
  }
  
  private void checkNotDeleted() {
    Preconditions.checkState(this.deleted.get() ^ true, "FirebaseApp was deleted");
  }
  
  @VisibleForTesting
  public static void clearInstancesForTest() {
    synchronized (LOCK) {
      INSTANCES.clear();
      return;
    } 
  }
  
  private static List<String> getAllAppNames() {
    null = new ArrayList();
    synchronized (LOCK) {
      Iterator<FirebaseApp> iterator = INSTANCES.values().iterator();
      while (iterator.hasNext())
        null.add(((FirebaseApp)iterator.next()).getName()); 
      Collections.sort(null);
      return null;
    } 
  }
  
  @PublicApi
  public static List<FirebaseApp> getApps(Context paramContext) {
    synchronized (LOCK) {
      ArrayList<FirebaseApp> arrayList = new ArrayList();
      this((Collection)INSTANCES.values());
      return arrayList;
    } 
  }
  
  @NonNull
  @PublicApi
  public static FirebaseApp getInstance() {
    synchronized (LOCK) {
      FirebaseApp firebaseApp = INSTANCES.get("[DEFAULT]");
      if (firebaseApp != null)
        return firebaseApp; 
      IllegalStateException illegalStateException = new IllegalStateException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Default FirebaseApp is not initialized in this process ");
      stringBuilder.append(ProcessUtils.getMyProcessName());
      stringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
      this(stringBuilder.toString());
      throw illegalStateException;
    } 
  }
  
  @NonNull
  @PublicApi
  public static FirebaseApp getInstance(@NonNull String paramString) {
    synchronized (LOCK) {
      String str;
      FirebaseApp firebaseApp = INSTANCES.get(normalize(paramString));
      if (firebaseApp != null)
        return firebaseApp; 
      List<String> list = getAllAppNames();
      if (list.isEmpty()) {
        str = "";
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Available app names: ");
        stringBuilder.append(TextUtils.join(", ", list));
        str = stringBuilder.toString();
      } 
      paramString = String.format("FirebaseApp with name %s doesn't exist. %s", new Object[] { paramString, str });
      IllegalStateException illegalStateException = new IllegalStateException();
      this(paramString);
      throw illegalStateException;
    } 
  }
  
  @KeepForSdk
  public static String getPersistenceKey(String paramString, FirebaseOptions paramFirebaseOptions) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramString.getBytes(Charset.defaultCharset())));
    stringBuilder.append("+");
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramFirebaseOptions.getApplicationId().getBytes(Charset.defaultCharset())));
    return stringBuilder.toString();
  }
  
  private static String getSharedPrefsName(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.google.firebase.common.prefs:");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private void initializeAllApis() {
    boolean bool = ContextCompat.isDeviceProtectedStorage(this.applicationContext);
    if (bool) {
      UserUnlockReceiver.ensureReceiverRegistered(this.applicationContext);
    } else {
      this.componentRuntime.initializeEagerComponents(isDefaultApp());
    } 
    initializeApis(FirebaseApp.class, this, API_INITIALIZERS, bool);
    if (isDefaultApp()) {
      initializeApis(FirebaseApp.class, this, DEFAULT_APP_API_INITITALIZERS, bool);
      initializeApis(Context.class, this.applicationContext, DEFAULT_CONTEXT_API_INITITALIZERS, bool);
    } 
  }
  
  private <T> void initializeApis(Class<T> paramClass, T paramT, Iterable<String> paramIterable, boolean paramBoolean) {
    Iterator<String> iterator = paramIterable.iterator();
    while (true) {
      while (true)
        break; 
      if (Modifier.isPublic(SYNTHETIC_LOCAL_VARIABLE_7) && Modifier.isStatic(SYNTHETIC_LOCAL_VARIABLE_7))
        SYNTHETIC_LOCAL_VARIABLE_6.invoke(null, new Object[] { paramT }); 
    } 
  }
  
  @Nullable
  @PublicApi
  public static FirebaseApp initializeApp(@NonNull Context paramContext) {
    synchronized (LOCK) {
      if (INSTANCES.containsKey("[DEFAULT]")) {
        firebaseApp = getInstance();
        return firebaseApp;
      } 
      FirebaseOptions firebaseOptions = FirebaseOptions.fromResource((Context)firebaseApp);
      if (firebaseOptions == null) {
        Log.d("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
        return null;
      } 
      FirebaseApp firebaseApp = initializeApp((Context)firebaseApp, firebaseOptions);
      return firebaseApp;
    } 
  }
  
  @NonNull
  @PublicApi
  public static FirebaseApp initializeApp(@NonNull Context paramContext, @NonNull FirebaseOptions paramFirebaseOptions) {
    return initializeApp(paramContext, paramFirebaseOptions, "[DEFAULT]");
  }
  
  @NonNull
  @PublicApi
  public static FirebaseApp initializeApp(@NonNull Context paramContext, @NonNull FirebaseOptions paramFirebaseOptions, @NonNull String paramString) {
    GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(paramContext);
    paramString = normalize(paramString);
    if (paramContext.getApplicationContext() != null)
      paramContext = paramContext.getApplicationContext(); 
    synchronized (LOCK) {
      boolean bool;
      if (!INSTANCES.containsKey(paramString)) {
        bool = true;
      } else {
        bool = false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("FirebaseApp name ");
      stringBuilder.append(paramString);
      stringBuilder.append(" already exists!");
      Preconditions.checkState(bool, stringBuilder.toString());
      Preconditions.checkNotNull(paramContext, "Application context cannot be null.");
      FirebaseApp firebaseApp = new FirebaseApp();
      this(paramContext, paramString, paramFirebaseOptions);
      INSTANCES.put(paramString, firebaseApp);
      firebaseApp.initializeAllApis();
      return firebaseApp;
    } 
  }
  
  private static String normalize(@NonNull String paramString) {
    return paramString.trim();
  }
  
  private void notifyBackgroundStateChangeListeners(boolean paramBoolean) {
    Log.d("FirebaseApp", "Notifying background state change listeners.");
    Iterator<BackgroundStateChangeListener> iterator = this.backgroundStateChangeListeners.iterator();
    while (iterator.hasNext())
      ((BackgroundStateChangeListener)iterator.next()).onBackgroundStateChanged(paramBoolean); 
  }
  
  private void notifyOnAppDeleted() {
    Iterator<FirebaseAppLifecycleListener> iterator = this.lifecycleListeners.iterator();
    while (iterator.hasNext())
      ((FirebaseAppLifecycleListener)iterator.next()).onDeleted(this.name, this.options); 
  }
  
  private boolean readAutoDataCollectionEnabled() {
    if (this.sharedPreferences.contains("firebase_data_collection_default_enabled"))
      return this.sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true); 
    try {
      PackageManager packageManager = this.applicationContext.getPackageManager();
      if (packageManager != null) {
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.applicationContext.getPackageName(), 128);
        if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))
          return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled"); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return true;
  }
  
  @KeepForSdk
  public void addBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener) {
    checkNotDeleted();
    if (this.automaticResourceManagementEnabled.get() && BackgroundDetector.getInstance().isInBackground())
      paramBackgroundStateChangeListener.onBackgroundStateChanged(true); 
    this.backgroundStateChangeListeners.add(paramBackgroundStateChangeListener);
  }
  
  @Deprecated
  @KeepForSdk
  public void addIdTokenListener(@NonNull IdTokenListener paramIdTokenListener) {
    checkNotDeleted();
    Preconditions.checkNotNull(paramIdTokenListener);
    this.idTokenListeners.add(paramIdTokenListener);
    this.idTokenListenersCountChangedListener.onListenerCountChanged(this.idTokenListeners.size());
  }
  
  @KeepForSdk
  public void addLifecycleEventListener(@NonNull FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener) {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.add(paramFirebaseAppLifecycleListener);
  }
  
  @PublicApi
  public void delete() {
    if (!this.deleted.compareAndSet(false, true))
      return; 
    synchronized (LOCK) {
      INSTANCES.remove(this.name);
      notifyOnAppDeleted();
      return;
    } 
  }
  
  public boolean equals(Object paramObject) {
    return !(paramObject instanceof FirebaseApp) ? false : this.name.equals(((FirebaseApp)paramObject).getName());
  }
  
  @KeepForSdk
  public <T> T get(Class<T> paramClass) {
    checkNotDeleted();
    return (T)this.componentRuntime.get(paramClass);
  }
  
  @NonNull
  @PublicApi
  public Context getApplicationContext() {
    checkNotDeleted();
    return this.applicationContext;
  }
  
  @Deprecated
  @KeepForSdk
  public List<IdTokenListener> getListeners() {
    checkNotDeleted();
    return this.idTokenListeners;
  }
  
  @NonNull
  @PublicApi
  public String getName() {
    checkNotDeleted();
    return this.name;
  }
  
  @NonNull
  @PublicApi
  public FirebaseOptions getOptions() {
    checkNotDeleted();
    return this.options;
  }
  
  @KeepForSdk
  public String getPersistenceKey() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())));
    stringBuilder.append("+");
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset())));
    return stringBuilder.toString();
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public Task<GetTokenResult> getToken(boolean paramBoolean) {
    checkNotDeleted();
    InternalTokenProvider internalTokenProvider = this.tokenProvider;
    return (internalTokenProvider == null) ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : internalTokenProvider.getAccessToken(paramBoolean);
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  public String getUid() throws FirebaseApiNotAvailableException {
    checkNotDeleted();
    InternalTokenProvider internalTokenProvider = this.tokenProvider;
    if (internalTokenProvider != null)
      return internalTokenProvider.getUid(); 
    throw new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.");
  }
  
  public int hashCode() {
    return this.name.hashCode();
  }
  
  @KeepForSdk
  public boolean isDataCollectionDefaultEnabled() {
    checkNotDeleted();
    return this.dataCollectionDefaultEnabled.get();
  }
  
  @VisibleForTesting
  @KeepForSdk
  public boolean isDefaultApp() {
    return "[DEFAULT]".equals(getName());
  }
  
  @Deprecated
  @UiThread
  @KeepForSdk
  public void notifyIdTokenListeners(@NonNull InternalTokenResult paramInternalTokenResult) {
    Log.d("FirebaseApp", "Notifying auth state listeners.");
    Iterator<IdTokenListener> iterator = this.idTokenListeners.iterator();
    byte b;
    for (b = 0; iterator.hasNext(); b++)
      ((IdTokenListener)iterator.next()).onIdTokenChanged(paramInternalTokenResult); 
    Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[] { Integer.valueOf(b) }));
  }
  
  @KeepForSdk
  public void removeBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener) {
    checkNotDeleted();
    this.backgroundStateChangeListeners.remove(paramBackgroundStateChangeListener);
  }
  
  @Deprecated
  @KeepForSdk
  public void removeIdTokenListener(@NonNull IdTokenListener paramIdTokenListener) {
    checkNotDeleted();
    Preconditions.checkNotNull(paramIdTokenListener);
    this.idTokenListeners.remove(paramIdTokenListener);
    this.idTokenListenersCountChangedListener.onListenerCountChanged(this.idTokenListeners.size());
  }
  
  @KeepForSdk
  public void removeLifecycleEventListener(@NonNull FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener) {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.remove(paramFirebaseAppLifecycleListener);
  }
  
  @PublicApi
  public void setAutomaticResourceManagementEnabled(boolean paramBoolean) {
    checkNotDeleted();
    if (this.automaticResourceManagementEnabled.compareAndSet(paramBoolean ^ true, paramBoolean)) {
      boolean bool = BackgroundDetector.getInstance().isInBackground();
      if (paramBoolean && bool) {
        notifyBackgroundStateChangeListeners(true);
      } else if (!paramBoolean && bool) {
        notifyBackgroundStateChangeListeners(false);
      } 
    } 
  }
  
  @KeepForSdk
  public void setDataCollectionDefaultEnabled(boolean paramBoolean) {
    checkNotDeleted();
    if (this.dataCollectionDefaultEnabled.compareAndSet(paramBoolean ^ true, paramBoolean)) {
      this.sharedPreferences.edit().putBoolean("firebase_data_collection_default_enabled", paramBoolean).commit();
      this.publisher.publish(new Event(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(paramBoolean)));
    } 
  }
  
  @Deprecated
  @KeepForSdk
  public void setIdTokenListenersCountChangedListener(@NonNull IdTokenListenersCountChangedListener paramIdTokenListenersCountChangedListener) {
    this.idTokenListenersCountChangedListener = (IdTokenListenersCountChangedListener)Preconditions.checkNotNull(paramIdTokenListenersCountChangedListener);
    this.idTokenListenersCountChangedListener.onListenerCountChanged(this.idTokenListeners.size());
  }
  
  @Deprecated
  @KeepForSdk
  public void setTokenProvider(@NonNull InternalTokenProvider paramInternalTokenProvider) {
    this.tokenProvider = (InternalTokenProvider)Preconditions.checkNotNull(paramInternalTokenProvider);
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("name", this.name).add("options", this.options).toString();
  }
  
  @KeepForSdk
  public static interface BackgroundStateChangeListener {
    @KeepForSdk
    void onBackgroundStateChanged(boolean param1Boolean);
  }
  
  @TargetApi(14)
  private static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {
    private static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference<GlobalBackgroundStateListener>();
    
    private static void ensureBackgroundStateListenerRegistered(Context param1Context) {
      if (!PlatformVersion.isAtLeastIceCreamSandwich() || !(param1Context.getApplicationContext() instanceof Application))
        return; 
      Application application = (Application)param1Context.getApplicationContext();
      if (INSTANCE.get() == null) {
        GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
        if (INSTANCE.compareAndSet(null, globalBackgroundStateListener)) {
          BackgroundDetector.initialize(application);
          BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
        } 
      } 
    }
    
    public void onBackgroundStateChanged(boolean param1Boolean) {
      synchronized (FirebaseApp.LOCK) {
        ArrayList arrayList = new ArrayList();
        this((Collection)FirebaseApp.INSTANCES.values());
        for (FirebaseApp firebaseApp : arrayList) {
          if (firebaseApp.automaticResourceManagementEnabled.get())
            firebaseApp.notifyBackgroundStateChangeListeners(param1Boolean); 
        } 
        return;
      } 
    }
  }
  
  @Deprecated
  @KeepForSdk
  public static interface IdTokenListener {
    @KeepForSdk
    void onIdTokenChanged(@NonNull InternalTokenResult param1InternalTokenResult);
  }
  
  @Deprecated
  @KeepForSdk
  public static interface IdTokenListenersCountChangedListener {
    @KeepForSdk
    void onListenerCountChanged(int param1Int);
  }
  
  private static class UiExecutor implements Executor {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    
    private UiExecutor() {}
    
    public void execute(@NonNull Runnable param1Runnable) {
      HANDLER.post(param1Runnable);
    }
  }
  
  @TargetApi(24)
  private static class UserUnlockReceiver extends BroadcastReceiver {
    private static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference<UserUnlockReceiver>();
    
    private final Context applicationContext;
    
    public UserUnlockReceiver(Context param1Context) {
      this.applicationContext = param1Context;
    }
    
    private static void ensureReceiverRegistered(Context param1Context) {
      if (INSTANCE.get() == null) {
        UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(param1Context);
        if (INSTANCE.compareAndSet(null, userUnlockReceiver))
          param1Context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED")); 
      } 
    }
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      synchronized (FirebaseApp.LOCK) {
        Iterator<FirebaseApp> iterator = FirebaseApp.INSTANCES.values().iterator();
        while (iterator.hasNext())
          ((FirebaseApp)iterator.next()).initializeAllApis(); 
        unregister();
        return;
      } 
    }
    
    public void unregister() {
      this.applicationContext.unregisterReceiver(this);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\FirebaseApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */