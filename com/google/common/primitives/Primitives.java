package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@GwtIncompatible
public final class Primitives {
  private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
  
  private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;
  
  static {
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(16);
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>(16);
    add((Map)hashMap1, (Map)hashMap2, boolean.class, Boolean.class);
    add((Map)hashMap1, (Map)hashMap2, byte.class, Byte.class);
    add((Map)hashMap1, (Map)hashMap2, char.class, Character.class);
    add((Map)hashMap1, (Map)hashMap2, double.class, Double.class);
    add((Map)hashMap1, (Map)hashMap2, float.class, Float.class);
    add((Map)hashMap1, (Map)hashMap2, int.class, Integer.class);
    add((Map)hashMap1, (Map)hashMap2, long.class, Long.class);
    add((Map)hashMap1, (Map)hashMap2, short.class, Short.class);
    add((Map)hashMap1, (Map)hashMap2, void.class, Void.class);
    PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(hashMap1);
    WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(hashMap2);
  }
  
  private static void add(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2) {
    paramMap1.put(paramClass1, paramClass2);
    paramMap2.put(paramClass2, paramClass1);
  }
  
  public static Set<Class<?>> allPrimitiveTypes() {
    return PRIMITIVE_TO_WRAPPER_TYPE.keySet();
  }
  
  public static Set<Class<?>> allWrapperTypes() {
    return WRAPPER_TO_PRIMITIVE_TYPE.keySet();
  }
  
  public static boolean isWrapperType(Class<?> paramClass) {
    return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(Preconditions.checkNotNull(paramClass));
  }
  
  public static <T> Class<T> unwrap(Class<T> paramClass) {
    Preconditions.checkNotNull(paramClass);
    Class<T> clazz = (Class)WRAPPER_TO_PRIMITIVE_TYPE.get(paramClass);
    if (clazz != null)
      paramClass = clazz; 
    return paramClass;
  }
  
  public static <T> Class<T> wrap(Class<T> paramClass) {
    Preconditions.checkNotNull(paramClass);
    Class<T> clazz = (Class)PRIMITIVE_TO_WRAPPER_TYPE.get(paramClass);
    if (clazz != null)
      paramClass = clazz; 
    return paramClass;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\primitives\Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */