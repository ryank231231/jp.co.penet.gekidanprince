package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

@GwtIncompatible
abstract class Striped64 extends Number {
  static final int NCPU;
  
  private static final Unsafe UNSAFE;
  
  private static final long baseOffset;
  
  private static final long busyOffset;
  
  static final Random rng;
  
  static final ThreadLocal<int[]> threadHashCode = (ThreadLocal)new ThreadLocal<int>();
  
  volatile transient long base;
  
  volatile transient int busy;
  
  volatile transient Cell[] cells;
  
  static {
    rng = new Random();
    NCPU = Runtime.getRuntime().availableProcessors();
    try {
      UNSAFE = getUnsafe();
      baseOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("base"));
      busyOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
      return;
    } catch (Exception exception) {
      throw new Error(exception);
    } 
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
  
  final boolean casBase(long paramLong1, long paramLong2) {
    return UNSAFE.compareAndSwapLong(this, baseOffset, paramLong1, paramLong2);
  }
  
  final boolean casBusy() {
    return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
  }
  
  abstract long fn(long paramLong1, long paramLong2);
  
  final void internalReset(long paramLong) {
    Cell[] arrayOfCell = this.cells;
    this.base = paramLong;
    if (arrayOfCell != null) {
      int i = arrayOfCell.length;
      for (byte b = 0; b < i; b++) {
        Cell cell = arrayOfCell[b];
        if (cell != null)
          cell.value = paramLong; 
      } 
    } 
  }
  
  final void retryUpdate(long paramLong, int[] paramArrayOfint, boolean paramBoolean) {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull -> 47
    //   4: getstatic com/google/common/cache/Striped64.threadHashCode : Ljava/lang/ThreadLocal;
    //   7: astore #5
    //   9: iconst_1
    //   10: newarray int
    //   12: astore_3
    //   13: aload #5
    //   15: aload_3
    //   16: invokevirtual set : (Ljava/lang/Object;)V
    //   19: getstatic com/google/common/cache/Striped64.rng : Ljava/util/Random;
    //   22: invokevirtual nextInt : ()I
    //   25: istore #6
    //   27: iload #6
    //   29: istore #7
    //   31: iload #6
    //   33: ifne -> 39
    //   36: iconst_1
    //   37: istore #7
    //   39: aload_3
    //   40: iconst_0
    //   41: iload #7
    //   43: iastore
    //   44: goto -> 52
    //   47: aload_3
    //   48: iconst_0
    //   49: iaload
    //   50: istore #7
    //   52: iconst_0
    //   53: istore #6
    //   55: iload #4
    //   57: istore #8
    //   59: iload #7
    //   61: istore #9
    //   63: aload_0
    //   64: getfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   67: astore #5
    //   69: aload #5
    //   71: ifnull -> 445
    //   74: aload #5
    //   76: arraylength
    //   77: istore #10
    //   79: iload #10
    //   81: ifle -> 445
    //   84: aload #5
    //   86: iload #10
    //   88: iconst_1
    //   89: isub
    //   90: iload #9
    //   92: iand
    //   93: aaload
    //   94: astore #11
    //   96: aload #11
    //   98: ifnonnull -> 217
    //   101: aload_0
    //   102: getfield busy : I
    //   105: ifne -> 207
    //   108: new com/google/common/cache/Striped64$Cell
    //   111: dup
    //   112: lload_1
    //   113: invokespecial <init> : (J)V
    //   116: astore #11
    //   118: aload_0
    //   119: getfield busy : I
    //   122: ifne -> 207
    //   125: aload_0
    //   126: invokevirtual casBusy : ()Z
    //   129: ifeq -> 207
    //   132: aload_0
    //   133: getfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   136: astore #5
    //   138: aload #5
    //   140: ifnull -> 183
    //   143: aload #5
    //   145: arraylength
    //   146: istore #7
    //   148: iload #7
    //   150: ifle -> 183
    //   153: iload #7
    //   155: iconst_1
    //   156: isub
    //   157: iload #9
    //   159: iand
    //   160: istore #7
    //   162: aload #5
    //   164: iload #7
    //   166: aaload
    //   167: ifnonnull -> 183
    //   170: aload #5
    //   172: iload #7
    //   174: aload #11
    //   176: aastore
    //   177: iconst_1
    //   178: istore #7
    //   180: goto -> 186
    //   183: iconst_0
    //   184: istore #7
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield busy : I
    //   191: iload #7
    //   193: ifeq -> 63
    //   196: goto -> 561
    //   199: astore_3
    //   200: aload_0
    //   201: iconst_0
    //   202: putfield busy : I
    //   205: aload_3
    //   206: athrow
    //   207: iconst_0
    //   208: istore #7
    //   210: iload #8
    //   212: istore #4
    //   214: goto -> 400
    //   217: iload #8
    //   219: ifne -> 232
    //   222: iconst_1
    //   223: istore #4
    //   225: iload #6
    //   227: istore #7
    //   229: goto -> 400
    //   232: aload #11
    //   234: getfield value : J
    //   237: lstore #12
    //   239: aload #11
    //   241: lload #12
    //   243: aload_0
    //   244: lload #12
    //   246: lload_1
    //   247: invokevirtual fn : (JJ)J
    //   250: invokevirtual cas : (JJ)Z
    //   253: ifeq -> 259
    //   256: goto -> 561
    //   259: iload #10
    //   261: getstatic com/google/common/cache/Striped64.NCPU : I
    //   264: if_icmpge -> 393
    //   267: aload_0
    //   268: getfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   271: aload #5
    //   273: if_acmpeq -> 279
    //   276: goto -> 393
    //   279: iload #6
    //   281: ifne -> 294
    //   284: iconst_1
    //   285: istore #7
    //   287: iload #8
    //   289: istore #4
    //   291: goto -> 400
    //   294: iload #8
    //   296: istore #4
    //   298: iload #6
    //   300: istore #7
    //   302: aload_0
    //   303: getfield busy : I
    //   306: ifne -> 400
    //   309: iload #8
    //   311: istore #4
    //   313: iload #6
    //   315: istore #7
    //   317: aload_0
    //   318: invokevirtual casBusy : ()Z
    //   321: ifeq -> 400
    //   324: aload_0
    //   325: getfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   328: aload #5
    //   330: if_acmpne -> 374
    //   333: iload #10
    //   335: iconst_1
    //   336: ishl
    //   337: anewarray com/google/common/cache/Striped64$Cell
    //   340: astore #11
    //   342: iconst_0
    //   343: istore #7
    //   345: iload #7
    //   347: iload #10
    //   349: if_icmpge -> 368
    //   352: aload #11
    //   354: iload #7
    //   356: aload #5
    //   358: iload #7
    //   360: aaload
    //   361: aastore
    //   362: iinc #7, 1
    //   365: goto -> 345
    //   368: aload_0
    //   369: aload #11
    //   371: putfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   374: aload_0
    //   375: iconst_0
    //   376: putfield busy : I
    //   379: iconst_0
    //   380: istore #6
    //   382: goto -> 63
    //   385: astore_3
    //   386: aload_0
    //   387: iconst_0
    //   388: putfield busy : I
    //   391: aload_3
    //   392: athrow
    //   393: iconst_0
    //   394: istore #7
    //   396: iload #8
    //   398: istore #4
    //   400: iload #9
    //   402: iload #9
    //   404: bipush #13
    //   406: ishl
    //   407: ixor
    //   408: istore #6
    //   410: iload #6
    //   412: iload #6
    //   414: bipush #17
    //   416: iushr
    //   417: ixor
    //   418: istore #6
    //   420: iload #6
    //   422: iload #6
    //   424: iconst_5
    //   425: ishl
    //   426: ixor
    //   427: istore #9
    //   429: aload_3
    //   430: iconst_0
    //   431: iload #9
    //   433: iastore
    //   434: iload #4
    //   436: istore #8
    //   438: iload #7
    //   440: istore #6
    //   442: goto -> 63
    //   445: aload_0
    //   446: getfield busy : I
    //   449: ifne -> 539
    //   452: aload_0
    //   453: getfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   456: aload #5
    //   458: if_acmpne -> 539
    //   461: aload_0
    //   462: invokevirtual casBusy : ()Z
    //   465: ifeq -> 539
    //   468: aload_0
    //   469: getfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   472: aload #5
    //   474: if_acmpne -> 515
    //   477: iconst_2
    //   478: anewarray com/google/common/cache/Striped64$Cell
    //   481: astore #11
    //   483: new com/google/common/cache/Striped64$Cell
    //   486: astore #5
    //   488: aload #5
    //   490: lload_1
    //   491: invokespecial <init> : (J)V
    //   494: aload #11
    //   496: iload #9
    //   498: iconst_1
    //   499: iand
    //   500: aload #5
    //   502: aastore
    //   503: aload_0
    //   504: aload #11
    //   506: putfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   509: iconst_1
    //   510: istore #7
    //   512: goto -> 518
    //   515: iconst_0
    //   516: istore #7
    //   518: aload_0
    //   519: iconst_0
    //   520: putfield busy : I
    //   523: iload #7
    //   525: ifeq -> 63
    //   528: goto -> 561
    //   531: astore_3
    //   532: aload_0
    //   533: iconst_0
    //   534: putfield busy : I
    //   537: aload_3
    //   538: athrow
    //   539: aload_0
    //   540: getfield base : J
    //   543: lstore #12
    //   545: aload_0
    //   546: lload #12
    //   548: aload_0
    //   549: lload #12
    //   551: lload_1
    //   552: invokevirtual fn : (JJ)J
    //   555: invokevirtual casBase : (JJ)Z
    //   558: ifeq -> 63
    //   561: return
    // Exception table:
    //   from	to	target	type
    //   132	138	199	finally
    //   143	148	199	finally
    //   324	342	385	finally
    //   368	374	385	finally
    //   468	494	531	finally
    //   503	509	531	finally
  }
  
  static final class Cell {
    private static final Unsafe UNSAFE;
    
    private static final long valueOffset;
    
    volatile long p0;
    
    volatile long p1;
    
    volatile long p2;
    
    volatile long p3;
    
    volatile long p4;
    
    volatile long p5;
    
    volatile long p6;
    
    volatile long q0;
    
    volatile long q1;
    
    volatile long q2;
    
    volatile long q3;
    
    volatile long q4;
    
    volatile long q5;
    
    volatile long q6;
    
    volatile long value;
    
    static {
      try {
        UNSAFE = Striped64.getUnsafe();
        valueOffset = UNSAFE.objectFieldOffset(Cell.class.getDeclaredField("value"));
        return;
      } catch (Exception exception) {
        throw new Error(exception);
      } 
    }
    
    Cell(long param1Long) {
      this.value = param1Long;
    }
    
    final boolean cas(long param1Long1, long param1Long2) {
      return UNSAFE.compareAndSwapLong(this, valueOffset, param1Long1, param1Long2);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\Striped64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */