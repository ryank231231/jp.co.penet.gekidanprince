package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
  protected abstract ConcurrentMap<K, V> delegate();
  
  @CanIgnoreReturnValue
  public V putIfAbsent(K paramK, V paramV) {
    return delegate().putIfAbsent(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject1, Object paramObject2) {
    return delegate().remove(paramObject1, paramObject2);
  }
  
  @CanIgnoreReturnValue
  public V replace(K paramK, V paramV) {
    return delegate().replace(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean replace(K paramK, V paramV1, V paramV2) {
    return delegate().replace(paramK, paramV1, paramV2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingConcurrentMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */