package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public final class ReflectionLongAdderCounter implements LongCounter {
  private static final Method addMethod;
  
  private static final Constructor<?> defaultConstructor;
  
  private static final RuntimeException initializationException;
  
  private static final Logger logger;
  
  private static final Method sumMethod;
  
  private final Object instance;
  
  static {
    // Byte code:
    //   0: ldc io/grpc/internal/ReflectionLongAdderCounter
    //   2: invokevirtual getName : ()Ljava/lang/String;
    //   5: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
    //   8: putstatic io/grpc/internal/ReflectionLongAdderCounter.logger : Ljava/util/logging/Logger;
    //   11: ldc 'java.util.concurrent.atomic.LongAdder'
    //   13: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   16: astore_0
    //   17: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   20: astore_1
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_0
    //   24: ldc 'add'
    //   26: iconst_1
    //   27: anewarray java/lang/Class
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   37: astore_3
    //   38: aload_0
    //   39: ldc 'sum'
    //   41: iconst_0
    //   42: anewarray java/lang/Class
    //   45: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual getConstructors : ()[Ljava/lang/reflect/Constructor;
    //   53: astore #4
    //   55: aload #4
    //   57: arraylength
    //   58: istore #5
    //   60: iload_2
    //   61: iload #5
    //   63: if_icmpge -> 92
    //   66: aload #4
    //   68: iload_2
    //   69: aaload
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   75: arraylength
    //   76: istore #6
    //   78: iload #6
    //   80: ifne -> 86
    //   83: goto -> 94
    //   86: iinc #2, 1
    //   89: goto -> 60
    //   92: aconst_null
    //   93: astore_0
    //   94: aconst_null
    //   95: astore #4
    //   97: aload_0
    //   98: astore #7
    //   100: goto -> 136
    //   103: astore_0
    //   104: goto -> 118
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_1
    //   110: goto -> 118
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: astore_1
    //   118: getstatic io/grpc/internal/ReflectionLongAdderCounter.logger : Ljava/util/logging/Logger;
    //   121: getstatic java/util/logging/Level.FINE : Ljava/util/logging/Level;
    //   124: ldc 'LongAdder can not be found via reflection, this is normal for JDK7 and below'
    //   126: aload_0
    //   127: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: aconst_null
    //   131: astore #7
    //   133: aload_0
    //   134: astore #4
    //   136: aload #4
    //   138: ifnonnull -> 166
    //   141: aload #7
    //   143: ifnull -> 166
    //   146: aload #7
    //   148: putstatic io/grpc/internal/ReflectionLongAdderCounter.defaultConstructor : Ljava/lang/reflect/Constructor;
    //   151: aload_3
    //   152: putstatic io/grpc/internal/ReflectionLongAdderCounter.addMethod : Ljava/lang/reflect/Method;
    //   155: aload_1
    //   156: putstatic io/grpc/internal/ReflectionLongAdderCounter.sumMethod : Ljava/lang/reflect/Method;
    //   159: aconst_null
    //   160: putstatic io/grpc/internal/ReflectionLongAdderCounter.initializationException : Ljava/lang/RuntimeException;
    //   163: goto -> 190
    //   166: aconst_null
    //   167: putstatic io/grpc/internal/ReflectionLongAdderCounter.defaultConstructor : Ljava/lang/reflect/Constructor;
    //   170: aconst_null
    //   171: putstatic io/grpc/internal/ReflectionLongAdderCounter.addMethod : Ljava/lang/reflect/Method;
    //   174: aconst_null
    //   175: putstatic io/grpc/internal/ReflectionLongAdderCounter.sumMethod : Ljava/lang/reflect/Method;
    //   178: new java/lang/RuntimeException
    //   181: dup
    //   182: aload #4
    //   184: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   187: putstatic io/grpc/internal/ReflectionLongAdderCounter.initializationException : Ljava/lang/RuntimeException;
    //   190: return
    // Exception table:
    //   from	to	target	type
    //   11	21	113	java/lang/Throwable
    //   23	38	113	java/lang/Throwable
    //   38	49	107	java/lang/Throwable
    //   49	60	103	java/lang/Throwable
    //   71	78	103	java/lang/Throwable
  }
  
  ReflectionLongAdderCounter() {
    RuntimeException runtimeException = initializationException;
    if (runtimeException == null)
      try {
        this.instance = defaultConstructor.newInstance(new Object[0]);
        return;
      } catch (InstantiationException instantiationException) {
        throw new RuntimeException(instantiationException);
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException);
      }  
    throw invocationTargetException;
  }
  
  static boolean isAvailable() {
    boolean bool;
    if (initializationException == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void add(long paramLong) {
    try {
      addMethod.invoke(this.instance, new Object[] { Long.valueOf(paramLong) });
      return;
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException(invocationTargetException);
    } 
  }
  
  public long value() {
    try {
      return ((Long)sumMethod.invoke(this.instance, new Object[0])).longValue();
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException();
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException();
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ReflectionLongAdderCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */