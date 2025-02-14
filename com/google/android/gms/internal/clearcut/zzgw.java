package com.google.android.gms.internal.clearcut;

import java.util.List;

public final class zzgw {
  public static final class zza extends zzcg<zza, zza.zza> implements zzdq {
    private static volatile zzdz<zza> zzbg;
    
    private static final zza zzbir = new zza();
    
    private zzcn<zzb> zzbiq = zzbb();
    
    static {
      zzcg.zza(zza.class, zzbir);
    }
    
    public static zza zzft() {
      return zzbir;
    }
    
    public static zza zzi(byte[] param1ArrayOfbyte) throws zzco {
      return zzcg.<zza>zzb(zzbir, param1ArrayOfbyte);
    }
    
    protected final Object zza(int param1Int, Object<zza> param1Object1, Object<zza> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/clearcut/zzgx.zzba : [I
      //   3: iload_1
      //   4: iconst_1
      //   5: isub
      //   6: iaload
      //   7: tableswitch default -> 48, 1 -> 151, 2 -> 142, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
      //   48: new java/lang/UnsupportedOperationException
      //   51: dup
      //   52: invokespecial <init> : ()V
      //   55: athrow
      //   56: aconst_null
      //   57: areturn
      //   58: iconst_1
      //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
      //   62: areturn
      //   63: getstatic com/google/android/gms/internal/clearcut/zzgw$zza.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/clearcut/zzgw$zza
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/clearcut/zzgw$zza.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/clearcut/zzcg$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/clearcut/zzgw$zza.zzbir : Lcom/google/android/gms/internal/clearcut/zzgw$zza;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzcg;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/clearcut/zzgw$zza.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
      //   101: ldc com/google/android/gms/internal/clearcut/zzgw$zza
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/clearcut/zzgw$zza
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/clearcut/zzgw$zza.zzbir : Lcom/google/android/gms/internal/clearcut/zzgw$zza;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/clearcut/zzgw$zza.zzbir : Lcom/google/android/gms/internal/clearcut/zzgw$zza;
      //   122: ldc '    '
      //   124: iconst_2
      //   125: anewarray java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: ldc 'zzbiq'
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: ldc com/google/android/gms/internal/clearcut/zzgw$zza$zzb
      //   137: aastore
      //   138: invokestatic zza : (Lcom/google/android/gms/internal/clearcut/zzdo;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   141: areturn
      //   142: new com/google/android/gms/internal/clearcut/zzgw$zza$zza
      //   145: dup
      //   146: aconst_null
      //   147: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzgx;)V
      //   150: areturn
      //   151: new com/google/android/gms/internal/clearcut/zzgw$zza
      //   154: dup
      //   155: invokespecial <init> : ()V
      //   158: areturn
      // Exception table:
      //   from	to	target	type
      //   76	80	107	finally
      //   86	101	107	finally
      //   101	104	107	finally
      //   108	111	107	finally
    }
    
    public final List<zzb> zzfs() {
      return this.zzbiq;
    }
    
    public static final class zza extends zzcg.zza<zza, zza> implements zzdq {
      private zza() {
        super(zzgw.zza.zzfu());
      }
    }
    
    public static final class zzb extends zzcg<zzb, zzb.zza> implements zzdq {
      private static volatile zzdz<zzb> zzbg;
      
      private static final zzb zzbiv = new zzb();
      
      private int zzbb;
      
      private String zzbis = "";
      
      private long zzbit;
      
      private long zzbiu;
      
      private int zzya;
      
      static {
        zzcg.zza(zzb.class, zzbiv);
      }
      
      public static zza zzfz() {
        return (zza)zzbiv.zza(zzcg.zzg.zzkh, (Object)null, (Object)null);
      }
      
      private final void zzm(String param2String) {
        if (param2String != null) {
          this.zzbb |= 0x2;
          this.zzbis = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private final void zzp(long param2Long) {
        this.zzbb |= 0x4;
        this.zzbit = param2Long;
      }
      
      private final void zzq(long param2Long) {
        this.zzbb |= 0x8;
        this.zzbiu = param2Long;
      }
      
      public final int getEventCode() {
        return this.zzya;
      }
      
      protected final Object zza(int param2Int, Object<zzb> param2Object1, Object<zzb> param2Object2) {
        // Byte code:
        //   0: getstatic com/google/android/gms/internal/clearcut/zzgx.zzba : [I
        //   3: iload_1
        //   4: iconst_1
        //   5: isub
        //   6: iaload
        //   7: tableswitch default -> 48, 1 -> 166, 2 -> 157, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
        //   48: new java/lang/UnsupportedOperationException
        //   51: dup
        //   52: invokespecial <init> : ()V
        //   55: athrow
        //   56: aconst_null
        //   57: areturn
        //   58: iconst_1
        //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
        //   62: areturn
        //   63: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
        //   66: astore_3
        //   67: aload_3
        //   68: astore_2
        //   69: aload_3
        //   70: ifnonnull -> 113
        //   73: ldc com/google/android/gms/internal/clearcut/zzgw$zza$zzb
        //   75: monitorenter
        //   76: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
        //   79: astore_3
        //   80: aload_3
        //   81: astore_2
        //   82: aload_3
        //   83: ifnonnull -> 101
        //   86: new com/google/android/gms/internal/clearcut/zzcg$zzb
        //   89: astore_2
        //   90: aload_2
        //   91: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbiv : Lcom/google/android/gms/internal/clearcut/zzgw$zza$zzb;
        //   94: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzcg;)V
        //   97: aload_2
        //   98: putstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
        //   101: ldc com/google/android/gms/internal/clearcut/zzgw$zza$zzb
        //   103: monitorexit
        //   104: goto -> 113
        //   107: astore_2
        //   108: ldc com/google/android/gms/internal/clearcut/zzgw$zza$zzb
        //   110: monitorexit
        //   111: aload_2
        //   112: athrow
        //   113: aload_2
        //   114: areturn
        //   115: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbiv : Lcom/google/android/gms/internal/clearcut/zzgw$zza$zzb;
        //   118: areturn
        //   119: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbiv : Lcom/google/android/gms/internal/clearcut/zzgw$zza$zzb;
        //   122: ldc '     \\b'
        //   124: iconst_5
        //   125: anewarray java/lang/Object
        //   128: dup
        //   129: iconst_0
        //   130: ldc 'zzbb'
        //   132: aastore
        //   133: dup
        //   134: iconst_1
        //   135: ldc 'zzya'
        //   137: aastore
        //   138: dup
        //   139: iconst_2
        //   140: ldc 'zzbis'
        //   142: aastore
        //   143: dup
        //   144: iconst_3
        //   145: ldc 'zzbit'
        //   147: aastore
        //   148: dup
        //   149: iconst_4
        //   150: ldc 'zzbiu'
        //   152: aastore
        //   153: invokestatic zza : (Lcom/google/android/gms/internal/clearcut/zzdo;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   156: areturn
        //   157: new com/google/android/gms/internal/clearcut/zzgw$zza$zzb$zza
        //   160: dup
        //   161: aconst_null
        //   162: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzgx;)V
        //   165: areturn
        //   166: new com/google/android/gms/internal/clearcut/zzgw$zza$zzb
        //   169: dup
        //   170: invokespecial <init> : ()V
        //   173: areturn
        // Exception table:
        //   from	to	target	type
        //   76	80	107	finally
        //   86	101	107	finally
        //   101	104	107	finally
        //   108	111	107	finally
      }
      
      public final boolean zzfv() {
        return ((this.zzbb & 0x1) == 1);
      }
      
      public final String zzfw() {
        return this.zzbis;
      }
      
      public final long zzfx() {
        return this.zzbit;
      }
      
      public final long zzfy() {
        return this.zzbiu;
      }
      
      public static final class zza extends zzcg.zza<zzb, zza> implements zzdq {
        private zza() {
          super(zzgw.zza.zzb.zzga());
        }
        
        public final zza zzn(String param3String) {
          zzbf();
          zzgw.zza.zzb.zza(this.zzjt, param3String);
          return this;
        }
        
        public final zza zzr(long param3Long) {
          zzbf();
          zzgw.zza.zzb.zza(this.zzjt, param3Long);
          return this;
        }
        
        public final zza zzs(long param3Long) {
          zzbf();
          zzgw.zza.zzb.zzb(this.zzjt, param3Long);
          return this;
        }
      }
    }
    
    public static final class zza extends zzcg.zza<zzb, zzb.zza> implements zzdq {
      private zza() {
        super(zzgw.zza.zzb.zzga());
      }
      
      public final zza zzn(String param2String) {
        zzbf();
        zzgw.zza.zzb.zza(this.zzjt, param2String);
        return this;
      }
      
      public final zza zzr(long param2Long) {
        zzbf();
        zzgw.zza.zzb.zza(this.zzjt, param2Long);
        return this;
      }
      
      public final zza zzs(long param2Long) {
        zzbf();
        zzgw.zza.zzb.zzb(this.zzjt, param2Long);
        return this;
      }
    }
  }
  
  public static final class zza extends zzcg.zza<zza, zza.zza> implements zzdq {
    private zza() {
      super(zzgw.zza.zzfu());
    }
  }
  
  public static final class zzb extends zzcg<zza.zzb, zza.zzb.zza> implements zzdq {
    private static volatile zzdz<zzb> zzbg;
    
    private static final zzb zzbiv = new zzb();
    
    private int zzbb;
    
    private String zzbis = "";
    
    private long zzbit;
    
    private long zzbiu;
    
    private int zzya;
    
    static {
      zzcg.zza(zzb.class, zzbiv);
    }
    
    public static zza zzfz() {
      return (zza)zzbiv.zza(zzcg.zzg.zzkh, (Object)null, (Object)null);
    }
    
    private final void zzm(String param1String) {
      if (param1String != null) {
        this.zzbb |= 0x2;
        this.zzbis = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private final void zzp(long param1Long) {
      this.zzbb |= 0x4;
      this.zzbit = param1Long;
    }
    
    private final void zzq(long param1Long) {
      this.zzbb |= 0x8;
      this.zzbiu = param1Long;
    }
    
    public final int getEventCode() {
      return this.zzya;
    }
    
    protected final Object zza(int param1Int, Object<zzb> param1Object1, Object<zzb> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/clearcut/zzgx.zzba : [I
      //   3: iload_1
      //   4: iconst_1
      //   5: isub
      //   6: iaload
      //   7: tableswitch default -> 48, 1 -> 166, 2 -> 157, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
      //   48: new java/lang/UnsupportedOperationException
      //   51: dup
      //   52: invokespecial <init> : ()V
      //   55: athrow
      //   56: aconst_null
      //   57: areturn
      //   58: iconst_1
      //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
      //   62: areturn
      //   63: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/clearcut/zzgw$zza$zzb
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/clearcut/zzcg$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbiv : Lcom/google/android/gms/internal/clearcut/zzgw$zza$zzb;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzcg;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbg : Lcom/google/android/gms/internal/clearcut/zzdz;
      //   101: ldc com/google/android/gms/internal/clearcut/zzgw$zza$zzb
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/clearcut/zzgw$zza$zzb
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbiv : Lcom/google/android/gms/internal/clearcut/zzgw$zza$zzb;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/clearcut/zzgw$zza$zzb.zzbiv : Lcom/google/android/gms/internal/clearcut/zzgw$zza$zzb;
      //   122: ldc '     \\b'
      //   124: iconst_5
      //   125: anewarray java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: ldc 'zzbb'
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: ldc 'zzya'
      //   137: aastore
      //   138: dup
      //   139: iconst_2
      //   140: ldc 'zzbis'
      //   142: aastore
      //   143: dup
      //   144: iconst_3
      //   145: ldc 'zzbit'
      //   147: aastore
      //   148: dup
      //   149: iconst_4
      //   150: ldc 'zzbiu'
      //   152: aastore
      //   153: invokestatic zza : (Lcom/google/android/gms/internal/clearcut/zzdo;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   156: areturn
      //   157: new com/google/android/gms/internal/clearcut/zzgw$zza$zzb$zza
      //   160: dup
      //   161: aconst_null
      //   162: invokespecial <init> : (Lcom/google/android/gms/internal/clearcut/zzgx;)V
      //   165: areturn
      //   166: new com/google/android/gms/internal/clearcut/zzgw$zza$zzb
      //   169: dup
      //   170: invokespecial <init> : ()V
      //   173: areturn
      // Exception table:
      //   from	to	target	type
      //   76	80	107	finally
      //   86	101	107	finally
      //   101	104	107	finally
      //   108	111	107	finally
    }
    
    public final boolean zzfv() {
      return ((this.zzbb & 0x1) == 1);
    }
    
    public final String zzfw() {
      return this.zzbis;
    }
    
    public final long zzfx() {
      return this.zzbit;
    }
    
    public final long zzfy() {
      return this.zzbiu;
    }
    
    public static final class zza extends zzcg.zza<zzb, zza> implements zzdq {
      private zza() {
        super(zzgw.zza.zzb.zzga());
      }
      
      public final zza zzn(String param3String) {
        zzbf();
        zzgw.zza.zzb.zza(this.zzjt, param3String);
        return this;
      }
      
      public final zza zzr(long param3Long) {
        zzbf();
        zzgw.zza.zzb.zza(this.zzjt, param3Long);
        return this;
      }
      
      public final zza zzs(long param3Long) {
        zzbf();
        zzgw.zza.zzb.zzb(this.zzjt, param3Long);
        return this;
      }
    }
  }
  
  public static final class zza extends zzcg.zza<zza.zzb, zza.zzb.zza> implements zzdq {
    private zza() {
      super(zzgw.zza.zzb.zzga());
    }
    
    public final zza zzn(String param1String) {
      zzbf();
      zzgw.zza.zzb.zza(this.zzjt, param1String);
      return this;
    }
    
    public final zza zzr(long param1Long) {
      zzbf();
      zzgw.zza.zzb.zza(this.zzjt, param1Long);
      return this;
    }
    
    public final zza zzs(long param1Long) {
      zzbf();
      zzgw.zza.zzb.zzb(this.zzjt, param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */