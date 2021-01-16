package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class zzav {
  private static zzav zzcy;
  
  @GuardedBy("serviceClassNames")
  private final SimpleArrayMap<String, String> zzcz = new SimpleArrayMap();
  
  private Boolean zzda = null;
  
  private Boolean zzdb = null;
  
  final Queue<Intent> zzdc = new ArrayDeque<Intent>();
  
  private final Queue<Intent> zzdd = new ArrayDeque<Intent>();
  
  public static PendingIntent zza(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2) {
    return PendingIntent.getBroadcast(paramContext, paramInt1, zza(paramContext, "com.google.firebase.MESSAGING_EVENT", paramIntent), 1073741824);
  }
  
  private static Intent zza(Context paramContext, String paramString, Intent paramIntent) {
    Intent intent = new Intent(paramContext, FirebaseInstanceIdReceiver.class);
    intent.setAction(paramString);
    intent.putExtra("wrapped_intent", (Parcelable)paramIntent);
    return intent;
  }
  
  public static zzav zzai() {
    // Byte code:
    //   0: ldc com/google/firebase/iid/zzav
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/zzav.zzcy : Lcom/google/firebase/iid/zzav;
    //   6: ifnonnull -> 21
    //   9: new com/google/firebase/iid/zzav
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/google/firebase/iid/zzav.zzcy : Lcom/google/firebase/iid/zzav;
    //   21: getstatic com/google/firebase/iid/zzav.zzcy : Lcom/google/firebase/iid/zzav;
    //   24: astore_0
    //   25: ldc com/google/firebase/iid/zzav
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/google/firebase/iid/zzav
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public static void zzb(Context paramContext, Intent paramIntent) {
    paramContext.sendBroadcast(zza(paramContext, "com.google.firebase.INSTANCE_ID_EVENT", paramIntent));
  }
  
  public static void zzc(Context paramContext, Intent paramIntent) {
    paramContext.sendBroadcast(zza(paramContext, "com.google.firebase.MESSAGING_EVENT", paramIntent));
  }
  
  private final int zzd(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzcz : Landroid/support/v4/util/SimpleArrayMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield zzcz : Landroid/support/v4/util/SimpleArrayMap;
    //   11: aload_2
    //   12: invokevirtual getAction : ()Ljava/lang/String;
    //   15: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast java/lang/String
    //   21: astore #4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload #4
    //   27: astore_3
    //   28: aload #4
    //   30: ifnonnull -> 282
    //   33: aload_1
    //   34: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokevirtual resolveService : (Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull -> 271
    //   47: aload_3
    //   48: getfield serviceInfo : Landroid/content/pm/ServiceInfo;
    //   51: ifnonnull -> 57
    //   54: goto -> 271
    //   57: aload_3
    //   58: getfield serviceInfo : Landroid/content/pm/ServiceInfo;
    //   61: astore #4
    //   63: aload_1
    //   64: invokevirtual getPackageName : ()Ljava/lang/String;
    //   67: aload #4
    //   69: getfield packageName : Ljava/lang/String;
    //   72: invokevirtual equals : (Ljava/lang/Object;)Z
    //   75: ifeq -> 185
    //   78: aload #4
    //   80: getfield name : Ljava/lang/String;
    //   83: ifnonnull -> 89
    //   86: goto -> 185
    //   89: aload #4
    //   91: getfield name : Ljava/lang/String;
    //   94: astore #4
    //   96: aload #4
    //   98: astore_3
    //   99: aload #4
    //   101: ldc '.'
    //   103: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   106: ifeq -> 151
    //   109: aload_1
    //   110: invokevirtual getPackageName : ()Ljava/lang/String;
    //   113: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   116: astore_3
    //   117: aload #4
    //   119: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   122: astore #4
    //   124: aload #4
    //   126: invokevirtual length : ()I
    //   129: ifeq -> 142
    //   132: aload_3
    //   133: aload #4
    //   135: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   138: astore_3
    //   139: goto -> 151
    //   142: new java/lang/String
    //   145: dup
    //   146: aload_3
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: astore_3
    //   151: aload_0
    //   152: getfield zzcz : Landroid/support/v4/util/SimpleArrayMap;
    //   155: astore #4
    //   157: aload #4
    //   159: monitorenter
    //   160: aload_0
    //   161: getfield zzcz : Landroid/support/v4/util/SimpleArrayMap;
    //   164: aload_2
    //   165: invokevirtual getAction : ()Ljava/lang/String;
    //   168: aload_3
    //   169: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload #4
    //   175: monitorexit
    //   176: goto -> 282
    //   179: astore_1
    //   180: aload #4
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    //   185: aload #4
    //   187: getfield packageName : Ljava/lang/String;
    //   190: astore_3
    //   191: aload #4
    //   193: getfield name : Ljava/lang/String;
    //   196: astore #5
    //   198: new java/lang/StringBuilder
    //   201: dup
    //   202: aload_3
    //   203: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokevirtual length : ()I
    //   209: bipush #94
    //   211: iadd
    //   212: aload #5
    //   214: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   217: invokevirtual length : ()I
    //   220: iadd
    //   221: invokespecial <init> : (I)V
    //   224: astore #4
    //   226: aload #4
    //   228: ldc 'Error resolving target intent service, skipping classname enforcement. Resolved service was: '
    //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload #4
    //   236: aload_3
    //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload #4
    //   243: ldc '/'
    //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload #4
    //   251: aload #5
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 'FirebaseInstanceId'
    //   259: aload #4
    //   261: invokevirtual toString : ()Ljava/lang/String;
    //   264: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   267: pop
    //   268: goto -> 346
    //   271: ldc 'FirebaseInstanceId'
    //   273: ldc 'Failed to resolve target intent service, skipping classname enforcement'
    //   275: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   278: pop
    //   279: goto -> 346
    //   282: ldc 'FirebaseInstanceId'
    //   284: iconst_3
    //   285: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   288: ifeq -> 336
    //   291: aload_3
    //   292: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   295: astore #4
    //   297: aload #4
    //   299: invokevirtual length : ()I
    //   302: ifeq -> 317
    //   305: ldc 'Restricting intent to a specific service: '
    //   307: aload #4
    //   309: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   312: astore #4
    //   314: goto -> 328
    //   317: new java/lang/String
    //   320: dup
    //   321: ldc 'Restricting intent to a specific service: '
    //   323: invokespecial <init> : (Ljava/lang/String;)V
    //   326: astore #4
    //   328: ldc 'FirebaseInstanceId'
    //   330: aload #4
    //   332: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   335: pop
    //   336: aload_2
    //   337: aload_1
    //   338: invokevirtual getPackageName : ()Ljava/lang/String;
    //   341: aload_3
    //   342: invokevirtual setClassName : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   345: pop
    //   346: aload_0
    //   347: aload_1
    //   348: invokevirtual zzd : (Landroid/content/Context;)Z
    //   351: ifeq -> 363
    //   354: aload_1
    //   355: aload_2
    //   356: invokestatic startWakefulService : (Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;
    //   359: astore_1
    //   360: goto -> 377
    //   363: aload_1
    //   364: aload_2
    //   365: invokevirtual startService : (Landroid/content/Intent;)Landroid/content/ComponentName;
    //   368: astore_1
    //   369: ldc 'FirebaseInstanceId'
    //   371: ldc 'Missing wake lock permission, service start may be delayed'
    //   373: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   376: pop
    //   377: aload_1
    //   378: ifnonnull -> 393
    //   381: ldc 'FirebaseInstanceId'
    //   383: ldc 'Error while delivering the message: ServiceIntent not found.'
    //   385: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   388: pop
    //   389: sipush #404
    //   392: ireturn
    //   393: iconst_m1
    //   394: ireturn
    //   395: astore_1
    //   396: aload_1
    //   397: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   400: astore_2
    //   401: new java/lang/StringBuilder
    //   404: dup
    //   405: aload_2
    //   406: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   409: invokevirtual length : ()I
    //   412: bipush #45
    //   414: iadd
    //   415: invokespecial <init> : (I)V
    //   418: astore_1
    //   419: aload_1
    //   420: ldc 'Failed to start service while in background: '
    //   422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_1
    //   427: aload_2
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 'FirebaseInstanceId'
    //   434: aload_1
    //   435: invokevirtual toString : ()Ljava/lang/String;
    //   438: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   441: pop
    //   442: sipush #402
    //   445: ireturn
    //   446: astore_1
    //   447: ldc 'FirebaseInstanceId'
    //   449: ldc 'Error while delivering the message to the serviceIntent'
    //   451: aload_1
    //   452: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   455: pop
    //   456: sipush #401
    //   459: ireturn
    //   460: astore_1
    //   461: aload_3
    //   462: monitorexit
    //   463: aload_1
    //   464: athrow
    // Exception table:
    //   from	to	target	type
    //   7	25	460	finally
    //   160	176	179	finally
    //   180	183	179	finally
    //   346	360	446	java/lang/SecurityException
    //   346	360	395	java/lang/IllegalStateException
    //   363	377	446	java/lang/SecurityException
    //   363	377	395	java/lang/IllegalStateException
    //   381	389	446	java/lang/SecurityException
    //   381	389	395	java/lang/IllegalStateException
    //   461	463	460	finally
  }
  
  public final Intent zzaj() {
    return this.zzdd.poll();
  }
  
  public final int zzb(Context paramContext, String paramString, Intent paramIntent) {
    Intent intent;
    if (Log.isLoggable("FirebaseInstanceId", 3)) {
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0) {
        str1 = "Starting service: ".concat(str1);
      } else {
        str1 = new String("Starting service: ");
      } 
      Log.d("FirebaseInstanceId", str1);
    } 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -842411455) {
      if (i == 41532704 && paramString.equals("com.google.firebase.MESSAGING_EVENT"))
        b = 1; 
    } else if (paramString.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
      b = 0;
    } 
    switch (b) {
      default:
        str = String.valueOf(paramString);
        if (str.length() != 0) {
          str = "Unknown service action: ".concat(str);
          Log.w("FirebaseInstanceId", str);
          return 500;
        } 
        break;
      case 1:
        this.zzdd.offer(paramIntent);
        intent = new Intent(paramString);
        intent.setPackage(str.getPackageName());
        return zzd((Context)str, intent);
      case 0:
        this.zzdc.offer(paramIntent);
        intent = new Intent((String)intent);
        intent.setPackage(str.getPackageName());
        return zzd((Context)str, intent);
    } 
    String str = new String("Unknown service action: ");
    Log.w("FirebaseInstanceId", str);
    return 500;
  }
  
  final boolean zzd(Context paramContext) {
    if (this.zzda == null) {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.zzda = Boolean.valueOf(bool);
    } 
    if (!this.zzda.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest"); 
    return this.zzda.booleanValue();
  }
  
  final boolean zze(Context paramContext) {
    if (this.zzdb == null) {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.zzdb = Boolean.valueOf(bool);
    } 
    if (!this.zzda.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest"); 
    return this.zzdb.booleanValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */