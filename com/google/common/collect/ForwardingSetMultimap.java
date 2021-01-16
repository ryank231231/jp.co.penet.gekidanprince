package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSetMultimap<K, V> extends ForwardingMultimap<K, V> implements SetMultimap<K, V> {
  protected abstract SetMultimap<K, V> delegate();
  
  public Set<Map.Entry<K, V>> entries() {
    return delegate().entries();
  }
  
  public Set<V> get(@Nullable K paramK) {
    return delegate().get(paramK);
  }
  
  @CanIgnoreReturnValue
  public Set<V> removeAll(@Nullable Object paramObject) {
    return delegate().removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    return delegate().replaceValues(paramK, paramIterable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */