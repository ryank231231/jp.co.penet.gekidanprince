package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzhw {
  private static final Logger logger;
  
  private static final Class<?> zzabq;
  
  private static final boolean zzacv;
  
  private static final Unsafe zzaiz;
  
  private static final boolean zzakw;
  
  private static final boolean zzakx;
  
  private static final zzd zzaky;
  
  private static final boolean zzakz;
  
  private static final long zzala;
  
  private static final long zzalb;
  
  private static final long zzalc;
  
  private static final long zzald;
  
  private static final long zzale;
  
  private static final long zzalf;
  
  private static final long zzalg;
  
  private static final long zzalh;
  
  private static final long zzali;
  
  private static final long zzalj;
  
  private static final long zzalk;
  
  private static final long zzall;
  
  private static final long zzalm;
  
  private static final long zzaln;
  
  private static final boolean zzalo;
  
  static {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/measurement/zzhw
    //   2: invokevirtual getName : ()Ljava/lang/String;
    //   5: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
    //   8: putstatic com/google/android/gms/internal/measurement/zzhw.logger : Ljava/util/logging/Logger;
    //   11: invokestatic zzow : ()Lsun/misc/Unsafe;
    //   14: putstatic com/google/android/gms/internal/measurement/zzhw.zzaiz : Lsun/misc/Unsafe;
    //   17: invokestatic zzkc : ()Ljava/lang/Class;
    //   20: putstatic com/google/android/gms/internal/measurement/zzhw.zzabq : Ljava/lang/Class;
    //   23: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   26: invokestatic zzk : (Ljava/lang/Class;)Z
    //   29: putstatic com/google/android/gms/internal/measurement/zzhw.zzakw : Z
    //   32: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   35: invokestatic zzk : (Ljava/lang/Class;)Z
    //   38: putstatic com/google/android/gms/internal/measurement/zzhw.zzakx : Z
    //   41: getstatic com/google/android/gms/internal/measurement/zzhw.zzaiz : Lsun/misc/Unsafe;
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_0
    //   48: ifnonnull -> 54
    //   51: goto -> 111
    //   54: invokestatic zzkb : ()Z
    //   57: ifeq -> 100
    //   60: getstatic com/google/android/gms/internal/measurement/zzhw.zzakw : Z
    //   63: ifeq -> 80
    //   66: new com/google/android/gms/internal/measurement/zzhw$zzb
    //   69: dup
    //   70: getstatic com/google/android/gms/internal/measurement/zzhw.zzaiz : Lsun/misc/Unsafe;
    //   73: invokespecial <init> : (Lsun/misc/Unsafe;)V
    //   76: astore_1
    //   77: goto -> 111
    //   80: getstatic com/google/android/gms/internal/measurement/zzhw.zzakx : Z
    //   83: ifeq -> 111
    //   86: new com/google/android/gms/internal/measurement/zzhw$zza
    //   89: dup
    //   90: getstatic com/google/android/gms/internal/measurement/zzhw.zzaiz : Lsun/misc/Unsafe;
    //   93: invokespecial <init> : (Lsun/misc/Unsafe;)V
    //   96: astore_1
    //   97: goto -> 111
    //   100: new com/google/android/gms/internal/measurement/zzhw$zzc
    //   103: dup
    //   104: getstatic com/google/android/gms/internal/measurement/zzhw.zzaiz : Lsun/misc/Unsafe;
    //   107: invokespecial <init> : (Lsun/misc/Unsafe;)V
    //   110: astore_1
    //   111: aload_1
    //   112: putstatic com/google/android/gms/internal/measurement/zzhw.zzaky : Lcom/google/android/gms/internal/measurement/zzhw$zzd;
    //   115: invokestatic zzoy : ()Z
    //   118: putstatic com/google/android/gms/internal/measurement/zzhw.zzakz : Z
    //   121: invokestatic zzox : ()Z
    //   124: putstatic com/google/android/gms/internal/measurement/zzhw.zzacv : Z
    //   127: ldc [B
    //   129: invokestatic zzi : (Ljava/lang/Class;)I
    //   132: i2l
    //   133: putstatic com/google/android/gms/internal/measurement/zzhw.zzala : J
    //   136: ldc [Z
    //   138: invokestatic zzi : (Ljava/lang/Class;)I
    //   141: i2l
    //   142: putstatic com/google/android/gms/internal/measurement/zzhw.zzalb : J
    //   145: ldc [Z
    //   147: invokestatic zzj : (Ljava/lang/Class;)I
    //   150: i2l
    //   151: putstatic com/google/android/gms/internal/measurement/zzhw.zzalc : J
    //   154: ldc [I
    //   156: invokestatic zzi : (Ljava/lang/Class;)I
    //   159: i2l
    //   160: putstatic com/google/android/gms/internal/measurement/zzhw.zzald : J
    //   163: ldc [I
    //   165: invokestatic zzj : (Ljava/lang/Class;)I
    //   168: i2l
    //   169: putstatic com/google/android/gms/internal/measurement/zzhw.zzale : J
    //   172: ldc [J
    //   174: invokestatic zzi : (Ljava/lang/Class;)I
    //   177: i2l
    //   178: putstatic com/google/android/gms/internal/measurement/zzhw.zzalf : J
    //   181: ldc [J
    //   183: invokestatic zzj : (Ljava/lang/Class;)I
    //   186: i2l
    //   187: putstatic com/google/android/gms/internal/measurement/zzhw.zzalg : J
    //   190: ldc [F
    //   192: invokestatic zzi : (Ljava/lang/Class;)I
    //   195: i2l
    //   196: putstatic com/google/android/gms/internal/measurement/zzhw.zzalh : J
    //   199: ldc [F
    //   201: invokestatic zzj : (Ljava/lang/Class;)I
    //   204: i2l
    //   205: putstatic com/google/android/gms/internal/measurement/zzhw.zzali : J
    //   208: ldc [D
    //   210: invokestatic zzi : (Ljava/lang/Class;)I
    //   213: i2l
    //   214: putstatic com/google/android/gms/internal/measurement/zzhw.zzalj : J
    //   217: ldc [D
    //   219: invokestatic zzj : (Ljava/lang/Class;)I
    //   222: i2l
    //   223: putstatic com/google/android/gms/internal/measurement/zzhw.zzalk : J
    //   226: ldc [Ljava/lang/Object;
    //   228: invokestatic zzi : (Ljava/lang/Class;)I
    //   231: i2l
    //   232: putstatic com/google/android/gms/internal/measurement/zzhw.zzall : J
    //   235: ldc [Ljava/lang/Object;
    //   237: invokestatic zzj : (Ljava/lang/Class;)I
    //   240: i2l
    //   241: putstatic com/google/android/gms/internal/measurement/zzhw.zzalm : J
    //   244: invokestatic zzoz : ()Ljava/lang/reflect/Field;
    //   247: astore_1
    //   248: aload_1
    //   249: ifnull -> 275
    //   252: getstatic com/google/android/gms/internal/measurement/zzhw.zzaky : Lcom/google/android/gms/internal/measurement/zzhw$zzd;
    //   255: astore_0
    //   256: aload_0
    //   257: ifnonnull -> 263
    //   260: goto -> 275
    //   263: aload_0
    //   264: getfield zzalp : Lsun/misc/Unsafe;
    //   267: aload_1
    //   268: invokevirtual objectFieldOffset : (Ljava/lang/reflect/Field;)J
    //   271: lstore_2
    //   272: goto -> 279
    //   275: ldc2_w -1
    //   278: lstore_2
    //   279: lload_2
    //   280: putstatic com/google/android/gms/internal/measurement/zzhw.zzaln : J
    //   283: invokestatic nativeOrder : ()Ljava/nio/ByteOrder;
    //   286: getstatic java/nio/ByteOrder.BIG_ENDIAN : Ljava/nio/ByteOrder;
    //   289: if_acmpne -> 298
    //   292: iconst_1
    //   293: istore #4
    //   295: goto -> 301
    //   298: iconst_0
    //   299: istore #4
    //   301: iload #4
    //   303: putstatic com/google/android/gms/internal/measurement/zzhw.zzalo : Z
    //   306: return
  }
  
  static byte zza(byte[] paramArrayOfbyte, long paramLong) {
    return zzaky.zzy(paramArrayOfbyte, zzala + paramLong);
  }
  
  static void zza(long paramLong, byte paramByte) {
    zzaky.zza(paramLong, paramByte);
  }
  
  private static void zza(Object paramObject, long paramLong, byte paramByte) {
    long l = 0xFFFFFFFFFFFFFFFCL & paramLong;
    int i = zzk(paramObject, l);
    int j = (((int)paramLong ^ 0xFFFFFFFF) & 0x3) << 3;
    zzb(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static void zza(Object paramObject, long paramLong, double paramDouble) {
    zzaky.zza(paramObject, paramLong, paramDouble);
  }
  
  static void zza(Object paramObject, long paramLong, float paramFloat) {
    zzaky.zza(paramObject, paramLong, paramFloat);
  }
  
  static void zza(Object paramObject, long paramLong1, long paramLong2) {
    zzaky.zza(paramObject, paramLong1, paramLong2);
  }
  
  static void zza(Object paramObject1, long paramLong, Object paramObject2) {
    zzaky.zzalp.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void zza(Object paramObject, long paramLong, boolean paramBoolean) {
    zzaky.zza(paramObject, paramLong, paramBoolean);
  }
  
  static void zza(byte[] paramArrayOfbyte, long paramLong, byte paramByte) {
    zzaky.zze(paramArrayOfbyte, zzala + paramLong, paramByte);
  }
  
  static void zza(byte[] paramArrayOfbyte, long paramLong1, long paramLong2, long paramLong3) {
    zzaky.zza(paramArrayOfbyte, paramLong1, paramLong2, paramLong3);
  }
  
  static long zzb(ByteBuffer paramByteBuffer) {
    return zzaky.zzl(paramByteBuffer, zzaln);
  }
  
  private static Field zzb(Class<?> paramClass, String paramString) {
    try {
      Field field = paramClass.getDeclaredField(paramString);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (Field)throwable;
  }
  
  private static void zzb(Object paramObject, long paramLong, byte paramByte) {
    long l = 0xFFFFFFFFFFFFFFFCL & paramLong;
    int i = zzk(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    zzb(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static void zzb(Object paramObject, long paramLong, int paramInt) {
    zzaky.zzb(paramObject, paramLong, paramInt);
  }
  
  private static void zzb(Object paramObject, long paramLong, boolean paramBoolean) {
    zza(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static void zzc(Object paramObject, long paramLong, boolean paramBoolean) {
    zzb(paramObject, paramLong, (byte)paramBoolean);
  }
  
  static <T> T zzh(Class<T> paramClass) {
    try {
      return (T)zzaiz.allocateInstance(paramClass);
    } catch (InstantiationException instantiationException) {
      throw new IllegalStateException(instantiationException);
    } 
  }
  
  private static int zzi(Class<?> paramClass) {
    return zzacv ? zzaky.zzalp.arrayBaseOffset(paramClass) : -1;
  }
  
  private static int zzj(Class<?> paramClass) {
    return zzacv ? zzaky.zzalp.arrayIndexScale(paramClass) : -1;
  }
  
  static int zzk(Object paramObject, long paramLong) {
    return zzaky.zzk(paramObject, paramLong);
  }
  
  private static boolean zzk(Class<?> paramClass) {
    if (!zzdk.zzkb())
      return false; 
    try {
      Class<?> clazz = zzabq;
      clazz.getMethod("peekLong", new Class[] { paramClass, boolean.class });
      clazz.getMethod("pokeLong", new Class[] { paramClass, long.class, boolean.class });
      clazz.getMethod("pokeInt", new Class[] { paramClass, int.class, boolean.class });
      clazz.getMethod("peekInt", new Class[] { paramClass, boolean.class });
      clazz.getMethod("pokeByte", new Class[] { paramClass, byte.class });
      clazz.getMethod("peekByte", new Class[] { paramClass });
      clazz.getMethod("pokeByteArray", new Class[] { paramClass, byte[].class, int.class, int.class });
      clazz.getMethod("peekByteArray", new Class[] { paramClass, byte[].class, int.class, int.class });
      return true;
    } catch (Throwable throwable) {
      return false;
    } 
  }
  
  static long zzl(Object paramObject, long paramLong) {
    return zzaky.zzl(paramObject, paramLong);
  }
  
  static boolean zzm(Object paramObject, long paramLong) {
    return zzaky.zzm(paramObject, paramLong);
  }
  
  static float zzn(Object paramObject, long paramLong) {
    return zzaky.zzn(paramObject, paramLong);
  }
  
  static double zzo(Object paramObject, long paramLong) {
    return zzaky.zzo(paramObject, paramLong);
  }
  
  static boolean zzou() {
    return zzacv;
  }
  
  static boolean zzov() {
    return zzakz;
  }
  
  static Unsafe zzow() {
    try {
      zzhx zzhx = new zzhx();
      this();
      Unsafe unsafe = AccessController.<Unsafe>doPrivileged(zzhx);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (Unsafe)throwable;
  }
  
  private static boolean zzox() {
    Unsafe unsafe = zzaiz;
    if (unsafe == null)
      return false; 
    try {
      Class<?> clazz = unsafe.getClass();
      clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
      clazz.getMethod("arrayBaseOffset", new Class[] { Class.class });
      clazz.getMethod("arrayIndexScale", new Class[] { Class.class });
      clazz.getMethod("getInt", new Class[] { Object.class, long.class });
      clazz.getMethod("putInt", new Class[] { Object.class, long.class, int.class });
      clazz.getMethod("getLong", new Class[] { Object.class, long.class });
      clazz.getMethod("putLong", new Class[] { Object.class, long.class, long.class });
      clazz.getMethod("getObject", new Class[] { Object.class, long.class });
      clazz.getMethod("putObject", new Class[] { Object.class, long.class, Object.class });
      if (zzdk.zzkb())
        return true; 
      clazz.getMethod("getByte", new Class[] { Object.class, long.class });
      clazz.getMethod("putByte", new Class[] { Object.class, long.class, byte.class });
      clazz.getMethod("getBoolean", new Class[] { Object.class, long.class });
      clazz.getMethod("putBoolean", new Class[] { Object.class, long.class, boolean.class });
      clazz.getMethod("getFloat", new Class[] { Object.class, long.class });
      clazz.getMethod("putFloat", new Class[] { Object.class, long.class, float.class });
      clazz.getMethod("getDouble", new Class[] { Object.class, long.class });
      clazz.getMethod("putDouble", new Class[] { Object.class, long.class, double.class });
      return true;
    } catch (Throwable throwable) {
      Logger logger = logger;
      Level level = Level.WARNING;
      String str = String.valueOf(throwable);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 71);
      stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      stringBuilder.append(str);
      logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", stringBuilder.toString());
      return false;
    } 
  }
  
  private static boolean zzoy() {
    Unsafe unsafe = zzaiz;
    if (unsafe == null)
      return false; 
    try {
      Class<?> clazz = unsafe.getClass();
      clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
      clazz.getMethod("getLong", new Class[] { Object.class, long.class });
      if (zzoz() == null)
        return false; 
      if (zzdk.zzkb())
        return true; 
      clazz.getMethod("getByte", new Class[] { long.class });
      clazz.getMethod("putByte", new Class[] { long.class, byte.class });
      clazz.getMethod("getInt", new Class[] { long.class });
      clazz.getMethod("putInt", new Class[] { long.class, int.class });
      clazz.getMethod("getLong", new Class[] { long.class });
      clazz.getMethod("putLong", new Class[] { long.class, long.class });
      clazz.getMethod("copyMemory", new Class[] { long.class, long.class, long.class });
      clazz.getMethod("copyMemory", new Class[] { Object.class, long.class, Object.class, long.class, long.class });
      return true;
    } catch (Throwable throwable) {
      Logger logger = logger;
      Level level = Level.WARNING;
      String str = String.valueOf(throwable);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 71);
      stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      stringBuilder.append(str);
      logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", stringBuilder.toString());
      return false;
    } 
  }
  
  private static Field zzoz() {
    if (zzdk.zzkb()) {
      Field field1 = zzb(Buffer.class, "effectiveDirectAddress");
      if (field1 != null)
        return field1; 
    } 
    Field field = zzb(Buffer.class, "address");
    return (field != null && field.getType() == long.class) ? field : null;
  }
  
  static Object zzp(Object paramObject, long paramLong) {
    return zzaky.zzalp.getObject(paramObject, paramLong);
  }
  
  private static byte zzq(Object paramObject, long paramLong) {
    return (byte)(zzk(paramObject, 0xFFFFFFFFFFFFFFFCL & paramLong) >>> (int)(((paramLong ^ 0xFFFFFFFFFFFFFFFFL) & 0x3L) << 3L));
  }
  
  private static byte zzr(Object paramObject, long paramLong) {
    return (byte)(zzk(paramObject, 0xFFFFFFFFFFFFFFFCL & paramLong) >>> (int)((paramLong & 0x3L) << 3L));
  }
  
  private static boolean zzs(Object paramObject, long paramLong) {
    return (zzq(paramObject, paramLong) != 0);
  }
  
  private static boolean zzt(Object paramObject, long paramLong) {
    return (zzr(paramObject, paramLong) != 0);
  }
  
  static final class zza extends zzd {
    zza(Unsafe param1Unsafe) {
      super(param1Unsafe);
    }
    
    public final void zza(long param1Long, byte param1Byte) {
      Memory.pokeByte((int)(param1Long & 0xFFFFFFFFFFFFFFFFL), param1Byte);
    }
    
    public final void zza(Object param1Object, long param1Long, double param1Double) {
      zza(param1Object, param1Long, Double.doubleToLongBits(param1Double));
    }
    
    public final void zza(Object param1Object, long param1Long, float param1Float) {
      zzb(param1Object, param1Long, Float.floatToIntBits(param1Float));
    }
    
    public final void zza(Object param1Object, long param1Long, boolean param1Boolean) {
      if (zzhw.zzll()) {
        zzhw.zzd(param1Object, param1Long, param1Boolean);
        return;
      } 
      zzhw.zze(param1Object, param1Long, param1Boolean);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      Memory.pokeByteArray((int)(param1Long2 & 0xFFFFFFFFFFFFFFFFL), param1ArrayOfbyte, (int)param1Long1, (int)param1Long3);
    }
    
    public final void zze(Object param1Object, long param1Long, byte param1Byte) {
      if (zzhw.zzll()) {
        zzhw.zzc(param1Object, param1Long, param1Byte);
        return;
      } 
      zzhw.zzd(param1Object, param1Long, param1Byte);
    }
    
    public final boolean zzm(Object param1Object, long param1Long) {
      return zzhw.zzll() ? zzhw.zzw(param1Object, param1Long) : zzhw.zzx(param1Object, param1Long);
    }
    
    public final float zzn(Object param1Object, long param1Long) {
      return Float.intBitsToFloat(zzk(param1Object, param1Long));
    }
    
    public final double zzo(Object param1Object, long param1Long) {
      return Double.longBitsToDouble(zzl(param1Object, param1Long));
    }
    
    public final byte zzy(Object param1Object, long param1Long) {
      return zzhw.zzll() ? zzhw.zzu(param1Object, param1Long) : zzhw.zzv(param1Object, param1Long);
    }
  }
  
  static final class zzb extends zzd {
    zzb(Unsafe param1Unsafe) {
      super(param1Unsafe);
    }
    
    public final void zza(long param1Long, byte param1Byte) {
      Memory.pokeByte(param1Long, param1Byte);
    }
    
    public final void zza(Object param1Object, long param1Long, double param1Double) {
      zza(param1Object, param1Long, Double.doubleToLongBits(param1Double));
    }
    
    public final void zza(Object param1Object, long param1Long, float param1Float) {
      zzb(param1Object, param1Long, Float.floatToIntBits(param1Float));
    }
    
    public final void zza(Object param1Object, long param1Long, boolean param1Boolean) {
      if (zzhw.zzll()) {
        zzhw.zzd(param1Object, param1Long, param1Boolean);
        return;
      } 
      zzhw.zze(param1Object, param1Long, param1Boolean);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      Memory.pokeByteArray(param1Long2, param1ArrayOfbyte, (int)param1Long1, (int)param1Long3);
    }
    
    public final void zze(Object param1Object, long param1Long, byte param1Byte) {
      if (zzhw.zzll()) {
        zzhw.zzc(param1Object, param1Long, param1Byte);
        return;
      } 
      zzhw.zzd(param1Object, param1Long, param1Byte);
    }
    
    public final boolean zzm(Object param1Object, long param1Long) {
      return zzhw.zzll() ? zzhw.zzw(param1Object, param1Long) : zzhw.zzx(param1Object, param1Long);
    }
    
    public final float zzn(Object param1Object, long param1Long) {
      return Float.intBitsToFloat(zzk(param1Object, param1Long));
    }
    
    public final double zzo(Object param1Object, long param1Long) {
      return Double.longBitsToDouble(zzl(param1Object, param1Long));
    }
    
    public final byte zzy(Object param1Object, long param1Long) {
      return zzhw.zzll() ? zzhw.zzu(param1Object, param1Long) : zzhw.zzv(param1Object, param1Long);
    }
  }
  
  static final class zzc extends zzd {
    zzc(Unsafe param1Unsafe) {
      super(param1Unsafe);
    }
    
    public final void zza(long param1Long, byte param1Byte) {
      this.zzalp.putByte(param1Long, param1Byte);
    }
    
    public final void zza(Object param1Object, long param1Long, double param1Double) {
      this.zzalp.putDouble(param1Object, param1Long, param1Double);
    }
    
    public final void zza(Object param1Object, long param1Long, float param1Float) {
      this.zzalp.putFloat(param1Object, param1Long, param1Float);
    }
    
    public final void zza(Object param1Object, long param1Long, boolean param1Boolean) {
      this.zzalp.putBoolean(param1Object, param1Long, param1Boolean);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      this.zzalp.copyMemory(param1ArrayOfbyte, zzhw.zzpa() + param1Long1, null, param1Long2, param1Long3);
    }
    
    public final void zze(Object param1Object, long param1Long, byte param1Byte) {
      this.zzalp.putByte(param1Object, param1Long, param1Byte);
    }
    
    public final boolean zzm(Object param1Object, long param1Long) {
      return this.zzalp.getBoolean(param1Object, param1Long);
    }
    
    public final float zzn(Object param1Object, long param1Long) {
      return this.zzalp.getFloat(param1Object, param1Long);
    }
    
    public final double zzo(Object param1Object, long param1Long) {
      return this.zzalp.getDouble(param1Object, param1Long);
    }
    
    public final byte zzy(Object param1Object, long param1Long) {
      return this.zzalp.getByte(param1Object, param1Long);
    }
  }
  
  static abstract class zzd {
    Unsafe zzalp;
    
    zzd(Unsafe param1Unsafe) {
      this.zzalp = param1Unsafe;
    }
    
    public abstract void zza(long param1Long, byte param1Byte);
    
    public abstract void zza(Object param1Object, long param1Long, double param1Double);
    
    public abstract void zza(Object param1Object, long param1Long, float param1Float);
    
    public final void zza(Object param1Object, long param1Long1, long param1Long2) {
      this.zzalp.putLong(param1Object, param1Long1, param1Long2);
    }
    
    public abstract void zza(Object param1Object, long param1Long, boolean param1Boolean);
    
    public abstract void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3);
    
    public final void zzb(Object param1Object, long param1Long, int param1Int) {
      this.zzalp.putInt(param1Object, param1Long, param1Int);
    }
    
    public abstract void zze(Object param1Object, long param1Long, byte param1Byte);
    
    public final int zzk(Object param1Object, long param1Long) {
      return this.zzalp.getInt(param1Object, param1Long);
    }
    
    public final long zzl(Object param1Object, long param1Long) {
      return this.zzalp.getLong(param1Object, param1Long);
    }
    
    public abstract boolean zzm(Object param1Object, long param1Long);
    
    public abstract float zzn(Object param1Object, long param1Long);
    
    public abstract double zzo(Object param1Object, long param1Long);
    
    public abstract byte zzy(Object param1Object, long param1Long);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */