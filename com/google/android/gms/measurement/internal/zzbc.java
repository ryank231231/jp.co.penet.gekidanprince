package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

@WorkerThread
final class zzbc implements Runnable {
  private final String packageName;
  
  private final URL url;
  
  private final byte[] zzko;
  
  private final zzba zzkp;
  
  private final Map<String, String> zzkq;
  
  public zzbc(zzay paramzzay, String paramString, URL paramURL, byte[] paramArrayOfbyte, Map<String, String> paramMap, zzba paramzzba) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramURL);
    Preconditions.checkNotNull(paramzzba);
    this.url = paramURL;
    this.zzko = paramArrayOfbyte;
    this.zzkp = paramzzba;
    this.packageName = paramString;
    this.zzkq = paramMap;
  }
  
  public final void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   4: invokevirtual zzp : ()V
    //   7: aconst_null
    //   8: astore_1
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore #4
    //   16: aload_0
    //   17: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   20: aload_0
    //   21: getfield url : Ljava/net/URL;
    //   24: invokevirtual zza : (Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   27: astore #5
    //   29: aload_0
    //   30: getfield zzkq : Ljava/util/Map;
    //   33: ifnull -> 102
    //   36: aload_0
    //   37: getfield zzkq : Ljava/util/Map;
    //   40: invokeinterface entrySet : ()Ljava/util/Set;
    //   45: invokeinterface iterator : ()Ljava/util/Iterator;
    //   50: astore #6
    //   52: aload #6
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 102
    //   62: aload #6
    //   64: invokeinterface next : ()Ljava/lang/Object;
    //   69: checkcast java/util/Map$Entry
    //   72: astore #7
    //   74: aload #5
    //   76: aload #7
    //   78: invokeinterface getKey : ()Ljava/lang/Object;
    //   83: checkcast java/lang/String
    //   86: aload #7
    //   88: invokeinterface getValue : ()Ljava/lang/Object;
    //   93: checkcast java/lang/String
    //   96: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   99: goto -> 52
    //   102: aload_0
    //   103: getfield zzko : [B
    //   106: ifnull -> 210
    //   109: aload_0
    //   110: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   113: invokevirtual zzdm : ()Lcom/google/android/gms/measurement/internal/zzfz;
    //   116: aload_0
    //   117: getfield zzko : [B
    //   120: invokevirtual zzc : ([B)[B
    //   123: astore #6
    //   125: aload_0
    //   126: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   129: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   132: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   135: ldc 'Uploading data. size'
    //   137: aload #6
    //   139: arraylength
    //   140: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   143: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   146: aload #5
    //   148: iconst_1
    //   149: invokevirtual setDoOutput : (Z)V
    //   152: aload #5
    //   154: ldc 'Content-Encoding'
    //   156: ldc 'gzip'
    //   158: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload #5
    //   163: aload #6
    //   165: arraylength
    //   166: invokevirtual setFixedLengthStreamingMode : (I)V
    //   169: aload #5
    //   171: invokevirtual connect : ()V
    //   174: aload #5
    //   176: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   179: astore #7
    //   181: aload #7
    //   183: aload #6
    //   185: invokevirtual write : ([B)V
    //   188: aload #7
    //   190: invokevirtual close : ()V
    //   193: goto -> 210
    //   196: astore_2
    //   197: aload #5
    //   199: astore_1
    //   200: aload_2
    //   201: astore #5
    //   203: goto -> 349
    //   206: astore_1
    //   207: goto -> 447
    //   210: aload #5
    //   212: invokevirtual getResponseCode : ()I
    //   215: istore #8
    //   217: aload #5
    //   219: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   222: astore #7
    //   224: aload_0
    //   225: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   228: aload #5
    //   230: invokestatic zza : (Lcom/google/android/gms/measurement/internal/zzay;Ljava/net/HttpURLConnection;)[B
    //   233: astore_2
    //   234: aload #5
    //   236: ifnull -> 244
    //   239: aload #5
    //   241: invokevirtual disconnect : ()V
    //   244: aload_0
    //   245: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   248: invokevirtual zzac : ()Lcom/google/android/gms/measurement/internal/zzbt;
    //   251: new com/google/android/gms/measurement/internal/zzbb
    //   254: dup
    //   255: aload_0
    //   256: getfield packageName : Ljava/lang/String;
    //   259: aload_0
    //   260: getfield zzkp : Lcom/google/android/gms/measurement/internal/zzba;
    //   263: iload #8
    //   265: aconst_null
    //   266: aload_2
    //   267: aload #7
    //   269: aconst_null
    //   270: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzba;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/measurement/internal/zzaz;)V
    //   273: invokevirtual zza : (Ljava/lang/Runnable;)V
    //   276: return
    //   277: astore_2
    //   278: aload_1
    //   279: astore_3
    //   280: aload #5
    //   282: astore_1
    //   283: aload_2
    //   284: astore #5
    //   286: aload #7
    //   288: astore_2
    //   289: goto -> 357
    //   292: astore_1
    //   293: goto -> 316
    //   296: astore #7
    //   298: aconst_null
    //   299: astore_2
    //   300: aload_1
    //   301: astore_3
    //   302: aload #5
    //   304: astore_1
    //   305: aload #7
    //   307: astore #5
    //   309: goto -> 357
    //   312: astore_1
    //   313: aconst_null
    //   314: astore #7
    //   316: aload #7
    //   318: astore_2
    //   319: goto -> 455
    //   322: astore_2
    //   323: aload #4
    //   325: astore #7
    //   327: aload #5
    //   329: astore_1
    //   330: aload_2
    //   331: astore #5
    //   333: goto -> 349
    //   336: astore #7
    //   338: goto -> 441
    //   341: astore #5
    //   343: aconst_null
    //   344: astore_1
    //   345: aload #4
    //   347: astore #7
    //   349: aconst_null
    //   350: astore_2
    //   351: iconst_0
    //   352: istore #8
    //   354: aload #7
    //   356: astore_3
    //   357: aload_3
    //   358: ifnull -> 394
    //   361: aload_3
    //   362: invokevirtual close : ()V
    //   365: goto -> 394
    //   368: astore #7
    //   370: aload_0
    //   371: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   374: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   377: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   380: ldc 'Error closing HTTP compressed POST connection output stream. appId'
    //   382: aload_0
    //   383: getfield packageName : Ljava/lang/String;
    //   386: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   389: aload #7
    //   391: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   394: aload_1
    //   395: ifnull -> 402
    //   398: aload_1
    //   399: invokevirtual disconnect : ()V
    //   402: aload_0
    //   403: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   406: invokevirtual zzac : ()Lcom/google/android/gms/measurement/internal/zzbt;
    //   409: new com/google/android/gms/measurement/internal/zzbb
    //   412: dup
    //   413: aload_0
    //   414: getfield packageName : Ljava/lang/String;
    //   417: aload_0
    //   418: getfield zzkp : Lcom/google/android/gms/measurement/internal/zzba;
    //   421: iload #8
    //   423: aconst_null
    //   424: aconst_null
    //   425: aload_2
    //   426: aconst_null
    //   427: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzba;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/measurement/internal/zzaz;)V
    //   430: invokevirtual zza : (Ljava/lang/Runnable;)V
    //   433: aload #5
    //   435: athrow
    //   436: astore #7
    //   438: aconst_null
    //   439: astore #5
    //   441: aload #7
    //   443: astore_1
    //   444: aload_2
    //   445: astore #7
    //   447: aconst_null
    //   448: astore_2
    //   449: iconst_0
    //   450: istore #8
    //   452: aload #7
    //   454: astore_3
    //   455: aload_3
    //   456: ifnull -> 492
    //   459: aload_3
    //   460: invokevirtual close : ()V
    //   463: goto -> 492
    //   466: astore #7
    //   468: aload_0
    //   469: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   472: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   475: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   478: ldc 'Error closing HTTP compressed POST connection output stream. appId'
    //   480: aload_0
    //   481: getfield packageName : Ljava/lang/String;
    //   484: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   487: aload #7
    //   489: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   492: aload #5
    //   494: ifnull -> 502
    //   497: aload #5
    //   499: invokevirtual disconnect : ()V
    //   502: aload_0
    //   503: getfield zzkr : Lcom/google/android/gms/measurement/internal/zzay;
    //   506: invokevirtual zzac : ()Lcom/google/android/gms/measurement/internal/zzbt;
    //   509: new com/google/android/gms/measurement/internal/zzbb
    //   512: dup
    //   513: aload_0
    //   514: getfield packageName : Ljava/lang/String;
    //   517: aload_0
    //   518: getfield zzkp : Lcom/google/android/gms/measurement/internal/zzba;
    //   521: iload #8
    //   523: aload_1
    //   524: aconst_null
    //   525: aload_2
    //   526: aconst_null
    //   527: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzba;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/measurement/internal/zzaz;)V
    //   530: invokevirtual zza : (Ljava/lang/Runnable;)V
    //   533: return
    // Exception table:
    //   from	to	target	type
    //   16	29	436	java/io/IOException
    //   16	29	341	finally
    //   29	52	336	java/io/IOException
    //   29	52	322	finally
    //   52	99	336	java/io/IOException
    //   52	99	322	finally
    //   102	181	336	java/io/IOException
    //   102	181	322	finally
    //   181	193	206	java/io/IOException
    //   181	193	196	finally
    //   210	217	336	java/io/IOException
    //   210	217	322	finally
    //   217	224	312	java/io/IOException
    //   217	224	296	finally
    //   224	234	292	java/io/IOException
    //   224	234	277	finally
    //   361	365	368	java/io/IOException
    //   459	463	466	java/io/IOException
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */