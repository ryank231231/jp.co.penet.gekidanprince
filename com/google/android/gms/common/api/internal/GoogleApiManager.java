package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class GoogleApiManager implements Handler.Callback {
  private static final Object lock;
  
  public static final Status zahw = new Status(4, "Sign-out occurred while this API call was in progress.");
  
  private static final Status zahx = new Status(4, "The user must be signed in to make this API call.");
  
  @GuardedBy("lock")
  private static GoogleApiManager zaib;
  
  private final Handler handler;
  
  private long zahy = 5000L;
  
  private long zahz = 120000L;
  
  private long zaia = 10000L;
  
  private final Context zaic;
  
  private final GoogleApiAvailability zaid;
  
  private final GoogleApiAvailabilityCache zaie;
  
  private final AtomicInteger zaif = new AtomicInteger(1);
  
  private final AtomicInteger zaig = new AtomicInteger(0);
  
  private final Map<zai<?>, zaa<?>> zaih = new ConcurrentHashMap<zai<?>, zaa<?>>(5, 0.75F, 1);
  
  @GuardedBy("lock")
  private zaae zaii = null;
  
  @GuardedBy("lock")
  private final Set<zai<?>> zaij = (Set<zai<?>>)new ArraySet();
  
  private final Set<zai<?>> zaik = (Set<zai<?>>)new ArraySet();
  
  static {
    lock = new Object();
  }
  
  @KeepForSdk
  private GoogleApiManager(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability) {
    this.zaic = paramContext;
    this.handler = (Handler)new zal(paramLooper, this);
    this.zaid = paramGoogleApiAvailability;
    this.zaie = new GoogleApiAvailabilityCache((GoogleApiAvailabilityLight)paramGoogleApiAvailability);
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(6));
  }
  
  @KeepForSdk
  public static void reportSignOut() {
    synchronized (lock) {
      if (zaib != null) {
        GoogleApiManager googleApiManager = zaib;
        googleApiManager.zaig.incrementAndGet();
        googleApiManager.handler.sendMessageAtFrontOfQueue(googleApiManager.handler.obtainMessage(10));
      } 
      return;
    } 
  }
  
  public static GoogleApiManager zab(Context paramContext) {
    synchronized (lock) {
      if (zaib == null) {
        HandlerThread handlerThread = new HandlerThread();
        this("GoogleApiHandler", 9);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        GoogleApiManager googleApiManager = new GoogleApiManager();
        this(paramContext.getApplicationContext(), looper, GoogleApiAvailability.getInstance());
        zaib = googleApiManager;
      } 
      return zaib;
    } 
  }
  
  @WorkerThread
  private final void zab(GoogleApi<?> paramGoogleApi) {
    zai<?> zai = paramGoogleApi.zak();
    zaa<?> zaa1 = this.zaih.get(zai);
    zaa<?> zaa2 = zaa1;
    if (zaa1 == null) {
      zaa2 = new zaa(this, paramGoogleApi);
      this.zaih.put(zai, zaa2);
    } 
    if (zaa2.requiresSignIn())
      this.zaik.add(zai); 
    zaa2.connect();
  }
  
  public static GoogleApiManager zabc() {
    synchronized (lock) {
      Preconditions.checkNotNull(zaib, "Must guarantee manager is non-null before using getInstance");
      return zaib;
    } 
  }
  
  @WorkerThread
  public boolean handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: istore_2
    //   5: ldc2_w 300000
    //   8: lstore_3
    //   9: iload_2
    //   10: tableswitch default -> 88, 1 -> 1100, 2 -> 952, 3 -> 904, 4 -> 783, 5 -> 557, 6 -> 491, 7 -> 477, 8 -> 783, 9 -> 439, 10 -> 377, 11 -> 339, 12 -> 300, 13 -> 783, 14 -> 223, 15 -> 176, 16 -> 129
    //   88: aload_1
    //   89: getfield what : I
    //   92: istore_2
    //   93: new java/lang/StringBuilder
    //   96: dup
    //   97: bipush #31
    //   99: invokespecial <init> : (I)V
    //   102: astore_1
    //   103: aload_1
    //   104: ldc 'Unknown message id: '
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: iload_2
    //   112: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc_w 'GoogleApiManager'
    //   119: aload_1
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   126: pop
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_1
    //   130: getfield obj : Ljava/lang/Object;
    //   133: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zab
    //   136: astore_1
    //   137: aload_0
    //   138: getfield zaih : Ljava/util/Map;
    //   141: aload_1
    //   142: invokestatic zac : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zab;)Lcom/google/android/gms/common/api/internal/zai;
    //   145: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   150: ifeq -> 1195
    //   153: aload_0
    //   154: getfield zaih : Ljava/util/Map;
    //   157: aload_1
    //   158: invokestatic zac : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zab;)Lcom/google/android/gms/common/api/internal/zai;
    //   161: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   166: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   169: aload_1
    //   170: invokestatic zab : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;Lcom/google/android/gms/common/api/internal/GoogleApiManager$zab;)V
    //   173: goto -> 1195
    //   176: aload_1
    //   177: getfield obj : Ljava/lang/Object;
    //   180: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zab
    //   183: astore_1
    //   184: aload_0
    //   185: getfield zaih : Ljava/util/Map;
    //   188: aload_1
    //   189: invokestatic zac : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zab;)Lcom/google/android/gms/common/api/internal/zai;
    //   192: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   197: ifeq -> 1195
    //   200: aload_0
    //   201: getfield zaih : Ljava/util/Map;
    //   204: aload_1
    //   205: invokestatic zac : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zab;)Lcom/google/android/gms/common/api/internal/zai;
    //   208: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   213: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   216: aload_1
    //   217: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;Lcom/google/android/gms/common/api/internal/GoogleApiManager$zab;)V
    //   220: goto -> 1195
    //   223: aload_1
    //   224: getfield obj : Ljava/lang/Object;
    //   227: checkcast com/google/android/gms/common/api/internal/zaaf
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual zak : ()Lcom/google/android/gms/common/api/internal/zai;
    //   235: astore #5
    //   237: aload_0
    //   238: getfield zaih : Ljava/util/Map;
    //   241: aload #5
    //   243: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   248: ifne -> 265
    //   251: aload_1
    //   252: invokevirtual zaal : ()Lcom/google/android/gms/tasks/TaskCompletionSource;
    //   255: iconst_0
    //   256: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   259: invokevirtual setResult : (Ljava/lang/Object;)V
    //   262: goto -> 1195
    //   265: aload_0
    //   266: getfield zaih : Ljava/util/Map;
    //   269: aload #5
    //   271: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   276: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   279: iconst_0
    //   280: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;Z)Z
    //   283: istore #6
    //   285: aload_1
    //   286: invokevirtual zaal : ()Lcom/google/android/gms/tasks/TaskCompletionSource;
    //   289: iload #6
    //   291: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   294: invokevirtual setResult : (Ljava/lang/Object;)V
    //   297: goto -> 1195
    //   300: aload_0
    //   301: getfield zaih : Ljava/util/Map;
    //   304: aload_1
    //   305: getfield obj : Ljava/lang/Object;
    //   308: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   313: ifeq -> 1195
    //   316: aload_0
    //   317: getfield zaih : Ljava/util/Map;
    //   320: aload_1
    //   321: getfield obj : Ljava/lang/Object;
    //   324: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   329: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   332: invokevirtual zabp : ()Z
    //   335: pop
    //   336: goto -> 1195
    //   339: aload_0
    //   340: getfield zaih : Ljava/util/Map;
    //   343: aload_1
    //   344: getfield obj : Ljava/lang/Object;
    //   347: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   352: ifeq -> 1195
    //   355: aload_0
    //   356: getfield zaih : Ljava/util/Map;
    //   359: aload_1
    //   360: getfield obj : Ljava/lang/Object;
    //   363: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   368: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   371: invokevirtual zaav : ()V
    //   374: goto -> 1195
    //   377: aload_0
    //   378: getfield zaik : Ljava/util/Set;
    //   381: invokeinterface iterator : ()Ljava/util/Iterator;
    //   386: astore_1
    //   387: aload_1
    //   388: invokeinterface hasNext : ()Z
    //   393: ifeq -> 427
    //   396: aload_1
    //   397: invokeinterface next : ()Ljava/lang/Object;
    //   402: checkcast com/google/android/gms/common/api/internal/zai
    //   405: astore #5
    //   407: aload_0
    //   408: getfield zaih : Ljava/util/Map;
    //   411: aload #5
    //   413: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   418: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   421: invokevirtual zabj : ()V
    //   424: goto -> 387
    //   427: aload_0
    //   428: getfield zaik : Ljava/util/Set;
    //   431: invokeinterface clear : ()V
    //   436: goto -> 1195
    //   439: aload_0
    //   440: getfield zaih : Ljava/util/Map;
    //   443: aload_1
    //   444: getfield obj : Ljava/lang/Object;
    //   447: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   452: ifeq -> 1195
    //   455: aload_0
    //   456: getfield zaih : Ljava/util/Map;
    //   459: aload_1
    //   460: getfield obj : Ljava/lang/Object;
    //   463: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   468: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   471: invokevirtual resume : ()V
    //   474: goto -> 1195
    //   477: aload_0
    //   478: aload_1
    //   479: getfield obj : Ljava/lang/Object;
    //   482: checkcast com/google/android/gms/common/api/GoogleApi
    //   485: invokespecial zab : (Lcom/google/android/gms/common/api/GoogleApi;)V
    //   488: goto -> 1195
    //   491: invokestatic isAtLeastIceCreamSandwich : ()Z
    //   494: ifeq -> 1195
    //   497: aload_0
    //   498: getfield zaic : Landroid/content/Context;
    //   501: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   504: instanceof android/app/Application
    //   507: ifeq -> 1195
    //   510: aload_0
    //   511: getfield zaic : Landroid/content/Context;
    //   514: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   517: checkcast android/app/Application
    //   520: invokestatic initialize : (Landroid/app/Application;)V
    //   523: invokestatic getInstance : ()Lcom/google/android/gms/common/api/internal/BackgroundDetector;
    //   526: new com/google/android/gms/common/api/internal/zabi
    //   529: dup
    //   530: aload_0
    //   531: invokespecial <init> : (Lcom/google/android/gms/common/api/internal/GoogleApiManager;)V
    //   534: invokevirtual addListener : (Lcom/google/android/gms/common/api/internal/BackgroundDetector$BackgroundStateChangeListener;)V
    //   537: invokestatic getInstance : ()Lcom/google/android/gms/common/api/internal/BackgroundDetector;
    //   540: iconst_1
    //   541: invokevirtual readCurrentStateIfPossible : (Z)Z
    //   544: ifne -> 1195
    //   547: aload_0
    //   548: ldc2_w 300000
    //   551: putfield zaia : J
    //   554: goto -> 1195
    //   557: aload_1
    //   558: getfield arg1 : I
    //   561: istore_2
    //   562: aload_1
    //   563: getfield obj : Ljava/lang/Object;
    //   566: checkcast com/google/android/gms/common/ConnectionResult
    //   569: astore #5
    //   571: aload_0
    //   572: getfield zaih : Ljava/util/Map;
    //   575: invokeinterface values : ()Ljava/util/Collection;
    //   580: invokeinterface iterator : ()Ljava/util/Iterator;
    //   585: astore #7
    //   587: aload #7
    //   589: invokeinterface hasNext : ()Z
    //   594: ifeq -> 619
    //   597: aload #7
    //   599: invokeinterface next : ()Ljava/lang/Object;
    //   604: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   607: astore_1
    //   608: aload_1
    //   609: invokevirtual getInstanceId : ()I
    //   612: iload_2
    //   613: if_icmpne -> 587
    //   616: goto -> 621
    //   619: aconst_null
    //   620: astore_1
    //   621: aload_1
    //   622: ifnull -> 730
    //   625: aload_0
    //   626: getfield zaid : Lcom/google/android/gms/common/GoogleApiAvailability;
    //   629: aload #5
    //   631: invokevirtual getErrorCode : ()I
    //   634: invokevirtual getErrorString : (I)Ljava/lang/String;
    //   637: astore #7
    //   639: aload #5
    //   641: invokevirtual getErrorMessage : ()Ljava/lang/String;
    //   644: astore #5
    //   646: new java/lang/StringBuilder
    //   649: dup
    //   650: aload #7
    //   652: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   655: invokevirtual length : ()I
    //   658: bipush #69
    //   660: iadd
    //   661: aload #5
    //   663: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   666: invokevirtual length : ()I
    //   669: iadd
    //   670: invokespecial <init> : (I)V
    //   673: astore #8
    //   675: aload #8
    //   677: ldc_w 'Error resolution was canceled by the user, original error message: '
    //   680: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload #8
    //   686: aload #7
    //   688: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload #8
    //   694: ldc_w ': '
    //   697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload #8
    //   703: aload #5
    //   705: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload_1
    //   710: new com/google/android/gms/common/api/Status
    //   713: dup
    //   714: bipush #17
    //   716: aload #8
    //   718: invokevirtual toString : ()Ljava/lang/String;
    //   721: invokespecial <init> : (ILjava/lang/String;)V
    //   724: invokevirtual zac : (Lcom/google/android/gms/common/api/Status;)V
    //   727: goto -> 1195
    //   730: new java/lang/StringBuilder
    //   733: dup
    //   734: bipush #76
    //   736: invokespecial <init> : (I)V
    //   739: astore_1
    //   740: aload_1
    //   741: ldc_w 'Could not find API instance '
    //   744: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_1
    //   749: iload_2
    //   750: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_1
    //   755: ldc_w ' while trying to fail enqueued calls.'
    //   758: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: ldc_w 'GoogleApiManager'
    //   765: aload_1
    //   766: invokevirtual toString : ()Ljava/lang/String;
    //   769: new java/lang/Exception
    //   772: dup
    //   773: invokespecial <init> : ()V
    //   776: invokestatic wtf : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   779: pop
    //   780: goto -> 1195
    //   783: aload_1
    //   784: getfield obj : Ljava/lang/Object;
    //   787: checkcast com/google/android/gms/common/api/internal/zabv
    //   790: astore #7
    //   792: aload_0
    //   793: getfield zaih : Ljava/util/Map;
    //   796: aload #7
    //   798: getfield zajs : Lcom/google/android/gms/common/api/GoogleApi;
    //   801: invokevirtual zak : ()Lcom/google/android/gms/common/api/internal/zai;
    //   804: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   809: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   812: astore #5
    //   814: aload #5
    //   816: astore_1
    //   817: aload #5
    //   819: ifnonnull -> 852
    //   822: aload_0
    //   823: aload #7
    //   825: getfield zajs : Lcom/google/android/gms/common/api/GoogleApi;
    //   828: invokespecial zab : (Lcom/google/android/gms/common/api/GoogleApi;)V
    //   831: aload_0
    //   832: getfield zaih : Ljava/util/Map;
    //   835: aload #7
    //   837: getfield zajs : Lcom/google/android/gms/common/api/GoogleApi;
    //   840: invokevirtual zak : ()Lcom/google/android/gms/common/api/internal/zai;
    //   843: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   848: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   851: astore_1
    //   852: aload_1
    //   853: invokevirtual requiresSignIn : ()Z
    //   856: ifeq -> 892
    //   859: aload_0
    //   860: getfield zaig : Ljava/util/concurrent/atomic/AtomicInteger;
    //   863: invokevirtual get : ()I
    //   866: aload #7
    //   868: getfield zajr : I
    //   871: if_icmpeq -> 892
    //   874: aload #7
    //   876: getfield zajq : Lcom/google/android/gms/common/api/internal/zab;
    //   879: getstatic com/google/android/gms/common/api/internal/GoogleApiManager.zahw : Lcom/google/android/gms/common/api/Status;
    //   882: invokevirtual zaa : (Lcom/google/android/gms/common/api/Status;)V
    //   885: aload_1
    //   886: invokevirtual zabj : ()V
    //   889: goto -> 1195
    //   892: aload_1
    //   893: aload #7
    //   895: getfield zajq : Lcom/google/android/gms/common/api/internal/zab;
    //   898: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/zab;)V
    //   901: goto -> 1195
    //   904: aload_0
    //   905: getfield zaih : Ljava/util/Map;
    //   908: invokeinterface values : ()Ljava/util/Collection;
    //   913: invokeinterface iterator : ()Ljava/util/Iterator;
    //   918: astore #5
    //   920: aload #5
    //   922: invokeinterface hasNext : ()Z
    //   927: ifeq -> 1195
    //   930: aload #5
    //   932: invokeinterface next : ()Ljava/lang/Object;
    //   937: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   940: astore_1
    //   941: aload_1
    //   942: invokevirtual zabl : ()V
    //   945: aload_1
    //   946: invokevirtual connect : ()V
    //   949: goto -> 920
    //   952: aload_1
    //   953: getfield obj : Ljava/lang/Object;
    //   956: checkcast com/google/android/gms/common/api/internal/zak
    //   959: astore_1
    //   960: aload_1
    //   961: invokevirtual zap : ()Ljava/util/Set;
    //   964: invokeinterface iterator : ()Ljava/util/Iterator;
    //   969: astore #7
    //   971: aload #7
    //   973: invokeinterface hasNext : ()Z
    //   978: ifeq -> 1195
    //   981: aload #7
    //   983: invokeinterface next : ()Ljava/lang/Object;
    //   988: checkcast com/google/android/gms/common/api/internal/zai
    //   991: astore #5
    //   993: aload_0
    //   994: getfield zaih : Ljava/util/Map;
    //   997: aload #5
    //   999: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1004: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   1007: astore #8
    //   1009: aload #8
    //   1011: ifnonnull -> 1033
    //   1014: aload_1
    //   1015: aload #5
    //   1017: new com/google/android/gms/common/ConnectionResult
    //   1020: dup
    //   1021: bipush #13
    //   1023: invokespecial <init> : (I)V
    //   1026: aconst_null
    //   1027: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/zai;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1030: goto -> 1195
    //   1033: aload #8
    //   1035: invokevirtual isConnected : ()Z
    //   1038: ifeq -> 1063
    //   1041: aload_1
    //   1042: aload #5
    //   1044: getstatic com/google/android/gms/common/ConnectionResult.RESULT_SUCCESS : Lcom/google/android/gms/common/ConnectionResult;
    //   1047: aload #8
    //   1049: invokevirtual zaab : ()Lcom/google/android/gms/common/api/Api$Client;
    //   1052: invokeinterface getEndpointPackageName : ()Ljava/lang/String;
    //   1057: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/zai;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1060: goto -> 971
    //   1063: aload #8
    //   1065: invokevirtual zabm : ()Lcom/google/android/gms/common/ConnectionResult;
    //   1068: ifnull -> 1086
    //   1071: aload_1
    //   1072: aload #5
    //   1074: aload #8
    //   1076: invokevirtual zabm : ()Lcom/google/android/gms/common/ConnectionResult;
    //   1079: aconst_null
    //   1080: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/zai;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1083: goto -> 971
    //   1086: aload #8
    //   1088: aload_1
    //   1089: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/zak;)V
    //   1092: aload #8
    //   1094: invokevirtual connect : ()V
    //   1097: goto -> 971
    //   1100: aload_1
    //   1101: getfield obj : Ljava/lang/Object;
    //   1104: checkcast java/lang/Boolean
    //   1107: invokevirtual booleanValue : ()Z
    //   1110: ifeq -> 1117
    //   1113: ldc2_w 10000
    //   1116: lstore_3
    //   1117: aload_0
    //   1118: lload_3
    //   1119: putfield zaia : J
    //   1122: aload_0
    //   1123: getfield handler : Landroid/os/Handler;
    //   1126: bipush #12
    //   1128: invokevirtual removeMessages : (I)V
    //   1131: aload_0
    //   1132: getfield zaih : Ljava/util/Map;
    //   1135: invokeinterface keySet : ()Ljava/util/Set;
    //   1140: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1145: astore #5
    //   1147: aload #5
    //   1149: invokeinterface hasNext : ()Z
    //   1154: ifeq -> 1195
    //   1157: aload #5
    //   1159: invokeinterface next : ()Ljava/lang/Object;
    //   1164: checkcast com/google/android/gms/common/api/internal/zai
    //   1167: astore_1
    //   1168: aload_0
    //   1169: getfield handler : Landroid/os/Handler;
    //   1172: astore #7
    //   1174: aload #7
    //   1176: aload #7
    //   1178: bipush #12
    //   1180: aload_1
    //   1181: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   1184: aload_0
    //   1185: getfield zaia : J
    //   1188: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
    //   1191: pop
    //   1192: goto -> 1147
    //   1195: iconst_1
    //   1196: ireturn
  }
  
  final void maybeSignOut() {
    this.zaig.incrementAndGet();
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(10));
  }
  
  final PendingIntent zaa(zai<?> paramzai, int paramInt) {
    zaa zaa = this.zaih.get(paramzai);
    if (zaa == null)
      return null; 
    zad zad = zaa.zabq();
    return (zad == null) ? null : PendingIntent.getActivity(this.zaic, paramInt, zad.getSignInIntent(), 134217728);
  }
  
  public final <O extends Api.ApiOptions> Task<Boolean> zaa(@NonNull GoogleApi<O> paramGoogleApi, @NonNull ListenerHolder.ListenerKey<?> paramListenerKey) {
    TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource();
    zah zah = new zah(paramListenerKey, taskCompletionSource);
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(13, new zabv(zah, this.zaig.get(), paramGoogleApi)));
    return taskCompletionSource.getTask();
  }
  
  public final <O extends Api.ApiOptions> Task<Void> zaa(@NonNull GoogleApi<O> paramGoogleApi, @NonNull RegisterListenerMethod<Api.AnyClient, ?> paramRegisterListenerMethod, @NonNull UnregisterListenerMethod<Api.AnyClient, ?> paramUnregisterListenerMethod) {
    TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource();
    zaf zaf = new zaf(new zabw(paramRegisterListenerMethod, paramUnregisterListenerMethod), taskCompletionSource);
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(8, new zabv(zaf, this.zaig.get(), paramGoogleApi)));
    return taskCompletionSource.getTask();
  }
  
  public final Task<Map<zai<?>, String>> zaa(Iterable<? extends GoogleApi<?>> paramIterable) {
    zak zak = new zak(paramIterable);
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(2, zak));
    return zak.getTask();
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, int paramInt) {
    if (!zac(paramConnectionResult, paramInt)) {
      Handler handler = this.handler;
      handler.sendMessage(handler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    } 
  }
  
  public final void zaa(GoogleApi<?> paramGoogleApi) {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(7, paramGoogleApi));
  }
  
  public final <O extends Api.ApiOptions> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> paramApiMethodImpl) {
    zae<BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> zae = new zae<BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>>(paramInt, paramApiMethodImpl);
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(4, new zabv(zae, this.zaig.get(), paramGoogleApi)));
  }
  
  public final <O extends Api.ApiOptions, ResultT> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper) {
    zag<ResultT> zag = new zag<ResultT>(paramInt, paramTaskApiCall, paramTaskCompletionSource, paramStatusExceptionMapper);
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(4, new zabv(zag, this.zaig.get(), paramGoogleApi)));
  }
  
  public final void zaa(@NonNull zaae paramzaae) {
    synchronized (lock) {
      if (this.zaii != paramzaae) {
        this.zaii = paramzaae;
        this.zaij.clear();
      } 
      this.zaij.addAll((Collection<? extends zai<?>>)paramzaae.zaaj());
      return;
    } 
  }
  
  final void zab(@NonNull zaae paramzaae) {
    synchronized (lock) {
      if (this.zaii == paramzaae) {
        this.zaii = null;
        this.zaij.clear();
      } 
      return;
    } 
  }
  
  public final int zabd() {
    return this.zaif.getAndIncrement();
  }
  
  public final Task<Boolean> zac(GoogleApi<?> paramGoogleApi) {
    zaaf zaaf = new zaaf(paramGoogleApi.zak());
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(14, zaaf));
    return zaaf.zaal().getTask();
  }
  
  final boolean zac(ConnectionResult paramConnectionResult, int paramInt) {
    return this.zaid.zaa(this.zaic, paramConnectionResult, paramInt);
  }
  
  public final void zao() {
    Handler handler = this.handler;
    handler.sendMessage(handler.obtainMessage(3));
  }
  
  public final class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {
    private final zai<O> zafp;
    
    private final Queue<zab> zaim = new LinkedList<zab>();
    
    private final Api.Client zain;
    
    private final Api.AnyClient zaio;
    
    private final zaab zaip;
    
    private final Set<zak> zaiq = new HashSet<zak>();
    
    private final Map<ListenerHolder.ListenerKey<?>, zabw> zair = new HashMap<ListenerHolder.ListenerKey<?>, zabw>();
    
    private final int zais;
    
    private final zace zait;
    
    private boolean zaiu;
    
    private final List<GoogleApiManager.zab> zaiv = new ArrayList<GoogleApiManager.zab>();
    
    private ConnectionResult zaiw = null;
    
    @WorkerThread
    public zaa(GoogleApiManager this$0, GoogleApi<O> param1GoogleApi) {
      this.zain = param1GoogleApi.zaa(GoogleApiManager.zaa(this$0).getLooper(), this);
      Api.Client client = this.zain;
      if (client instanceof SimpleClientAdapter) {
        this.zaio = (Api.AnyClient)((SimpleClientAdapter)client).getClient();
      } else {
        this.zaio = (Api.AnyClient)client;
      } 
      this.zafp = param1GoogleApi.zak();
      this.zaip = new zaab();
      this.zais = param1GoogleApi.getInstanceId();
      if (this.zain.requiresSignIn()) {
        this.zait = param1GoogleApi.zaa(GoogleApiManager.zab(this$0), GoogleApiManager.zaa(this$0));
        return;
      } 
      this.zait = null;
    }
    
    @Nullable
    @WorkerThread
    private final Feature zaa(@Nullable Feature[] param1ArrayOfFeature) {
      if (param1ArrayOfFeature == null || param1ArrayOfFeature.length == 0)
        return null; 
      Feature[] arrayOfFeature1 = this.zain.getAvailableFeatures();
      boolean bool = false;
      Feature[] arrayOfFeature2 = arrayOfFeature1;
      if (arrayOfFeature1 == null)
        arrayOfFeature2 = new Feature[0]; 
      ArrayMap<String, Long> arrayMap = new ArrayMap(arrayOfFeature2.length);
      int i = arrayOfFeature2.length;
      byte b;
      for (b = 0; b < i; b++) {
        Feature feature = arrayOfFeature2[b];
        arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
      } 
      i = param1ArrayOfFeature.length;
      for (b = bool; b < i; b++) {
        Feature feature = param1ArrayOfFeature[b];
        if (!arrayMap.containsKey(feature.getName()) || ((Long)arrayMap.get(feature.getName())).longValue() < feature.getVersion())
          return feature; 
      } 
      return null;
    }
    
    @WorkerThread
    private final void zaa(GoogleApiManager.zab param1zab) {
      if (!this.zaiv.contains(param1zab))
        return; 
      if (!this.zaiu) {
        if (!this.zain.isConnected()) {
          connect();
          return;
        } 
        zabi();
      } 
    }
    
    @WorkerThread
    private final void zab(GoogleApiManager.zab param1zab) {
      if (this.zaiv.remove(param1zab)) {
        GoogleApiManager.zaa(this.zail).removeMessages(15, param1zab);
        GoogleApiManager.zaa(this.zail).removeMessages(16, param1zab);
        Feature feature = GoogleApiManager.zab.zad(param1zab);
        ArrayList<zab> arrayList1 = new ArrayList(this.zaim.size());
        for (zab zab1 : this.zaim) {
          if (zab1 instanceof zac) {
            Feature[] arrayOfFeature = ((zac)zab1).zab(this);
            if (arrayOfFeature != null && ArrayUtils.contains((Object[])arrayOfFeature, feature))
              arrayList1.add(zab1); 
          } 
        } 
        ArrayList<zab> arrayList2 = arrayList1;
        int i = arrayList2.size();
        byte b = 0;
        while (b < i) {
          arrayList1 = (ArrayList<zab>)arrayList2.get(b);
          b++;
          zab zab1 = (zab)arrayList1;
          this.zaim.remove(zab1);
          zab1.zaa((RuntimeException)new UnsupportedApiCallException(feature));
        } 
      } 
    }
    
    @WorkerThread
    private final boolean zab(zab param1zab) {
      if (!(param1zab instanceof zac)) {
        zac(param1zab);
        return true;
      } 
      zac zac = (zac)param1zab;
      Feature feature = zaa(zac.zab(this));
      if (feature == null) {
        zac(param1zab);
        return true;
      } 
      if (zac.zac(this)) {
        GoogleApiManager.zab zab1 = new GoogleApiManager.zab(this.zafp, feature, null);
        int i = this.zaiv.indexOf(zab1);
        if (i >= 0) {
          zab1 = this.zaiv.get(i);
          GoogleApiManager.zaa(this.zail).removeMessages(15, zab1);
          GoogleApiManager.zaa(this.zail).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zail), 15, zab1), GoogleApiManager.zac(this.zail));
        } else {
          this.zaiv.add(zab1);
          GoogleApiManager.zaa(this.zail).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zail), 15, zab1), GoogleApiManager.zac(this.zail));
          GoogleApiManager.zaa(this.zail).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zail), 16, zab1), GoogleApiManager.zad(this.zail));
          ConnectionResult connectionResult = new ConnectionResult(2, null);
          if (!zah(connectionResult))
            this.zail.zac(connectionResult, this.zais); 
        } 
      } else {
        zac.zaa((RuntimeException)new UnsupportedApiCallException(feature));
      } 
      return false;
    }
    
    @WorkerThread
    private final void zabg() {
      zabl();
      zai(ConnectionResult.RESULT_SUCCESS);
      zabn();
      Iterator<zabw> iterator = this.zair.values().iterator();
      while (iterator.hasNext()) {
        zabw zabw = iterator.next();
        if (zaa(zabw.zajw.getRequiredFeatures()) != null) {
          iterator.remove();
          continue;
        } 
        try {
          RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod = zabw.zajw;
          Api.AnyClient anyClient = this.zaio;
          TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource();
          this();
          registerListenerMethod.registerListener(anyClient, taskCompletionSource);
        } catch (DeadObjectException deadObjectException) {
          onConnectionSuspended(1);
          this.zain.disconnect();
          break;
        } catch (RemoteException remoteException) {
          deadObjectException.remove();
        } 
      } 
      zabi();
      zabo();
    }
    
    @WorkerThread
    private final void zabh() {
      zabl();
      this.zaiu = true;
      this.zaip.zaai();
      GoogleApiManager.zaa(this.zail).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zail), 9, this.zafp), GoogleApiManager.zac(this.zail));
      GoogleApiManager.zaa(this.zail).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zail), 11, this.zafp), GoogleApiManager.zad(this.zail));
      GoogleApiManager.zae(this.zail).flush();
    }
    
    @WorkerThread
    private final void zabi() {
      ArrayList<zab> arrayList = new ArrayList<zab>(this.zaim);
      int i = arrayList.size();
      int j = 0;
      while (j < i) {
        zab zab = (zab)arrayList.get(j);
        int k = j + 1;
        zab = zab;
        if (this.zain.isConnected()) {
          j = k;
          if (zab(zab)) {
            this.zaim.remove(zab);
            j = k;
          } 
        } 
      } 
    }
    
    @WorkerThread
    private final void zabn() {
      if (this.zaiu) {
        GoogleApiManager.zaa(this.zail).removeMessages(11, this.zafp);
        GoogleApiManager.zaa(this.zail).removeMessages(9, this.zafp);
        this.zaiu = false;
      } 
    }
    
    private final void zabo() {
      GoogleApiManager.zaa(this.zail).removeMessages(12, this.zafp);
      GoogleApiManager.zaa(this.zail).sendMessageDelayed(GoogleApiManager.zaa(this.zail).obtainMessage(12, this.zafp), GoogleApiManager.zai(this.zail));
    }
    
    @WorkerThread
    private final void zac(zab param1zab) {
      param1zab.zaa(this.zaip, requiresSignIn());
      try {
        param1zab.zaa(this);
        return;
      } catch (DeadObjectException deadObjectException) {
        onConnectionSuspended(1);
        this.zain.disconnect();
        return;
      } 
    }
    
    @WorkerThread
    private final boolean zac(boolean param1Boolean) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      if (this.zain.isConnected() && this.zair.size() == 0) {
        if (this.zaip.zaag()) {
          if (param1Boolean)
            zabo(); 
          return false;
        } 
        this.zain.disconnect();
        return true;
      } 
      return false;
    }
    
    @WorkerThread
    private final boolean zah(@NonNull ConnectionResult param1ConnectionResult) {
      synchronized (GoogleApiManager.zabe()) {
        if (GoogleApiManager.zaf(this.zail) != null && GoogleApiManager.zag(this.zail).contains(this.zafp)) {
          GoogleApiManager.zaf(this.zail).zab(param1ConnectionResult, this.zais);
          return true;
        } 
        return false;
      } 
    }
    
    @WorkerThread
    private final void zai(ConnectionResult param1ConnectionResult) {
      for (zak zak : this.zaiq) {
        String str = null;
        if (Objects.equal(param1ConnectionResult, ConnectionResult.RESULT_SUCCESS))
          str = this.zain.getEndpointPackageName(); 
        zak.zaa(this.zafp, param1ConnectionResult, str);
      } 
      this.zaiq.clear();
    }
    
    @WorkerThread
    public final void connect() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      if (this.zain.isConnected() || this.zain.isConnecting())
        return; 
      int i = GoogleApiManager.zae(this.zail).getClientAvailability(GoogleApiManager.zab(this.zail), this.zain);
      if (i != 0) {
        onConnectionFailed(new ConnectionResult(i, null));
        return;
      } 
      GoogleApiManager.zac zac = new GoogleApiManager.zac(this.zail, this.zain, this.zafp);
      if (this.zain.requiresSignIn())
        this.zait.zaa(zac); 
      this.zain.connect(zac);
    }
    
    public final int getInstanceId() {
      return this.zais;
    }
    
    final boolean isConnected() {
      return this.zain.isConnected();
    }
    
    public final void onConnected(@Nullable Bundle param1Bundle) {
      if (Looper.myLooper() == GoogleApiManager.zaa(this.zail).getLooper()) {
        zabg();
        return;
      } 
      GoogleApiManager.zaa(this.zail).post(new zabj(this));
    }
    
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult param1ConnectionResult) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      zace zace1 = this.zait;
      if (zace1 != null)
        zace1.zabs(); 
      zabl();
      GoogleApiManager.zae(this.zail).flush();
      zai(param1ConnectionResult);
      if (param1ConnectionResult.getErrorCode() == 4) {
        zac(GoogleApiManager.zabf());
        return;
      } 
      if (this.zaim.isEmpty()) {
        this.zaiw = param1ConnectionResult;
        return;
      } 
      if (zah(param1ConnectionResult))
        return; 
      if (!this.zail.zac(param1ConnectionResult, this.zais)) {
        if (param1ConnectionResult.getErrorCode() == 18)
          this.zaiu = true; 
        if (this.zaiu) {
          GoogleApiManager.zaa(this.zail).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zail), 9, this.zafp), GoogleApiManager.zac(this.zail));
          return;
        } 
        String str = this.zafp.zan();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 38);
        stringBuilder.append("API: ");
        stringBuilder.append(str);
        stringBuilder.append(" is not available on this device.");
        zac(new Status(17, stringBuilder.toString()));
      } 
    }
    
    public final void onConnectionSuspended(int param1Int) {
      if (Looper.myLooper() == GoogleApiManager.zaa(this.zail).getLooper()) {
        zabh();
        return;
      } 
      GoogleApiManager.zaa(this.zail).post(new zabk(this));
    }
    
    public final boolean requiresSignIn() {
      return this.zain.requiresSignIn();
    }
    
    @WorkerThread
    public final void resume() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      if (this.zaiu)
        connect(); 
    }
    
    public final void zaa(ConnectionResult param1ConnectionResult, Api<?> param1Api, boolean param1Boolean) {
      if (Looper.myLooper() == GoogleApiManager.zaa(this.zail).getLooper()) {
        onConnectionFailed(param1ConnectionResult);
        return;
      } 
      GoogleApiManager.zaa(this.zail).post(new zabl(this, param1ConnectionResult));
    }
    
    @WorkerThread
    public final void zaa(zab param1zab) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      if (this.zain.isConnected()) {
        if (zab(param1zab)) {
          zabo();
          return;
        } 
        this.zaim.add(param1zab);
        return;
      } 
      this.zaim.add(param1zab);
      ConnectionResult connectionResult = this.zaiw;
      if (connectionResult != null && connectionResult.hasResolution()) {
        onConnectionFailed(this.zaiw);
        return;
      } 
      connect();
    }
    
    @WorkerThread
    public final void zaa(zak param1zak) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      this.zaiq.add(param1zak);
    }
    
    public final Api.Client zaab() {
      return this.zain;
    }
    
    @WorkerThread
    public final void zaav() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      if (this.zaiu) {
        Status status;
        zabn();
        if (GoogleApiManager.zah(this.zail).isGooglePlayServicesAvailable(GoogleApiManager.zab(this.zail)) == 18) {
          status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
        } else {
          status = new Status(8, "API failed to connect while resuming due to an unknown error.");
        } 
        zac(status);
        this.zain.disconnect();
      } 
    }
    
    @WorkerThread
    public final void zabj() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      zac(GoogleApiManager.zahw);
      this.zaip.zaah();
      ListenerHolder.ListenerKey[] arrayOfListenerKey = (ListenerHolder.ListenerKey[])this.zair.keySet().toArray((Object[])new ListenerHolder.ListenerKey[this.zair.size()]);
      int i = arrayOfListenerKey.length;
      for (byte b = 0; b < i; b++)
        zaa(new zah(arrayOfListenerKey[b], new TaskCompletionSource())); 
      zai(new ConnectionResult(4));
      if (this.zain.isConnected())
        this.zain.onUserSignOut(new zabm(this)); 
    }
    
    public final Map<ListenerHolder.ListenerKey<?>, zabw> zabk() {
      return this.zair;
    }
    
    @WorkerThread
    public final void zabl() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      this.zaiw = null;
    }
    
    @WorkerThread
    public final ConnectionResult zabm() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      return this.zaiw;
    }
    
    @WorkerThread
    public final boolean zabp() {
      return zac(true);
    }
    
    final zad zabq() {
      zace zace1 = this.zait;
      return (zace1 == null) ? null : zace1.zabq();
    }
    
    @WorkerThread
    public final void zac(Status param1Status) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      Iterator<zab> iterator = this.zaim.iterator();
      while (iterator.hasNext())
        ((zab)iterator.next()).zaa(param1Status); 
      this.zaim.clear();
    }
    
    @WorkerThread
    public final void zag(@NonNull ConnectionResult param1ConnectionResult) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zail));
      this.zain.disconnect();
      onConnectionFailed(param1ConnectionResult);
    }
  }
  
  private static final class zab {
    private final zai<?> zaja;
    
    private final Feature zajb;
    
    private zab(zai<?> param1zai, Feature param1Feature) {
      this.zaja = param1zai;
      this.zajb = param1Feature;
    }
    
    public final boolean equals(Object param1Object) {
      if (param1Object != null && param1Object instanceof zab) {
        param1Object = param1Object;
        return (Objects.equal(this.zaja, ((zab)param1Object).zaja) && Objects.equal(this.zajb, ((zab)param1Object).zajb));
      } 
      return false;
    }
    
    public final int hashCode() {
      return Objects.hashCode(new Object[] { this.zaja, this.zajb });
    }
    
    public final String toString() {
      return Objects.toStringHelper(this).add("key", this.zaja).add("feature", this.zajb).toString();
    }
  }
  
  private final class zac implements zach, BaseGmsClient.ConnectionProgressReportCallbacks {
    private final zai<?> zafp;
    
    private final Api.Client zain;
    
    private IAccountAccessor zajc = null;
    
    private Set<Scope> zajd = null;
    
    private boolean zaje = false;
    
    public zac(GoogleApiManager this$0, Api.Client param1Client, zai<?> param1zai) {
      this.zain = param1Client;
      this.zafp = param1zai;
    }
    
    @WorkerThread
    private final void zabr() {
      if (this.zaje) {
        IAccountAccessor iAccountAccessor = this.zajc;
        if (iAccountAccessor != null)
          this.zain.getRemoteService(iAccountAccessor, this.zajd); 
      } 
    }
    
    public final void onReportServiceBinding(@NonNull ConnectionResult param1ConnectionResult) {
      GoogleApiManager.zaa(this.zail).post(new zabo(this, param1ConnectionResult));
    }
    
    @WorkerThread
    public final void zaa(IAccountAccessor param1IAccountAccessor, Set<Scope> param1Set) {
      if (param1IAccountAccessor == null || param1Set == null) {
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zag(new ConnectionResult(4));
        return;
      } 
      this.zajc = param1IAccountAccessor;
      this.zajd = param1Set;
      zabr();
    }
    
    @WorkerThread
    public final void zag(ConnectionResult param1ConnectionResult) {
      ((GoogleApiManager.zaa)GoogleApiManager.zaj(this.zail).get(this.zafp)).zag(param1ConnectionResult);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\GoogleApiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */