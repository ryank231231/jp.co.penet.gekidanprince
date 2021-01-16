package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtIncompatible
public final class Defaults {
  private static final Map<Class<?>, Object> DEFAULTS;
  
  static {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    put((Map)hashMap, boolean.class, Boolean.valueOf(false));
    put((Map)hashMap, char.class, Character.valueOf(false));
    put((Map)hashMap, byte.class, Byte.valueOf((byte)0));
    put((Map)hashMap, short.class, Short.valueOf((short)0));
    put((Map)hashMap, int.class, Integer.valueOf(0));
    put((Map)hashMap, long.class, Long.valueOf(0L));
    put((Map)hashMap, float.class, Float.valueOf(0.0F));
    put((Map)hashMap, double.class, Double.valueOf(0.0D));
    DEFAULTS = Collections.unmodifiableMap(hashMap);
  }
  
  @Nullable
  public static <T> T defaultValue(Class<T> paramClass) {
    return (T)DEFAULTS.get(Preconditions.checkNotNull(paramClass));
  }
  
  private static <T> void put(Map<Class<?>, Object> paramMap, Class<T> paramClass, T paramT) {
    paramMap.put(paramClass, paramT);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Defaults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */