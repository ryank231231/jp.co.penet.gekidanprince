package com.google.android.gms.internal.clearcut;

public final class zzgc extends zzcg.zzd<zzgc, zzgc.zza> implements zzdq {
  private static volatile zzdz<zzgc> zzbg;
  
  private static final zzgc zzsg = new zzgc();
  
  private byte zzsf = (byte)2;
  
  static {
    zzcg.zza(zzgc.class, zzsg);
  }
  
  public static zzgc zzer() {
    return zzsg;
  }
  
  protected final Object zza(int paramInt, Object<zzgc> paramObject1, Object<zzgc> paramObject2) {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/clearcut/zzgd.zzba : [I
    //   3: astore_3
    //   4: iconst_1
    //   5: istore #4
    //   7: aload_3
    //   8: iload_1
    //   9: iconst_1
    //   10: isub
    //   11: iaload
    //   12: tableswitch default -> 56, 1 -> 165, 2 -> 156, 3 -> 146, 4 -> 142, 5 -> 90, 6 -> 82, 7 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: iload #4
    //   66: istore_1
    //   67: aload_2
    //   68: ifnonnull -> 73
    //   71: iconst_0
    //   72: istore_1
    //   73: aload_0
    //   74: iload_1
    //   75: i2b
    //   76: i2b
    //   77: putfield zzsf : B
    //   80: aconst_null
    //   81: areturn
    //   82: aload_0
    //   83: getfield zzsf : B
    //   86: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   89: areturn
    //   90: getstatic com/google/android/gms/internal/clearcut/zzgc.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: ifnonnull -> 140
    //   100: ldc com/google/android/gms/internal/clearcut/zzgc
    //   102: monitorenter
    //   103: getstatic com/google/android/gms/internal/clearcut/zzgc.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
    //   106: astore_3
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: ifnonnull -> 128
    //   113: new com/google/android/gms/internal/clearcut/zzcg$zzb
    //   116: astore_2
    //   117: aload_2
    //   118: getstatic com/google/android/gms/internal/clearcut/zzgc.zzsg : Lcom/google/android/gms/internal/clearcut/zzgc;
    //   121: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzcg;)V
    //   124: aload_2
    //   125: putstatic com/google/android/gms/internal/clearcut/zzgc.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
    //   128: ldc com/google/android/gms/internal/clearcut/zzgc
    //   130: monitorexit
    //   131: goto -> 140
    //   134: astore_2
    //   135: ldc com/google/android/gms/internal/clearcut/zzgc
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    //   140: aload_2
    //   141: areturn
    //   142: getstatic com/google/android/gms/internal/clearcut/zzgc.zzsg : Lcom/google/android/gms/internal/clearcut/zzgc;
    //   145: areturn
    //   146: getstatic com/google/android/gms/internal/clearcut/zzgc.zzsg : Lcom/google/android/gms/internal/clearcut/zzgc;
    //   149: ldc ' '
    //   151: aconst_null
    //   152: invokestatic zza : (Lcom/google/android/gms/internal/clearcut/zzdo;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   155: areturn
    //   156: new com/google/android/gms/internal/clearcut/zzgc$zza
    //   159: dup
    //   160: aconst_null
    //   161: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzgd;)V
    //   164: areturn
    //   165: new com/google/android/gms/internal/clearcut/zzgc
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: areturn
    // Exception table:
    //   from	to	target	type
    //   103	107	134	finally
    //   113	128	134	finally
    //   128	131	134	finally
    //   135	138	134	finally
  }
  
  public static final class zza extends zzcg.zzc<zzgc, zza> implements zzdq {
    private zza() {
      super(zzgc.zzes());
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */