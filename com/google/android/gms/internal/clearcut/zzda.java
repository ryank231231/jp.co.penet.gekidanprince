package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.List;

final class zzda extends zzcy {
  private static final Class<?> zzlv = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzda() {
    super(null);
  }
  
  private static <E> List<E> zzb(Object paramObject, long paramLong) {
    return (List<E>)zzfd.zzo(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong) {
    List<?> list = (List)zzfd.zzo(paramObject, paramLong);
    if (list instanceof zzcx) {
      list = ((zzcx)list).zzbu();
    } else {
      if (zzlv.isAssignableFrom(list.getClass()))
        return; 
      list = Collections.unmodifiableList(list);
    } 
    zzfd.zza(paramObject, paramLong, list);
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong) {
    // Byte code:
    //   0: aload_2
    //   1: lload_3
    //   2: invokestatic zzb : (Ljava/lang/Object;J)Ljava/util/List;
    //   5: astore #5
    //   7: aload #5
    //   9: invokeinterface size : ()I
    //   14: istore #6
    //   16: aload_1
    //   17: lload_3
    //   18: invokestatic zzb : (Ljava/lang/Object;J)Ljava/util/List;
    //   21: astore #7
    //   23: aload #7
    //   25: invokeinterface isEmpty : ()Z
    //   30: ifeq -> 73
    //   33: aload #7
    //   35: instanceof com/google/android/gms/internal/clearcut/zzcx
    //   38: ifeq -> 54
    //   41: new com/google/android/gms/internal/clearcut/zzcw
    //   44: dup
    //   45: iload #6
    //   47: invokespecial <init> : (I)V
    //   50: astore_2
    //   51: goto -> 64
    //   54: new java/util/ArrayList
    //   57: dup
    //   58: iload #6
    //   60: invokespecial <init> : (I)V
    //   63: astore_2
    //   64: aload_1
    //   65: lload_3
    //   66: aload_2
    //   67: invokestatic zza : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   70: goto -> 163
    //   73: getstatic com/google/android/gms/internal/clearcut/zzda.zzlv : Ljava/lang/Class;
    //   76: aload #7
    //   78: invokevirtual getClass : ()Ljava/lang/Class;
    //   81: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   84: ifeq -> 121
    //   87: new java/util/ArrayList
    //   90: dup
    //   91: aload #7
    //   93: invokeinterface size : ()I
    //   98: iload #6
    //   100: iadd
    //   101: invokespecial <init> : (I)V
    //   104: astore_2
    //   105: aload_2
    //   106: aload #7
    //   108: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   111: pop
    //   112: aload_1
    //   113: lload_3
    //   114: aload_2
    //   115: invokestatic zza : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   118: goto -> 163
    //   121: aload #7
    //   123: astore_2
    //   124: aload #7
    //   126: instanceof com/google/android/gms/internal/clearcut/zzfa
    //   129: ifeq -> 163
    //   132: new com/google/android/gms/internal/clearcut/zzcw
    //   135: dup
    //   136: aload #7
    //   138: invokeinterface size : ()I
    //   143: iload #6
    //   145: iadd
    //   146: invokespecial <init> : (I)V
    //   149: astore_2
    //   150: aload_2
    //   151: aload #7
    //   153: checkcast com/google/android/gms/internal/clearcut/zzfa
    //   156: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   159: pop
    //   160: goto -> 112
    //   163: aload_2
    //   164: invokeinterface size : ()I
    //   169: istore #6
    //   171: aload #5
    //   173: invokeinterface size : ()I
    //   178: istore #8
    //   180: iload #6
    //   182: ifle -> 199
    //   185: iload #8
    //   187: ifle -> 199
    //   190: aload_2
    //   191: aload #5
    //   193: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   198: pop
    //   199: iload #6
    //   201: ifle -> 207
    //   204: aload_2
    //   205: astore #5
    //   207: aload_1
    //   208: lload_3
    //   209: aload #5
    //   211: invokestatic zza : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   214: return
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */