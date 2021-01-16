package com.google.android.vending.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LicenseChecker implements ServiceConnection {
  private static final boolean DEBUG_LICENSE_ERROR = false;
  
  private static final String KEY_FACTORY_ALGORITHM = "RSA";
  
  private static final SecureRandom RANDOM = new SecureRandom();
  
  private static final String TAG = "LicenseChecker";
  
  private static final int TIMEOUT_MS = 10000;
  
  private final Set<LicenseValidator> mChecksInProgress = new HashSet<LicenseValidator>();
  
  private final Context mContext;
  
  private Handler mHandler;
  
  private final String mPackageName;
  
  private final Queue<LicenseValidator> mPendingChecks = new LinkedList<LicenseValidator>();
  
  private final Policy mPolicy;
  
  private PublicKey mPublicKey;
  
  private ILicensingService mService;
  
  private final String mVersionCode;
  
  public LicenseChecker(Context paramContext, Policy paramPolicy, String paramString) {
    this.mContext = paramContext;
    this.mPolicy = paramPolicy;
    this.mPublicKey = generatePublicKey(paramString);
    this.mPackageName = this.mContext.getPackageName();
    this.mVersionCode = getVersionCode(paramContext, this.mPackageName);
    HandlerThread handlerThread = new HandlerThread("background thread");
    handlerThread.start();
    this.mHandler = new Handler(handlerThread.getLooper());
  }
  
  private void cleanupService() {
    if (this.mService != null) {
      try {
        this.mContext.unbindService(this);
      } catch (IllegalArgumentException illegalArgumentException) {
        Log.e("LicenseChecker", "Unable to unbind from licensing service (already unbound)");
      } 
      this.mService = null;
    } 
  }
  
  private void finishCheck(LicenseValidator paramLicenseValidator) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mChecksInProgress : Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: getfield mChecksInProgress : Ljava/util/Set;
    //   17: invokeinterface isEmpty : ()Z
    //   22: ifeq -> 29
    //   25: aload_0
    //   26: invokespecial cleanupService : ()V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	32	finally
  }
  
  private int generateNonce() {
    return RANDOM.nextInt();
  }
  
  private static PublicKey generatePublicKey(String paramString) {
    try {
      byte[] arrayOfByte = Base64.decode(paramString);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
      this(arrayOfByte);
      return keyFactory.generatePublic(x509EncodedKeySpec);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } catch (Base64DecoderException base64DecoderException) {
      Log.e("LicenseChecker", "Could not decode from Base64.");
      throw new IllegalArgumentException(base64DecoderException);
    } catch (InvalidKeySpecException invalidKeySpecException) {
      Log.e("LicenseChecker", "Invalid key specification.");
      throw new IllegalArgumentException(invalidKeySpecException);
    } 
  }
  
  private static String getVersionCode(Context paramContext, String paramString) {
    try {
      int i = (paramContext.getPackageManager().getPackageInfo(paramString, 0)).versionCode;
      return String.valueOf(i);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("LicenseChecker", "Package not found. could not get version code.");
      return "";
    } 
  }
  
  private void handleServiceConnectionError(LicenseValidator paramLicenseValidator) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPolicy : Lcom/google/android/vending/licensing/Policy;
    //   6: sipush #291
    //   9: aconst_null
    //   10: invokeinterface processServerResponse : (ILcom/google/android/vending/licensing/ResponseData;)V
    //   15: aload_0
    //   16: getfield mPolicy : Lcom/google/android/vending/licensing/Policy;
    //   19: invokeinterface allowAccess : ()Z
    //   24: ifeq -> 42
    //   27: aload_1
    //   28: invokevirtual getCallback : ()Lcom/google/android/vending/licensing/LicenseCheckerCallback;
    //   31: sipush #291
    //   34: invokeinterface allow : (I)V
    //   39: goto -> 54
    //   42: aload_1
    //   43: invokevirtual getCallback : ()Lcom/google/android/vending/licensing/LicenseCheckerCallback;
    //   46: sipush #291
    //   49: invokeinterface dontAllow : (I)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   2	39	57	finally
    //   42	54	57	finally
  }
  
  private void runChecks() {
    while (true) {
      LicenseValidator licenseValidator = this.mPendingChecks.poll();
      if (licenseValidator != null) {
        try {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("Calling checkLicense on service for ");
          stringBuilder.append(licenseValidator.getPackageName());
          Log.i("LicenseChecker", stringBuilder.toString());
          ILicensingService iLicensingService = this.mService;
          long l = licenseValidator.getNonce();
          String str = licenseValidator.getPackageName();
          ResultListener resultListener = new ResultListener();
          this(this, licenseValidator);
          iLicensingService.checkLicense(l, str, resultListener);
          this.mChecksInProgress.add(licenseValidator);
        } catch (RemoteException remoteException) {
          Log.w("LicenseChecker", "RemoteException in checkLicense call.", (Throwable)remoteException);
          handleServiceConnectionError(licenseValidator);
        } 
        continue;
      } 
      break;
    } 
  }
  
  public void checkAccess(LicenseCheckerCallback paramLicenseCheckerCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPolicy : Lcom/google/android/vending/licensing/Policy;
    //   6: invokeinterface allowAccess : ()Z
    //   11: ifeq -> 35
    //   14: ldc 'LicenseChecker'
    //   16: ldc_w 'Using cached license response'
    //   19: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: aload_1
    //   24: sipush #256
    //   27: invokeinterface allow : (I)V
    //   32: goto -> 204
    //   35: new com/google/android/vending/licensing/LicenseValidator
    //   38: astore_2
    //   39: aload_0
    //   40: getfield mPolicy : Lcom/google/android/vending/licensing/Policy;
    //   43: astore_3
    //   44: new com/google/android/vending/licensing/NullDeviceLimiter
    //   47: astore #4
    //   49: aload #4
    //   51: invokespecial <init> : ()V
    //   54: aload_2
    //   55: aload_3
    //   56: aload #4
    //   58: aload_1
    //   59: aload_0
    //   60: invokespecial generateNonce : ()I
    //   63: aload_0
    //   64: getfield mPackageName : Ljava/lang/String;
    //   67: aload_0
    //   68: getfield mVersionCode : Ljava/lang/String;
    //   71: invokespecial <init> : (Lcom/google/android/vending/licensing/Policy;Lcom/google/android/vending/licensing/DeviceLimiter;Lcom/google/android/vending/licensing/LicenseCheckerCallback;ILjava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield mService : Lcom/google/android/vending/licensing/ILicensingService;
    //   78: ifnonnull -> 189
    //   81: ldc 'LicenseChecker'
    //   83: ldc_w 'Binding to licensing service.'
    //   86: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   89: pop
    //   90: new android/content/Intent
    //   93: astore #4
    //   95: new java/lang/String
    //   98: astore_3
    //   99: aload_3
    //   100: ldc_w 'Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U='
    //   103: invokestatic decode : (Ljava/lang/String;)[B
    //   106: invokespecial <init> : ([B)V
    //   109: aload #4
    //   111: aload_3
    //   112: invokespecial <init> : (Ljava/lang/String;)V
    //   115: aload #4
    //   117: ldc_w 'com.android.vending'
    //   120: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   123: pop
    //   124: aload_0
    //   125: getfield mContext : Landroid/content/Context;
    //   128: aload #4
    //   130: aload_0
    //   131: iconst_1
    //   132: invokevirtual bindService : (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   135: ifeq -> 152
    //   138: aload_0
    //   139: getfield mPendingChecks : Ljava/util/Queue;
    //   142: aload_2
    //   143: invokeinterface offer : (Ljava/lang/Object;)Z
    //   148: pop
    //   149: goto -> 204
    //   152: ldc 'LicenseChecker'
    //   154: ldc_w 'Could not bind to service.'
    //   157: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   160: pop
    //   161: aload_0
    //   162: aload_2
    //   163: invokespecial handleServiceConnectionError : (Lcom/google/android/vending/licensing/LicenseValidator;)V
    //   166: goto -> 204
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual printStackTrace : ()V
    //   174: goto -> 204
    //   177: astore_2
    //   178: aload_1
    //   179: bipush #6
    //   181: invokeinterface applicationError : (I)V
    //   186: goto -> 204
    //   189: aload_0
    //   190: getfield mPendingChecks : Ljava/util/Queue;
    //   193: aload_2
    //   194: invokeinterface offer : (Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload_0
    //   201: invokespecial runChecks : ()V
    //   204: aload_0
    //   205: monitorexit
    //   206: return
    //   207: astore_1
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	207	finally
    //   35	90	207	finally
    //   90	149	177	java/lang/SecurityException
    //   90	149	169	com/google/android/vending/licensing/util/Base64DecoderException
    //   90	149	207	finally
    //   152	166	177	java/lang/SecurityException
    //   152	166	169	com/google/android/vending/licensing/util/Base64DecoderException
    //   152	166	207	finally
    //   170	174	207	finally
    //   178	186	207	finally
    //   189	204	207	finally
  }
  
  public void onDestroy() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial cleanupService : ()V
    //   6: aload_0
    //   7: getfield mHandler : Landroid/os/Handler;
    //   10: invokevirtual getLooper : ()Landroid/os/Looper;
    //   13: invokevirtual quit : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokestatic asInterface : (Landroid/os/IBinder;)Lcom/google/android/vending/licensing/ILicensingService;
    //   7: putfield mService : Lcom/google/android/vending/licensing/ILicensingService;
    //   10: aload_0
    //   11: invokespecial runChecks : ()V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LicenseChecker'
    //   4: ldc_w 'Service unexpectedly disconnected.'
    //   7: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: aload_0
    //   12: aconst_null
    //   13: putfield mService : Lcom/google/android/vending/licensing/ILicensingService;
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
  
  private class ResultListener extends ILicenseResultListener.Stub {
    private static final int ERROR_CONTACTING_SERVER = 257;
    
    private static final int ERROR_INVALID_PACKAGE_NAME = 258;
    
    private static final int ERROR_NON_MATCHING_UID = 259;
    
    private Runnable mOnTimeout;
    
    private final LicenseValidator mValidator;
    
    public ResultListener(LicenseValidator param1LicenseValidator) {
      this.mValidator = param1LicenseValidator;
      this.mOnTimeout = new Runnable() {
          public void run() {
            Log.i("LicenseChecker", "Check timed out.");
            LicenseChecker.this.handleServiceConnectionError(LicenseChecker.ResultListener.this.mValidator);
            LicenseChecker.this.finishCheck(LicenseChecker.ResultListener.this.mValidator);
          }
        };
      startTimeout();
    }
    
    private void clearTimeout() {
      Log.i("LicenseChecker", "Clearing timeout.");
      LicenseChecker.this.mHandler.removeCallbacks(this.mOnTimeout);
    }
    
    private void startTimeout() {
      Log.i("LicenseChecker", "Start monitoring timeout.");
      LicenseChecker.this.mHandler.postDelayed(this.mOnTimeout, 10000L);
    }
    
    public void verifyLicense(final int responseCode, final String signedData, final String signature) {
      LicenseChecker.this.mHandler.post(new Runnable() {
            public void run() {
              Log.i("LicenseChecker", "Received response.");
              if (LicenseChecker.this.mChecksInProgress.contains(LicenseChecker.ResultListener.this.mValidator)) {
                LicenseChecker.ResultListener.this.clearTimeout();
                LicenseChecker.ResultListener.this.mValidator.verify(LicenseChecker.this.mPublicKey, responseCode, signedData, signature);
                LicenseChecker.this.finishCheck(LicenseChecker.ResultListener.this.mValidator);
              } 
            }
          });
    }
  }
  
  class null implements Runnable {
    public void run() {
      Log.i("LicenseChecker", "Check timed out.");
      LicenseChecker.this.handleServiceConnectionError(this.this$1.mValidator);
      LicenseChecker.this.finishCheck(this.this$1.mValidator);
    }
  }
  
  class null implements Runnable {
    public void run() {
      Log.i("LicenseChecker", "Received response.");
      if (LicenseChecker.this.mChecksInProgress.contains(this.this$1.mValidator)) {
        this.this$1.clearTimeout();
        this.this$1.mValidator.verify(LicenseChecker.this.mPublicKey, responseCode, signedData, signature);
        LicenseChecker.this.finishCheck(this.this$1.mValidator);
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensing\LicenseChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */