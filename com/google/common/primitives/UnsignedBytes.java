package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;

@GwtIncompatible
public final class UnsignedBytes {
  public static final byte MAX_POWER_OF_TWO = -128;
  
  public static final byte MAX_VALUE = -1;
  
  private static final int UNSIGNED_MASK = 255;
  
  @CanIgnoreReturnValue
  public static byte checkedCast(long paramLong) {
    if (paramLong >> 8L == 0L)
      return (byte)(int)paramLong; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Out of range: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static int compare(byte paramByte1, byte paramByte2) {
    return toInt(paramByte1) - toInt(paramByte2);
  }
  
  public static String join(String paramString, byte... paramVarArgs) {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * (paramString.length() + 3));
    stringBuilder.append(toInt(paramVarArgs[0]));
    for (byte b = 1; b < paramVarArgs.length; b++) {
      stringBuilder.append(paramString);
      stringBuilder.append(toString(paramVarArgs[b]));
    } 
    return stringBuilder.toString();
  }
  
  public static Comparator<byte[]> lexicographicalComparator() {
    return LexicographicalComparatorHolder.BEST_COMPARATOR;
  }
  
  @VisibleForTesting
  static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
    return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
  }
  
  public static byte max(byte... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    int j;
    for (j = toInt(paramVarArgs[0]); b < paramVarArgs.length; j = i) {
      int k = toInt(paramVarArgs[b]);
      i = j;
      if (k > j)
        i = k; 
      b++;
    } 
    return (byte)j;
  }
  
  public static byte min(byte... paramVarArgs) {
    boolean bool;
    int i = paramVarArgs.length;
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    for (i = toInt(paramVarArgs[0]); b < paramVarArgs.length; i = k) {
      int j = toInt(paramVarArgs[b]);
      int k = i;
      if (j < i)
        k = j; 
      b++;
    } 
    return (byte)i;
  }
  
  @Beta
  @CanIgnoreReturnValue
  public static byte parseUnsignedByte(String paramString) {
    return parseUnsignedByte(paramString, 10);
  }
  
  @Beta
  @CanIgnoreReturnValue
  public static byte parseUnsignedByte(String paramString, int paramInt) {
    paramInt = Integer.parseInt((String)Preconditions.checkNotNull(paramString), paramInt);
    if (paramInt >> 8 == 0)
      return (byte)paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("out of range: ");
    stringBuilder.append(paramInt);
    throw new NumberFormatException(stringBuilder.toString());
  }
  
  public static byte saturatedCast(long paramLong) {
    return (paramLong > toInt((byte)-1)) ? -1 : ((paramLong < 0L) ? 0 : (byte)(int)paramLong);
  }
  
  public static int toInt(byte paramByte) {
    return paramByte & 0xFF;
  }
  
  @Beta
  public static String toString(byte paramByte) {
    return toString(paramByte, 10);
  }
  
  @Beta
  public static String toString(byte paramByte, int paramInt) {
    boolean bool;
    if (paramInt >= 2 && paramInt <= 36) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", paramInt);
    return Integer.toString(toInt(paramByte), paramInt);
  }
  
  @VisibleForTesting
  static class LexicographicalComparatorHolder {
    static final Comparator<byte[]> BEST_COMPARATOR;
    
    static final String UNSAFE_COMPARATOR_NAME;
    
    static {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(LexicographicalComparatorHolder.class.getName());
      stringBuilder.append("$UnsafeComparator");
      UNSAFE_COMPARATOR_NAME = stringBuilder.toString();
      BEST_COMPARATOR = getBestComparator();
    }
    
    static Comparator<byte[]> getBestComparator() {
      try {
        return (Comparator)Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
      } catch (Throwable throwable) {
        return UnsignedBytes.lexicographicalComparatorJavaImpl();
      } 
    }
    
    enum PureJavaComparator implements Comparator<byte[]> {
      INSTANCE;
      
      static {
      
      }
      
      public int compare(byte[] param2ArrayOfbyte1, byte[] param2ArrayOfbyte2) {
        int i = Math.min(param2ArrayOfbyte1.length, param2ArrayOfbyte2.length);
        for (byte b = 0; b < i; b++) {
          int j = UnsignedBytes.compare(param2ArrayOfbyte1[b], param2ArrayOfbyte2[b]);
          if (j != 0)
            return j; 
        } 
        return param2ArrayOfbyte1.length - param2ArrayOfbyte2.length;
      }
      
      public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
      }
    }
    
    @VisibleForTesting
    enum UnsafeComparator implements Comparator<byte[]> {
      INSTANCE;
      
      static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
      
      static final int BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
      
      static final Unsafe theUnsafe = getUnsafe();
      
      static {
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
      
      public int compare(byte[] param2ArrayOfbyte1, byte[] param2ArrayOfbyte2) {
        int m;
        int i = Math.min(param2ArrayOfbyte1.length, param2ArrayOfbyte2.length);
        int j = i / 8;
        int k = 0;
        while (true) {
          int n = j * 8;
          m = n;
          if (k < n) {
            Unsafe unsafe = theUnsafe;
            long l1 = BYTE_ARRAY_BASE_OFFSET;
            long l2 = k;
            l1 = unsafe.getLong(param2ArrayOfbyte1, l1 + l2);
            l2 = theUnsafe.getLong(param2ArrayOfbyte2, BYTE_ARRAY_BASE_OFFSET + l2);
            if (l1 != l2) {
              if (BIG_ENDIAN)
                return UnsignedLongs.compare(l1, l2); 
              m = Long.numberOfTrailingZeros(l1 ^ l2) & 0xFFFFFFF8;
              return (int)(l1 >>> m & 0xFFL) - (int)(l2 >>> m & 0xFFL);
            } 
            k += 8;
            continue;
          } 
          break;
        } 
        while (m < i) {
          k = UnsignedBytes.compare(param2ArrayOfbyte1[m], param2ArrayOfbyte2[m]);
          if (k != 0)
            return k; 
          m++;
        } 
        return param2ArrayOfbyte1.length - param2ArrayOfbyte2.length;
      }
      
      public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
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
  
  enum PureJavaComparator implements Comparator<byte[]> {
    INSTANCE;
    
    static {
    
    }
    
    public int compare(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      int i = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
      for (byte b = 0; b < i; b++) {
        int j = UnsignedBytes.compare(param1ArrayOfbyte1[b], param1ArrayOfbyte2[b]);
        if (j != 0)
          return j; 
      } 
      return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
    }
    
    public String toString() {
      return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }
  }
  
  @VisibleForTesting
  enum UnsafeComparator implements Comparator<byte[]> {
    INSTANCE;
    
    static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
    
    static final int BYTE_ARRAY_BASE_OFFSET;
    
    static final Unsafe theUnsafe = getUnsafe();
    
    static {
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
    
    public int compare(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      int m;
      int i = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
      int j = i / 8;
      int k = 0;
      while (true) {
        int n = j * 8;
        m = n;
        if (k < n) {
          Unsafe unsafe = theUnsafe;
          long l1 = BYTE_ARRAY_BASE_OFFSET;
          long l2 = k;
          l1 = unsafe.getLong(param1ArrayOfbyte1, l1 + l2);
          l2 = theUnsafe.getLong(param1ArrayOfbyte2, BYTE_ARRAY_BASE_OFFSET + l2);
          if (l1 != l2) {
            if (BIG_ENDIAN)
              return UnsignedLongs.compare(l1, l2); 
            m = Long.numberOfTrailingZeros(l1 ^ l2) & 0xFFFFFFF8;
            return (int)(l1 >>> m & 0xFFL) - (int)(l2 >>> m & 0xFFL);
          } 
          k += 8;
          continue;
        } 
        break;
      } 
      while (m < i) {
        k = UnsignedBytes.compare(param1ArrayOfbyte1[m], param1ArrayOfbyte2[m]);
        if (k != 0)
          return k; 
        m++;
      } 
      return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
    }
    
    public String toString() {
      return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\UnsignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */