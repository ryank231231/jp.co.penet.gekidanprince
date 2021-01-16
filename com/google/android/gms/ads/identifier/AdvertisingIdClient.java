package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@KeepForSdk
public class AdvertisingIdClient {
  @GuardedBy("this")
  private final Context mContext;
  
  @Nullable
  @GuardedBy("this")
  private BlockingServiceConnection zze;
  
  @Nullable
  @GuardedBy("this")
  private zze zzf;
  
  @GuardedBy("this")
  private boolean zzg;
  
  private final Object zzh = new Object();
  
  @Nullable
  @GuardedBy("mAutoDisconnectTaskLock")
  private zza zzi;
  
  private final boolean zzj;
  
  private final long zzk;
  
  @KeepForSdk
  public AdvertisingIdClient(Context paramContext) {
    this(paramContext, 30000L, false, false);
  }
  
  @VisibleForTesting
  private AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
    Preconditions.checkNotNull(paramContext);
    Context context = paramContext;
    if (paramBoolean1) {
      context = paramContext.getApplicationContext();
      if (context == null)
        context = paramContext; 
    } 
    this.mContext = context;
    this.zzg = false;
    this.zzk = paramLong;
    this.zzj = paramBoolean2;
  }
  
  @KeepForSdk
  public static Info getAdvertisingIdInfo(Context paramContext) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
    zzb zzb = new zzb(paramContext);
    boolean bool = zzb.getBoolean("gads:ad_id_app_context:enabled", false);
    float f = zzb.getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
    String str = zzb.getString("gads:ad_id_use_shared_preference:experiment_id", "");
    AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(paramContext, -1L, bool, zzb.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
    try {
      long l = SystemClock.elapsedRealtime();
      advertisingIdClient.zza(false);
      Info info = advertisingIdClient.getInfo();
      advertisingIdClient.zza(info, bool, f, SystemClock.elapsedRealtime() - l, str, null);
      advertisingIdClient.finish();
      return info;
    } catch (Throwable throwable) {
      advertisingIdClient.zza(null, bool, f, -1L, str, throwable);
      throw throwable;
    } finally {}
    advertisingIdClient.finish();
    throw str;
  }
  
  @KeepForSdk
  public static boolean getIsAdIdFakeForDebugLogging(Context paramContext) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
    null = new zzb(paramContext);
    AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(paramContext, -1L, null.getBoolean("gads:ad_id_app_context:enabled", false), null.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
    try {
      advertisingIdClient.zza(false);
      return advertisingIdClient.zzb();
    } finally {
      advertisingIdClient.finish();
    } 
  }
  
  @KeepForSdk
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  private static BlockingServiceConnection zza(Context paramContext, boolean paramBoolean) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
    try {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      int i = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, 12451000);
      if (i == 0 || i == 2) {
        String str;
        if (paramBoolean) {
          str = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
        } else {
          str = "com.google.android.gms.ads.identifier.service.START";
        } 
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        Intent intent = new Intent(str);
        intent.setPackage("com.google.android.gms");
        try {
          paramBoolean = ConnectionTracker.getInstance().bindService(paramContext, intent, (ServiceConnection)blockingServiceConnection, 1);
          if (paramBoolean)
            return blockingServiceConnection; 
          throw new IOException("Connection failure");
        } catch (Throwable throwable) {
          throw new IOException(throwable);
        } 
      } 
      throw new IOException("Google Play services not available");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new GooglePlayServicesNotAvailableException(9);
    } 
  }
  
  @VisibleForTesting
  private static zze zza(Context paramContext, BlockingServiceConnection paramBlockingServiceConnection) throws IOException {
    try {
      return zzf.zza(paramBlockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
    } catch (InterruptedException interruptedException) {
      throw new IOException("Interrupted exception");
    } catch (Throwable throwable) {
      throw new IOException(throwable);
    } 
  }
  
  private final void zza() {
    synchronized (this.zzh) {
      if (this.zzi != null) {
        this.zzi.zzo.countDown();
        try {
          this.zzi.join();
        } catch (InterruptedException interruptedException) {}
      } 
      if (this.zzk > 0L) {
        zza zza1 = new zza();
        this(this, this.zzk);
        this.zzi = zza1;
      } 
      return;
    } 
  }
  
  @VisibleForTesting
  private final void zza(boolean paramBoolean) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
    // Byte code:
    //   0: ldc 'Calling this from your main thread can lead to deadlock'
    //   2: invokestatic checkNotMainThread : (Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield zzg : Z
    //   11: ifeq -> 18
    //   14: aload_0
    //   15: invokevirtual finish : ()V
    //   18: aload_0
    //   19: aload_0
    //   20: getfield mContext : Landroid/content/Context;
    //   23: aload_0
    //   24: getfield zzj : Z
    //   27: invokestatic zza : (Landroid/content/Context;Z)Lcom/google/android/gms/common/BlockingServiceConnection;
    //   30: putfield zze : Lcom/google/android/gms/common/BlockingServiceConnection;
    //   33: aload_0
    //   34: aload_0
    //   35: getfield mContext : Landroid/content/Context;
    //   38: aload_0
    //   39: getfield zze : Lcom/google/android/gms/common/BlockingServiceConnection;
    //   42: invokestatic zza : (Landroid/content/Context;Lcom/google/android/gms/common/BlockingServiceConnection;)Lcom/google/android/gms/internal/ads_identifier/zze;
    //   45: putfield zzf : Lcom/google/android/gms/internal/ads_identifier/zze;
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield zzg : Z
    //   53: iload_1
    //   54: ifeq -> 61
    //   57: aload_0
    //   58: invokespecial zza : ()V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   7	18	64	finally
    //   18	53	64	finally
    //   57	61	64	finally
    //   61	63	64	finally
    //   65	67	64	finally
  }
  
  @VisibleForTesting
  private final boolean zza(Info paramInfo, boolean paramBoolean, float paramFloat, long paramLong, String paramString, Throwable paramThrowable) {
    String str;
    if (Math.random() > paramFloat)
      return false; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    } 
    hashMap.put("app_context", str);
    if (paramInfo != null) {
      if (paramInfo.isLimitAdTrackingEnabled()) {
        str = "1";
      } else {
        str = "0";
      } 
      hashMap.put("limit_ad_tracking", str);
    } 
    if (paramInfo != null && paramInfo.getId() != null)
      hashMap.put("ad_id_size", Integer.toString(paramInfo.getId().length())); 
    if (paramThrowable != null)
      hashMap.put("error", paramThrowable.getClass().getName()); 
    if (paramString != null && !paramString.isEmpty())
      hashMap.put("experiment_id", paramString); 
    hashMap.put("tag", "AdvertisingIdClient");
    hashMap.put("time_spent", Long.toString(paramLong));
    (new zza(this, hashMap)).start();
    return true;
  }
  
  private final boolean zzb() throws IOException {
    // Byte code:
    //   0: ldc 'Calling this from your main thread can lead to deadlock'
    //   2: invokestatic checkNotMainThread : (Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield zzg : Z
    //   11: ifne -> 101
    //   14: aload_0
    //   15: getfield zzh : Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield zzi : Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull -> 83
    //   28: aload_0
    //   29: getfield zzi : Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: getfield zzp : Z
    //   35: ifeq -> 83
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_0
    //   41: iconst_0
    //   42: invokespecial zza : (Z)V
    //   45: aload_0
    //   46: getfield zzg : Z
    //   49: ifeq -> 55
    //   52: goto -> 101
    //   55: new java/io/IOException
    //   58: astore_1
    //   59: aload_1
    //   60: ldc_w 'AdvertisingIdClient cannot reconnect.'
    //   63: invokespecial <init> : (Ljava/lang/String;)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: new java/io/IOException
    //   72: astore_2
    //   73: aload_2
    //   74: ldc_w 'AdvertisingIdClient cannot reconnect.'
    //   77: aload_1
    //   78: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_2
    //   82: athrow
    //   83: new java/io/IOException
    //   86: astore_2
    //   87: aload_2
    //   88: ldc_w 'AdvertisingIdClient is not connected.'
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: aload_2
    //   95: athrow
    //   96: astore_2
    //   97: aload_1
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    //   101: aload_0
    //   102: getfield zze : Lcom/google/android/gms/common/BlockingServiceConnection;
    //   105: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload_0
    //   110: getfield zzf : Lcom/google/android/gms/internal/ads_identifier/zze;
    //   113: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_0
    //   118: getfield zzf : Lcom/google/android/gms/internal/ads_identifier/zze;
    //   121: invokeinterface zzc : ()Z
    //   126: istore_3
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_0
    //   130: invokespecial zza : ()V
    //   133: iload_3
    //   134: ireturn
    //   135: astore_1
    //   136: ldc_w 'AdvertisingIdClient'
    //   139: ldc_w 'GMS remote exception '
    //   142: aload_1
    //   143: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   146: pop
    //   147: new java/io/IOException
    //   150: astore_1
    //   151: aload_1
    //   152: ldc_w 'Remote exception'
    //   155: invokespecial <init> : (Ljava/lang/String;)V
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Exception table:
    //   from	to	target	type
    //   7	21	160	finally
    //   21	40	96	finally
    //   40	45	68	java/lang/Exception
    //   40	45	160	finally
    //   45	52	160	finally
    //   55	68	160	finally
    //   69	83	160	finally
    //   83	96	96	finally
    //   97	99	96	finally
    //   99	101	160	finally
    //   101	117	160	finally
    //   117	127	135	android/os/RemoteException
    //   117	127	160	finally
    //   127	129	160	finally
    //   136	160	160	finally
    //   161	163	160	finally
  }
  
  protected void finalize() throws Throwable {
    finish();
    super.finalize();
  }
  
  public final void finish() {
    // Byte code:
    //   0: ldc 'Calling this from your main thread can lead to deadlock'
    //   2: invokestatic checkNotMainThread : (Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield mContext : Landroid/content/Context;
    //   11: ifnull -> 80
    //   14: aload_0
    //   15: getfield zze : Lcom/google/android/gms/common/BlockingServiceConnection;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull -> 26
    //   23: goto -> 80
    //   26: aload_0
    //   27: getfield zzg : Z
    //   30: ifeq -> 62
    //   33: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   36: aload_0
    //   37: getfield mContext : Landroid/content/Context;
    //   40: aload_0
    //   41: getfield zze : Lcom/google/android/gms/common/BlockingServiceConnection;
    //   44: invokevirtual unbindService : (Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   47: goto -> 62
    //   50: astore_1
    //   51: ldc_w 'AdvertisingIdClient'
    //   54: ldc_w 'AdvertisingIdClient unbindService failed.'
    //   57: aload_1
    //   58: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   61: pop
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield zzg : Z
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield zzf : Lcom/google/android/gms/internal/ads_identifier/zze;
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield zze : Lcom/google/android/gms/common/BlockingServiceConnection;
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   7	19	83	finally
    //   26	47	50	java/lang/Throwable
    //   26	47	83	finally
    //   51	62	83	finally
    //   62	79	83	finally
    //   80	82	83	finally
    //   84	86	83	finally
  }
  
  @KeepForSdk
  public Info getInfo() throws IOException {
    // Byte code:
    //   0: ldc 'Calling this from your main thread can lead to deadlock'
    //   2: invokestatic checkNotMainThread : (Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield zzg : Z
    //   11: ifne -> 101
    //   14: aload_0
    //   15: getfield zzh : Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield zzi : Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull -> 83
    //   28: aload_0
    //   29: getfield zzi : Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: getfield zzp : Z
    //   35: ifeq -> 83
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_0
    //   41: iconst_0
    //   42: invokespecial zza : (Z)V
    //   45: aload_0
    //   46: getfield zzg : Z
    //   49: ifeq -> 55
    //   52: goto -> 101
    //   55: new java/io/IOException
    //   58: astore_1
    //   59: aload_1
    //   60: ldc_w 'AdvertisingIdClient cannot reconnect.'
    //   63: invokespecial <init> : (Ljava/lang/String;)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_2
    //   69: new java/io/IOException
    //   72: astore_1
    //   73: aload_1
    //   74: ldc_w 'AdvertisingIdClient cannot reconnect.'
    //   77: aload_2
    //   78: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_1
    //   82: athrow
    //   83: new java/io/IOException
    //   86: astore_2
    //   87: aload_2
    //   88: ldc_w 'AdvertisingIdClient is not connected.'
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: aload_2
    //   95: athrow
    //   96: astore_2
    //   97: aload_1
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    //   101: aload_0
    //   102: getfield zze : Lcom/google/android/gms/common/BlockingServiceConnection;
    //   105: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload_0
    //   110: getfield zzf : Lcom/google/android/gms/internal/ads_identifier/zze;
    //   113: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: new com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   120: astore_1
    //   121: aload_1
    //   122: aload_0
    //   123: getfield zzf : Lcom/google/android/gms/internal/ads_identifier/zze;
    //   126: invokeinterface getId : ()Ljava/lang/String;
    //   131: aload_0
    //   132: getfield zzf : Lcom/google/android/gms/internal/ads_identifier/zze;
    //   135: iconst_1
    //   136: invokeinterface zzb : (Z)Z
    //   141: invokespecial <init> : (Ljava/lang/String;Z)V
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_0
    //   147: invokespecial zza : ()V
    //   150: aload_1
    //   151: areturn
    //   152: astore_1
    //   153: ldc_w 'AdvertisingIdClient'
    //   156: ldc_w 'GMS remote exception '
    //   159: aload_1
    //   160: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   163: pop
    //   164: new java/io/IOException
    //   167: astore_1
    //   168: aload_1
    //   169: ldc_w 'Remote exception'
    //   172: invokespecial <init> : (Ljava/lang/String;)V
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Exception table:
    //   from	to	target	type
    //   7	21	177	finally
    //   21	40	96	finally
    //   40	45	68	java/lang/Exception
    //   40	45	177	finally
    //   45	52	177	finally
    //   55	68	177	finally
    //   69	83	177	finally
    //   83	96	96	finally
    //   97	99	96	finally
    //   99	101	177	finally
    //   101	117	177	finally
    //   117	144	152	android/os/RemoteException
    //   117	144	177	finally
    //   144	146	177	finally
    //   153	177	177	finally
    //   178	180	177	finally
  }
  
  @KeepForSdk
  public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
    zza(true);
  }
  
  @KeepForSdkWithMembers
  public static final class Info {
    private final String zzq;
    
    private final boolean zzr;
    
    public Info(String param1String, boolean param1Boolean) {
      this.zzq = param1String;
      this.zzr = param1Boolean;
    }
    
    public final String getId() {
      return this.zzq;
    }
    
    public final boolean isLimitAdTrackingEnabled() {
      return this.zzr;
    }
    
    public final String toString() {
      String str = this.zzq;
      boolean bool = this.zzr;
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
      stringBuilder.append("{");
      stringBuilder.append(str);
      stringBuilder.append("}");
      stringBuilder.append(bool);
      return stringBuilder.toString();
    }
  }
  
  @VisibleForTesting
  static final class zza extends Thread {
    private WeakReference<AdvertisingIdClient> zzm;
    
    private long zzn;
    
    CountDownLatch zzo;
    
    boolean zzp;
    
    public zza(AdvertisingIdClient param1AdvertisingIdClient, long param1Long) {
      this.zzm = new WeakReference<AdvertisingIdClient>(param1AdvertisingIdClient);
      this.zzn = param1Long;
      this.zzo = new CountDownLatch(1);
      this.zzp = false;
      start();
    }
    
    private final void disconnect() {
      AdvertisingIdClient advertisingIdClient = this.zzm.get();
      if (advertisingIdClient != null) {
        advertisingIdClient.finish();
        this.zzp = true;
      } 
    }
    
    public final void run() {
      try {
        if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS))
          disconnect(); 
        return;
      } catch (InterruptedException interruptedException) {
        disconnect();
        return;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\ads\identifier\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */