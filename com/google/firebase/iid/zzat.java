package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

final class zzat {
  private static int zzcg;
  
  private static PendingIntent zzcs;
  
  private final zzan zzap;
  
  @GuardedBy("responseCallbacks")
  private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzct = new SimpleArrayMap();
  
  private Messenger zzcu;
  
  private Messenger zzcv;
  
  private zzl zzcw;
  
  private final Context zzz;
  
  public zzat(Context paramContext, zzan paramzzan) {
    this.zzz = paramContext;
    this.zzap = paramzzan;
    this.zzcu = new Messenger((Handler)new zzau(this, Looper.getMainLooper()));
  }
  
  private static void zza(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: ldc com/google/firebase/iid/zzat
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/zzat.zzcs : Landroid/app/PendingIntent;
    //   6: ifnonnull -> 34
    //   9: new android/content/Intent
    //   12: astore_2
    //   13: aload_2
    //   14: invokespecial <init> : ()V
    //   17: aload_2
    //   18: ldc 'com.google.example.invalidpackage'
    //   20: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   23: pop
    //   24: aload_0
    //   25: iconst_0
    //   26: aload_2
    //   27: iconst_0
    //   28: invokestatic getBroadcast : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   31: putstatic com/google/firebase/iid/zzat.zzcs : Landroid/app/PendingIntent;
    //   34: aload_1
    //   35: ldc 'app'
    //   37: getstatic com/google/firebase/iid/zzat.zzcs : Landroid/app/PendingIntent;
    //   40: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   43: pop
    //   44: ldc com/google/firebase/iid/zzat
    //   46: monitorexit
    //   47: return
    //   48: astore_0
    //   49: ldc com/google/firebase/iid/zzat
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   3	34	48	finally
    //   34	44	48	finally
  }
  
  private final void zza(String paramString, Bundle paramBundle) {
    synchronized (this.zzct) {
      TaskCompletionSource taskCompletionSource = (TaskCompletionSource)this.zzct.remove(paramString);
      if (taskCompletionSource == null) {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Missing callback for ".concat(paramString);
        } else {
          paramString = new String("Missing callback for ");
        } 
        Log.w("FirebaseInstanceId", paramString);
        return;
      } 
      taskCompletionSource.setResult(paramBundle);
      return;
    } 
  }
  
  private static String zzah() {
    // Byte code:
    //   0: ldc com/google/firebase/iid/zzat
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/zzat.zzcg : I
    //   6: istore_0
    //   7: iload_0
    //   8: iconst_1
    //   9: iadd
    //   10: putstatic com/google/firebase/iid/zzat.zzcg : I
    //   13: iload_0
    //   14: invokestatic toString : (I)Ljava/lang/String;
    //   17: astore_1
    //   18: ldc com/google/firebase/iid/zzat
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: astore_1
    //   24: ldc com/google/firebase/iid/zzat
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	23	finally
  }
  
  private final void zzb(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 565
    //   4: aload_1
    //   5: getfield obj : Ljava/lang/Object;
    //   8: instanceof android/content/Intent
    //   11: ifeq -> 565
    //   14: aload_1
    //   15: getfield obj : Ljava/lang/Object;
    //   18: checkcast android/content/Intent
    //   21: astore_2
    //   22: aload_2
    //   23: new com/google/firebase/iid/zzl$zza
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: invokevirtual setExtrasClassLoader : (Ljava/lang/ClassLoader;)V
    //   33: aload_2
    //   34: ldc 'google.messenger'
    //   36: invokevirtual hasExtra : (Ljava/lang/String;)Z
    //   39: ifeq -> 79
    //   42: aload_2
    //   43: ldc 'google.messenger'
    //   45: invokevirtual getParcelableExtra : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   48: astore_2
    //   49: aload_2
    //   50: instanceof com/google/firebase/iid/zzl
    //   53: ifeq -> 64
    //   56: aload_0
    //   57: aload_2
    //   58: checkcast com/google/firebase/iid/zzl
    //   61: putfield zzcw : Lcom/google/firebase/iid/zzl;
    //   64: aload_2
    //   65: instanceof android/os/Messenger
    //   68: ifeq -> 79
    //   71: aload_0
    //   72: aload_2
    //   73: checkcast android/os/Messenger
    //   76: putfield zzcv : Landroid/os/Messenger;
    //   79: aload_1
    //   80: getfield obj : Ljava/lang/Object;
    //   83: checkcast android/content/Intent
    //   86: astore_3
    //   87: aload_3
    //   88: invokevirtual getAction : ()Ljava/lang/String;
    //   91: astore_1
    //   92: ldc 'com.google.android.c2dm.intent.REGISTRATION'
    //   94: aload_1
    //   95: invokevirtual equals : (Ljava/lang/Object;)Z
    //   98: ifne -> 150
    //   101: ldc 'FirebaseInstanceId'
    //   103: iconst_3
    //   104: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   107: ifeq -> 149
    //   110: aload_1
    //   111: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual length : ()I
    //   119: ifeq -> 132
    //   122: ldc 'Unexpected response action: '
    //   124: aload_1
    //   125: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_1
    //   129: goto -> 142
    //   132: new java/lang/String
    //   135: dup
    //   136: ldc 'Unexpected response action: '
    //   138: invokespecial <init> : (Ljava/lang/String;)V
    //   141: astore_1
    //   142: ldc 'FirebaseInstanceId'
    //   144: aload_1
    //   145: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   148: pop
    //   149: return
    //   150: aload_3
    //   151: ldc 'registration_id'
    //   153: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_2
    //   157: aload_2
    //   158: astore_1
    //   159: aload_2
    //   160: ifnonnull -> 170
    //   163: aload_3
    //   164: ldc 'unregistered'
    //   166: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   169: astore_1
    //   170: aload_1
    //   171: ifnonnull -> 466
    //   174: aload_3
    //   175: ldc 'error'
    //   177: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   180: astore_2
    //   181: aload_2
    //   182: ifnonnull -> 237
    //   185: aload_3
    //   186: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   189: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   192: astore_1
    //   193: new java/lang/StringBuilder
    //   196: dup
    //   197: aload_1
    //   198: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   201: invokevirtual length : ()I
    //   204: bipush #49
    //   206: iadd
    //   207: invokespecial <init> : (I)V
    //   210: astore_2
    //   211: aload_2
    //   212: ldc 'Unexpected response, no error or registration id '
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_2
    //   219: aload_1
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc 'FirebaseInstanceId'
    //   226: aload_2
    //   227: invokevirtual toString : ()Ljava/lang/String;
    //   230: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   233: pop
    //   234: goto -> 574
    //   237: ldc 'FirebaseInstanceId'
    //   239: iconst_3
    //   240: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   243: ifeq -> 285
    //   246: aload_2
    //   247: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual length : ()I
    //   255: ifeq -> 268
    //   258: ldc 'Received InstanceID error '
    //   260: aload_1
    //   261: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   264: astore_1
    //   265: goto -> 278
    //   268: new java/lang/String
    //   271: dup
    //   272: ldc 'Received InstanceID error '
    //   274: invokespecial <init> : (Ljava/lang/String;)V
    //   277: astore_1
    //   278: ldc 'FirebaseInstanceId'
    //   280: aload_1
    //   281: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   284: pop
    //   285: aload_2
    //   286: ldc '|'
    //   288: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   291: ifeq -> 408
    //   294: aload_2
    //   295: ldc '\|'
    //   297: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   300: astore_1
    //   301: aload_1
    //   302: arraylength
    //   303: iconst_2
    //   304: if_icmple -> 366
    //   307: ldc 'ID'
    //   309: aload_1
    //   310: iconst_1
    //   311: aaload
    //   312: invokevirtual equals : (Ljava/lang/Object;)Z
    //   315: ifne -> 321
    //   318: goto -> 366
    //   321: aload_1
    //   322: iconst_2
    //   323: aaload
    //   324: astore #4
    //   326: aload_1
    //   327: iconst_3
    //   328: aaload
    //   329: astore_2
    //   330: aload_2
    //   331: astore_1
    //   332: aload_2
    //   333: ldc ':'
    //   335: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   338: ifeq -> 347
    //   341: aload_2
    //   342: iconst_1
    //   343: invokevirtual substring : (I)Ljava/lang/String;
    //   346: astore_1
    //   347: aload_0
    //   348: aload #4
    //   350: aload_3
    //   351: ldc 'error'
    //   353: aload_1
    //   354: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   357: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   360: invokespecial zza : (Ljava/lang/String;Landroid/os/Bundle;)V
    //   363: goto -> 574
    //   366: aload_2
    //   367: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual length : ()I
    //   375: ifeq -> 388
    //   378: ldc 'Unexpected structured response '
    //   380: aload_1
    //   381: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   384: astore_1
    //   385: goto -> 398
    //   388: new java/lang/String
    //   391: dup
    //   392: ldc 'Unexpected structured response '
    //   394: invokespecial <init> : (Ljava/lang/String;)V
    //   397: astore_1
    //   398: ldc 'FirebaseInstanceId'
    //   400: aload_1
    //   401: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   404: pop
    //   405: goto -> 574
    //   408: aload_0
    //   409: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   412: astore_1
    //   413: aload_1
    //   414: monitorenter
    //   415: iconst_0
    //   416: istore #5
    //   418: iload #5
    //   420: aload_0
    //   421: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   424: invokevirtual size : ()I
    //   427: if_icmpge -> 456
    //   430: aload_0
    //   431: aload_0
    //   432: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   435: iload #5
    //   437: invokevirtual keyAt : (I)Ljava/lang/Object;
    //   440: checkcast java/lang/String
    //   443: aload_3
    //   444: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   447: invokespecial zza : (Ljava/lang/String;Landroid/os/Bundle;)V
    //   450: iinc #5, 1
    //   453: goto -> 418
    //   456: aload_1
    //   457: monitorexit
    //   458: goto -> 574
    //   461: astore_2
    //   462: aload_1
    //   463: monitorexit
    //   464: aload_2
    //   465: athrow
    //   466: ldc '\|ID\|([^|]+)\|:?+(.*)'
    //   468: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   471: aload_1
    //   472: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   475: astore_2
    //   476: aload_2
    //   477: invokevirtual matches : ()Z
    //   480: ifne -> 534
    //   483: ldc 'FirebaseInstanceId'
    //   485: iconst_3
    //   486: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   489: ifeq -> 533
    //   492: aload_1
    //   493: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   496: astore_1
    //   497: aload_1
    //   498: invokevirtual length : ()I
    //   501: ifeq -> 515
    //   504: ldc_w 'Unexpected response string: '
    //   507: aload_1
    //   508: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   511: astore_1
    //   512: goto -> 526
    //   515: new java/lang/String
    //   518: dup
    //   519: ldc_w 'Unexpected response string: '
    //   522: invokespecial <init> : (Ljava/lang/String;)V
    //   525: astore_1
    //   526: ldc 'FirebaseInstanceId'
    //   528: aload_1
    //   529: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   532: pop
    //   533: return
    //   534: aload_2
    //   535: iconst_1
    //   536: invokevirtual group : (I)Ljava/lang/String;
    //   539: astore_1
    //   540: aload_2
    //   541: iconst_2
    //   542: invokevirtual group : (I)Ljava/lang/String;
    //   545: astore_2
    //   546: aload_3
    //   547: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   550: astore_3
    //   551: aload_3
    //   552: ldc 'registration_id'
    //   554: aload_2
    //   555: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_0
    //   559: aload_1
    //   560: aload_3
    //   561: invokespecial zza : (Ljava/lang/String;Landroid/os/Bundle;)V
    //   564: return
    //   565: ldc 'FirebaseInstanceId'
    //   567: ldc_w 'Dropping invalid message'
    //   570: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   573: pop
    //   574: return
    // Exception table:
    //   from	to	target	type
    //   418	450	461	finally
    //   456	458	461	finally
    //   462	464	461	finally
  }
  
  private final Bundle zzd(Bundle paramBundle) throws IOException {
    Bundle bundle1 = zze(paramBundle);
    Bundle bundle2 = bundle1;
    if (bundle1 != null) {
      bundle2 = bundle1;
      if (bundle1.containsKey("google.messenger")) {
        paramBundle = zze(paramBundle);
        bundle2 = paramBundle;
        if (paramBundle != null) {
          bundle2 = paramBundle;
          if (paramBundle.containsKey("google.messenger"))
            bundle2 = null; 
        } 
      } 
    } 
    return bundle2;
  }
  
  private final Bundle zze(Bundle paramBundle) throws IOException {
    // Byte code:
    //   0: invokestatic zzah : ()Ljava/lang/String;
    //   3: astore_2
    //   4: new com/google/android/gms/tasks/TaskCompletionSource
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore_3
    //   12: aload_0
    //   13: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   16: astore #4
    //   18: aload #4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   25: aload_2
    //   26: aload_3
    //   27: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload #4
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield zzap : Lcom/google/firebase/iid/zzan;
    //   38: invokevirtual zzac : ()I
    //   41: ifeq -> 448
    //   44: new android/content/Intent
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #4
    //   53: aload #4
    //   55: ldc_w 'com.google.android.gms'
    //   58: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   61: pop
    //   62: aload_0
    //   63: getfield zzap : Lcom/google/firebase/iid/zzan;
    //   66: invokevirtual zzac : ()I
    //   69: iconst_2
    //   70: if_icmpne -> 85
    //   73: aload #4
    //   75: ldc_w 'com.google.iid.TOKEN_REQUEST'
    //   78: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   81: pop
    //   82: goto -> 94
    //   85: aload #4
    //   87: ldc_w 'com.google.android.c2dm.intent.REGISTER'
    //   90: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   93: pop
    //   94: aload #4
    //   96: aload_1
    //   97: invokevirtual putExtras : (Landroid/os/Bundle;)Landroid/content/Intent;
    //   100: pop
    //   101: aload_0
    //   102: getfield zzz : Landroid/content/Context;
    //   105: aload #4
    //   107: invokestatic zza : (Landroid/content/Context;Landroid/content/Intent;)V
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: aload_2
    //   115: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual length : ()I
    //   121: iconst_5
    //   122: iadd
    //   123: invokespecial <init> : (I)V
    //   126: astore_1
    //   127: aload_1
    //   128: ldc_w '|ID|'
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: aload_2
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ldc '|'
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload #4
    //   150: ldc_w 'kid'
    //   153: aload_1
    //   154: invokevirtual toString : ()Ljava/lang/String;
    //   157: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: ldc 'FirebaseInstanceId'
    //   163: iconst_3
    //   164: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   167: ifeq -> 225
    //   170: aload #4
    //   172: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   175: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   178: astore_1
    //   179: new java/lang/StringBuilder
    //   182: dup
    //   183: aload_1
    //   184: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokevirtual length : ()I
    //   190: bipush #8
    //   192: iadd
    //   193: invokespecial <init> : (I)V
    //   196: astore #5
    //   198: aload #5
    //   200: ldc_w 'Sending '
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload #5
    //   209: aload_1
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: ldc 'FirebaseInstanceId'
    //   216: aload #5
    //   218: invokevirtual toString : ()Ljava/lang/String;
    //   221: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   224: pop
    //   225: aload #4
    //   227: ldc 'google.messenger'
    //   229: aload_0
    //   230: getfield zzcu : Landroid/os/Messenger;
    //   233: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   236: pop
    //   237: aload_0
    //   238: getfield zzcv : Landroid/os/Messenger;
    //   241: ifnonnull -> 251
    //   244: aload_0
    //   245: getfield zzcw : Lcom/google/firebase/iid/zzl;
    //   248: ifnull -> 309
    //   251: invokestatic obtain : ()Landroid/os/Message;
    //   254: astore_1
    //   255: aload_1
    //   256: aload #4
    //   258: putfield obj : Ljava/lang/Object;
    //   261: aload_0
    //   262: getfield zzcv : Landroid/os/Messenger;
    //   265: ifnull -> 279
    //   268: aload_0
    //   269: getfield zzcv : Landroid/os/Messenger;
    //   272: aload_1
    //   273: invokevirtual send : (Landroid/os/Message;)V
    //   276: goto -> 342
    //   279: aload_0
    //   280: getfield zzcw : Lcom/google/firebase/iid/zzl;
    //   283: aload_1
    //   284: invokevirtual send : (Landroid/os/Message;)V
    //   287: goto -> 342
    //   290: astore_1
    //   291: ldc 'FirebaseInstanceId'
    //   293: iconst_3
    //   294: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   297: ifeq -> 309
    //   300: ldc 'FirebaseInstanceId'
    //   302: ldc_w 'Messenger failed, fallback to startService'
    //   305: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   308: pop
    //   309: aload_0
    //   310: getfield zzap : Lcom/google/firebase/iid/zzan;
    //   313: invokevirtual zzac : ()I
    //   316: iconst_2
    //   317: if_icmpne -> 332
    //   320: aload_0
    //   321: getfield zzz : Landroid/content/Context;
    //   324: aload #4
    //   326: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   329: goto -> 342
    //   332: aload_0
    //   333: getfield zzz : Landroid/content/Context;
    //   336: aload #4
    //   338: invokevirtual startService : (Landroid/content/Intent;)Landroid/content/ComponentName;
    //   341: pop
    //   342: aload_3
    //   343: invokevirtual getTask : ()Lcom/google/android/gms/tasks/Task;
    //   346: ldc2_w 30000
    //   349: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   352: invokestatic await : (Lcom/google/android/gms/tasks/Task;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   355: checkcast android/os/Bundle
    //   358: astore_3
    //   359: aload_0
    //   360: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   363: astore_1
    //   364: aload_1
    //   365: monitorenter
    //   366: aload_0
    //   367: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   370: aload_2
    //   371: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: aload_1
    //   376: monitorexit
    //   377: aload_3
    //   378: areturn
    //   379: astore_2
    //   380: aload_1
    //   381: monitorexit
    //   382: aload_2
    //   383: athrow
    //   384: astore_3
    //   385: goto -> 423
    //   388: astore_3
    //   389: new java/io/IOException
    //   392: astore_1
    //   393: aload_1
    //   394: aload_3
    //   395: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   398: aload_1
    //   399: athrow
    //   400: astore_1
    //   401: ldc 'FirebaseInstanceId'
    //   403: ldc_w 'No response'
    //   406: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   409: pop
    //   410: new java/io/IOException
    //   413: astore_1
    //   414: aload_1
    //   415: ldc_w 'TIMEOUT'
    //   418: invokespecial <init> : (Ljava/lang/String;)V
    //   421: aload_1
    //   422: athrow
    //   423: aload_0
    //   424: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   427: astore_1
    //   428: aload_1
    //   429: monitorenter
    //   430: aload_0
    //   431: getfield zzct : Landroid/support/v4/util/SimpleArrayMap;
    //   434: aload_2
    //   435: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   438: pop
    //   439: aload_1
    //   440: monitorexit
    //   441: aload_3
    //   442: athrow
    //   443: astore_2
    //   444: aload_1
    //   445: monitorexit
    //   446: aload_2
    //   447: athrow
    //   448: new java/io/IOException
    //   451: dup
    //   452: ldc_w 'MISSING_INSTANCEID_SERVICE'
    //   455: invokespecial <init> : (Ljava/lang/String;)V
    //   458: athrow
    //   459: astore_1
    //   460: aload #4
    //   462: monitorexit
    //   463: aload_1
    //   464: athrow
    // Exception table:
    //   from	to	target	type
    //   21	34	459	finally
    //   261	276	290	android/os/RemoteException
    //   279	287	290	android/os/RemoteException
    //   342	359	400	java/lang/InterruptedException
    //   342	359	400	java/util/concurrent/TimeoutException
    //   342	359	388	java/util/concurrent/ExecutionException
    //   342	359	384	finally
    //   366	377	379	finally
    //   380	382	379	finally
    //   389	400	384	finally
    //   401	423	384	finally
    //   430	441	443	finally
    //   444	446	443	finally
    //   460	463	459	finally
  }
  
  final Bundle zzc(Bundle paramBundle) throws IOException {
    if (this.zzap.zzaf() >= 12000000) {
      Task<Bundle> task = zzab.zzc(this.zzz).zzb(1, paramBundle);
      try {
        return (Bundle)Tasks.await(task);
      } catch (InterruptedException interruptedException) {
      
      } catch (ExecutionException executionException) {}
      if (Log.isLoggable("FirebaseInstanceId", 3)) {
        String str = String.valueOf(executionException);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 22);
        stringBuilder.append("Error making request: ");
        stringBuilder.append(str);
        Log.d("FirebaseInstanceId", stringBuilder.toString());
      } 
      return (executionException.getCause() instanceof zzal && ((zzal)executionException.getCause()).getErrorCode() == 4) ? zzd(paramBundle) : null;
    } 
    return zzd(paramBundle);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */