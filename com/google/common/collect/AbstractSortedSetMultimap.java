package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements SortedSetMultimap<K, V> {
  private static final long serialVersionUID = 430848587173315748L;
  
  protected AbstractSortedSetMultimap(Map<K, Collection<V>> paramMap) {
    super(paramMap);
  }
  
  public Map<K, Collection<V>> asMap() {
    return super.asMap();
  }
  
  abstract SortedSet<V> createCollection();
  
  SortedSet<V> createUnmodifiableEmptyCollection() {
    return (valueComparator() == null) ? Collections.unmodifiableSortedSet(createCollection()) : ImmutableSortedSet.emptySet(valueComparator());
  }
  
  public SortedSet<V> get(@Nullable K paramK) {
    return (SortedSet<V>)super.get(paramK);
  }
  
  @CanIgnoreReturnValue
  public SortedSet<V> removeAll(@Nullable Object paramObject) {
    return (SortedSet<V>)super.removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public SortedSet<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable) {
    return (SortedSet<V>)super.replaceValues(paramK, paramIterable);
  }
  
  public Collection<V> values() {
    return super.values();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\AbstractSortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */