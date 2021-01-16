package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtIncompatible
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
  private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
  
  private final ImmutableMap<Class<? extends B>, B> delegate;
  
  private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> paramImmutableMap) {
    this.delegate = paramImmutableMap;
  }
  
  public static <B> Builder<B> builder() {
    return new Builder<B>();
  }
  
  public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> paramMap) {
    return (paramMap instanceof ImmutableClassToInstanceMap) ? (ImmutableClassToInstanceMap)paramMap : (new Builder<B>()).<S>putAll(paramMap).build();
  }
  
  public static <B> ImmutableClassToInstanceMap<B> of() {
    return (ImmutableClassToInstanceMap)EMPTY;
  }
  
  public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> paramClass, T paramT) {
    return new ImmutableClassToInstanceMap<B>(ImmutableMap.of(paramClass, (B)paramT));
  }
  
  protected Map<Class<? extends B>, B> delegate() {
    return this.delegate;
  }
  
  @Nullable
  public <T extends B> T getInstance(Class<T> paramClass) {
    return (T)this.delegate.get(Preconditions.checkNotNull(paramClass));
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT) {
    throw new UnsupportedOperationException();
  }
  
  Object readResolve() {
    ImmutableClassToInstanceMap immutableClassToInstanceMap;
    if (isEmpty()) {
      immutableClassToInstanceMap = of();
    } else {
      immutableClassToInstanceMap = this;
    } 
    return immutableClassToInstanceMap;
  }
  
  public static final class Builder<B> {
    private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();
    
    private static <B, T extends B> T cast(Class<T> param1Class, B param1B) {
      return Primitives.wrap(param1Class).cast(param1B);
    }
    
    public ImmutableClassToInstanceMap<B> build() {
      ImmutableMap<Class<? extends B>, B> immutableMap = this.mapBuilder.build();
      return immutableMap.isEmpty() ? ImmutableClassToInstanceMap.of() : new ImmutableClassToInstanceMap<B>(immutableMap);
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> put(Class<T> param1Class, T param1T) {
      this.mapBuilder.put(param1Class, (B)param1T);
      return this;
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> param1Map) {
      for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : param1Map.entrySet()) {
        Class<? extends B> clazz = (Class)entry.getKey();
        entry = (Map.Entry<? extends Class<? extends T>, ? extends T>)entry.getValue();
        this.mapBuilder.put(clazz, cast((Class)clazz, entry));
      } 
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */