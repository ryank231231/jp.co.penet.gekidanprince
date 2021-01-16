package android.support.v4.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.annotation.GuardedBy;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FontsContractCompat {
  private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static final String PARCEL_FONT_RESULTS = "font_results";
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
  
  private static final String TAG = "FontsContractCompat";
  
  private static final SelfDestructiveThread sBackgroundThread;
  
  private static final Comparator<byte[]> sByteArrayComparator;
  
  private static final Object sLock;
  
  @GuardedBy("sLock")
  private static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies;
  
  private static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);
  
  static {
    sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    sLock = new Object();
    sPendingReplies = new SimpleArrayMap();
    sByteArrayComparator = new Comparator<byte[]>() {
        public int compare(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
          if (param1ArrayOfbyte1.length != param1ArrayOfbyte2.length)
            return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length; 
          for (byte b = 0; b < param1ArrayOfbyte1.length; b++) {
            if (param1ArrayOfbyte1[b] != param1ArrayOfbyte2[b])
              return param1ArrayOfbyte1[b] - param1ArrayOfbyte2[b]; 
          } 
          return 0;
        }
      };
  }
  
  @Nullable
  public static Typeface buildTypeface(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontInfo[] paramArrayOfFontInfo) {
    return TypefaceCompat.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, 0);
  }
  
  private static List<byte[]> convertToByteArrayList(Signature[] paramArrayOfSignature) {
    ArrayList<byte[]> arrayList = new ArrayList();
    for (byte b = 0; b < paramArrayOfSignature.length; b++)
      arrayList.add(paramArrayOfSignature[b].toByteArray()); 
    return (List<byte[]>)arrayList;
  }
  
  private static boolean equalsByteArrayList(List<byte[]> paramList1, List<byte[]> paramList2) {
    if (paramList1.size() != paramList2.size())
      return false; 
    for (byte b = 0; b < paramList1.size(); b++) {
      if (!Arrays.equals(paramList1.get(b), paramList2.get(b)))
        return false; 
    } 
    return true;
  }
  
  @NonNull
  public static FontFamilyResult fetchFonts(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontRequest paramFontRequest) throws PackageManager.NameNotFoundException {
    ProviderInfo providerInfo = getProvider(paramContext.getPackageManager(), paramFontRequest, paramContext.getResources());
    return (providerInfo == null) ? new FontFamilyResult(1, null) : new FontFamilyResult(0, getFontFromProvider(paramContext, paramFontRequest, providerInfo.authority, paramCancellationSignal));
  }
  
  private static List<List<byte[]>> getCertificates(FontRequest paramFontRequest, Resources paramResources) {
    return (paramFontRequest.getCertificates() != null) ? paramFontRequest.getCertificates() : FontResourcesParserCompat.readCerts(paramResources, paramFontRequest.getCertificatesArrayResId());
  }
  
  @NonNull
  @VisibleForTesting
  static FontInfo[] getFontFromProvider(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: new android/net/Uri$Builder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: ldc 'content'
    //   18: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   21: aload_2
    //   22: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   25: invokevirtual build : ()Landroid/net/Uri;
    //   28: astore #5
    //   30: new android/net/Uri$Builder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: ldc 'content'
    //   39: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   42: aload_2
    //   43: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   46: ldc 'file'
    //   48: invokevirtual appendPath : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   51: invokevirtual build : ()Landroid/net/Uri;
    //   54: astore #6
    //   56: aconst_null
    //   57: astore #7
    //   59: aload #7
    //   61: astore_2
    //   62: getstatic android/os/Build$VERSION.SDK_INT : I
    //   65: bipush #16
    //   67: if_icmple -> 160
    //   70: aload #7
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   77: astore_0
    //   78: aload #7
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual getQuery : ()Ljava/lang/String;
    //   85: astore_1
    //   86: aload #7
    //   88: astore_2
    //   89: aload_0
    //   90: aload #5
    //   92: bipush #7
    //   94: anewarray java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc_w '_id'
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: ldc_w 'file_id'
    //   108: aastore
    //   109: dup
    //   110: iconst_2
    //   111: ldc_w 'font_ttc_index'
    //   114: aastore
    //   115: dup
    //   116: iconst_3
    //   117: ldc_w 'font_variation_settings'
    //   120: aastore
    //   121: dup
    //   122: iconst_4
    //   123: ldc_w 'font_weight'
    //   126: aastore
    //   127: dup
    //   128: iconst_5
    //   129: ldc_w 'font_italic'
    //   132: aastore
    //   133: dup
    //   134: bipush #6
    //   136: ldc_w 'result_code'
    //   139: aastore
    //   140: ldc_w 'query = ?'
    //   143: iconst_1
    //   144: anewarray java/lang/String
    //   147: dup
    //   148: iconst_0
    //   149: aload_1
    //   150: aastore
    //   151: aconst_null
    //   152: aload_3
    //   153: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   156: astore_0
    //   157: goto -> 246
    //   160: aload #7
    //   162: astore_2
    //   163: aload_0
    //   164: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   167: astore_0
    //   168: aload #7
    //   170: astore_2
    //   171: aload_1
    //   172: invokevirtual getQuery : ()Ljava/lang/String;
    //   175: astore_1
    //   176: aload #7
    //   178: astore_2
    //   179: aload_0
    //   180: aload #5
    //   182: bipush #7
    //   184: anewarray java/lang/String
    //   187: dup
    //   188: iconst_0
    //   189: ldc_w '_id'
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: ldc_w 'file_id'
    //   198: aastore
    //   199: dup
    //   200: iconst_2
    //   201: ldc_w 'font_ttc_index'
    //   204: aastore
    //   205: dup
    //   206: iconst_3
    //   207: ldc_w 'font_variation_settings'
    //   210: aastore
    //   211: dup
    //   212: iconst_4
    //   213: ldc_w 'font_weight'
    //   216: aastore
    //   217: dup
    //   218: iconst_5
    //   219: ldc_w 'font_italic'
    //   222: aastore
    //   223: dup
    //   224: bipush #6
    //   226: ldc_w 'result_code'
    //   229: aastore
    //   230: ldc_w 'query = ?'
    //   233: iconst_1
    //   234: anewarray java/lang/String
    //   237: dup
    //   238: iconst_0
    //   239: aload_1
    //   240: aastore
    //   241: aconst_null
    //   242: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   245: astore_0
    //   246: aload #4
    //   248: astore_1
    //   249: aload_0
    //   250: ifnull -> 549
    //   253: aload #4
    //   255: astore_1
    //   256: aload_0
    //   257: astore_2
    //   258: aload_0
    //   259: invokeinterface getCount : ()I
    //   264: ifle -> 549
    //   267: aload_0
    //   268: astore_2
    //   269: aload_0
    //   270: ldc_w 'result_code'
    //   273: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   278: istore #8
    //   280: aload_0
    //   281: astore_2
    //   282: new java/util/ArrayList
    //   285: astore_3
    //   286: aload_0
    //   287: astore_2
    //   288: aload_3
    //   289: invokespecial <init> : ()V
    //   292: aload_0
    //   293: astore_2
    //   294: aload_0
    //   295: ldc_w '_id'
    //   298: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   303: istore #9
    //   305: aload_0
    //   306: astore_2
    //   307: aload_0
    //   308: ldc_w 'file_id'
    //   311: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   316: istore #10
    //   318: aload_0
    //   319: astore_2
    //   320: aload_0
    //   321: ldc_w 'font_ttc_index'
    //   324: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   329: istore #11
    //   331: aload_0
    //   332: astore_2
    //   333: aload_0
    //   334: ldc_w 'font_weight'
    //   337: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   342: istore #12
    //   344: aload_0
    //   345: astore_2
    //   346: aload_0
    //   347: ldc_w 'font_italic'
    //   350: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   355: istore #13
    //   357: aload_0
    //   358: astore_2
    //   359: aload_0
    //   360: invokeinterface moveToNext : ()Z
    //   365: ifeq -> 547
    //   368: iload #8
    //   370: iconst_m1
    //   371: if_icmpeq -> 389
    //   374: aload_0
    //   375: astore_2
    //   376: aload_0
    //   377: iload #8
    //   379: invokeinterface getInt : (I)I
    //   384: istore #14
    //   386: goto -> 392
    //   389: iconst_0
    //   390: istore #14
    //   392: iload #11
    //   394: iconst_m1
    //   395: if_icmpeq -> 413
    //   398: aload_0
    //   399: astore_2
    //   400: aload_0
    //   401: iload #11
    //   403: invokeinterface getInt : (I)I
    //   408: istore #15
    //   410: goto -> 416
    //   413: iconst_0
    //   414: istore #15
    //   416: iload #10
    //   418: iconst_m1
    //   419: if_icmpne -> 441
    //   422: aload_0
    //   423: astore_2
    //   424: aload #5
    //   426: aload_0
    //   427: iload #9
    //   429: invokeinterface getLong : (I)J
    //   434: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   437: astore_1
    //   438: goto -> 457
    //   441: aload_0
    //   442: astore_2
    //   443: aload #6
    //   445: aload_0
    //   446: iload #10
    //   448: invokeinterface getLong : (I)J
    //   453: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   456: astore_1
    //   457: iload #12
    //   459: iconst_m1
    //   460: if_icmpeq -> 478
    //   463: aload_0
    //   464: astore_2
    //   465: aload_0
    //   466: iload #12
    //   468: invokeinterface getInt : (I)I
    //   473: istore #16
    //   475: goto -> 483
    //   478: sipush #400
    //   481: istore #16
    //   483: iload #13
    //   485: iconst_m1
    //   486: if_icmpeq -> 509
    //   489: aload_0
    //   490: astore_2
    //   491: aload_0
    //   492: iload #13
    //   494: invokeinterface getInt : (I)I
    //   499: iconst_1
    //   500: if_icmpne -> 509
    //   503: iconst_1
    //   504: istore #17
    //   506: goto -> 512
    //   509: iconst_0
    //   510: istore #17
    //   512: aload_0
    //   513: astore_2
    //   514: new android/support/v4/provider/FontsContractCompat$FontInfo
    //   517: astore #4
    //   519: aload_0
    //   520: astore_2
    //   521: aload #4
    //   523: aload_1
    //   524: iload #15
    //   526: iload #16
    //   528: iload #17
    //   530: iload #14
    //   532: invokespecial <init> : (Landroid/net/Uri;IIZI)V
    //   535: aload_0
    //   536: astore_2
    //   537: aload_3
    //   538: aload #4
    //   540: invokevirtual add : (Ljava/lang/Object;)Z
    //   543: pop
    //   544: goto -> 357
    //   547: aload_3
    //   548: astore_1
    //   549: aload_0
    //   550: ifnull -> 559
    //   553: aload_0
    //   554: invokeinterface close : ()V
    //   559: aload_1
    //   560: iconst_0
    //   561: anewarray android/support/v4/provider/FontsContractCompat$FontInfo
    //   564: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   567: checkcast [Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   570: areturn
    //   571: astore_0
    //   572: aload_2
    //   573: ifnull -> 582
    //   576: aload_2
    //   577: invokeinterface close : ()V
    //   582: aload_0
    //   583: athrow
    // Exception table:
    //   from	to	target	type
    //   62	70	571	finally
    //   73	78	571	finally
    //   81	86	571	finally
    //   89	157	571	finally
    //   163	168	571	finally
    //   171	176	571	finally
    //   179	246	571	finally
    //   258	267	571	finally
    //   269	280	571	finally
    //   282	286	571	finally
    //   288	292	571	finally
    //   294	305	571	finally
    //   307	318	571	finally
    //   320	331	571	finally
    //   333	344	571	finally
    //   346	357	571	finally
    //   359	368	571	finally
    //   376	386	571	finally
    //   400	410	571	finally
    //   424	438	571	finally
    //   443	457	571	finally
    //   465	475	571	finally
    //   491	503	571	finally
    //   514	519	571	finally
    //   521	535	571	finally
    //   537	544	571	finally
  }
  
  @NonNull
  private static TypefaceResult getFontInternal(Context paramContext, FontRequest paramFontRequest, int paramInt) {
    try {
      FontFamilyResult fontFamilyResult = fetchFonts(paramContext, null, paramFontRequest);
      int i = fontFamilyResult.getStatusCode();
      byte b = -3;
      if (i == 0) {
        Typeface typeface = TypefaceCompat.createFromFontInfo(paramContext, null, fontFamilyResult.getFonts(), paramInt);
        if (typeface != null)
          b = 0; 
        return new TypefaceResult(typeface, b);
      } 
      if (fontFamilyResult.getStatusCode() == 1)
        b = -2; 
      return new TypefaceResult(null, b);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return new TypefaceResult(null, -1);
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static Typeface getFontSync(Context paramContext, final FontRequest request, @Nullable final ResourcesCompat.FontCallback fontCallback, @Nullable final Handler handler, boolean paramBoolean, int paramInt1, final int style) {
    final TypefaceResult context;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(request.getIdentifier());
    stringBuilder.append("-");
    stringBuilder.append(style);
    final String id = stringBuilder.toString();
    Typeface typeface = (Typeface)sTypefaceCache.get(str);
    if (typeface != null) {
      if (fontCallback != null)
        fontCallback.onFontRetrieved(typeface); 
      return typeface;
    } 
    if (paramBoolean && paramInt1 == -1) {
      typefaceResult = getFontInternal(paramContext, request, style);
      if (fontCallback != null)
        if (typefaceResult.mResult == 0) {
          fontCallback.callbackSuccessAsync(typefaceResult.mTypeface, handler);
        } else {
          fontCallback.callbackFailAsync(typefaceResult.mResult, handler);
        }  
      return typefaceResult.mTypeface;
    } 
    Callable<TypefaceResult> callable = new Callable<TypefaceResult>() {
        public FontsContractCompat.TypefaceResult call() throws Exception {
          FontsContractCompat.TypefaceResult typefaceResult = FontsContractCompat.getFontInternal(context, request, style);
          if (typefaceResult.mTypeface != null)
            FontsContractCompat.sTypefaceCache.put(id, typefaceResult.mTypeface); 
          return typefaceResult;
        }
      };
    if (paramBoolean)
      try {
        return ((TypefaceResult)sBackgroundThread.postAndWait((Callable)callable, paramInt1)).mTypeface;
      } catch (InterruptedException interruptedException) {
        return null;
      }  
    if (fontCallback == null) {
      typefaceResult = null;
    } else {
      null = new SelfDestructiveThread.ReplyCallback<TypefaceResult>() {
          public void onReply(FontsContractCompat.TypefaceResult param1TypefaceResult) {
            if (param1TypefaceResult == null) {
              fontCallback.callbackFailAsync(1, handler);
            } else if (param1TypefaceResult.mResult == 0) {
              fontCallback.callbackSuccessAsync(param1TypefaceResult.mTypeface, handler);
            } else {
              fontCallback.callbackFailAsync(param1TypefaceResult.mResult, handler);
            } 
          }
        };
    } 
    synchronized (sLock) {
      if (sPendingReplies.containsKey(str)) {
        if (null != null)
          ((ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>)sPendingReplies.get(str)).add(null); 
        return null;
      } 
      if (null != null) {
        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = new ArrayList();
        this();
        arrayList.add(null);
        sPendingReplies.put(str, arrayList);
      } 
      sBackgroundThread.postAndReply(callable, new SelfDestructiveThread.ReplyCallback<TypefaceResult>() {
            public void onReply(FontsContractCompat.TypefaceResult param1TypefaceResult) {
              synchronized (FontsContractCompat.sLock) {
                ArrayList<SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>> arrayList = (ArrayList)FontsContractCompat.sPendingReplies.get(id);
                if (arrayList == null)
                  return; 
                FontsContractCompat.sPendingReplies.remove(id);
                for (byte b = 0; b < arrayList.size(); b++)
                  ((SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>)arrayList.get(b)).onReply(param1TypefaceResult); 
                return;
              } 
            }
          });
      return null;
    } 
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  public static ProviderInfo getProvider(@NonNull PackageManager paramPackageManager, @NonNull FontRequest paramFontRequest, @Nullable Resources paramResources) throws PackageManager.NameNotFoundException {
    String str = paramFontRequest.getProviderAuthority();
    byte b = 0;
    ProviderInfo providerInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (providerInfo != null) {
      List<List<byte[]>> list;
      if (providerInfo.packageName.equals(paramFontRequest.getProviderPackage())) {
        List<byte[]> list1 = convertToByteArrayList((paramPackageManager.getPackageInfo(providerInfo.packageName, 64)).signatures);
        Collections.sort((List)list1, (Comparator)sByteArrayComparator);
        list = getCertificates(paramFontRequest, paramResources);
        while (b < list.size()) {
          ArrayList<byte> arrayList = new ArrayList(list.get(b));
          Collections.sort(arrayList, (Comparator)sByteArrayComparator);
          if (equalsByteArrayList(list1, (List)arrayList))
            return providerInfo; 
          b++;
        } 
        return null;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Found content provider ");
      stringBuilder1.append(str);
      stringBuilder1.append(", but package was not ");
      stringBuilder1.append(list.getProviderPackage());
      throw new PackageManager.NameNotFoundException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No package found for authority: ");
    stringBuilder.append(str);
    throw new PackageManager.NameNotFoundException(stringBuilder.toString());
  }
  
  @RequiresApi(19)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static Map<Uri, ByteBuffer> prepareFontData(Context paramContext, FontInfo[] paramArrayOfFontInfo, CancellationSignal paramCancellationSignal) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = paramArrayOfFontInfo.length;
    for (byte b = 0; b < i; b++) {
      FontInfo fontInfo = paramArrayOfFontInfo[b];
      if (fontInfo.getResultCode() == 0) {
        Uri uri = fontInfo.getUri();
        if (!hashMap.containsKey(uri))
          hashMap.put(uri, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, uri)); 
      } 
    } 
    return (Map)Collections.unmodifiableMap(hashMap);
  }
  
  public static void requestFont(@NonNull final Context context, @NonNull final FontRequest request, @NonNull final FontRequestCallback callback, @NonNull Handler paramHandler) {
    paramHandler.post(new Runnable() {
          public void run() {
            try {
              FontsContractCompat.FontFamilyResult fontFamilyResult = FontsContractCompat.fetchFonts(context, null, request);
              if (fontFamilyResult.getStatusCode() != 0) {
                switch (fontFamilyResult.getStatusCode()) {
                  default:
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(-3);
                          }
                        });
                    return;
                  case 2:
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(-3);
                          }
                        });
                    return;
                  case 1:
                    break;
                } 
                callerThreadHandler.post(new Runnable() {
                      public void run() {
                        callback.onTypefaceRequestFailed(-2);
                      }
                    });
                return;
              } 
              FontsContractCompat.FontInfo[] arrayOfFontInfo = fontFamilyResult.getFonts();
              if (arrayOfFontInfo == null || arrayOfFontInfo.length == 0) {
                callerThreadHandler.post(new Runnable() {
                      public void run() {
                        callback.onTypefaceRequestFailed(1);
                      }
                    });
                return;
              } 
              int i = arrayOfFontInfo.length;
              for (final int resultCode = 0; j < i; j++) {
                FontsContractCompat.FontInfo fontInfo = arrayOfFontInfo[j];
                if (fontInfo.getResultCode() != 0) {
                  j = fontInfo.getResultCode();
                  if (j < 0) {
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(-3);
                          }
                        });
                  } else {
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(resultCode);
                          }
                        });
                  } 
                  return;
                } 
              } 
              final Typeface typeface = FontsContractCompat.buildTypeface(context, null, arrayOfFontInfo);
              if (typeface == null) {
                callerThreadHandler.post(new Runnable() {
                      public void run() {
                        callback.onTypefaceRequestFailed(-3);
                      }
                    });
                return;
              } 
              callerThreadHandler.post(new Runnable() {
                    public void run() {
                      callback.onTypefaceRetrieved(typeface);
                    }
                  });
              return;
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
              callerThreadHandler.post(new Runnable() {
                    public void run() {
                      callback.onTypefaceRequestFailed(-1);
                    }
                  });
              return;
            } 
          }
        });
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static void resetCache() {
    sTypefaceCache.evictAll();
  }
  
  public static final class Columns implements BaseColumns {
    public static final String FILE_ID = "file_id";
    
    public static final String ITALIC = "font_italic";
    
    public static final String RESULT_CODE = "result_code";
    
    public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
    
    public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
    
    public static final int RESULT_CODE_MALFORMED_QUERY = 3;
    
    public static final int RESULT_CODE_OK = 0;
    
    public static final String TTC_INDEX = "font_ttc_index";
    
    public static final String VARIATION_SETTINGS = "font_variation_settings";
    
    public static final String WEIGHT = "font_weight";
  }
  
  public static class FontFamilyResult {
    public static final int STATUS_OK = 0;
    
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    
    private final FontsContractCompat.FontInfo[] mFonts;
    
    private final int mStatusCode;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FontFamilyResult(int param1Int, @Nullable FontsContractCompat.FontInfo[] param1ArrayOfFontInfo) {
      this.mStatusCode = param1Int;
      this.mFonts = param1ArrayOfFontInfo;
    }
    
    public FontsContractCompat.FontInfo[] getFonts() {
      return this.mFonts;
    }
    
    public int getStatusCode() {
      return this.mStatusCode;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static @interface FontResultStatus {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  static @interface FontResultStatus {}
  
  public static class FontInfo {
    private final boolean mItalic;
    
    private final int mResultCode;
    
    private final int mTtcIndex;
    
    private final Uri mUri;
    
    private final int mWeight;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FontInfo(@NonNull Uri param1Uri, @IntRange(from = 0L) int param1Int1, @IntRange(from = 1L, to = 1000L) int param1Int2, boolean param1Boolean, int param1Int3) {
      this.mUri = (Uri)Preconditions.checkNotNull(param1Uri);
      this.mTtcIndex = param1Int1;
      this.mWeight = param1Int2;
      this.mItalic = param1Boolean;
      this.mResultCode = param1Int3;
    }
    
    public int getResultCode() {
      return this.mResultCode;
    }
    
    @IntRange(from = 0L)
    public int getTtcIndex() {
      return this.mTtcIndex;
    }
    
    @NonNull
    public Uri getUri() {
      return this.mUri;
    }
    
    @IntRange(from = 1L, to = 1000L)
    public int getWeight() {
      return this.mWeight;
    }
    
    public boolean isItalic() {
      return this.mItalic;
    }
  }
  
  public static class FontRequestCallback {
    public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
    
    public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
    
    public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
    
    public static final int FAIL_REASON_MALFORMED_QUERY = 3;
    
    public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
    
    public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
    
    public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int RESULT_OK = 0;
    
    public void onTypefaceRequestFailed(int param1Int) {}
    
    public void onTypefaceRetrieved(Typeface param1Typeface) {}
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static @interface FontRequestFailReason {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface FontRequestFailReason {}
  
  private static final class TypefaceResult {
    final int mResult;
    
    final Typeface mTypeface;
    
    TypefaceResult(@Nullable Typeface param1Typeface, int param1Int) {
      this.mTypeface = param1Typeface;
      this.mResult = param1Int;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\provider\FontsContractCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */