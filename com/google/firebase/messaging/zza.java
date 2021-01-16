package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zza {
  private static final AtomicInteger zzdp = new AtomicInteger((int)SystemClock.elapsedRealtime());
  
  private Bundle zzdq;
  
  private final Context zzz;
  
  public zza(Context paramContext) {
    this.zzz = paramContext.getApplicationContext();
  }
  
  static String zza(Bundle paramBundle, String paramString) {
    String str1 = paramBundle.getString(paramString);
    String str2 = str1;
    if (str1 == null)
      str2 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification.")); 
    return str2;
  }
  
  private static void zza(Intent paramIntent, Bundle paramBundle) {
    for (String str : paramBundle.keySet()) {
      if (str.startsWith("google.c.a.") || str.equals("from"))
        paramIntent.putExtra(str, paramBundle.getString(str)); 
    } 
  }
  
  private final Bundle zzar() {
    ApplicationInfo applicationInfo;
    Bundle bundle = this.zzdq;
    if (bundle != null)
      return bundle; 
    bundle = null;
    try {
      ApplicationInfo applicationInfo1 = this.zzz.getPackageManager().getApplicationInfo(this.zzz.getPackageName(), 128);
      applicationInfo = applicationInfo1;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    if (applicationInfo != null && applicationInfo.metaData != null) {
      this.zzdq = applicationInfo.metaData;
      return this.zzdq;
    } 
    return Bundle.EMPTY;
  }
  
  static String zzb(Bundle paramBundle, String paramString) {
    paramString = String.valueOf(paramString);
    String str = String.valueOf("_loc_key");
    if (str.length() != 0) {
      paramString = paramString.concat(str);
    } else {
      paramString = new String(paramString);
    } 
    return zza(paramBundle, paramString);
  }
  
  @TargetApi(26)
  private final boolean zzb(int paramInt) {
    if (Build.VERSION.SDK_INT != 26)
      return true; 
    try {
      if (this.zzz.getResources().getDrawable(paramInt, null) instanceof android.graphics.drawable.AdaptiveIconDrawable) {
        StringBuilder stringBuilder = new StringBuilder();
        this(77);
        stringBuilder.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
        stringBuilder.append(paramInt);
        Log.e("FirebaseMessaging", stringBuilder.toString());
        return false;
      } 
      return true;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      return false;
    } 
  }
  
  static Object[] zzc(Bundle paramBundle, String paramString) {
    String str1 = String.valueOf(paramString);
    String str2 = String.valueOf("_loc_args");
    if (str2.length() != 0) {
      str1 = str1.concat(str2);
    } else {
      str1 = new String(str1);
    } 
    str1 = zza(paramBundle, str1);
    if (TextUtils.isEmpty(str1))
      return null; 
    try {
      JSONArray jSONArray = new JSONArray();
      this(str1);
      String[] arrayOfString = new String[jSONArray.length()];
      for (byte b = 0; b < arrayOfString.length; b++)
        arrayOfString[b] = (String)jSONArray.opt(b); 
      return (Object[])arrayOfString;
    } catch (JSONException jSONException) {
      String str = String.valueOf(paramString);
      paramString = String.valueOf("_loc_args");
      if (paramString.length() != 0) {
        str = str.concat(paramString);
      } else {
        str = new String(str);
      } 
      paramString = str.substring(6);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 41 + String.valueOf(str1).length());
      stringBuilder.append("Malformed ");
      stringBuilder.append(paramString);
      stringBuilder.append(": ");
      stringBuilder.append(str1);
      stringBuilder.append("  Default value will be used.");
      Log.w("FirebaseMessaging", stringBuilder.toString());
      return null;
    } 
  }
  
  private final String zzd(Bundle paramBundle, String paramString) {
    StringBuilder stringBuilder;
    String str = zza(paramBundle, paramString);
    if (!TextUtils.isEmpty(str))
      return str; 
    str = zzb(paramBundle, paramString);
    if (TextUtils.isEmpty(str))
      return null; 
    Resources resources = this.zzz.getResources();
    int i = resources.getIdentifier(str, "string", this.zzz.getPackageName());
    if (i == 0) {
      paramString = String.valueOf(paramString);
      String str1 = String.valueOf("_loc_key");
      if (str1.length() != 0) {
        str1 = paramString.concat(str1);
      } else {
        str1 = new String(paramString);
      } 
      paramString = str1.substring(6);
      stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 49 + String.valueOf(str).length());
      stringBuilder.append(paramString);
      stringBuilder.append(" resource not found: ");
      stringBuilder.append(str);
      stringBuilder.append(" Default value will be used.");
      Log.w("FirebaseMessaging", stringBuilder.toString());
      return null;
    } 
    Object[] arrayOfObject = zzc((Bundle)stringBuilder, paramString);
    if (arrayOfObject == null)
      return resources.getString(i); 
    try {
      return resources.getString(i, arrayOfObject);
    } catch (MissingFormatArgumentException missingFormatArgumentException) {
      String str1 = Arrays.toString(arrayOfObject);
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(str1).length());
      stringBuilder1.append("Missing format argument for ");
      stringBuilder1.append(str);
      stringBuilder1.append(": ");
      stringBuilder1.append(str1);
      stringBuilder1.append(" Default value will be used.");
      Log.w("FirebaseMessaging", stringBuilder1.toString(), missingFormatArgumentException);
      return null;
    } 
  }
  
  static boolean zzf(Bundle paramBundle) {
    return ("1".equals(zza(paramBundle, "gcm.n.e")) || zza(paramBundle, "gcm.n.icon") != null);
  }
  
  @Nullable
  static Uri zzg(@NonNull Bundle paramBundle) {
    String str1 = zza(paramBundle, "gcm.n.link_android");
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = zza(paramBundle, "gcm.n.link"); 
    return !TextUtils.isEmpty(str2) ? Uri.parse(str2) : null;
  }
  
  static String zzi(Bundle paramBundle) {
    String str1 = zza(paramBundle, "gcm.n.sound2");
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = zza(paramBundle, "gcm.n.sound"); 
    return str2;
  }
  
  private final Integer zzl(String paramString) {
    if (Build.VERSION.SDK_INT < 21)
      return null; 
    if (!TextUtils.isEmpty(paramString))
      try {
        int j = Color.parseColor(paramString);
        return Integer.valueOf(j);
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 54);
        stringBuilder.append("Color ");
        stringBuilder.append(paramString);
        stringBuilder.append(" not valid. Notification will use default color.");
        Log.w("FirebaseMessaging", stringBuilder.toString());
      }  
    int i = zzar().getInt("com.google.firebase.messaging.default_notification_color", 0);
    if (i != 0)
      try {
        i = ContextCompat.getColor(this.zzz, i);
        return Integer.valueOf(i);
      } catch (android.content.res.Resources.NotFoundException notFoundException) {
        Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
      }  
    return null;
  }
  
  final boolean zzh(Bundle paramBundle) {
    // Byte code:
    //   0: ldc_w '1'
    //   3: aload_1
    //   4: ldc_w 'gcm.n.noui'
    //   7: invokestatic zza : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual equals : (Ljava/lang/Object;)Z
    //   13: ifeq -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: getfield zzz : Landroid/content/Context;
    //   22: ldc_w 'keyguard'
    //   25: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast android/app/KeyguardManager
    //   31: invokevirtual inKeyguardRestrictedInputMode : ()Z
    //   34: ifne -> 130
    //   37: invokestatic isAtLeastLollipop : ()Z
    //   40: ifne -> 49
    //   43: ldc2_w 10
    //   46: invokestatic sleep : (J)V
    //   49: invokestatic myPid : ()I
    //   52: istore_2
    //   53: aload_0
    //   54: getfield zzz : Landroid/content/Context;
    //   57: ldc_w 'activity'
    //   60: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   63: checkcast android/app/ActivityManager
    //   66: invokevirtual getRunningAppProcesses : ()Ljava/util/List;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull -> 130
    //   74: aload_3
    //   75: invokeinterface iterator : ()Ljava/util/Iterator;
    //   80: astore #4
    //   82: aload #4
    //   84: invokeinterface hasNext : ()Z
    //   89: ifeq -> 130
    //   92: aload #4
    //   94: invokeinterface next : ()Ljava/lang/Object;
    //   99: checkcast android/app/ActivityManager$RunningAppProcessInfo
    //   102: astore_3
    //   103: aload_3
    //   104: getfield pid : I
    //   107: iload_2
    //   108: if_icmpne -> 82
    //   111: aload_3
    //   112: getfield importance : I
    //   115: bipush #100
    //   117: if_icmpne -> 125
    //   120: iconst_1
    //   121: istore_2
    //   122: goto -> 132
    //   125: iconst_0
    //   126: istore_2
    //   127: goto -> 132
    //   130: iconst_0
    //   131: istore_2
    //   132: iload_2
    //   133: ifeq -> 138
    //   136: iconst_0
    //   137: ireturn
    //   138: aload_0
    //   139: aload_1
    //   140: ldc_w 'gcm.n.title'
    //   143: invokespecial zzd : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: astore #5
    //   150: aload_3
    //   151: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   154: ifeq -> 176
    //   157: aload_0
    //   158: getfield zzz : Landroid/content/Context;
    //   161: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   164: aload_0
    //   165: getfield zzz : Landroid/content/Context;
    //   168: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   171: invokevirtual loadLabel : (Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   174: astore #5
    //   176: aload_0
    //   177: aload_1
    //   178: ldc_w 'gcm.n.body'
    //   181: invokespecial zzd : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   184: astore #6
    //   186: aload_1
    //   187: ldc_w 'gcm.n.icon'
    //   190: invokestatic zza : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore_3
    //   194: aload_3
    //   195: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   198: ifne -> 329
    //   201: aload_0
    //   202: getfield zzz : Landroid/content/Context;
    //   205: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   208: astore #4
    //   210: aload #4
    //   212: aload_3
    //   213: ldc_w 'drawable'
    //   216: aload_0
    //   217: getfield zzz : Landroid/content/Context;
    //   220: invokevirtual getPackageName : ()Ljava/lang/String;
    //   223: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   226: istore_2
    //   227: iload_2
    //   228: ifeq -> 242
    //   231: aload_0
    //   232: iload_2
    //   233: invokespecial zzb : (I)Z
    //   236: ifeq -> 242
    //   239: goto -> 392
    //   242: aload #4
    //   244: aload_3
    //   245: ldc_w 'mipmap'
    //   248: aload_0
    //   249: getfield zzz : Landroid/content/Context;
    //   252: invokevirtual getPackageName : ()Ljava/lang/String;
    //   255: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   258: istore_2
    //   259: iload_2
    //   260: ifeq -> 274
    //   263: aload_0
    //   264: iload_2
    //   265: invokespecial zzb : (I)Z
    //   268: ifeq -> 274
    //   271: goto -> 392
    //   274: new java/lang/StringBuilder
    //   277: dup
    //   278: aload_3
    //   279: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   282: invokevirtual length : ()I
    //   285: bipush #61
    //   287: iadd
    //   288: invokespecial <init> : (I)V
    //   291: astore #4
    //   293: aload #4
    //   295: ldc_w 'Icon resource '
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #4
    //   304: aload_3
    //   305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload #4
    //   311: ldc_w ' not found. Notification will use default icon.'
    //   314: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: ldc 'FirebaseMessaging'
    //   320: aload #4
    //   322: invokevirtual toString : ()Ljava/lang/String;
    //   325: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: aload_0
    //   330: invokespecial zzar : ()Landroid/os/Bundle;
    //   333: ldc_w 'com.google.firebase.messaging.default_notification_icon'
    //   336: iconst_0
    //   337: invokevirtual getInt : (Ljava/lang/String;I)I
    //   340: istore #7
    //   342: iload #7
    //   344: ifeq -> 359
    //   347: iload #7
    //   349: istore_2
    //   350: aload_0
    //   351: iload #7
    //   353: invokespecial zzb : (I)Z
    //   356: ifne -> 370
    //   359: aload_0
    //   360: getfield zzz : Landroid/content/Context;
    //   363: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   366: getfield icon : I
    //   369: istore_2
    //   370: iload_2
    //   371: ifeq -> 388
    //   374: aload_0
    //   375: iload_2
    //   376: invokespecial zzb : (I)Z
    //   379: ifne -> 385
    //   382: goto -> 388
    //   385: goto -> 392
    //   388: ldc_w 17301651
    //   391: istore_2
    //   392: aload_0
    //   393: aload_1
    //   394: ldc_w 'gcm.n.color'
    //   397: invokestatic zza : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   400: invokespecial zzl : (Ljava/lang/String;)Ljava/lang/Integer;
    //   403: astore #8
    //   405: aload_1
    //   406: invokestatic zzi : (Landroid/os/Bundle;)Ljava/lang/String;
    //   409: astore #4
    //   411: aload #4
    //   413: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   416: istore #9
    //   418: aconst_null
    //   419: astore #10
    //   421: iload #9
    //   423: ifeq -> 432
    //   426: aconst_null
    //   427: astore #4
    //   429: goto -> 553
    //   432: ldc_w 'default'
    //   435: aload #4
    //   437: invokevirtual equals : (Ljava/lang/Object;)Z
    //   440: ifne -> 547
    //   443: aload_0
    //   444: getfield zzz : Landroid/content/Context;
    //   447: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   450: aload #4
    //   452: ldc_w 'raw'
    //   455: aload_0
    //   456: getfield zzz : Landroid/content/Context;
    //   459: invokevirtual getPackageName : ()Ljava/lang/String;
    //   462: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   465: ifeq -> 547
    //   468: aload_0
    //   469: getfield zzz : Landroid/content/Context;
    //   472: invokevirtual getPackageName : ()Ljava/lang/String;
    //   475: astore #11
    //   477: new java/lang/StringBuilder
    //   480: dup
    //   481: aload #11
    //   483: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   486: invokevirtual length : ()I
    //   489: bipush #24
    //   491: iadd
    //   492: aload #4
    //   494: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   497: invokevirtual length : ()I
    //   500: iadd
    //   501: invokespecial <init> : (I)V
    //   504: astore_3
    //   505: aload_3
    //   506: ldc_w 'android.resource://'
    //   509: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_3
    //   514: aload #11
    //   516: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload_3
    //   521: ldc_w '/raw/'
    //   524: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_3
    //   529: aload #4
    //   531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_3
    //   536: invokevirtual toString : ()Ljava/lang/String;
    //   539: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   542: astore #4
    //   544: goto -> 553
    //   547: iconst_2
    //   548: invokestatic getDefaultUri : (I)Landroid/net/Uri;
    //   551: astore #4
    //   553: aload_1
    //   554: ldc_w 'gcm.n.click_action'
    //   557: invokestatic zza : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   560: astore_3
    //   561: aload_3
    //   562: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   565: ifne -> 600
    //   568: new android/content/Intent
    //   571: dup
    //   572: aload_3
    //   573: invokespecial <init> : (Ljava/lang/String;)V
    //   576: astore_3
    //   577: aload_3
    //   578: aload_0
    //   579: getfield zzz : Landroid/content/Context;
    //   582: invokevirtual getPackageName : ()Ljava/lang/String;
    //   585: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   588: pop
    //   589: aload_3
    //   590: ldc_w 268435456
    //   593: invokevirtual setFlags : (I)Landroid/content/Intent;
    //   596: pop
    //   597: goto -> 683
    //   600: aload_1
    //   601: invokestatic zzg : (Landroid/os/Bundle;)Landroid/net/Uri;
    //   604: astore #11
    //   606: aload #11
    //   608: ifnull -> 644
    //   611: new android/content/Intent
    //   614: dup
    //   615: ldc_w 'android.intent.action.VIEW'
    //   618: invokespecial <init> : (Ljava/lang/String;)V
    //   621: astore_3
    //   622: aload_3
    //   623: aload_0
    //   624: getfield zzz : Landroid/content/Context;
    //   627: invokevirtual getPackageName : ()Ljava/lang/String;
    //   630: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   633: pop
    //   634: aload_3
    //   635: aload #11
    //   637: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   640: pop
    //   641: goto -> 683
    //   644: aload_0
    //   645: getfield zzz : Landroid/content/Context;
    //   648: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   651: aload_0
    //   652: getfield zzz : Landroid/content/Context;
    //   655: invokevirtual getPackageName : ()Ljava/lang/String;
    //   658: invokevirtual getLaunchIntentForPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   661: astore #11
    //   663: aload #11
    //   665: astore_3
    //   666: aload #11
    //   668: ifnonnull -> 683
    //   671: ldc 'FirebaseMessaging'
    //   673: ldc_w 'No activity found to launch app'
    //   676: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   679: pop
    //   680: aload #11
    //   682: astore_3
    //   683: aload_3
    //   684: ifnonnull -> 692
    //   687: aconst_null
    //   688: astore_3
    //   689: goto -> 803
    //   692: aload_3
    //   693: ldc_w 67108864
    //   696: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   699: pop
    //   700: new android/os/Bundle
    //   703: dup
    //   704: aload_1
    //   705: invokespecial <init> : (Landroid/os/Bundle;)V
    //   708: astore #11
    //   710: aload #11
    //   712: invokestatic zzj : (Landroid/os/Bundle;)V
    //   715: aload_3
    //   716: aload #11
    //   718: invokevirtual putExtras : (Landroid/os/Bundle;)Landroid/content/Intent;
    //   721: pop
    //   722: aload #11
    //   724: invokevirtual keySet : ()Ljava/util/Set;
    //   727: invokeinterface iterator : ()Ljava/util/Iterator;
    //   732: astore #12
    //   734: aload #12
    //   736: invokeinterface hasNext : ()Z
    //   741: ifeq -> 785
    //   744: aload #12
    //   746: invokeinterface next : ()Ljava/lang/Object;
    //   751: checkcast java/lang/String
    //   754: astore #11
    //   756: aload #11
    //   758: ldc 'gcm.n.'
    //   760: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   763: ifne -> 776
    //   766: aload #11
    //   768: ldc 'gcm.notification.'
    //   770: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   773: ifeq -> 734
    //   776: aload_3
    //   777: aload #11
    //   779: invokevirtual removeExtra : (Ljava/lang/String;)V
    //   782: goto -> 734
    //   785: aload_0
    //   786: getfield zzz : Landroid/content/Context;
    //   789: getstatic com/google/firebase/messaging/zza.zzdp : Ljava/util/concurrent/atomic/AtomicInteger;
    //   792: invokevirtual incrementAndGet : ()I
    //   795: aload_3
    //   796: ldc_w 1073741824
    //   799: invokestatic getActivity : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   802: astore_3
    //   803: aload_1
    //   804: ifnonnull -> 813
    //   807: iconst_0
    //   808: istore #9
    //   810: goto -> 828
    //   813: ldc_w '1'
    //   816: aload_1
    //   817: ldc_w 'google.c.a.e'
    //   820: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   823: invokevirtual equals : (Ljava/lang/Object;)Z
    //   826: istore #9
    //   828: iload #9
    //   830: ifeq -> 919
    //   833: new android/content/Intent
    //   836: dup
    //   837: ldc_w 'com.google.firebase.messaging.NOTIFICATION_OPEN'
    //   840: invokespecial <init> : (Ljava/lang/String;)V
    //   843: astore #11
    //   845: aload #11
    //   847: aload_1
    //   848: invokestatic zza : (Landroid/content/Intent;Landroid/os/Bundle;)V
    //   851: aload #11
    //   853: ldc_w 'pending_intent'
    //   856: aload_3
    //   857: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   860: pop
    //   861: aload_0
    //   862: getfield zzz : Landroid/content/Context;
    //   865: getstatic com/google/firebase/messaging/zza.zzdp : Ljava/util/concurrent/atomic/AtomicInteger;
    //   868: invokevirtual incrementAndGet : ()I
    //   871: aload #11
    //   873: ldc_w 1073741824
    //   876: invokestatic zza : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   879: astore #12
    //   881: new android/content/Intent
    //   884: dup
    //   885: ldc_w 'com.google.firebase.messaging.NOTIFICATION_DISMISS'
    //   888: invokespecial <init> : (Ljava/lang/String;)V
    //   891: astore_3
    //   892: aload_3
    //   893: aload_1
    //   894: invokestatic zza : (Landroid/content/Intent;Landroid/os/Bundle;)V
    //   897: aload_0
    //   898: getfield zzz : Landroid/content/Context;
    //   901: getstatic com/google/firebase/messaging/zza.zzdp : Ljava/util/concurrent/atomic/AtomicInteger;
    //   904: invokevirtual incrementAndGet : ()I
    //   907: aload_3
    //   908: ldc_w 1073741824
    //   911: invokestatic zza : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   914: astore #11
    //   916: goto -> 925
    //   919: aconst_null
    //   920: astore #11
    //   922: aload_3
    //   923: astore #12
    //   925: aload_1
    //   926: ldc_w 'gcm.n.android_channel_id'
    //   929: invokestatic zza : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   932: astore #13
    //   934: aload #10
    //   936: astore_3
    //   937: invokestatic isAtLeastO : ()Z
    //   940: ifeq -> 1147
    //   943: aload_0
    //   944: getfield zzz : Landroid/content/Context;
    //   947: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   950: getfield targetSdkVersion : I
    //   953: bipush #26
    //   955: if_icmpge -> 964
    //   958: aload #10
    //   960: astore_3
    //   961: goto -> 1147
    //   964: aload_0
    //   965: getfield zzz : Landroid/content/Context;
    //   968: ldc_w android/app/NotificationManager
    //   971: invokevirtual getSystemService : (Ljava/lang/Class;)Ljava/lang/Object;
    //   974: checkcast android/app/NotificationManager
    //   977: astore #10
    //   979: aload #13
    //   981: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   984: ifne -> 1055
    //   987: aload #10
    //   989: aload #13
    //   991: invokevirtual getNotificationChannel : (Ljava/lang/String;)Landroid/app/NotificationChannel;
    //   994: ifnull -> 1003
    //   997: aload #13
    //   999: astore_3
    //   1000: goto -> 1147
    //   1003: new java/lang/StringBuilder
    //   1006: dup
    //   1007: aload #13
    //   1009: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1012: invokevirtual length : ()I
    //   1015: bipush #122
    //   1017: iadd
    //   1018: invokespecial <init> : (I)V
    //   1021: astore_3
    //   1022: aload_3
    //   1023: ldc_w 'Notification Channel requested ('
    //   1026: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: pop
    //   1030: aload_3
    //   1031: aload #13
    //   1033: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: aload_3
    //   1038: ldc_w ') has not been created by the app. Manifest configuration, or default, value will be used.'
    //   1041: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: ldc 'FirebaseMessaging'
    //   1047: aload_3
    //   1048: invokevirtual toString : ()Ljava/lang/String;
    //   1051: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   1054: pop
    //   1055: aload_0
    //   1056: invokespecial zzar : ()Landroid/os/Bundle;
    //   1059: ldc_w 'com.google.firebase.messaging.default_notification_channel_id'
    //   1062: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1065: astore_3
    //   1066: aload_3
    //   1067: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1070: ifne -> 1097
    //   1073: aload #10
    //   1075: aload_3
    //   1076: invokevirtual getNotificationChannel : (Ljava/lang/String;)Landroid/app/NotificationChannel;
    //   1079: ifnull -> 1085
    //   1082: goto -> 1147
    //   1085: ldc 'FirebaseMessaging'
    //   1087: ldc_w 'Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.'
    //   1090: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   1093: pop
    //   1094: goto -> 1106
    //   1097: ldc 'FirebaseMessaging'
    //   1099: ldc_w 'Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.'
    //   1102: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   1105: pop
    //   1106: aload #10
    //   1108: ldc_w 'fcm_fallback_notification_channel'
    //   1111: invokevirtual getNotificationChannel : (Ljava/lang/String;)Landroid/app/NotificationChannel;
    //   1114: ifnonnull -> 1143
    //   1117: aload #10
    //   1119: new android/app/NotificationChannel
    //   1122: dup
    //   1123: ldc_w 'fcm_fallback_notification_channel'
    //   1126: aload_0
    //   1127: getfield zzz : Landroid/content/Context;
    //   1130: getstatic com/google/firebase/messaging/R$string.fcm_fallback_notification_channel_label : I
    //   1133: invokevirtual getString : (I)Ljava/lang/String;
    //   1136: iconst_3
    //   1137: invokespecial <init> : (Ljava/lang/String;Ljava/lang/CharSequence;I)V
    //   1140: invokevirtual createNotificationChannel : (Landroid/app/NotificationChannel;)V
    //   1143: ldc_w 'fcm_fallback_notification_channel'
    //   1146: astore_3
    //   1147: new android/support/v4/app/NotificationCompat$Builder
    //   1150: dup
    //   1151: aload_0
    //   1152: getfield zzz : Landroid/content/Context;
    //   1155: invokespecial <init> : (Landroid/content/Context;)V
    //   1158: iconst_1
    //   1159: invokevirtual setAutoCancel : (Z)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1162: iload_2
    //   1163: invokevirtual setSmallIcon : (I)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1166: astore #10
    //   1168: aload #5
    //   1170: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1173: ifne -> 1184
    //   1176: aload #10
    //   1178: aload #5
    //   1180: invokevirtual setContentTitle : (Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1183: pop
    //   1184: aload #6
    //   1186: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1189: ifne -> 1218
    //   1192: aload #10
    //   1194: aload #6
    //   1196: invokevirtual setContentText : (Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1199: pop
    //   1200: aload #10
    //   1202: new android/support/v4/app/NotificationCompat$BigTextStyle
    //   1205: dup
    //   1206: invokespecial <init> : ()V
    //   1209: aload #6
    //   1211: invokevirtual bigText : (Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigTextStyle;
    //   1214: invokevirtual setStyle : (Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1217: pop
    //   1218: aload #8
    //   1220: ifnull -> 1234
    //   1223: aload #10
    //   1225: aload #8
    //   1227: invokevirtual intValue : ()I
    //   1230: invokevirtual setColor : (I)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1233: pop
    //   1234: aload #4
    //   1236: ifnull -> 1247
    //   1239: aload #10
    //   1241: aload #4
    //   1243: invokevirtual setSound : (Landroid/net/Uri;)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1246: pop
    //   1247: aload #12
    //   1249: ifnull -> 1260
    //   1252: aload #10
    //   1254: aload #12
    //   1256: invokevirtual setContentIntent : (Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1259: pop
    //   1260: aload #11
    //   1262: ifnull -> 1273
    //   1265: aload #10
    //   1267: aload #11
    //   1269: invokevirtual setDeleteIntent : (Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1272: pop
    //   1273: aload_3
    //   1274: ifnull -> 1284
    //   1277: aload #10
    //   1279: aload_3
    //   1280: invokevirtual setChannelId : (Ljava/lang/String;)Landroid/support/v4/app/NotificationCompat$Builder;
    //   1283: pop
    //   1284: aload #10
    //   1286: invokevirtual build : ()Landroid/app/Notification;
    //   1289: astore_3
    //   1290: aload_1
    //   1291: ldc_w 'gcm.n.tag'
    //   1294: invokestatic zza : (Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   1297: astore_1
    //   1298: ldc 'FirebaseMessaging'
    //   1300: iconst_3
    //   1301: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   1304: ifeq -> 1316
    //   1307: ldc 'FirebaseMessaging'
    //   1309: ldc_w 'Showing notification'
    //   1312: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1315: pop
    //   1316: aload_0
    //   1317: getfield zzz : Landroid/content/Context;
    //   1320: ldc_w 'notification'
    //   1323: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   1326: checkcast android/app/NotificationManager
    //   1329: astore #4
    //   1331: aload_1
    //   1332: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1335: ifeq -> 1376
    //   1338: invokestatic uptimeMillis : ()J
    //   1341: lstore #14
    //   1343: new java/lang/StringBuilder
    //   1346: dup
    //   1347: bipush #37
    //   1349: invokespecial <init> : (I)V
    //   1352: astore_1
    //   1353: aload_1
    //   1354: ldc_w 'FCM-Notification:'
    //   1357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload_1
    //   1362: lload #14
    //   1364: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1367: pop
    //   1368: aload_1
    //   1369: invokevirtual toString : ()Ljava/lang/String;
    //   1372: astore_1
    //   1373: goto -> 1376
    //   1376: aload #4
    //   1378: aload_1
    //   1379: iconst_0
    //   1380: aload_3
    //   1381: invokevirtual notify : (Ljava/lang/String;ILandroid/app/Notification;)V
    //   1384: iconst_1
    //   1385: ireturn
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\messaging\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */