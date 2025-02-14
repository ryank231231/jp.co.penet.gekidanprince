package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbt {
  public static final class zza extends zzez<zza, zza.zza> implements zzgj {
    private static volatile zzgs<zza> zztq;
    
    private static final zza zzut = new zza();
    
    private int zztj;
    
    private int zzup;
    
    private zzbt.zzf zzuq;
    
    private zzbt.zzf zzur;
    
    private boolean zzus;
    
    static {
      zzez.zza(zza.class, zzut);
    }
    
    private final void zza(zzbt.zzf.zza param1zza) {
      this.zzuq = (zzbt.zzf)param1zza.zzmr();
      this.zztj |= 0x2;
    }
    
    private final void zza(zzbt.zzf param1zzf) {
      if (param1zzf != null) {
        this.zzur = param1zzf;
        this.zztj |= 0x4;
        return;
      } 
      throw new NullPointerException();
    }
    
    public static zzgs<zza> zzgs() {
      return (zzgs<zza>)zzut.zza(zzez.zze.zzaha, (Object)null, (Object)null);
    }
    
    private final void zzh(int param1Int) {
      this.zztj |= 0x1;
      this.zzup = param1Int;
    }
    
    public static zza zzhb() {
      return (zza)zzut.zzmg();
    }
    
    private final void zzk(boolean param1Boolean) {
      this.zztj |= 0x8;
      this.zzus = param1Boolean;
    }
    
    protected final Object zza(int param1Int, Object<zza> param1Object1, Object<zza> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
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
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zza.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zza
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zza.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zza.zzut : Lcom/google/android/gms/internal/measurement/zzbt$zza;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zza.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zza
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zza
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zza.zzut : Lcom/google/android/gms/internal/measurement/zzbt$zza;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbt$zza.zzut : Lcom/google/android/gms/internal/measurement/zzbt$zza;
      //   122: ldc '     \\t\\t'
      //   124: iconst_5
      //   125: anewarray java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: ldc 'zztj'
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: ldc 'zzup'
      //   137: aastore
      //   138: dup
      //   139: iconst_2
      //   140: ldc 'zzuq'
      //   142: aastore
      //   143: dup
      //   144: iconst_3
      //   145: ldc 'zzur'
      //   147: aastore
      //   148: dup
      //   149: iconst_4
      //   150: ldc 'zzus'
      //   152: aastore
      //   153: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   156: areturn
      //   157: new com/google/android/gms/internal/measurement/zzbt$zza$zza
      //   160: dup
      //   161: aconst_null
      //   162: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   165: areturn
      //   166: new com/google/android/gms/internal/measurement/zzbt$zza
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
    
    public final boolean zzgu() {
      return ((this.zztj & 0x1) != 0);
    }
    
    public final int zzgv() {
      return this.zzup;
    }
    
    public final zzbt.zzf zzgw() {
      zzbt.zzf zzf1 = this.zzuq;
      zzbt.zzf zzf2 = zzf1;
      if (zzf1 == null)
        zzf2 = zzbt.zzf.zzij(); 
      return zzf2;
    }
    
    public final boolean zzgx() {
      return ((this.zztj & 0x4) != 0);
    }
    
    public final zzbt.zzf zzgy() {
      zzbt.zzf zzf1 = this.zzur;
      zzbt.zzf zzf2 = zzf1;
      if (zzf1 == null)
        zzf2 = zzbt.zzf.zzij(); 
      return zzf2;
    }
    
    public final boolean zzgz() {
      return ((this.zztj & 0x8) != 0);
    }
    
    public final boolean zzha() {
      return this.zzus;
    }
    
    public static final class zza extends zzez.zza<zza, zza> implements zzgj {
      private zza() {
        super(zzbt.zza.zzhc());
      }
      
      public final zza zzb(zzbt.zzf.zza param2zza) {
        zzmn();
        zzbt.zza.zza(this.zzagr, param2zza);
        return this;
      }
      
      public final zza zzb(zzbt.zzf param2zzf) {
        zzmn();
        zzbt.zza.zza(this.zzagr, param2zzf);
        return this;
      }
      
      public final zzbt.zzf zzgw() {
        return this.zzagr.zzgw();
      }
      
      public final boolean zzgx() {
        return this.zzagr.zzgx();
      }
      
      public final zzbt.zzf zzgy() {
        return this.zzagr.zzgy();
      }
      
      public final zza zzi(int param2Int) {
        zzmn();
        zzbt.zza.zza(this.zzagr, param2Int);
        return this;
      }
      
      public final zza zzl(boolean param2Boolean) {
        zzmn();
        zzbt.zza.zza(this.zzagr, param2Boolean);
        return this;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zza, zza.zza> implements zzgj {
    private zza() {
      super(zzbt.zza.zzhc());
    }
    
    public final zza zzb(zzbt.zzf.zza param1zza) {
      zzmn();
      zzbt.zza.zza(this.zzagr, param1zza);
      return this;
    }
    
    public final zza zzb(zzbt.zzf param1zzf) {
      zzmn();
      zzbt.zza.zza(this.zzagr, param1zzf);
      return this;
    }
    
    public final zzbt.zzf zzgw() {
      return this.zzagr.zzgw();
    }
    
    public final boolean zzgx() {
      return this.zzagr.zzgx();
    }
    
    public final zzbt.zzf zzgy() {
      return this.zzagr.zzgy();
    }
    
    public final zza zzi(int param1Int) {
      zzmn();
      zzbt.zza.zza(this.zzagr, param1Int);
      return this;
    }
    
    public final zza zzl(boolean param1Boolean) {
      zzmn();
      zzbt.zza.zza(this.zzagr, param1Boolean);
      return this;
    }
  }
  
  public static final class zzb extends zzez<zzb, zzb.zza> implements zzgj {
    private static volatile zzgs<zzb> zztq;
    
    private static final zzb zzuw = new zzb();
    
    private int zztj;
    
    private int zzuu;
    
    private long zzuv;
    
    static {
      zzez.zza(zzb.class, zzuw);
    }
    
    private final void setIndex(int param1Int) {
      this.zztj |= 0x1;
      this.zzuu = param1Int;
    }
    
    private final void zzaf(long param1Long) {
      this.zztj |= 0x2;
      this.zzuv = param1Long;
    }
    
    public static zza zzhg() {
      return (zza)zzuw.zzmg();
    }
    
    public final int getIndex() {
      return this.zzuu;
    }
    
    protected final Object zza(int param1Int, Object<zzb> param1Object1, Object<zzb> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
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
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zzb.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zzb
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zzb.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zzb.zzuw : Lcom/google/android/gms/internal/measurement/zzbt$zzb;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zzb.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zzb
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zzb
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zzb.zzuw : Lcom/google/android/gms/internal/measurement/zzbt$zzb;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbt$zzb.zzuw : Lcom/google/android/gms/internal/measurement/zzbt$zzb;
      //   122: ldc '     '
      //   124: iconst_3
      //   125: anewarray java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: ldc 'zztj'
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: ldc 'zzuu'
      //   137: aastore
      //   138: dup
      //   139: iconst_2
      //   140: ldc 'zzuv'
      //   142: aastore
      //   143: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   146: areturn
      //   147: new com/google/android/gms/internal/measurement/zzbt$zzb$zza
      //   150: dup
      //   151: aconst_null
      //   152: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   155: areturn
      //   156: new com/google/android/gms/internal/measurement/zzbt$zzb
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
    
    public final boolean zzhd() {
      return ((this.zztj & 0x1) != 0);
    }
    
    public final boolean zzhe() {
      return ((this.zztj & 0x2) != 0);
    }
    
    public final long zzhf() {
      return this.zzuv;
    }
    
    public static final class zza extends zzez.zza<zzb, zza> implements zzgj {
      private zza() {
        super(zzbt.zzb.zzhh());
      }
      
      public final zza zzag(long param2Long) {
        zzmn();
        zzbt.zzb.zza(this.zzagr, param2Long);
        return this;
      }
      
      public final zza zzj(int param2Int) {
        zzmn();
        zzbt.zzb.zza(this.zzagr, param2Int);
        return this;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zzb, zzb.zza> implements zzgj {
    private zza() {
      super(zzbt.zzb.zzhh());
    }
    
    public final zza zzag(long param1Long) {
      zzmn();
      zzbt.zzb.zza(this.zzagr, param1Long);
      return this;
    }
    
    public final zza zzj(int param1Int) {
      zzmn();
      zzbt.zzb.zza(this.zzagr, param1Int);
      return this;
    }
  }
  
  public static final class zzc extends zzez<zzc, zzc.zza> implements zzgj {
    private static volatile zzgs<zzc> zztq;
    
    private static final zzc zzuz = new zzc();
    
    private int zztj;
    
    private String zzux = "";
    
    private long zzuy;
    
    static {
      zzez.zza(zzc.class, zzuz);
    }
    
    private final void setName(String param1String) {
      if (param1String != null) {
        this.zztj |= 0x1;
        this.zzux = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private final void zzah(long param1Long) {
      this.zztj |= 0x2;
      this.zzuy = param1Long;
    }
    
    public static zza zzhi() {
      return (zza)zzuz.zzmg();
    }
    
    protected final Object zza(int param1Int, Object<zzc> param1Object1, Object<zzc> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
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
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zzc.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zzc
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zzc.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zzc.zzuz : Lcom/google/android/gms/internal/measurement/zzbt$zzc;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zzc.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zzc
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zzc
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zzc.zzuz : Lcom/google/android/gms/internal/measurement/zzbt$zzc;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbt$zzc.zzuz : Lcom/google/android/gms/internal/measurement/zzbt$zzc;
      //   122: ldc '    \\b '
      //   124: iconst_3
      //   125: anewarray java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: ldc 'zztj'
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: ldc 'zzux'
      //   137: aastore
      //   138: dup
      //   139: iconst_2
      //   140: ldc 'zzuy'
      //   142: aastore
      //   143: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   146: areturn
      //   147: new com/google/android/gms/internal/measurement/zzbt$zzc$zza
      //   150: dup
      //   151: aconst_null
      //   152: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   155: areturn
      //   156: new com/google/android/gms/internal/measurement/zzbt$zzc
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
    
    public static final class zza extends zzez.zza<zzc, zza> implements zzgj {
      private zza() {
        super(zzbt.zzc.zzhj());
      }
      
      public final zza zzai(long param2Long) {
        zzmn();
        zzbt.zzc.zza(this.zzagr, param2Long);
        return this;
      }
      
      public final zza zzbu(String param2String) {
        zzmn();
        zzbt.zzc.zza(this.zzagr, param2String);
        return this;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zzc, zzc.zza> implements zzgj {
    private zza() {
      super(zzbt.zzc.zzhj());
    }
    
    public final zza zzai(long param1Long) {
      zzmn();
      zzbt.zzc.zza(this.zzagr, param1Long);
      return this;
    }
    
    public final zza zzbu(String param1String) {
      zzmn();
      zzbt.zzc.zza(this.zzagr, param1String);
      return this;
    }
  }
  
  public static final class zzd extends zzez<zzd, zzd.zza> implements zzgj {
    private static volatile zzgs<zzd> zztq;
    
    private static final zzd zzvd = new zzd();
    
    private int zztj;
    
    private String zzux = "";
    
    private long zzuy;
    
    private String zzva = "";
    
    private float zzvb;
    
    private double zzvc;
    
    static {
      zzez.zza(zzd.class, zzvd);
    }
    
    private final void setName(String param1String) {
      if (param1String != null) {
        this.zztj |= 0x1;
        this.zzux = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private final void zza(double param1Double) {
      this.zztj |= 0x10;
      this.zzvc = param1Double;
    }
    
    private final void zzah(long param1Long) {
      this.zztj |= 0x4;
      this.zzuy = param1Long;
    }
    
    private final void zzbv(String param1String) {
      if (param1String != null) {
        this.zztj |= 0x2;
        this.zzva = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    public static zzgs<zzd> zzgs() {
      return (zzgs<zzd>)zzvd.zza(zzez.zze.zzaha, (Object)null, (Object)null);
    }
    
    private final void zzhm() {
      this.zztj &= 0xFFFFFFFD;
      this.zzva = zzvd.zzva;
    }
    
    private final void zzhp() {
      this.zztj &= 0xFFFFFFFB;
      this.zzuy = 0L;
    }
    
    private final void zzhs() {
      this.zztj &= 0xFFFFFFEF;
      this.zzvc = 0.0D;
    }
    
    public static zza zzht() {
      return (zza)zzvd.zzmg();
    }
    
    public final String getName() {
      return this.zzux;
    }
    
    protected final Object zza(int param1Int, Object<zzd> param1Object1, Object<zzd> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
      //   3: iload_1
      //   4: iconst_1
      //   5: isub
      //   6: iaload
      //   7: tableswitch default -> 48, 1 -> 172, 2 -> 163, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
      //   48: new java/lang/UnsupportedOperationException
      //   51: dup
      //   52: invokespecial <init> : ()V
      //   55: athrow
      //   56: aconst_null
      //   57: areturn
      //   58: iconst_1
      //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
      //   62: areturn
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zzd.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zzd
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zzd.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zzd.zzvd : Lcom/google/android/gms/internal/measurement/zzbt$zzd;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zzd.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zzd
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zzd
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zzd.zzvd : Lcom/google/android/gms/internal/measurement/zzbt$zzd;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbt$zzd.zzvd : Lcom/google/android/gms/internal/measurement/zzbt$zzd;
      //   122: ldc '    \\b \\b '
      //   124: bipush #6
      //   126: anewarray java/lang/Object
      //   129: dup
      //   130: iconst_0
      //   131: ldc 'zztj'
      //   133: aastore
      //   134: dup
      //   135: iconst_1
      //   136: ldc 'zzux'
      //   138: aastore
      //   139: dup
      //   140: iconst_2
      //   141: ldc 'zzva'
      //   143: aastore
      //   144: dup
      //   145: iconst_3
      //   146: ldc 'zzuy'
      //   148: aastore
      //   149: dup
      //   150: iconst_4
      //   151: ldc 'zzvb'
      //   153: aastore
      //   154: dup
      //   155: iconst_5
      //   156: ldc 'zzvc'
      //   158: aastore
      //   159: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   162: areturn
      //   163: new com/google/android/gms/internal/measurement/zzbt$zzd$zza
      //   166: dup
      //   167: aconst_null
      //   168: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   171: areturn
      //   172: new com/google/android/gms/internal/measurement/zzbt$zzd
      //   175: dup
      //   176: invokespecial <init> : ()V
      //   179: areturn
      // Exception table:
      //   from	to	target	type
      //   76	80	107	finally
      //   86	101	107	finally
      //   101	104	107	finally
      //   108	111	107	finally
    }
    
    public final boolean zzhk() {
      return ((this.zztj & 0x2) != 0);
    }
    
    public final String zzhl() {
      return this.zzva;
    }
    
    public final boolean zzhn() {
      return ((this.zztj & 0x4) != 0);
    }
    
    public final long zzho() {
      return this.zzuy;
    }
    
    public final boolean zzhq() {
      return ((this.zztj & 0x10) != 0);
    }
    
    public final double zzhr() {
      return this.zzvc;
    }
    
    public static final class zza extends zzez.zza<zzd, zza> implements zzgj {
      private zza() {
        super(zzbt.zzd.zzhu());
      }
      
      public final String getName() {
        return this.zzagr.getName();
      }
      
      public final zza zzaj(long param2Long) {
        zzmn();
        zzbt.zzd.zza(this.zzagr, param2Long);
        return this;
      }
      
      public final zza zzb(double param2Double) {
        zzmn();
        zzbt.zzd.zza(this.zzagr, param2Double);
        return this;
      }
      
      public final zza zzbw(String param2String) {
        zzmn();
        zzbt.zzd.zza(this.zzagr, param2String);
        return this;
      }
      
      public final zza zzbx(String param2String) {
        zzmn();
        zzbt.zzd.zzb(this.zzagr, param2String);
        return this;
      }
      
      public final zza zzhv() {
        zzmn();
        zzbt.zzd.zza(this.zzagr);
        return this;
      }
      
      public final zza zzhw() {
        zzmn();
        zzbt.zzd.zzb(this.zzagr);
        return this;
      }
      
      public final zza zzhx() {
        zzmn();
        zzbt.zzd.zzc(this.zzagr);
        return this;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zzd, zzd.zza> implements zzgj {
    private zza() {
      super(zzbt.zzd.zzhu());
    }
    
    public final String getName() {
      return this.zzagr.getName();
    }
    
    public final zza zzaj(long param1Long) {
      zzmn();
      zzbt.zzd.zza(this.zzagr, param1Long);
      return this;
    }
    
    public final zza zzb(double param1Double) {
      zzmn();
      zzbt.zzd.zza(this.zzagr, param1Double);
      return this;
    }
    
    public final zza zzbw(String param1String) {
      zzmn();
      zzbt.zzd.zza(this.zzagr, param1String);
      return this;
    }
    
    public final zza zzbx(String param1String) {
      zzmn();
      zzbt.zzd.zzb(this.zzagr, param1String);
      return this;
    }
    
    public final zza zzhv() {
      zzmn();
      zzbt.zzd.zza(this.zzagr);
      return this;
    }
    
    public final zza zzhw() {
      zzmn();
      zzbt.zzd.zzb(this.zzagr);
      return this;
    }
    
    public final zza zzhx() {
      zzmn();
      zzbt.zzd.zzc(this.zzagr);
      return this;
    }
  }
  
  public static final class zze extends zzez<zze, zze.zza> implements zzgj {
    private static volatile zzgs<zze> zztq;
    
    private static final zze zzvg = new zze();
    
    private int zztj;
    
    private int zzve = 1;
    
    private zzfg<zzbt.zzc> zzvf = zzmj();
    
    static {
      zzez.zza(zze.class, zzvg);
    }
    
    private final void zza(zzbt.zzc.zza param1zza) {
      if (!this.zzvf.zzjy())
        this.zzvf = zzez.zza(this.zzvf); 
      this.zzvf.add((zzbt.zzc)param1zza.zzmr());
    }
    
    public static zzgs<zze> zzgs() {
      return (zzgs<zze>)zzvg.zza(zzez.zze.zzaha, (Object)null, (Object)null);
    }
    
    public static zza zzhy() {
      return (zza)zzvg.zzmg();
    }
    
    protected final Object zza(int param1Int, Object<zze> param1Object1, Object<zze> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
      //   3: iload_1
      //   4: iconst_1
      //   5: isub
      //   6: iaload
      //   7: tableswitch default -> 48, 1 -> 169, 2 -> 160, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
      //   48: new java/lang/UnsupportedOperationException
      //   51: dup
      //   52: invokespecial <init> : ()V
      //   55: athrow
      //   56: aconst_null
      //   57: areturn
      //   58: iconst_1
      //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
      //   62: areturn
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zze.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zze
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zze.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zze.zzvg : Lcom/google/android/gms/internal/measurement/zzbt$zze;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zze.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zze
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zze
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zze.zzvg : Lcom/google/android/gms/internal/measurement/zzbt$zze;
      //   118: areturn
      //   119: invokestatic zzgq : ()Lcom/google/android/gms/internal/measurement/zzfe;
      //   122: astore_2
      //   123: getstatic com/google/android/gms/internal/measurement/zzbt$zze.zzvg : Lcom/google/android/gms/internal/measurement/zzbt$zze;
      //   126: ldc '   \\f '
      //   128: iconst_5
      //   129: anewarray java/lang/Object
      //   132: dup
      //   133: iconst_0
      //   134: ldc 'zztj'
      //   136: aastore
      //   137: dup
      //   138: iconst_1
      //   139: ldc 'zzve'
      //   141: aastore
      //   142: dup
      //   143: iconst_2
      //   144: aload_2
      //   145: aastore
      //   146: dup
      //   147: iconst_3
      //   148: ldc 'zzvf'
      //   150: aastore
      //   151: dup
      //   152: iconst_4
      //   153: ldc com/google/android/gms/internal/measurement/zzbt$zzc
      //   155: aastore
      //   156: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   159: areturn
      //   160: new com/google/android/gms/internal/measurement/zzbt$zze$zza
      //   163: dup
      //   164: aconst_null
      //   165: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   168: areturn
      //   169: new com/google/android/gms/internal/measurement/zzbt$zze
      //   172: dup
      //   173: invokespecial <init> : ()V
      //   176: areturn
      // Exception table:
      //   from	to	target	type
      //   76	80	107	finally
      //   86	101	107	finally
      //   101	104	107	finally
      //   108	111	107	finally
    }
    
    public static final class zza extends zzez.zza<zze, zza> implements zzgj {
      private zza() {
        super(zzbt.zze.zzhz());
      }
      
      public final zza zzb(zzbt.zzc.zza param2zza) {
        zzmn();
        zzbt.zze.zza(this.zzagr, param2zza);
        return this;
      }
    }
    
    public enum zzb implements zzfc {
      zzvh(1),
      zzvi(2);
      
      private static final zzfd<zzb> zztw = new zzbv();
      
      private final int value;
      
      static {
      
      }
      
      zzb(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static zzfe zzgq() {
        return zzbw.zzty;
      }
      
      public static zzb zzk(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return zzvi;
          case 1:
            break;
        } 
        return zzvh;
      }
      
      public final int zzgp() {
        return this.value;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zze, zze.zza> implements zzgj {
    private zza() {
      super(zzbt.zze.zzhz());
    }
    
    public final zza zzb(zzbt.zzc.zza param1zza) {
      zzmn();
      zzbt.zze.zza(this.zzagr, param1zza);
      return this;
    }
  }
  
  public enum zzb implements zzfc {
    zzvh(1),
    zzvi(2);
    
    private static final zzfd<zzb> zztw = new zzbv();
    
    private final int value;
    
    static {
    
    }
    
    zzb(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static zzfe zzgq() {
      return zzbw.zzty;
    }
    
    public static zzb zzk(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return zzvi;
        case 1:
          break;
      } 
      return zzvh;
    }
    
    public final int zzgp() {
      return this.value;
    }
  }
  
  public static final class zzf extends zzez<zzf, zzf.zza> implements zzgj {
    private static volatile zzgs<zzf> zztq;
    
    private static final zzf zzvo = new zzf();
    
    private zzff zzvk = zzmi();
    
    private zzff zzvl = zzmi();
    
    private zzfg<zzbt.zzb> zzvm = zzmj();
    
    private zzfg<zzbt.zzg> zzvn = zzmj();
    
    static {
      zzez.zza(zzf.class, zzvo);
    }
    
    public static zzf zza(byte[] param1ArrayOfbyte, zzem param1zzem) throws zzfh {
      return zzez.<zzf>zza(zzvo, param1ArrayOfbyte, param1zzem);
    }
    
    private final void zza(Iterable<? extends Long> param1Iterable) {
      if (!this.zzvk.zzjy())
        this.zzvk = zzez.zza(this.zzvk); 
      zzdg.zza(param1Iterable, this.zzvk);
    }
    
    private final void zzb(Iterable<? extends Long> param1Iterable) {
      if (!this.zzvl.zzjy())
        this.zzvl = zzez.zza(this.zzvl); 
      zzdg.zza(param1Iterable, this.zzvl);
    }
    
    private final void zzc(Iterable<? extends zzbt.zzb> param1Iterable) {
      if (!this.zzvm.zzjy())
        this.zzvm = zzez.zza(this.zzvm); 
      zzdg.zza(param1Iterable, this.zzvm);
    }
    
    private final void zzd(Iterable<? extends zzbt.zzg> param1Iterable) {
      if (!this.zzvn.zzjy())
        this.zzvn = zzez.zza(this.zzvn); 
      zzdg.zza(param1Iterable, this.zzvn);
    }
    
    public static zza zzii() {
      return (zza)zzvo.zzmg();
    }
    
    public static zzf zzij() {
      return zzvo;
    }
    
    protected final Object zza(int param1Int, Object<zzf> param1Object1, Object<zzf> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
      //   3: iload_1
      //   4: iconst_1
      //   5: isub
      //   6: iaload
      //   7: tableswitch default -> 48, 1 -> 172, 2 -> 163, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
      //   48: new java/lang/UnsupportedOperationException
      //   51: dup
      //   52: invokespecial <init> : ()V
      //   55: athrow
      //   56: aconst_null
      //   57: areturn
      //   58: iconst_1
      //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
      //   62: areturn
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zzf.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zzf
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zzf.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zzf.zzvo : Lcom/google/android/gms/internal/measurement/zzbt$zzf;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zzf.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zzf
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zzf
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zzf.zzvo : Lcom/google/android/gms/internal/measurement/zzbt$zzf;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbt$zzf.zzvo : Lcom/google/android/gms/internal/measurement/zzbt$zzf;
      //   122: ldc '    '
      //   124: bipush #6
      //   126: anewarray java/lang/Object
      //   129: dup
      //   130: iconst_0
      //   131: ldc 'zzvk'
      //   133: aastore
      //   134: dup
      //   135: iconst_1
      //   136: ldc 'zzvl'
      //   138: aastore
      //   139: dup
      //   140: iconst_2
      //   141: ldc 'zzvm'
      //   143: aastore
      //   144: dup
      //   145: iconst_3
      //   146: ldc com/google/android/gms/internal/measurement/zzbt$zzb
      //   148: aastore
      //   149: dup
      //   150: iconst_4
      //   151: ldc 'zzvn'
      //   153: aastore
      //   154: dup
      //   155: iconst_5
      //   156: ldc com/google/android/gms/internal/measurement/zzbt$zzg
      //   158: aastore
      //   159: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   162: areturn
      //   163: new com/google/android/gms/internal/measurement/zzbt$zzf$zza
      //   166: dup
      //   167: aconst_null
      //   168: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   171: areturn
      //   172: new com/google/android/gms/internal/measurement/zzbt$zzf
      //   175: dup
      //   176: invokespecial <init> : ()V
      //   179: areturn
      // Exception table:
      //   from	to	target	type
      //   76	80	107	finally
      //   86	101	107	finally
      //   101	104	107	finally
      //   108	111	107	finally
    }
    
    public final List<Long> zzia() {
      return this.zzvk;
    }
    
    public final int zzib() {
      return this.zzvk.size();
    }
    
    public final List<Long> zzic() {
      return this.zzvl;
    }
    
    public final int zzid() {
      return this.zzvl.size();
    }
    
    public final List<zzbt.zzb> zzie() {
      return this.zzvm;
    }
    
    public final int zzif() {
      return this.zzvm.size();
    }
    
    public final List<zzbt.zzg> zzig() {
      return this.zzvn;
    }
    
    public final int zzih() {
      return this.zzvn.size();
    }
    
    public static final class zza extends zzez.zza<zzf, zza> implements zzgj {
      private zza() {
        super(zzbt.zzf.zzik());
      }
      
      public final zza zze(Iterable<? extends Long> param2Iterable) {
        zzmn();
        zzbt.zzf.zza(this.zzagr, param2Iterable);
        return this;
      }
      
      public final zza zzf(Iterable<? extends Long> param2Iterable) {
        zzmn();
        zzbt.zzf.zzb(this.zzagr, param2Iterable);
        return this;
      }
      
      public final zza zzg(Iterable<? extends zzbt.zzb> param2Iterable) {
        zzmn();
        zzbt.zzf.zzc(this.zzagr, param2Iterable);
        return this;
      }
      
      public final zza zzh(Iterable<? extends zzbt.zzg> param2Iterable) {
        zzmn();
        zzbt.zzf.zzd(this.zzagr, param2Iterable);
        return this;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zzf, zzf.zza> implements zzgj {
    private zza() {
      super(zzbt.zzf.zzik());
    }
    
    public final zza zze(Iterable<? extends Long> param1Iterable) {
      zzmn();
      zzbt.zzf.zza(this.zzagr, param1Iterable);
      return this;
    }
    
    public final zza zzf(Iterable<? extends Long> param1Iterable) {
      zzmn();
      zzbt.zzf.zzb(this.zzagr, param1Iterable);
      return this;
    }
    
    public final zza zzg(Iterable<? extends zzbt.zzb> param1Iterable) {
      zzmn();
      zzbt.zzf.zzc(this.zzagr, param1Iterable);
      return this;
    }
    
    public final zza zzh(Iterable<? extends zzbt.zzg> param1Iterable) {
      zzmn();
      zzbt.zzf.zzd(this.zzagr, param1Iterable);
      return this;
    }
  }
  
  public static final class zzg extends zzez<zzg, zzg.zza> implements zzgj {
    private static volatile zzgs<zzg> zztq;
    
    private static final zzg zzvq = new zzg();
    
    private int zztj;
    
    private int zzuu;
    
    private zzff zzvp = zzmi();
    
    static {
      zzez.zza(zzg.class, zzvq);
    }
    
    private final void setIndex(int param1Int) {
      this.zztj |= 0x1;
      this.zzuu = param1Int;
    }
    
    private final void zzak(long param1Long) {
      zzin();
      this.zzvp.zzbb(param1Long);
    }
    
    private final void zzi(Iterable<? extends Long> param1Iterable) {
      zzin();
      zzdg.zza(param1Iterable, this.zzvp);
    }
    
    private final void zzin() {
      if (!this.zzvp.zzjy())
        this.zzvp = zzez.zza(this.zzvp); 
    }
    
    private final void zzio() {
      this.zzvp = zzmi();
    }
    
    public static zza zzip() {
      return (zza)zzvq.zzmg();
    }
    
    public final int getIndex() {
      return this.zzuu;
    }
    
    protected final Object zza(int param1Int, Object<zzg> param1Object1, Object<zzg> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
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
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zzg.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zzg
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zzg.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zzg.zzvq : Lcom/google/android/gms/internal/measurement/zzbt$zzg;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zzg.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zzg
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zzg
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zzg.zzvq : Lcom/google/android/gms/internal/measurement/zzbt$zzg;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbt$zzg.zzvq : Lcom/google/android/gms/internal/measurement/zzbt$zzg;
      //   122: ldc '    '
      //   124: iconst_3
      //   125: anewarray java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: ldc 'zztj'
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: ldc 'zzuu'
      //   137: aastore
      //   138: dup
      //   139: iconst_2
      //   140: ldc 'zzvp'
      //   142: aastore
      //   143: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   146: areturn
      //   147: new com/google/android/gms/internal/measurement/zzbt$zzg$zza
      //   150: dup
      //   151: aconst_null
      //   152: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   155: areturn
      //   156: new com/google/android/gms/internal/measurement/zzbt$zzg
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
    
    public final boolean zzhd() {
      return ((this.zztj & 0x1) != 0);
    }
    
    public final List<Long> zzil() {
      return this.zzvp;
    }
    
    public final int zzim() {
      return this.zzvp.size();
    }
    
    public final long zzl(int param1Int) {
      return this.zzvp.getLong(param1Int);
    }
    
    public static final class zza extends zzez.zza<zzg, zza> implements zzgj {
      private zza() {
        super(zzbt.zzg.zziq());
      }
      
      public final zza zzal(long param2Long) {
        zzmn();
        zzbt.zzg.zza(this.zzagr, param2Long);
        return this;
      }
      
      public final zza zzir() {
        zzmn();
        zzbt.zzg.zza(this.zzagr);
        return this;
      }
      
      public final zza zzj(Iterable<? extends Long> param2Iterable) {
        zzmn();
        zzbt.zzg.zza(this.zzagr, param2Iterable);
        return this;
      }
      
      public final zza zzm(int param2Int) {
        zzmn();
        zzbt.zzg.zza(this.zzagr, param2Int);
        return this;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zzg, zzg.zza> implements zzgj {
    private zza() {
      super(zzbt.zzg.zziq());
    }
    
    public final zza zzal(long param1Long) {
      zzmn();
      zzbt.zzg.zza(this.zzagr, param1Long);
      return this;
    }
    
    public final zza zzir() {
      zzmn();
      zzbt.zzg.zza(this.zzagr);
      return this;
    }
    
    public final zza zzj(Iterable<? extends Long> param1Iterable) {
      zzmn();
      zzbt.zzg.zza(this.zzagr, param1Iterable);
      return this;
    }
    
    public final zza zzm(int param1Int) {
      zzmn();
      zzbt.zzg.zza(this.zzagr, param1Int);
      return this;
    }
  }
  
  public static final class zzh extends zzez<zzh, zzh.zza> implements zzgj {
    private static volatile zzgs<zzh> zztq;
    
    private static final zzh zzvs = new zzh();
    
    private int zztj;
    
    private String zzux = "";
    
    private long zzuy;
    
    private String zzva = "";
    
    private float zzvb;
    
    private double zzvc;
    
    private long zzvr;
    
    static {
      zzez.zza(zzh.class, zzvs);
    }
    
    private final void setName(String param1String) {
      if (param1String != null) {
        this.zztj |= 0x2;
        this.zzux = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private final void zza(double param1Double) {
      this.zztj |= 0x20;
      this.zzvc = param1Double;
    }
    
    private final void zzah(long param1Long) {
      this.zztj |= 0x8;
      this.zzuy = param1Long;
    }
    
    private final void zzam(long param1Long) {
      this.zztj |= 0x1;
      this.zzvr = param1Long;
    }
    
    private final void zzbv(String param1String) {
      if (param1String != null) {
        this.zztj |= 0x4;
        this.zzva = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    public static zzgs<zzh> zzgs() {
      return (zzgs<zzh>)zzvs.zza(zzez.zze.zzaha, (Object)null, (Object)null);
    }
    
    private final void zzhm() {
      this.zztj &= 0xFFFFFFFB;
      this.zzva = zzvs.zzva;
    }
    
    private final void zzhp() {
      this.zztj &= 0xFFFFFFF7;
      this.zzuy = 0L;
    }
    
    private final void zzhs() {
      this.zztj &= 0xFFFFFFDF;
      this.zzvc = 0.0D;
    }
    
    public static zza zziu() {
      return (zza)zzvs.zzmg();
    }
    
    public final String getName() {
      return this.zzux;
    }
    
    protected final Object zza(int param1Int, Object<zzh> param1Object1, Object<zzh> param1Object2) {
      // Byte code:
      //   0: getstatic com/google/android/gms/internal/measurement/zzbu.zzti : [I
      //   3: iload_1
      //   4: iconst_1
      //   5: isub
      //   6: iaload
      //   7: tableswitch default -> 48, 1 -> 178, 2 -> 169, 3 -> 119, 4 -> 115, 5 -> 63, 6 -> 58, 7 -> 56
      //   48: new java/lang/UnsupportedOperationException
      //   51: dup
      //   52: invokespecial <init> : ()V
      //   55: athrow
      //   56: aconst_null
      //   57: areturn
      //   58: iconst_1
      //   59: invokestatic valueOf : (B)Ljava/lang/Byte;
      //   62: areturn
      //   63: getstatic com/google/android/gms/internal/measurement/zzbt$zzh.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   66: astore_3
      //   67: aload_3
      //   68: astore_2
      //   69: aload_3
      //   70: ifnonnull -> 113
      //   73: ldc com/google/android/gms/internal/measurement/zzbt$zzh
      //   75: monitorenter
      //   76: getstatic com/google/android/gms/internal/measurement/zzbt$zzh.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   79: astore_3
      //   80: aload_3
      //   81: astore_2
      //   82: aload_3
      //   83: ifnonnull -> 101
      //   86: new com/google/android/gms/internal/measurement/zzez$zzb
      //   89: astore_2
      //   90: aload_2
      //   91: getstatic com/google/android/gms/internal/measurement/zzbt$zzh.zzvs : Lcom/google/android/gms/internal/measurement/zzbt$zzh;
      //   94: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzez;)V
      //   97: aload_2
      //   98: putstatic com/google/android/gms/internal/measurement/zzbt$zzh.zztq : Lcom/google/android/gms/internal/measurement/zzgs;
      //   101: ldc com/google/android/gms/internal/measurement/zzbt$zzh
      //   103: monitorexit
      //   104: goto -> 113
      //   107: astore_2
      //   108: ldc com/google/android/gms/internal/measurement/zzbt$zzh
      //   110: monitorexit
      //   111: aload_2
      //   112: athrow
      //   113: aload_2
      //   114: areturn
      //   115: getstatic com/google/android/gms/internal/measurement/zzbt$zzh.zzvs : Lcom/google/android/gms/internal/measurement/zzbt$zzh;
      //   118: areturn
      //   119: getstatic com/google/android/gms/internal/measurement/zzbt$zzh.zzvs : Lcom/google/android/gms/internal/measurement/zzbt$zzh;
      //   122: ldc '     \\b\\b '
      //   124: bipush #7
      //   126: anewarray java/lang/Object
      //   129: dup
      //   130: iconst_0
      //   131: ldc 'zztj'
      //   133: aastore
      //   134: dup
      //   135: iconst_1
      //   136: ldc 'zzvr'
      //   138: aastore
      //   139: dup
      //   140: iconst_2
      //   141: ldc 'zzux'
      //   143: aastore
      //   144: dup
      //   145: iconst_3
      //   146: ldc 'zzva'
      //   148: aastore
      //   149: dup
      //   150: iconst_4
      //   151: ldc 'zzuy'
      //   153: aastore
      //   154: dup
      //   155: iconst_5
      //   156: ldc 'zzvb'
      //   158: aastore
      //   159: dup
      //   160: bipush #6
      //   162: ldc 'zzvc'
      //   164: aastore
      //   165: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
      //   168: areturn
      //   169: new com/google/android/gms/internal/measurement/zzbt$zzh$zza
      //   172: dup
      //   173: aconst_null
      //   174: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzbu;)V
      //   177: areturn
      //   178: new com/google/android/gms/internal/measurement/zzbt$zzh
      //   181: dup
      //   182: invokespecial <init> : ()V
      //   185: areturn
      // Exception table:
      //   from	to	target	type
      //   76	80	107	finally
      //   86	101	107	finally
      //   101	104	107	finally
      //   108	111	107	finally
    }
    
    public final boolean zzhk() {
      return ((this.zztj & 0x4) != 0);
    }
    
    public final String zzhl() {
      return this.zzva;
    }
    
    public final boolean zzhn() {
      return ((this.zztj & 0x8) != 0);
    }
    
    public final long zzho() {
      return this.zzuy;
    }
    
    public final boolean zzhq() {
      return ((this.zztj & 0x20) != 0);
    }
    
    public final double zzhr() {
      return this.zzvc;
    }
    
    public final boolean zzis() {
      return ((this.zztj & 0x1) != 0);
    }
    
    public final long zzit() {
      return this.zzvr;
    }
    
    public static final class zza extends zzez.zza<zzh, zza> implements zzgj {
      private zza() {
        super(zzbt.zzh.zziv());
      }
      
      public final zza zzan(long param2Long) {
        zzmn();
        zzbt.zzh.zza(this.zzagr, param2Long);
        return this;
      }
      
      public final zza zzao(long param2Long) {
        zzmn();
        zzbt.zzh.zzb(this.zzagr, param2Long);
        return this;
      }
      
      public final zza zzby(String param2String) {
        zzmn();
        zzbt.zzh.zza(this.zzagr, param2String);
        return this;
      }
      
      public final zza zzbz(String param2String) {
        zzmn();
        zzbt.zzh.zzb(this.zzagr, param2String);
        return this;
      }
      
      public final zza zzc(double param2Double) {
        zzmn();
        zzbt.zzh.zza(this.zzagr, param2Double);
        return this;
      }
      
      public final zza zziw() {
        zzmn();
        zzbt.zzh.zza(this.zzagr);
        return this;
      }
      
      public final zza zzix() {
        zzmn();
        zzbt.zzh.zzb(this.zzagr);
        return this;
      }
      
      public final zza zziy() {
        zzmn();
        zzbt.zzh.zzc(this.zzagr);
        return this;
      }
    }
  }
  
  public static final class zza extends zzez.zza<zzh, zzh.zza> implements zzgj {
    private zza() {
      super(zzbt.zzh.zziv());
    }
    
    public final zza zzan(long param1Long) {
      zzmn();
      zzbt.zzh.zza(this.zzagr, param1Long);
      return this;
    }
    
    public final zza zzao(long param1Long) {
      zzmn();
      zzbt.zzh.zzb(this.zzagr, param1Long);
      return this;
    }
    
    public final zza zzby(String param1String) {
      zzmn();
      zzbt.zzh.zza(this.zzagr, param1String);
      return this;
    }
    
    public final zza zzbz(String param1String) {
      zzmn();
      zzbt.zzh.zzb(this.zzagr, param1String);
      return this;
    }
    
    public final zza zzc(double param1Double) {
      zzmn();
      zzbt.zzh.zza(this.zzagr, param1Double);
      return this;
    }
    
    public final zza zziw() {
      zzmn();
      zzbt.zzh.zza(this.zzagr);
      return this;
    }
    
    public final zza zzix() {
      zzmn();
      zzbt.zzh.zzb(this.zzagr);
      return this;
    }
    
    public final zza zziy() {
      zzmn();
      zzbt.zzh.zzc(this.zzagr);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */