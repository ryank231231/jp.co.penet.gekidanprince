package com.google.android.gms.internal.measurement;

public final class zzbr {
  public static final class zza extends zzez<zza, zza.zza> implements zzgj {
    private static volatile zzgs<zza> zztq;
    
    private static final zza zzuo = new zza();
    
    private int zztj;
    
    private String zzum = "";
    
    private String zzun = "";
    
    static {
      zzez.zza(zza.class, zzuo);
    }
    
    public static zzgs<zza> zzgs() {
      return (zzgs<zza>)zzuo.zza(zzez.zze.zzaha, (Object)null, (Object)null);
    }
    
    public final String getKey() {
      return this.zzum;
    }
    
    public final String getValue() {
      return this.zzun;
    }
    
    protected final Object zza(int param1Int, Object<zza> param1Object1, Object<zza> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbs.zzti : [I
      //   3: iload_1
      //   4: iconst_1
      //   5: isub
      //   6: iaload
      //   7: tableswitch default -> 48, 1 -> 156, 2 -> 147, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
      //   48: new java/lang/UnsupportedOperationException
      //   51: dup
      //   52: invokespecial <init> : ()V
      //   55: athrow
      //   56: aconst_null
      //   57: areturn
      //   58: iconst_1
      //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
      //   62: areturn
      //   63: getstatic com/google/android/gms/internal/measurement/zzbr$zza.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbr$zza
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbr$zza.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbr$zza.zzuo : Lcom/google/android/gms/internal/measurement/zzbr$zza;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbr$zza.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbr$zza
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbr$zza
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbr$zza.zzuo : Lcom/google/android/gms/internal/measurement/zzbr$zza;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbr$zza.zzuo : Lcom/google/android/gms/internal/measurement/zzbr$zza;
      //   122: ldc '    \\b \\b'
      //   124: iconst_3
      //   125: anewarray java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: ldc 'zztj'
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: ldc 'zzum'
      //   137: aastore
      //   138: dup
      //   139: iconst_2
      //   140: ldc 'zzun'
      //   142: aastore
      //   143: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   146: areturn
      //   147: new com/google/android/gms/internal/measurement/zzbr$zza$zza
      //   150: dup
      //   151: aconst_null
      //   152: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbs;)V
      //   155: areturn
      //   156: new com/google/android/gms/internal/measurement/zzbr$zza
      //   159: dup
      //   160: invokespecial <init> : ()V
      //   163: areturn
      // Exception table:
      //   from	to	target	type
      //   76	80	107	finally
      //   86	101	107	finally
      //   101	104	107	finally
      //   108	111	107	finally
    }
    
    public static final class zza extends zzez.zza<zza, zza> implements zzgj {
      private zza() {
        super(zzbr.zza.zzgt());
      }
    }
  }
  
  public static final class zza extends zzez.zza<zza, zza.zza> implements zzgj {
    private zza() {
      super(zzbr.zza.zzgt());
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */