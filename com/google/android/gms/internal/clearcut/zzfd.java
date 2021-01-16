package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzfd {
  private static final Logger logger;
  
  private static final Class<?> zzfb;
  
  private static final boolean zzfy;
  
  private static final Unsafe zzmh;
  
  private static final boolean zzpg;
  
  private static final boolean zzph;
  
  private static final zzd zzpi;
  
  private static final boolean zzpj;
  
  private static final long zzpk;
  
  private static final long zzpl;
  
  private static final long zzpm;
  
  private static final long zzpn;
  
  private static final long zzpo;
  
  private static final long zzpp;
  
  private static final long zzpq;
  
  private static final long zzpr;
  
  private static final long zzps;
  
  private static final long zzpt;
  
  private static final long zzpu;
  
  private static final long zzpv;
  
  private static final long zzpw;
  
  private static final long zzpx;
  
  private static final long zzpy;
  
  private static final boolean zzpz;
  
  static {
    // Byte code:
    //   0: ldc com/google/android/gms/internal/clearcut/zzfd
    //   2: invokevirtual getName : ()Ljava/lang/String;
    //   5: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
    //   8: putstatic com/google/android/gms/internal/clearcut/zzfd.logger : Ljava/util/logging/Logger;
    //   11: invokestatic zzef : ()Lsun/misc/Unsafe;
    //   14: putstatic com/google/android/gms/internal/clearcut/zzfd.zzmh : Lsun/misc/Unsafe;
    //   17: invokestatic zzy : ()Ljava/lang/Class;
    //   20: putstatic com/google/android/gms/internal/clearcut/zzfd.zzfb : Ljava/lang/Class;
    //   23: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   26: invokestatic zzi : (Ljava/lang/Class;)Z
    //   29: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpg : Z
    //   32: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   35: invokestatic zzi : (Ljava/lang/Class;)Z
    //   38: putstatic com/google/android/gms/internal/clearcut/zzfd.zzph : Z
    //   41: getstatic com/google/android/gms/internal/clearcut/zzfd.zzmh : Lsun/misc/Unsafe;
    //   44: ifnonnull -> 52
    //   47: aconst_null
    //   48: astore_0
    //   49: goto -> 109
    //   52: invokestatic zzx : ()Z
    //   55: ifeq -> 98
    //   58: getstatic com/google/android/gms/internal/clearcut/zzfd.zzpg : Z
    //   61: ifeq -> 78
    //   64: new com/google/android/gms/internal/clearcut/zzfd$zzb
    //   67: dup
    //   68: getstatic com/google/android/gms/internal/clearcut/zzfd.zzmh : Lsun/misc/Unsafe;
    //   71: invokespecial <init> : (Lsun/misc/Unsafe;)V
    //   74: astore_0
    //   75: goto -> 109
    //   78: getstatic com/google/android/gms/internal/clearcut/zzfd.zzph : Z
    //   81: ifeq -> 47
    //   84: new com/google/android/gms/internal/clearcut/zzfd$zza
    //   87: dup
    //   88: getstatic com/google/android/gms/internal/clearcut/zzfd.zzmh : Lsun/misc/Unsafe;
    //   91: invokespecial <init> : (Lsun/misc/Unsafe;)V
    //   94: astore_0
    //   95: goto -> 109
    //   98: new com/google/android/gms/internal/clearcut/zzfd$zzc
    //   101: dup
    //   102: getstatic com/google/android/gms/internal/clearcut/zzfd.zzmh : Lsun/misc/Unsafe;
    //   105: invokespecial <init> : (Lsun/misc/Unsafe;)V
    //   108: astore_0
    //   109: aload_0
    //   110: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpi : Lcom/google/android/gms/internal/clearcut/zzfd$zzd;
    //   113: invokestatic zzeh : ()Z
    //   116: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpj : Z
    //   119: invokestatic zzeg : ()Z
    //   122: putstatic com/google/android/gms/internal/clearcut/zzfd.zzfy : Z
    //   125: ldc [B
    //   127: invokestatic zzg : (Ljava/lang/Class;)I
    //   130: i2l
    //   131: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpk : J
    //   134: ldc [Z
    //   136: invokestatic zzg : (Ljava/lang/Class;)I
    //   139: i2l
    //   140: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpl : J
    //   143: ldc [Z
    //   145: invokestatic zzh : (Ljava/lang/Class;)I
    //   148: i2l
    //   149: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpm : J
    //   152: ldc [I
    //   154: invokestatic zzg : (Ljava/lang/Class;)I
    //   157: i2l
    //   158: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpn : J
    //   161: ldc [I
    //   163: invokestatic zzh : (Ljava/lang/Class;)I
    //   166: i2l
    //   167: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpo : J
    //   170: ldc [J
    //   172: invokestatic zzg : (Ljava/lang/Class;)I
    //   175: i2l
    //   176: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpp : J
    //   179: ldc [J
    //   181: invokestatic zzh : (Ljava/lang/Class;)I
    //   184: i2l
    //   185: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpq : J
    //   188: ldc [F
    //   190: invokestatic zzg : (Ljava/lang/Class;)I
    //   193: i2l
    //   194: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpr : J
    //   197: ldc [F
    //   199: invokestatic zzh : (Ljava/lang/Class;)I
    //   202: i2l
    //   203: putstatic com/google/android/gms/internal/clearcut/zzfd.zzps : J
    //   206: ldc [D
    //   208: invokestatic zzg : (Ljava/lang/Class;)I
    //   211: i2l
    //   212: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpt : J
    //   215: ldc [D
    //   217: invokestatic zzh : (Ljava/lang/Class;)I
    //   220: i2l
    //   221: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpu : J
    //   224: ldc [Ljava/lang/Object;
    //   226: invokestatic zzg : (Ljava/lang/Class;)I
    //   229: i2l
    //   230: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpv : J
    //   233: ldc [Ljava/lang/Object;
    //   235: invokestatic zzh : (Ljava/lang/Class;)I
    //   238: i2l
    //   239: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpw : J
    //   242: invokestatic zzei : ()Ljava/lang/reflect/Field;
    //   245: invokestatic zzb : (Ljava/lang/reflect/Field;)J
    //   248: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpx : J
    //   251: ldc java/lang/String
    //   253: ldc 'value'
    //   255: invokestatic zzb : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   258: astore_0
    //   259: aload_0
    //   260: ifnull -> 275
    //   263: aload_0
    //   264: invokevirtual getType : ()Ljava/lang/Class;
    //   267: ldc [C
    //   269: if_acmpne -> 275
    //   272: goto -> 277
    //   275: aconst_null
    //   276: astore_0
    //   277: aload_0
    //   278: invokestatic zzb : (Ljava/lang/reflect/Field;)J
    //   281: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpy : J
    //   284: invokestatic nativeOrder : ()Ljava/nio/ByteOrder;
    //   287: getstatic java/nio/ByteOrder.BIG_ENDIAN : Ljava/nio/ByteOrder;
    //   290: if_acmpne -> 298
    //   293: iconst_1
    //   294: istore_1
    //   295: goto -> 300
    //   298: iconst_0
    //   299: istore_1
    //   300: iload_1
    //   301: putstatic com/google/android/gms/internal/clearcut/zzfd.zzpz : Z
    //   304: return
  }
  
  static byte zza(byte[] paramArrayOfbyte, long paramLong) {
    return zzpi.zzx(paramArrayOfbyte, zzpk + paramLong);
  }
  
  static long zza(Field paramField) {
    return zzpi.zza(paramField);
  }
  
  static void zza(long paramLong, byte paramByte) {
    zzpi.zza(paramLong, paramByte);
  }
  
  private static void zza(Object paramObject, long paramLong, byte paramByte) {
    long l = 0xFFFFFFFFFFFFFFFCL & paramLong;
    int i = zzj(paramObject, l);
    int j = (((int)paramLong ^ 0xFFFFFFFF) & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  static void zza(Object paramObject, long paramLong, double paramDouble) {
    zzpi.zza(paramObject, paramLong, paramDouble);
  }
  
  static void zza(Object paramObject, long paramLong, float paramFloat) {
    zzpi.zza(paramObject, paramLong, paramFloat);
  }
  
  static void zza(Object paramObject, long paramLong, int paramInt) {
    zzpi.zza(paramObject, paramLong, paramInt);
  }
  
  static void zza(Object paramObject, long paramLong1, long paramLong2) {
    zzpi.zza(paramObject, paramLong1, paramLong2);
  }
  
  static void zza(Object paramObject1, long paramLong, Object paramObject2) {
    zzpi.zzqa.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void zza(Object paramObject, long paramLong, boolean paramBoolean) {
    zzpi.zza(paramObject, paramLong, paramBoolean);
  }
  
  static void zza(byte[] paramArrayOfbyte, long paramLong, byte paramByte) {
    zzpi.zze(paramArrayOfbyte, zzpk + paramLong, paramByte);
  }
  
  static void zza(byte[] paramArrayOfbyte, long paramLong1, long paramLong2, long paramLong3) {
    zzpi.zza(paramArrayOfbyte, paramLong1, paramLong2, paramLong3);
  }
  
  private static long zzb(Field paramField) {
    if (paramField != null) {
      zzd zzd1 = zzpi;
      if (zzd1 != null)
        return zzd1.zza(paramField); 
    } 
    return -1L;
  }
  
  static long zzb(ByteBuffer paramByteBuffer) {
    return zzpi.zzk(paramByteBuffer, zzpx);
  }
  
  private static Field zzb(Class<?> paramClass, String paramString) {
    try {
      Field field = paramClass.getDeclaredField(paramString);
      field.setAccessible(true);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (Field)throwable;
  }
  
  private static void zzb(Object paramObject, long paramLong, byte paramByte) {
    long l = 0xFFFFFFFFFFFFFFFCL & paramLong;
    int i = zzj(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    zza(paramObject, l, (0xFF & paramByte) << j | i & (255 << j ^ 0xFFFFFFFF));
  }
  
  private static void zzb(Object paramObject, long paramLong, boolean paramBoolean) {
    zza(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static void zzc(Object paramObject, long paramLong, boolean paramBoolean) {
    zzb(paramObject, paramLong, (byte)paramBoolean);
  }
  
  static boolean zzed() {
    return zzfy;
  }
  
  static boolean zzee() {
    return zzpj;
  }
  
  static Unsafe zzef() {
    try {
      zzfe zzfe = new zzfe();
      this();
      Unsafe unsafe = AccessController.<Unsafe>doPrivileged(zzfe);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (Unsafe)throwable;
  }
  
  private static boolean zzeg() {
    Unsafe unsafe = zzmh;
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
      if (zzaw.zzx())
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
  
  private static boolean zzeh() {
    Unsafe unsafe = zzmh;
    if (unsafe == null)
      return false; 
    try {
      Class<?> clazz = unsafe.getClass();
      clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
      clazz.getMethod("getLong", new Class[] { Object.class, long.class });
      if (zzei() == null)
        return false; 
      if (zzaw.zzx())
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
  
  private static Field zzei() {
    if (zzaw.zzx()) {
      Field field1 = zzb(Buffer.class, "effectiveDirectAddress");
      if (field1 != null)
        return field1; 
    } 
    Field field = zzb(Buffer.class, "address");
    return (field != null && field.getType() == long.class) ? field : null;
  }
  
  private static int zzg(Class<?> paramClass) {
    return zzfy ? zzpi.zzqa.arrayBaseOffset(paramClass) : -1;
  }
  
  private static int zzh(Class<?> paramClass) {
    return zzfy ? zzpi.zzqa.arrayIndexScale(paramClass) : -1;
  }
  
  private static boolean zzi(Class<?> paramClass) {
    if (!zzaw.zzx())
      return false; 
    try {
      Class<?> clazz = zzfb;
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
  
  static int zzj(Object paramObject, long paramLong) {
    return zzpi.zzj(paramObject, paramLong);
  }
  
  static long zzk(Object paramObject, long paramLong) {
    return zzpi.zzk(paramObject, paramLong);
  }
  
  static boolean zzl(Object paramObject, long paramLong) {
    return zzpi.zzl(paramObject, paramLong);
  }
  
  static float zzm(Object paramObject, long paramLong) {
    return zzpi.zzm(paramObject, paramLong);
  }
  
  static double zzn(Object paramObject, long paramLong) {
    return zzpi.zzn(paramObject, paramLong);
  }
  
  static Object zzo(Object paramObject, long paramLong) {
    return zzpi.zzqa.getObject(paramObject, paramLong);
  }
  
  private static byte zzp(Object paramObject, long paramLong) {
    return (byte)(zzj(paramObject, 0xFFFFFFFFFFFFFFFCL & paramLong) >>> (int)(((paramLong ^ 0xFFFFFFFFFFFFFFFFL) & 0x3L) << 3L));
  }
  
  private static byte zzq(Object paramObject, long paramLong) {
    return (byte)(zzj(paramObject, 0xFFFFFFFFFFFFFFFCL & paramLong) >>> (int)((paramLong & 0x3L) << 3L));
  }
  
  private static boolean zzr(Object paramObject, long paramLong) {
    return (zzp(paramObject, paramLong) != 0);
  }
  
  private static boolean zzs(Object paramObject, long paramLong) {
    return (zzq(paramObject, paramLong) != 0);
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
      zza(param1Object, param1Long, Float.floatToIntBits(param1Float));
    }
    
    public final void zza(Object param1Object, long param1Long, boolean param1Boolean) {
      if (zzfd.zzah()) {
        zzfd.zzd(param1Object, param1Long, param1Boolean);
        return;
      } 
      zzfd.zze(param1Object, param1Long, param1Boolean);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      Memory.pokeByteArray((int)(param1Long2 & 0xFFFFFFFFFFFFFFFFL), param1ArrayOfbyte, (int)param1Long1, (int)param1Long3);
    }
    
    public final void zze(Object param1Object, long param1Long, byte param1Byte) {
      if (zzfd.zzah()) {
        zzfd.zzc(param1Object, param1Long, param1Byte);
        return;
      } 
      zzfd.zzd(param1Object, param1Long, param1Byte);
    }
    
    public final boolean zzl(Object param1Object, long param1Long) {
      return zzfd.zzah() ? zzfd.zzv(param1Object, param1Long) : zzfd.zzw(param1Object, param1Long);
    }
    
    public final float zzm(Object param1Object, long param1Long) {
      return Float.intBitsToFloat(zzj(param1Object, param1Long));
    }
    
    public final double zzn(Object param1Object, long param1Long) {
      return Double.longBitsToDouble(zzk(param1Object, param1Long));
    }
    
    public final byte zzx(Object param1Object, long param1Long) {
      return zzfd.zzah() ? zzfd.zzt(param1Object, param1Long) : zzfd.zzu(param1Object, param1Long);
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
      zza(param1Object, param1Long, Float.floatToIntBits(param1Float));
    }
    
    public final void zza(Object param1Object, long param1Long, boolean param1Boolean) {
      if (zzfd.zzah()) {
        zzfd.zzd(param1Object, param1Long, param1Boolean);
        return;
      } 
      zzfd.zze(param1Object, param1Long, param1Boolean);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      Memory.pokeByteArray(param1Long2, param1ArrayOfbyte, (int)param1Long1, (int)param1Long3);
    }
    
    public final void zze(Object param1Object, long param1Long, byte param1Byte) {
      if (zzfd.zzah()) {
        zzfd.zzc(param1Object, param1Long, param1Byte);
        return;
      } 
      zzfd.zzd(param1Object, param1Long, param1Byte);
    }
    
    public final boolean zzl(Object param1Object, long param1Long) {
      return zzfd.zzah() ? zzfd.zzv(param1Object, param1Long) : zzfd.zzw(param1Object, param1Long);
    }
    
    public final float zzm(Object param1Object, long param1Long) {
      return Float.intBitsToFloat(zzj(param1Object, param1Long));
    }
    
    public final double zzn(Object param1Object, long param1Long) {
      return Double.longBitsToDouble(zzk(param1Object, param1Long));
    }
    
    public final byte zzx(Object param1Object, long param1Long) {
      return zzfd.zzah() ? zzfd.zzt(param1Object, param1Long) : zzfd.zzu(param1Object, param1Long);
    }
  }
  
  static final class zzc extends zzd {
    zzc(Unsafe param1Unsafe) {
      super(param1Unsafe);
    }
    
    public final void zza(long param1Long, byte param1Byte) {
      this.zzqa.putByte(param1Long, param1Byte);
    }
    
    public final void zza(Object param1Object, long param1Long, double param1Double) {
      this.zzqa.putDouble(param1Object, param1Long, param1Double);
    }
    
    public final void zza(Object param1Object, long param1Long, float param1Float) {
      this.zzqa.putFloat(param1Object, param1Long, param1Float);
    }
    
    public final void zza(Object param1Object, long param1Long, boolean param1Boolean) {
      this.zzqa.putBoolean(param1Object, param1Long, param1Boolean);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      this.zzqa.copyMemory(param1ArrayOfbyte, zzfd.zzej() + param1Long1, null, param1Long2, param1Long3);
    }
    
    public final void zze(Object param1Object, long param1Long, byte param1Byte) {
      this.zzqa.putByte(param1Object, param1Long, param1Byte);
    }
    
    public final boolean zzl(Object param1Object, long param1Long) {
      return this.zzqa.getBoolean(param1Object, param1Long);
    }
    
    public final float zzm(Object param1Object, long param1Long) {
      return this.zzqa.getFloat(param1Object, param1Long);
    }
    
    public final double zzn(Object param1Object, long param1Long) {
      return this.zzqa.getDouble(param1Object, param1Long);
    }
    
    public final byte zzx(Object param1Object, long param1Long) {
      return this.zzqa.getByte(param1Object, param1Long);
    }
  }
  
  static abstract class zzd {
    Unsafe zzqa;
    
    zzd(Unsafe param1Unsafe) {
      this.zzqa = param1Unsafe;
    }
    
    public final long zza(Field param1Field) {
      return this.zzqa.objectFieldOffset(param1Field);
    }
    
    public abstract void zza(long param1Long, byte param1Byte);
    
    public abstract void zza(Object param1Object, long param1Long, double param1Double);
    
    public abstract void zza(Object param1Object, long param1Long, float param1Float);
    
    public final void zza(Object param1Object, long param1Long, int param1Int) {
      this.zzqa.putInt(param1Object, param1Long, param1Int);
    }
    
    public final void zza(Object param1Object, long param1Long1, long param1Long2) {
      this.zzqa.putLong(param1Object, param1Long1, param1Long2);
    }
    
    public abstract void zza(Object param1Object, long param1Long, boolean param1Boolean);
    
    public abstract void zza(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3);
    
    public abstract void zze(Object param1Object, long param1Long, byte param1Byte);
    
    public final int zzj(Object param1Object, long param1Long) {
      return this.zzqa.getInt(param1Object, param1Long);
    }
    
    public final long zzk(Object param1Object, long param1Long) {
      return this.zzqa.getLong(param1Object, param1Long);
    }
    
    public abstract boolean zzl(Object param1Object, long param1Long);
    
    public abstract float zzm(Object param1Object, long param1Long);
    
    public abstract double zzn(Object param1Object, long param1Long);
    
    public abstract byte zzx(Object param1Object, long param1Long);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */