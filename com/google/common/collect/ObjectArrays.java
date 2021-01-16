package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class ObjectArrays {
  static final Object[] EMPTY_ARRAY = new Object[0];
  
  static <T> T[] arraysCopyOf(T[] paramArrayOfT, int paramInt) {
    Object[] arrayOfObject = newArray((Object[])paramArrayOfT, paramInt);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, Math.min(paramArrayOfT.length, paramInt));
    return (T[])arrayOfObject;
  }
  
  @CanIgnoreReturnValue
  static Object checkElementNotNull(Object paramObject, int paramInt) {
    if (paramObject != null)
      return paramObject; 
    paramObject = new StringBuilder();
    paramObject.append("at index ");
    paramObject.append(paramInt);
    throw new NullPointerException(paramObject.toString());
  }
  
  @CanIgnoreReturnValue
  static Object[] checkElementsNotNull(Object... paramVarArgs) {
    return checkElementsNotNull(paramVarArgs, paramVarArgs.length);
  }
  
  @CanIgnoreReturnValue
  static Object[] checkElementsNotNull(Object[] paramArrayOfObject, int paramInt) {
    for (byte b = 0; b < paramInt; b++)
      checkElementNotNull(paramArrayOfObject[b], b); 
    return paramArrayOfObject;
  }
  
  public static <T> T[] concat(@Nullable T paramT, T[] paramArrayOfT) {
    Object[] arrayOfObject = newArray((Object[])paramArrayOfT, paramArrayOfT.length + 1);
    arrayOfObject[0] = paramT;
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, paramArrayOfT.length);
    return (T[])arrayOfObject;
  }
  
  public static <T> T[] concat(T[] paramArrayOfT, @Nullable T paramT) {
    Object[] arrayOfObject = arraysCopyOf((Object[])paramArrayOfT, paramArrayOfT.length + 1);
    arrayOfObject[paramArrayOfT.length] = paramT;
    return (T[])arrayOfObject;
  }
  
  @GwtIncompatible
  public static <T> T[] concat(T[] paramArrayOfT1, T[] paramArrayOfT2, Class<T> paramClass) {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: arraylength
    //   3: aload_1
    //   4: arraylength
    //   5: iadd
    //   6: invokestatic newArray : (Ljava/lang/Class;I)[Ljava/lang/Object;
    //   9: astore_2
    //   10: aload_0
    //   11: iconst_0
    //   12: aload_2
    //   13: iconst_0
    //   14: aload_0
    //   15: arraylength
    //   16: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   19: aload_1
    //   20: iconst_0
    //   21: aload_2
    //   22: aload_0
    //   23: arraylength
    //   24: aload_1
    //   25: arraylength
    //   26: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   29: aload_2
    //   30: areturn
  }
  
  static Object[] copyAsObjectArray(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
    if (paramInt2 == 0)
      return EMPTY_ARRAY; 
    Object[] arrayOfObject = new Object[paramInt2];
    System.arraycopy(paramArrayOfObject, paramInt1, arrayOfObject, 0, paramInt2);
    return arrayOfObject;
  }
  
  @CanIgnoreReturnValue
  private static Object[] fillArray(Iterable<?> paramIterable, Object[] paramArrayOfObject) {
    Iterator<?> iterator = paramIterable.iterator();
    for (byte b = 0; iterator.hasNext(); b++)
      paramArrayOfObject[b] = iterator.next(); 
    return paramArrayOfObject;
  }
  
  @GwtIncompatible
  public static <T> T[] newArray(Class<T> paramClass, int paramInt) {
    return (T[])Array.newInstance(paramClass, paramInt);
  }
  
  public static <T> T[] newArray(T[] paramArrayOfT, int paramInt) {
    return Platform.newArray(paramArrayOfT, paramInt);
  }
  
  static void swap(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
    Object object = paramArrayOfObject[paramInt1];
    paramArrayOfObject[paramInt1] = paramArrayOfObject[paramInt2];
    paramArrayOfObject[paramInt2] = object;
  }
  
  static Object[] toArrayImpl(Collection<?> paramCollection) {
    return fillArray(paramCollection, new Object[paramCollection.size()]);
  }
  
  static <T> T[] toArrayImpl(Collection<?> paramCollection, T[] paramArrayOfT) {
    int i = paramCollection.size();
    T[] arrayOfT = paramArrayOfT;
    if (paramArrayOfT.length < i)
      arrayOfT = newArray(paramArrayOfT, i); 
    fillArray(paramCollection, (Object[])arrayOfT);
    if (arrayOfT.length > i)
      arrayOfT[i] = null; 
    return arrayOfT;
  }
  
  static <T> T[] toArrayImpl(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT) {
    T[] arrayOfT;
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
    if (paramArrayOfT.length < paramInt2) {
      Object[] arrayOfObject = newArray((Object[])paramArrayOfT, paramInt2);
    } else {
      arrayOfT = paramArrayOfT;
      if (paramArrayOfT.length > paramInt2) {
        paramArrayOfT[paramInt2] = null;
        arrayOfT = paramArrayOfT;
      } 
    } 
    System.arraycopy(paramArrayOfObject, paramInt1, arrayOfT, 0, paramInt2);
    return arrayOfT;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ObjectArrays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */