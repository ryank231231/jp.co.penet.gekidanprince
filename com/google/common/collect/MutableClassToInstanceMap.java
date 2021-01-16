package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@GwtIncompatible
public final class MutableClassToInstanceMap<B> extends MapConstraints.ConstrainedMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
  private static final MapConstraint<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY = new MapConstraint<Class<?>, Object>() {
      public void checkKeyValue(Class<?> param1Class, Object param1Object) {
        MutableClassToInstanceMap.cast((Class)param1Class, (B)param1Object);
      }
    };
  
  private MutableClassToInstanceMap(Map<Class<? extends B>, B> paramMap) {
    super(paramMap, (MapConstraint)VALUE_CAN_BE_CAST_TO_KEY);
  }
  
  @CanIgnoreReturnValue
  private static <B, T extends B> T cast(Class<T> paramClass, B paramB) {
    return Primitives.wrap(paramClass).cast(paramB);
  }
  
  public static <B> MutableClassToInstanceMap<B> create() {
    return new MutableClassToInstanceMap<B>(new HashMap<Class<? extends B>, B>());
  }
  
  public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> paramMap) {
    return new MutableClassToInstanceMap<B>(paramMap);
  }
  
  private Object writeReplace() {
    return new SerializedForm<B>(delegate());
  }
  
  public <T extends B> T getInstance(Class<T> paramClass) {
    return cast(paramClass, get(paramClass));
  }
  
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT) {
    return cast(paramClass, put(paramClass, (B)paramT));
  }
  
  private static final class SerializedForm<B> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Map<Class<? extends B>, B> backingMap;
    
    SerializedForm(Map<Class<? extends B>, B> param1Map) {
      this.backingMap = param1Map;
    }
    
    Object readResolve() {
      return MutableClassToInstanceMap.create(this.backingMap);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */