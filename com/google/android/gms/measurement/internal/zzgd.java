package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzq;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class zzgd extends zzcu {
  private static final String[] zztb = new String[] { "firebase_", "google_", "ga_" };
  
  private int zzae;
  
  private SecureRandom zztc;
  
  private final AtomicLong zztd = new AtomicLong(0L);
  
  private Integer zzte = null;
  
  zzgd(zzby paramzzby) {
    super(paramzzby);
  }
  
  static MessageDigest getMessageDigest() {
    byte b = 0;
    while (true) {
      if (b < 2) {
        try {
          MessageDigest messageDigest = MessageDigest.getInstance("MD5");
          if (messageDigest != null)
            return messageDigest; 
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        b++;
        continue;
      } 
      return null;
    } 
  }
  
  private static Object zza(int paramInt, Object paramObject, boolean paramBoolean) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Long || paramObject instanceof Double)
      return paramObject; 
    if (paramObject instanceof Integer)
      return Long.valueOf(((Integer)paramObject).intValue()); 
    if (paramObject instanceof Byte)
      return Long.valueOf(((Byte)paramObject).byteValue()); 
    if (paramObject instanceof Short)
      return Long.valueOf(((Short)paramObject).shortValue()); 
    if (paramObject instanceof Boolean) {
      long l;
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      } 
      return Long.valueOf(l);
    } 
    return (paramObject instanceof Float) ? Double.valueOf(((Float)paramObject).doubleValue()) : ((paramObject instanceof String || paramObject instanceof Character || paramObject instanceof CharSequence) ? zza(String.valueOf(paramObject), paramInt, paramBoolean) : null);
  }
  
  public static String zza(String paramString, int paramInt, boolean paramBoolean) {
    return (paramString == null) ? null : ((paramString.codePointCount(0, paramString.length()) > paramInt) ? (paramBoolean ? String.valueOf(paramString.substring(0, paramString.offsetByCodePoints(0, paramInt))).concat("...") : null) : paramString);
  }
  
  private static boolean zza(Bundle paramBundle, int paramInt) {
    if (paramBundle.getLong("_err") == 0L) {
      paramBundle.putLong("_err", paramInt);
      return true;
    } 
    return false;
  }
  
  static boolean zza(Boolean paramBoolean1, Boolean paramBoolean2) {
    return (paramBoolean1 == null && paramBoolean2 == null) ? true : ((paramBoolean1 == null) ? false : paramBoolean1.equals(paramBoolean2));
  }
  
  private final boolean zza(String paramString1, String paramString2, int paramInt, Object paramObject, boolean paramBoolean) {
    if (paramObject == null)
      return true; 
    if (paramObject instanceof Long || paramObject instanceof Float || paramObject instanceof Integer || paramObject instanceof Byte || paramObject instanceof Short || paramObject instanceof Boolean || paramObject instanceof Double)
      return true; 
    if (paramObject instanceof String || paramObject instanceof Character || paramObject instanceof CharSequence) {
      paramObject = String.valueOf(paramObject);
      if (paramObject.codePointCount(0, paramObject.length()) > paramInt) {
        super.zzad().zzdd().zza("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(paramObject.length()));
        return false;
      } 
      return true;
    } 
    if (paramObject instanceof Bundle && paramBoolean)
      return true; 
    if (paramObject instanceof Parcelable[] && paramBoolean) {
      paramObject = paramObject;
      int i = paramObject.length;
      for (paramInt = 0; paramInt < i; paramInt++) {
        Object object = paramObject[paramInt];
        if (!(object instanceof Bundle)) {
          super.zzad().zzdd().zza("All Parcelable[] elements must be of type Bundle. Value type, name", object.getClass(), paramString2);
          return false;
        } 
      } 
      return true;
    } 
    if (paramObject instanceof ArrayList && paramBoolean) {
      ArrayList arrayList = (ArrayList)paramObject;
      int i = arrayList.size();
      paramInt = 0;
      while (paramInt < i) {
        paramObject = arrayList.get(paramInt);
        paramInt++;
        if (!(paramObject instanceof Bundle)) {
          super.zzad().zzdd().zza("All ArrayList elements must be of type Bundle. Value type, name", paramObject.getClass(), paramString2);
          return false;
        } 
      } 
      return true;
    } 
    return false;
  }
  
  static boolean zza(String paramString1, String paramString2, String paramString3, String paramString4) {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    return (!bool1 && !bool2) ? (!paramString1.equals(paramString2)) : ((bool1 && bool2) ? ((!TextUtils.isEmpty(paramString3) && !TextUtils.isEmpty(paramString4)) ? (!paramString3.equals(paramString4)) : (!TextUtils.isEmpty(paramString4))) : ((!bool1 && bool2) ? (TextUtils.isEmpty(paramString4) ? false : ((TextUtils.isEmpty(paramString3) || !paramString3.equals(paramString4)))) : ((TextUtils.isEmpty(paramString3) || !paramString3.equals(paramString4)))));
  }
  
  static byte[] zza(Parcelable paramParcelable) {
    if (paramParcelable == null)
      return null; 
    Parcel parcel = Parcel.obtain();
    try {
      paramParcelable.writeToParcel(parcel, 0);
      return parcel.marshall();
    } finally {
      parcel.recycle();
    } 
  }
  
  public static Bundle zzb(List<zzga> paramList) {
    Bundle bundle = new Bundle();
    if (paramList == null)
      return bundle; 
    for (zzga zzga : paramList) {
      if (zzga.zzki != null) {
        bundle.putString(zzga.name, zzga.zzki);
        continue;
      } 
      if (zzga.zzsy != null) {
        bundle.putLong(zzga.name, zzga.zzsy.longValue());
        continue;
      } 
      if (zzga.zzta != null)
        bundle.putDouble(zzga.name, zzga.zzta.doubleValue()); 
    } 
    return bundle;
  }
  
  private static void zzb(Bundle paramBundle, Object paramObject) {
    Preconditions.checkNotNull(paramBundle);
    if (paramObject != null && (paramObject instanceof String || paramObject instanceof CharSequence))
      paramBundle.putLong("_el", String.valueOf(paramObject).length()); 
  }
  
  private static boolean zzb(Context paramContext, String paramString) {
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      if (packageManager == null)
        return false; 
      ComponentName componentName = new ComponentName();
      this(paramContext, paramString);
      ServiceInfo serviceInfo = packageManager.getServiceInfo(componentName, 0);
      if (serviceInfo != null) {
        boolean bool = serviceInfo.enabled;
        if (bool)
          return true; 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return false;
  }
  
  static boolean zzb(Context paramContext, boolean paramBoolean) {
    Preconditions.checkNotNull(paramContext);
    return (Build.VERSION.SDK_INT >= 24) ? zzb(paramContext, "com.google.android.gms.measurement.AppMeasurementJobService") : zzb(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
  }
  
  static Bundle[] zzb(Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: instanceof android/os/Bundle
    //   4: ifeq -> 19
    //   7: iconst_1
    //   8: anewarray android/os/Bundle
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: checkcast android/os/Bundle
    //   17: aastore
    //   18: areturn
    //   19: aload_0
    //   20: instanceof [Landroid/os/Parcelable;
    //   23: ifeq -> 44
    //   26: aload_0
    //   27: checkcast [Landroid/os/Parcelable;
    //   30: astore_0
    //   31: aload_0
    //   32: aload_0
    //   33: arraylength
    //   34: ldc_w [Landroid/os/Bundle;
    //   37: invokestatic copyOf : ([Ljava/lang/Object;ILjava/lang/Class;)[Ljava/lang/Object;
    //   40: checkcast [Landroid/os/Bundle;
    //   43: areturn
    //   44: aload_0
    //   45: instanceof java/util/ArrayList
    //   48: ifeq -> 71
    //   51: aload_0
    //   52: checkcast java/util/ArrayList
    //   55: astore_0
    //   56: aload_0
    //   57: aload_0
    //   58: invokevirtual size : ()I
    //   61: anewarray android/os/Bundle
    //   64: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   67: checkcast [Landroid/os/Bundle;
    //   70: areturn
    //   71: aconst_null
    //   72: areturn
  }
  
  static boolean zzbm(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return (paramString.charAt(0) != '_' || paramString.equals("_ep"));
  }
  
  @VisibleForTesting
  private static boolean zzbp(String paramString) {
    Preconditions.checkNotNull(paramString);
    return paramString.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
  }
  
  private static int zzbq(String paramString) {
    return "_ldl".equals(paramString) ? 2048 : ("_id".equals(paramString) ? 256 : 36);
  }
  
  static boolean zzbs(String paramString) {
    return (!TextUtils.isEmpty(paramString) && paramString.startsWith("_"));
  }
  
  public static long zzc(long paramLong1, long paramLong2) {
    return (paramLong1 + paramLong2 * 60000L) / 86400000L;
  }
  
  public static ArrayList<Bundle> zzc(List<zzr> paramList) {
    if (paramList == null)
      return new ArrayList<Bundle>(0); 
    ArrayList<Bundle> arrayList = new ArrayList(paramList.size());
    for (zzr zzr : paramList) {
      Bundle bundle = new Bundle();
      bundle.putString("app_id", zzr.packageName);
      bundle.putString("origin", zzr.origin);
      bundle.putLong("creation_timestamp", zzr.creationTimestamp);
      bundle.putString("name", zzr.zzdv.name);
      zzcw.zza(bundle, zzr.zzdv.getValue());
      bundle.putBoolean("active", zzr.active);
      if (zzr.triggerEventName != null)
        bundle.putString("trigger_event_name", zzr.triggerEventName); 
      if (zzr.zzdw != null) {
        bundle.putString("timed_out_event_name", zzr.zzdw.name);
        if (zzr.zzdw.zzfd != null)
          bundle.putBundle("timed_out_event_params", zzr.zzdw.zzfd.zzct()); 
      } 
      bundle.putLong("trigger_timeout", zzr.triggerTimeout);
      if (zzr.zzdx != null) {
        bundle.putString("triggered_event_name", zzr.zzdx.name);
        if (zzr.zzdx.zzfd != null)
          bundle.putBundle("triggered_event_params", zzr.zzdx.zzfd.zzct()); 
      } 
      bundle.putLong("triggered_timestamp", zzr.zzdv.zzsx);
      bundle.putLong("time_to_live", zzr.timeToLive);
      if (zzr.zzdy != null) {
        bundle.putString("expired_event_name", zzr.zzdy.name);
        if (zzr.zzdy.zzfd != null)
          bundle.putBundle("expired_event_params", zzr.zzdy.zzfd.zzct()); 
      } 
      arrayList.add(bundle);
    } 
    return arrayList;
  }
  
  static boolean zzc(Intent paramIntent) {
    String str = paramIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    return ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(str) || "https://www.google.com".equals(str) || "android-app://com.google.appcrawler".equals(str));
  }
  
  @VisibleForTesting
  static long zzd(byte[] paramArrayOfbyte) {
    boolean bool2;
    Preconditions.checkNotNull(paramArrayOfbyte);
    int i = paramArrayOfbyte.length;
    boolean bool1 = false;
    if (i > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    long l = 0L;
    for (i = paramArrayOfbyte.length - 1; i >= 0 && i >= paramArrayOfbyte.length - 8; i--) {
      l += (paramArrayOfbyte[i] & 0xFFL) << bool1;
      bool1 += true;
    } 
    return l;
  }
  
  @VisibleForTesting
  private final boolean zzd(Context paramContext, String paramString) {
    X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
    try {
      PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
      if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
        Signature signature = packageInfo.signatures[0];
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
        this(signature.toByteArray());
        return ((X509Certificate)certificateFactory.generateCertificate(byteArrayInputStream)).getSubjectX500Principal().equals(x500Principal);
      } 
    } catch (CertificateException certificateException) {
      super.zzad().zzda().zza("Error obtaining certificate", certificateException);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      super.zzad().zzda().zza("Package name not found", nameNotFoundException);
    } 
    return true;
  }
  
  public static Bundle zzh(Bundle paramBundle) {
    if (paramBundle == null)
      return new Bundle(); 
    paramBundle = new Bundle(paramBundle);
    for (String str : paramBundle.keySet()) {
      Object object = paramBundle.get(str);
      if (object instanceof Bundle) {
        paramBundle.putBundle(str, new Bundle((Bundle)object));
        continue;
      } 
      boolean bool = object instanceof Parcelable[];
      boolean bool1 = false;
      byte b = 0;
      if (bool) {
        object = object;
        while (b < object.length) {
          if (object[b] instanceof Bundle)
            object[b] = new Bundle((Bundle)object[b]); 
          b++;
        } 
        continue;
      } 
      if (object instanceof List) {
        List<Bundle> list = (List)object;
        for (b = bool1; b < list.size(); b++) {
          object = list.get(b);
          if (object instanceof Bundle)
            list.set(b, new Bundle((Bundle)object)); 
        } 
      } 
    } 
    return paramBundle;
  }
  
  private final boolean zzq(String paramString1, String paramString2) {
    if (paramString2 == null) {
      super.zzad().zzda().zza("Name is required and can't be null. Type", paramString1);
      return false;
    } 
    if (paramString2.length() == 0) {
      super.zzad().zzda().zza("Name is required and can't be empty. Type", paramString1);
      return false;
    } 
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i) && i != 95) {
      super.zzad().zzda().zza("Name must start with a letter or _ (underscore). Type, name", paramString1, paramString2);
      return false;
    } 
    int j = paramString2.length();
    for (i = Character.charCount(i); i < j; i += Character.charCount(k)) {
      int k = paramString2.codePointAt(i);
      if (k != 95 && !Character.isLetterOrDigit(k)) {
        super.zzad().zzda().zza("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      } 
    } 
    return true;
  }
  
  static boolean zzs(String paramString1, String paramString2) {
    return (paramString1 == null && paramString2 == null) ? true : ((paramString1 == null) ? false : paramString1.equals(paramString2));
  }
  
  final Bundle zza(@NonNull Uri paramUri) {
    if (paramUri == null)
      return null; 
    try {
      CharSequence charSequence1;
      CharSequence charSequence2;
      CharSequence charSequence3;
      CharSequence charSequence4;
      if (paramUri.isHierarchical()) {
        charSequence1 = paramUri.getQueryParameter("utm_campaign");
        charSequence2 = paramUri.getQueryParameter("utm_source");
        charSequence3 = paramUri.getQueryParameter("utm_medium");
        charSequence4 = paramUri.getQueryParameter("gclid");
      } else {
        CharSequence charSequence = null;
        charSequence2 = charSequence;
        charSequence1 = charSequence2;
        charSequence4 = charSequence1;
        charSequence3 = charSequence1;
        charSequence1 = charSequence;
      } 
      if (!TextUtils.isEmpty(charSequence1) || !TextUtils.isEmpty(charSequence2) || !TextUtils.isEmpty(charSequence3) || !TextUtils.isEmpty(charSequence4)) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(charSequence1))
          bundle.putString("campaign", (String)charSequence1); 
        if (!TextUtils.isEmpty(charSequence2))
          bundle.putString("source", (String)charSequence2); 
        if (!TextUtils.isEmpty(charSequence3))
          bundle.putString("medium", (String)charSequence3); 
        if (!TextUtils.isEmpty(charSequence4))
          bundle.putString("gclid", (String)charSequence4); 
        charSequence2 = paramUri.getQueryParameter("utm_term");
        if (!TextUtils.isEmpty(charSequence2))
          bundle.putString("term", (String)charSequence2); 
        charSequence2 = paramUri.getQueryParameter("utm_content");
        if (!TextUtils.isEmpty(charSequence2))
          bundle.putString("content", (String)charSequence2); 
        charSequence2 = paramUri.getQueryParameter("aclid");
        if (!TextUtils.isEmpty(charSequence2))
          bundle.putString("aclid", (String)charSequence2); 
        charSequence2 = paramUri.getQueryParameter("cp1");
        if (!TextUtils.isEmpty(charSequence2))
          bundle.putString("cp1", (String)charSequence2); 
        String str = paramUri.getQueryParameter("anid");
        if (!TextUtils.isEmpty(str))
          bundle.putString("anid", str); 
        return bundle;
      } 
      return null;
    } catch (UnsupportedOperationException unsupportedOperationException) {
      super.zzad().zzdd().zza("Install referrer url isn't a hierarchical URI", unsupportedOperationException);
      return null;
    } 
  }
  
  final Bundle zza(String paramString1, String paramString2, Bundle paramBundle, @Nullable List<String> paramList, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_3
    //   1: ifnull -> 662
    //   4: new android/os/Bundle
    //   7: dup
    //   8: aload_3
    //   9: invokespecial <init> : (Landroid/os/Bundle;)V
    //   12: astore #7
    //   14: aload_0
    //   15: invokevirtual zzaf : ()Lcom/google/android/gms/measurement/internal/zzt;
    //   18: aload_1
    //   19: getstatic com/google/android/gms/measurement/internal/zzal.zziy : Lcom/google/android/gms/measurement/internal/zzal$zza;
    //   22: invokevirtual zze : (Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzal$zza;)Z
    //   25: ifeq -> 44
    //   28: new java/util/TreeSet
    //   31: dup
    //   32: aload_3
    //   33: invokevirtual keySet : ()Ljava/util/Set;
    //   36: invokespecial <init> : (Ljava/util/Collection;)V
    //   39: astore #8
    //   41: goto -> 50
    //   44: aload_3
    //   45: invokevirtual keySet : ()Ljava/util/Set;
    //   48: astore #8
    //   50: aload #8
    //   52: invokeinterface iterator : ()Ljava/util/Iterator;
    //   57: astore #9
    //   59: iconst_0
    //   60: istore #10
    //   62: aload #7
    //   64: astore #8
    //   66: aload #9
    //   68: invokeinterface hasNext : ()Z
    //   73: ifeq -> 665
    //   76: aload #9
    //   78: invokeinterface next : ()Ljava/lang/Object;
    //   83: checkcast java/lang/String
    //   86: astore #8
    //   88: aload #4
    //   90: ifnull -> 114
    //   93: aload #4
    //   95: aload #8
    //   97: invokeinterface contains : (Ljava/lang/Object;)Z
    //   102: ifne -> 108
    //   105: goto -> 114
    //   108: iconst_0
    //   109: istore #11
    //   111: goto -> 259
    //   114: bipush #14
    //   116: istore #12
    //   118: iload #5
    //   120: ifeq -> 187
    //   123: aload_0
    //   124: ldc_w 'event param'
    //   127: aload #8
    //   129: invokevirtual zzp : (Ljava/lang/String;Ljava/lang/String;)Z
    //   132: ifne -> 141
    //   135: iconst_3
    //   136: istore #11
    //   138: goto -> 190
    //   141: aload_0
    //   142: ldc_w 'event param'
    //   145: aconst_null
    //   146: aload #8
    //   148: invokevirtual zza : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Z
    //   151: ifne -> 161
    //   154: bipush #14
    //   156: istore #11
    //   158: goto -> 190
    //   161: aload_0
    //   162: ldc_w 'event param'
    //   165: bipush #40
    //   167: aload #8
    //   169: invokevirtual zza : (Ljava/lang/String;ILjava/lang/String;)Z
    //   172: ifne -> 181
    //   175: iconst_3
    //   176: istore #11
    //   178: goto -> 190
    //   181: iconst_0
    //   182: istore #11
    //   184: goto -> 190
    //   187: iconst_0
    //   188: istore #11
    //   190: iload #11
    //   192: ifne -> 259
    //   195: aload_0
    //   196: ldc_w 'event param'
    //   199: aload #8
    //   201: invokespecial zzq : (Ljava/lang/String;Ljava/lang/String;)Z
    //   204: ifne -> 213
    //   207: iconst_3
    //   208: istore #11
    //   210: goto -> 259
    //   213: aload_0
    //   214: ldc_w 'event param'
    //   217: aconst_null
    //   218: aload #8
    //   220: invokevirtual zza : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Z
    //   223: ifne -> 233
    //   226: iload #12
    //   228: istore #11
    //   230: goto -> 259
    //   233: aload_0
    //   234: ldc_w 'event param'
    //   237: bipush #40
    //   239: aload #8
    //   241: invokevirtual zza : (Ljava/lang/String;ILjava/lang/String;)Z
    //   244: ifne -> 253
    //   247: iconst_3
    //   248: istore #11
    //   250: goto -> 259
    //   253: iconst_0
    //   254: istore #11
    //   256: goto -> 259
    //   259: iload #11
    //   261: ifeq -> 313
    //   264: aload #7
    //   266: iload #11
    //   268: invokestatic zza : (Landroid/os/Bundle;I)Z
    //   271: ifeq -> 303
    //   274: aload #7
    //   276: ldc_w '_ev'
    //   279: aload #8
    //   281: bipush #40
    //   283: iconst_1
    //   284: invokestatic zza : (Ljava/lang/String;IZ)Ljava/lang/String;
    //   287: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   290: iload #11
    //   292: iconst_3
    //   293: if_icmpne -> 303
    //   296: aload #7
    //   298: aload #8
    //   300: invokestatic zzb : (Landroid/os/Bundle;Ljava/lang/Object;)V
    //   303: aload #7
    //   305: aload #8
    //   307: invokevirtual remove : (Ljava/lang/String;)V
    //   310: goto -> 563
    //   313: aload_3
    //   314: aload #8
    //   316: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   319: astore #13
    //   321: aload_0
    //   322: invokevirtual zzq : ()V
    //   325: iload #6
    //   327: ifeq -> 425
    //   330: aload #13
    //   332: instanceof [Landroid/os/Parcelable;
    //   335: ifeq -> 349
    //   338: aload #13
    //   340: checkcast [Landroid/os/Parcelable;
    //   343: arraylength
    //   344: istore #11
    //   346: goto -> 367
    //   349: aload #13
    //   351: instanceof java/util/ArrayList
    //   354: ifeq -> 410
    //   357: aload #13
    //   359: checkcast java/util/ArrayList
    //   362: invokevirtual size : ()I
    //   365: istore #11
    //   367: iload #11
    //   369: sipush #1000
    //   372: if_icmple -> 404
    //   375: aload_0
    //   376: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   379: invokevirtual zzdd : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   382: ldc_w 'Parameter array is too long; discarded. Value kind, name, array length'
    //   385: ldc_w 'param'
    //   388: aload #8
    //   390: iload #11
    //   392: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   395: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   398: iconst_0
    //   399: istore #11
    //   401: goto -> 413
    //   404: iconst_1
    //   405: istore #11
    //   407: goto -> 413
    //   410: iconst_1
    //   411: istore #11
    //   413: iload #11
    //   415: ifne -> 425
    //   418: bipush #17
    //   420: istore #11
    //   422: goto -> 503
    //   425: aload_0
    //   426: invokevirtual zzaf : ()Lcom/google/android/gms/measurement/internal/zzt;
    //   429: aload_1
    //   430: invokevirtual zzn : (Ljava/lang/String;)Z
    //   433: ifeq -> 443
    //   436: aload_2
    //   437: invokestatic zzbs : (Ljava/lang/String;)Z
    //   440: ifne -> 451
    //   443: aload #8
    //   445: invokestatic zzbs : (Ljava/lang/String;)Z
    //   448: ifeq -> 472
    //   451: aload_0
    //   452: ldc_w 'param'
    //   455: aload #8
    //   457: sipush #256
    //   460: aload #13
    //   462: iload #6
    //   464: invokespecial zza : (Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;Z)Z
    //   467: istore #14
    //   469: goto -> 489
    //   472: aload_0
    //   473: ldc_w 'param'
    //   476: aload #8
    //   478: bipush #100
    //   480: aload #13
    //   482: iload #6
    //   484: invokespecial zza : (Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;Z)Z
    //   487: istore #14
    //   489: iload #14
    //   491: ifeq -> 500
    //   494: iconst_0
    //   495: istore #11
    //   497: goto -> 503
    //   500: iconst_4
    //   501: istore #11
    //   503: iload #11
    //   505: ifeq -> 566
    //   508: ldc_w '_ev'
    //   511: aload #8
    //   513: invokevirtual equals : (Ljava/lang/Object;)Z
    //   516: ifne -> 566
    //   519: aload #7
    //   521: iload #11
    //   523: invokestatic zza : (Landroid/os/Bundle;I)Z
    //   526: ifeq -> 556
    //   529: aload #7
    //   531: ldc_w '_ev'
    //   534: aload #8
    //   536: bipush #40
    //   538: iconst_1
    //   539: invokestatic zza : (Ljava/lang/String;IZ)Ljava/lang/String;
    //   542: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload #7
    //   547: aload_3
    //   548: aload #8
    //   550: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   553: invokestatic zzb : (Landroid/os/Bundle;Ljava/lang/Object;)V
    //   556: aload #7
    //   558: aload #8
    //   560: invokevirtual remove : (Ljava/lang/String;)V
    //   563: goto -> 62
    //   566: aload #8
    //   568: invokestatic zzbm : (Ljava/lang/String;)Z
    //   571: ifeq -> 659
    //   574: iinc #10, 1
    //   577: iload #10
    //   579: bipush #25
    //   581: if_icmple -> 656
    //   584: new java/lang/StringBuilder
    //   587: dup
    //   588: bipush #48
    //   590: invokespecial <init> : (I)V
    //   593: astore #13
    //   595: aload #13
    //   597: ldc_w 'Event can't contain more than 25 params'
    //   600: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload #13
    //   606: invokevirtual toString : ()Ljava/lang/String;
    //   609: astore #13
    //   611: aload_0
    //   612: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   615: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   618: aload #13
    //   620: aload_0
    //   621: invokevirtual zzaa : ()Lcom/google/android/gms/measurement/internal/zzas;
    //   624: aload_2
    //   625: invokevirtual zzal : (Ljava/lang/String;)Ljava/lang/String;
    //   628: aload_0
    //   629: invokevirtual zzaa : ()Lcom/google/android/gms/measurement/internal/zzas;
    //   632: aload_3
    //   633: invokevirtual zzc : (Landroid/os/Bundle;)Ljava/lang/String;
    //   636: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   639: aload #7
    //   641: iconst_5
    //   642: invokestatic zza : (Landroid/os/Bundle;I)Z
    //   645: pop
    //   646: aload #7
    //   648: aload #8
    //   650: invokevirtual remove : (Ljava/lang/String;)V
    //   653: goto -> 62
    //   656: goto -> 659
    //   659: goto -> 62
    //   662: aconst_null
    //   663: astore #8
    //   665: aload #8
    //   667: areturn
  }
  
  final zzaj zza(String paramString1, String paramString2, Bundle paramBundle, String paramString3, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
    if (TextUtils.isEmpty(paramString2))
      return null; 
    if (zzbn(paramString2) == 0) {
      if (paramBundle != null) {
        paramBundle = new Bundle(paramBundle);
      } else {
        paramBundle = new Bundle();
      } 
      paramBundle.putString("_o", paramString3);
      return new zzaj(paramString2, new zzag(zzg(zza(paramString1, paramString2, paramBundle, CollectionUtils.listOf("_o"), false, false))), paramString3, paramLong);
    } 
    super.zzad().zzda().zza("Invalid conditional property event name", super.zzaa().zzan(paramString2));
    throw new IllegalArgumentException();
  }
  
  public final void zza(int paramInt1, String paramString1, String paramString2, int paramInt2) {
    zza((String)null, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  final void zza(Bundle paramBundle, String paramString, Object paramObject) {
    if (paramBundle == null)
      return; 
    if (paramObject instanceof Long) {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      return;
    } 
    if (paramObject instanceof String) {
      paramBundle.putString(paramString, String.valueOf(paramObject));
      return;
    } 
    if (paramObject instanceof Double) {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    } 
    if (paramString != null) {
      if (paramObject != null) {
        String str = paramObject.getClass().getSimpleName();
      } else {
        paramBundle = null;
      } 
      super.zzad().zzdf().zza("Not putting event parameter. Invalid value type. name, type", super.zzaa().zzam(paramString), paramBundle);
    } 
  }
  
  public final void zza(zzq paramzzq, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("r", paramInt);
    try {
      paramzzq.zzb(bundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning int value to wrapper", remoteException);
      return;
    } 
  }
  
  public final void zza(zzq paramzzq, long paramLong) {
    Bundle bundle = new Bundle();
    bundle.putLong("r", paramLong);
    try {
      paramzzq.zzb(bundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning long value to wrapper", remoteException);
      return;
    } 
  }
  
  public final void zza(zzq paramzzq, Bundle paramBundle) {
    try {
      paramzzq.zzb(paramBundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning bundle value to wrapper", remoteException);
      return;
    } 
  }
  
  public final void zza(zzq paramzzq, ArrayList<Bundle> paramArrayList) {
    Bundle bundle = new Bundle();
    bundle.putParcelableArrayList("r", paramArrayList);
    try {
      paramzzq.zzb(bundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning bundle list to wrapper", remoteException);
      return;
    } 
  }
  
  public final void zza(zzq paramzzq, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("r", paramBoolean);
    try {
      paramzzq.zzb(bundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning boolean value to wrapper", remoteException);
      return;
    } 
  }
  
  public final void zza(zzq paramzzq, byte[] paramArrayOfbyte) {
    Bundle bundle = new Bundle();
    bundle.putByteArray("r", paramArrayOfbyte);
    try {
      paramzzq.zzb(bundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning byte array to wrapper", remoteException);
      return;
    } 
  }
  
  final void zza(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {
    Bundle bundle = new Bundle();
    zza(bundle, paramInt1);
    if (super.zzaf().zze(paramString1, zzal.zzis)) {
      if (!TextUtils.isEmpty(paramString2) && !TextUtils.isEmpty(paramString3))
        bundle.putString(paramString2, paramString3); 
    } else if (!TextUtils.isEmpty(paramString2)) {
      bundle.putString(paramString2, paramString3);
    } 
    if (paramInt1 == 6 || paramInt1 == 7 || paramInt1 == 2)
      bundle.putLong("_el", paramInt2); 
    this.zzl.zzag();
    this.zzl.zzs().logEvent("auto", "_err", bundle);
  }
  
  final boolean zza(String paramString1, int paramInt, String paramString2) {
    if (paramString2 == null) {
      super.zzad().zzda().zza("Name is required and can't be null. Type", paramString1);
      return false;
    } 
    if (paramString2.codePointCount(0, paramString2.length()) > paramInt) {
      super.zzad().zzda().zza("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      return false;
    } 
    return true;
  }
  
  final boolean zza(String paramString1, String[] paramArrayOfString, String paramString2) {
    if (paramString2 == null) {
      super.zzad().zzda().zza("Name is required and can't be null. Type", paramString1);
      return false;
    } 
    Preconditions.checkNotNull(paramString2);
    String[] arrayOfString = zztb;
    int i = arrayOfString.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        if (paramString2.startsWith(arrayOfString[b])) {
          b = 1;
          break;
        } 
        b++;
        continue;
      } 
      b = 0;
      break;
    } 
    if (b != 0) {
      super.zzad().zzda().zza("Name starts with reserved prefix. Type, name", paramString1, paramString2);
      return false;
    } 
    if (paramArrayOfString != null) {
      Preconditions.checkNotNull(paramArrayOfString);
      i = paramArrayOfString.length;
      b = 0;
      while (true) {
        if (b < i) {
          if (zzs(paramString2, paramArrayOfString[b])) {
            b = 1;
            break;
          } 
          b++;
          continue;
        } 
        b = 0;
        break;
      } 
      if (b != 0) {
        super.zzad().zzda().zza("Name is reserved. Type, name", paramString1, paramString2);
        return false;
      } 
    } 
    return true;
  }
  
  protected final boolean zzak() {
    return true;
  }
  
  @WorkerThread
  protected final void zzal() {
    super.zzq();
    SecureRandom secureRandom = new SecureRandom();
    long l1 = secureRandom.nextLong();
    long l2 = l1;
    if (l1 == 0L) {
      l1 = secureRandom.nextLong();
      l2 = l1;
      if (l1 == 0L) {
        super.zzad().zzdd().zzaq("Utils falling back to Random for random id");
        l2 = l1;
      } 
    } 
    this.zztd.set(l2);
  }
  
  final Object zzb(String paramString, Object paramObject) {
    boolean bool = "_ev".equals(paramString);
    char c = 'Ā';
    if (bool)
      return zza(256, paramObject, true); 
    if (!zzbs(paramString))
      c = 'd'; 
    return zza(c, paramObject, false);
  }
  
  @WorkerThread
  final void zzb(Bundle paramBundle, long paramLong) {
    long l = paramBundle.getLong("_et");
    if (l != 0L)
      super.zzad().zzdd().zza("Params already contained engagement", Long.valueOf(l)); 
    paramBundle.putLong("_et", paramLong + l);
  }
  
  public final void zzb(zzq paramzzq, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("r", paramString);
    try {
      paramzzq.zzb(bundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning string value to wrapper", remoteException);
      return;
    } 
  }
  
  final int zzbn(String paramString) {
    return !zzq("event", paramString) ? 2 : (!zza("event", zzcx.zzoy, paramString) ? 13 : (!zza("event", 40, paramString) ? 2 : 0));
  }
  
  final int zzbo(String paramString) {
    return !zzq("user property", paramString) ? 6 : (!zza("user property", zzcz.zzpc, paramString) ? 15 : (!zza("user property", 24, paramString) ? 6 : 0));
  }
  
  @WorkerThread
  final boolean zzbr(String paramString) {
    super.zzq();
    if (Wrappers.packageManager(super.getContext()).checkCallingOrSelfPermission(paramString) == 0)
      return true; 
    super.zzad().zzdh().zza("Permission not granted", paramString);
    return false;
  }
  
  final boolean zzbt(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    String str = super.zzaf().zzbu();
    super.zzag();
    return str.equals(paramString);
  }
  
  final int zzc(String paramString, Object paramObject) {
    boolean bool;
    if ("_ldl".equals(paramString)) {
      bool = zza("user property referrer", paramString, zzbq(paramString), paramObject, false);
    } else {
      bool = zza("user property", paramString, zzbq(paramString), paramObject, false);
    } 
    return bool ? 0 : 7;
  }
  
  @WorkerThread
  final long zzc(Context paramContext, String paramString) {
    super.zzq();
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotEmpty(paramString);
    PackageManager packageManager = paramContext.getPackageManager();
    MessageDigest messageDigest = getMessageDigest();
    long l = -1L;
    if (messageDigest == null) {
      super.zzad().zzda().zzaq("Could not get MD5 instance");
    } else {
      if (packageManager != null) {
        try {
          if (!zzd(paramContext, paramString)) {
            PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo(super.getContext().getPackageName(), 64);
            if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
              l = zzd(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
            } else {
              super.zzad().zzdd().zzaq("Could not get signatures");
            } 
          } else {
            l = 0L;
          } 
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
          super.zzad().zzda().zza("Package name not found", nameNotFoundException);
          l = 0L;
        } 
        return l;
      } 
      l = 0L;
    } 
    return l;
  }
  
  public final int zzd(int paramInt) {
    return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(super.getContext(), 12451000);
  }
  
  final Object zzd(String paramString, Object paramObject) {
    return "_ldl".equals(paramString) ? zza(zzbq(paramString), paramObject, true) : zza(zzbq(paramString), paramObject, false);
  }
  
  final Bundle zzg(Bundle paramBundle) {
    Bundle bundle = new Bundle();
    if (paramBundle != null)
      for (String str : paramBundle.keySet()) {
        Object object = zzb(str, paramBundle.get(str));
        if (object == null) {
          super.zzad().zzdd().zza("Param value can't be null", super.zzaa().zzam(str));
          continue;
        } 
        zza(bundle, str, object);
      }  
    return bundle;
  }
  
  public final long zzgk() {
    if (this.zztd.get() == 0L)
      synchronized (this.zztd) {
        Random random = new Random();
        this(System.nanoTime() ^ super.zzz().currentTimeMillis());
        long l1 = random.nextLong();
        int i = this.zzae + 1;
        this.zzae = i;
        long l2 = i;
        return l1 + l2;
      }  
    synchronized (this.zztd) {
      this.zztd.compareAndSet(-1L, 1L);
      return this.zztd.getAndIncrement();
    } 
  }
  
  @WorkerThread
  final SecureRandom zzgl() {
    super.zzq();
    if (this.zztc == null)
      this.zztc = new SecureRandom(); 
    return this.zztc;
  }
  
  public final int zzgm() {
    if (this.zzte == null)
      this.zzte = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(super.getContext()) / 1000); 
    return this.zzte.intValue();
  }
  
  @WorkerThread
  final String zzgn() {
    byte[] arrayOfByte = new byte[16];
    zzgl().nextBytes(arrayOfByte);
    return String.format(Locale.US, "%032x", new Object[] { new BigInteger(1, arrayOfByte) });
  }
  
  final boolean zzp(String paramString1, String paramString2) {
    if (paramString2 == null) {
      super.zzad().zzda().zza("Name is required and can't be null. Type", paramString1);
      return false;
    } 
    if (paramString2.length() == 0) {
      super.zzad().zzda().zza("Name is required and can't be empty. Type", paramString1);
      return false;
    } 
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i)) {
      super.zzad().zzda().zza("Name must start with a letter. Type, name", paramString1, paramString2);
      return false;
    } 
    int j = paramString2.length();
    for (i = Character.charCount(i); i < j; i += Character.charCount(k)) {
      int k = paramString2.codePointAt(i);
      if (k != 95 && !Character.isLetterOrDigit(k)) {
        super.zzad().zzda().zza("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      } 
    } 
    return true;
  }
  
  final boolean zzr(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (!zzbp(paramString1)) {
        if (this.zzl.zzel())
          super.zzad().zzda().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzau.zzao(paramString1)); 
        return false;
      } 
    } else {
      if (!TextUtils.isEmpty(paramString2)) {
        if (!zzbp(paramString2)) {
          super.zzad().zzda().zza("Invalid admob_app_id. Analytics disabled.", zzau.zzao(paramString2));
          return false;
        } 
        return true;
      } 
      if (this.zzl.zzel())
        super.zzad().zzda().zzaq("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI"); 
      return false;
    } 
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */