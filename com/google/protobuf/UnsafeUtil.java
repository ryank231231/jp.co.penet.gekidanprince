package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class UnsafeUtil {
  private static final long ARRAY_BASE_OFFSET;
  
  private static final long BUFFER_ADDRESS_OFFSET;
  
  private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
  
  private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  
  private static final Unsafe UNSAFE = getUnsafe();
  
  static {
    HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    ARRAY_BASE_OFFSET = byteArrayBaseOffset();
    BUFFER_ADDRESS_OFFSET = fieldOffset(field(Buffer.class, "address"));
  }
  
  static long addressOffset(ByteBuffer paramByteBuffer) {
    return UNSAFE.getLong(paramByteBuffer, BUFFER_ADDRESS_OFFSET);
  }
  
  private static int byteArrayBaseOffset() {
    byte b;
    if (HAS_UNSAFE_ARRAY_OPERATIONS) {
      b = UNSAFE.arrayBaseOffset(byte[].class);
    } else {
      b = -1;
    } 
    return b;
  }
  
  static void copyMemory(long paramLong1, long paramLong2, long paramLong3) {
    UNSAFE.copyMemory(paramLong1, paramLong2, paramLong3);
  }
  
  static void copyMemory(byte[] paramArrayOfbyte1, long paramLong1, byte[] paramArrayOfbyte2, long paramLong2, long paramLong3) {
    UNSAFE.copyMemory(paramArrayOfbyte1, paramLong1, paramArrayOfbyte2, paramLong2, paramLong3);
  }
  
  private static Field field(Class<?> paramClass, String paramString) {
    try {
      Field field = paramClass.getDeclaredField(paramString);
      field.setAccessible(true);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (Field)throwable;
  }
  
  private static long fieldOffset(Field paramField) {
    if (paramField != null) {
      Unsafe unsafe = UNSAFE;
      return (unsafe == null) ? -1L : unsafe.objectFieldOffset(paramField);
    } 
    return -1L;
  }
  
  static long getArrayBaseOffset() {
    return ARRAY_BASE_OFFSET;
  }
  
  static byte getByte(long paramLong) {
    return UNSAFE.getByte(paramLong);
  }
  
  static byte getByte(byte[] paramArrayOfbyte, long paramLong) {
    return UNSAFE.getByte(paramArrayOfbyte, paramLong);
  }
  
  static long getLong(long paramLong) {
    return UNSAFE.getLong(paramLong);
  }
  
  static long getLong(byte[] paramArrayOfbyte, long paramLong) {
    return UNSAFE.getLong(paramArrayOfbyte, paramLong);
  }
  
  private static Unsafe getUnsafe() {
    try {
      PrivilegedExceptionAction<Unsafe> privilegedExceptionAction = new PrivilegedExceptionAction<Unsafe>() {
          public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
              field.setAccessible(true);
              Object object = field.get((Object)null);
              if (Unsafe.class.isInstance(object))
                return Unsafe.class.cast(object); 
            } 
            return null;
          }
        };
      super();
      Unsafe unsafe = AccessController.<Unsafe>doPrivileged(privilegedExceptionAction);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (Unsafe)throwable;
  }
  
  static boolean hasUnsafeArrayOperations() {
    return HAS_UNSAFE_ARRAY_OPERATIONS;
  }
  
  static boolean hasUnsafeByteBufferOperations() {
    return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  }
  
  static void putByte(long paramLong, byte paramByte) {
    UNSAFE.putByte(paramLong, paramByte);
  }
  
  static void putByte(byte[] paramArrayOfbyte, long paramLong, byte paramByte) {
    UNSAFE.putByte(paramArrayOfbyte, paramLong, paramByte);
  }
  
  private static boolean supportsUnsafeArrayOperations() {
    Unsafe unsafe = UNSAFE;
    null = true;
    if (unsafe != null)
      try {
        Class<?> clazz = unsafe.getClass();
        clazz.getMethod("arrayBaseOffset", new Class[] { Class.class });
        clazz.getMethod("getByte", new Class[] { Object.class, long.class });
        clazz.getMethod("putByte", new Class[] { Object.class, long.class, byte.class });
        clazz.getMethod("getLong", new Class[] { Object.class, long.class });
        clazz.getMethod("copyMemory", new Class[] { Object.class, long.class, Object.class, long.class, long.class });
        return null;
      } catch (Throwable throwable) {} 
    return false;
  }
  
  private static boolean supportsUnsafeByteBufferOperations() {
    Unsafe unsafe = UNSAFE;
    null = true;
    if (unsafe != null)
      try {
        Class<?> clazz = unsafe.getClass();
        clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
        clazz.getMethod("getByte", new Class[] { long.class });
        clazz.getMethod("getLong", new Class[] { Object.class, long.class });
        clazz.getMethod("putByte", new Class[] { long.class, byte.class });
        clazz.getMethod("getLong", new Class[] { long.class });
        clazz.getMethod("copyMemory", new Class[] { long.class, long.class, long.class });
        return null;
      } catch (Throwable throwable) {} 
    return false;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\UnsafeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */