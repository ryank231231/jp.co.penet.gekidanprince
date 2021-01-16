package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

public class LruCache implements Cache {
  private int evictionCount;
  
  private int hitCount;
  
  final LinkedHashMap<String, Bitmap> map;
  
  private final int maxSize;
  
  private int missCount;
  
  private int putCount;
  
  private int size;
  
  public LruCache(int paramInt) {
    if (paramInt > 0) {
      this.maxSize = paramInt;
      this.map = new LinkedHashMap<String, Bitmap>(0, 0.75F, true);
      return;
    } 
    throw new IllegalArgumentException("Max size must be positive.");
  }
  
  public LruCache(Context paramContext) {
    this(Utils.calculateMemoryCacheSize(paramContext));
  }
  
  private void trimToSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield size : I
    //   6: iflt -> 128
    //   9: aload_0
    //   10: getfield map : Ljava/util/LinkedHashMap;
    //   13: invokevirtual isEmpty : ()Z
    //   16: ifeq -> 26
    //   19: aload_0
    //   20: getfield size : I
    //   23: ifne -> 128
    //   26: aload_0
    //   27: getfield size : I
    //   30: iload_1
    //   31: if_icmple -> 125
    //   34: aload_0
    //   35: getfield map : Ljava/util/LinkedHashMap;
    //   38: invokevirtual isEmpty : ()Z
    //   41: ifeq -> 47
    //   44: goto -> 125
    //   47: aload_0
    //   48: getfield map : Ljava/util/LinkedHashMap;
    //   51: invokevirtual entrySet : ()Ljava/util/Set;
    //   54: invokeinterface iterator : ()Ljava/util/Iterator;
    //   59: invokeinterface next : ()Ljava/lang/Object;
    //   64: checkcast java/util/Map$Entry
    //   67: astore_2
    //   68: aload_2
    //   69: invokeinterface getKey : ()Ljava/lang/Object;
    //   74: checkcast java/lang/String
    //   77: astore_3
    //   78: aload_2
    //   79: invokeinterface getValue : ()Ljava/lang/Object;
    //   84: checkcast android/graphics/Bitmap
    //   87: astore_2
    //   88: aload_0
    //   89: getfield map : Ljava/util/LinkedHashMap;
    //   92: aload_3
    //   93: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: aload_0
    //   98: aload_0
    //   99: getfield size : I
    //   102: aload_2
    //   103: invokestatic getBitmapBytes : (Landroid/graphics/Bitmap;)I
    //   106: isub
    //   107: putfield size : I
    //   110: aload_0
    //   111: aload_0
    //   112: getfield evictionCount : I
    //   115: iconst_1
    //   116: iadd
    //   117: putfield evictionCount : I
    //   120: aload_0
    //   121: monitorexit
    //   122: goto -> 0
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: new java/lang/IllegalStateException
    //   131: astore_2
    //   132: new java/lang/StringBuilder
    //   135: astore_3
    //   136: aload_3
    //   137: invokespecial <init> : ()V
    //   140: aload_3
    //   141: aload_0
    //   142: invokevirtual getClass : ()Ljava/lang/Class;
    //   145: invokevirtual getName : ()Ljava/lang/String;
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_3
    //   153: ldc '.sizeOf() is reporting inconsistent results!'
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_2
    //   160: aload_3
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: invokespecial <init> : (Ljava/lang/String;)V
    //   167: aload_2
    //   168: athrow
    //   169: astore_3
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_3
    //   173: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	169	finally
    //   26	44	169	finally
    //   47	122	169	finally
    //   125	127	169	finally
    //   128	169	169	finally
    //   170	172	169	finally
  }
  
  public final void clear() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual evictAll : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	9	finally
  }
  
  public final void clearKeyUri(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual length : ()I
    //   6: istore_2
    //   7: aload_0
    //   8: getfield map : Ljava/util/LinkedHashMap;
    //   11: invokevirtual entrySet : ()Ljava/util/Set;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_3
    //   20: iconst_0
    //   21: istore #4
    //   23: aload_3
    //   24: invokeinterface hasNext : ()Z
    //   29: ifeq -> 123
    //   32: aload_3
    //   33: invokeinterface next : ()Ljava/lang/Object;
    //   38: checkcast java/util/Map$Entry
    //   41: astore #5
    //   43: aload #5
    //   45: invokeinterface getKey : ()Ljava/lang/Object;
    //   50: checkcast java/lang/String
    //   53: astore #6
    //   55: aload #5
    //   57: invokeinterface getValue : ()Ljava/lang/Object;
    //   62: checkcast android/graphics/Bitmap
    //   65: astore #5
    //   67: aload #6
    //   69: bipush #10
    //   71: invokevirtual indexOf : (I)I
    //   74: istore #7
    //   76: iload #7
    //   78: iload_2
    //   79: if_icmpne -> 23
    //   82: aload #6
    //   84: iconst_0
    //   85: iload #7
    //   87: invokevirtual substring : (II)Ljava/lang/String;
    //   90: aload_1
    //   91: invokevirtual equals : (Ljava/lang/Object;)Z
    //   94: ifeq -> 23
    //   97: aload_3
    //   98: invokeinterface remove : ()V
    //   103: aload_0
    //   104: aload_0
    //   105: getfield size : I
    //   108: aload #5
    //   110: invokestatic getBitmapBytes : (Landroid/graphics/Bitmap;)I
    //   113: isub
    //   114: putfield size : I
    //   117: iconst_1
    //   118: istore #4
    //   120: goto -> 23
    //   123: iload #4
    //   125: ifeq -> 136
    //   128: aload_0
    //   129: aload_0
    //   130: getfield maxSize : I
    //   133: invokespecial trimToSize : (I)V
    //   136: aload_0
    //   137: monitorexit
    //   138: return
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	139	finally
    //   23	76	139	finally
    //   82	117	139	finally
    //   128	136	139	finally
  }
  
  public final void evictAll() {
    trimToSize(-1);
  }
  
  public final int evictionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield evictionCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public Bitmap get(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 55
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield map : Ljava/util/LinkedHashMap;
    //   10: aload_1
    //   11: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast android/graphics/Bitmap
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull -> 36
    //   22: aload_0
    //   23: aload_0
    //   24: getfield hitCount : I
    //   27: iconst_1
    //   28: iadd
    //   29: putfield hitCount : I
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: aload_0
    //   38: getfield missCount : I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield missCount : I
    //   46: aload_0
    //   47: monitorexit
    //   48: aconst_null
    //   49: areturn
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: new java/lang/NullPointerException
    //   58: dup
    //   59: ldc 'key == null'
    //   61: invokespecial <init> : (Ljava/lang/String;)V
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   6	18	50	finally
    //   22	34	50	finally
    //   36	48	50	finally
    //   51	53	50	finally
  }
  
  public final int hitCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield hitCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final int maxSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxSize : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final int missCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield missCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final int putCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield putCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void set(String paramString, Bitmap paramBitmap) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 79
    //   4: aload_2
    //   5: ifnull -> 79
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: aload_0
    //   12: getfield putCount : I
    //   15: iconst_1
    //   16: iadd
    //   17: putfield putCount : I
    //   20: aload_0
    //   21: aload_0
    //   22: getfield size : I
    //   25: aload_2
    //   26: invokestatic getBitmapBytes : (Landroid/graphics/Bitmap;)I
    //   29: iadd
    //   30: putfield size : I
    //   33: aload_0
    //   34: getfield map : Ljava/util/LinkedHashMap;
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast android/graphics/Bitmap
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -> 63
    //   50: aload_0
    //   51: aload_0
    //   52: getfield size : I
    //   55: aload_1
    //   56: invokestatic getBitmapBytes : (Landroid/graphics/Bitmap;)I
    //   59: isub
    //   60: putfield size : I
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: aload_0
    //   67: getfield maxSize : I
    //   70: invokespecial trimToSize : (I)V
    //   73: return
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: new java/lang/NullPointerException
    //   82: dup
    //   83: ldc 'key == null || bitmap == null'
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   10	46	74	finally
    //   50	63	74	finally
    //   63	65	74	finally
    //   75	77	74	finally
  }
  
  public final int size() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield size : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */