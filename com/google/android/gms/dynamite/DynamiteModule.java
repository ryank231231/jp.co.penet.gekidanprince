package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class DynamiteModule {
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION;
  
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
  
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION;
  
  @KeepForSdk
  public static final VersionPolicy PREFER_LOCAL;
  
  @KeepForSdk
  public static final VersionPolicy PREFER_REMOTE;
  
  @GuardedBy("DynamiteModule.class")
  private static Boolean zzif;
  
  @GuardedBy("DynamiteModule.class")
  private static zzi zzig;
  
  @GuardedBy("DynamiteModule.class")
  private static zzk zzih;
  
  @GuardedBy("DynamiteModule.class")
  private static String zzii;
  
  @GuardedBy("DynamiteModule.class")
  private static int zzij = -1;
  
  private static final ThreadLocal<zza> zzik = new ThreadLocal<zza>();
  
  private static final VersionPolicy.zza zzil = new zza();
  
  private static final VersionPolicy zzim;
  
  private final Context zzin;
  
  static {
    PREFER_REMOTE = new zzb();
    PREFER_LOCAL = new zzc();
    PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
    PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    zzim = new zzg();
  }
  
  private DynamiteModule(Context paramContext) {
    this.zzin = (Context)Preconditions.checkNotNull(paramContext);
  }
  
  @KeepForSdk
  public static int getLocalVersion(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder1;
      ClassLoader classLoader = paramContext.getApplicationContext().getClassLoader();
      null = String.valueOf(paramString).length();
      StringBuilder stringBuilder2 = new StringBuilder();
      this(null + 61);
      stringBuilder2.append("com.google.android.gms.dynamite.descriptors.");
      stringBuilder2.append(paramString);
      stringBuilder2.append(".ModuleDescriptor");
      Class<?> clazz = classLoader.loadClass(stringBuilder2.toString());
      Field field1 = clazz.getDeclaredField("MODULE_ID");
      Field field2 = clazz.getDeclaredField("MODULE_VERSION");
      if (!field1.get(null).equals(paramString)) {
        String str = String.valueOf(field1.get(null));
        null = String.valueOf(str).length();
        int i = String.valueOf(paramString).length();
        stringBuilder1 = new StringBuilder();
        this(null + 51 + i);
        stringBuilder1.append("Module descriptor id '");
        stringBuilder1.append(str);
        stringBuilder1.append("' didn't match expected id '");
        stringBuilder1.append(paramString);
        stringBuilder1.append("'");
        Log.e("DynamiteModule", stringBuilder1.toString());
        return 0;
      } 
      return stringBuilder1.getInt(null);
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 45);
      stringBuilder.append("Local module descriptor class for ");
      stringBuilder.append(paramString);
      stringBuilder.append(" not found.");
      Log.w("DynamiteModule", stringBuilder.toString());
    } catch (Exception exception) {
      String str = String.valueOf(exception.getMessage());
      if (str.length() != 0) {
        str = "Failed to load module descriptor class: ".concat(str);
      } else {
        str = new String("Failed to load module descriptor class: ");
      } 
      Log.e("DynamiteModule", str);
    } 
    return 0;
  }
  
  @KeepForSdk
  public static int getRemoteVersion(Context paramContext, String paramString) {
    return zza(paramContext, paramString, false);
  }
  
  @KeepForSdk
  public static DynamiteModule load(Context paramContext, VersionPolicy paramVersionPolicy, String paramString) throws LoadingException {
    zza zza1 = zzik.get();
    zza zza2 = new zza(null);
    zzik.set(zza2);
    try {
      VersionPolicy.zzb zzb = paramVersionPolicy.zza(paramContext, paramString, zzil);
      int i = zzb.zzir;
      int j = zzb.zzis;
      int k = String.valueOf(paramString).length();
      int m = String.valueOf(paramString).length();
      StringBuilder stringBuilder2 = new StringBuilder();
      this(k + 68 + m);
      stringBuilder2.append("Considering local module ");
      stringBuilder2.append(paramString);
      stringBuilder2.append(":");
      stringBuilder2.append(i);
      stringBuilder2.append(" and remote module ");
      stringBuilder2.append(paramString);
      stringBuilder2.append(":");
      stringBuilder2.append(j);
      Log.i("DynamiteModule", stringBuilder2.toString());
      if (zzb.zzit != 0 && (zzb.zzit != -1 || zzb.zzir != 0) && (zzb.zzit != 1 || zzb.zzis != 0)) {
        DynamiteModule dynamiteModule;
        if (zzb.zzit == -1) {
          dynamiteModule = zze(paramContext, paramString);
          return dynamiteModule;
        } 
        j = zzb.zzit;
        if (j == 1)
          try {
            return zza((Context)dynamiteModule, paramString, zzb.zzis);
          } catch (LoadingException loadingException3) {
            String str = String.valueOf(loadingException3.getMessage());
            if (str.length() != 0) {
              str = "Failed to load remote module: ".concat(str);
            } else {
              str = new String("Failed to load remote module: ");
            } 
            Log.w("DynamiteModule", str);
            if (zzb.zzir != 0) {
              zzb zzb1 = new zzb();
              this(zzb.zzir, 0);
              if ((paramVersionPolicy.zza((Context)dynamiteModule, paramString, zzb1)).zzit == -1) {
                dynamiteModule = zze((Context)dynamiteModule, paramString);
                return dynamiteModule;
              } 
            } 
            LoadingException loadingException2 = new LoadingException();
            this("Remote load failed. No local fallback found.", loadingException3, null);
            throw loadingException2;
          }  
        LoadingException loadingException1 = new LoadingException();
        j = zzb.zzit;
        StringBuilder stringBuilder = new StringBuilder();
        this(47);
        stringBuilder.append("VersionPolicy returned invalid code:");
        stringBuilder.append(j);
        this(stringBuilder.toString(), (zza)null);
        throw loadingException1;
      } 
      LoadingException loadingException = new LoadingException();
      j = zzb.zzir;
      k = zzb.zzis;
      StringBuilder stringBuilder1 = new StringBuilder();
      this(91);
      stringBuilder1.append("No acceptable module found. Local version is ");
      stringBuilder1.append(j);
      stringBuilder1.append(" and remote version is ");
      stringBuilder1.append(k);
      stringBuilder1.append(".");
      this(stringBuilder1.toString(), (zza)null);
      throw loadingException;
    } finally {
      if (zza2.zzio != null)
        zza2.zzio.close(); 
      zzik.set(zza1);
    } 
  }
  
  public static int zza(Context paramContext, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzif : Ljava/lang/Boolean;
    //   6: astore_3
    //   7: aload_3
    //   8: astore #4
    //   10: aload_3
    //   11: ifnonnull -> 301
    //   14: aload_0
    //   15: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   18: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   21: ldc com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader
    //   23: invokevirtual getName : ()Ljava/lang/String;
    //   26: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   29: astore_3
    //   30: aload_3
    //   31: ldc_w 'sClassLoader'
    //   34: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   37: astore #4
    //   39: aload_3
    //   40: monitorenter
    //   41: aload #4
    //   43: aconst_null
    //   44: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast java/lang/ClassLoader
    //   50: astore #5
    //   52: aload #5
    //   54: ifnull -> 86
    //   57: aload #5
    //   59: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   62: if_acmpne -> 73
    //   65: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   68: astore #4
    //   70: goto -> 212
    //   73: aload #5
    //   75: invokestatic zza : (Ljava/lang/ClassLoader;)V
    //   78: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   81: astore #4
    //   83: goto -> 212
    //   86: ldc_w 'com.google.android.gms'
    //   89: aload_0
    //   90: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   93: invokevirtual getPackageName : ()Ljava/lang/String;
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifeq -> 119
    //   102: aload #4
    //   104: aconst_null
    //   105: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   108: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   111: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   114: astore #4
    //   116: goto -> 212
    //   119: aload_0
    //   120: aload_1
    //   121: iload_2
    //   122: invokestatic zzc : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   125: istore #6
    //   127: getstatic com/google/android/gms/dynamite/DynamiteModule.zzii : Ljava/lang/String;
    //   130: ifnull -> 188
    //   133: getstatic com/google/android/gms/dynamite/DynamiteModule.zzii : Ljava/lang/String;
    //   136: invokevirtual isEmpty : ()Z
    //   139: ifeq -> 145
    //   142: goto -> 188
    //   145: new com/google/android/gms/dynamite/zzh
    //   148: astore #5
    //   150: aload #5
    //   152: getstatic com/google/android/gms/dynamite/DynamiteModule.zzii : Ljava/lang/String;
    //   155: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   158: invokespecial <init> : (Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   161: aload #5
    //   163: invokestatic zza : (Ljava/lang/ClassLoader;)V
    //   166: aload #4
    //   168: aconst_null
    //   169: aload #5
    //   171: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   174: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   177: putstatic com/google/android/gms/dynamite/DynamiteModule.zzif : Ljava/lang/Boolean;
    //   180: aload_3
    //   181: monitorexit
    //   182: ldc com/google/android/gms/dynamite/DynamiteModule
    //   184: monitorexit
    //   185: iload #6
    //   187: ireturn
    //   188: aload_3
    //   189: monitorexit
    //   190: ldc com/google/android/gms/dynamite/DynamiteModule
    //   192: monitorexit
    //   193: iload #6
    //   195: ireturn
    //   196: astore #5
    //   198: aload #4
    //   200: aconst_null
    //   201: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   204: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   207: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   210: astore #4
    //   212: aload_3
    //   213: monitorexit
    //   214: goto -> 296
    //   217: astore #4
    //   219: aload_3
    //   220: monitorexit
    //   221: aload #4
    //   223: athrow
    //   224: astore #4
    //   226: goto -> 236
    //   229: astore #4
    //   231: goto -> 236
    //   234: astore #4
    //   236: aload #4
    //   238: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   241: astore #4
    //   243: aload #4
    //   245: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   248: invokevirtual length : ()I
    //   251: istore #6
    //   253: new java/lang/StringBuilder
    //   256: astore_3
    //   257: aload_3
    //   258: iload #6
    //   260: bipush #30
    //   262: iadd
    //   263: invokespecial <init> : (I)V
    //   266: aload_3
    //   267: ldc_w 'Failed to load module via V2: '
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_3
    //   275: aload #4
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: ldc 'DynamiteModule'
    //   283: aload_3
    //   284: invokevirtual toString : ()Ljava/lang/String;
    //   287: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   290: pop
    //   291: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   294: astore #4
    //   296: aload #4
    //   298: putstatic com/google/android/gms/dynamite/DynamiteModule.zzif : Ljava/lang/Boolean;
    //   301: ldc com/google/android/gms/dynamite/DynamiteModule
    //   303: monitorexit
    //   304: aload #4
    //   306: invokevirtual booleanValue : ()Z
    //   309: istore #7
    //   311: iload #7
    //   313: ifeq -> 374
    //   316: aload_0
    //   317: aload_1
    //   318: iload_2
    //   319: invokestatic zzc : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   322: istore #6
    //   324: iload #6
    //   326: ireturn
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual getMessage : ()Ljava/lang/String;
    //   332: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual length : ()I
    //   340: ifeq -> 354
    //   343: ldc_w 'Failed to retrieve remote module version: '
    //   346: aload_1
    //   347: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   350: astore_1
    //   351: goto -> 365
    //   354: new java/lang/String
    //   357: dup
    //   358: ldc_w 'Failed to retrieve remote module version: '
    //   361: invokespecial <init> : (Ljava/lang/String;)V
    //   364: astore_1
    //   365: ldc 'DynamiteModule'
    //   367: aload_1
    //   368: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   371: pop
    //   372: iconst_0
    //   373: ireturn
    //   374: aload_0
    //   375: aload_1
    //   376: iload_2
    //   377: invokestatic zzb : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   380: istore #6
    //   382: iload #6
    //   384: ireturn
    //   385: astore_1
    //   386: ldc com/google/android/gms/dynamite/DynamiteModule
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: astore_1
    //   392: aload_0
    //   393: aload_1
    //   394: invokestatic addDynamiteErrorToDropBox : (Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   397: pop
    //   398: aload_1
    //   399: athrow
    //   400: astore #4
    //   402: goto -> 78
    // Exception table:
    //   from	to	target	type
    //   0	3	391	java/lang/Throwable
    //   3	7	385	finally
    //   14	41	234	java/lang/ClassNotFoundException
    //   14	41	229	java/lang/IllegalAccessException
    //   14	41	224	java/lang/NoSuchFieldException
    //   14	41	385	finally
    //   41	52	217	finally
    //   57	70	217	finally
    //   73	78	400	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   73	78	217	finally
    //   78	83	217	finally
    //   86	116	217	finally
    //   119	142	196	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   119	142	217	finally
    //   145	180	196	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   145	180	217	finally
    //   180	182	217	finally
    //   182	185	385	finally
    //   188	190	217	finally
    //   190	193	385	finally
    //   198	212	217	finally
    //   212	214	217	finally
    //   219	221	217	finally
    //   221	224	234	java/lang/ClassNotFoundException
    //   221	224	229	java/lang/IllegalAccessException
    //   221	224	224	java/lang/NoSuchFieldException
    //   221	224	385	finally
    //   236	296	385	finally
    //   296	301	385	finally
    //   301	304	385	finally
    //   304	311	391	java/lang/Throwable
    //   316	324	327	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   316	324	391	java/lang/Throwable
    //   328	351	391	java/lang/Throwable
    //   354	365	391	java/lang/Throwable
    //   365	372	391	java/lang/Throwable
    //   374	382	391	java/lang/Throwable
    //   386	389	385	finally
    //   389	391	391	java/lang/Throwable
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt) throws LoadingException {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzif : Ljava/lang/Boolean;
    //   6: astore_3
    //   7: ldc com/google/android/gms/dynamite/DynamiteModule
    //   9: monitorexit
    //   10: aload_3
    //   11: ifnull -> 195
    //   14: aload_3
    //   15: invokevirtual booleanValue : ()Z
    //   18: ifeq -> 28
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokestatic zzb : (Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   27: areturn
    //   28: aload_1
    //   29: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   32: invokevirtual length : ()I
    //   35: istore #4
    //   37: new java/lang/StringBuilder
    //   40: astore_3
    //   41: aload_3
    //   42: iload #4
    //   44: bipush #51
    //   46: iadd
    //   47: invokespecial <init> : (I)V
    //   50: aload_3
    //   51: ldc_w 'Selected remote version of '
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: aload_1
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc_w ', version >= '
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: iload_2
    //   74: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: ldc 'DynamiteModule'
    //   80: aload_3
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   87: pop
    //   88: aload_0
    //   89: invokestatic zzj : (Landroid/content/Context;)Lcom/google/android/gms/dynamite/zzi;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull -> 181
    //   97: aload_3
    //   98: invokeinterface zzak : ()I
    //   103: iconst_2
    //   104: if_icmplt -> 123
    //   107: aload_3
    //   108: aload_0
    //   109: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   112: aload_1
    //   113: iload_2
    //   114: invokeinterface zzb : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;I)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   119: astore_1
    //   120: goto -> 145
    //   123: ldc 'DynamiteModule'
    //   125: ldc_w 'Dynamite loader version < 2, falling back to createModuleContext'
    //   128: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_3
    //   133: aload_0
    //   134: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   137: aload_1
    //   138: iload_2
    //   139: invokeinterface zza : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;I)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   144: astore_1
    //   145: aload_1
    //   146: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   149: ifnull -> 167
    //   152: new com/google/android/gms/dynamite/DynamiteModule
    //   155: dup
    //   156: aload_1
    //   157: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   160: checkcast android/content/Context
    //   163: invokespecial <init> : (Landroid/content/Context;)V
    //   166: areturn
    //   167: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   170: astore_1
    //   171: aload_1
    //   172: ldc_w 'Failed to load remote module.'
    //   175: aconst_null
    //   176: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   179: aload_1
    //   180: athrow
    //   181: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   184: astore_1
    //   185: aload_1
    //   186: ldc_w 'Failed to create IDynamiteLoader.'
    //   189: aconst_null
    //   190: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   193: aload_1
    //   194: athrow
    //   195: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   198: astore_1
    //   199: aload_1
    //   200: ldc_w 'Failed to determine which loading route to use.'
    //   203: aconst_null
    //   204: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   207: aload_1
    //   208: athrow
    //   209: astore_1
    //   210: ldc com/google/android/gms/dynamite/DynamiteModule
    //   212: monitorexit
    //   213: aload_1
    //   214: athrow
    //   215: astore_1
    //   216: aload_0
    //   217: aload_1
    //   218: invokestatic addDynamiteErrorToDropBox : (Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   221: pop
    //   222: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   225: dup
    //   226: ldc_w 'Failed to load remote module.'
    //   229: aload_1
    //   230: aconst_null
    //   231: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   234: athrow
    //   235: astore_0
    //   236: aload_0
    //   237: athrow
    //   238: astore_0
    //   239: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   242: dup
    //   243: ldc_w 'Failed to load remote module.'
    //   246: aload_0
    //   247: aconst_null
    //   248: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   251: athrow
    // Exception table:
    //   from	to	target	type
    //   0	3	238	android/os/RemoteException
    //   0	3	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   0	3	215	java/lang/Throwable
    //   3	10	209	finally
    //   14	28	238	android/os/RemoteException
    //   14	28	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   14	28	215	java/lang/Throwable
    //   28	93	238	android/os/RemoteException
    //   28	93	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   28	93	215	java/lang/Throwable
    //   97	120	238	android/os/RemoteException
    //   97	120	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   97	120	215	java/lang/Throwable
    //   123	145	238	android/os/RemoteException
    //   123	145	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   123	145	215	java/lang/Throwable
    //   145	167	238	android/os/RemoteException
    //   145	167	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   145	167	215	java/lang/Throwable
    //   167	181	238	android/os/RemoteException
    //   167	181	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   167	181	215	java/lang/Throwable
    //   181	195	238	android/os/RemoteException
    //   181	195	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   181	195	215	java/lang/Throwable
    //   195	209	238	android/os/RemoteException
    //   195	209	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   195	209	215	java/lang/Throwable
    //   210	213	209	finally
    //   213	215	238	android/os/RemoteException
    //   213	215	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   213	215	215	java/lang/Throwable
  }
  
  @GuardedBy("DynamiteModule.class")
  private static void zza(ClassLoader paramClassLoader) throws LoadingException {
    try {
      IInterface iInterface;
      IBinder iBinder = paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
      if (iBinder == null) {
        paramClassLoader = null;
      } else {
        iInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        if (iInterface instanceof zzk) {
          iInterface = iInterface;
        } else {
          iInterface = new zzl(iBinder);
        } 
      } 
      zzih = (zzk)iInterface;
      return;
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {}
    throw new LoadingException("Failed to instantiate dynamite loader", noSuchMethodException, null);
  }
  
  private static Boolean zzaj() {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzij : I
    //   6: iconst_2
    //   7: if_icmplt -> 15
    //   10: iconst_1
    //   11: istore_0
    //   12: goto -> 17
    //   15: iconst_0
    //   16: istore_0
    //   17: ldc com/google/android/gms/dynamite/DynamiteModule
    //   19: monitorexit
    //   20: iload_0
    //   21: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   24: areturn
    //   25: astore_1
    //   26: ldc com/google/android/gms/dynamite/DynamiteModule
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	25	finally
    //   17	25	25	finally
    //   26	29	25	finally
  }
  
  private static int zzb(Context paramContext, String paramString, boolean paramBoolean) {
    zzi zzi1 = zzj(paramContext);
    if (zzi1 == null)
      return 0; 
    try {
      if (zzi1.zzak() >= 2)
        return zzi1.zzb(ObjectWrapper.wrap(paramContext), paramString, paramBoolean); 
      Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
      return zzi1.zza(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
    } catch (RemoteException remoteException) {
      String str = String.valueOf(remoteException.getMessage());
      if (str.length() != 0) {
        str = "Failed to retrieve remote module version: ".concat(str);
      } else {
        str = new String("Failed to retrieve remote module version: ");
      } 
      Log.w("DynamiteModule", str);
      return 0;
    } 
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt) throws LoadingException, RemoteException {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: aload_1
    //   5: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   8: invokevirtual length : ()I
    //   11: bipush #51
    //   13: iadd
    //   14: invokespecial <init> : (I)V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc_w 'Selected remote version of '
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: ldc_w ', version >= '
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: iload_2
    //   42: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 'DynamiteModule'
    //   48: aload_3
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: ldc com/google/android/gms/dynamite/DynamiteModule
    //   58: monitorenter
    //   59: getstatic com/google/android/gms/dynamite/DynamiteModule.zzih : Lcom/google/android/gms/dynamite/zzk;
    //   62: astore_3
    //   63: ldc com/google/android/gms/dynamite/DynamiteModule
    //   65: monitorexit
    //   66: aload_3
    //   67: ifnull -> 222
    //   70: getstatic com/google/android/gms/dynamite/DynamiteModule.zzik : Ljava/lang/ThreadLocal;
    //   73: invokevirtual get : ()Ljava/lang/Object;
    //   76: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
    //   79: astore #4
    //   81: aload #4
    //   83: ifnull -> 210
    //   86: aload #4
    //   88: getfield zzio : Landroid/database/Cursor;
    //   91: ifnull -> 210
    //   94: aload_0
    //   95: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   98: astore_0
    //   99: aload #4
    //   101: getfield zzio : Landroid/database/Cursor;
    //   104: astore #4
    //   106: aconst_null
    //   107: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   110: pop
    //   111: invokestatic zzaj : ()Ljava/lang/Boolean;
    //   114: invokevirtual booleanValue : ()Z
    //   117: ifeq -> 150
    //   120: ldc 'DynamiteModule'
    //   122: ldc_w 'Dynamite loader version >= 2, using loadModule2NoCrashUtils'
    //   125: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   128: pop
    //   129: aload_3
    //   130: aload_0
    //   131: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   134: aload_1
    //   135: iload_2
    //   136: aload #4
    //   138: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   141: invokeinterface zzb : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ILcom/google/android/gms/dynamic/IObjectWrapper;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   146: astore_0
    //   147: goto -> 177
    //   150: ldc 'DynamiteModule'
    //   152: ldc_w 'Dynamite loader version < 2, falling back to loadModule2'
    //   155: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: aload_3
    //   160: aload_0
    //   161: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   164: aload_1
    //   165: iload_2
    //   166: aload #4
    //   168: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   171: invokeinterface zza : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ILcom/google/android/gms/dynamic/IObjectWrapper;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   176: astore_0
    //   177: aload_0
    //   178: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   181: checkcast android/content/Context
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull -> 198
    //   189: new com/google/android/gms/dynamite/DynamiteModule
    //   192: dup
    //   193: aload_0
    //   194: invokespecial <init> : (Landroid/content/Context;)V
    //   197: areturn
    //   198: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   201: dup
    //   202: ldc_w 'Failed to get module context'
    //   205: aconst_null
    //   206: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   209: athrow
    //   210: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   213: dup
    //   214: ldc_w 'No result cursor'
    //   217: aconst_null
    //   218: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   221: athrow
    //   222: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   225: dup
    //   226: ldc_w 'DynamiteLoaderV2 was not cached.'
    //   229: aconst_null
    //   230: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   233: athrow
    //   234: astore_0
    //   235: ldc com/google/android/gms/dynamite/DynamiteModule
    //   237: monitorexit
    //   238: aload_0
    //   239: athrow
    // Exception table:
    //   from	to	target	type
    //   59	66	234	finally
    //   235	238	234	finally
  }
  
  private static int zzc(Context paramContext, String paramString, boolean paramBoolean) throws LoadingException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   6: astore #4
    //   8: iload_2
    //   9: ifeq -> 19
    //   12: ldc_w 'api_force_staging'
    //   15: astore_0
    //   16: goto -> 23
    //   19: ldc_w 'api'
    //   22: astore_0
    //   23: aload_0
    //   24: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokevirtual length : ()I
    //   30: istore #5
    //   32: aload_1
    //   33: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual length : ()I
    //   39: istore #6
    //   41: new java/lang/StringBuilder
    //   44: astore #7
    //   46: aload #7
    //   48: iload #5
    //   50: bipush #42
    //   52: iadd
    //   53: iload #6
    //   55: iadd
    //   56: invokespecial <init> : (I)V
    //   59: aload #7
    //   61: ldc_w 'content://com.google.android.gms.chimera/'
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #7
    //   70: aload_0
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload #7
    //   77: ldc_w '/'
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload #7
    //   86: aload_1
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #4
    //   93: aload #7
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   101: aconst_null
    //   102: aconst_null
    //   103: aconst_null
    //   104: aconst_null
    //   105: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull -> 235
    //   113: aload_0
    //   114: invokeinterface moveToFirst : ()Z
    //   119: ifeq -> 235
    //   122: aload_0
    //   123: iconst_0
    //   124: invokeinterface getInt : (I)I
    //   129: istore #5
    //   131: aload_0
    //   132: astore_1
    //   133: iload #5
    //   135: ifle -> 222
    //   138: ldc com/google/android/gms/dynamite/DynamiteModule
    //   140: monitorenter
    //   141: aload_0
    //   142: iconst_2
    //   143: invokeinterface getString : (I)Ljava/lang/String;
    //   148: putstatic com/google/android/gms/dynamite/DynamiteModule.zzii : Ljava/lang/String;
    //   151: aload_0
    //   152: ldc_w 'loaderVersion'
    //   155: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   160: istore #6
    //   162: iload #6
    //   164: iflt -> 178
    //   167: aload_0
    //   168: iload #6
    //   170: invokeinterface getInt : (I)I
    //   175: putstatic com/google/android/gms/dynamite/DynamiteModule.zzij : I
    //   178: ldc com/google/android/gms/dynamite/DynamiteModule
    //   180: monitorexit
    //   181: getstatic com/google/android/gms/dynamite/DynamiteModule.zzik : Ljava/lang/ThreadLocal;
    //   184: invokevirtual get : ()Ljava/lang/Object;
    //   187: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
    //   190: astore_3
    //   191: aload_0
    //   192: astore_1
    //   193: aload_3
    //   194: ifnull -> 222
    //   197: aload_0
    //   198: astore_1
    //   199: aload_3
    //   200: getfield zzio : Landroid/database/Cursor;
    //   203: ifnonnull -> 222
    //   206: aload_3
    //   207: aload_0
    //   208: putfield zzio : Landroid/database/Cursor;
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -> 222
    //   216: astore_1
    //   217: ldc com/google/android/gms/dynamite/DynamiteModule
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: aload_1
    //   223: ifnull -> 232
    //   226: aload_1
    //   227: invokeinterface close : ()V
    //   232: iload #5
    //   234: ireturn
    //   235: ldc 'DynamiteModule'
    //   237: ldc_w 'Failed to retrieve remote module version.'
    //   240: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   243: pop
    //   244: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   247: astore_1
    //   248: aload_1
    //   249: ldc_w 'Failed to connect to dynamite module ContentResolver.'
    //   252: aconst_null
    //   253: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: goto -> 300
    //   262: astore_1
    //   263: goto -> 275
    //   266: astore_1
    //   267: aload_3
    //   268: astore_0
    //   269: goto -> 300
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_0
    //   275: aload_1
    //   276: instanceof com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   279: ifeq -> 284
    //   282: aload_1
    //   283: athrow
    //   284: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   287: astore_3
    //   288: aload_3
    //   289: ldc_w 'V2 version check failed'
    //   292: aload_1
    //   293: aconst_null
    //   294: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   297: aload_3
    //   298: athrow
    //   299: astore_1
    //   300: aload_0
    //   301: ifnull -> 310
    //   304: aload_0
    //   305: invokeinterface close : ()V
    //   310: aload_1
    //   311: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	272	java/lang/Exception
    //   2	8	266	finally
    //   23	109	272	java/lang/Exception
    //   23	109	266	finally
    //   113	131	262	java/lang/Exception
    //   113	131	258	finally
    //   138	141	262	java/lang/Exception
    //   138	141	258	finally
    //   141	162	216	finally
    //   167	178	216	finally
    //   178	181	216	finally
    //   181	191	262	java/lang/Exception
    //   181	191	258	finally
    //   199	211	262	java/lang/Exception
    //   199	211	258	finally
    //   217	220	216	finally
    //   220	222	262	java/lang/Exception
    //   220	222	258	finally
    //   235	258	262	java/lang/Exception
    //   235	258	258	finally
    //   275	284	299	finally
    //   284	299	299	finally
  }
  
  private static DynamiteModule zze(Context paramContext, String paramString) {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Selected local version of ".concat(paramString);
    } else {
      paramString = new String("Selected local version of ");
    } 
    Log.i("DynamiteModule", paramString);
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  private static zzi zzj(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzig : Lcom/google/android/gms/dynamite/zzi;
    //   6: ifnull -> 18
    //   9: getstatic com/google/android/gms/dynamite/DynamiteModule.zzig : Lcom/google/android/gms/dynamite/zzi;
    //   12: astore_0
    //   13: ldc com/google/android/gms/dynamite/DynamiteModule
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic getInstance : ()Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   21: aload_0
    //   22: invokevirtual isGooglePlayServicesAvailable : (Landroid/content/Context;)I
    //   25: ifeq -> 33
    //   28: ldc com/google/android/gms/dynamite/DynamiteModule
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc_w 'com.google.android.gms'
    //   37: iconst_3
    //   38: invokevirtual createPackageContext : (Ljava/lang/String;I)Landroid/content/Context;
    //   41: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   44: ldc_w 'com.google.android.gms.chimera.container.DynamiteLoaderImpl'
    //   47: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   50: invokevirtual newInstance : ()Ljava/lang/Object;
    //   53: checkcast android/os/IBinder
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull -> 66
    //   61: aconst_null
    //   62: astore_0
    //   63: goto -> 100
    //   66: aload_0
    //   67: ldc_w 'com.google.android.gms.dynamite.IDynamiteLoader'
    //   70: invokeinterface queryLocalInterface : (Ljava/lang/String;)Landroid/os/IInterface;
    //   75: astore_1
    //   76: aload_1
    //   77: instanceof com/google/android/gms/dynamite/zzi
    //   80: ifeq -> 91
    //   83: aload_1
    //   84: checkcast com/google/android/gms/dynamite/zzi
    //   87: astore_0
    //   88: goto -> 100
    //   91: new com/google/android/gms/dynamite/zzj
    //   94: dup
    //   95: aload_0
    //   96: invokespecial <init> : (Landroid/os/IBinder;)V
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull -> 158
    //   104: aload_0
    //   105: putstatic com/google/android/gms/dynamite/DynamiteModule.zzig : Lcom/google/android/gms/dynamite/zzi;
    //   108: ldc com/google/android/gms/dynamite/DynamiteModule
    //   110: monitorexit
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual getMessage : ()Ljava/lang/String;
    //   118: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual length : ()I
    //   126: ifeq -> 140
    //   129: ldc_w 'Failed to load IDynamiteLoader from GmsCore: '
    //   132: aload_0
    //   133: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_0
    //   137: goto -> 151
    //   140: new java/lang/String
    //   143: dup
    //   144: ldc_w 'Failed to load IDynamiteLoader from GmsCore: '
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: astore_0
    //   151: ldc 'DynamiteModule'
    //   153: aload_0
    //   154: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: ldc com/google/android/gms/dynamite/DynamiteModule
    //   160: monitorexit
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: ldc com/google/android/gms/dynamite/DynamiteModule
    //   166: monitorexit
    //   167: aload_0
    //   168: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	163	finally
    //   18	31	163	finally
    //   33	57	113	java/lang/Exception
    //   33	57	163	finally
    //   66	88	113	java/lang/Exception
    //   66	88	163	finally
    //   91	100	113	java/lang/Exception
    //   91	100	163	finally
    //   104	108	113	java/lang/Exception
    //   104	108	163	finally
    //   108	111	163	finally
    //   114	137	163	finally
    //   140	151	163	finally
    //   151	158	163	finally
    //   158	161	163	finally
    //   164	167	163	finally
  }
  
  @KeepForSdk
  public final Context getModuleContext() {
    return this.zzin;
  }
  
  @KeepForSdk
  public final IBinder instantiate(String paramString) throws LoadingException {
    try {
      return (IBinder)this.zzin.getClassLoader().loadClass(paramString).newInstance();
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Failed to instantiate module class: ".concat(paramString);
    } else {
      paramString = new String("Failed to instantiate module class: ");
    } 
    throw new LoadingException(paramString, illegalAccessException, null);
  }
  
  @DynamiteApi
  public static class DynamiteLoaderClassLoader {
    @GuardedBy("DynamiteLoaderClassLoader.class")
    public static ClassLoader sClassLoader;
  }
  
  @KeepForSdk
  public static class LoadingException extends Exception {
    private LoadingException(String param1String) {
      super(param1String);
    }
    
    private LoadingException(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
  
  public static interface VersionPolicy {
    zzb zza(Context param1Context, String param1String, zza param1zza) throws DynamiteModule.LoadingException;
    
    public static interface zza {
      int getLocalVersion(Context param2Context, String param2String);
      
      int zza(Context param2Context, String param2String, boolean param2Boolean) throws DynamiteModule.LoadingException;
    }
    
    public static final class zzb {
      public int zzir = 0;
      
      public int zzis = 0;
      
      public int zzit = 0;
    }
  }
  
  public static interface zza {
    int getLocalVersion(Context param1Context, String param1String);
    
    int zza(Context param1Context, String param1String, boolean param1Boolean) throws DynamiteModule.LoadingException;
  }
  
  public static final class zzb {
    public int zzir = 0;
    
    public int zzis = 0;
    
    public int zzit = 0;
  }
  
  private static final class zza {
    public Cursor zzio;
    
    private zza() {}
  }
  
  private static final class zzb implements VersionPolicy.zza {
    private final int zzip;
    
    private final int zziq;
    
    public zzb(int param1Int1, int param1Int2) {
      this.zzip = param1Int1;
      this.zziq = 0;
    }
    
    public final int getLocalVersion(Context param1Context, String param1String) {
      return this.zzip;
    }
    
    public final int zza(Context param1Context, String param1String, boolean param1Boolean) {
      return 0;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\dynamite\DynamiteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */