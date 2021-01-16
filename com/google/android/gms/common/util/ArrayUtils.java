package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@KeepForSdk
@VisibleForTesting
public final class ArrayUtils {
  @KeepForSdk
  public static <T> T[] appendToArray(T[] paramArrayOfT, T paramT) {
    if (paramArrayOfT != null || paramT != null) {
      if (paramArrayOfT == null) {
        paramArrayOfT = (T[])Array.newInstance(paramT.getClass(), 1);
      } else {
        paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length + 1);
      } 
      paramArrayOfT[paramArrayOfT.length - 1] = paramT;
      return paramArrayOfT;
    } 
    throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
  }
  
  @KeepForSdk
  public static <T> T[] concat(T[]... paramVarArgs) {
    if (paramVarArgs.length == 0)
      return (T[])Array.newInstance(paramVarArgs.getClass(), 0); 
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length) {
      j += (paramVarArgs[i]).length;
      i++;
    } 
    Object[] arrayOfObject = Arrays.copyOf((Object[])paramVarArgs[0], j);
    i = (paramVarArgs[0]).length;
    for (j = 1; j < paramVarArgs.length; j++) {
      T[] arrayOfT = paramVarArgs[j];
      System.arraycopy(arrayOfT, 0, arrayOfObject, i, arrayOfT.length);
      i += arrayOfT.length;
    } 
    return (T[])arrayOfObject;
  }
  
  @KeepForSdk
  public static byte[] concatByteArrays(byte[]... paramVarArgs) {
    if (paramVarArgs.length == 0)
      return new byte[0]; 
    byte b = 0;
    int i = 0;
    while (b < paramVarArgs.length) {
      i += (paramVarArgs[b]).length;
      b++;
    } 
    byte[] arrayOfByte = Arrays.copyOf(paramVarArgs[0], i);
    i = (paramVarArgs[0]).length;
    for (b = 1; b < paramVarArgs.length; b++) {
      byte[] arrayOfByte1 = paramVarArgs[b];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, arrayOfByte1.length);
      i += arrayOfByte1.length;
    } 
    return arrayOfByte;
  }
  
  @KeepForSdk
  public static boolean contains(int[] paramArrayOfint, int paramInt) {
    if (paramArrayOfint == null)
      return false; 
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i; b++) {
      if (paramArrayOfint[b] == paramInt)
        return true; 
    } 
    return false;
  }
  
  @KeepForSdk
  public static <T> boolean contains(T[] paramArrayOfT, T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 10
    //   4: aload_0
    //   5: arraylength
    //   6: istore_2
    //   7: goto -> 12
    //   10: iconst_0
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_3
    //   14: iload_3
    //   15: iload_2
    //   16: if_icmpge -> 38
    //   19: aload_0
    //   20: iload_3
    //   21: aaload
    //   22: aload_1
    //   23: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   26: ifeq -> 32
    //   29: goto -> 40
    //   32: iinc #3, 1
    //   35: goto -> 14
    //   38: iconst_m1
    //   39: istore_3
    //   40: iload_3
    //   41: iflt -> 46
    //   44: iconst_1
    //   45: ireturn
    //   46: iconst_0
    //   47: ireturn
  }
  
  @KeepForSdk
  public static <T> ArrayList<T> newArrayList() {
    return new ArrayList<T>();
  }
  
  @KeepForSdk
  public static <T> T[] removeAll(T[] paramArrayOfT1, T... paramVarArgs1) {
    int j;
    if (paramArrayOfT1 == null)
      return null; 
    if (paramVarArgs1 == null || paramVarArgs1.length == 0)
      return Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length); 
    Object[] arrayOfObject = (Object[])Array.newInstance(paramVarArgs1.getClass().getComponentType(), paramArrayOfT1.length);
    int i = paramVarArgs1.length;
    byte b = 0;
    if (i == 1) {
      int k = paramArrayOfT1.length;
      b = 0;
      i = 0;
      while (true) {
        j = i;
        if (b < k) {
          T t = paramArrayOfT1[b];
          j = i;
          if (!Objects.equal(paramVarArgs1[0], t)) {
            arrayOfObject[i] = t;
            j = i + 1;
          } 
          b++;
          i = j;
          continue;
        } 
        break;
      } 
    } else {
      int k = paramArrayOfT1.length;
      i = 0;
      while (true) {
        j = i;
        if (b < k) {
          T t = paramArrayOfT1[b];
          j = i;
          if (!contains(paramVarArgs1, t)) {
            arrayOfObject[i] = t;
            j = i + 1;
          } 
          b++;
          i = j;
          continue;
        } 
        break;
      } 
    } 
    if (arrayOfObject == null)
      return null; 
    paramArrayOfT1 = (T[])arrayOfObject;
    if (j != arrayOfObject.length)
      paramArrayOfT1 = Arrays.copyOf((T[])arrayOfObject, j); 
    return paramArrayOfT1;
  }
  
  @KeepForSdk
  public static <T> ArrayList<T> toArrayList(T[] paramArrayOfT) {
    int i = paramArrayOfT.length;
    ArrayList<T> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++)
      arrayList.add(paramArrayOfT[b]); 
    return arrayList;
  }
  
  @KeepForSdk
  public static int[] toPrimitiveArray(Collection<Integer> paramCollection) {
    byte b = 0;
    if (paramCollection == null || paramCollection.size() == 0)
      return new int[0]; 
    int[] arrayOfInt = new int[paramCollection.size()];
    Iterator<Integer> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      arrayOfInt[b] = ((Integer)iterator.next()).intValue();
      b++;
    } 
    return arrayOfInt;
  }
  
  @KeepForSdk
  public static Integer[] toWrapperArray(int[] paramArrayOfint) {
    if (paramArrayOfint == null)
      return null; 
    int i = paramArrayOfint.length;
    Integer[] arrayOfInteger = new Integer[i];
    for (byte b = 0; b < i; b++)
      arrayOfInteger[b] = Integer.valueOf(paramArrayOfint[b]); 
    return arrayOfInteger;
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, double[] paramArrayOfdouble) {
    int i = paramArrayOfdouble.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Double.toString(paramArrayOfdouble[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, float[] paramArrayOffloat) {
    int i = paramArrayOffloat.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Float.toString(paramArrayOffloat[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Integer.toString(paramArrayOfint[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, long[] paramArrayOflong) {
    int i = paramArrayOflong.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Long.toString(paramArrayOflong[b]));
    } 
  }
  
  @KeepForSdk
  public static <T> void writeArray(StringBuilder paramStringBuilder, T[] paramArrayOfT) {
    int i = paramArrayOfT.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(paramArrayOfT[b].toString());
    } 
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, boolean[] paramArrayOfboolean) {
    int i = paramArrayOfboolean.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Boolean.toString(paramArrayOfboolean[b]));
    } 
  }
  
  @KeepForSdk
  public static void writeStringArray(StringBuilder paramStringBuilder, String[] paramArrayOfString) {
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      if (b != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramArrayOfString[b]);
      paramStringBuilder.append("\"");
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */