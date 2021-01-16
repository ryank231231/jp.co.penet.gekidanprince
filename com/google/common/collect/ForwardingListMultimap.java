package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
  protected abstract ListMultimap<K, V> delegate();
  
  public List<V> get(@Nullable K paramK) {
    return delegate().get(paramK);
  }
  
  @CanIgnoreReturnValue
  public List<V> removeAll(@Nullable Object paramObject) {
    return delegate().removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    return delegate().replaceValues(paramK, paramIterable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */