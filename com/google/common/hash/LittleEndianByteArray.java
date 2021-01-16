package com.google.common.hash;

import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class LittleEndianByteArray {
  private static final LittleEndianBytes byteArray;
  
  static {
    // Byte code:
    //   0: getstatic com/google/common/hash/LittleEndianByteArray$JavaLittleEndianBytes.INSTANCE : Lcom/google/common/hash/LittleEndianByteArray$JavaLittleEndianBytes;
    //   3: astore_0
    //   4: ldc 'os.arch'
    //   6: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: ldc 'amd64'
    //   12: aload_1
    //   13: invokevirtual equals : (Ljava/lang/Object;)Z
    //   16: ifne -> 30
    //   19: aload_0
    //   20: astore_2
    //   21: ldc 'aarch64'
    //   23: aload_1
    //   24: invokevirtual equals : (Ljava/lang/Object;)Z
    //   27: ifeq -> 53
    //   30: invokestatic nativeOrder : ()Ljava/nio/ByteOrder;
    //   33: getstatic java/nio/ByteOrder.LITTLE_ENDIAN : Ljava/nio/ByteOrder;
    //   36: invokevirtual equals : (Ljava/lang/Object;)Z
    //   39: ifeq -> 49
    //   42: getstatic com/google/common/hash/LittleEndianByteArray$UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : Lcom/google/common/hash/LittleEndianByteArray$UnsafeByteArray;
    //   45: astore_2
    //   46: goto -> 53
    //   49: getstatic com/google/common/hash/LittleEndianByteArray$UnsafeByteArray.UNSAFE_BIG_ENDIAN : Lcom/google/common/hash/LittleEndianByteArray$UnsafeByteArray;
    //   52: astore_2
    //   53: aload_2
    //   54: putstatic com/google/common/hash/LittleEndianByteArray.byteArray : Lcom/google/common/hash/LittleEndianByteArray$LittleEndianBytes;
    //   57: return
    //   58: astore_2
    //   59: aload_0
    //   60: astore_2
    //   61: goto -> 53
    // Exception table:
    //   from	to	target	type
    //   4	19	58	java/lang/Throwable
    //   21	30	58	java/lang/Throwable
    //   30	46	58	java/lang/Throwable
    //   49	53	58	java/lang/Throwable
  }
  
  static int load32(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
  }
  
  static long load64(byte[] paramArrayOfbyte, int paramInt) {
    return byteArray.getLongLittleEndian(paramArrayOfbyte, paramInt);
  }
  
  static long load64Safely(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int i = Math.min(paramInt2, 8);
    long l = 0L;
    for (paramInt2 = 0; paramInt2 < i; paramInt2++)
      l |= (paramArrayOfbyte[paramInt1 + paramInt2] & 0xFFL) << paramInt2 * 8; 
    return l;
  }
  
  static void store64(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    byteArray.putLongLittleEndian(paramArrayOfbyte, paramInt, paramLong);
  }
  
  static boolean usingUnsafe() {
    return byteArray instanceof UnsafeByteArray;
  }
  
  private enum JavaLittleEndianBytes implements LittleEndianBytes {
    INSTANCE {
      public long getLongLittleEndian(byte[] param2ArrayOfbyte, int param2Int) {
        return Longs.fromBytes(param2ArrayOfbyte[param2Int + 7], param2ArrayOfbyte[param2Int + 6], param2ArrayOfbyte[param2Int + 5], param2ArrayOfbyte[param2Int + 4], param2ArrayOfbyte[param2Int + 3], param2ArrayOfbyte[param2Int + 2], param2ArrayOfbyte[param2Int + 1], param2ArrayOfbyte[param2Int]);
      }
      
      public void putLongLittleEndian(byte[] param2ArrayOfbyte, int param2Int, long param2Long) {
        long l = 255L;
        for (byte b = 0; b < 8; b++) {
          param2ArrayOfbyte[param2Int + b] = (byte)(byte)(int)((param2Long & l) >> b * 8);
          l <<= 8L;
        } 
      }
    };
    
    static {
    
    }
  }
  
  enum null {
    public long getLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int) {
      return Longs.fromBytes(param1ArrayOfbyte[param1Int + 7], param1ArrayOfbyte[param1Int + 6], param1ArrayOfbyte[param1Int + 5], param1ArrayOfbyte[param1Int + 4], param1ArrayOfbyte[param1Int + 3], param1ArrayOfbyte[param1Int + 2], param1ArrayOfbyte[param1Int + 1], param1ArrayOfbyte[param1Int]);
    }
    
    public void putLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int, long param1Long) {
      long l = 255L;
      for (byte b = 0; b < 8; b++) {
        param1ArrayOfbyte[param1Int + b] = (byte)(byte)(int)((param1Long & l) >> b * 8);
        l <<= 8L;
      } 
    }
  }
  
  private static interface LittleEndianBytes {
    long getLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int);
    
    void putLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int, long param1Long);
  }
  
  private enum UnsafeByteArray implements LittleEndianBytes {
    UNSAFE_BIG_ENDIAN,
    UNSAFE_LITTLE_ENDIAN {
      public long getLongLittleEndian(byte[] param2ArrayOfbyte, int param2Int) {
        return UnsafeByteArray.theUnsafe.getLong(param2ArrayOfbyte, param2Int + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
      }
      
      public void putLongLittleEndian(byte[] param2ArrayOfbyte, int param2Int, long param2Long) {
        Unsafe unsafe = UnsafeByteArray.theUnsafe;
        long l = param2Int;
        unsafe.putLong(param2ArrayOfbyte, UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET + l, param2Long);
      }
    };
    
    private static final int BYTE_ARRAY_BASE_OFFSET;
    
    private static final Unsafe theUnsafe;
    
    static {
      $VALUES = new UnsafeByteArray[] { UNSAFE_LITTLE_ENDIAN, UNSAFE_BIG_ENDIAN };
      theUnsafe = getUnsafe();
      BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
      if (theUnsafe.arrayIndexScale(byte[].class) == 1)
        return; 
      throw new AssertionError();
    }
    
    private static Unsafe getUnsafe() {
      try {
        return Unsafe.getUnsafe();
      } catch (SecurityException securityException) {
        try {
          PrivilegedExceptionAction<Unsafe> privilegedExceptionAction = new PrivilegedExceptionAction<Unsafe>() {
              public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                  field.setAccessible(true);
                  Object object = field.get((Object)null);
                  if (Unsafe.class.isInstance(object))
                    return Unsafe.class.cast(object); 
                } 
                throw new NoSuchFieldError("the Unsafe");
              }
            };
          super();
          return AccessController.<Unsafe>doPrivileged(privilegedExceptionAction);
        } catch (PrivilegedActionException privilegedActionException) {
          throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
        } 
      } 
    }
  }
  
  enum null {
    public long getLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int) {
      return LittleEndianByteArray.UnsafeByteArray.theUnsafe.getLong(param1ArrayOfbyte, param1Int + LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
    }
    
    public void putLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int, long param1Long) {
      Unsafe unsafe = LittleEndianByteArray.UnsafeByteArray.theUnsafe;
      long l = param1Int;
      unsafe.putLong(param1ArrayOfbyte, LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET + l, param1Long);
    }
  }
  
  enum null {
    public long getLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int) {
      return Long.reverseBytes(LittleEndianByteArray.UnsafeByteArray.theUnsafe.getLong(param1ArrayOfbyte, param1Int + LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
    }
    
    public void putLongLittleEndian(byte[] param1ArrayOfbyte, int param1Int, long param1Long) {
      param1Long = Long.reverseBytes(param1Long);
      LittleEndianByteArray.UnsafeByteArray.theUnsafe.putLong(param1ArrayOfbyte, param1Int + LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, param1Long);
    }
  }
  
  static final class null implements PrivilegedExceptionAction<Unsafe> {
    public Unsafe run() throws Exception {
      for (Field field : Unsafe.class.getDeclaredFields()) {
        field.setAccessible(true);
        Object object = field.get((Object)null);
        if (Unsafe.class.isInstance(object))
          return Unsafe.class.cast(object); 
      } 
      throw new NoSuchFieldError("the Unsafe");
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\LittleEndianByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */