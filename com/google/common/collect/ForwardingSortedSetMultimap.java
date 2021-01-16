package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
  protected abstract SortedSetMultimap<K, V> delegate();
  
  public SortedSet<V> get(@Nullable K paramK) {
    return delegate().get(paramK);
  }
  
  public SortedSet<V> removeAll(@Nullable Object paramObject) {
    return delegate().removeAll(paramObject);
  }
  
  public SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable) {
    return delegate().replaceValues(paramK, paramIterable);
  }
  
  public Comparator<? super V> valueComparator() {
    return delegate().valueComparator();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ForwardingSortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */