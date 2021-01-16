package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Enums {
  @GwtIncompatible
  private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = new WeakHashMap<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>>();
  
  @GwtIncompatible
  static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> paramClass) {
    synchronized (enumConstantCache) {
      Map<String, WeakReference<? extends Enum<?>>> map1 = enumConstantCache.get(paramClass);
      Map<String, WeakReference<? extends Enum<?>>> map2 = map1;
      if (map1 == null)
        map2 = populateCache(paramClass); 
      return map2;
    } 
  }
  
  @GwtIncompatible
  public static Field getField(Enum<?> paramEnum) {
    Class<?> clazz = paramEnum.getDeclaringClass();
    try {
      return clazz.getDeclaredField(paramEnum.name());
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new AssertionError(noSuchFieldException);
    } 
  }
  
  public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> paramClass, String paramString) {
    Preconditions.checkNotNull(paramClass);
    Preconditions.checkNotNull(paramString);
    return Platform.getEnumIfPresent(paramClass, paramString);
  }
  
  @GwtIncompatible
  private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> paramClass) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Enum enum_ : EnumSet.<T>allOf(paramClass))
      hashMap.put(enum_.name(), new WeakReference<Enum>(enum_)); 
    enumConstantCache.put(paramClass, hashMap);
    return (Map)hashMap;
  }
  
  public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> paramClass) {
    return new StringConverter<T>(paramClass);
  }
  
  private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Class<T> enumClass;
    
    StringConverter(Class<T> param1Class) {
      this.enumClass = Preconditions.<Class<T>>checkNotNull(param1Class);
    }
    
    protected String doBackward(T param1T) {
      return param1T.name();
    }
    
    protected T doForward(String param1String) {
      return Enum.valueOf(this.enumClass, param1String);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof StringConverter) {
        param1Object = param1Object;
        return this.enumClass.equals(((StringConverter)param1Object).enumClass);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.enumClass.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Enums.stringConverter(");
      stringBuilder.append(this.enumClass.getName());
      stringBuilder.append(".class)");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Enums.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */